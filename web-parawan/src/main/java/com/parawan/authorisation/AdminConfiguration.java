package com.parawan.authorisation;

import java.util.List;

public class AdminConfiguration {

    private List<String> admins;

    public AdminConfiguration() {
    }

    public List<String> getAdmins() {
        return admins;
    }

    public void setAdmins(List<String> admins) {
        this.admins = admins;
    }
}