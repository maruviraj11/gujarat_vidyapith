<%-- 
    Document   : index
    Created on : 19 Mar, 2026, 11:54:28 AM
    Author     : viraj maru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>Login</title>

<script>
function validate() {
    let email = document.forms["f"]["email"].value;
    let password = document.forms["f"]["password"].value;

   
    if (email == "" || password == "") {
        alert("All fields required!");
        return false;
    }

   
    let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!emailPattern.test(email)) {
        alert("Enter valid email address!");
        return false;
    }

    return true;
}
function noSpace(event)
{
    if(event.key === " ")
    {
        alert("do not enter space");
        return false;
    }
}
</script>

<style>

body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    background: linear-gradient(to right, #4facfe, #00f2fe);
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

.box {
    background: white;
    padding: 40px;
    width: 320px;
    border-radius: 12px;
    box-shadow: 0px 8px 20px rgba(0,0,0,0.2);
    text-align: center;
}


.box h2 {
    margin-bottom: 20px;
    color: #333;
}

.box input {
    width: 100%;
    padding: 12px;
    margin: 10px 0;
    border: 1px solid #ccc;
    border-radius: 8px;
    outline: none;
    transition: 0.3s;
}


.box input:focus {
    border-color: #4facfe;
    box-shadow: 0 0 5px #4facfe;
}


.box button {
    width: 100%;
    padding: 12px;
    background: #4facfe;
    border: none;
    color: white;
    font-size: 16px;
    border-radius: 8px;
    cursor: pointer;
    transition: 0.3s;
}

.box button:hover {
    background: #007bff;
}
</style>

</head>

<body>

<div class="box">
<h2>Login</h2>

<form name="f" action="validate.jsp" method="post" onsubmit="return validate()">
    <input type="text" name="email" placeholder="Email" onkeypress="return noSpace(event)"><br><br>
    <input type="password" name="password" placeholder="Password" onkeypress="return noSpace(event)"><br><br>
    <button type="submit">Login</button>
</form>

</div>

</body>
</html>
