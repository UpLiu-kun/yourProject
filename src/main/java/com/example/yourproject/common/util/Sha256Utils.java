package com.example.yourproject.common.util;

import java.security.MessageDigest;

//256加密
public class Sha256Utils {

    public static String getSHA256ToStr(String str){
        MessageDigest messageDigest;
        String resultRst = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            resultRst = byte2Hex(messageDigest.digest());
        }catch (Exception e){

        }
        return resultRst;
    }
    public static String byte2Hex(byte[] bytes){
        StringBuffer sb = new StringBuffer();
        String tempStr = null;
        for (int i=0;i<bytes.length;i++){
            tempStr = Integer.toHexString(bytes[i] & 0xFF);
            if (tempStr.length() == 1){
                sb.append("0");
            }
            sb.append(tempStr);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "111";
        System.out.println("256加密结果："+getSHA256ToStr(str));
    }
}
