package org.sql.optimizer.config;

public class OptimizeConfiguration {

    private String debrisRecordLogPath;
    private String optimizationRecordLogPath;
    private int debrisRecordingThreshold;
    private int optimizationThreshold;
    private String cronExpression;
    private int optimizationMode;
    private String jdbcUrl;
    private String userName;
    private String passWord;
    private String driverClassName;


    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getDebrisRecordLogPath() {
        return debrisRecordLogPath;
    }

    public void setDebrisRecordLogPath(String debrisRecordLogPath) {
        this.debrisRecordLogPath = debrisRecordLogPath;
    }

    public int getDebrisRecordingThreshold() {
        return debrisRecordingThreshold;
    }

    public void setDebrisRecordingThreshold(int debrisRecordingThreshold) {
        this.debrisRecordingThreshold = debrisRecordingThreshold;
    }

    public String getOptimizationRecordLogPath() {
        return optimizationRecordLogPath;
    }

    public void setOptimizationRecordLogPath(String optimizationRecordLogPath) {
        this.optimizationRecordLogPath = optimizationRecordLogPath;
    }


    public int getOptimizationThreshold() {
        return optimizationThreshold;
    }

    public void setOptimizationThreshold(int optimizationThreshold) {
        this.optimizationThreshold = optimizationThreshold;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public int getOptimizationMode() {
        return optimizationMode;
    }

    public void setOptimizationMode(int optimizationMode) {
        this.optimizationMode = optimizationMode;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }
}
