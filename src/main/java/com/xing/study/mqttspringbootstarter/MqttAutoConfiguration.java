package com.xing.study.mqttspringbootstarter;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qzexing
 * @version 1.0
 * @date 2022/3/31 15:21
 */
@EnableConfigurationProperties(MqttConfig.class)
@ConditionalOnClass(MqttClient.class)
@Configuration
public class MqttAutoConfiguration {

    @Bean
    public MqttClient getMqttPahoClientFactory(MqttConfig mqttConfig) throws MqttException {
        String broker = mqttConfig.getServerProtocol() + "://" + mqttConfig.getServerHost() + ":" + mqttConfig.getServerPort();
        MemoryPersistence persistence = new MemoryPersistence();
        MqttClient sampleClient = new MqttClient(broker, mqttConfig.getClientId(), persistence);
        MqttConnectOptions options = new MqttConnectOptions();
        // 设置连接的用户名
        options.setUserName(mqttConfig.getUsername());
        // 设置连接的密码
        options.setPassword(mqttConfig.getPassword().toCharArray());
        // 设置超时时间 单位为秒
        options.setConnectionTimeout(mqttConfig.getConnectionTimeout());
        // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送心跳判断客户端是否在线
        options.setKeepAliveInterval(mqttConfig.getKeepAliveInterval());
        sampleClient.connect(options);
        return sampleClient;
    }

}
