package com.xyz66.cs;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @date 2023/11/18 22:47
 */
public class cs_MapStruct {

//    @Autowired
//    private AToBConverter converter;

    @Test
    public void cs_1() {
        A_entity a = new A_entity();
        a.setName("A!");
        a.setAge(17);
        System.out.println(JSON.toJSONString(a));
        // 通过Mappers工程获取AToBConverter
        AToBConverter mapper = Mappers.getMapper(AToBConverter.class);
        B_entity b = mapper.toB_entity(a);
        System.out.println(JSON.toJSONString(b));
    }
    @Test
    public void cs_2() {
        B_entity b = new B_entity();

    }
}
