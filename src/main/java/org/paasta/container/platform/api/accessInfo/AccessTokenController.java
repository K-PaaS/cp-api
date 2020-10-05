package org.paasta.container.platform.api.accessInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * AccessToken Controller 클래스
 *
 * @author hrjin
 * @version 1.0
 * @since 2020.09.29
 */
@RestController
@RequestMapping("/clusters/{cluster:.+}/namespaces/{namespace:.+}/secrets")
public class AccessTokenController {

    private final AccessTokenService accessTokenService;

    /**
     * Instantiates a new accessToken controller
     *
     * @param accessTokenService the accessToken service
     */
    @Autowired
    public AccessTokenController(AccessTokenService accessTokenService) {
        this.accessTokenService = accessTokenService;
    }

    /**
     * Secret 상세 정보를 조회한다.
     *
     * @param namespace       the namespace
     * @param accessTokenName the accessTokenName
     * @return the AccessToken
     */
    @RequestMapping(value = "/{accessTokenName:.+}")
    @ResponseBody
    public AccessToken getSecret(@PathVariable("namespace") String namespace, @PathVariable("accessTokenName") String accessTokenName) {
        return accessTokenService.getSecret(namespace, accessTokenName);
    }

}
