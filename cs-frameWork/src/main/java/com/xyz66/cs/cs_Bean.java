package com.xyz66.cs;


import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @date 2023/11/18 22:23
 */
public class cs_Bean {
    public static void main(String[] args) {
        A_entity a = new A_entity();
        a.setName("A!");
//        a.setAge(1);
        B_entity b = new B_entity();
        BeanUtils.copyProperties(a,b);
        System.out.println(JSON.toJSONString(b));
    }
}
