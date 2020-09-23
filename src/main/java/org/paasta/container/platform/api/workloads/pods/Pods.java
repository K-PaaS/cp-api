package org.paasta.container.platform.api.workloads.pods;

import lombok.Data;
import org.paasta.container.platform.api.common.model.CommonMetaData;
import org.paasta.container.platform.api.common.model.CommonSpec;
import org.paasta.container.platform.api.common.model.CommonStatus;

import java.util.Map;

/**
 * Pods Model 클래스
 *
 * @author hrjin
 * @version 1.0
 * @since 2020.09.09
 */
@Data
public class Pods {
    private String resultCode;
    private String nextActionUrl;

    private CommonMetaData metadata;
    private CommonSpec spec;
    private CommonStatus status;
    private String selector;

    private Map<String, Object> source;
    private String sourceTypeYaml;
}
