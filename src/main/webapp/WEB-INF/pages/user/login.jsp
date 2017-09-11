<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
<title>Login Page</title>
</head>

<style>
form {
    
    width: 320px;
    padding: 10px;
    border: 8px solid #f1f1f1;
    margin: auto;
}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    
    max-width: 280px;
    margin: 0 auto;
    padding: 15px;
    margin-top:50px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}


</style>
<body>

<form:form method="post" action="login" modelAttribute="user">
  <div class="container">
  <h2>Login</h2>
    <form:label path="username">Username</form:label>
    <form:input path="username" placeholder="Enter Username"/>

    <form:label path="password">Password</form:label>
    <form:input path="password" type="password" placeholder="Enter Password"/>
        
    <!-- <button type="submit">Login</button> -->
    <input type="submit"  value="Login"/>
    <input type="checkbox" checked="checked"> Remember me
  

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
  </div>
</form:form>

</body>
</html>
