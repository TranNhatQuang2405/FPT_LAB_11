package fpt.lab.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class LoadFileService {
	public static String getSqlContent(String pathName) {
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			URL url = classLoader.getResource("sql/" + pathName);
			InputStream inputStream = url.openStream();
			String sql = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
			return sql;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
