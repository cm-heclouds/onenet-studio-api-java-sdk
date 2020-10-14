package com.github.cm.heclouds.onenet.studio.api;

import com.github.cm.heclouds.onenet.studio.api.auth.SignatureMethod;

/**
 * OneNET Studio profile class which is used to create {@link IotClient}
 * @see IotClient#create(IotProfile)
 * @author ChengQi
 * @date 2020-07-03 13:55
 */
public class IotProfile {

    private String userId;
    private String projectId;
    private String groupId;
    private String accessKey;
    private Integer expiredAfterHours;
    private SignatureMethod signatureMethod;

    private boolean enableSsl = false;
    private String url;

    public IotProfile userId(String userId) {
        this.userId = userId;
        return this;
    }

    public String userId() {
        return userId;
    }

    public IotProfile projectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String projectId() {
        return projectId;
    }

    public IotProfile groupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public String groupId() {
        return groupId;
    }

    public IotProfile accessKey(String accessKey) {
        this.accessKey = accessKey;
        return this;
    }

    public String accessKey() {
        return accessKey;
    }

    public IotProfile expireAfterHours(Integer expiredAfterHours) {
        this.expiredAfterHours = expiredAfterHours;
        return this;
    }

    public Integer expiredAfterHours() {
        return expiredAfterHours;
    }

    public IotProfile signatureMethod(SignatureMethod signatureMethod) {
        this.signatureMethod = signatureMethod;
        return this;
    }

    public SignatureMethod signatureMethod() {
        return signatureMethod;
    }

    public IotProfile enableSsl(boolean enableSsl) {
        this.enableSsl = enableSsl;
        return this;
    }

    public boolean enableSsl() {
        return enableSsl;
    }

    public IotProfile url(String url) {
        this.url = url;
        return this;
    }

    public String url() {
        return url;
    }
}
