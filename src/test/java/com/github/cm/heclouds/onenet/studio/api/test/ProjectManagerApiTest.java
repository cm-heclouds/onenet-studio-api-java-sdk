package com.github.cm.heclouds.onenet.studio.api.test;

import com.alibaba.fastjson.JSON;
import com.github.cm.heclouds.onenet.studio.api.entity.application.project.*;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.From;
import com.github.cm.heclouds.onenet.studio.api.exception.IotClientException;
import com.github.cm.heclouds.onenet.studio.api.exception.IotServerException;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * 应用开发类-项目管理API调用单元测试
 * @author ChengQi
 * @date 2020-07-06 14:08
 */
@SuppressWarnings("Duplicates")
public class ProjectManagerApiTest extends ApiTest {

    private final String projectId = "rYEt9n";

    /**
     * 同步调用项目概况API
     */
    @Test
    public void testQueryStatistics() {
        QueryStatisticsRequest request = new QueryStatisticsRequest();
        request.setProjectId(projectId);

        try {
            QueryStatisticsResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用项目概况API
     */
    @Test
    public void testQueryStatisticsAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        QueryStatisticsRequest request = new QueryStatisticsRequest();
        request.setProjectId(projectId);

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
     * 同步调用项目集成产品列表API
     */
    @Test
    public void testQueryProductList() {
        QueryProductListRequest request = new QueryProductListRequest();
        request.setProjectId(projectId);
        request.setOffset(0);
        request.setLimit(10);

        try {
            QueryProductListResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用项目集成产品列表API
     */
    @Test
    public void testQueryProductListAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        QueryProductListRequest request = new QueryProductListRequest();
        request.setProjectId(projectId);
        request.setOffset(0);
        request.setLimit(10);

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
     * 同步调用项目集成设备列表API
     */
    @Test
    public void testQueryDeviceList() {
        QueryDeviceListRequest request = new QueryDeviceListRequest();
        request.setProjectId(projectId);
//        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-00");
        request.setFrom(From.CREATED_AUTONOMY);
        request.setOffset(0);
        request.setLimit(10);

        try {
            QueryDeviceListResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用项目集成设备列表API
     */
    @Test
    public void testQueryDeviceListAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        QueryDeviceListRequest request = new QueryDeviceListRequest();
        request.setProjectId(projectId);

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
     * 同步调用项目添加设备API
     */
    @Test
    public void testAddDevice() {
        AddDeviceRequest request = new AddDeviceRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.addDevice("api-sdk-device-011");

        try {
            AddDeviceResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用项目添加设备API
     */
    @Test
    public void testAddDeviceAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        AddDeviceRequest request = new AddDeviceRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.addDevice("api-sdk-device-011");

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (cause == null) {
                System.out.println(response.getRequestId());
                response.forEach(errorData -> System.out.println(JSON.toJSONString(errorData)));
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
     * 同步调用项目移除设备API
     */
    @Test
    public void testRemoveDevice() {
        RemoveDeviceRequest request = new RemoveDeviceRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.addDevice("api-sdk-device-011");

        try {
            RemoveDeviceResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用项目移除设备API
     */
    @Test
    public void testRemoveDeviceAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        RemoveDeviceRequest request = new RemoveDeviceRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.addDevice("api-sdk-device-011");

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (cause == null) {
                System.out.println(response.getRequestId());
                response.forEach(errorData -> System.out.println(JSON.toJSONString(errorData)));
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
