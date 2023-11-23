package com.xyz66.cs.cs3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @date 2023/11/23 15:47
 */
public class cs1 {
    @Mock
    cs cs;

    @Test
    public void cs1() {
//        when(cs.cs1()).thenReturn(1);
        cs cs1 = new csImpl();
//        System.out.println(cs.cs1());
        assert cs1.cs1() == 1;
    }
}
