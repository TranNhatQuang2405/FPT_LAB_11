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
                            <div class="content">
                            	
                            	<div class="section">
                            		<c:if test="${blog != null}">
	                                    <div class="content">
	                                        <div class="avatar">
	                                            <i class="${blog.iconClass}"
	                                                title="${blog.blogName}"></i>
	                                        </div>
	                                        <div class="item">
	                                            <div class="controls">
	                                                <span class="date-text">${blog.publishedDate}</span>
	                                            </div>
	                                            <div class="heading">
	                                                <h4>
	                                                	<a rel="nofollow" href="<c:url value='${"/MyBlog?blogId="}${blog.blogId}'/>">${blog.blogName}</a>
	                                                </h4>
	                                            </div>
	
	                                            <div class="content">
	                                            	<c:if test="${blog.imageUrl != null && blog.blogContent != null}">
		                                            	<div class="img-simple span6 pull-left">
		                                                    <div class="image">
		                                                        <a rel="nofollow" data-ss="imagemodal">
		                                                        	<img src="<c:url value='${blog.imageUrl}'/>">
		                                                        </a>
		                                                    </div>
		                                                </div>
	                                            	</c:if>
	                                            	<c:if test="${blog.imageUrl != null && blog.blogContent == null}">
		                                            	<div class="img-simple  ">
			                                            	<div class="image">
		                                                        <a rel="nofollow" data-ss="imagemodal">
		                                                        	<img src="<c:url value='${blog.imageUrl}'/>">
		                                                        </a>
		                                                    </div>
	                                                    </div>
	                                            	</c:if>
													<c:if test="${blog.blogContent != null}">
														${blog.blogContent}
													</c:if>
	                                            </div>
	                                        </div>
	                                    </div>
                                    </c:if>
                                </div>
                                <ul class="pager">
                                    <li>
                                    	<a rel="nofollow" href="<c:url value='${data.getValue("MY_BLOG_BODY.OVERVIEW_LINK")}'/>">
                                            ${data.getValue("MY_BLOG_BODY.OVERVIEW")}
                                        </a>
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