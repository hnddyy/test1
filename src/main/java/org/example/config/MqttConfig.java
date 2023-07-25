package org.example.config;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@IntegrationComponentScan
@Configuration
public class MqttConfig {

    private String[] hosts = {"tcp://0.0.0.0:1833"};
    private String defaultTopic = "topic.exchange";
    private String clientId = "quest";

    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler mqttMessageHandler() {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(clientId, mqttClientFactory());
        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic(defaultTopic);
        return messageHandler;
    }

    @Bean
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }

    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(hosts);
        options.setUserName(clientId);
        options.setPassword(clientId.toCharArray());
        options.setAutomaticReconnect(true);
        options.setKeepAliveInterval(5000);
        options.setMaxReconnectDelay(5000);
        options.setConnectionTimeout(5000);
        factory.setConnectionOptions(options);
        return factory;
    }

}
