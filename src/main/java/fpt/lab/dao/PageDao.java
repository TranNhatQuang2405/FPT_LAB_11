package fpt.lab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fpt.lab.config.DatabaseLoader;
import fpt.lab.model.dto.PageContent;
import fpt.lab.service.LoadFileService;

public class PageDao {
	public PageContent selectPageContent(String pathName) {
		try {
			Connection connection = DatabaseLoader.getConnection();
			String sql = LoadFileService.getSqlContent("select_page_content.sql");
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, pathName);
			ResultSet rs = preparedStatement.executeQuery();
			PageContent pageContent = new PageContent();
			while (rs.next()) {
				pageContent.setTitle(rs.getString("PAGE_TITLE"));
				pageContent.setJsonData(rs.getString("DATA"));
				break;
			}
			connection.close();
			return pageContent;
		} catch (Exception e) {
			return null;
		}
	}
}
