package ${package.Controller};

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import ${cfg.voPackage}.${cfg.pageVOName};
import ${cfg.pageResponseClass.canonicalName};
import ${cfg.singleResponseClass.canonicalName};
import ${cfg.simpleResponseClass.canonicalName};
import com.baomidou.mybatisplus.core.metadata.IPage;

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
@RequestMapping("<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
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

    @PostMapping
    @ApiOperation(value = "所有数据列表查询,传入pageNumber与pageSize可分页")
    public ${cfg.pageResponseClass.simpleName} page(@RequestBody @Valid ${cfg.pageVOName} vo) {
        IPage page = vo.generatePage();
        return new ${cfg.pageResponseClass.simpleName}().init(page).setData(targetService.page(page, vo));
    }

    @GetMapping("{id}")
    @ApiOperation(value = "根据id查询")
    public ${cfg.singleResponseClass.simpleName} detail(@PathVariable("id") ${cfg.pkKeyType} id) {
        return new SingleResponse().setData(targetService.findDetail(id));
    }

    @PatchMapping
    @ApiOperation(value = "保存")
    public ${cfg.singleResponseClass.simpleName} save(@RequestBody ${entity} ${entity?uncap_first}) {
        targetService.save(${entity?uncap_first});
        return detail(${entity?uncap_first}.getId());
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除")
    public ${cfg.simpleResponseClass.simpleName} delete(@PathVariable("id") ${cfg.pkKeyType} id) {
        SimpleResponse response = new SimpleResponse();
        response.setSuccess(targetService.removeById(id));
        return response;
    }
}
</#if>
