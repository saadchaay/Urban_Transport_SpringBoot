package com.urban.vaultservice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class VaultRestController {
    @Value("${token.accessTokenTimeout}")
    private String accessToken;

    @GetMapping("/person-config")
    public Map<String, Object> getConfig(){
        return Map.of("Access Token: ", accessToken);
    }
}
