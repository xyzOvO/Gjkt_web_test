package com.xyz66.redis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023/12/3 11:59
 */

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable{
    private String name;
    private Integer age;
}
