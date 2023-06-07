package command;

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
		resc.setTarget("detail"); //제일 마지막, WebReques	t에서 마지막으로 설정한 애들 받아서, 주소록으로 보내
		return resc;
	}
}