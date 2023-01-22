package fpt.lab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fpt.lab.config.DatabaseLoader;
import fpt.lab.constant.NumberResultConstant;
import fpt.lab.model.req.AccessReq;
import fpt.lab.service.LoadFileService;

public class AccessDao {
	public boolean checkAccess(AccessReq accessReq) {
		try {
			Connection connection = DatabaseLoader.getConnection();
			String sql = LoadFileService.getSqlContent("check_access_site.sql");
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, accessReq.getIp());
			preparedStatement.setString(2, accessReq.getUserAgent());
			preparedStatement.setString(3, accessReq.getSessionId());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				connection.close();
				return false;
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
	}
	
	public int accessSite(AccessReq accessReq) {
		try {
			Connection connection = DatabaseLoader.getConnection();
			String sql = LoadFileService.getSqlContent("access_site.sql");
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, accessReq.getIp());
			preparedStatement.setString(2, accessReq.getUserAgent());
			preparedStatement.setString(3, accessReq.getSessionId());
			preparedStatement.setString(4, accessReq.getUserId());
			int result = preparedStatement.executeUpdate();
			connection.close();
			return result;
		} catch (Exception e) {
			return NumberResultConstant.ERROR;
		}
	}
	
	public int accessSiteAnomynous(AccessReq accessReq) {
		try {
			Connection connection = DatabaseLoader.getConnection();
			String sql = LoadFileService.getSqlContent("access_site_anomynous.sql");
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, accessReq.getIp());
			preparedStatement.setString(2, accessReq.getUserAgent());
			preparedStatement.setString(3, accessReq.getSessionId());
			int result = preparedStatement.executeUpdate();
			connection.close();
			return result;
		} catch (Exception e) {
			return NumberResultConstant.ERROR;
		}
	}
	
	public long countVisitor() {
		try {
			Connection connection = DatabaseLoader.getConnection();
			String sql = LoadFileService.getSqlContent("select_count_vistor.sql");
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			long result = resultSet.getInt(1);
			connection.close();
			return result;
		} catch (Exception e) {
			return NumberResultConstant.NO_DATA;
		}
	}
}
