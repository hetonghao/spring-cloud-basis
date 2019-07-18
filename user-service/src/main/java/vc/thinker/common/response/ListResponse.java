package vc.thinker.common.response;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.MessageSource;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 列表返回参数
 *
 * @author HeTongHao
 * @since 2019-07-03
 */
@Data
@Accessors(chain = true)
public class ListResponse<T> extends AbstractResponse {

    public ListResponse() {
    }

    public ListResponse(MessageSource messageSource, HttpServletRequest request) {
        super(messageSource, request);
    }

    private List<T> items;
}
