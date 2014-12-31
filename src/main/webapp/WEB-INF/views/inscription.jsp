<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
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
<h1>
	Inscription
</h1>

<c:url var="addAction" value="/user/add" ></c:url>
<c:url var="addAction2" value="/user/connect" ></c:url>

<form:form action="${addAction}" commandName="user">
    <table style="alignment-adjust: central">
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="email">
				<spring:message text="Email"/>
			</form:label>
		</td>
		<td>
			<form:input path="email" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="pass">
				<spring:message text="pass"/>
                                
			</form:label>
		</td>
		<td>
			<form:input path="pass" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			
				<input type="submit"
					value="<spring:message text="inscription"/>" />
			
		</td>
	</tr>
</table>	
</form:form>
<br>
<hr>
<br>

<h1>connexion</h1>

<form:form action="${addAction2}" commandName="user">
    <table style="alignment-adjust: central">
	
	<tr>
		<td>
                    <form:label path="email">
				<spring:message text="Email"/>
			</form:label>
		</td>
		<td>
			<form:input path="email" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="pass">
				<spring:message text="pass"/>
                                
			</form:label>
		</td>
		<td>
			<form:input path="pass" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="<spring:message text="connexion"/>" />
			
		</td>
	</tr>
</table>	
</form:form>

</body>
</html>
