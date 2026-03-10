<%-- 
    Document   : index
    Created on : 25 Feb, 2026, 9:20:56 PM
    Author     : VIRAJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTER PAGE</title>
        
        <script>
            function validateForm()
            {
                var fname=document.forms["regform"]["fname"].value;
                var lname=document.forms["regform"]["lname"].value;
                var password=document.forms["regform"]["password"].value;
                var conpassword=document.forms["regform"]["conpassword"].value;
                var email=document.forms["regform"]["email"].value;
                var mobile=document.forms["regform"]["mobile"].value;
                var address=document.forms["regform"]["address"].value;
                var role=document.forms["regform"]["role"].value;
                
                var namePattern = /^[A-Za-z]{6,}$/;
                var emailPattern = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
                var mobilePattern = /^[0-9]{10}$/;
                
                
                 if(fname=="")
                {
                    alert("pleace do not blank any filed");
                    return false;
                }
                if(fname.length<6)
                {
                    alert("pleace enter atlist 6 char name");
                    return false;
                }
                if (!namePattern.test(fname))
                {
                    alert("First Name must contain alphabets only and minimum 6 characters.");
                    return false;
                }
                

                if(lname=="")
                {
                    alert("pleace do not blank any filed");
                    return false;
                }
                
                if(lname.length<6)
                {
                    alert("pleace enter aylist 6 character");
                    return false;
                }
                 if (!namePattern.test(lname))
                 {
                    alert("Last Name must contain alphabets only and minimum 6 characters.");
                    return false;
                 }
                
                if(password=="")
                {
                    alert("pleace do not blank any filed");
                    return false;
                }
                 if(conpassword=="")
                {
                    alert("pleace do not blank any filed");
                    return false;
                }
                if(password != conpassword)
                {
                    alert("enter valid passwords");
                    return false;
                }
                
                if(email=="")
                {
                    alert("pleace do not blank any filed");
                    return false;
                }
                if (!emailPattern.test(email)) 
                {
                    alert("Enter valid Email address.");
                    return false;
                }
                 if(mobile=="")
                {
                    alert("pleace do not blank any filed");
                    return false;
                }
                if(!mobilePattern.test(mobile))
                {
                    alert("Mobile number must contain exactly 10 digits.");
                    return false;
                }
                if(address=="")
                {
                    alert("pleace do not blank any filed");
                    return false;
                }
                if(role=="")
                {
                    alert("pleace do not blank any filed");
                    return false;
                }
                return true;
                 
                
                
            }
            </script>
            
    </head>
    <body>
        <h1>THIS IS A RAGISTER PAGE</h1>
        
        <form name="regform" action="registerservlet" method="post" onsubmit=" return validateForm()">
           
            FIRST NAME:<input type="text" name="fname"><br><br>
            
           
            SECOUND NAME:<input type="text" name="lname"><br><br>
            
            PASSWORD<input type="password" name="password"><br><br>
            
           
            CONFORM PASSWORD:<input type="password" name="conpassword"><br><br>
            
           
            EMAIL:<input type="text" name="email"><br><br>
            
            MOBILE<input type="text" name="mobile"><br><br>
            
            ADDRESS<textarea name="address"></textarea><br><br>
            
            ROLE<select name="role">
                <option value=""> select role</option>
                <option value="admin">admin</option>
                <option value="registerd">registered</option>
                <option value="guest">guest</option>
            </select>
            
            <br><br>
            
            <input type="submit" name="register">
            
            
            
        </form>
    </body>
</html>
