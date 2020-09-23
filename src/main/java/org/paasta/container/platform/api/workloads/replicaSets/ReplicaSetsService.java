package org.paasta.container.platform.api.workloads.replicaSets;

import org.paasta.container.platform.api.common.*;

import org.paasta.container.platform.api.common.model.ResultStatus;
import org.paasta.container.platform.api.customServices.CustomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * ReplicaSets Service 클래스
 *
 * @author jjy
 * @version 1.0
 * @since 2020.09.10
 */
@Service
public class ReplicaSetsService {

    private final RestTemplateService restTemplateService;
    private final CommonService commonService;
    private final PropertyService propertyService;

    /**
     * Instantiates a new ReplicaSet service.
     *
     * @param restTemplateService the rest template service
     * @param commonService       the common service
     * @param propertyService     the property service
     */
    @Autowired
    public ReplicaSetsService(RestTemplateService restTemplateService, CommonService commonService, PropertyService propertyService) {
        this.restTemplateService = restTemplateService;
        this.commonService = commonService;
        this.propertyService = propertyService;
    }

    /**
     * ReplicaSets 목록을 조회한다.
     *
     * @param namespace the namespace
     * @return the replicaSets list
     */
    public ReplicaSetsList getReplicaSetsList(String namespace) {
        HashMap resultMap = (HashMap) restTemplateService.send(Constants.TARGET_CP_MASTER_API,
                propertyService.getCpMasterApiListReplicaSetsListUrl()
                        .replace("{namespace}", namespace), HttpMethod.GET, null, Map.class);

        return (ReplicaSetsList) commonService.setResultModel(commonService.setResultObject(resultMap, ReplicaSetsList.class), Constants.RESULT_STATUS_SUCCESS);
    }

    /**
     * ReplicaSets 상세 정보를 조회한다.
     *
     * @param namespace       the namespace
     * @param replicaSetsName the replicaSets name
     * @return the custom services
     */
    public ReplicaSets getReplicaSets(String namespace, String replicaSetsName) {
        HashMap resultMap = (HashMap) restTemplateService.send(Constants.TARGET_CP_MASTER_API,
                propertyService.getCpMasterApiListReplicaSetsGetUrl()
                        .replace("{namespace}", namespace)
                        .replace("{name}", replicaSetsName)
                , HttpMethod.GET, null, Map.class);

        return (ReplicaSets) commonService.setResultModel(commonService.setResultObject(resultMap, ReplicaSets.class), Constants.RESULT_STATUS_SUCCESS);
    }

    /**
     * ReplicaSets YAML을 조회한다.
     *
     * @param namespace   the namespace
     * @param replicaSetsName the ReplicaSets name
     * @return the custom ReplicaSets yaml
     */
    public ReplicaSets getReplicaSetsYaml(String namespace, String replicaSetsName) {
        String resultString = restTemplateService.send(Constants.TARGET_CP_MASTER_API,
                propertyService.getCpMasterApiListReplicaSetsGetUrl()
                        .replace("{namespace}", namespace)
                        .replace("{name}", replicaSetsName), HttpMethod.GET, null, String.class, Constants.ACCEPT_TYPE_YAML);

        //noinspection unchecked
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("sourceTypeYaml", resultString);

        return (ReplicaSets) commonService.setResultModel(commonService.setResultObject(resultMap, ReplicaSets.class), Constants.RESULT_STATUS_SUCCESS);
    }

    /**
     * ReplicaSets 목록을 조회한다. (Label Selector)
     *
     * @param namespace the namespace
     * @param selectors the selectors
     * @return the replicaSets list
     */
    public ReplicaSetsList getReplicaSetsListLabelSelector(String namespace, String selectors) {
        String requestSelector = "?labelSelector=" + selectors;
        HashMap resultMap = (HashMap) restTemplateService.send(Constants.TARGET_CP_MASTER_API,
                propertyService.getCpMasterApiListReplicaSetsListUrl()
                        .replace("{namespace}", namespace) + requestSelector, HttpMethod.GET, null, Map.class);

        return (ReplicaSetsList) commonService.setResultModel(commonService.setResultObject(resultMap, ReplicaSetsList.class), Constants.RESULT_STATUS_SUCCESS);
    }


    /**
     * ReplicaSets을 생성한다.
     *
     * @param namespace       the namespace
     * @param yaml            the yaml
     * @return                 return is succeeded
     */
    public Object createReplicaSets(String namespace, String yaml) {
        Object map = restTemplateService.sendYaml(Constants.TARGET_CP_MASTER_API,
                propertyService.getCpMasterApiListreplicaSetsCreate()
                        .replace("{namespace}", namespace), HttpMethod.POST, yaml, Object.class);

        return  commonService.setResultModelWithNextUrl(commonService.setResultObject(map, ReplicaSets.class),
                Constants.RESULT_STATUS_SUCCESS, Constants.URI_WORKLOAD_REPLICA_SETS);
    }

    /**
     * ReplicaSets을 삭제한다.
     *
     * @param namespace        the namespace
     * @param resourceName     the ReplicaSets name
     * @return the ResultStatus
     */
    public ResultStatus deleteReplicaSets(String namespace, String resourceName, HashMap resultMap) {
        ResultStatus resultStatus = restTemplateService.send(Constants.TARGET_CP_MASTER_API,
                propertyService.getCpMasterApiListreplicaSetsDelete()
                        .replace("{namespace}", namespace).replace("{name}", resourceName), HttpMethod.DELETE, null, ResultStatus.class);

        return (ResultStatus) commonService.setResultModelWithNextUrl(commonService.setResultObject(resultStatus, ResultStatus.class),
                Constants.RESULT_STATUS_SUCCESS, Constants.URI_WORKLOAD_REPLICA_SETS);
    }

    /**
     * ReplicaSets을 수정한다.
     *
     * @param namespace the namespace
     * @param resourceName the ReplicaSets name
     * @param yaml          the yaml
     * @return the services
     */
    public Object updateReplicaSets(String namespace, String resourceName, String yaml) {
        Object map = restTemplateService.sendYaml(Constants.TARGET_CP_MASTER_API,
                propertyService.getCpMasterApiListreplicaSetsUpdate()
                        .replace("{namespace}", namespace).replace("{name}", resourceName), HttpMethod.PUT, yaml, Object.class);

        return commonService.setResultModelWithNextUrl(commonService.setResultObject(map, CustomServices.class),
                Constants.RESULT_STATUS_SUCCESS, Constants.URI_WORKLOAD_REPLICA_SETS_DETAIL.replace("{replicaSetName:.+}", resourceName));
    }
}
