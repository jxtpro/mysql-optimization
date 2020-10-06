package org.sql.optimizer.debris.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql.optimizer.config.OptimizeConfiguration;
import org.sql.optimizer.StatisticsResult;
import org.sql.optimizer.debris.DebrisStatistics;
import org.sql.optimizer.debris.DebrisOptimizer;
import org.sql.optimizer.debris.OptimizeManager;
import org.sql.optimizer.execption.SqlOptimizeExecption;
import org.sql.optimizer.execption.SqlStatisticsExecption;
import org.sql.optimizer.sql.JdbcManager;
import org.sql.optimizer.sql.JdbcManagerImpl;
import org.sql.optimizer.utils.YmlUtils;

public class OptimizeManagerImpl implements OptimizeManager {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private DebrisOptimizer debrisOptimizer;
    private DebrisStatistics debrisStatistics;
    private JdbcManager jdbcManager;

    public OptimizeManagerImpl() {
        OptimizeConfiguration optimizeConfiguration = YmlUtils.loadConfig();
        jdbcManager = new JdbcManagerImpl(optimizeConfiguration);
        this.debrisOptimizer = new DebrisOptimizerImpl(jdbcManager);
        this.debrisStatistics = new DebrisStatisticsImpl(jdbcManager);
    }

    @Override
    public StatisticsResult optimize(StatisticsResult statisticsResult) {
        try {
            return debrisOptimizer.optimize(statisticsResult);
        } catch (SqlOptimizeExecption sqlOptimizeExecption) {
            logger.error(sqlOptimizeExecption.getMessage());
        }
        return new StatisticsResult();
    }

    @Override
    public StatisticsResult statistics() {
        try {
            return debrisStatistics.statistics();
        } catch (SqlStatisticsExecption sqlStatisticsExecption) {
            logger.error(sqlStatisticsExecption.getMessage());
        }
        return new StatisticsResult();
    }
}
