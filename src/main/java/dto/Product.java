package dto;

import java.io.Serializable;

public class Product implements Serializable{

	private String thumbnailScreen;
	
	private String titlePlace;
	
	private String detailContent;
	
	private String subthumbScreen;
	
	private String titleSub;

	private String name;
	private String con;
	private String img;
	private int anum;
	private String id;
	public void setName(String name) {
		this.name = name;
	}
	private String pass;
	 
	private String thumbnail;
	
	public String getThumbnail() {
		return thumbnail;
	}
	public String getThumbnailScreen() {
		return thumbnailScreen;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getAnum() {
		return anum;
	}
	public void setAnum(int anum) {
		this.anum = anum;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	private Integer atNum;
	private String atName;
	private String atCon;
	private String imgName;
	private Integer a_keyNum;
	private Integer k_keyNum;
	private String keyName;
	
	
	public Integer getAtNum() {
		return atNum;
	}
	public void setAtNum(Integer atNum) {
		this.atNum = atNum;
	}
	public String getAtName() {
		return atName;
	}
	public void setAtName(String atName) {
		this.atName = atName;
	}
	public String getAtCon() {
		return atCon;
	}
	public void setAtCon(String atCon) {
		this.atCon = atCon;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public Integer getA_keyNum() {
		return a_keyNum;
	}
	public void setA_keyNum(Integer a_keyNum) {
		this.a_keyNum = a_keyNum;
	}
	public Integer getK_keyNum() {
		return k_keyNum;
	}
	public void setK_keyNum(Integer k_keyNum) {
		this.k_keyNum = k_keyNum;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;

	}
	public String getName() {
		return name;

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