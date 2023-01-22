package fpt.lab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.lab.constant.ParamConstant;
import fpt.lab.constant.PathConstant;
import fpt.lab.model.dto.PageContent;
import fpt.lab.service.AboutMeService;

@WebServlet(value = PathConstant.PATH_ABOUT_ME)
public class AboutMeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doInit(request);
		request.getRequestDispatcher(PathConstant.JSP_ABOUT_ME_PATH).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void doInit(HttpServletRequest request) {
		AboutMeService aboutMeService = new AboutMeService();
		PageContent pageContent = aboutMeService.getPageContent();
		List<Integer> vistorCount = aboutMeService.getVisitorCount();
		request.setAttribute(ParamConstant.PARAM_DATA, pageContent);
		request.setAttribute(ParamConstant.PARAM_PATH, PathConstant.PATH_ABOUT_ME);
		request.setAttribute(ParamConstant.PARAM_FULL_PATH, request.getRequestURL());
		request.setAttribute(ParamConstant.PARAM_VISTOR_COUNT, vistorCount);
	}
}
