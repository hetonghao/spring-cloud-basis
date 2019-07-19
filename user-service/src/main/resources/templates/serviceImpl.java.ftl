package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${cfg.voPackage}.${cfg.pageVOName};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${cfg.boPackage}.${cfg.BOName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Override
    public List page(IPage page, ${cfg.pageVOName} vo) {
        return baseMapper.page(page, vo);
    }

    @Override
    public ${cfg.BOName} findDetail(${cfg.pkKeyType} id) {
        return baseMapper.findDetail(id);
    }
}
</#if>
