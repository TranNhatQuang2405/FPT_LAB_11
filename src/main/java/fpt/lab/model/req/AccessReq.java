package fpt.lab.model.req;

import java.io.Serializable;

public class AccessReq implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String ip;

	private String userAgent;
	
	private String sessionId;
	
	private String userId;
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	
	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public AccessReq(String ip, String userAgent, String sessionId) {
		super();
		this.ip = ip;
		this.userAgent = userAgent;
		this.sessionId = sessionId;
		this.userId = null;
	}

	public AccessReq() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
