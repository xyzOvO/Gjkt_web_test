package com.xyz66.web.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author Gjkt
 * @since 2023/12/26 15:52
 */
@TableName("c_message")
public class Message {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
