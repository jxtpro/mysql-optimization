package org.sql.optimizer.job;

import com.alibaba.fastjson.JSON;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql.optimizer.OptimizerStatistics;
import org.sql.optimizer.StatisticsResult;
import org.sql.optimizer.config.OptimizeConfiguration;
import org.sql.optimizer.debris.OptimizeManager;
import org.sql.optimizer.debris.impl.OptimizeManagerImpl;
import org.sql.optimizer.utils.YmlUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuartzTask implements Job {
    private final Logger logger = LoggerFactory.getLogger(YmlUtils.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        OptimizeConfiguration optimizeConfiguration = YmlUtils.loadConfig();
        logger.info("-------- 任务开始时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        OptimizeManager optimizeManager = new OptimizeManagerImpl();
        StatisticsResult statisticsResult = optimizeManager.statistics();
        // 统计产生sql碎片化
        for (OptimizerStatistics optimizerStatistics : statisticsResult.getStatisticsList()) {
            if ( optimizeConfiguration.getDebrisRecordingThreshold() <= optimizerStatistics.getDataFree() ) {
                logger.info("{}", JSON.toJSON(optimizerStatistics));
            }
        }
        // 针对sql碎片优化
        optimizeManager.optimize(statisticsResult);
        // 再次统计 验证
        optimizeManager.statistics();
    }
}
