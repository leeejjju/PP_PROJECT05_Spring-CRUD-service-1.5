<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>view post</title>
</head>
<body>

<form:form modelAttribute="boardVO" method="POST" action="../editok" >

  <form:input path="title" readonly="true" cssStyle="font-size: large; font-weight: bold; border: none; margin-top: 20px"/>

  <br><br>
  <form:hidden path="seq" />
  <table id="edit">
    <tr>Writer: <form:input path="writer" readonly="true"/></tr>
    <tr><td><form:textarea cols="50" rows="10" path="content" readonly="true"/></td></tr>
  </table>
  <br>

  <input type="button" value="Back" onclick="history.back()" />
</form:form>

</body>
</html>