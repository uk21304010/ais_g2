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
		String[]anums=reqc.postParameter("ANUM");
		String anum = anums[0];
		System.out.println("ANUM‚Ì’l"+anum);
		String[]combos=reqc.postParameter("COMBO");
		String combo = combos[0];
		System.out.println("COMBO‚Ì’l"+combo);
		
		String[]names=reqc.postParameter("NAME");
		String name = names[0];
		
		String[] cons=reqc.postParameter("CON");
		String con= cons[0];
		String fileName = null;
			if(reqc.uploadFile()) {
				System.out.println("Š®—¹");
				fileName = reqc.getFileName();
				p.setThumbnail(fileName);
			}
			
		p.setName(name);
		p.setCon(con);
 
		md.updateDetail(p,Integer.parseInt(anum),Integer.parseInt(combo));
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
