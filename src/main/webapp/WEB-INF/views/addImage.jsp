<%-- 
    Document   : addImage
    Created on : 03-Jan-2015, 23:33:06
    Author     : Sara
--%>

<%@page import="com.archive.spring.form.ImageAddForm"%>
<%@ include file="import.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>ENSA Gallery</title>
        <%@include file="header.jsp"  %>
            <%
            if (request.getAttribute("ImageAddForm") == null) {
                request.setAttribute("ImageAddForm", new ImageAddForm());
            }
            %>
    </head>
    <body>
        <%@include file="body_header.jsp" %>
                   
      <div class="container">
        <div class="row">
             <%@include file="profil_head.jsp" %>
            <div class="span9 content-setting">
                <div class="content-settings">
                    <div class="tabbable"> <!-- Only required for left/right tabs -->
                      <ul class="nav nav-tabs">
                        <li class="active"><a href="#addImage" data-toggle="tab">Ajouter votre image</a></li>
                      </ul>
                      <div class="tab-content">
                        <div class="tab-pane active" id="profile"><!-- Profile -->
                         <form:form method="post" action="/SpringMVCHibernate/addImage" class="form-horizontal" modelAttribute="ImageAddForm">
                            <div class="control-group">
                              <form:label path="title" class="control-label">Titre</form:label>
                   
                              <div class="controls" >
                                  <form:input path="title"  name="title" class="input-xlarge"/>
                                   <form:errors path="title" class="error" />
                              </div>
                            </div>
                            <div class="control-group">
                                <form:label path="pravacy" class="control-label">Etat</form:label>
                              <div class="controls">
                                  <form:input path="pravacy" name="pravacy" class="input-xlarge"  />
                                  <form:errors path="pravacy" name="pravacy" class="error" />
                              </div>
                            </div>
                              <div class="control-group">
                                  <form:label path="description" class="control-label">Description</form:label>
                              <div class="controls">
                              <form:textarea path="description" name="description" class="input-xlarge" rows="4"   />
                                  <form:errors path="description" name="description" class="error" />
                              </div>
                            </div>
                              <div class="control-group">
                                  <form:label path="keywords" class="control-label">Mot Cle</form:label>
                              <div class="controls">
                                  <form:input path="keywords" name="keywords" class="input-xlarge"  />
                                  <form:errors path="keywords" name="keywords" class="error" />
                              </div>
                            </div>
                              <div class="control-group">
                                  <form:label path="category" class="control-label">Categorie</form:label>
                              <div class="controls">
                                  <form:input path="category" name="category" class="input-xlarge"  />
                                  <form:errors path="category" name="category" class="error" />
                              </div>
                            </div>
                            <div class="control-group">
                                   <form:label path="url" name="url" class="control-label">URL</form:label>
                              <div class="controls">
                              <form:input path="url" type="file" class="input-file" name="url" id="fileInput" sizeLimit="2097152" allowTypes="*.jpg;*.png;*.gif;" />
                                    <form:errors path="url" name="url" class="error" />
                              </div>
                            </div>
                            <div class="form-actions">
                                 <form:errors path="*" />
                                 <form:button path="submit" name="submit" value="" >Ajouter Image</form:button>
                            </div>
                            </form:form>
                        </div>
                        </div>
                      </div>
                    </div> <!-- end tabbable -->
                </div>
            </div>
        </div>

        <%@include file="footer.jsp" %>
    </body>
</html>
