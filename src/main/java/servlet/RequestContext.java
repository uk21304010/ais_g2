package servlet;

import java.util.Map;

import dto.Product;

public interface RequestContext {
    public String getCommandPath();
    public String[] postParameter(String key);
    public String[] getParameter(String key);
    public Object getRequest();
    public void setRequest(Object request);
	public void setSessionParameter(String string, Product p);
	public boolean uploadFile();
	public String getFileName();
	public Map<String, String[]> getPostParameter();
}
