package org.paasta.container.platform.api.common;

import org.springframework.http.MediaType;

import java.util.*;

/**
 * Constants 클래스
 *
 * @author hrjin
 * @version 1.0
 * @since 2020.08.26
 */
public class Constants {

    public static final String RESULT_STATUS_SUCCESS = "SUCCESS";
    public static final String RESULT_STATUS_FAIL = "FAIL";

    public static final String TARGET_CP_MASTER_API = "cpMasterApi";
    public static final String TARGET_COMMON_API = "commonApi";

    public static final String ACCEPT_TYPE_YAML = "application/yaml";

    public static final String TOKEN_KEY = "cp_admin";

    public static final String DEFAULT_NAMESPACE_NAME = "temp-namespace";
    public static final String NOT_ASSIGNED_ROLE = "NOT_ASSIGNED_ROLE";
    public static final String DEFAULT_INIT_ROLE = "init-role";
    public static final String DEFAULT_CLUSTER_ADMIN_ROLE = "cluster-admin"; // k8s default cluster role's name

    static final String STRING_DATE_TYPE = "yyyy-MM-dd HH:mm:ss";
    static final String STRING_ORIGINAL_DATE_TYPE = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    static final String STRING_TIME_ZONE_ID = "Asia/Seoul";

    static final String ACCEPT_TYPE_JSON = MediaType.APPLICATION_JSON_VALUE;

    // COMMON API CALL URI
    public static final String URI_COMMON_API_ADMIN_TOKEN_DETAIL = "/adminToken/{tokenName:.+}";
    public static final String URI_COMMON_API_USER_DETAIL =  "/users/{userId:.+}";
    public static final String URI_COMMON_API_USER_DETAIL_LOGIN =  "/users/login/{userId:.+}";
    public static final String URI_COMMON_API_USERS_LIST = "/clusters/cp-cluster/namespaces/{namespace:.+}/users";
    public static final String URI_COMMON_API_USERS_NAMES_LIST = "/clusters/cp-cluster/namespaces/{namespace:.+}/users/names";

    // NEXT ACTION MOVEMENT DASHBOARD URI
    public static final String URI_CLUSTER_NODES = "/container-platform/clusters/nodes";
    public static final String URI_CLUSTER_NAMESPACES = "/container-platform/clusters/namespaces";
    public static final String URI_INTRO_OVERVIEW = "/container-platform/intro/overview";
    public static final String URI_INTRO_ACCESS_INFO = "/container-platform/intro/accessInfo";
    public static final String URI_INTRO_PRIVATE_REGISTRY_INFO = "/container-platform/intro/privateRegistryInfo";

    public static final String URI_WORKLOAD_OVERVIEW = "/container-platform/workloads/overview";
    public static final String URI_WORKLOAD_DEPLOYMENTS = "/container-platform/workloads/deployments";
    public static final String URI_WORKLOAD_DEPLOYMENTS_DETAIL = "/container-platform/workloads/deployments/{deploymentName:.+}";
    public static final String URI_WORKLOAD_PODS = "/container-platform/workloads/pods";
    public static final String URI_WORKLOAD_PODS_DETAIL = "/container-platform/workloads/pods/{podName:.+}";
    public static final String URI_WORKLOAD_REPLICA_SETS = "/container-platform/workloads/replicasets";
    public static final String URI_WORKLOAD_REPLICA_SETS_DETAIL = "/container-platform/workloads/replicasets/{replicaSetName:.+}";

    public static final String URI_SERVICES = "/container-platform/services";
    public static final String URI_SERVICES_DETAIL = "/container-platform/services/{serviceName:.+}";

    public static final String URI_STORAGES = "/container-platform/storages";
    public static final String URI_STORAGES_PERSISTENT_VOLUME_CLAIM = "/container-platform/storages/persistentvolumeclaims";
    public static final String URI_STORAGES_PERSISTENT_VOLUME_CLAIM_DETAIL = "/container-platform/storages/persistentvolumeclaims/{persistentVolumeClaimName:.+}";
    public static final String URI_STORAGES_DETAIL = "/container-platform/storages/{persistentVolumeClaimName:.+}";

