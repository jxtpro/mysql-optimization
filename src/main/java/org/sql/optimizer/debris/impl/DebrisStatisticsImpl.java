package org.sql.optimizer.debris.impl;

import org.sql.optimizer.StatisticsResult;
import org.sql.optimizer.utils.OptimizerStatisticsUtils;
import org.sql.optimizer.utils.YmlUtils;
import org.sql.optimizer.debris.DebrisStatistics;
import org.sql.optimizer.execption.ExecSqlException;
import org.sql.optimizer.execption.SqlStatisticsExecption;
import org.sql.optimizer.sql.JdbcManager;
import org.sql.optimizer.sql.JdbcManagerImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DebrisStatisticsImpl implements DebrisStatistics {

    private JdbcManager jdbcManager;

    public DebrisStatisticsImpl(JdbcManager jdbcManager) {
        if (jdbcManager != null) {
            this.jdbcManager = jdbcManager;
        } else {
            this.jdbcManager = new JdbcManagerImpl(YmlUtils.loadConfig());
        }
    }

    @Override
    public StatisticsResult statistics() throws SqlStatisticsExecption {
        String statisticsSql = "SELECT table_schema,table_name,CONCAT('alter table ',table_name, ' engine=Innodb ;') AS HELP,(data_length+index_length)/1024/1024 LENGTH,ENGINE,data_free/1024/1024 as data_free,table_rows FROM information_schema.tables WHERE table_schema NOT IN ('information_schema','mysql','performance_schema')      AND data_free !=0 GROUP BY table_name ORDER BY table_rows ASC;";
        try {
           return jdbcManager.execSql(statisticsSql);
        } catch (ExecSqlException e) {
            e.printStackTrace();
        }
        return new StatisticsResult();
    }
}
