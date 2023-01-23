package fpt.lab.model.dto;

public enum BlogType {
	GENERAL("GENERAL"), QUOTES("QUOTES"), PICTURE("PICTURE");
	private String blogTypeName;

	private BlogType(String blogTypeName) {
		this.blogTypeName = blogTypeName;
	}

	public String getBlogTypeName() {
		return blogTypeName;
	}
}
