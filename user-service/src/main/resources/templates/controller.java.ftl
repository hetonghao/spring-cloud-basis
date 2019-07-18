package ${package.Controller};

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import ${cfg.voPackage}.${cfg.pageVOName};
import ${cfg.pageResponseClass.canonicalName};
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import javax.validation.Valid;

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Api(tags = {"${table.comment!}"})
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>
    @Autowired
    private ${table.serviceName} targetService;

    @ApiOperation(value = "分页查询")
    @PostMapping("page")
    public ${cfg.pageResponseClass.simpleName} page(@RequestBody @Valid ${cfg.pageVOName} vo) {
        IPage page = vo.generatePage();
        targetService.page(page, vo);
        return new ${cfg.pageResponseClass.simpleName}().init(page);
    }


    @ApiOperation(value = "根据id查询")
    @GetMapping("{id}")
    public ${entity} detail(@PathVariable("id") Long id) {
        targetService.getById(id);
        return null;
    }

    @ApiOperation(value = "保存")
    @PatchMapping
    public ${entity} save(@RequestBody ${entity} ${entity?uncap_first}) {
        targetService.save(${entity?uncap_first});
        return null;
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Long id) {
        targetService.removeById(id);
        return null;
    }
}
</#if>
