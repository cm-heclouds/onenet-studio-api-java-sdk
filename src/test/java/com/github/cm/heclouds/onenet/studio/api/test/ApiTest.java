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

    IotClient client;

    @Before
    public void initClient() {
        IotProfile profile = new IotProfile();
        profile.userId(userId)
//                .roleId(roleId)
                .accessKey(accessKey)
                .enableSsl(true)
                .signatureMethod(SignatureMethod.SHA256);
        client = IotClient.create(profile);
    }

    @After
    public void destroyClient() throws IOException {
        client.close();
    }
}
