package com.jfrogchina.soleng.callback.controller;

import com.alibaba.fastjson.JSON;
import com.jfrogchina.soleng.callback.controller.inputVO.ArtifactVO;
import com.jfrogchina.soleng.callback.service.ArtifactoryService;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CallbackController {

    private static final Logger logger = LoggerFactory.getLogger(CallbackController.class);

    @Autowired
    ArtifactoryService artifactoryService;

    @PostMapping(value = "/callbackELM")
    public String callbackELM(@RequestBody String artifactVO) throws JSONException {

        logger.info("--------------- start callbackELM ------------------------");

//        String artifact = artifactVO.getString("inputs");
        logger.info("artifact:  {}", artifactVO);

        JSONObject jsonObject = new JSONObject(artifactVO);
        String repoKey = jsonObject.getString("repo_key");
        String artifactPath = jsonObject.getString("artifact_path");
        String token = jsonObject.getString("token");

        logger.info("repoKey : {}", repoKey);
        logger.info("artifactPath : {}", artifactPath);

        // 调用 Artifactory 查询制品的元数据（workitem）
        String result = artifactoryService.getartifactMsg(repoKey, artifactPath, token);

        com.alibaba.fastjson.JSONObject jsonObj = JSON.parseObject(result);

        com.alibaba.fastjson.JSONObject properties = jsonObj.getJSONObject("properties");
        try{
            logger.info(properties.get("workitem").toString());
        }catch (Exception e){
            logger.error("制品没有 workitem 元数据：", e);
        }




        // 返回的元数据信息中需要存在 key=workitem 的元数据（在 ELM Jenkins 开发构建时注入）
        // 调用 EML - 根据 workitem 获取制品目前在 ELM 中的元数据信息


        // 调用 EML 将现在的元数据更新




        return result;
    }

}
