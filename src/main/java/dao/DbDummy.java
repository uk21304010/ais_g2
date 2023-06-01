package dao;

import java.util.ArrayList;

import dto.Product;

public class DbDummy{
	private static ArrayList database=new ArrayList();

	public static void addProduct(Product p){
		database.add(p);
	}
	public static Product getProduct(int index){
		return (Product)database.get(index);
	}
	public static ArrayList getDatabase(){
		return database;
	}
}