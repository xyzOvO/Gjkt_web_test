package com.xyz66.cs.cs2023年11月24日;

import com.alibaba.fastjson.JSON;
import io.swagger.models.auth.In;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @date 2023/11/24 9:38
 */
public class cs1 {
    @Test
    public void cs1() {
        // 返回一个空列表
        List<Object> objects = Collections.emptyList();
//        System.out.println(JSON.toJSONString(objects));
        // 测试Optional(java8特性)
        List<String> slist = new ArrayList<>();
        slist.add("2");
//        System.out.println(Optional.ofNullable(Stream.of(slist).collect(Collectors.toList())));// Optional[[[2]]]
//        System.out.println(Optional.ofNullable(slist));// Optional[[2]]
//        System.out.println(Optional.ofNullable(null));
        // 2
        List<String> nullList = null;
        // 为空返回空数组
        List<String> list = Optional.ofNullable(slist)
                .orElse(Collections.emptyList());
//        System.out.println(list);
//        System.out.println(Optional.ofNullable(slist).get());
        // CollectionUtils.isEmpty 判断集合是否为空
        System.out.println(CollectionUtils.isEmpty(slist));
    }
    @Test
    public void cs2(){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6,7,8,10);
        Map<Integer, Integer> map = list.stream()
                .collect(Collectors.toMap(Function.identity(), Function.identity(), (a, b) -> a));
        System.out.println(JSON.toJSONString(map));
    }
}
