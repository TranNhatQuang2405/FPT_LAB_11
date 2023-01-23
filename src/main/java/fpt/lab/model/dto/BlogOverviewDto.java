package fpt.lab.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BlogOverviewDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String month;
	private JSONArray data;

	public BlogOverviewDto() {
	}

	public BlogOverviewDto(String month, JSONArray data) {
		this.month = month;
		this.data = data;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public JSONArray getData() {
		return data;
	}

	public void setData(String jsonData) {
		this.data = new JSONArray(jsonData);
		sortData();
	}

	public List<JSONObject> getListData(){
		List<JSONObject> result = new ArrayList<JSONObject>();
		if(this.data != null) {
			for (int i = 0; i < this.data.length(); i++) {
				result.add(this.data.getJSONObject(i));
			}
		}
		return result;
	}
	
	private void sortData() {
		if (this.data != null) {

			List<JSONObject> jsonValues = new ArrayList<JSONObject>();
			for (int i = 0; i < this.data.length(); i++) {
				jsonValues.add(this.data.getJSONObject(i));
			}
			Collections.sort(jsonValues, new Comparator<JSONObject>() {
				private static final String KEY_NAME = "ROW_ID";

				@Override
				public int compare(JSONObject a, JSONObject b) {
					String valA = new String();
					String valB = new String();
					try {
						valA = (String) a.get(KEY_NAME);
						valB = (String) b.get(KEY_NAME);
					} catch (JSONException e) {
					}
					return valA.compareTo(valB);
				}
			});
			this.data = new JSONArray();
			for (int i = 0; i < jsonValues.size(); i++) {
				this.data.put(jsonValues.get(i));
			}
		}
	}
}
