package fpt.lab.service;

import java.util.List;

import fpt.lab.dao.AccessDao;
import fpt.lab.dao.PageDao;
import fpt.lab.model.dto.PageContent;
import fpt.lab.model.dto.SiteVisitorCount;

public class BaseService {
	protected String path;
	
	public PageContent getPageContent() {
		PageDao pageDao = new PageDao();
		return pageDao.selectPageContent(this.path);
	}
	
	public List<Integer> getVisitorCount(){
		AccessDao accessDao = new AccessDao();
		Long count = accessDao.countVisitor();
		SiteVisitorCount siteVisitorCount = new SiteVisitorCount(count);
		return siteVisitorCount.getVisitorCount();
	}
}
