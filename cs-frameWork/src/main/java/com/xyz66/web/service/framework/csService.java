package com.xyz66.web.service.framework;

import org.springframework.stereotype.Service;

/**
 * @author Gjkt
 * @since 2023/12/25 15:36
 */
@Service("csService")
public class csService {
    public boolean cs(String s) {
        System.out.println("csService.cs:"+s);
        return true;
    }
}
