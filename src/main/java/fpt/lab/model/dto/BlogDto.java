package fpt.lab.model.dto;

import java.io.Serializable;

public class BlogDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String blogId;
	private String blogName;
	private String blogContent;
	private String imageUrl;
	private String iconClass;
	private String publishedDate;

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public BlogDto(String blogId, String blogName, String blogContent, String imageUrl, String iconClass,
			String publishedDate) {
		super();
		this.blogId = blogId;
		this.blogName = blogName;
		this.blogContent = blogContent;
		this.imageUrl = imageUrl;
		this.iconClass = iconClass;
		this.publishedDate = publishedDate;
	}

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

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
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

}
