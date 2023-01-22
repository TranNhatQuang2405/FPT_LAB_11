package fpt.lab.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class PageContent implements Serializable{

	private static final long serialVersionUID = 1L;
	private String title;
	private JSONObject jsonData;

	public PageContent(String title, JSONObject jsonData) {
		super();
		this.title = title;
		this.jsonData = jsonData;
	}

	public PageContent() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public JSONObject getJsonData() {
		return jsonData;
	}

	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}

	public void setJsonData(String jsonString) {
		this.jsonData = new JSONObject(jsonString);
	}

	public String getValue(String multiKey) {
		try {
			List<String> keys = Arrays.asList(multiKey.split("\\."));
			JSONObject tmpObject = this.jsonData;
			String result = null;
			for (int i = 0; i < keys.size(); i++) {
				if(i != keys.size() - 1)
					tmpObject = new JSONObject(tmpObject.get(keys.get(i)).toString());
				else 
					result = tmpObject.getString(keys.get(i));
			}
			return result;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public List<JSONObject> getArrayValue(String multiKey) {
		try {
			List<String> keys = Arrays.asList(multiKey.split("\\."));
			JSONObject tmpObject = this.jsonData;
			JSONArray jsonArray = null;
			List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
			for (int i = 0; i < keys.size(); i++) {
				if(i != keys.size() - 1)
					tmpObject = new JSONObject(tmpObject.get(keys.get(i)).toString());
				else 
					jsonArray = tmpObject.getJSONArray(keys.get(i));
			}
			for(int i = 0; i< jsonArray.length();i++) {
				jsonObjects.add(jsonArray.getJSONObject(i));
			}
			return jsonObjects;
		} catch (Exception e) {
			return new ArrayList<JSONObject>();
		}
		
	}
}
