package com.xyz66.utils;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023/11/29 9:34
 */
public class Oss {
    
    @Test
    public void cs1() throws Exception {
        // 测试使用md5
        File d = new File("C:\\Users\\古井枯塘\\Desktop\\测试\\md5.txt");
        if (!d.exists()){
            d.createNewFile();
        }
        // 第一次测试:d41d8cd98f00b204e9800998ecf8427e
        // 第二次测试:d41d8cd98f00b204e9800998ecf8427e
        // 第三次改名测试:d41d8cd98f00b204e9800998ecf8427e
        // 自带文件转换为MultipartFile
        byte[] fileContent = StreamUtils.copyToByteArray(d.toURI().toURL().openStream());
        MultipartFile multipartFile = new MockMultipartFile(d.getName(), fileContent);
        d.createNewFile();// 创建文件
        String fileMD5 = getFileMD5(multipartFile);
        System.out.println(fileMD5);
    }
    private String getFileMD5(MultipartFile file) throws Exception {
        byte[] fileBytes = file.getBytes();  // 获取文件的字节数组
        MessageDigest md5 = MessageDigest.getInstance("MD5");  // 获取MD5消息摘要实例
        byte[] digest = md5.digest(fileBytes);  // 对文件字节数组进行MD5哈希运算
        return new BigInteger(1, digest).toString(16);  // 将结果转换为十六进制字符串并返回
    }
}
