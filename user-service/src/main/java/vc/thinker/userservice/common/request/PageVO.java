package vc.thinker.userservice.common.request;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 通用分页参数
 *
 * @author HeTongHao
 * @since 2019-07-03
 */
@Data
@Accessors(chain = true)
public class PageVO {
    public PageVO() {
        pageNumber = 1;
        pageSize = 10;
    }

    @ApiModelProperty("页码")
    private Integer pageNumber;
    @ApiModelProperty("每页数据")
    private Integer pageSize;

    /**
     * 生成分页组件
     *
     * @return
     */
    public IPage generatePage() {
        return new Page(pageNumber, pageSize);
    }
}
