package command;


import dao.ModifyDao;
import dto.Product;
import servlet.RequestContext;
import servlet.ResponseContext;

//import dao.AbstractDaoFactory;
//import dao.ProductsDao;
public class CreateDetailCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();
		String[]combos=reqc.postParameter("COMBO");
		String combo = combos[0];
		
		System.out.println("コンボボックスの値は"+combo);
		String[]names=reqc.postParameter("NAME");
		String name = names[0];
		String[] cons=reqc.postParameter("CON");
		String con= cons[0];

		Product p = new Product();
		String fileName = null;
		if(reqc.uploadFile()) {
			System.out.println("完了");
			fileName = reqc.getFileName();
			p.setThumbnail(fileName);
		}else {
			System.out.println("エラー");

			resc.setResult("ファイルアップロードエラー");
			resc.setTarget("inputDetail");

	        return resc;
		}
		p.setCon(con);
		p.setName(name);

		ModifyDao md = new ModifyDao();

		int anum= md.getANum();  
		int knum= md.getNumber(combo);
		md.setDetail(p,anum,knum);
		resc.setTarget("start");
		return resc;
	}
}
		//AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		//ProductsDao dao=factory.getProductsDao();
		//dao.addProduct(p);
		//resc.setResult(dao.getAllProducts());