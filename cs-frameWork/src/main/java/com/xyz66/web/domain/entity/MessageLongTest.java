package com.xyz66.web.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Gjkt
 * @since 2023/12/26 15:52
 */
@TableName("c_message")// 测试
@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageLongTest {
    
    @NotBlank(message = "雪豹闭嘴！")
    @Size(min = 1, max = 20, message = "雪豹闭嘴！")
    private Long message;
    
//    private String name;
}
