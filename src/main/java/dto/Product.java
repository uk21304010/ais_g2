package dto;

import java.io.Serializable;

public class Product implements Serializable{
	private String thumbnailScreen;
	
	private String titlePlace;
	
	private String detailContent;
	
	private String subthumbScreen;
	
	private String titleSub;

	public String getThumbnailScreen() {
		return thumbnailScreen;
	}

	public void setThumbnailScreen(String thumbnailScreen) {
		this.thumbnailScreen = thumbnailScreen;
	}

	public String getTitlePlace() {
		return titlePlace;
	}

	public void setTitlePlace(String titlePlace) {
		this.titlePlace = titlePlace;
	}

	public String getDetailContent() {
		return detailContent;
	}

	public void setDetailContent(String detailContent) {
		this.detailContent = detailContent;
	}

	public String getSubthumbScreen() {
		return subthumbScreen;
	}

	public void setSubthumbScreen(String subthumbScreen) {
		this.subthumbScreen = subthumbScreen;
	}

	public String getTitleSub() {
		return titleSub;
	}

	public void setTitleSub(String titleSub) {
		this.titleSub = titleSub;
	}
	
	
}