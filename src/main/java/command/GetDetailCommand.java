package command;

import java.util.List;

import dao.ContentInfoDao;
import servlet.RequestContext;
import servlet.ResponseContext;

public class GetDetailCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc=getRequestContext();

		
		String[]pids=reqc.getParameter("NUM"); //NAME이랑 이름 똑같이? ? ? 
		String pid = pids[0];
		ContentInfoDao db = new ContentInfoDao();
		resc.setResult(db.showDetail(Integer.parseInt(pid)));
		resc.setTarget("detail"); //제일 마지막, WebRequest에서 마지막으로 설정한 애들 받아서, 주소록으로 보내
		
		resc.setTarget("detail"); //��懍攵 �ｧ溢ｧ��ｧ�, WebReques	t�乱��� �ｧ溢ｧ��ｧ餓愍�｡� �└��倣復 �腹�豆 �ｰ幗符���, �｣ｼ��誤｡晧愍�｡� �ｳｴ�ざ
		return resc;
			
	}

}