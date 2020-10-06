package org.sql.optimizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql.optimizer.job.QuartzTask;
import org.sql.optimizer.utils.JobUtils;
import org.sql.optimizer.utils.YmlUtils;

import java.util.concurrent.Semaphore;

/**
 * @author xujie
 */
public class SqlOptimizerApp {
    private final static Logger logger = LoggerFactory.getLogger(SqlOptimizerApp.class);
    public static void main(String[] args) {
        String job_name = "----------------- mysql5.7碎片化自动优化 ----------------";
        logger.info("-----------------【任务启动】开始(每10秒输出一次) ---------------");
        JobUtils.addJob(job_name, QuartzTask.class, YmlUtils.loadConfig().getCronExpression());
        Semaphore semaphore = new Semaphore(0);
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
