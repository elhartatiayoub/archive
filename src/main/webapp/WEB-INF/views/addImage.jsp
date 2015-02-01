<%-- 
    Document   : addImage
    Created on : 03-Jan-2015, 23:33:06
    Author     : Sara
--%>

<%@ include file="import.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>ENSA Gallery</title>
        <%@include file="header.jsp"  %>
    </head>
    <body>
        <%@include file="body_header.jsp" %>
        <form:form method="post" action="/SpringMVCHibernate/addImage" modelAttribute="ImageAddForm">
                    <form:label path="title">Titre</form:label>
                    <form:input path="title" />
                    <form:errors path="title" cssClass="error" />
              
                    <form:label path="pravacy">Privacy</form:label>
                    <form:input path="pravacy" />
                    <form:errors path="pravacy" cssClass="error" />
                    <form:label path="url">URLllll</form:label>
                    <form:input path="url" />
                    <form:errors path="url" cssClass="error" />
               
                    <form:errors path="*" />
                    <form:button path="submit" value="" >Ajouter Image</form:button>
      
        </form:form>
        <%@include file="footer.jsp" %>
    </body>
</html>
