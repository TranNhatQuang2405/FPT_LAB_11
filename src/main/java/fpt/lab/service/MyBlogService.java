package fpt.lab.service;

import java.util.List;

import fpt.lab.constant.PathConstant;
import fpt.lab.dao.BlogDao;
import fpt.lab.model.dto.BlogDto;

public class MyBlogService extends BaseService {

	public MyBlogService() {
		super();
		this.path = PathConstant.PATH_MY_BLOG;
	}

	public List<BlogDto> getListBlog(String userId) {
		BlogDao blogDao = new BlogDao();
		return blogDao.selectTopBlog(userId);
	}

	public BlogDto getBlogDetail(String userId, String blogId) {
		BlogDao blogDao = new BlogDao();
		return blogDao.selectBlogDetail(userId, blogId);
	}
}
