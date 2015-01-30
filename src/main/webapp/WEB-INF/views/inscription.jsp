
<%@page import="com.archive.spring.form.UserInscriptionForm"%>
<%@ include file="import.jsp" %>
<html>
<head>
	<title>Image Archive</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
        <%
            if (request.getAttribute("UserInscriptionForm") == null) {
                request.setAttribute("UserInscriptionForm", new UserInscriptionForm());
            }
            ((UserInscriptionForm) request.getAttribute("signUpUser")).setTermsAndPolicy(false);
        %>
</head>
<body>
<h1>
	Inscription
</h1>

<c:url var="addAction" value="/user/add" ></c:url>
<c:url var="addAction2" value="/user/connect" ></c:url>

<form:form action="${addAction}" commandName="user">
  	
</form:form>

</body>
</html>
