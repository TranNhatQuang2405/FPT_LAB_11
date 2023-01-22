<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">
</head>
<body>
	<div id="right" class="span3">
		<div class="sidebar">
			<div class="wrapper share-box">
				<div class="heading">
					<h4>${data.getValue("ADVERTISE.TITLE_SHARE")}</h4>
				</div>

				<div class="content">
					<span>
						<ul>
							<c:forEach items="${data.getArrayValue('ADVERTISE.LIST_SHARE')}" var="item">
								<li>
									<a href="${item.get('LINK')}${fullpath}">
										<i class="${item.get('ICON_CLASS')}"></i><span>${item.get('LINK_NAME')}</span></a>
								</li>
							</c:forEach>
						</ul>
					</span>
				</div>
			</div>
			<div class="wrapper viral-box">
				<div class="heading">
					<h4>${data.getValue("ADVERTISE.TITLE_CREATE")}</h4>
				</div>

				<div class="content">
					<p>${data.getValue("ADVERTISE.SUBTITLE_CREATE")}</p>
					<div class="bottom">
						<a rel="nofollow"
							href="${data.getValue('ADVERTISE.PATH_CREATE')}"
							class="btn btn-block">${data.getValue("ADVERTISE.BTN_CREATE")}</a>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>