from flask import Flask, render_template, request, redirect, url_for, flash
import mysql.connector
import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
from datetime import datetime, timedelta

app = Flask(__name__)
app.secret_key = "bloodlink123"

# 🔹 Database Connection
db = mysql.connector.connect(
    host="localhost",
    user="root",
    password="your_password",     # change this
    database="bloodlink"
)
cursor = db.cursor(dictionary=True)

# ----------------------------------------
# 🏠 Home Route
# ----------------------------------------
@app.route('/')
def home():
    return render_template('index.html')


# ----------------------------------------
# 🩸 Donor Registration
# ----------------------------------------
@app.route('/register', methods=['GET', 'POST'])
def register():
    if request.method == 'POST':
        name = request.form['name'].strip()
        age = int(request.form['age'])
        gender = request.form['gender']
        weight = float(request.form['weight'])
        blood_group = request.form['blood_group']
        city = request.form['city'].strip()
        disease_history = request.form['disease_history'].strip().lower()
        medicines = request.form['medicines'].strip().lower()
        last_donation = request.form['last_donation']

        # 🧠 Smart Validation Rules
        if age < 18:
            flash("❌ You must be at least 18 years old to donate blood.", "danger")
            return redirect(url_for('register'))

        if weight < 50:
            flash("❌ Minimum weight for donation is 50 kg.", "danger")
            return redirect(url_for('register'))

        if disease_history != "none" and disease_history != "":
            flash("⚠️ You are currently not eligible due to recent illness (last 3 months).", "warning")
            return redirect(url_for('register'))

        if medicines != "none" and medicines != "":
            flash("⚠️ Active medication detected. Please consult doctor before donating.", "warning")
            return redirect(url_for('register'))

        # ✅ If passed all checks, insert donor record
        cursor.execute("""
            INSERT INTO donors 
            (name, age, gender, weight, blood_group, disease_history, medicines, city, last_donation)
            VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s)
        """, (name, age, gender, weight, blood_group, disease_history, medicines, city, last_donation))
        db.commit()

        flash("✅ Registration Successful! You are eligible to donate blood.", "success")
        return redirect(url_for('home'))

    return render_template('register.html')


# ----------------------------------------
# 📍 Show Blood Camps
# ----------------------------------------
@app.route('/camps')
def camps():
    cursor.execute("SELECT * FROM camps ORDER BY date ASC")
    camps = cursor.fetchall()
    return render_template('camps.html', camps=camps)


# ----------------------------------------
# 📧 Email Reminder Function
# ----------------------------------------
def send_email(to_email, name, camp_name, camp_address, camp_date, maps_link):
    sender_email = "youremail@gmail.com"   # change this
    sender_password = "your_app_password"  # use App Password (for Gmail)

    subject = "⏰ Blood Donation Reminder"
    
    html_content = render_template(
        'email_template.html',
        name=name,
        camp_name=camp_name,
        camp_address=camp_address,
        camp_date=camp_date,
        maps_link=maps_link
    )

    msg = MIMEMultipart('alternative')
    msg['Subject'] = subject
    msg['From'] = sender_email
    msg['To'] = to_email

    msg.attach(MIMEText(html_content, 'html'))

    try:
        server = smtplib.SMTP('smtp.gmail.com', 587)
        server.starttls()
        server.login(sender_email, sender_password)
        server.sendmail(sender_email, to_email, msg.as_string())
        server.quit()
        print(f"✅ Email sent to {to_email}")
    except Exception as e:
        print("❌ Error sending email:", e)


# ----------------------------------------
# 🕒 Check Eligible Donors and Send Reminder
# ----------------------------------------
@app.route('/send_reminders')
def send_reminders():
    today = datetime.now().date()
    eligible_date = today - timedelta(days=90)  # after 90 days

    cursor.execute("SELECT * FROM donors WHERE last_donation <= %s", (eligible_date,))
    donors = cursor.fetchall()

    for donor in donors:
        # find nearest camp by city
        cursor.execute("SELECT * FROM camps WHERE city = %s ORDER BY date ASC LIMIT 1", (donor['city'],))
        camp = cursor.fetchone()

        if camp:
            maps_link = f"https://www.google.com/maps/search/?api=1&query={camp['latitude']},{camp['longitude']}"
            send_email(
                to_email="recipient@gmail.com",  # use donor email if stored
                name=donor['name'],
                camp_name=camp['name'],
                camp_address=camp['address'],
                camp_date=camp['date'],
                maps_link=maps_link
            )

    return "Reminder emails sent!"


# ----------------------------------------
# ℹ️ About Page
# ----------------------------------------
@app.route('/about')
def about():
    return render_template('about.html')


# ----------------------------------------
# Run the Flask app
# ----------------------------------------
if __name__ == '__main__':
    app.run(debug=True)
