package org.paasta.container.platform.api.overview;

import lombok.Data;

import java.util.Map;

/**
 * Overview Model 클래스
 *
 * @author hrjin
 * @version 1.0
 * @since 2020.10.30
 **/
@Data
public class Overview {
    private String resultCode;
    private String resultMessage;
    private Integer httpStatusCode;
    private String detailMessage;
    private String nextActionUrl;

    private Integer namespacesCount;
    private Integer deploymentsCount;
    private Integer podsCount;
    private Integer usersCount;

    private Map<String, Object> deploymentsUsage;
    private Map<String, Object> podsUsage;
    private Map<String, Object> replicaSetsUsage;


}
