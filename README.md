# mysql-optimization碎片化自动优化

###### 功能列表

1. 支持Cron表达式定时任务
2. 支持两种模式优化
3. 支持mysql版本5.7
4. 支持超量碎片阈值优化
5. 支持超量阈值记录
6. 支持jar快速部署
7. 支持指认日志路径(待完成)

###### 优化模式

1. 修改engine模式：支持Innodb引擎数据库
2. optimize模式： 支持MYISAM引擎数据库,且锁表

###### 核心流程

![核心流程](https://github.com/jxtpro/mysql-optimization/blob/master/screenshot/core-1.png)


![核心类设计](https://github.com/jxtpro/mysql-optimization/blob/master/screenshot/core-2.png)

