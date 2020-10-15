package com.github.cm.heclouds.onenet.studio.api.test;

import com.alibaba.fastjson.JSON;
import com.github.cm.heclouds.onenet.studio.api.entity.application.device.CallServiceRequest;
import com.github.cm.heclouds.onenet.studio.api.entity.application.device.CallServiceResponse;
import com.github.cm.heclouds.onenet.studio.api.entity.application.group.*;
import com.github.cm.heclouds.onenet.studio.api.entity.common.*;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.*;
import com.github.cm.heclouds.onenet.studio.api.exception.IotClientException;
import com.github.cm.heclouds.onenet.studio.api.exception.IotServerException;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

/**
 * <p>设备管理类-物模型API调用单元测试</p>
 * <p>应用开发类-分组管理API调用单元测试</p>
 * <p>应用开发类-服务调用API单元测试</p>
 * @author ChengQi
 * @date 2020/10/14
 */
public class ThingModelAndGroupApiTest extends ApiTest {

    private final String productId = "EWQ0uNRuUp";
    private final String projectId = "rYEt9n";

    /**
     * 同步调用物模型系统功能点列表API
     */
    @Test
    public void testQuerySystemThingModel() {
        QuerySystemThingModelRequest request = new QuerySystemThingModelRequest();

        try {
            QuerySystemThingModelResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用物模型系统功能点列表API
     */
    @Test
    public void testQuerySystemThingModelAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        QuerySystemThingModelRequest request = new QuerySystemThingModelRequest();

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
     * 同步调用物模型更新API
     */
    @Test
    public void testUpdateThingModel() {
        UpdateThingModelRequest request = new UpdateThingModelRequest();
        request.setProductId(productId);
        request.addProperties(constructProperty());
        request.addEvent(constructEvent());
        request.addService(constructService());

        try {
            UpdateThingModelResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 同步调用物模型更新API
     */
    @Test
    public void testUpdateThingModelAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        UpdateThingModelRequest request = new UpdateThingModelRequest();
        request.setProductId(productId);
        request.addProperties(constructProperty());
        request.addEvent(constructEvent());
        request.addService(constructService());

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

    private Property constructProperty() {
        Property property = new Property();
        property.setFunctionMode(FunctionMode.PROPERTY);
        property.setIdentifier("identifier-api");
        property.setName("API属性");
        property.setDesc("API属性 描述");
        property.setAccessMode(AccessMode.READ_WRITE);
        property.setFunctionType(FunctionType.CUSTOM);

        DataTypeMeta dataType = new DataTypeMeta();
        dataType.setType(DataType.INT32);
        dataType.setSpecs(new HashMap<String, Object>(){{put("min", -214748);put("max", 214748);}});
        property.setDataType(dataType);
        return property;
    }

    private Event constructEvent() {
        Event event = new Event();
        event.setFunctionMode(FunctionMode.EVENT);
        event.setIdentifier("event-api");
        event.setName("API事件");
        event.setDesc("API事件 描述");
        event.setEventType(FunctionEventType.INFO);
        event.setFunctionType(FunctionType.CUSTOM);

        Parameter parameter = new Parameter();
        parameter.setIdentifier("event-api-param1");
        parameter.setName("event-api-param1");
        DataTypeMeta dataType = new DataTypeMeta();
        dataType.setType(DataType.INT32);
        dataType.setSpecs(new HashMap<String, Object>(){{put("min", "-214748");put("max", "214748");}});
        parameter.setDataType(dataType);
        event.setOutputData(Collections.singletonList(parameter));
        return event;
    }

    private Service constructService() {
        Service service = new Service();
        service.setFunctionMode(FunctionMode.SERVICE);
        service.setIdentifier("service-api");
        service.setName("API服务");
        service.setDesc("API服务 描述");
        service.setFunctionType(FunctionType.CUSTOM);
        service.setCallType(CallType.ASYNC);

        Parameter input = new Parameter();
        input.setIdentifier("input-param1");
        input.setName("input-param1");
        DataTypeMeta dataType = new DataTypeMeta();
        dataType.setType(DataType.INT32);
        dataType.setSpecs(new HashMap<String, Object>(){{put("min", "-214748");put("max", "214748");}});
        input.setDataType(dataType);

        Parameter output = new Parameter();
        output.setIdentifier("output-param1");
        output.setName("output-param1");
        dataType = new DataTypeMeta();
        dataType.setType(DataType.INT32);
        dataType.setSpecs(new HashMap<String, Object>(){{put("min", "-214748");put("max", "214748");}});
        output.setDataType(dataType);

        service.setInput(Collections.singletonList(input));
        service.setOutput(Collections.singletonList(output));
        return service;
    }

    /**
     * 同步调用物模型查询API
     */
    @Test
    public void testQueryThingModel() {
        QueryThingModelRequest request = new QueryThingModelRequest();
        request.setProductId(productId);

        try {
            QueryThingModelResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用物模型查询API
     */
    @Test
    public void testQueryThingModelAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        QueryThingModelRequest request = new QueryThingModelRequest();
        request.setProductId(productId);

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
     * 同步调用分组创建API
     */
    @Test
    public void testCreateGroup() {
        CreateGroupRequest request = new CreateGroupRequest();
        request.setProjectId(projectId);
        request.setName("group1");
        request.setDesc("分组1");

        try {
            CreateGroupResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用分组创建API
     */
    @Test
    public void testCreateGroupAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        CreateGroupRequest request = new CreateGroupRequest();
        request.setProjectId(projectId);
        request.setName("group3");

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
     * 同步调用分组删除API
     */
    @Test
    public void testDeleteGroup() {
        DeleteGroupRequest request = new DeleteGroupRequest();
        request.setProjectId(projectId);
        request.setId("ZTwQXY");

        try {
            DeleteGroupResponse response = client.sendRequest(request);
            System.out.println(response.getRequestId());
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用分组删除API
     */
    @Test
    public void testDeleteGroupAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        DeleteGroupRequest request = new DeleteGroupRequest();
        request.setProjectId(projectId);
        request.setId("aXlthv");

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (response != null) {
                System.out.println(response.getRequestId());
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
     * 同步调用分组编辑API
     */
    @Test
    public void testUpdateGroup() {
        UpdateGroupRequest request = new UpdateGroupRequest();
        request.setProjectId(projectId);
        request.setId("KXhRAz");
        request.addTag("haha", "xixi");
        request.setDesc("分组2");

        try {
            UpdateGroupResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用分组编辑API
     */
    @Test
    public void testUpdateGroupAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        UpdateGroupRequest request = new UpdateGroupRequest();
        request.setProjectId(projectId);
        request.setId("KXhRAz");
        request.addTag("kuku", "yiku");
        request.setDesc("分&&组2");

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
     * 同步调用分组详情API
     */
    @Test
    public void testQueryGroupDetail() {
        QueryGroupDetailRequest request = new QueryGroupDetailRequest();
        request.setProjectId(projectId);
        request.setId("KXhRAz");

        try {
            QueryGroupDetailResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用分组详情API
     */
    @Test
    public void testQueryGroupDetailAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        QueryGroupDetailRequest request = new QueryGroupDetailRequest();
        request.setProjectId(projectId);
        request.setId("KXhRAz");

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
     * 同步调用分组列表API
     */
    @Test
    public void testQueryGroupList() {
        QueryGroupListRequest request = new QueryGroupListRequest();
        request.setProjectId(projectId);
        request.setTagKey("kuku");
        request.setTagValue("yiku");
        request.setOffset(0);
        request.setLimit(10);

        try {
            QueryGroupListResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用分组列表API
     */
    @Test
    public void testQueryGroupListAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        QueryGroupListRequest request = new QueryGroupListRequest();
        request.setProjectId(projectId);
        request.setTagKey("kuku");
        request.setTagValue("yiku");
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
     * 同步调用分组设备添加API
     */
    @Test
    public void testAddGroupDevice() {
        AddGroupDeviceRequest request = new AddGroupDeviceRequest();
        request.setProjectId(projectId);
        request.setId("KXhRAz");
        request.setProductId(productId);
        request.setDevices(Collections.singletonList("api-sdk-device-005"));

        try {
            AddGroupDeviceResponse response = client.sendRequest(request);
            System.out.println(response.getRequestId());
            response.forEach(errorData -> System.out.println(JSON.toJSONString(errorData)));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用分组设备添加API
     */
    @Test
    public void testAddGroupDeviceAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        AddGroupDeviceRequest request = new AddGroupDeviceRequest();
        request.setProjectId(projectId);
        request.setId("KXhRAz");
        request.setProductId(productId);
        request.setDevices(Collections.singletonList("api-sdk-device-001"));

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (response != null) {
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
     * 同步调用分组设备移除API
     */
    @Test
    public void testRemoveGroupDevice() {
        RemoveGroupDeviceRequest request = new RemoveGroupDeviceRequest();
        request.setProjectId(projectId);
        request.setId("KXhRAz");
        request.setProductId(productId);
        request.setDevices(Collections.singletonList("api-sdk-device-005"));

        try {
            RemoveGroupDeviceResponse response = client.sendRequest(request);
            System.out.println(response.getRequestId());
            response.forEach(errorData -> System.out.println(JSON.toJSONString(errorData)));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用分组设备移除API
     */
    @Test
    public void testRemoveGroupDeviceAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        RemoveGroupDeviceRequest request = new RemoveGroupDeviceRequest();
        request.setProjectId(projectId);
        request.setId("KXhRAz");
        request.setProductId(productId);
        request.setDevices(Collections.singletonList("api-sdk-device-005"));

        client.sendRequestAsync(request).whenComplete((response, cause) -> {
            if (response != null) {
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
     * 同步调用服务API
     */
    @Test
    public void testCallService() {
        CallServiceRequest request = new CallServiceRequest();
        request.setProductId(productId);
        request.setDeviceName("del11");
        request.setIdentifier("adfaf");
        request.addParam("a", 1);

        try {
            CallServiceResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用服务API
     */
    @Test
    public void testCallServiceAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        CallServiceRequest request = new CallServiceRequest();
        request.setProductId(productId);
        request.setDeviceName("api-sdk-device-001");
        request.setIdentifier("service-api");
        request.addParam("input-param1", 1);

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
