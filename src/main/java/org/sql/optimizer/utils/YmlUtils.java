package org.sql.optimizer.utils;

import org.ho.yaml.Yaml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql.optimizer.config.OptimizeConfiguration;

import java.io.File;
import java.io.FileNotFoundException;

public class YmlUtils {
    private final static Logger logger = LoggerFactory.getLogger(YmlUtils.class);

    public static OptimizeConfiguration loadConfig() {
        File dumpFile = new File(System.getProperty("user.dir") + "/src/main/resources/conf/OptimizeConfiguration.yaml");
        try {
            return (OptimizeConfiguration) Yaml.loadType(dumpFile, OptimizeConfiguration.class);
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }
        return new OptimizeConfiguration();
    }
}
