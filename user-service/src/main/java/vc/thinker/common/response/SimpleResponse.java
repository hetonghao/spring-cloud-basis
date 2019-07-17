package vc.thinker.common.response;

import org.springframework.context.MessageSource;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础返回
 * @author james
 *
 */
public  class SimpleResponse extends AbstractResponse {
	
	public SimpleResponse(){
		
	}
	
	public SimpleResponse(MessageSource messageSource, HttpServletRequest request){
		super(messageSource,request);
	}
}
