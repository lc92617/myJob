package org.example.controller;


import com.westsecu.inf.base.model.api.response.Response;
import org.example.common.config.DynamicConfigDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 动态配置示例Controller
 */
@Slf4j
@RestController
@RequestMapping("/myJob/dynamicconfig")
public class DynamicConfigController {

    @Autowired
    private DynamicConfigDemo configDemo;

    @GetMapping(value = "/appconfig")
    public Response<String> getApplicationConfigItem() {
        return Response.success(configDemo.getApplicationConfigItem());
    }

    @GetMapping(value = "/extconfig")
    public Response<String> getExtensionConfigItem() {
        return Response.success(configDemo.getExtensionConfigItem());
    }

    @GetMapping(value = "/allconfig")
    public Response<String> getApplicationConfigFromApi() {
        return Response.success(configDemo.getApplicationConfigFromApi());
    }
}
