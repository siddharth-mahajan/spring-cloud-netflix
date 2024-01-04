package com.sidmhjn.springcloudnetflix.configurationserver.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    private final ConfigFileFetcher configFileFetcher;

    @Autowired
    public ConfigController(ConfigFileFetcher configFileFetcher) {
        this.configFileFetcher = configFileFetcher;
    }

    @GetMapping("/all")
    public ResponseEntity<Environment> getAllConfigFiles() {
        Environment environment = configFileFetcher.getAllConfigFiles();
        if (environment != null) {
            return ResponseEntity.ok().body(environment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
