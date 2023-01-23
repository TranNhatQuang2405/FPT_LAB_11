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
                                <h1 class="page-title">${data.getValue("MY_BLOG_BODY.OVERVIEW_TITLE")}</h1>
                            </div>

                            <div class="content">
                            	<c:forEach items="${overviews}" var="overview">
                                        <hr class="line"/>
                                        <div class="overview-child">
                                            <span class="date-text text-overview">
                                            	${overview.month}
                                            </span>
                                            <span class="date-text text-overview">
                                            	${data.getValue("MY_BLOG_BODY.DATE")}
                                            </span>
                                        </div>
                                        <c:forEach items="${overview.getListData()}" var="blog">
                                        	<hr class="line"/>
                                        	<div class="overview-child">
                                        	<a rel="nofollow" class="cur-pointer" href="<c:url value='${data.getValue("MY_BLOG_BODY.VIEW_DETAIL_LINK")}${blog.get("BLOG_ID")}'/>">
	                                        	<span class="date-text text-overview">
	                                            	${blog.get("BLOG_NAME")}
	                                            </span>
                                        	</a>
                                            <span class="date-text text-overview">
                                            	${blog.get("PUBLISHED_DATE")}
                                            </span>
                                        </div>
                                        </c:forEach>
                            	</c:forEach>
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