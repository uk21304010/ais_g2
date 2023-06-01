package command;

import dao.DbDummy;
import dao.ModifyDao;
import dto.Product;
import servlet.RequestContext;
import servlet.ResponseContext;

//import dao.AbstractDaoFactory;
//import dao.ProductsDao;
public class CreateDetailCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();

		String[]names=reqc.getParameter("NAME");
		String name = names[0];
		System.out.println(name);
		String[] cons=reqc.getParameter("CON");
		String con= cons[0];

		String[] imgs=reqc.getParameter("IMG");
		String img= imgs[0];
		
		Product p = new Product();
		p.setPid(name);
		p.setName(con);
		p.setPrice(img);

		ModifyDao md = new ModifyDao();
		String s = "‚³‚­‚ç";
		int anum= md.getANum();  
		String knum= md.getNumber(s);
		md.setDetail(p,anum,knum);
		
		resc.setTarget("start");
		return resc;
	}
}
		//AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		//ProductsDao dao=factory.getProductsDao();
		//dao.addProduct(p);
		//resc.setResult(dao.getAllProducts());