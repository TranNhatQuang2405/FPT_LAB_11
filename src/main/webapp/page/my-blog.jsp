<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title><c:out value="${data.title}" /></title>
	<link rel="stylesheet" type="text/css"
		href="<c:url value='/assets/css/my-blog.css'></c:url>" />
</head>
<body>
    <div class="container-fluid site-wrapper"> <!-- this is the Sheet -->
    	<c:import url="/common/header_navbar.jsp"/>
    	
      <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
            <div class="container">
                <div class="row-fluid content-inner">
                    <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                        <div class="wrapper blog">
                            <div class="heading">
                                <h1 class="page-title">My Blog</h1>
                            </div>

                            <div class="content">
                                <div class="section">
                                    <div class="content">
                                        <div class="avatar">
                                            <i class="icon-pencil icon-4x"
                                                title="Essential skills for a happy life!"></i>
                                        </div>
                                        <div class="item">
                                            <div class="controls">
                                                <span class="date-text">16-11-2015</span>
                                            </div>
                                            <div class="heading">
                                                <h4><a rel="nofollow"
                                                        href="http://us-123my-life.simplesite.com/422328564/3232873/posting/essential-skills-for-a-happy-life">Essential
                                                        skills for a happy life!</a></h4>
                                            </div>

                                            <div class="content">
                                                <div class="img-simple span6 pull-left">
                                                    <div class="image">
                                                        <a rel="nofollow" data-ss="imagemodal"
                                                            data-href="http://cdn.simplesite.com/i/2b/ac/283445309157387307/i283445314544979646._szw1280h1280_.jpg"><img
                                                                src="./My Blog - us-123my-life.simplesite.com_files/i283445314544979646._szw480h1280_.jpg"></a>
                                                    </div>
                                                </div>

                                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam
                                                    nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat
                                                    volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation
                                                    ullamcorper suscipit lobortis nisl ut aliquip ex
                                                    ea commodo consequat.</p>
                                                <p>At eam doctus oportere, eam feugait delectus ne. Quo cu vulputate
                                                    persecuti. Eum ut natum possim comprehensam, habeo dicta scaevola eu
                                                    nec. Ea adhuc reformidans eam. Pri dolore epicuri eu, ne cum tantas
                                                    fierent instructior. Pro
                                                    ridens intellegam ut, sea at graecis scriptorem eloquentiam.</p>
                                                <p>Per an labitur lucilius ullamcorper, esse erat ponderum ad vim.
                                                    Possim laoreet suscipit ex pri, vix numquam eruditi feugait in. Nec
                                                    maluisset complectitur te, at sea decore semper. Falli numquam
                                                    perpetua sea et, tibique repudiandae an pro. Ut his solum persius
                                                    postulant. Soluta nemore debitis ne eos, cum an scripta pericula
                                                    partiendo.</p>
                                            </div>


                                        </div>
                                    </div>
                                </div>
                                <div class="section">
                                    <div class="content">
                                        <div class="avatar">
                                            <i class="icon-quote-left icon-4x" title="You&#39;ve gotta dance"></i>
                                        </div>
                                        <div class="item">
                                            <div class="controls">
                                                <span class="date-text">16-11-2015</span>
                                            </div>
                                            <div class="heading">
                                                <h4><a rel="nofollow"
                                                        href="http://us-123my-life.simplesite.com/422328564/3232872/posting/you-ve-gotta-dance">You've
                                                        gotta dance</a></h4>
                                            </div>


                                            <div class="content">
                                                <blockquote class="pull-right">
                                                    <p>"“You've gotta dance like there's nobody watching,<br>Love like
                                                        you'll never be hurt,<br>Sing like there's nobody
                                                        listening,<br>And live like it's heaven on earth.” "</p>
                                                    <small><cite title="William W. Purkey">William W.
                                                            Purkey</cite></small>
                                                </blockquote>
                                            </div>


                                        </div>
                                    </div>
                                </div>
                                <div class="section">
                                    <div class="content">
                                        <div class="avatar">
                                            <i class="icon-camera-retro icon-4x" title="Photo"></i>
                                        </div>
                                        <div class="item">
                                            <div class="controls">
                                                <span class="date-text">16-11-2015</span>
                                            </div>
                                            <div class="heading">
                                                <h4><a rel="nofollow"
                                                        href="http://us-123my-life.simplesite.com/422328564/3232871/posting/photo">Photo</a>
                                                </h4>
                                            </div>

                                            <div class="content">
                                                <div class="img-simple  ">
                                                    <div class="image">
                                                        <a rel="nofollow" data-ss="imagemodal"
                                                            data-href="http://cdn.simplesite.com/i/2b/ac/283445309157387307/i283445314544979644._szw1280h1280_.jpg"><img
                                                                src="./My Blog - us-123my-life.simplesite.com_files/i283445314544979644._szw1280h1280_.jpg"></a>
                                                    </div>
                                                </div>

                                            </div>


                                        </div>
                                    </div>
                                </div>
                                <ul class="pager">
                                    <li><a rel="nofollow"
                                            href="http://us-123my-life.simplesite.com/422328564?overview=1">Overview</a>
                                    </li>
                                </ul>
                            </div>


                        </div>
                    </div>
                   	<c:import url="/common/rightbar.jsp"/>
                </div>
            </div>
        </div> <!-- the controller has determined which view to be shown in the content -->
 		<c:import url="/common/footer.jsp" />
    </div>
</body>
</html>