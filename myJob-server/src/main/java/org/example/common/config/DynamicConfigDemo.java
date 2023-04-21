package org.example.common.config;

import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.AbstractListener;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@RefreshScope
@Configuration
public class DynamicConfigDemo {

    // 应用默认配置
    @Value("${config0.demo:0}")
    private String applicationConfigItem;
    // 应用扩展配置
    @Value("${config1.demo:1}")
    private String extensionConfigItem;
    @Value("${spring.application.name}")
    private String appName;
    // 通过api订阅的方式获取完整的应用配置信息
    private volatile String applicationConfigFromApi;
    // Nacos的配置管理器，可以通过管理器获取Api服务，进而手动订阅配置
    @Autowired
    private ConfigService configService;

    @PostConstruct
    public void init() throws NacosException {
        applicationConfigFromApi = configService.getConfigAndSignListener(appName + ".yaml", appName, 1000L, new AbstractListener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                applicationConfigFromApi = configInfo;
            }
        });
    }

    public String getApplicationConfigItem() {
        return applicationConfigItem;
    }

    public String getExtensionConfigItem() {
        return extensionConfigItem;
    }

    public String getApplicationConfigFromApi() {
        return applicationConfigFromApi;
    }

}
