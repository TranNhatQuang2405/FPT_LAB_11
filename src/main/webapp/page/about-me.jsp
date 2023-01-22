<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title><c:out value="${data.title}" /></title>
	<link rel="stylesheet" type="text/css"
		href="<c:url value='/assets/css/about-me.css'></c:url>" />
</head>
<body>
 <div class="container-fluid site-wrapper"> <!-- this is the Sheet -->
	<c:import url="/common/header_navbar.jsp"/>
       
           <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
            <div class="container">
                <div class="row-fluid content-inner">
                    <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                        <div class="wrapper ">
                            <div class="content">
                                <div class="section article">
                                    <div class="heading">
                                        <h3>${data.getValue("ABOUT_ME_BODY.TITLE")}</h3>
                                    </div>

                                    <div class="content">
	                                    <c:forEach var='item' items='${data.getArrayValue("ABOUT_ME_BODY.DESCRIPTION")}'>
	                                     	<p><span>${item.get("PARA")}</span></p>
										</c:forEach>
                                    </div>
                                </div>
                                <div class="section signature">
                                    <div class="content">

                                        <div class="signature-text-noimg">
                                            <p>${data.getValue("ABOUT_ME_BODY.PRE_SIGN")}</p>
                                            <div class="signature-sign" style="font-family: &#39;Pacifico&#39;,serif;">
                                                ${data.getValue("ABOUT_ME_BODY.SIGN")}
                                            </div>
                                        </div>
                                    </div>
                                </div>
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