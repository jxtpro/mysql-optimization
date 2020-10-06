package org.sql.optimizer.debris;

import org.sql.optimizer.StatisticsResult;
import org.sql.optimizer.execption.SqlOptimizeExecption;

public interface DebrisOptimizer {
    StatisticsResult optimize(StatisticsResult statisticsResult) throws SqlOptimizeExecption;
}
