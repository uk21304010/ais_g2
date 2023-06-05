package command;

import dao.DbDummy;
import dao.ModifyDao;
import dto.Product;
import servlet.RequestContext;
import servlet.ResponseContext;
//import dao.AbstractDaoFactory;
//import dao.ProductsDao;

public class UpdateDetailCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();
		ModifyDao md = new ModifyDao();
		Product p = new Product();
		String[]anums=reqc.getParameter("ANUM");
		String anum = anums[0];
		System.out.println("ANUM‚Ì’l"+anum);
		String[]combos=reqc.getParameter("COMBO");
		String combo = combos[0];
		System.out.println("COMBO‚Ì’l"+combo);
		
		String[]names=reqc.getParameter("NAME");
		String name = names[0];
		
		String[] cons=reqc.getParameter("CON");
		String con= cons[0];

		String[] imgs=reqc.getParameter("IMG");
		String img= imgs[0];

		p.setName(name);
		p.setCon(con);
		p.setThumbnail(img);

 
		int knum= md.getNumber(combo);
		md.updateDetail(p,Integer.parseInt(anum),knum);
		System.out.println("cm");
		/*AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ProductsDao dao=factory.getProductsDao();

		List products=dao.getAllProducts();
		*/
		//s=md.getNumber();
		resc.setTarget("start");
		return resc;
	}
}
