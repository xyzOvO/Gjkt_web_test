package com.xyz66.json;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Gjkt
 * @description
 * @since 2023/12/28 15:57
 */
@Log4j2
public class JacksonTest {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test1() throws JsonProcessingException {
        // JacksonTest-json键值对，不匹配或多于实体类字段
//        String jsonString = "{\"name\":\"张三\",\"age\":18}";
        String jsonString = "{\"name\":\"张三\",\"age\":18,\"cs\":\"雪豹闭嘴\"}";
        log.info(jsonString);
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.readValue(jsonString, Student.class);
        log.info(student);
    }
}
