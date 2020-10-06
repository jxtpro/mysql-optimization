package org.sql.optimizer;

public class OptimizerStatistics {
    private String tableSchema;
    private String tableName;
    private String help;
    private float length;
    private String engine;
    private int dataFree;
    private int tableRows;


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getDataFree() {
        return dataFree;
    }

    public void setDataFree(int dataFree) {
        this.dataFree = dataFree;
    }

    public int getTableRows() {
        return tableRows;
    }

    public void setTableRows(int tableRows) {
        this.tableRows = tableRows;
    }
}
