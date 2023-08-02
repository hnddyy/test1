package org.example.conroller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.domain.dto.HeartRate;
import org.example.domain.dto.SearchDto;
import org.example.domain.dto.Stress;
import org.example.domain.entity.FitrockrBodyId;
import org.example.service.FitrockrBodyService;
import org.example.service.MqttResponseService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@RestController
public class WebClientController {

    private static final String EXCHANGE_NAME = "sample.exchange";

    private final FitrockrBodyService fitrockrBodyService;

    private final RabbitTemplate rabbitTemplate;

    private final MqttResponseService mqttResponseService;

    @GetMapping("/first")
    public Map<String, Object> firstController() {
        Map<String, Object> first = new HashMap<>();
        first.put("label", "check");
        return first;
    }

    @GetMapping("/greet")
    public Mono<String> doTest() {
        WebClient client = WebClient.create();
        return client.get()
                .uri("https://api.fitrockr.com/v1/status/greet")
                .headers(httpHeaders -> {
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                    httpHeaders.set("X-Tenant", "funzin");
                    httpHeaders.set("X-API-Key", "f176e30c-0a78-4742-b06a-358d46300909");
                })
                .retrieve()
                .bodyToMono(String.class);
    }

    @GetMapping("/heartRate")
    public void getGroupHeartRate() {
        WebClient client = WebClient.create();
        Mono<HeartRate[]> data =  client.get()
                .uri("https://api.fitrockr.com/v1/researchGroups/64703f032ea7495a37566b23/heartRate?startDate=2023-06-02&endDate=2023-06-02")
                .headers(httpHeaders -> {
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                    httpHeaders.set("X-Tenant", "funzin");
                    httpHeaders.set("X-API-Key", "f176e30c-0a78-4742-b06a-358d46300909");
                })
                .retrieve()
                .bodyToMono(HeartRate[].class);
        fitrockrBodyService.addHeartRate(data);
    }

    @GetMapping("/stress")
    public void getGroupStress() {
        WebClient client = WebClient.create();
        Mono<Stress[]> data =  client.get()
                .uri("https://api.fitrockr.com/v1/researchGroups/64703f032ea7495a37566b23/stress?startDate=2023-06-02&endDate=2023-06-02")
                .headers(httpHeaders -> {
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                    httpHeaders.set("X-Tenant", "funzin");
                    httpHeaders.set("X-API-Key", "f176e30c-0a78-4742-b06a-358d46300909");
                })
                .retrieve()
                .bodyToMono(Stress[].class);
        fitrockrBodyService.addStress(data);
    }

//    @GetMapping("/sample/queue")
//    public String samplePublish() {
//        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "funzin", "RabbitMQ + Springboot = Success!");
//        return "message sending!";
//    }
//
//    @GetMapping("/sample/bodydata")
//    public String sampleDataPublish() {
//        SearchDto searchDto = new SearchDto();
//        searchDto.setSearchUserId("646b38efdeb81f4756cfc87a");
//        searchDto.setSearchStartDate(LocalDateTime.of(2023, 6, 2, 9, 6, 0));
//        String dataString = fitrockrBodyService.getData(searchDto);
//        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "funzin", dataString);
//        return dataString;
//    }

    @GetMapping("/sample/topic")
    public String sampleTopicDataPublish(@RequestParam("message")String message) {
        return mqttResponseService.sendToMqtt(message);
    }

}
