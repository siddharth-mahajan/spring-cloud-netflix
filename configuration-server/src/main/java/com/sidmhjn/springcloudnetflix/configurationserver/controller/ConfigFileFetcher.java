package com.sidmhjn.springcloudnetflix.configurationserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.stereotype.Service;

@Service
public class ConfigFileFetcher {

    private final EnvironmentRepository environmentRepository;

    @Autowired
    public ConfigFileFetcher(EnvironmentRepository environmentRepository) {
        this.environmentRepository = environmentRepository;
    }

    public Environment getAllConfigFiles() {
        // Fetch all configuration files from the Config Server
        return environmentRepository.findOne(null, null, null, true);
    }
}
