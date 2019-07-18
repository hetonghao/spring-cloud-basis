package ${package.Service};

import ${package.Entity}.${entity};
import ${cfg.voPackage}.${cfg.pageVOName};
import ${superServiceClassPackage};
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
     * 根据VO分页查询
     *
     * @param page
     * @param vo
     * @return
     */
    List page(IPage page, ${cfg.pageVOName} vo);
}
</#if>
