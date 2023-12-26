package com.xyz66.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyz66.web.domain.entity.Message;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Gjkt
 * @since 2023/12/26 15:58
 */
@Mapper
public interface MessageMapper extends BaseMapper<Message> {
}
