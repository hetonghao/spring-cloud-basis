package vc.thinker.common.response;

import org.springframework.context.MessageSource;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础返回参数
 *
 * @author HeTongHao
 * @since 2019-07-03
 */
public class SimpleResponse extends AbstractResponse {

    public SimpleResponse() {

    }

    public SimpleResponse(MessageSource messageSource, HttpServletRequest request) {
        super(messageSource, request);
    }
}
