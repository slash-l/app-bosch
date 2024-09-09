package com.jfrogchina.soleng.callback.service;

import com.jfrogchina.soleng.callback.service.bean.ArtifactBean;

/**
 * @Author Slash Liu
 * @Date 2024/08/27
 * @version 1.0
 */
public interface ArtifactoryService {

    /**
     * 根据指定条件查询制品的元数据信息
     * @param repoKey
     * @param itemPath
     * @param token
     * @return
     */
    public String getartifactMsg(String repoKey, String itemPath, String token);

}
