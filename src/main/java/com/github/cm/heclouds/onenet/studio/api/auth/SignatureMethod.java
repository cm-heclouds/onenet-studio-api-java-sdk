package com.github.cm.heclouds.onenet.studio.api.auth;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.function.Function;

/**
 * The enum object of Hmac algorithm
 * @author ChengQi
 * @date 2020-07-02 15:38
 */
public enum SignatureMethod {

    /**
     * HmacMD5
     */
    MD5("HmacMD5", "md5"),
    /**
     * HmacSHA1
     */
    SHA1("HmacSHA1", "sha1"),
    /**
     * HmacSHA256
     */
    SHA256("HmacSHA256", "sha256");

    private String macName;
    private String methodName;
    private Function<String, byte[]> decodeFunc = encryptKey -> Base64.getDecoder().decode(encryptKey);

    SignatureMethod(String macName, String methodName) {
        this.macName = macName;
        this.methodName = methodName;
    }

    public String getMacName() {
        return macName;
    }

    public String getMethodName() {
        return methodName;
    }

    public SecretKey generateSecretKey(String encryptKey) {
        return new SecretKeySpec(decodeFunc.apply(encryptKey), macName);
    }
}
