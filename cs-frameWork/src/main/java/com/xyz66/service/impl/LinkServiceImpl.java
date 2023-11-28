package com.xyz66.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyz66.mapper.LinkMapper;
import com.xyz66.domain.entity.Link;
import com.xyz66.service.LinkService;
import org.springframework.stereotype.Service;

/**
 * 友链(Link)表服务实现类
 *
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023-11-28 15:53:55
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

}

