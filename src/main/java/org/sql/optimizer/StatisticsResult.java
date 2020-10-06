package org.sql.optimizer;

import java.util.ArrayList;
import java.util.List;

public class StatisticsResult {

    private List<OptimizerStatistics> statisticsList = new ArrayList<>();

    public List<OptimizerStatistics> getStatisticsList() {
        return statisticsList;
    }

    public void setStatisticsList(List<OptimizerStatistics> statisticsList) {
        this.statisticsList = statisticsList;
    }
}
