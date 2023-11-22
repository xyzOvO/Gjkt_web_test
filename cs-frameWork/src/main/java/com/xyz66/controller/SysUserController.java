package com.xyz66.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyz66.domain.ResponseResult;
import com.xyz66.domain.entity.SysUser;
import com.xyz66.enums.AppHttpCodeEnum;
import com.xyz66.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 用户表(SysUser)表控制层
 *
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023-11-16 13:00:01
 */
@Transactional(rollbackFor = Exception.class)
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Autowired
    private SysUserService sysUserService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param sysUser 查询实体
     * @return 所有数据
     */
    @GetMapping("/selectall")
    public ResponseResult selectAll(Page<SysUser> page, SysUser sysUser) {
        return ResponseResult.okResult(this.sysUserService.page(page, new QueryWrapper<>(sysUser)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/sOne/{id}")
    public ResponseResult selectOne(@PathVariable Serializable id) {
        return ResponseResult.okResult(this.sysUserService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysUser 实体对象
     * @return 新增结果
     */
    @PostMapping("/insert")
    public ResponseResult insert(@RequestBody SysUser sysUser) {
        if (sysUser==null){
            return ResponseResult.errorResult(404,"为空，新增失败！");
        }
        this.sysUserService.save(sysUser);
        return ResponseResult.okResult(sysUser);
    }

    /**
     * 修改数据
     *
     * @param sysUser 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    public ResponseResult update(@RequestBody SysUser sysUser) {
        return ResponseResult.okResult(this.sysUserService.updateById(sysUser));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("/delete")
    public ResponseResult delete(@RequestParam("idList") List<Long> idList) {
        return ResponseResult.okResult(this.sysUserService.removeByIds(idList));
    }

    /**
     * 测试MybtaisPlus的Lambda查询
     * @param id
     * @return 查询结果
     */
    @PostMapping("/cs1")
    public ResponseResult filter(@RequestParam("cs1") String id){
        List<SysUser> sysUserList =sysUserService.lambdaQuery()
                // 相当于whrere id = id
                .eq(SysUser::getId,id)
                .list();
        return ResponseResult.okResult(sysUserList);
    }
    @PostMapping("/cs2")
    public ResponseResult filter2(@RequestParam("cs") String id){
        List<SysUser> sysUserList =sysUserService.lambdaQuery()
                .between(SysUser::getId,0,id)
                .list();
        return ResponseResult.okResult(sysUserList);
    }
    @PostMapping("/cs3")
    public ResponseResult filter3(@RequestParam("cs") String id){
        List<SysUser> sysUserList =sysUserService.lambdaQuery()
                // 模糊查询
                .like(SysUser::getId,id)
                .list();
        return ResponseResult.okResult(sysUserList);
    }
    @PostMapping("/cs4")
    public ResponseResult filter4(@RequestParam("cs") String id){
        List<SysUser> sysUserList =sysUserService.lambdaQuery()
                // ID降序
                .orderByDesc(SysUser::getId)
                .list();
        return ResponseResult.okResult(sysUserList);
    }
    @PostMapping("/cs5/{id}")
    public ResponseResult filter5(@PathVariable("id") String id){
        List<SysUser> sysUserList =sysUserService.lambdaQuery()
                // 大于
                .ge(SysUser::getId,id)
                .list();
        return ResponseResult.okResult(sysUserList);
    }

}

