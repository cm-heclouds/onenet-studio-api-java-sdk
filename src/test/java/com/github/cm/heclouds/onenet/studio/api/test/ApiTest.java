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
    private final String roleId = "12974671-765c-458c-abfd-ec117f5c79de";
    private final String accessKey = "ioI/lquiGVxzEFRGuijpXNSqb8MH0pUEjH67jwEPL1AuKn9/HDr1XhCNv7vXfGiQgOTP1G+l7ThhgqtKvWj1ww==";
//    private final String accessKey = "NTc2OTA4NTE4MDAyZjhlYzI2NWM0YjRkODg0Y2E3OTg=";

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
