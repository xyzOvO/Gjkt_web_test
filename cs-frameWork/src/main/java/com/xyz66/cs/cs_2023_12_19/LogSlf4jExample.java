package com.xyz66.cs.cs_2023_12_19;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogSlf4jExample {
    public static void main(String[] args) {
        log.info("level:{}","info");
        log.warn("level:{}","warn");
        log.error("level:{}", "error");
    }
}
