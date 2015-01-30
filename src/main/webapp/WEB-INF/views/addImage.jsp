<%-- 
    Document   : addImage
    Created on : 03-Jan-2015, 23:33:06
    Author     : Sara
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
	<title>Image Archive</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
    </head>
    <body>
        <h2>Inscription</h2>
        <form:form method="post" action="/image/add" commandName="addImage">
     
            <table>
                <tr>
                    <td><form:label path="title">Titre</form:label></td>
                    <td><form:input path="title" /></td>
                    <td><form:errors path="title" cssClass="error" /></td>
                </tr>
                
                <tr>
                    <td><form:label path="pravacy">Privacy</form:label></td>
                    <td><form:input path="pravacy" /></td>
                    <td><form:errors path="pravacy" cssClass="error" /></td>
 
                </tr>
                <tr>
                    <td><form:label path="url">URL</form:label></td>
                    <td><form:input path="url" /></td>
                    <td><form:errors path="url" cssClass="error" /></td>
                </tr>
                <tr>
                    <td><form:errors path="*" /></td>
                    <td colspan="2"><input type="submit" value="Ajouter" /></td>
                </tr>
            </table>
     
        </form:form>
    </body>
</html>
