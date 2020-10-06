package org.sql.optimizer.config;

public enum OptimizationModeEnum {
    ENGINE(1, "engine"),
    OPTIMIZE(2, "optimize");

    private int mode;
    private String modeName;

    OptimizationModeEnum(int mode, String modeName){
        this.mode = mode;
        this.modeName = modeName;
    }

    public int getMode() {
        return mode;
    }

    public String getModeName() {
        return modeName;
    }
}
