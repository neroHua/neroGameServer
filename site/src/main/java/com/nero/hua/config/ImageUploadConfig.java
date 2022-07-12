package com.nero.hua.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@ConfigurationProperties("image.upload")
@Getter
@Setter
@Component
public class ImageUploadConfig {

    private String realPrefixPath;

    private String virtualPrefixPath;

    public String getRealPrefixPath() {
        return realPrefixPath;
    }

    public void setRealPrefixPath(String realPrefixPath) {
        this.realPrefixPath = realPrefixPath;
    }

    public String getVirtualPrefixPath() {
        return virtualPrefixPath;
    }

    public void setVirtualPrefixPath(String virtualPrefixPath) {
        this.virtualPrefixPath = virtualPrefixPath;
    }
}
