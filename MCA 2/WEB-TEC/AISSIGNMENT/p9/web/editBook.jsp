<%-- 
    Document   : editBook
    Created on : 14 Mar, 2026, 9:50:34 PM
    Author     : Infinity
--%>

<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Edit Book</title>

        <style>
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: #f4f7f6;
                display: flex;
                flex-direction: column;
                align-items: center;
                padding: 40px;
                color: #333;
            }

            h2 {
                color: #2c3e50;
                margin-bottom: 20px;
            }

            form {
                background: #ffffff;
                padding: 30px;
                border-radius: 8px;
                box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
                width: 100%;
                max-width: 400px;
            }

            form br {
                display: none; 
            }

            form {
                display: flex;
                flex-direction: column;
            }

            input[type="text"],
            input[type="number"] {
                width: 100%;
                padding: 10px;
                margin: 8px 0 20px 0;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box; 
                font-size: 14px;
            }

            input:focus {
                border-color: #3498db;
                outline: none;
                box-shadow: 0 0 5px rgba(52, 152, 219, 0.3);
            }


            input[type="submit"], 
            button {
                width: 100%;
                padding: 12px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 16px;
                font-weight: 600;
                transition: background 0.3s ease;
            }

            input[type="submit"] {
                background-color: #2ecc71;
                color: white;
                margin-top: 10px;
            }

            input[type="submit"]:hover {
                background-color: #27ae60;
            }

            button {
                background-color: #3498db;
                color: white;
                max-width: 460px; 
                margin-top: 15px;
            }

            button:hover {
                background-color: #2980b9;
            }

        </style>

        <script>
            function validateForm() {

                let title = document.forms["bookForm"]["title"].value.trim();
                let author = document.forms["bookForm"]["author"].value.trim();
                let price = document.forms["bookForm"]["price"].value.trim();
                let quantity = document.forms["bookForm"]["quantity"].value.trim();
                let isbn = document.forms["bookForm"]["isbn"].value.trim();
                let publisher = document.forms["bookForm"]["publisher"].value.trim();
                let editionYear = document.forms["bookForm"]["edition_year"].value.trim();
                let catalogueId = document.forms["bookForm"]["catalogueId"].value.trim();


                if (title === "") {
                    alert("Please enter a Title.");
                    return false;
                }
                
                if (title.length < 3) {
                    alert("Title must be at least 3 characters.");
                    return false;
                }

                

                if (author === "") {
                    alert("Please enter a author.");
                    return false;
                }

                if (author.length < 3) {
                    alert("Author name must be at least 3 characters.");
                    return false;
                }
                
                

                if (price <= 0) {
                    alert("Price must be greater than 0.");
                    return false;
                }
                
                

                if (quantity <= 0) {
                    alert("Quantity must be greater than 0.");
                    return false;
                }

                let isbnPattern = /^[0-9]{10,13}$/;
                if (!isbnPattern.test(isbn)) {
                    alert("ISBN must be 10 to 13 digits.");
                    return false;
                }

                let year = parseInt(editionYear);
                if (year < 1900 || year > new Date().getFullYear()) {
                    alert("Enter valid edition year.");
                    return false;
                }

                let catPattern = /^[A-Z0-9]{4,10}$/;
                if (!catPattern.test(catalogueId)) {
                    alert("Catalogue ID must be 4-10 uppercase letters/numbers.");
                    return false;
                }

                if (publisher === "")
                {
                    alert("please enter publisher.");
                    return false;
                }

                return true;
            }
        </script>
    </head>

    <body>

        <%
            int id = Integer.parseInt(request.getParameter("id"));

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                java.sql.Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/librarydb", "root", "");

                java.sql.PreparedStatement ps = con.prepareStatement(
                        "SELECT * FROM book WHERE bookId=?");

                ps.setInt(1, id);

                java.sql.ResultSet rs = ps.executeQuery();

                while (rs.next()) {
        %>

        <form name="bookForm" action="updateBook.jsp" method="post" onsubmit="return validateForm()">

            <input type="hidden" name="bookId" value="<%= rs.getInt("bookId")%>">

            Title:
            <input type="text"
                   name="title"
                   value="<%= rs.getString("title")%>"
                   required
                   maxlength="50"
                   pattern="[A-Za-z ]{3,50}"
                   oninput="this.value=this.value.replace(/[^A-Za-z ]/g,'')">
            <br><br>

            Author:
            <input type="text"
                   name="author"
                   value="<%= rs.getString("author")%>"
                   required
                   maxlength="50"
                   pattern="[A-Za-z ]{3,50}"
                   oninput="this.value=this.value.replace(/[^A-Za-z ]/g,'')">
            <br><br>

            Price:
            <input type="number"
                   name="price"
                   value="<%= rs.getDouble("price")%>"
                   required
                   min="1"
                   max="10000"
                   step="any">
            <br><br>

            Quantity:
            <input type="number"
                   name="quantity"
                   value="<%= rs.getInt("quantity")%>"
                   required
                   min="1"
                   max="1000">
            <br><br>

            ISBN:
            <input type="text"
                   name="isbn"
                   value="<%= rs.getString("isbn")%>"
                   required
                   maxlength="13"
                   pattern="[0-9]{10,13}"
                   oninput="this.value=this.value.replace(/[^0-9]/g,'')">
            <br><br>

            Publisher:
            <input type="text"
                   name="publisher"
                   value="<%= rs.getString("publisher")%>"
                   required
                   maxlength="50"
                   pattern="[A-Za-z ]{3,50}"
                   oninput="this.value=this.value.replace(/[^A-Za-z ]/g,'')">
            <br><br>

            Edition Year:
            <input type="number"
                   name="edition_year"
                   value="<%= rs.getInt("edition_year")%>"
                   required
                   min="1900"
                   max="2026">
            <br><br>

            Catalogue ID:
            <input type="text"
                   name="catalogueId"
                   value="<%= rs.getString("catalogueId")%>"
                   required
                   maxlength="10"
                   pattern="[A-Z0-9]{4,10}"
                   oninput="this.value=this.value.toUpperCase().replace(/[^A-Z0-9]/g,'')">
            <br><br>

            <input type="submit" value="Update">

        </form>

        <%
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>

    </body>
</html>