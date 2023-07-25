package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.integration.MqttGateway;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log4j2
@Service
public class MqttResponseService {

    private final MqttGateway gateway;

    public void sendToMqtt(String data, String topic) {
        log.debug("send to mqtt --- start ---");
        try {
            gateway.sendToMqtt(data, topic);
        } catch (Exception e) {
            log.error("error:" +  e.getMessage() + "," + e.getCause());
        }
        log.debug("send to mqtt --- end -----");
    }
}
