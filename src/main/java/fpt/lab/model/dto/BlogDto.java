package fpt.lab.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class BlogDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String blogId;
	private String blogName;
	private JSONObject blogContent;
	private String imageUrl;
	private String iconClass;
	private String publishedDate;
	private BlogType blogType;

	public BlogDto() {
		super();
	}

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public JSONObject getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = new JSONObject(blogContent);
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getIconClass() {
		return iconClass;
	}

	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public BlogDto(String blogId, String blogName, JSONObject blogContent, String imageUrl, String iconClass,
			String publishedDate, BlogType blogType) {
		super();
		this.blogId = blogId;
		this.blogName = blogName;
		this.blogContent = blogContent;
		this.imageUrl = imageUrl;
		this.iconClass = iconClass;
		this.publishedDate = publishedDate;
		this.blogType = blogType;
	}

	public BlogType getBlogType() {
		return blogType;
	}

	public void setBlogType(String blogType) {
		this.blogType = BlogType.valueOf(blogType);
	}

	public String getValue(String multiKey) {
		try {
			List<String> keys = Arrays.asList(multiKey.split("\\."));
			JSONObject tmpObject = this.blogContent;
			String result = null;
			for (int i = 0; i < keys.size(); i++) {
				if (i != keys.size() - 1)
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
			JSONObject tmpObject = this.blogContent;
			JSONArray jsonArray = null;
			List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
			for (int i = 0; i < keys.size(); i++) {
				if (i != keys.size() - 1)
					tmpObject = new JSONObject(tmpObject.get(keys.get(i)).toString());
				else
					jsonArray = tmpObject.getJSONArray(keys.get(i));
			}
			for (int i = 0; i < jsonArray.length(); i++) {
				jsonObjects.add(jsonArray.getJSONObject(i));
			}
			return jsonObjects;
		} catch (Exception e) {
			return new ArrayList<JSONObject>();
		}

	}
}
