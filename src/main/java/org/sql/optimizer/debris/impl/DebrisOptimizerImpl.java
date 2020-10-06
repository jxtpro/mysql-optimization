package org.sql.optimizer.debris.impl;

import org.sql.optimizer.config.OptimizationModeEnum;
import org.sql.optimizer.config.OptimizeConfiguration;
import org.sql.optimizer.OptimizerStatistics;
import org.sql.optimizer.StatisticsResult;
import org.sql.optimizer.execption.ExecSqlException;
import org.sql.optimizer.utils.YmlUtils;
import org.sql.optimizer.debris.DebrisOptimizer;
import org.sql.optimizer.execption.SqlOptimizeExecption;
import org.sql.optimizer.sql.JdbcManager;
import org.sql.optimizer.sql.JdbcManagerImpl;

import java.util.List;

public class DebrisOptimizerImpl implements DebrisOptimizer {

    private JdbcManager jdbcManager;
    private OptimizeConfiguration optimizeConfiguration = YmlUtils.loadConfig();

    public DebrisOptimizerImpl(JdbcManager jdbcManager) {
        if (jdbcManager != null) {
            this.jdbcManager = jdbcManager;
        } else {
            this.jdbcManager = new JdbcManagerImpl(optimizeConfiguration);
        }
    }

    @Override
    public StatisticsResult optimize(StatisticsResult statisticsResult) throws SqlOptimizeExecption {
        List<OptimizerStatistics> optimizerStatisticsList = statisticsResult.getStatisticsList();
        StringBuilder optimizerTable = new StringBuilder();

        if (optimizerStatisticsList != null) {
            for (OptimizerStatistics optimizerStatistics : optimizerStatisticsList) {
                if (OptimizationModeEnum.ENGINE.getMode() == optimizeConfiguration.getOptimizationMode()
                        && optimizeConfiguration.getOptimizationThreshold() <= optimizerStatistics.getDataFree()) {
                    optimizerTable.append(optimizerStatistics.getHelp());
                } else if (OptimizationModeEnum.OPTIMIZE.getMode() == optimizeConfiguration.getOptimizationMode()
                        && optimizeConfiguration.getOptimizationThreshold() <= optimizerStatistics.getDataFree()) {
                    optimizerTable.append("optimize ").append("table ").append(optimizerStatistics.getTableSchema())
                            .append(" ").append(optimizerStatistics.getTableName()).append(";");
                }
            }
        }
        try {
            jdbcManager.execSql(optimizerTable.toString());
        } catch (ExecSqlException e) {
            e.printStackTrace();
        }

        return new StatisticsResult();
    }
}
