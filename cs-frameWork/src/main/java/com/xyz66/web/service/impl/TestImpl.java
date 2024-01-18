package com.xyz66.web.service.impl;

import com.xyz66.web.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author Gjkt
 * @description
 * @since 2024/1/18 18:31
 */
@Service("testService")
public class TestImpl implements TestService {
    @Override
    public String test() {
        return "Hello-World,233";
    }
}
