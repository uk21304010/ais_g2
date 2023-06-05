package dto;

import java.io.Serializable;

public class Product implements Serializable{
	private String name;
	private String price;
	private String pid;
	private String con;
	private String img;
	private int anum;
	private String id;
	private String pass;
	
<<<<<<< HEAD
	
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
=======
	private Integer atNum;//명소 번호
	private String atName;//명소 이름
	private String atCon;//명소 내용
	private String imgName;//이미지명
	private Integer a_keyNum;//명소 테이블 키워드 번호
	private Integer k_keyNum;//키워드 테이블 키워드 번호
	private String keyName;//키워드명
	
	
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
>>>>>>> a9746dcdad974bc570ffe8d0277b74bab3a8345a
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
}