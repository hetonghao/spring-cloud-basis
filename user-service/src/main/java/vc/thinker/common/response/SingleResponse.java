package vc.thinker.common.response;

import org.springframework.context.MessageSource;

import javax.servlet.http.HttpServletRequest;

/**
 * 单个对象返回参数
 *
 * @author HeTongHao
 * @since 2019-07-03
 */
public class SingleResponse<T> extends AbstractResponse {

    public SingleResponse() {
    }

    public SingleResponse(MessageSource messageSource, HttpServletRequest request) {
        super(messageSource, request);
    }

    private T item;

    public T getItem() {
        return item;
    }

    public SingleResponse setItem(T item) {
        this.item = item;
        return this;
    }
}
