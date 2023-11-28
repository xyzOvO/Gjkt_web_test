package ${updateDTO.packageName};

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
<#list tableClass.importList as fieldType>${"\n"}import ${fieldType};</#list>
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;

/**
* ${tableClass.remark!}
* @TableName ${tableClass.tableName}
*/
@Data
public class ${updateDTO.fileName} implements Serializable {

<#list tableClass.allFields as field>
    /**
    * ${field.remark!}
    */<#if !field.nullable || field.jdbcType=="VARCHAR">${"\n    "}</#if><#if !field.nullable><#if field.jdbcType=="VARCHAR">@NotBlank(message="[${field.remark!}]不能为空")<#else>@NotNull(message="[${field.remark!}]不能为空")</#if></#if><#if field.jdbcType=="VARCHAR"><#if !field.nullable>${"\n    "}</#if>@Size(max= ${field.columnLength?c},message="${field.remark!}长度不能超过${field.columnLength?c}")</#if>
    @ApiModelProperty("${field.remark!}")
    private ${field.shortTypeName} ${field.fieldName};
</#list>
}
