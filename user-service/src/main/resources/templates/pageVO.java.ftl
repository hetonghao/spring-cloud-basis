package ${cfg.voPackage};

<#if swagger2>
import io.swagger.annotations.ApiModel;
</#if>
<#if entityLombokModel>
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
</#if>
<#if cfg.superPageVOClass??>
import ${cfg.superPageVOClass.canonicalName};
</#if>

/**
 * <p>
 * ${table.comment!}
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if entityLombokModel>
@Data
    <#if superEntityClass??>
@EqualsAndHashCode(callSuper = true)
    <#else>
@EqualsAndHashCode(callSuper = false)
    </#if>
@Accessors(chain = true)
</#if>
<#if swagger2>
@ApiModel(value = "${entity}PageVO对象", description = "${table.comment!}")
</#if>
<#if cfg.superPageVOClass??>
public class ${cfg.pageVOName} extends ${cfg.superPageVOClass.simpleName} {
<#else>
public class ${cfg.pageVOName} {
</#if>
}