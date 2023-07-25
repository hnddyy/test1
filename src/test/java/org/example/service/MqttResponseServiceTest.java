package org.example.service;

import org.example.TestApplication;
import org.example.integration.MqttGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestApplication.class)
class MqttResponseServiceTest {

    @Autowired
    MqttResponseService service;

    @MockBean
    MqttGateway gateway;

    @Test
    public void sendTestByGateway() throws InterruptedException {

        service.sendToMqtt("gateway send " + LocalDateTime.now(),
                "server/angel/v01");

        CountDownLatch latch = new CountDownLatch(1);
        boolean await = latch.await(1, TimeUnit.SECONDS);
        if (await) {
            System.out.println("done!");
        }
    }

}