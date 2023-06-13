package command;


import dao.AccountDao;
import dto.Product;
import servlet.RequestContext;
import servlet.ResponseContext;

//import dao.AbstractDaoFactory;
//import dao.ProductsDao;
public class CheckCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();

		String[]ids=reqc.getParameter("ID");
		String id = ids[0];
		String[] passs=reqc.getParameter("PASS");
		String pass= passs[0];

		
		AccountDao ad = new AccountDao();
		
		boolean flag = ad.checkId(id, pass);
		System.out.println(flag);
			if(flag == false) {//ユーザーフラグが0の場合
				resc.setResult("無効なアカウントです。");
				resc.setTarget("login");
			}else {//ユーザーフラグが1の場合
				Product p = ad.getUser(id, pass);
				reqc.setSessionParameter("session", p);
				resc.setTarget("start");
			}
		return resc;
	}
}
		//AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		//ProductsDao dao=factory.getProductsDao();
		//dao.addProduct(p);
		//resc.setResult(dao.getAllProducts());