package com.jfrogchina.soleng.callback.utils.service.impl;

import com.jfrogchina.soleng.callback.utils.ArtifactoryResource;
import com.jfrogchina.soleng.callback.utils.service.HttpRestApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class HttpRestApiServiceImpl implements HttpRestApiService {

    private static final Logger logger = LoggerFactory.getLogger(HttpRestApiServiceImpl.class);

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    private static ArtifactoryResource artifactoryResource;

    public void httpPost(){
        RestTemplate restTemplate = new RestTemplate();
    }

    /**
     * 使用 RestTemplate 调用服务端的 GET 请求
     */
    public String httpGet(String apiUrl, String assessToken){
        String result = new String();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + assessToken);
        HttpEntity<String> httpEntity = new HttpEntity(null, httpHeaders);

        try{
            RestTemplate restTemplate = restTemplate();
            ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, httpEntity, String.class, 1);

            if (HttpStatus.OK == responseEntity.getStatusCode()){
                result = responseEntity.getBody();
            }
        }catch (Exception e){
            logger.error("调用 Artifactory query properties 请求接口出错：", e);
        }
        return result;

    }

}
