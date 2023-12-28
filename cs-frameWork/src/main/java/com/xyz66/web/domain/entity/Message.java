package com.xyz66.web.domain.entity;

/**
 * @author Gjkt
 * @since 2023/12/26 15:52
 */
//@TableName("c_message")// 测试
//@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Message{
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
