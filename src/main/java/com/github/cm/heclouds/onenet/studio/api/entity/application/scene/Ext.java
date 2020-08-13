package com.github.cm.heclouds.onenet.studio.api.entity.application.scene;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.ExtType;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderDeserializer;

/**
 * @author ChengQi
 * @date 2020/8/13
 */
public class Ext {

    @JSONField(name = "ad_code")
    private String adCode;

    @JSONField(deserializeUsing = ValueHolderDeserializer.class)
    private ExtType type;

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public ExtType getType() {
        return type;
    }

    public void setType(ExtType type) {
        this.type = type;
    }
}
