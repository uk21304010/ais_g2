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
		
		boolean flag = ad.checkId(pass, id);
		System.out.println(flag);
			if(flag == false) {//���[�U�[�t���O��0�̏ꍇ
				resc.setResult("�����ȃA�J�E���g�ł��B");
				resc.setTarget("login");
			}else {//���[�U�[�t���O��1�̏ꍇ
				Product p = ad.getUser(pass, id);
				reqc.setSessionParameter("user", p);
				resc.setTarget("view");
			}
		return resc;
	}
}
		//AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		//ProductsDao dao=factory.getProductsDao();
		//dao.addProduct(p);
		//resc.setResult(dao.getAllProducts());