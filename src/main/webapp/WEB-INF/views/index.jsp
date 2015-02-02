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
                    <h3>Parce qu'une image est un souvenir precieux,partageons la avec tous</h3>
                    <p><a href="/SpringMVCHibernate/addImage" class="btn">Ajouter une image &rarr;</a></p>
                </div>
                <ul class="nav nav-tabs nav-stacked">
                    <li class="active"><a href="#"><i class="icon-picture"></i> Newest</a></li>
                    <li><a href="/SpringMVCHibernate/index/popular"><i class="icon-ok"></i> Popular</a></li>
                    <li><a href="/SpringMVCHibernate/index/liked"><i class="icon-bookmark"></i> Most likes</a></li>
                    <li><a href="/SpringMVCHibernate/index/download"><i class="icon-th-list"></i> Most Downloaded</a></li>
                </ul>
            </div>
            <div class="span3 galery">
                <div class="menu-galery">
                    <ul>
                        <li><a href="/SpringMVCHibernate/detail" rel="tooltip" title="Detail"><i class="iconbig-search"></i></a></li>
                        <li><a href="/SpringMVCHibernate/detail" rel="tooltip" title="Add Comment"><i class="iconbig-speak"></i></a></li>
                        <li><a href="" rel="tooltip" title="Download"><i class="iconbig-download"></i></a></li>
                        <li><a href="" rel="tooltip" title="Like"><i class="iconbig-black-star"></i></a></li>
                    </ul>
                </div>
                <div class="image-galery">
                    <c:if test="${!empty user.images}">
                        <c:forEach items="${user.images}" var="userI">
                             <a href="/SpringMVCHibernate/detail/${userI.id}" class="thumbnail">
                                 <img src="${userI.uqrl}" alt="" /></a>
                        </c:forEach>
                    </c:if> 
                </div>
                <div class="count-galery">
                    <ul>
                        <li><i class="icon-comment"></i>${image.comment}</li>
                        <li><i class="icon-download-alt"></i>${image.downloads}</li>
                        <li><i class="icon-star"></i>${image.likes}</li>
                        <li><i class="icon-eye-open"></i>${image.shares}</li>
                    </ul>
                </div>
                <div class="tags-galery">
                    <p><i class="icon-tags">
                         <c:if test="${!empty user.images}">
                                <c:forEach items="${user.images}" var="userI">
                                </i> Tags : <a href="#">${image.keywords}</a>,
                                </c:forEach>
                           </c:if> 
                    </p>
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
