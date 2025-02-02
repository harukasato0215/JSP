package model;

import java.io.Serializable;

public class Star implements Serializable {
	private String enName;
	private String jpName;
	private String origin;
	private String starImage;
	
	public Star() {}

	public String getEnName() {
		return enName;
	}

	public String getJpName() {
		return jpName;
	}

	public String getOrigin() {
		return origin;
	}

	public String getStarImage() {
		return starImage;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public void setJpName(String jpName) {
		this.jpName = jpName;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setStarImage(String starImage) {
		this.starImage = starImage;
	};
	

}
