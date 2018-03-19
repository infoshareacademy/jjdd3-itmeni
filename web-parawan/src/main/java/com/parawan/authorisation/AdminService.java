package com.parawan.authorisation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Singleton;
import java.io.IOException;

@Singleton
public class AdminService {
    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);

    private final AdminConfiguration adminConfiguration;

    public AdminService() {
        adminConfiguration = loadAdminFile();
    }

    public AdminConfiguration getAdminConfiguration() {
        return adminConfiguration;
    }

    public boolean isAdmin(String email) {
        return adminConfiguration.getAdmins().contains(email);
    }

    private AdminConfiguration loadAdminFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.reader(AdminConfiguration.class).readValue(AdminService.class.getResourceAsStream("/admin_email_list.json"));
        } catch (IOException e) {
            logger.error("caught an exception during loading AdminFile", e);
            throw new RuntimeException(e);
        }
    }
}