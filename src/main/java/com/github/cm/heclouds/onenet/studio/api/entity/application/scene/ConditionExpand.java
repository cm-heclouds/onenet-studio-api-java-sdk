package com.github.cm.heclouds.onenet.studio.api.entity.application.scene;

/**
 * @author ChengQi
 * @date 2020/8/13
 */
public class ConditionExpand extends Condition {

    private Ext ext;

    private Timer timer;

    public Ext getExt() {
        return ext;
    }

    public void setExt(Ext ext) {
        this.ext = ext;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
