package com.xyz66.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyz66.web.domain.entity.Message;
import com.xyz66.web.mapper.MessageMapper;
import com.xyz66.web.service.MessageService;
import org.springframework.stereotype.Service;

/**
 * @author Gjkt
 * @since 2023/12/26 15:56
 */
@Service("messageService")
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {
}
