package command;

import dao.DbDummy;
import dto.Product;
import servlet.RequestContext;
import servlet.ResponseContext;

//import dao.AbstractDaoFactory;
//import dao.ProductsDao;
public class AddProductCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();

		String[]pids=reqc.getParameter("pid");
		String pid = pids[0];

		String[] names=reqc.getParameter("name");
		String name= names[0];

		String[] prices=reqc.getParameter("price");
		String price= prices[0];

		Product p = new Product();
		p.setPid(pid);
		p.setName(name);
		p.setPrice(price);
		System.out.println("fail");
		
		DbDummy db = new DbDummy();
		db.addProduct(p);
		resc.setResult(db.getDatabase());
		resc.setTarget("view");
		return resc;
	}
}
		//AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		//ProductsDao dao=factory.getProductsDao();
		//dao.addProduct(p);
		//resc.setResult(dao.getAllProducts());