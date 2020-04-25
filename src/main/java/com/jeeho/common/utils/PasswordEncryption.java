package com.jeeho.common.utils;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.digests.MD5Digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Jeeho
 * 密码加密工具类
 */
public class PasswordEncryption {

    public final static String ALGORITHM_MD5  = "MD5";
    public final static String ALGORITHM_SHA  = "SHA";
    public final static String ALGORITHM_MAC  = "MAC";

    //Base64 编码方式

    /**
     * JDK MD5加密
     * @param password
     * @return
     */
    public static String entryPasswordByJDK(String password){
        byte[] md5Bytes = null;
        try {
            MessageDigest digest = MessageDigest.getInstance(ALGORITHM_MD5);
            md5Bytes = digest.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return Hex.encodeHexString(md5Bytes);
    }

    /**
     * commons codec md5 加密
     * @param password
     * @return
     */
    public static String entryPasswordByCc(String password){
        return DigestUtils.md5Hex(password.getBytes());
    }

    /**
     * Bouncy castle MD5密码加密
     * @param password
     * @return
     */
    public static String entryPasswordByBc(String password){
        MD5Digest digest = new MD5Digest();
        digest.update(password.getBytes(),0,password.getBytes().length);
        byte[] md5Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(md5Bytes,0);
        return org.bouncycastle.util.encoders.Hex.toHexString(md5Bytes);
    }

    //SHA 消息摘要加密算法

    //MAC 散列消息摘要算法

    //对称加密算法

    //非对称加密算法

    public static void main(String args[]){
        System.out.println("JDK MD5 : " + PasswordEncryption.entryPasswordByJDK("123456"));
        System.out.println("Bc MD5 : " + PasswordEncryption.entryPasswordByBc("123456"));
        System.out.println("Cc MD5 : " + PasswordEncryption.entryPasswordByCc("123456"));
    }
}
