package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.config.MqttConfig;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log4j2
@Service
public class MqttResponseService {

//    @Autowired
//    private ConfigurableApplicationContext configurableApplicationContext;

    private final MqttConfig.MyGateway gateWay;

//    @PostConstruct
//    public void initGateWay() {
//        gateWay = configurableApplicationContext.getBean(MqttConfig.MyGateway.class);
//    }

    public String sendToMqtt(String message) {
        gateWay.sendToMqtt(message);
        return "ok";
    }
}
