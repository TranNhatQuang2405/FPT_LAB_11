package fpt.lab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fpt.lab.config.DatabaseLoader;
import fpt.lab.model.dto.UserDto;
import fpt.lab.service.LoadFileService;

public class UserDao {
	public UserDto getGuestAccount() {
		try {
			Connection connection = DatabaseLoader.getConnection();
			String sql = LoadFileService.getSqlContent("get_guest_account.sql");
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			UserDto userDto = new UserDto();
			while (rs.next()) {
				userDto.setUserId(rs.getString("USER_ID"));
				userDto.setUserName(rs.getString("USER_NAME"));
				break;
			}
			connection.close();
			return userDto;
		} catch (Exception e) {
			return null;
		}
	}
}
