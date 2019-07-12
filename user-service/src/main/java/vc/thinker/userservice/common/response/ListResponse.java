package vc.thinker.userservice.common.response;

import org.springframework.context.MessageSource;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ListResponse<T> extends AbstractResponse {
	
	public ListResponse(){
	}
	
	public ListResponse(MessageSource messageSource, HttpServletRequest request){
		super(messageSource,request);
	}
	
	private List<T> items;

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
}
