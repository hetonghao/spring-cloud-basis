package vc.thinker.common.response;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.MessageSource;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 分页返回参数
 *
 * @author HeTongHao
 * @since 2019-07-03
 */
@Data
@Accessors(chain = true)
public class PageResponse<T> extends AbstractResponse {
    public PageResponse() {
    }

    public PageResponse(MessageSource messageSource, HttpServletRequest request) {
        super(messageSource, request);
    }

    private List<T> data;

    private Boolean first;

    private Boolean last;

    private Long number;

    private Long size;

    private Long totalElements;

    private Long totalPages;

    private LocalDateTime queryTime = LocalDateTime.now();

    /**
     * 将Mybatis-Plus分页插件的结果赋给PageResponse
     *
     * @param page
     * @return this
     */
    public PageResponse init(IPage page) {
        if (page != null) {
            data = page.getRecords();
            number = page.getCurrent();
            size = page.getSize();
            totalPages = page.getPages();
            totalElements = page.getTotal();
            first = number.equals(1L);
            last = totalPages.equals(number);
        }
        return this;
    }
}
