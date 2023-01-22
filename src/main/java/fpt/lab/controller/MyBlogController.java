package fpt.lab.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.lab.constant.ParamConstant;
import fpt.lab.constant.PathConstant;
import fpt.lab.model.dto.BlogDto;
import fpt.lab.model.dto.PageContent;
import fpt.lab.model.dto.UserDto;
import fpt.lab.model.req.AccessReq;
import fpt.lab.service.CommonService;
import fpt.lab.service.MyBlogService;

@WebServlet(value = PathConstant.PATH_MY_BLOG)
public class MyBlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doInit(request);
		doAccess(request);
		String jspUrl = doGetData(request, response);
		request.getRequestDispatcher(jspUrl).forward(request, response);

	}

	private String doGetData(HttpServletRequest request, HttpServletResponse response)  {
		MyBlogService myBlogService = new MyBlogService();
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("user");
		if(userDto != null) {
			String blogId = request.getParameter(ParamConstant.MY_BLOG_PARAM_BLOG_ID);
			String overview = request.getParameter(ParamConstant.MY_BLOG_PARAM_OVERVIEW);
			if(blogId != null && !blogId.isBlank()) {
				BlogDto blogDto = myBlogService.getBlogDetail(userDto.getUserId(), blogId);
				request.setAttribute(ParamConstant.MY_BLOG_PARAM_BLOG, blogDto);
				return PathConstant.JSP_MY_BLOG_DETAIL_PATH;
			}else if(overview != null && overview.equals("true")) {
				return PathConstant.JSP_MY_BLOG_OVERVIEW_PATH;
			}else {
				List<BlogDto> blogDtos = myBlogService.getListBlog(userDto.getUserId());
				request.setAttribute(ParamConstant.MY_BLOG_PARAM_BLOGS, blogDtos);
				return PathConstant.JSP_MY_BLOG_PATH;
			}
		}else {
			return PathConstant.JSP_MY_BLOG_PATH;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void doInit(HttpServletRequest request) {
		MyBlogService myBlogService = new MyBlogService();
		PageContent pageContent = myBlogService.getPageContent();
		List<Integer> vistorCount = myBlogService.getVisitorCount();
		request.setAttribute(ParamConstant.PARAM_DATA, pageContent);
		request.setAttribute(ParamConstant.PARAM_PATH, PathConstant.PATH_MY_BLOG);
		request.setAttribute(ParamConstant.PARAM_FULL_PATH, request.getRequestURL());
		request.setAttribute(ParamConstant.PARAM_VISTOR_COUNT, vistorCount);
	}
	
	private void doAccess(HttpServletRequest request) throws UnknownHostException {
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		String userAgent = request.getHeader("User-Agent");
		String ip = request.getHeader("X-FORWARDED-FOR");
		String serverName = request.getServerName();
		if (ip == null || "".equals(ip)) {
			if(serverName.equals("localhost")) {
				InetAddress address = InetAddress.getLocalHost();
				ip = address.getHostAddress();
			}else {
				ip = request.getRemoteAddr();
			}
		}
		AccessReq accessReq = new AccessReq(ip, userAgent, sessionId);
		CommonService commonService = new CommonService();
		commonService.accessSite(accessReq);
	}


}
