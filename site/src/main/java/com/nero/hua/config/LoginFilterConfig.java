package com.nero.hua.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@ConfigurationProperties("filter.login-filter")
@Getter
@Setter
@Component
public class LoginFilterConfig {

    private List<String> excludeURIList;

    public Boolean exclude(String URI) {
        if (CollectionUtils.isEmpty(excludeURIList)) {
            return Boolean.FALSE;
        }

        for (String excludeURI : excludeURIList) {
            if (URI.contains(excludeURI)) {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }
}
