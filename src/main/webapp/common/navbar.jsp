<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar navbar-compact">
	<div class="navbar-inner">
		<div class="container">
			<div>
				<ul class="nav" data-submenu="horizontal">
					<c:forEach var='item' items='${data.getArrayValue("NAVBAR")}'>
						<li class="${path == item.get('PATH') ? 'active': ''}" style="">
							<a href='<c:url value="${item.get('PATH')}"/>'>
								${item.get("CONTENT")} </a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>

