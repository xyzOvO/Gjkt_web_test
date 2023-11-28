package ${vo.packageName};


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

<#list tableClass.importList as fieldType>${"\n"}import ${fieldType};</#list>

import java.io.Serializable;
import java.util.Date;

/**
* ${tableClass.remark!}
* @TableName ${tableClass.tableName}
*/
@Data
public class ${vo.fileName} implements Serializable {

<#list tableClass.allFields as field>
    /**
    * ${field.remark!}
    */
    @ApiModelProperty("${field.remark!}")
    private ${field.shortTypeName} ${field.fieldName};
</#list>
}
