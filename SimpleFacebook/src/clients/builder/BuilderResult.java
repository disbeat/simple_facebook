package clients.builder;

import java.io.Serializable;

public class BuilderResult implements Serializable {
	private static final long serialVersionUID = 123456789L;

	protected Object page;
	protected String redirectPath;
	protected Object cookies;

	public BuilderResult(Object page, String redirectPath, Object cookies) {
		this.page = page;
		this.redirectPath = redirectPath;
		this.cookies = cookies;
	}

	public Object getCookies() {
		return cookies;
	}

	public Object getPage() {
		return page;
	}

	public String getRedirectPath() {
		return redirectPath;
	}

}
