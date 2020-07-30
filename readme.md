# OneNET Studio API SDK 

本项目是 中移物联网公司 为方便Java开发者快速将应用接入OneNET Studio开发的SDK，关于

[OneNET Studio](https://open.iot.10086.cn/studio)请进入主站了解详情，如果要了解OneNET Studio API请参考[文档中心](https://open.iot.10086.cn/doc/iot_platform/book/api/introduce.html)。本项目包含了SDK源码和单元测试代码，单元测试列出了SDK的所有使用方式。

## 环境

JDK1.8及以上

## 构建项目

推荐开发者使用项目构建工具来构建项目，引入下面的SDK依赖。

### Maven

```xml
<dependency>
  <groupId>com.github.cm-heclouds</groupId>
  <artifactId>onenet-studio-api-sdk</artifactId>
  <version>1.0.0</version>
</dependency>
```

### Gradle

```groovy
implementation 'com.github.cm-heclouds:onenet-studio-api-sdk:1.0.0'
```

### SBT

```scala
libraryDependencies += "com.github.cm-heclouds" % "onenet-studio-api-sdk" % "1.0.0"
```

## 如何使用

要使用SDK调用OneNET Studio平台提供的API，一共分为三步：创建IotClient对象，调用API，关闭IotClient释放资源。

### 创建IotClient对象

创建IotClient对象需要先创建IotProfile对象，提供必须的参数（userId, accessKey）和可选参数，然后调用IotClient简单工厂方法创建IotClient。

#### 示例：

```java
IotProfile profile = new IotProfile();
profile.userId("<your userId>")
    .accessKey("<your accessKey>");
IotClient client = IotClient.create(profile);
```

### 调用API

关于调用API分为三步：创建请求对象，调用IotClient的发送请求方法，处理响应对象或异常。

以下选取创建设备作为示例，请求对象详见包：com.github.cm.heclouds.onenet.studio.api.entity 和单元测试。

IotClient提供了同步和异步调用方法，开发者可根据业务场景和需求自行选择。

#### 示例：

同步调用

```java
CreateDeviceRequest request = new CreateDeviceRequest();
request.setProductId("<your productId>");
request.setDeviceName("<your device name>");
request.setDesc("<description about your device>");

try {
    CreateDeviceResponse response = client.sendRequest(request);
    System.out.println(JSONObject.toJSONString(response));
} catch (IotClientException e) {
    e.printStackTrace();
} catch (IotServerException e) {
    System.err.println(e.getCode());
    e.printStackTrace();
}
```

异步调用

```java
CreateDeviceRequest request = new CreateDeviceRequest();
request.setProductId("<your productId>");
request.setDeviceName("<your device name>");
request.setDesc("<description about your device>");

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
});
```

### 关闭IotClient

SDK内部使用连接池，即IotClient对象可以复用，通常情况下是不需要关闭IotClient的，只有不再需要调用OneNET Studio API或者程序关闭时需要关闭IotClient以释放资源。

#### 示例：

```java
client.close();
```

### 异常说明

SDK捕获了调用API产生的错误，并以IotClientException和IotServerException作为异常抛出。当开发者以同步方式调用时需要捕获异常并处理，当以异步方式调用时，开发者需要使用CompletableFuture.whenComplete()或者CompletableFuture.exceptionally()方法处理异常。顾名思义，IotClientException是由于本地客户端错误导致的，通常是缺少必要参数或参数无效；IotServerException是对OneNET Studio平台返回错误的封装，包含http非200错误和业务类型错误，详情见[错误码文档](https://open.iot.10086.cn/doc/iot_platform/book/api/code.html)