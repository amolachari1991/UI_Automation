package com.pojo;

import java.util.Map;

public class EnvConfigration {
    public Map<String, Environment> getEnvironments() {
        return environments;
    }

    public void setEnvironments(Map<String, Environment> environments) {
        this.environments = environments;
    }

    private Map<String,Environment> environments;
}
