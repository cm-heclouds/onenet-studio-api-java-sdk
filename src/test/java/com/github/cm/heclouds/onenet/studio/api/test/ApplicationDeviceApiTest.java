package com.github.cm.heclouds.onenet.studio.api.test;

import com.alibaba.fastjson.JSONObject;
import com.github.cm.heclouds.onenet.studio.api.entity.application.device.*;
import com.github.cm.heclouds.onenet.studio.api.entity.common.QueryDeviceDetailResponse;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.EventType;
import com.github.cm.heclouds.onenet.studio.api.enums.Sort;
import com.github.cm.heclouds.onenet.studio.api.exception.IotClientException;
import com.github.cm.heclouds.onenet.studio.api.exception.IotServerException;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author ChengQi
 * @date 2020-07-06 16:27
 */
@SuppressWarnings("Duplicates")
public class ApplicationDeviceApiTest extends ApiTest {

    private final String projectId = "rYEt9n";

    @Test
    public void testQueryDeviceDetail() {
        QueryDeviceDetailRequest request = new QueryDeviceDetailRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");

        try {
            QueryDeviceDetailResponse response = client.sendRequest(request);
            System.out.println(JSONObject.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryDeviceDetailAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        QueryDeviceDetailRequest request = new QueryDeviceDetailRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (response != null) {
                System.out.println(JSONObject.toJSONString(response));
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

    @Test
    public void testQueryDeviceStatus() {
        QueryDeviceStatusRequest request = new QueryDeviceStatusRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");

        try {
            QueryDeviceStatusResponse response = client.sendRequest(request);
            System.out.println(JSONObject.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryDeviceStatusAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        QueryDeviceStatusRequest request = new QueryDeviceStatusRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (response != null) {
                System.out.println(JSONObject.toJSONString(response));
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

    @Test
    public void testQueryDeviceStatusHistory() {
        QueryDeviceStatusHistoryRequest request = new QueryDeviceStatusHistoryRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");
        LocalDateTime tenDaysBefore = LocalDateTime.now().minus(Duration.ofDays(10));
        LocalDateTime now = LocalDateTime.now();
        request.setStartTime(Date.from(tenDaysBefore.toInstant(ZoneOffset.of("+8"))));
        request.setEndTime(Date.from(now.toInstant(ZoneOffset.of("+8"))));

        try {
            QueryDeviceStatusHistoryResponse response = client.sendRequest(request);
            System.out.println(JSONObject.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryDeviceStatusHistoryAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        QueryDeviceStatusHistoryRequest request = new QueryDeviceStatusHistoryRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");
        LocalDateTime tenDaysBefore = LocalDateTime.now().minus(Duration.ofDays(10));
        LocalDateTime now = LocalDateTime.now();
        request.setStartTime(Date.from(tenDaysBefore.toInstant(ZoneOffset.of("+8"))));
        request.setEndTime(Date.from(now.toInstant(ZoneOffset.of("+8"))));

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (response != null) {
                System.out.println(JSONObject.toJSONString(response));
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

    @Test
    public void testSetDeviceProperty() {
        SetDevicePropertyRequest request = new SetDevicePropertyRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");
        request.addParam("function-bitmap-001", 2);

        try {
            SetDevicePropertyResponse response = client.sendRequest(request);
            System.out.println(JSONObject.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    @Test
    public void testSetDevicePropertyAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        SetDevicePropertyRequest request = new SetDevicePropertyRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");
        request.addParam("api-sdk-develop-function-001", 13);

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (response != null) {
                System.out.println(JSONObject.toJSONString(response));
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

    @Test
    public void testSetDeviceDesiredPropertyResponse() {
        SetDeviceDesiredPropertyRequest request = new SetDeviceDesiredPropertyRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");
        request.addParam("function-bitmap-001", 2);
        request.addParam("function_test_001", new HashMap<String, Object>(){{put("a", 10); put("b", true);}});

        try {
            SetDeviceDesiredPropertyResponse response = client.sendRequest(request);
            System.out.println(JSONObject.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    @Test
    public void testSetDeviceDesiredPropertyResponseAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        SetDeviceDesiredPropertyRequest request = new SetDeviceDesiredPropertyRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");
        request.addParam("api-sdk-develop-function-001", 13);

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (response != null) {
                System.out.println(JSONObject.toJSONString(response));
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

    @Test
    public void testQueryDeviceDesiredProperty() {
        QueryDeviceDesiredPropertyRequest request = new QueryDeviceDesiredPropertyRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");
//        request.addParam("api-sdk-develop-function-001");

        try {
            QueryDeviceDesiredPropertyResponse response = client.sendRequest(request);
            System.out.println("requestId:" + response.getRequestId());
            response.forEach((identify, property) -> {
                System.out.println("identify:" + identify);
                System.out.println("property:" + JSONObject.toJSONString(property));
            });
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryDeviceDesiredPropertyAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        QueryDeviceDesiredPropertyRequest request = new QueryDeviceDesiredPropertyRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");
        request.addParam("api-sdk-develop-function-001");

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (response != null) {
                System.out.println("requestId:" + response.getRequestId());
                response.forEach((identify, property) -> {
                    System.out.println("identify:" + identify);
                    System.out.println("property:" + JSONObject.toJSONString(property));
                });
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

    @Test
    public void testDeleteDeviceDesiredProperty() {
        DeleteDeviceDesiredPropertyRequest request = new DeleteDeviceDesiredPropertyRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");
        request.addParam("api-sdk-develop-function-001", 1);

        try {
            DeleteDeviceDesiredPropertyResponse response = client.sendRequest(request);
            System.out.println(JSONObject.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteDeviceDesiredPropertyAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        DeleteDeviceDesiredPropertyRequest request = new DeleteDeviceDesiredPropertyRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");
        request.addParam("api-sdk-develop-function-001");

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (response != null) {
                System.out.println(JSONObject.toJSONString(response));
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

    @Test
    public void testQueryDeviceLog() {
        QueryDeviceLogRequest request = new QueryDeviceLogRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");
        LocalDateTime tenDaysBefore = LocalDateTime.now().minus(Duration.ofDays(1));
        LocalDateTime now = LocalDateTime.now();
        request.setStartTime(Date.from(tenDaysBefore.toInstant(ZoneOffset.of("+8"))));
        request.setEndTime(Date.from(now.toInstant(ZoneOffset.of("+8"))));
        request.setOffset(0);
        request.setLimit(10);

        try {
            QueryDeviceLogResponse response = client.sendRequest(request);
            System.out.println(JSONObject.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryDeviceLogAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        QueryDeviceLogRequest request = new QueryDeviceLogRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");
        LocalDateTime tenDaysBefore = LocalDateTime.now().minus(Duration.ofDays(1));
        LocalDateTime now = LocalDateTime.now();
        request.setStartTime(Date.from(tenDaysBefore.toInstant(ZoneOffset.of("+8"))));
        request.setEndTime(Date.from(now.toInstant(ZoneOffset.of("+8"))));
        request.setOffset(0);
        request.setLimit(10);

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (response != null) {
                System.out.println(JSONObject.toJSONString(response));
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

    @Test
    public void testQueryDeviceProperty() {
        QueryDevicePropertyRequest request = new QueryDevicePropertyRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");

        try {
            QueryDevicePropertyResponse response = client.sendRequest(request);
            System.out.println("requestId:" + response.getRequestId());
            response.forEach(deviceProperty -> System.out.println(JSONObject.toJSONString(deviceProperty)));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryDevicePropertyAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        QueryDevicePropertyRequest request = new QueryDevicePropertyRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (response != null) {
                System.out.println("requestId:" + response.getRequestId());
                response.forEach(deviceProperty -> System.out.println(JSONObject.toJSONString(deviceProperty)));
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

    @Test
    public void testQueryDevicePropertyHistory() {
        QueryDevicePropertyHistoryRequest request = new QueryDevicePropertyHistoryRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");
        request.setIdentifier("function_test_001");
        LocalDateTime tenDaysBefore = LocalDateTime.now().minus(Duration.ofDays(7));
        LocalDateTime now = LocalDateTime.now();
        request.setStartTime(Date.from(tenDaysBefore.toInstant(ZoneOffset.of("+8"))));
        request.setEndTime(Date.from(now.toInstant(ZoneOffset.of("+8"))));
        request.setOffset(0);
        request.setLimit(10);
        request.setSort(Sort.DESC);

        try {
            QueryDevicePropertyHistoryResponse response = client.sendRequest(request);
            System.out.println(JSONObject.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryDevicePropertyHistoryAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        QueryDevicePropertyHistoryRequest request = new QueryDevicePropertyHistoryRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");
        request.setIdentifier("api-sdk-develop-function-001");
        LocalDateTime tenDaysBefore = LocalDateTime.now().minus(Duration.ofDays(1));
        LocalDateTime now = LocalDateTime.now();
        request.setStartTime(Date.from(tenDaysBefore.toInstant(ZoneOffset.of("+8"))));
        request.setEndTime(Date.from(now.toInstant(ZoneOffset.of("+8"))));
        request.setOffset(0);
        request.setLimit(10);
        request.setSort(Sort.DESC);

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (response != null) {
                System.out.println(JSONObject.toJSONString(response));
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

    @Test
    public void testQueryDeviceEventHistory() {
        QueryDeviceEventHistoryRequest request = new QueryDeviceEventHistoryRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");
        request.setIdentifier("api-sdk-develop-event-001");
        request.setEventType(EventType.MESSAGE);
        LocalDateTime tenDaysBefore = LocalDateTime.now().minus(Duration.ofDays(1));
        LocalDateTime now = LocalDateTime.now();
        request.setStartTime(Date.from(tenDaysBefore.toInstant(ZoneOffset.of("+8"))));
        request.setEndTime(Date.from(now.toInstant(ZoneOffset.of("+8"))));
        request.setOffset(0);
        request.setLimit(10);

        try {
            QueryDeviceEventHistoryResponse response = client.sendRequest(request);
            System.out.println(JSONObject.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryDeviceEventHistoryAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        QueryDeviceEventHistoryRequest request = new QueryDeviceEventHistoryRequest();
        request.setProjectId(projectId);
        request.setProductId("EWQ0uNRuUp");
        request.setDeviceName("api-sdk-device-001");
        request.setIdentifier("api-sdk-develop-event-001");
        request.setEventType(EventType.MESSAGE);
        LocalDateTime tenDaysBefore = LocalDateTime.now().minus(Duration.ofDays(1));
        LocalDateTime now = LocalDateTime.now();
        request.setStartTime(Date.from(tenDaysBefore.toInstant(ZoneOffset.of("+8"))));
        request.setEndTime(Date.from(now.toInstant(ZoneOffset.of("+8"))));
        request.setOffset(0);
        request.setLimit(10);

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (response != null) {
                System.out.println(JSONObject.toJSONString(response));
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
