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
        <h1>gghjklhlj</h1>
    <form:form action="${addAction}" commandName="addImage">
    <legend>Ajoutez votre Image</legend>
				<div class="span7">
					<label for="nom">Nom de l'image:</label>
					<html:text property="name" styleClass="span4" ></html:text> <br>
				</div>
				<div class="span7">
					<label for="nom">Description</label>
					<html:text property="descr" styleClass="span4" ></html:text> <br>
				</div>
				<div class="span7">
					<label for="nom">Ville</label>
					<html:date property="ville" styleClass="span4" ></html:date> <br>
				</div>
				<div class="span7">
					<label for="nom">Telephone du restaurant</label>
					<html:text property="tel_restau" styleClass="span4" ></html:text> <br>
				</div>
				<div class="span7">
					<label for="nom">Service du restaurant</label>
					<html:text property="service_restau" styleClass="span4" ></html:text> <br>
				</div>
				<div class="span7">
					<label for="nom">Type de cuisine</label>
					<html:text property="type_cuisine" styleClass="span4" ></html:text> <br>
				</div>
				<div class="span7">
					<label for="nom">Site-Web</label>
					<html:text property="site_restau" styleClass="span4" value="http://"></html:text> <br>
				</div>
				<div class="span7">
					<html:submit  value="Suivant"></html:submit>
				</div>
   </form:form>
    </body>
</html>
