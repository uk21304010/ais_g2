package servlet;

import dto.Product;

public interface RequestContext {
    public String getCommandPath();
    public String[] getParameter(String key);
    public Object getRequest();
    public void setRequest(Object request);
	public void setSessionParameter(String string, Product p);
}
