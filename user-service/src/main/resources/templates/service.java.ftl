package ${package.Service};

import ${package.Entity}.${entity};
import ${cfg.voPackage}.${cfg.pageVOName};
import ${superServiceClassPackage};
import ${cfg.boPackage}.${cfg.BOName};
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

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    ${cfg.BOName} findDetail(${cfg.pkKeyType} id);

    /**
     * 保存,逻辑处理
     *
     * @param ${entity?uncap_first}
     * @return
     */
    boolean saveData(${entity} ${entity?uncap_first});

    /**
     * 根据id删除,逻辑处理
     *
     * @param id
     * @return
     */
    boolean delete(${cfg.pkKeyType} id);
}
</#if>
