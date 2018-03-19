package com.parawan.loginconfig;

public class Configuration {
    private String facebookAppId;
    private String testFacebookAppId;
    private String facebookAppSecret;
    private String testFacebookAppSecret;

    public String getTestFacebookAppId() {
        return testFacebookAppId;
    }

    public String getTestFacebookAppSecret() {
        return testFacebookAppSecret;
    }

    public String getFacebookAppSecret() {return facebookAppSecret; }

    public String getFacebookAppId() {return facebookAppId;}
}