<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid footer-wrapper" id="footer">
	<!-- this is the Footer Wrapper -->
	<div class="container">
		<div class="footer-info">
			<div class="footer-info-text">${data.getValue("FOOTER.TITLE")}</div>
			<div class="footer-powered-by">
				<a rel="nofollow" href='<c:url value="${data.getValue('FOOTER.HOME_PATH')}"/>'>
					${data.getValue("FOOTER.DESCRIPTION")}
				</a>
			</div>
		</div>
		<div class="footer-page-counter" style="display: block;">
			<c:forEach items="${vistorCount}" var="num">
				<span class="footer-page-counter-item">${num}</span>
			</c:forEach>
		</div>
		<div id="css_simplesite_com_fallback" class="hide"></div>
	</div>
</div>