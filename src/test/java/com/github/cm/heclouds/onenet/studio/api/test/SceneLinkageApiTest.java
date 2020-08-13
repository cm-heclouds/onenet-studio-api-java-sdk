package com.github.cm.heclouds.onenet.studio.api.test;

import com.alibaba.fastjson.JSON;
import com.github.cm.heclouds.onenet.studio.api.entity.application.scene.*;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.CType;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.DataType;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.EmitCondition;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.Operator;
import com.github.cm.heclouds.onenet.studio.api.exception.IotClientException;
import com.github.cm.heclouds.onenet.studio.api.exception.IotServerException;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * 应用开发类-场景联动API调用单元测试
 * @author ChengQi
 * @date 2020/7/8
 */
@SuppressWarnings("Duplicates")
public class SceneLinkageApiTest extends ApiTest {

    private final String projectId = "rYEt9n";

    /**
     * 同步调用场景联动规则创建API
     */
    @Test
    public void testCreateSceneRule() {
        CreateSceneRuleRequest request = new CreateSceneRuleRequest();
        request.setProjectId(projectId);
        request.setName("apiSdkDevelopScene001");
        request.setEmitCondition(EmitCondition.ALL);

        Condition condition = new Condition();
//        condition.setCtype(CType.NOTIFY);
//        condition.setDeviceName("api-sdk-device-001");
//        condition.setProductId("EWQ0uNRuUp");
//        condition.setIdentifier("api-sdk-develop-function-001");
//        condition.setType(DataType.INT32);
//        condition.setOperator(Operator.EQ);
//        condition.setValue("10");

        condition.setCtype(CType.LIFECYCLE);
        condition.setDeviceName("api-sdk-device-001");
        condition.setProductId("EWQ0uNRuUp");
        condition.setOperator(Operator.EQ);
        condition.setValue("online");

        request.addCondition(condition);

        Action action = new Action();
        action.setDeviceName("api-sdk-device-001");
        action.setProductId("EWQ0uNRuUp");
        action.setIdentifier("api-sdk-develop-function-001");
        action.setType(DataType.INT32);
        action.setValue("50");
        request.addAction(action);

        try {
            CreateSceneRuleResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用场景联动规则创建API
     */
    @Test
    public void testCreateSceneRuleAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        CreateSceneRuleRequest request = new CreateSceneRuleRequest();
        request.setProjectId(projectId);
        request.setName("apiSdkDevelopScene001");
        request.setEmitCondition(EmitCondition.ALL);

        Condition condition = new Condition();
        condition.setCtype(CType.NOTIFY);
        condition.setDeviceName("api-sdk-device-001");
        condition.setProductId("EWQ0uNRuUp");
        condition.setIdentifier("api-sdk-develop-function-001");
        condition.setType(DataType.INT32);
        condition.setOperator(Operator.EQ);
        condition.setValue("10");
        request.addCondition(condition);

        Action action = new Action();
        action.setDeviceName("api-sdk-device-001");
        action.setProductId("EWQ0uNRuUp");
        action.setIdentifier("api-sdk-develop-function-001");
        action.setType(DataType.INT32);
        action.setValue("50");
        request.addAction(action);

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
     * 同步调用场景联动规则编辑API
     */
    @Test
    public void testUpdateSceneRule() {
        UpdateSceneRuleRequest request = new UpdateSceneRuleRequest();
        request.setProjectId(projectId);
        request.setName("apiSdkDevelopScene001");
        request.setSceneId("5f05677321c85d0036fe5b0a");
        request.setEmitCondition(EmitCondition.ALL);

        Condition condition = new Condition();
        condition.setCtype(CType.NOTIFY);
        condition.setDeviceName("api-sdk-device-001");
        condition.setProductId("EWQ0uNRuUp");
        condition.setIdentifier("api-sdk-develop-function-001");
        condition.setType(DataType.INT32);
        condition.setOperator(Operator.EQ);
        condition.setValue("10");
        request.addCondition(condition);

        Action action = new Action();
        action.setDeviceName("api-sdk-device-001");
        action.setProductId("EWQ0uNRuUp");
        action.setIdentifier("api-sdk-develop-function-001");
        action.setType(DataType.INT32);
        action.setValue("60");
        request.addAction(action);

        try {
            UpdateSceneRuleResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用场景联动规则编辑API
     */
    @Test
    public void testUpdateSceneRuleAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        UpdateSceneRuleRequest request = new UpdateSceneRuleRequest();
        request.setProjectId(projectId);
        request.setName("apiSdkDevelopScene001");
        request.setSceneId("5f05677321c85d0036fe5b0a");
        request.setEmitCondition(EmitCondition.ALL);

        Condition condition = new Condition();
        condition.setCtype(CType.NOTIFY);
        condition.setDeviceName("api-sdk-device-001");
        condition.setProductId("EWQ0uNRuUp");
        condition.setIdentifier("api-sdk-develop-function-001");
        condition.setType(DataType.INT32);
        condition.setOperator(Operator.EQ);
        condition.setValue("10");
        request.addCondition(condition);

        Action action = new Action();
        action.setDeviceName("api-sdk-device-001");
        action.setProductId("EWQ0uNRuUp");
        action.setIdentifier("api-sdk-develop-function-001");
        action.setType(DataType.INT32);
        action.setValue("60");
        request.addAction(action);

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
     * 同步调用场景联动规则详情API
     */
    @Test
    public void testQuerySceneRuleDetail() {
        QuerySceneRuleDetailRequest request = new QuerySceneRuleDetailRequest();
        request.setProjectId(projectId);
        request.setSceneId("5f05677321c85d0036fe5b0a");

        try {
            QuerySceneRuleDetailResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用场景联动规则详情API
     */
    @Test
    public void testQuerySceneRuleDetailAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        QuerySceneRuleDetailRequest request = new QuerySceneRuleDetailRequest();
        request.setProjectId(projectId);
        request.setSceneId("5f05677321c85d0036fe5b0a");

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
     * 同步调用场景联动规则列表API
     */
    @Test
    public void testQuerySceneRules() {
        QuerySceneRulesRequest request = new QuerySceneRulesRequest();
        request.setProjectId(projectId);
        request.setOffset(0);
        request.setLimit(100);

        try {
            QuerySceneRulesResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用场景联动规则列表API
     */
    @Test
    public void testQuerySceneRulesAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        QuerySceneRulesRequest request = new QuerySceneRulesRequest();
        request.setProjectId(projectId);
        request.setOffset(0);
        request.setLimit(100);

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
     * 同步调用场景联动触发日志API
     */
    @Test
    public void testQuerySceneLog() {
        QuerySceneLogRequest request = new QuerySceneLogRequest();
        request.setProjectId(projectId);
        request.setSceneId("5f05677321c85d0036fe5b0a");
        LocalDateTime tenDaysBefore = LocalDateTime.now().minus(Duration.ofDays(17));
        LocalDateTime now = LocalDateTime.now().minus(Duration.ofDays(7));
        request.setStartTime(Date.from(tenDaysBefore.toInstant(ZoneOffset.of("+8"))));
        request.setEndTime(Date.from(now.toInstant(ZoneOffset.of("+8"))));
        request.setOffset(0);
        request.setLimit(10);

        try {
            QuerySceneLogResponse response = client.sendRequest(request);
            System.out.println(JSON.toJSONString(response));
        } catch (IotClientException e) {
            e.printStackTrace();
        } catch (IotServerException e) {
            System.err.println(e.getCode());
            e.printStackTrace();
        }
    }

    /**
     * 异步调用场景联动触发日志API
     */
    @Test
    public void testQuerySceneLogAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        QuerySceneLogRequest request = new QuerySceneLogRequest();
        request.setProjectId(projectId);
        request.setSceneId("5f05677321c85d0036fe5b0a");
        LocalDateTime tenDaysBefore = LocalDateTime.now().minus(Duration.ofDays(10));
        LocalDateTime now = LocalDateTime.now();
        request.setStartTime(Date.from(tenDaysBefore.toInstant(ZoneOffset.of("+8"))));
        request.setEndTime(Date.from(now.toInstant(ZoneOffset.of("+8"))));
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
}
