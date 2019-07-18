package ${package.Mapper};

import org.apache.ibatis.annotations.Param;
import ${package.Entity}.${entity};
import ${superMapperClassPackage};
import ${cfg.voPackage}.${cfg.pageVOName};
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * ${table.comment!} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {
    /**
    * 根据VO分页查询
    *
    * @param page
    * @param vo
    * @return
    */
    List page(@Param("page") IPage page, @Param("vo") ${cfg.pageVOName} vo);
}
</#if>
