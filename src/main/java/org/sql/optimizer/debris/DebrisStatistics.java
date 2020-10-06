package org.sql.optimizer.debris;

import org.sql.optimizer.StatisticsResult;
import org.sql.optimizer.execption.SqlStatisticsExecption;

public interface DebrisStatistics {
    StatisticsResult statistics() throws SqlStatisticsExecption;
}
