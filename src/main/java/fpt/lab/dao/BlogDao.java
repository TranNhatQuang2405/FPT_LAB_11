package fpt.lab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fpt.lab.config.DatabaseLoader;
import fpt.lab.constant.NumberResultConstant;
import fpt.lab.model.dto.BlogDto;
import fpt.lab.service.LoadFileService;

public class BlogDao {
	public List<BlogDto> selectTopBlog(String userId) {
		List<BlogDto> result = new ArrayList<BlogDto>();
		try {
			Connection connection = DatabaseLoader.getConnection();
			String sql = LoadFileService.getSqlContent("select_top_X_blog.sql");
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, NumberResultConstant.LENGTH_ITEM_IN_HOME_PAGE);
			preparedStatement.setString(2, userId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				BlogDto blogDto = new BlogDto();
				blogDto.setBlogId(rs.getString("BLOG_ID"));
				blogDto.setBlogName(rs.getString("BLOG_NAME"));
				blogDto.setBlogContent(rs.getString("BLOG_CONTENT"));
				blogDto.setImageUrl(rs.getString("IMAGE_URL"));
				blogDto.setIconClass(rs.getString("ICON_CLASS"));
				blogDto.setPublishedDate(rs.getString("PUBLISHED_DATE"));
				result.add(blogDto);
			}
			connection.close();
			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return result;
		}
	}
	
	public BlogDto selectBlogDetail(String userId, String blogId) {
		try {
			Connection connection = DatabaseLoader.getConnection();
			String sql = LoadFileService.getSqlContent("select_blog_detail.sql");
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, blogId);
			ResultSet rs = preparedStatement.executeQuery();
			BlogDto blogDto = new BlogDto();
			while (rs.next()) {
				blogDto.setBlogId(rs.getString("BLOG_ID"));
				blogDto.setBlogName(rs.getString("BLOG_NAME"));
				blogDto.setBlogContent(rs.getString("BLOG_CONTENT"));
				blogDto.setImageUrl(rs.getString("IMAGE_URL"));
				blogDto.setIconClass(rs.getString("ICON_CLASS"));
				blogDto.setPublishedDate(rs.getString("PUBLISHED_DATE"));
				break;
			}
			connection.close();
			return blogDto;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
