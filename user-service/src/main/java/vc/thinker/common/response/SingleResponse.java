package vc.thinker.common.response;

import org.springframework.context.MessageSource;

import javax.servlet.http.HttpServletRequest;

public class SingleResponse<T>  extends AbstractResponse {
	
	public SingleResponse(){
	}
	
	public SingleResponse(MessageSource messageSource, HttpServletRequest request){
		super(messageSource,request);
	}
	
	private T item;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
}
