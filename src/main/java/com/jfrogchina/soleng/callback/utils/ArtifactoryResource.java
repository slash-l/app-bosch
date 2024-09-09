package com.jfrogchina.soleng.callback.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "artifactory")
@Data
public class ArtifactoryResource {

    private String url;

    private RestapiResource restapiResource;

}
