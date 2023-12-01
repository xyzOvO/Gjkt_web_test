package com.xyz66.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyz66.web.domain.ResponseResult;
import com.xyz66.web.domain.entity.Link;
import com.xyz66.web.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 友链(Link)表控制层
 *
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023-11-28 15:53:54
 */
@RestController
@RequestMapping("/link")
public class LinkController {
    /**
     * 服务对象
     */
    @Autowired
    private LinkService linkService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param link 查询实体
     * @return 所有数据
     */
    @GetMapping
    public ResponseResult selectAll(Page<Link> page, Link link) {
        return ResponseResult.okResult(this.linkService.page(page, new QueryWrapper<>(link)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseResult selectOne(@PathVariable Serializable id) {
        return ResponseResult.okResult(this.linkService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param link 实体对象
     * @return 新增结果
     */
    @PostMapping
    public ResponseResult insert(@RequestBody Link link) {
        return ResponseResult.okResult(this.linkService.save(link));
    }

    /**
     * 修改数据
     *
     * @param link 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ResponseResult update(@RequestBody Link link) {
        return ResponseResult.okResult(this.linkService.updateById(link));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ResponseResult delete(@RequestParam("idList") List<Long> idList) {
        return ResponseResult.okResult(this.linkService.removeByIds(idList));
    }
}

