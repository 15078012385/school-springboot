package com.atguigu.schoolspringboot.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//加密
public final class MD5 {

    private static String salt = "Make in xiaochen";
    public static void main(String[] args) {
        System.out.println(MD5.encrypt(salt + 12345 + salt));

    }

    public static String encrypt(String strSrc) {
        try {
            char hexChars[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
                    '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            byte[] bytes = strSrc.getBytes();

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(bytes);
            bytes = md.digest();
            int j = bytes.length;
//            32位的MD5值
            char[] chars = new char[j * 2];
            int k = 0;
//            加密过程
            for (int i = 0; i < bytes.length; i++) {
                byte b = bytes[i];
                chars[k++] = hexChars[b >>> 4 & 0xf];
                chars[k++] = hexChars[b & 0xf];
            }

            return new String(chars);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("MD5加密出错！！+" + e);
        }

    }


}
