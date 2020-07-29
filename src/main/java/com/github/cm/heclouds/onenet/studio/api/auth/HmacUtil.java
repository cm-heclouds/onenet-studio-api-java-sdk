package com.github.cm.heclouds.onenet.studio.api.auth;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * The utils for signature algorithm. supports md5,sha1 and sha256
 * @author ChengQi
 * @date 2020-07-02 15:35
 */
public class HmacUtil {

    private HmacUtil() {}

    public static byte[] encrypt(SignatureMethod method, String encryptKey, String encryptText)
            throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKey secretKey = method.generateSecretKey(encryptKey);
        Mac mac = Mac.getInstance(method.getMacName());
        mac.init(secretKey);
        return mac.doFinal(encryptText.getBytes());
    }

    public static String base64Encrypt(SignatureMethod method, String encryptKey, String encryptText)
            throws InvalidKeyException, NoSuchAlgorithmException {
        byte[] encryptedBytes = encrypt(method, encryptKey, encryptText);
        return new String(Base64.getEncoder().encode(encryptedBytes));
    }
}
