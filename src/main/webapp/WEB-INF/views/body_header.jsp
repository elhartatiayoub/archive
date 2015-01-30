<%-- 
    Document   : body_header.jsp
    Created on : 30-Jan-2015, 14:42:25
    Author     : Sara
--%>

    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="index.jsp"><img src="/SpringMVCHibernate/resources/img/logo.png" /></a>
          <div class="nav-collapse">
            <ul class="nav">
			  <li class="divider-vertical"></li>
              <li class="active"><a href="about.jsp">About</a></li>
			  <li class="divider-vertical"></li>
              <form class="navbar-search pull-left" action="ETTTT" />
                <input type="text" class="search-query span2" placeholder="Search" required="" />
              </form>
			  <li class="divider-vertical"></li>
            </ul>
            <ul class="nav pull-right">
            <li class="divider-vertical"></li>
            <li class="gravatar"><a href="profile.jsp"></a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="account_setting.jsp"><i class="icon-user"></i>Paramètres du Compte</a></li>
                <li class="divider"></li>
                <li><a href="signin.jsp"><i class="icon-off"></i>Déconnexion</a></li>
              </ul>
            </li>
            <li class="divider-vertical"></li>
          </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
