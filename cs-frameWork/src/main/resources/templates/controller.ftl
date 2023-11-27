package com.dcqc.web.controller;

import com.dcqc.common.core.controller.BaseController;
import com.dcqc.common.core.domain.R;
import com.dcqc.common.core.page.TableDataInfo;
import com.dcqc.web.domain.dto.${addDTO.fileName};
import com.dcqc.web.domain.dto.${updateDTO.fileName};
import com.dcqc.web.domain.vo.${vo.fileName};
import com.dcqc.web.domain.${tableClass.shortClassName};
import com.dcqc.web.service.${serviceInterface.fileName};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import com.dcqc.common.utils.bean.BeanUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* @author ${author!}
* @description 针对表【${tableClass.tableName}<#if tableClass.remark?has_content>(${tableClass.remark!})</#if>】的表控制层
* @createDate ${.now?string('yyyy-MM-dd HH:mm:ss')}
*/
@Valid
@AllArgsConstructor
@Api(tags = "<#if tableClass.remark?has_content>${tableClass.remark!}</#if>")
@RequestMapping("/${tableClass.shortClassName?uncap_first}")
public class ${controller.fileName} extends BaseController{

private final ${serviceInterface.fileName} service;

/**
* 条件分页查询信息
*
* @param condition 搜索条件
*/
@ApiOperation(value = "条件分页查询列表查询", produces = MediaType.APPLICATION_JSON_VALUE)
@GetMapping("page")
public TableDataInfo
<List<${tableClass.shortClassName}>> pageList(${tableClass.shortClassName} condition) {
List<${tableClass.shortClassName}> list = service.lambdaQuery()
.list();
return getDataTable(list);
}

/**
* 通过主键查询单条数据
*
* @param id 主键
* @return 单条数据
*/
@ApiOperation(value = "通过主键查询单条数据", produces = MediaType.APPLICATION_JSON_VALUE)
@GetMapping("getById/{id}")
public R<${vo.fileName}> getById(@PathVariable("id") String id) {
${tableClass.shortClassName} source = this.service.getById(id);
${vo.fileName} target = null;
if (source != null) {
target = new ${vo.fileName}();
BeanUtils.copyProperties(source, target);
}
return R.ok(target, "获取成功!");
}

/**
* 新增单条数据
*
* @param dto 主键
* @return 单条数据
*/
@ApiOperation(value = "新增单条数据", produces = MediaType.APPLICATION_JSON_VALUE)
@PostMapping("add")
public R add(@RequestBody ${addDTO.fileName} dto) {
${tableClass.shortClassName} entity = new ${tableClass.shortClassName}();
BeanUtils.copyProperties(dto, entity);
if (this.service.save(entity)) {
return R.ok(entity, "新增成功!");
} else {
return R.fail("新增失败!");
}
}

/**
* 通过主键编辑单条数据
*
* @param dto 主键
* @return 单条数据
*/
@ApiOperation(value = "通过主键编辑单条数据", produces = MediaType.APPLICATION_JSON_VALUE)
@PutMapping("update")
public R update(@RequestBody ${updateDTO.fileName} dto) {
if (dto.getId() == null) {
return R.fail("主键值为空,无法修改!");
}
if (this.service.lambdaQuery().eq(${tableClass.shortClassName}::getId, dto.getId()).count() <= 0) {
return R.fail("数据记录不存在,无法修改!");
}
${tableClass.shortClassName} entity = new ${tableClass.shortClassName}();
BeanUtils.copyProperties(dto, entity);
if (this.service.updateById(entity)) {
return R.ok(this.service.getById(dto.getId()), "修改成功!");
} else {
return R.fail("修改失败!");
}
}

/**
* 通过主键删除单条数据
*
* @param id 主键
* @return 单条数据
*/
@ApiOperation(value = "通过主键删除单条数据", produces = MediaType.APPLICATION_JSON_VALUE)
@DeleteMapping("deleteById")
public R
<Boolean> deleteById(String id) {
    if (this.service.lambdaQuery().eq(${tableClass.shortClassName}::getId, id).count()<=0) {
    return R.fail(Boolean.FALSE,"数据记录不存在,无法删除!");
    }
    if (this.service.removeById(id)) {
    return R.ok(Boolean.TRUE, "删除成功!");
    } else {
    return R.fail(Boolean.FALSE, "删除失败!");
    }
    }
    }