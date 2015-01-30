<%-- 
    Document   : account_setting.jsp
    Created on : 30-Jan-2015, 19:20:21
    Author     : Sara
--%>


<%@ include file="import.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>ENSA Gallery</title>
        <%@ include file="header.jsp" %>
    </head>
    <body>
         <%@include file="body_header.jsp"%>
      <div class="container">
        <div class="row">
            <div class="span3 left-sidebar">
                <div class="account-settings">
                    <img src="/SpringMVCHibernate/resources/simg/gravatar.jpg" />
                </div>
                <div class="account-detail">
                    <p><strong>Sign up :</strong></p>
                    <p>3 weeks a go</p>
                    <p><strong>Location : </strong></p>
                    <p>California</p>
                    <hr />
                    <p><a href="profile.jsp">View Public Profile</a></p>
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
                          <form:form class="form-horizontal" >
                            <div class="control-group">
                              <form:label path="nom" class="control-label">Your Name</form:label>
                              <div class="controls">
                                <form:input path="nom" class="input-xlarge" value="dgfhj" />
                              </div>
                            </div>
                            <div class="control-group">
                              <form:label path="username" class="control-label">Username</form:label>
                              <div class="controls">
                                <form:input path="username" type="text" class="input-xlarge" value="johndoe" />
                                <p class="help-block">Your Public Profile : http://yourdomain.com/profile/johndoe</p>
                              </div>
                            </div>
                            <div class="control-group">
                              <form:label path="email" class="control-label">Email</form:label>
                              <div class="controls">
                                <form:input path="email" type="email" class="input-xlarge" value="johndoe@domain.com" />
                              </div>
                            </div>
                
                            <div class="control-group">
                              <form:label path="description" class="control-label">About</form:label>
                              <div class="controls">
                                <form:textarea path="description" class="input-xlarge" id="textarea" rows="3"></form:textarea>
                              </div>
                            </div>
                            <div class="control-group">
                              <form:label path="avtar" class="control-label">Avatar</form:label>
                              <div class="controls">
                                <form:input path="avatar"  class="input-file" id="fileInput" type="file" />
                              </div>
                            </div>
                            <div class="form-actions">
                                <form:button type="submit" name="submit" value="Save Change" class="btn" />
                            </div>
                          </form:form>
                        </div>
                        
                        <div class="tab-pane" id="password"><!-- Password -->
                          <form:form class="form-horizontal" >
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
                                <form:button path="submit" type="submit"  value="Save Change" class="btn" />
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

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery-1.7.2.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/image-gallery.js"></script>
    <script src="js/jquery.mousewheel-3.0.6.pack.js"></script>
    <script src="source/jquery.fancybox.js"></script>

    </body>
</html>
