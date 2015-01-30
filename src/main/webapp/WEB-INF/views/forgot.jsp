<%-- 
    Document   : forgot.jsp
    Created on : 30-Jan-2015, 16:05:50
    Author     : Sara
--%>

<%@page import="com.archive.spring.form.ForgotPass"%>
<%@ include file="import.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@ include file="header.jsp" %>
        <%
            if (request.getAttribute("ForgotPass") == null) {
                request.setAttribute("ForgotPass", new ForgotPass());
            }
        %>
    </head>
    <body>

        <div id="wrap">

            <%@include file="body_header.jsp" %>
           <div class="account-container btm10">

	<div class="form-content clearfix">
    
		<form:form action="/forgotpass" modelAttribute="ForgotPass">

			<h1><i class="iconbig-lock"></i> Sign In</h1>	
            
			<div class="login-fields">
            
				<p>Reset your password</p>
				<div class="field">
                                    <form:label path="email" for="email">Email</form:label>
                                    <form:input path="email"  id="email" placeholder="Email address" type="email" class="email-field"/>					
				</div> <!-- /password -->
			</div> <!-- /login-fields -->			

			<div class="login-actions">
                            <form:button type="submit" class="btn-signin btn btn-primary" > Submit </form:button> 
                                <a href="/signin" class="btn-signin btn">Cancel</a>
			</div> <!-- .actions -->
                        </form:form>

	   </div> <!-- /form-content -->

    </div> <!-- /account-container -->
    
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