package org.sql.optimizer.sql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql.optimizer.config.OptimizeConfiguration;
import org.sql.optimizer.StatisticsResult;
import org.sql.optimizer.utils.OptimizerStatisticsUtils;
import org.sql.optimizer.utils.YmlUtils;

import java.sql.*;

public class JdbcManagerImpl implements JdbcManager {

    private OptimizeConfiguration optimizeConfiguration;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public JdbcManagerImpl(OptimizeConfiguration optimizeConfiguration) {
        if (optimizeConfiguration != null) {
            this.optimizeConfiguration = optimizeConfiguration;
        } else {
            this.optimizeConfiguration = YmlUtils.loadConfig();
        }
    }

    @Override
    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(optimizeConfiguration.getDriverClassName());
            con = DriverManager.getConnection(optimizeConfiguration.getJdbcUrl(), optimizeConfiguration.getUserName(), optimizeConfiguration.getPassWord());
        } catch (ClassNotFoundException | SQLException e) {
            logger.error(e.getMessage());
        }
        return con;
    }

    private void closeConnection(Connection connection) {
        try {
            if (connection != null) connection.close();  //必须要关
        } catch (Exception e) {
        }
    }

    private void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    private void closePreparedStatement(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) preparedStatement.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public StatisticsResult execSql(String sql) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StatisticsResult statisticsResult = new StatisticsResult();
        con = getConnection();
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            statisticsResult.getStatisticsList().addAll(OptimizerStatisticsUtils.resultSetToListOptimizerStatistics(rs));
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pstmt);
            closeConnection(con);
        }
        return statisticsResult;
    }
}
