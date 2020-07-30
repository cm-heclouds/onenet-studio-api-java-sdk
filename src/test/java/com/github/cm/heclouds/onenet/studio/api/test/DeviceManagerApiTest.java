package com.github.cm.heclouds.onenet.studio.api.test;

import com.alibaba.fastjson.JSON;
import com.github.cm.heclouds.onenet.studio.api.entity.common.*;
import com.github.cm.heclouds.onenet.studio.api.exception.IotClientException;
import com.github.cm.heclouds.onenet.studio.api.exception.IotServerException;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * 设备管理类-API调用单元测试
 * @author ChengQi
 * @date 2020-07-02 14:21
 */
@SuppressWarnings({"FieldCanBeLocal", "Duplicates"})
public class DeviceManagerApiTest extends ApiTest {

    private final String productId = "EWQ0uNRuUp";

    /**
     * 同步调用设备创建API
     */
    @Test
    public void testCreateDevice() {
        CreateDeviceRequest request = new CreateDeviceRequest();
        request.setProductId(productId);
        request.setDeviceName("api-sdk-device-043");
        request.setDesc("api-sdk-device-020 description");

        try {
            CreateDeviceResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用设备创建API
     */
    @Test
    public void testCreateDeviceAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        CreateDeviceRequest request = new CreateDeviceRequest();
        request.setProductId(productId);
        request.setDeviceName("api-sdk-device-009");
        request.setDesc("api-sdk-device-009 description");

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (response != null) {
                System.out.println(JSON.toJSONString(response));
            } else {
                if (cause instanceof IotServerException) {
                    IotServerException serverError = (IotServerException) cause;
                    System.err.println(serverError.getCode());
                }
                cause.printStackTrace();
            }
            latch.countDown();
        });
        latch.await();
    }

    /**
     * 同步调用设备批量创建API
     */
    @Test
    public void testBatchCreateDevices() {
        BatchCreateDevicesRequest request = new BatchCreateDevicesRequest();
        request.setProductId(productId);
        Device device1 = new Device();
        device1.setName("api-sdk-device-041");
        device1.setDesc("api-sdk-device-020 description");
        Device device2 = new Device();
        device2.setName("api-sdk-device-042");
        device2.setDesc("api-sdk-device-021 description");
        request.addDevice(device1);
        request.addDevice(device2);

        try {
            BatchCreateDevicesResponse response = client.sendRequest(request);
            System.out.println(response.getRequestId());
            response.forEach(deviceDetail -> System.out.println(JSON.toJSONString(deviceDetail)));
        } catch (IotClientException e) {
            e.printStackTrace();
        }  catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用设备批量创建API
     */
    @Test
    public void testBatchCreateDevicesAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        BatchCreateDevicesRequest request = new BatchCreateDevicesRequest();
        request.setProductId(productId);
        Device device1 = new Device();
        device1.setName("api-sdk-device-020");
        device1.setDesc("api-sdk-device-020 description");
        Device device2 = new Device();
        device2.setName("api-sdk-device-021");
        device2.setDesc("api-sdk-device-021 description");
        request.addDevice(device1);
        request.addDevice(device2);

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (cause == null) {
                System.out.println(response.getRequestId());
                response.forEach(deviceDetail -> System.out.println(JSON.toJSONString(deviceDetail)));
            } else {
                if (cause instanceof IotServerException) {
                    IotServerException serverError = (IotServerException) cause;
                    System.err.println(serverError.getCode());
                }
                cause.printStackTrace();
            }
            latch.countDown();
        });
        latch.await();
    }

    /**
     * 同步调用设备编辑API
     */
    @Test
    public void testUpdateDevice() {
        UpdateDeviceRequest request = new UpdateDeviceRequest();
        request.setProductId(productId);
        request.setDeviceName("api-sdk-device-043");
        request.setDesc("api-sdk-设备-020 描述");

        try {
            UpdateDeviceResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用设备编辑API
     */
    @Test
    public void testUpdateDeviceAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        UpdateDeviceRequest request = new UpdateDeviceRequest();
        request.setProductId(productId);
        request.setDeviceName("api-sdk-device-021");
        request.setDesc("api-sdk-设备-021 描述");

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (response != null) {
                System.out.println(JSON.toJSONString(response));
            } else {
                if (cause instanceof IotServerException) {
                    IotServerException serverError = (IotServerException) cause;
                    System.err.println(serverError.getCode());
                }
                cause.printStackTrace();
            }
            latch.countDown();
        });
        latch.await();
    }

    /**
     * 同步调用设备删除API
     */
    @Test
    public void testDeleteDevice() {
        DeleteDeviceRequest request = new DeleteDeviceRequest();
        request.setProductId(productId);
        request.setDeviceName("api-sdk-device-042");

        try {
            DeleteDeviceResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用设备删除API
     */
    @Test
    public void testDeleteDeviceAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        DeleteDeviceRequest request = new DeleteDeviceRequest();
        request.setProductId(productId);
        request.setDeviceName("api-sdk-device-012");

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (response != null) {
                System.out.println(JSON.toJSONString(response));
            } else {
                if (cause instanceof IotServerException) {
                    IotServerException serverError = (IotServerException) cause;
                    System.err.println(serverError.getCode());
                }
                cause.printStackTrace();
            }
            latch.countDown();
        });
        latch.await();
    }

    /**
     * 同步调用设备详情API
     */
    @Test
    public void testQueryDeviceDetail() {
        QueryDeviceDetailRequest request = new QueryDeviceDetailRequest();
        request.setProductId(productId);
        request.setDeviceName("api-sdk-device-001");

        try {
            QueryDeviceDetailResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用设备详情API
     */
    @Test
    public void testQueryDeviceDetailAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        QueryDeviceDetailRequest request = new QueryDeviceDetailRequest();
        request.setProductId(productId);
        request.setDeviceName("api-sdk-device-001");

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (response != null) {
                System.out.println(JSON.toJSONString(response));
            } else {
                if (cause instanceof IotServerException) {
                    IotServerException serverError = (IotServerException) cause;
                    System.err.println(serverError.getCode());
                }
                cause.printStackTrace();
            }
            latch.countDown();
        });
        latch.await();
    }
}
