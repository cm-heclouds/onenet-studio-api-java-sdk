package com.github.cm.heclouds.onenet.studio.api.auth;

/**
 * @author ChengQi
 * @date 2020-07-02 17:08
 */
public class Signature {

    String version;
    String res;
    long et;
    SignatureMethod method;

    public Signature(String version, String res, long et, SignatureMethod method) {
        this.version = version;
        this.res = res;
        this.et = et;
        this.method = method;
    }

    public String sign(String accessKey) throws Exception{
        String forSignature = et + "\n" + method.getMethodName() + "\n" + res + "\n" + version;
        return HmacUtil.base64Encrypt(method, accessKey, forSignature);
    }
}
