package command;

import dao.DbDummy;

import dao.ModifyDao;
import servlet.ResponseContext;
import dto.Product;
//import dao.AbstractDaoFactory;
//import dao.ProductsDao;

public class GetProductCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		DbDummy db=new DbDummy();
		ModifyDao md = new ModifyDao();
		String s;
		System.out.println("cm");
		/*AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ProductsDao dao=factory.getProductsDao();

		List products=dao.getAllProducts();
		*/
		//s=md.getNumber();
		resc.setTarget("view");
		return resc;
	}
}
