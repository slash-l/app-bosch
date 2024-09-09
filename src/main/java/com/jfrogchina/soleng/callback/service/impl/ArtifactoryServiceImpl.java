package com.jfrogchina.soleng.callback.service.impl;

import com.jfrogchina.soleng.callback.service.ArtifactoryService;
import com.jfrogchina.soleng.callback.service.bean.ArtifactBean;
import com.jfrogchina.soleng.callback.utils.ArtifactoryResource;
import com.jfrogchina.soleng.callback.utils.service.HttpRestApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author Slash Liu
 * @Date 2024/08/27
 */
@Service
public class ArtifactoryServiceImpl implements ArtifactoryService {

    private static final Logger logger = LoggerFactory.getLogger(ArtifactoryServiceImpl.class);

    @Autowired
    private ArtifactoryResource artifactoryResource;

    @Autowired
    private HttpRestApiService httpRestApiService;

    @Override
    public String getartifactMsg(String repoKey, String itemPath, String token) {
//        logger.info("Get Item Properties: {}", artifactoryResource.getRestapiResource().getPrefix() + artifactoryResource.getRestapiResource().getGetItemProperties());

        String apiUrl = "https://demo.jfrogchina.com/artifactory/api/storage/" + repoKey + "/" + itemPath + "?properties";

        String artifactsPropertiesMsg = httpRestApiService.httpGet(apiUrl, token);

        return artifactsPropertiesMsg;
    }
}
