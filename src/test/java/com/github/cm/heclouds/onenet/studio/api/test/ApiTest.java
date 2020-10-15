package com.github.cm.heclouds.onenet.studio.api.test;

import com.github.cm.heclouds.onenet.studio.api.IotClient;
import com.github.cm.heclouds.onenet.studio.api.IotProfile;
import com.github.cm.heclouds.onenet.studio.api.auth.SignatureMethod;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;

/**
 * @author ChengQi
 * @date 2020-07-06 11:38
 */
@SuppressWarnings("FieldCanBeLocal")
public class ApiTest {

    private final String userId = "<your userId>";
    private final String accessKey = "<your accessKey>";
//    private final String projectId = "<your projectId>";
//    private final String groupId = "<your groupId>";
//    private final String accessKey = "<your group key>";

    IotClient client;

    /**
     * 初始化并构造{@link IotClient}
     */
    @Before
    public void initClient() {
        IotProfile profile = new IotProfile();
        profile
                .userId(userId)
//                .projectId(projectId)
//                .groupId(groupId)
                .accessKey(accessKey)
                .signatureMethod(SignatureMethod.SHA256);
        client = IotClient.create(profile);
    }

    /**
     * 关闭{@link IotClient}并释放资源
     * @throws IOException 如果有IO 错误
     */
    @After
    public void destroyClient() throws IOException {
        client.close();
    }
}
