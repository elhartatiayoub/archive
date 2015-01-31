<%-- 
    Document   : index.jsp
    Created on : 30-Jan-2015, 20:21:41
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
            <div class="span3">
                <div class="nav-headers">
                    <h3>Parce qu'une image est un souvenir precieux,partageons avec tous</h3>
                    <p><a href="about.jsp" class="btn">Learn more &rarr;</a></p>
                </div>
                <ul class="nav nav-tabs nav-stacked">
                    <li class="active"><a href="#"><i class="icon-picture"></i> Newest</a></li>
                    <li><a href="#"><i class="icon-ok"></i> Popular</a></li>
                    <li><a href="#"><i class="icon-certificate"></i> Top Sites</a></li>
                    <li><a href="#"><i class="icon-bookmark"></i> Most Viewed</a></li>
                    <li><a href="#"><i class="icon-th-list"></i> Categories</a></li>
                    <li><a href="#"><i class="icon-download"></i> Most Download</a></li>
                    <li><a href="#"><i class="icon-heart"></i> Recomended</a></li>
                </ul>
            </div>
            <div class="span3 galery">
                <div class="menu-galery">
                    <ul>
                        <li><a href="detail.jsp" rel="tooltip" title="Detail"><i class="iconbig-search"></i></a></li>
                        <li><a href="" rel="tooltip" title="Add Comment"><i class="iconbig-speak"></i></a></li>
                        <li><a href="" rel="tooltip" title="Download"><i class="iconbig-download"></i></a></li>
                        <li><a href="" rel="tooltip" title="Like"><i class="iconbig-black-star"></i></a></li>
                    </ul>
                </div>
                <div class="image-galery"><a class="group" rel="group1" href="/SpringMVCHibernate/resources/img/4_b.jpg"><img src="/SpringMVCHibernate/resources/img/4_b.jpg" /></a></div>
                <div class="count-galery">
                    <ul>
                        <li><i class="icon-comment"></i> 5</li>
                        <li><i class="icon-download-alt"></i> 7</li>
                        <li><i class="icon-star"></i> 2</li>
                        <li><i class="icon-eye-open"></i> 20</li>
                    </ul>
                </div>
                <div class="tags-galery">
                    <p><i class="icon-tags"></i> Tags : <a href="#">Building</a>, <a href="#">Tower</a>, 
                    <a href="#">Eifel</a>, <a href="#">Wonders of the world</a>, <a href="#">Miracle</a></p>
                </div>
            </div>
            </div>
        </div>
    </div>
    
    <div class="container">
        <div class="pagination">
        <ul>
          <li class="disabled"><a href="#" title="Go to the first page">&laquo; First</a></li>
          <li><a href="#" title="Go to the previous page">&larr;</a></li>
          <li class="active"><a href="#">1</a></li>
          <li><a href="#">2</a></li>
          <li><a href="#">..</a></li>
          <li><a href="#">8</a></li>
          <li><a href="#">9</a></li>
          <li><a href="#" title="Go to the next page">&rarr;</a></li>
          <li><a href="#" title="Go to the last page">Last &raquo;</a></li>
        </ul>
      </div>
    </div>
<%@ include file="footer.jsp" %>

    </body>
</html>
