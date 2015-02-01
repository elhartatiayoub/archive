<%-- 
    Document   : account_setting.jsp
    Created on : 30-Jan-2015, 19:20:21
    Author     : Sara
--%>


<%@page import="com.archive.spring.form.UserModifyForm"%>
<%@ include file="import.jsp" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:p="http://primefaces.org/ui">
    <h:head>
        <title>ENSA Gallery</title>
        <%@ include file="header.jsp" %>
         <%
            if (request.getAttribute("UserModifyForm") == null) {
                request.setAttribute("UserModifyForm", new UserModifyForm());
            }
            %>
    </h:head>
    <h:body>
     <%@include file="body_header.jsp"%>
      <div class="container">
        <div class="row">
            <div class="span3 left-sidebar">
                <div class="account-settings">
                    <img src="/SpringMVCHibernate/resources/img/gravatar.jpg" />
                </div>
                <div class="account-detail">
                    <p><strong>Sign up :</strong></p>
                    <p>3 weeks a go</p>
                    <p><strong>Location : </strong></p>
                    <p>California</p>
                    <hr />
                    <p><a href="/SpringMVCHibernate/profile">View Public Profile</a></p>
                </div>
            </div>
            <div class="span9 content-setting">
                <div class="content-settings">
                    <div class="tabbable"> <!-- Only required for left/right tabs -->
                      <ul class="nav nav-tabs">
                        <li class="active"><a href="#profile" data-toggle="tab">Profile</a></li>
                        <li><a href="#password" data-toggle="tab">Password</a></li>
                      </ul>
                      <div class="tab-content">
                        <div class="tab-pane active" id="profile"><!-- Profile -->
                            <h:form enctype="multipart/form-data" class="form-horizontal">
                            <div class="control-group">
                              <label for="username" class="control-label">Username</label>
                              <div class="controls">
                                  <p:inputText  value="#{changeAccountForm.username}" label="username" class="input-xlarge"/>
                              </div>
                            </div>
                            <div class="control-group">
                              <label for="email" class="control-label">Email</label>
                              <div class="controls">
                                <p:inputText  value="#{changeAccountForm.email}" label="email"  class="input-xlarge"/>
                              </div>
                            </div>
                
                            <div class="control-group">
                              <label for="description" class="control-label">About</label>
                              <div class="controls">
                                <p:inputTextarea  value="#{changeAccountForm.description}" label="description" rows="3" class="input-xlarge"/>
                              </div>
                            </div>
                            <div class="control-group">
                              <label path="avatar" class="control-label">Avatar</label>
                              <div class="controls">
                                  <p:fileUpload value="#{changeAccountForm.file}" class="input-file" mode="simple" sizeLimit="2097152" id="fileInput" label="choose" allowTypes="*.jpg;*.png;*.gif;"/>
                              </div>
                            </div>
                            <div class="form-actions">
                                <p:commandButton value="Save Change" class="btn" ajax="false" actionListener="#{changeAccountForm.upload}"  />
                            </div>
                          </h:form>
                        </div>
                          
                        
                        <div class="tab-pane" id="password"><!-- Password -->
                          <form:form class="form-horizontal" action="/SpringMVCHibernate/profil" modelAttribute="UserModifyForm">
                            <div class="control-group">
                              <form:label path="oldpass" class="control-label">Enter Old Password</form:label>
                              <div class="controls">
                                <form:input path="oldpass" type="password" class="input-xlarge" />
                              </div>
                            </div>
                            <div class="control-group">
                              <form:label path="newpass" class="control-label">Enter New Password</form:label>
                              <div class="controls">
                                <form:input path="newpass" type="password" class="input-xlarge" />
                              </div>
                            </div>
                            <div class="control-group">
                              <form:label path="confNew" class="control-label">Confirm New Password</form:label>
                              <div class="controls">
                                <form:input path="confNew" type="password" class="input-xlarge" />
                              </div>
                            </div>
                            <div class="form-actions">
                                <form:button path="submit" type="submit"  value="Save Change" class="btn" >Modifier</form:button>
                            </div>
                          </form:form>
                        </div>
                      </div>
                    </div> <!-- end tabbable -->
                </div>
            </div>
        </div>
    </div>
        <%@ include file="footer.jsp" %>
    </h:body>
</html>
