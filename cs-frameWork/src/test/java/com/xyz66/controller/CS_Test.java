package com.xyz66.controller;

import com.xyz66.config.DayBeanConfig;
import com.xyz66.prop.DayBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023/12/2 14:42
 */
@SpringBootTest
public class CS_Test {

    @Value("${cs.startTime}")
    private String startTime;
    @Value("${cs.endTime}")
    private String endTime;

    @Test
    public void test() {
        // 测试读取配置文件
        System.out.println(
                "开始时间:" + startTime + "\n" +
                        "结束时间:" + endTime);
        // 将时间戳转换为正常时间
        Date stime = new Date(new Long(startTime));
        Date etime = new Date(new Long(endTime));
        // 转成yyyy-MM-dd HH:mm:ss格式
        String stime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(stime);
        String etime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(etime);
        System.out.println(stime1+"\n"+etime1);
    }
    @Resource// 读取配置文件资源
    DayBeanConfig dayBeanConfig;
    @Test
    public void test1() {
        // 测试读取配置文件
        DayBean dayBean = dayBeanConfig.getDayBean();
        System.out.println(dayBean.getStartTime());
        System.out.println(dayBean.getEndTime());
    }
}
