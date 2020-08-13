package com.github.cm.heclouds.onenet.studio.api.test;

import com.alibaba.fastjson.JSON;
import com.github.cm.heclouds.onenet.studio.api.entity.application.scene.QuerySceneLogResponse;
import com.github.cm.heclouds.onenet.studio.api.entity.application.scene.QuerySceneRuleDetailResponse;
import org.junit.Test;

/**
 * @author ChengQi
 * @date 2020/8/13
 */
public class SerializationTest {

    @Test
    public void testDeserializeSceneRuleDetail() {
        String data = "{\n" +
                "        \"name\":\"联动测试\",\n" +
                "        \"conditions\":[\n" +
                "            {   \n" +
                "                \"ctype\":\"notify\",\n" +
                "                \"device_name\":\"datou1\",\n" +
                "                \"product_id\":\"30769\",\n" +
                "                \"identifier\":\"1\",\n" +
                "                \"type\":\"bool\",\n" +
                "                \"value\":\"true\",\n" +
                "                \"operator\":\"eq\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"ctype\": \"extension\", \n" +
                "                \"value\": \"BAD\",        \n" +
                "                \"operator\": \"gt\", \n" +
                "                \"ext\": {\n" +
                "                    \"ad_code\": \"101041200\", \n" +
                "                    \"type\": \"airquality\"     \n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"ctype\": \"timer\",      \n" +
                "                \"timer\": {\n" +
                "                    \"repeat_day\": [\n" +
                "                        \"wed\",\"sat\"              \n" +
                "                    ],\n" +
                "                    \"_id\": \"5f325c903f8f26003c42420e\", \n" +
                "                    \"time\": \"01:02:07\",     \n" +
                "                    \"cron\": \"07 02 01 ? * WED *\"    \n" +
                "                }\n" +
                "            }\n" +
                "\t],\n" +
                "        \"actions\":[\n" +
                "            {\n" +
                "                \"device_name\":\"datou1\",\n" +
                "                \"product_id\":\"30769\",\n" +
                "                \"identifier\":\"1\",\n" +
                "                \"type\":\"bool\",\n" +
                "                \"value\":\"true\"\n" +
                "        },\n" +
                "        {\n" +
                "                \"callback\": {        // 回调执行\n" +
                "                    \"url\": \"https://www.baidu.com\"  // 回调地址\n" +
                "                }\n" +
                "         }\n" +
                "\t],\n" +
                "        \"emit_condition\":\"all\",\n" +
                "        \"created_at\": \"2020-05-20T01:37:45.187Z\",\n" +
                "        \"updated_at\": \"2020-05-20T01:45:35.149Z\"\n" +
                "    }";
        QuerySceneRuleDetailResponse response = JSON.parseObject(data, QuerySceneRuleDetailResponse.class);
        System.out.println(JSON.toJSONString(response));
    }

    @Test
    public void testDeserializeSceneLog() {
        String data = "{\n" +
                "\t\"list\": [{\n" +
                "\t\t\"conditions\": [{\n" +
                "\t\t\t\t\"ctype\": \"notify\",\n" +
                "\t\t\t\t\"device_name\": \"30769-datou1\",\n" +
                "\t\t\t\t\"product_id\": \"30769\",\n" +
                "\t\t\t\t\"identifier\": \"1\",\n" +
                "\t\t\t\t\"type\": \"bool\",\n" +
                "\t\t\t\t\"value\": \"true\",\n" +
                "\t\t\t\t\"operator\": \"eq\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"ctype\": \"extension\",\n" +
                "\t\t\t\t\"value\": \"BAD\",\n" +
                "\t\t\t\t\"operator\": \"gt\",\n" +
                "\t\t\t\t\"ext\": {\n" +
                "\t\t\t\t\t\"ad_code\": \"101041200\",\n" +
                "\t\t\t\t\t\"type\": \"airquality\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"ctype\": \"timer\",\n" +
                "\t\t\t\t\"timer\": {\n" +
                "\t\t\t\t\t\"repeat_day\": [\n" +
                "\t\t\t\t\t\t\"wed\",\"sun\"\n" +
                "\t\t\t\t\t],\n" +
                "\t\t\t\t\t\"_id\": \"5f325c903f8f26003c42420e\",\n" +
                "\t\t\t\t\t\"time\": \"01:02:07\",\n" +
                "\t\t\t\t\t\"cron\": \"07 02 01 ? * WED *\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t],\n" +
                "\t\t\"actions\": [{\n" +
                "\t\t\t\t\"device_name\": \"30769-datou1\",\n" +
                "\t\t\t\t\"product_id\": \"30769\",\n" +
                "\t\t\t\t\"identifier\": \"1\",\n" +
                "\t\t\t\t\"type\": \"bool\",\n" +
                "\t\t\t\t\"value\": \"true\",\n" +
                "\t\t\t\t\"success\": true,\n" +
                "\t\t\t\t\"message\": \"命令下发成功\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"callback\": {\n" +
                "\t\t\t\t\t\"url\": \"https://www.baidu.com\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"success\": false,\n" +
                "\t\t\t\t\"message\": \"请求失败\"\n" +
                "\t\t\t}\n" +
                "\t\t],\n" +
                "\t\t\"scene_id\": \"5ec48dce640d1b02043a6a59\",\n" +
                "\t\t\"status\": \"allsuccess\",\n" +
                "\t\t\"created_at\": \"2020-05-21T01:27:18.974Z\",\n" +
                "\t\t\"updated_at\": \"2020-05-21T01:27:18.974Z\"\n" +
                "\t}],\n" +
                "\t\"meta\": {\n" +
                "\t\t\"count\": 1,\n" +
                "\t\t\"limit\": 10,\n" +
                "\t\t\"offset\": 0\n" +
                "\t}\n" +
                "}";
        QuerySceneLogResponse response = JSON.parseObject(data, QuerySceneLogResponse.class);
        System.out.println(JSON.toJSONString(response));
    }
}