    public static final String URI_USERS = "/container-platform/users";

    public static final String URI_ROLES = "/container-platform/roles";

    /** 서비스 요청시 처리 메소드 kind 매핑 정보 */
    public static final String RESOURCE_SERVICEACCOUNT = "ServiceAccount";
    public static final String RESOURCE_ROLEBINDING = "RoleBinding";
    public static final String RESOURCE_SECRET = "Secret";
    public static final String RESOURCE_ENDPOINTS = "Endpoints";
    public static final String RESOURCE_EVENTS = "Events";

    //cluster
    public static final String RESOURCE_NAMESPACE = "Namespace";
    public static final String RESOURCE_NODE = "Node";

    //workload
    public static final String RESOURCE_DEPLOYMENT = "Deployment";
    public static final String RESOURCE_POD = "Pod";
    public static final String RESOURCE_REPLICASET = "ReplicaSet";

    //service
    public static final String RESOURCE_SERVICE = "Service";

    //storage
    public static final String RESOURCE_PERSISTENTVOLUME = "PersistentVolume";
    public static final String RESOURCE_PERSISTENTVOLUMECLAIM = "PersistentVolumeClaim";
    public static final String RESOURCE_STORAGECLASS = "StorageClass";

    //management
    public static final String RESOURCE_RESOURCEQUOTA = "ResourceQuota";
    public static final String RESOURCE_LIMITRANGE = "LimitRange";
    public static final String RESOURCE_ROLE = "Role";

    //리소스 복수형이 -es로 끝나는 case(소문자 작성)
    public static final String[] RESOURCE_SPELL_CASE = {"storageclasses"};

//    public static final List<String> RESOURCE_MAP = Collections.unmodifiableList(new ArrayList<String>(){
//        {
//            add(RESOURCE_POD);
//            add(RESOURCE_DEPLOYMENT);
//            add(RESOURCE_SERVICE);
//        }
//    });

    /** 서비스 클래스의 Package */
    public static final String SERVICE_PACKAGE = "org.paasta.container.platform.api.";

    public static final Map<String, String> RESOURCE_SERVICE_MAP = Collections.unmodifiableMap(new HashMap<String, String>() {
        {
            put(RESOURCE_ENDPOINTS, SERVICE_PACKAGE + "endpoints:EndpointsService");     // Endpoints 서비스
            put(RESOURCE_EVENTS, SERVICE_PACKAGE + "events:EventsService");     // Endpoints 서비스
            put(RESOURCE_NAMESPACE, SERVICE_PACKAGE + "clusters.namespaces:NamespacesService");     // Namespace 서비스
            put(RESOURCE_NODE, SERVICE_PACKAGE + "clusters.nodes:NodesService");     // Node 서비스
            put(RESOURCE_DEPLOYMENT, SERVICE_PACKAGE + "workloads.deployments:DeploymentsService");     // Deployment 서비스
            put(RESOURCE_POD, SERVICE_PACKAGE + "workloads.pods:PodsService");     // Pod 서비스
            put(RESOURCE_REPLICASET, SERVICE_PACKAGE + "workloads.pods:ReplicaSetsService");     // ReplicaSet 서비스
            put(RESOURCE_SERVICE, SERVICE_PACKAGE + "customServices:CustomServicesService");     // Service 서비스
            put(RESOURCE_PERSISTENTVOLUMECLAIM, SERVICE_PACKAGE + "storages.persistentVolumeClaims:PersistentVolumeClaimsService");     // PersistentVolumeClaim 서비스
            put(RESOURCE_STORAGECLASS, SERVICE_PACKAGE + "storages.storageClasses:StorageClassesService");     // StorageClass 서비스
            put(RESOURCE_RESOURCEQUOTA, SERVICE_PACKAGE + "managements.resourceQuotas:ResourceQuotasService");     // ResourceQuota 서비스
            put(RESOURCE_ROLE, SERVICE_PACKAGE + "roles:RolesService"); // Role 서비스
        }

    });

    public Constants() {
        throw new IllegalStateException();
    }

}
