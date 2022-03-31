package com.xing.study.mqttspringbootstarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author qzexing
 * @version 1.0
 * @date 2022/3/31 15:26
 */
@ConfigurationProperties("xing.mqtt.config")
public class MqttConfig {

    private String clientId;

    private String serverProtocol = "tcp";

    private String serverHost = "localhost";

    private Integer serverPort = 1883;

    private String username;

    private String password;

    private Integer connectionTimeout;

    private Integer keepAliveInterval;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getServerProtocol() {
        return serverProtocol;
    }

    public void setServerProtocol(String serverProtocol) {
        this.serverProtocol = serverProtocol;
    }

    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }

    public Integer getServerPort() {
        return serverPort;
    }

    public void setServerPort(Integer serverPort) {
        this.serverPort = serverPort;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(Integer connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public Integer getKeepAliveInterval() {
        return keepAliveInterval;
    }

    public void setKeepAliveInterval(Integer keepAliveInterval) {
        this.keepAliveInterval = keepAliveInterval;
    }
}
