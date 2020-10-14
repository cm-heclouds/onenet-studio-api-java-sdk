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

    private final String userId = "154377";
    private final String accessKey = "ioI/lquiGVxzEFRGuijpXNSqb8MH0pUEjH67jwEPL1AuKn9/HDr1XhCNv7vXfGiQgOTP1G+l7ThhgqtKvWj1ww==";

    IotClient client;

    /**
     * 初始化并构造{@link IotClient}
     */
    @Before
    public void initClient() {
        IotProfile profile = new IotProfile();
        profile.userId(userId)
                .accessKey(accessKey)
                .enableSsl(true)
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
