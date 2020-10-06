package org.sql.optimizer.utils;

import org.sql.optimizer.OptimizerStatistics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OptimizerStatisticsUtils {

    public static OptimizerStatistics resultSetToOptimizerStatistics(ResultSet rs) throws SQLException {
        OptimizerStatistics optimizerStatistics = new OptimizerStatistics();
        optimizerStatistics.setTableSchema(rs.getString("table_schema"));
        optimizerStatistics.setTableName(rs.getString("table_name"));
        optimizerStatistics.setHelp(rs.getString("help"));
        optimizerStatistics.setDataFree(rs.getInt("data_free"));
        optimizerStatistics.setEngine(rs.getString("engine"));
        optimizerStatistics.setLength(rs.getInt("length"));
        optimizerStatistics.setTableRows(rs.getInt("table_rows"));
        return optimizerStatistics;
    }

    public static List<OptimizerStatistics> resultSetToListOptimizerStatistics(ResultSet rs) throws SQLException {
        List<OptimizerStatistics> optimizerStatisticsList = new ArrayList<>();
        while (rs.next()) {
            optimizerStatisticsList.add(resultSetToOptimizerStatistics(rs));
        }
        return optimizerStatisticsList;
    }
}
