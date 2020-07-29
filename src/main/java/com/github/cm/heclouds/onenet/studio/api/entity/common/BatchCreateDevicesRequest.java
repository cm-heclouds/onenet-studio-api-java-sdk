package com.github.cm.heclouds.onenet.studio.api.entity.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备批量创建请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/common/batchCreateDevice.html">设备批量创建</>
 * @author ChengQi
 * @date 2020-07-03 15:06
 */
public class BatchCreateDevicesRequest extends BaseCommonRequest<BatchCreateDevicesResponse> {

    private List<Device> devices = new ArrayList<>();

    public BatchCreateDevicesRequest() {
        super(Method.POST, "BatchCreateDevices");
    }

    /**
     * 设置批量创建的设备信息集合
     * @param devices 批量创建的设备信息集合
     */
    public void setDevices(List<Device> devices) {
        this.devices = devices;
        bodyParam("devices", this.devices);
    }

    /**
     * 添加要批量创建的设备
     * @param device 设备信息
     */
    public void addDevice(Device device) {
        devices.add(device);
        bodyParam("devices", devices);
    }

    @Override
    protected Class<BatchCreateDevicesResponse> getResponseType() {
        return BatchCreateDevicesResponse.class;
    }

    @Override
    protected BatchCreateDevicesResponse newResponse(String responseBody) {
        BatchCreateDevicesResponse response = new BatchCreateDevicesResponse();
        JSONObject jsonObject = JSON.parseObject(responseBody);
        List<DeviceDetail> deviceDetails = JSON.parseArray(jsonObject.getString("list"), DeviceDetail.class);
        response.addAll(deviceDetails);
        return response;
    }
}
