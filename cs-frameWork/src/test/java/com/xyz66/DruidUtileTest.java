package com.xyz66;

import com.xyz66.utils.DruidUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
public class DruidUtileTest {
    private static DataSource dataSource = DruidUtils.getDataSource(); //得到连接池对象

    @Test
    public void test(){
        System.out.println(dataSource);
    }
}
