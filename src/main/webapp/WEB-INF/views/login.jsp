<%--
  Created by IntelliJ IDEA.
  User: Pearl LEE
  Date: 2022-12-06
  Time: 오후 5:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>leeejjju-login</title>
    <style>
        img, label {display: inline-block;}
        label{width: 130px}
        button{background-color: darkolivegreen; color: white; font-size: 15px}
    </style>
</head>
<body>

    <div style="width: 100%; text-align: center; padding-top: 100px; justify-content: center; margin-left: 20%";>
        
        <img src="http://pngedits.com/public/uploads/preview/funny-cat-transparent-png-hd-11615994388qvybvgcqtu.png" width="450px" height="150px">
        <form method="post" action="loginOK" style="border: 2px solid darkolivegreen; padding: 20px; width:60%">
            <div>
                <label>User ID: </label>
                <input type="text" name="userid" />
            </div>
            <div>
                <label>password: </label>
                <input type="password" name="password" />
            </div>
            <br>
            <button type="submit">Login</button>

        </form>
        
    </div>


</body>
</html>
