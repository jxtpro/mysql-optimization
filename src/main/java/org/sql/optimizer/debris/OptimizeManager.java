package org.sql.optimizer.debris;

import org.sql.optimizer.StatisticsResult;

public interface OptimizeManager {
    StatisticsResult optimize(StatisticsResult statisticsResult);
    StatisticsResult statistics();
}
