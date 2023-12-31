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

    public static final String CHECK_Y = "Y";
    public static final String CHECK_N = "N";

    public static final String CHECK_TRUE = "true";
    public static final String CHECK_FALSE = "false";


    // for kubernetes cli user
    public static final String CHECK_K8S = "K";
    public static final String TYPE = "type" ;
    public static final String PATH= "path" ;

    public static final String TARGET_CP_MASTER_API = "cpMasterApi";
    public static final String TARGET_COMMON_API = "commonApi";

    public static final String ACCEPT_TYPE_YAML = "application/yaml";

    public static final String TOKEN_KEY = "cp_admin";

    public static final String SELECTED_ADMINISTRATOR = "administrator";
    public static final String SELECTED_USER = "user";

    public static final String AUTH_CLUSTER_ADMIN = "CLUSTER_ADMIN";
    public static final String AUTH_NAMESPACE_ADMIN = "NAMESPACE_ADMIN";
    public static final String AUTH_USER = "USER";


    public static final String AUTH_CLUSTER_ADMIN_CG = "Cluster Admin";
    public static final String AUTH_NAMESPACE_ADMIN_CG = "Namespace Admin";
    public static final String AUTH_USER_CG = "User";

    public static final String ALL_NAMESPACES = "all";
    public static final String ALL_USER_ID = "all";
    public static final String USERS = "users";
    public static final String DEFAULT_SERVICE_ACCOUNT = "default";

    public static final String NOT_ASSIGNED_ROLE = "NOT_ASSIGNED_ROLE";
    public static final String DEFAULT_CLUSTER_ADMIN_ROLE = "cluster-admin"; // k8s default cluster role's name

    public static final String NOT_ALLOWED_POD_NAME_NODES = "nodes";
    public static final String NOT_ALLOWED_POD_NAME_RESOURCES= "resources";

    public static final String LIMIT_RANGE_TYPE_POD = "Pod";
    public static final String LIMIT_RANGE_TYPE_CONTAINER = "Container";
    public static final String LIMIT_RANGE_TYPE_PVC = "PersistentVolumeClaim";

    public static final String SUPPORTED_RESOURCE_CPU = "cpu";
    public static final String SUPPORTED_RESOURCE_MEMORY = "memory";
    public static final String SUPPORTED_RESOURCE_STORAGE = "storage";

    public static final List<String> LIMIT_RANGE_TYPE_LIST = Collections.unmodifiableList(new ArrayList<String>(){
        {
            add(LIMIT_RANGE_TYPE_POD);
            add(LIMIT_RANGE_TYPE_CONTAINER);
            add(LIMIT_RANGE_TYPE_PVC);
        }
    });

    public static final List<String> SUPPORTED_RESOURCE_LIST = Collections.unmodifiableList(new ArrayList<String>(){
        {
            add(SUPPORTED_RESOURCE_CPU);
            add(SUPPORTED_RESOURCE_MEMORY);
        }
    });

    public static final List<String> NOT_ALLOWED_POD_NAME_LIST = Collections.unmodifiableList(new ArrayList<String>(){
        {
            add(NOT_ALLOWED_POD_NAME_NODES);
            add(NOT_ALLOWED_POD_NAME_RESOURCES);
        }
    });

    static final String STRING_DATE_TYPE = "yyyy-MM-dd HH:mm:ss";
    static final String STRING_ORIGINAL_DATE_TYPE = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    static final String STRING_TIME_ZONE_ID = "Asia/Seoul";

    static final String ACCEPT_TYPE_JSON = MediaType.APPLICATION_JSON_VALUE;

    public static final String URI_SIGN_UP = "/signUp";
    public static final String URI_LOGIN = "/login";
    public static final String CLUSTER_ROLE_URI = "users/resources";


    public static final String URI_CHECK_REGISTERED_USER = "/check/clusters/{cluster:.+}/namespaces/{namespace:.+}/users/{userId:.+}";

    public static final String[] PERMIT_PATH_LIST = new String[]{ URI_SIGN_UP, URI_LOGIN, URI_CHECK_REGISTERED_USER};

    public static final String ENDS_WITH_SES = "ses";
    public static final String ENDS_WITH_S = "s";

    // KUBERNETES METRIC API URI
    public static final String URI_METRIC_API_BASIC = "/apis/metrics.k8s.io/v1beta1/namespaces/{namespace}/pods";

    // COMMON API CALL URI
    public static final String URI_COMMON_API_ADMIN_TOKEN_DETAIL = "/adminToken/{tokenName:.+}";
    public static final String URI_COMMON_API_USERS = "/clusters/{cluster:.+}/namespaces/{namespace:.+}/users/{userId:.+}";
    public static final String URI_COMMON_API_USERS_DETAIL =  "/users/{userId:.+}";
    public static final String URI_COMMON_API_USERS_LIST =  "/users";
    public static final String URI_COMMON_API_USERS_NAMES =  "/users/names";
    public static final String URI_COMMON_API_USERS_LIST_BY_CLUSTER = "/clusters/{cluster:.+}/users";
    public static final String URI_COMMON_API_USERS_LIST_BY_CLUSTER_TEMPNAMESPACE = "/clusters/{cluster:.+}/users/tempNamespace";



    public static final String URI_COMMON_API_USER_DETAIL_LOGIN =  "/users/login/{userId:.+}";
    public static final String URI_COMMON_API_USERS_LIST_BY_NAMESPACE = "/clusters/{cluster:.+}/namespaces/{namespace:.+}/users";
    public static final String URI_COMMON_API_USERS_NAMES_LIST = "/clusters/{cluster:.+}/namespaces/{namespace:.+}/users/names";
    public static final String URI_COMMON_API_USER_DELETE = "/users/";
    public static final String URI_COMMON_API_USERS_BY_NAMESPACE_NS_ADMIN = "/clusters/{cluster:.+}/namespaces/{namespace:.+}";
    public static final String URI_COMMON_API_NAMESPACES_ROLE_BY_CLUSTER_NAME_USER_ID = "/clusters/{cluster:.+}/users/{userId:.+}";
    public static final String URI_COMMON_API_PRIVATE_REGISTRY = "/privateRegistry/{imageName:.+}";
    public static final String URI_COMMON_API_CLUSTER_ADMIN_ROLE_BY_CLUSTER_NAME_USER_ID = "/clusters/{cluster:.+}/users/{userId:.+}/userType";

    public static final String URI_COMMON_API_CLUSTER_ADMIN_SIGNUP = "/cluster/all/admin/signUp";
    public static final String URI_COMMON_API_USER_SIGNUP = "/cluster/all/user/signUp";

    public static final String URI_COMMON_API_CHECK_CLUSTER_ADMIN_REGISTER = "/clusterAdminRegisterCheck?userId={userId:.+}&userAuthId={userAuthId:.+}";
    public static final String URI_COMMON_API_CHECK_USER_REGISTER =  "/userRegisterCheck?userId={userId:.+}&userAuthId={userAuthId:.+}";

    public static final String URI_COMMON_API_CLUSTER_ADMIN_INFO = "/cluster/all/admin/info?searchName={searchName:.+}";
    public static final String URI_COMMON_API_CLUSTER_USER_DETAILS = "/cluster/all/user/details?userId={userId:.+}&userType={userType:.+}";
    public static final String URI_COMMON_API_NAMESPACE_OR_NOT_CHECK = "/clusters/all/namespaces/{namespace:.+}/adminCheck";
    public static final String URI_COMMON_API_DELETE_USER_BY_ID_AND_AUTHID = "/cluster/all/user/delete?userId={userId:.+}&userAuthId={userAuthId:.+}&namespace={namespace:.+}";



    // NEXT ACTION MOVEMENT DASHBOARD URI
    public static final String URI_CLUSTER_NODES = "/container-platform/clusters/nodes";
    public static final String URI_CLUSTER_NAMESPACES = "/container-platform/clusters/namespaces";
    public static final String URI_INTRO_OVERVIEW = "/container-platform/intro/overview";

    public static final String URI_WORKLOAD_DEPLOYMENTS = "/container-platform/workloads/deployments";
    public static final String URI_WORKLOAD_DEPLOYMENTS_DETAIL = "/container-platform/workloads/deployments/{deploymentName:.+}";
    public static final String URI_WORKLOAD_PODS = "/container-platform/workloads/pods";
    public static final String URI_WORKLOAD_PODS_DETAIL = "/container-platform/workloads/pods/{podName:.+}";
    public static final String URI_WORKLOAD_REPLICA_SETS = "/container-platform/workloads/replicaSets";
    public static final String URI_WORKLOAD_REPLICA_SETS_DETAIL = "/container-platform/workloads/replicaSets/{replicaSetName:.+}";

    public static final String URI_SERVICES = "/container-platform/services";
    public static final String URI_SERVICES_DETAIL = "/container-platform/services/{serviceName:.+}";

    public static final String URI_STORAGES = "/container-platform/storages";
    public static final String URI_STORAGES_DETAIL = "/container-platform/storages/{persistentVolumeClaimName:.+}";

    public static final String URI_STORAGES_PERSISTENT_VOLUMES = "/container-platform/storages/persistentVolumes";
    public static final String URI_STORAGES_PERSISTENT_VOLUMES_DETAIL = "/container-platform/storages/persistentVolumes/{persistentVolumeName:.+}";
    public static final String URI_STORAGES_STORAGE_CLASSES = "/container-platform/storages/storageClasses";
    public static final String URI_STORAGES_STORAGE_CLASSES_DETAIL = "/container-platform/storages/storageClasses/{storageClassName:.+}";

    public static final String URI_USERS = "/container-platform/users";
    public static final String URI_USERS_DETAIL = "/container-platform/users/{userId:.+}";
    public static final String URI_USERS_CONFIG = "/container-platform/users/config";

    public static final String URI_ROLES = "/container-platform/roles";
    public static final String URI_ROLES_DETAIL = "/container-platform/roles/{roleName:.+}";

    public static final String URI_RESOURCE_QUOTAS = "/container-platform";
    public static final String URI_RESOURCE_QUOTAS_DETAIL = "/container-platform/resourceQuotas/{resourceQuotaName:.+}";

    public static final String URI_LIMIT_RANGES = "/container-platform";
    public static final String URI_LIMIT_RANGES_DETAIL = "/container-platform/limitRanges/{limitRangeName:.+}";
    public static final String URI_SERVICEINSTANCE_DETAIL =  "/serviceInstance/{serviceInstanceId:.+}";



    /** 서비스 요청시 처리 메소드 kind 매핑 정보 */
    public static final String RESOURCE_ENDPOINTS = "Endpoints";
    public static final String RESOURCE_EVENTS = "Events";

    //cluster
    public static final String RESOURCE_CLUSTER = "Cluster";
    public static final String RESOURCE_NAMESPACE = "Namespace";
    public static final String RESOURCE_NODE = "Node";

    //workload
    public static final String RESOURCE_DEPLOYMENT = "Deployment";
    public static final String RESOURCE_POD = "Pod";
    public static final String RESOURCE_REPLICASET = "ReplicaSet";

    //service
    public static final String RESOURCE_SERVICE = "Service";

    //storage
    public static final String RESOURCE_PERSISTENTVOLUMECLAIM = "PersistentVolumeClaim";
    public static final String RESOURCE_PERSISTENTVOLUME = "PersistentVolume";
    public static final String RESOURCE_STORAGECLASS = "StorageClass";

    //management
    public static final String RESOURCE_LIMITRANGE = "LimitRange";
    public static final String RESOURCE_RESOURCEQUOTA = "ResourceQuota";
    public static final String RESOURCE_ROLE = "Role";

    public static final String RESOURCE_NAME = "name";
    public static final String RESOURCE_CREATIONTIMESTAMP = "creationTimestamp";
    public static final String RESOURCE_METADATA = "metadata";
    public static final String RESOURCE_NS = "namespace";
    public static final String RESOURCE_ANNOTATIONS = "annotations";




    public static final String noName = "[-]";
    public static final String separatorString =  "," ;

    public static final Integer EVENT_DEFAULT_LIMIT  = 5;
    public static final String PERSISTENT_HOST_PATH_FIELD = "hostPath";

    public static final String REPLICASETS_FOR_SELECTOR = "replicaSets";
    public static final String DEPLOYMENTS_FOR_SELECTOR = "deployments";
    public static final String NULL_REPLACE_TEXT = "-";

    public static final String PARAM_QUERY_FIRST ="?" ;
    public static final String PARAM_QUERY_AND = "&";

    public static final String U_LANG_KO = "ko";
    public static final String U_LANG_KO_START_WITH = "ko_";
    public static final String U_LANG_ENG = "en";


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
            put(RESOURCE_PERSISTENTVOLUME, SERVICE_PACKAGE + "storages.persistentVolumes:PersistentVolumesService");     // PersistentVolume 서비스
            put(RESOURCE_STORAGECLASS, SERVICE_PACKAGE + "storages.storageClasses:StorageClassesService");     // StorageClass 서비스
            put(RESOURCE_RESOURCEQUOTA, SERVICE_PACKAGE + "clusters.resourceQuotas:ResourceQuotasService");     // ResourceQuota 서비스
            put(RESOURCE_LIMITRANGE, SERVICE_PACKAGE + "clusters.limitRanges:LimitRangesService");     // LimitRange 서비스
            put(RESOURCE_ROLE, SERVICE_PACKAGE + "roles:RolesService"); // Role 서비스
        }

    });

    /*
    public static final ResultStatus SUCCESS_RESULT_STATUS = new ResultStatus(Constants.RESULT_STATUS_SUCCESS, CommonStatusCode.OK.getMsg(),
            CommonStatusCode.OK.getCode(),CommonStatusCode.OK.getMsg(), null );

    public static final ResultStatus BAD_REQUEST_ACCESS_RESULT_STATUS = new ResultStatus(Constants.RESULT_STATUS_FAIL,
            CommonStatusCode.BAD_REQUEST.getMsg(), CommonStatusCode.BAD_REQUEST.getCode(),CommonStatusCode.BAD_REQUEST.getMsg(), null );

    public static final ResultStatus FORBIDDEN_ACCESS_RESULT_STATUS = new ResultStatus(Constants.RESULT_STATUS_FAIL,
            CommonStatusCode.FORBIDDEN.getMsg(), CommonStatusCode.FORBIDDEN.getCode(),CommonStatusCode.FORBIDDEN.getMsg());

    public static final ResultStatus NOT_FOUND_RESULT_STATUS = new ResultStatus(Constants.RESULT_STATUS_FAIL,
            CommonStatusCode.NOT_FOUND.getMsg(), CommonStatusCode.NOT_FOUND.getCode(),CommonStatusCode.NOT_FOUND.getMsg());

    public static final ResultStatus NOT_MATCH_NAMESPACES = new ResultStatus(Constants.RESULT_STATUS_FAIL, MessageConstant.NOT_MATCH_NAMESPACES.getMsg(),
            CommonStatusCode.BAD_REQUEST.getCode(),CommonStatusCode.BAD_REQUEST.getMsg(), null );

    public static final ResultStatus DO_NOT_DELETE_DEFAULT_RESOURCES = new ResultStatus(Constants.RESULT_STATUS_FAIL, MessageConstant.DO_NOT_DELETE_DEFAULT_RESOURCES.getMsg(),
            CommonStatusCode.BAD_REQUEST.getCode(),MessageConstant.DO_NOT_DELETE_DEFAULT_RESOURCES.getMsg(), null );

    public static final ResultStatus MANDATORY_NAMESPACE_AND_ROLE = new ResultStatus(Constants.RESULT_STATUS_FAIL, MessageConstant.MANDATORY_NAMESPACE_AND_ROLE.getMsg(),
            CommonStatusCode.BAD_REQUEST.getCode(),MessageConstant.MANDATORY_NAMESPACE_AND_ROLE.getMsg(), null );

    public static final ResultStatus UNAPPROACHABLE_USERS = new ResultStatus(Constants.RESULT_STATUS_FAIL, MessageConstant.UNAPPROACHABLE_USERS.getMsg(),
            CommonStatusCode.BAD_REQUEST.getCode(),MessageConstant.UNAPPROACHABLE_USERS.getMsg(), null );

    public static final ResultStatus REQUIRES_NAMESPACE_ADMINISTRATOR_ASSIGNMENT = new ResultStatus(Constants.RESULT_STATUS_FAIL, MessageConstant.REQUIRES_NAMESPACE_ADMINISTRATOR_ASSIGNMENT.getMsg(),
            CommonStatusCode.BAD_REQUEST.getCode(),MessageConstant.REQUIRES_NAMESPACE_ADMINISTRATOR_ASSIGNMENT.getMsg(), null );

    public static final ResultStatus UNABLE_TO_CREATE_RESOURCE_NAME = new ResultStatus(Constants.RESULT_STATUS_FAIL, MessageConstant.NOT_ALLOWED_RESOURCE_NAME.getMsg(),
            CommonStatusCode.BAD_REQUEST.getCode(),MessageConstant.NOT_ALLOWED_RESOURCE_NAME.getMsg(), null );

    public static final ResultStatus REQUEST_VALUE_IS_MISSING = new ResultStatus(Constants.RESULT_STATUS_FAIL, MessageConstant.REQUEST_VALUE_IS_MISSING.getMsg(),
            CommonStatusCode.BAD_REQUEST.getCode(),MessageConstant.REQUEST_VALUE_IS_MISSING.getMsg(), null );

    //SIGN UP

    public static final ResultStatus CLUSTER_ADMINISTRATOR_IS_ALREADY_REGISTERED = new ResultStatus(Constants.RESULT_STATUS_FAIL, MessageConstant.CLUSTER_ADMINISTRATOR_IS_ALREADY_REGISTERED_MESSAGE.getMsg(),
            CommonStatusCode.CONFLICT.getCode(),MessageConstant.CLUSTER_ADMINISTRATOR_IS_ALREADY_REGISTERED_MESSAGE.getMsg(), null );

    public static final ResultStatus USER_ALREADY_REGISTERED = new ResultStatus(Constants.RESULT_STATUS_FAIL, MessageConstant.USER_ALREADY_REGISTERED_MESSAGE.getMsg(),
            CommonStatusCode.CONFLICT.getCode(),MessageConstant.USER_ALREADY_REGISTERED_MESSAGE.getMsg(), null );

    public static final ResultStatus USERS_REGISTERED_CHECK_FAIL = new ResultStatus(Constants.RESULT_STATUS_FAIL, MessageConstant.USERS_REGISTERED_CHECK_FAIL_MESSAGE.getMsg(),
            CommonStatusCode.INTERNAL_SERVER_ERROR.getCode() ,MessageConstant.USERS_REGISTERED_CHECK_FAIL_MESSAGE.getMsg() );

    public static final ResultStatus CREATE_USERS_FAIL = new ResultStatus(Constants.RESULT_STATUS_FAIL, MessageConstant.SIGNUP_USER_CREATION_FAILED.getMsg(),
            CommonStatusCode.INTERNAL_SERVER_ERROR.getCode() ,MessageConstant.SIGNUP_USER_CREATION_FAILED.getMsg());

    public static final ResultStatus USER_NOT_REGISTERED_IN_KEYCLOAK = new ResultStatus(Constants.RESULT_STATUS_FAIL, MessageConstant.USER_NOT_REGISTERED_IN_KEYCLOAK_MESSAGE.getMsg(),
            CommonStatusCode.UNAUTHORIZED.getCode(),MessageConstant.USER_NOT_REGISTERED_IN_KEYCLOAK_MESSAGE.getMsg(), null );

    public static final ResultStatus INVALID_USER_SIGN_UP = new ResultStatus(Constants.RESULT_STATUS_FAIL, MessageConstant.USER_SIGN_UP_INFO_REQUIRED.getMsg(),
            CommonStatusCode.BAD_REQUEST.getCode(),MessageConstant.USER_SIGN_UP_INFO_REQUIRED.getMsg(), null );

    public static final ResultStatus INVALID_SERVICE_INSTANCE_ID = new ResultStatus(Constants.RESULT_STATUS_FAIL, MessageConstant.INVALID_SERVICE_INSTANCE_ID.getMsg(),
            CommonStatusCode.UNAUTHORIZED.getCode(),MessageConstant.INVALID_SERVICE_INSTANCE_ID.getMsg(), null );
            */

    public Constants() {
        throw new IllegalStateException();
    }

    /**
     * The enum List object type
     */
    public enum ListObjectType {
        LIMIT_RANGES_ITEM,
        COMMON_OWNER_REFERENCES,
        STRING
    }

    public static final String STRING_CONDITION_READY = "Ready";
}
