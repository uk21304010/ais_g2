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
		String[]combos=reqc.getParameter("COMBO");
		String combo = combos[0];
		System.out.println("�R���{�{�b�N�X�̒l��"+combo);
		String[]names=reqc.getParameter("NAME");
		String name = names[0];
		String[] cons=reqc.getParameter("CON");
		String con= cons[0];

		String[] imgs=reqc.getParameter("IMG");
		String img= imgs[0];
		
		Product p = new Product();
		p.setPid(name);
		p.setName(con);
		p.setPrice(img);

		ModifyDao md = new ModifyDao();
<<<<<<< HEAD

		int anum= md.getANum();  
		int knum= md.getNumber(combo);
		md.setDetail(p,anum,knum);
=======
		String s = "さくら";

>>>>>>> a9746dcdad974bc570ffe8d0277b74bab3a8345a
		
		resc.setTarget("start");
		return resc;
	}
}
		//AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		//ProductsDao dao=factory.getProductsDao();
		//dao.addProduct(p);
		//resc.setResult(dao.getAllProducts());