package com.xyz66.cs;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @date 2023/11/18 22:54
 */

//@Mapper(componentModel = "spring")
@Mapper
public interface AToBConverter {

    @Named("isAge")
    default Boolean isTrue(Integer age){
        return age!= null && age > 18;
    }
    //    @Mapping(target = "age",constant = "18")
    @Mapping(target = "ageFlag", source = "age", qualifiedByName = "isAge")
    B_entity toB_entity(A_entity a_entity);// 字段：name,age
}
