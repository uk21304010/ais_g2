package command;

import dao.ContentInfoDao;
import servlet.RequestContext;
import servlet.ResponseContext;

public class GetDetailCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc=getRequestContext();

		String[]pids=reqc.getParameter("NUM"); //NAME�擽�梠 �擽�ｦ� ��滝ｰ呷擽? ? ? 
		String pid = pids[0];
		
		ContentInfoDao db = new ContentInfoDao();
		resc.setResult(db.showDetail(Integer.parseInt(pid)));
		resc.setTarget("detail"); //��懍攵 �ｧ溢ｧ��ｧ�, WebReques	t�乱��� �ｧ溢ｧ��ｧ餓愍�｡� �└��倣復 �腹�豆 �ｰ幗符���, �｣ｼ��誤｡晧愍�｡� �ｳｴ�ざ
		return resc;
	}
}