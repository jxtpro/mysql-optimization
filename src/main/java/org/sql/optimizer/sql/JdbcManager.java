package org.sql.optimizer.sql;

import org.sql.optimizer.StatisticsResult;
import org.sql.optimizer.execption.ConnectionException;
import org.sql.optimizer.execption.ExecSqlException;

import java.sql.Connection;


public interface JdbcManager {
    Connection getConnection() throws ConnectionException;
    StatisticsResult execSql(String sql) throws ExecSqlException;
}
