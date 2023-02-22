# 第1章 Hive基本概念

- 主要研究写sql

## 1.1 什么是Hive

**1）Hive简介**
		Hive：由Facebook开源用于解决海量结构化日志的数据统计工具。
		Hive是基于Hadoop的一个数据仓库工具，可以**将结构化的数据文件映射为一张表**，并提供类SQL查询功能。
**2）Hive本质：将HQL转化成MapReduce程序。**

- 元数据：描述数据的数据

![1654826796048](./imgs\220610-1654826796048.png)

​	（1）Hive处理的数据存储在HDFS
​	（2）Hive分析数据底层的实现是MapReduce
​	（3）执行程序运行在Yarn上

## 1.2 Hive的优缺点

### 1.2.1 优点

（1）操作接口采用类SQL语法，提供快速开发的能力（简单、容易上手）。
（2）避免了去写MapReduce，减少开发人员的学习成本。
（3）Hive优势在于处理大数据，**支持海量数据的分析与计算。**
（4）Hive支持用户自定义函数，用户可以根据自己的需求来实现自己的函数。

### 1.2.2 缺点

**1）Hive的HQL表达能力有限**
（1）Hive自动生成的MapReduce作业，通常情况下不够智能化。
（2）数据挖掘方面不擅长，由于MapReduce数据处理流程的限制，效率更高的算法却无法实现。
**2）Hive的效率比较低**
（1）Hive的执行延迟比较高，因此Hive常用于数据分析，对实时性要求不高的场合。
（2）Hive调优比较困难，粒度较粗。
**3）Hive不支持实时查询和行级别更新**
（1）Hive分析的数据是存储在 **HDFS** 上，**HDFS** 不支持随机写，只支持追加写，所以在 Hive 中不能 update 和delete，能 select 和 insert。

## 1.3 Hive架构原理

![1654827886796](./imgs\220610-1654827886796.png)

1）用户接口：Client
CLI（command-line interface）、JDBC/ODBC（jdbc访问Hive）
2）元数据：Metastore
元数据包括：表名、表所属的数据库（默认是default）、表的拥有者、列/分区字段、表的类型（是否是外部表）、表的数据所在目录等。
默认存储在自带的derby数据库中，推荐使用MySQL存储Metastore。
3）Hadoop
使用HDFS进行存储，使用MapReduce进行计算。
4）驱动器：Driver
（1）解析器（SQL Parser）：将SQL字符串转换成抽象语法树AST，这一步一般都用第三方工具库完成，比如antlr；对AST进行语法分析，比如表是否存在、字段是否存在、SQL语义是否有误。
（2）编译器（Physical Plan）：将AST编译生成逻辑执行计划。
（3）优化器（Query Optimizer）：对逻辑执行计划进行优化。
（4）执行器（Execution）：把逻辑执行计划转换成可以运行的物理计划。对于Hive来说，就是MR/Spark。

![1654828191221](./imgs\220610-1654828191221.png)

Hive通过给用户提供的一系列交互接口，接收到用户的指令（SQL），使用自己的Driver，结合元数据（MetaStore），将这些指令翻译成MapReduce，提交到Hadoop中执行，最后，将执行返回的结果输出到用户交互接口。

## **1.4** **Hive和数据库比较** 

![](https://raw.githubusercontent.com/KK-0613/KK-Image/main/vnote/04_my_note/220610-hive%E7%8E%AF%E5%A2%83.md/393935116262037.png)

# 第2章 Hive安装

## 2.1 Hive安装地址

1）Hive官网地址
http://hive.apache.org/
2）文档查看地址
https://cwiki.apache.org/confluence/display/Hive/GettingStarted
3）下载地址
http://archive.apache.org/dist/hive/
4）github地址
https://github.com/apache/hive

## 2.2Hive安装部署

# Hive安装(只安装102)

1. 拷贝以下文件到集群

   ```
   01_mysql-community-common-5.7.29-1.el7.x86_64.rpm
   02_mysql-community-libs-5.7.29-1.el7.x86_64.rpm
   03_mysql-community-libs-compat-5.7.29-1.el7.x86_64.rpm
   04_mysql-community-client-5.7.29-1.el7.x86_64.rpm
   05_mysql-community-server-5.7.29-1.el7.x86_64.rpm
   apache-hive-3.1.2-bin.tar.gz
   hive_services.sh
   init.sql
   mysql-connector-java-5.1.48.jar
   remove_mysql.sh
   ```

2. 部署MySQL

   - 移除旧的MySQL安装包或者依赖

     ```bash
     sudo bash /opt/software/remove_mysql.sh
     ```

   - 安装新的MySQL

     ```bash
     sudo yum install -y \
     /opt/software/01_mysql-community-common-5.7.29-1.el7.x86_64.rpm \
     /opt/software/02_mysql-community-libs-5.7.29-1.el7.x86_64.rpm \
     /opt/software/03_mysql-community-libs-compat-5.7.29-1.el7.x86_64.rpm \
     /opt/software/04_mysql-community-client-5.7.29-1.el7.x86_64.rpm \
     /opt/software/05_mysql-community-server-5.7.29-1.el7.x86_64.rpm
     ```

     或者

     ```bash
     ls /opt/software/*.rpm | xargs -n1 sudo rpm -ivh
     ```

   - 初始化MySQL

     ```bash
     # 首先启动MySQL服务
     sudo systemctl start mysqld
     
     # 初始化MySQL，主要是修改root密码和登录位置
     mysql --connect-expired-password -uroot \
     -p"$(sudo cat /var/log/mysqld.log | grep "temporary password" | awk '{print $NF}')" \
     < /opt/software/init.sql
     ```

   - 如果安装过程中出现问题，就从最开始卸载的部分重来一次就行

3. 部署Hive

   - 解压HIVE，并添加环境变量

     ```bash
     # 解压
     tar -zxf /opt/software/apache-hive-3.1.2-bin.tar.gz -C /opt/module
     
     # 重命名
     mv /opt/module/apache-hive-3.1.2-bin /opt/module/hive
     
     # 添加环境变量
     sudo vim /etc/profile.d/my_env.sh
     
     # 追加如下内容
     #HIVE_HOME
     export HIVE_HOME=/opt/module/hive
     export PATH=$PATH:$HIVE_HOME/bin
     ```

     **保存过后，重启xshell窗口**

     **保存过后，重启xshell窗口**

     **保存过后，重启xshell窗口**

   - 配置HIVE

     - 修改HDFS的配置：core-site.xml

       ```xml
         <!-- 配置该atguigu(superUser)允许通过代理访问的主机节点 -->
         <property>
           <name>hadoop.proxyuser.atguigu.hosts</name>
           <value>*</value>
         </property>
         <!-- 配置该atguigu(superUser)允许通过代理用户所属组 -->
         <property>
           <name>hadoop.proxyuser.atguigu.groups</name>
           <value>*</value>
         </property>
         <!-- 配置该atguigu(superUser)允许通过代理的用户-->
         <property>
           <name>hadoop.proxyuser.atguigu.users</name>
           <value>*</value>
         </property>
       ```

       完成后保存并同步

       ```bash
       xsync /opt/module/hadoop-3.1.3/etc/hadoop/core-site.xml
       ```

     - 新建hive的配置：hive-site.xml

       - 注意修改所有者与权限

       ```bash
       # 新建一个hive-site.xml文件
       sudo vim /opt/module/hive/conf/hive-site.xml
       
       # 修改所有者
       sudo chown atguigu:atguigu /opt/module/hive/conf/hive-site.xml
       
       # 修改权限
       sudo chmod 744 /opt/module/hive/conf/hive-site.xml
       
       ```

       内容如下：

       - 注意修改配置文件的时候使用UTF-8编码

       ```xml
       <?xml version="1.0"?>
       <?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
       
       <configuration>
         <!-- jdbc连接的URL -->
         <property>
           <name>javax.jdo.option.ConnectionURL</name>
           <value>jdbc:mysql://hadoop102:3306/metastore?useSSL=false</value>
         </property>
       
         <!-- jdbc连接的Driver-->
         <property>
           <name>javax.jdo.option.ConnectionDriverName</name>
           <value>com.mysql.jdbc.Driver</value>
         </property>
       
         <!-- jdbc连接的username-->
         <property>
           <name>javax.jdo.option.ConnectionUserName</name>
           <value>root</value>
         </property>
       
         <!-- jdbc连接的password -->
         <property>
           <name>javax.jdo.option.ConnectionPassword</name>
           <value>000000</value>
         </property>
       
         <!-- Hive默认在HDFS的工作目录 -->
         <property>
           <name>hive.metastore.warehouse.dir</name>
           <value>/user/hive/warehouse</value>
         </property>
         <!-- 指定hiveserver2连接的host -->
         <property>
           <name>hive.server2.thrift.bind.host</name>
           <value>hadoop102</value>
         </property>
       
         <!-- 指定hiveserver2连接的端口号 -->
         <property>
           <name>hive.server2.thrift.port</name>
           <value>10000</value>
         </property>
       
         <!-- hiveserver2的高可用参数，开启此参数可以提高hiveserver2的启动速度 -->
         <property>
           <name>hive.server2.active.passive.ha.enable</name>
           <value>true</value>
         </property>
       
       </configuration>
       
       ```

     - 拷贝JDBC驱动到HIVE

       ```bash
       cp /opt/software/mysql-connector-java-5.1.48.jar /opt/module/hive/lib
       
       ```

     - 修改HIVE堆内存

       ```bash
       # 重命名hive-env.sh
       mv /opt/module/hive/conf/hive-env.sh.template /opt/module/hive/conf/hive-env.sh
       
       ```

       ```bash
       # 将
       # export HADOOP_HEAPSIZE=1024
       # 修改为
       export HADOOP_HEAPSIZE=1024
       
       ```

     - 修改hive日志目录的配置（可选）

       ```bash
       # 重命名hive-log4j2.properties
       mv /opt/module/hive/conf/hive-log4j2.properties.template /opt/module/hive/conf/hive-log4j2.properties
       
       ```

       ```properties
       #将property.hive.log.dir这一行改为
       property.hive.log.dir = /opt/module/hive/logs
       
       ```

     - 处理Hive和Hadoop的Jar包冲突（可选）

       ```bash
       mv /opt/module/hive/lib/log4j-slf4j-impl-2.10.0.jar /opt/module/hive/lib/log4j-slf4j-impl-2.10.0.jar.bak
       
       ```

   - 初始化HIVE

     ```bash
     # 在MySQL中新建一个metastore数据库
     mysql -uroot -p000000 -e"drop database if exists metastore;create database metastore;"
     
     # 初始化HIVE元数据库
     schematool -initSchema -dbType mysql -verbose
     
     ```

   - 启动hiveserver2服务器

     - 首先要先启动集群

       ```bash
       start-dfs.sh
       ssh hadoop103 "start-yarn.sh"
       
       ```

     - hive服务启动命令

       ```
       hiveserver2
       
       ```

     - 写一个后台启动脚本

       ```bash
       mv /opt/software/hive_services.sh /opt/module/hive/bin
       chmod +x /opt/module/hive/bin/hive_services.sh
       
       ```

       用脚本启动hive

       ```bash
       hive_serivces.sh start/stop/restart/status
       
       ```

4. 连接Hive服务

   - Hive自带的Beeline客户端

     ```bash
     beeline -u jdbc:hive2://hadoop102:10000 -n atguigu
     ```
     
- IDEA连接

# Linux基础普及

- bash

# 第3章 Hive数据类型

## 3.1 基本数据类型

| ***\*H\*******\*IVE\**** | ***\*M\*******\*ySQL\**** | ***\*JAVA\**** | ***\*长度\****                                       | ***\*例子\****                      |
| ------------------------ | ------------------------- | -------------- | ---------------------------------------------------- | ----------------------------------- |
| TINYINT                  | TINYINT                   | byte           | 1byte有符号整数                                      | 2                                   |
| SMALINT                  | SMALINT                   | short          | 2byte有符号整数                                      | 20                                  |
| INT                      | INT                       | int            | 4byte有符号整数                                      | 20                                  |
| BIGINT                   | BIGINT                    | long           | 8byte有符号整数                                      | 20                                  |
| BOOLEAN                  | 无                        | boolean        | 布尔类型，true或者false                              | TRUE  FALSE                         |
| FLOAT                    | FLOAT                     | float          | 单精度浮点数                                         | 3.14159                             |
| DOUBLE                   | DOUBLE                    | double         | 双精度浮点数                                         | 3.14159                             |
| STRING                   | VARCHAR                   | string         | 字符系列。可以指定字符集。可以使用单引号或者双引号。 | ‘now is the time’“for all good men” |
| TIMESTAMP                | TIMESTAMP                 |                | 时间类型                                             |                                     |
| BINARY                   | BINARY                    |                | 字节数组                                             |                                     |

​		对于Hive的String类型相当于数据库的varchar类型，该类型是一个可变的字符串，不过它不能声明其中最多能存储多少个字符，理论上它可以存储2GB的字符数。

## 3.2 集合数据类型

| ***\*数据类型\**** | ***\*描述\****                                               | ***\*语法示例\****                             |
| ------------------ | ------------------------------------------------------------ | ---------------------------------------------- |
| STRUCT             | 和c语言中的struct类似，都可以通过“点”符号访问元素内容。例如，如果某个列的数据类型是STRUCT{first STRING, last STRING}，那么第1个元素可以通过字段.first来引用。 | struct()例如struct<street:string, city:string> |
| MAP                | MAP是一组键-值对元组集合，使用数组表示法可以访问数据。例如，如果某个列的数据类型是MAP，其中键->值对是’first’->’John’和’last’->’Doe’，那么可以通过字段名[‘last’]获取最后一个元素 | map()例如map<string, int>                      |
| ARRAY              | 数组是一组具有相同类型和名称的变量的集合。这些变量称为数组的元素，每个数组元素都有一个编号，编号从零开始。例如，数组值为[‘John’, ‘Doe’]，那么第2个元素可以通过数组名[1]进行引用。 | Array()例如array<string>                       |

​			Hive有三种复杂数据类型ARRAY、MAP和STRUCT。ARRAY和MAP与Java中的Array和Map类似，而STRUCT与C语言中的Struct类似，它封装了一个命名字段集合，复杂数据类型允许任意层次的嵌套。



## 3.3 类型转化

​		Hive的原子数据类型是可以进行隐式转换的，类似于Java的类型转换，例如某表达式使用INT类型，TINYINT会自动转换为INT类型，但是Hive不会进行反向转化，例如，某表达式使用TINYINT类型，INT不会自动转换为TINYINT类型，它会返回错误，除非使用CAST操作。

**1）隐式类型转换规则如下**
（1）任何整数类型都可以隐式地转换为一个范围更广的类型，如TINYINT可以转换成INT，INT可以转换成BIGINT。
（2）所有整数类型、FLOAT和STRING类型都可以隐式地转换成DOUBLE。
（3）TINYINT、SMALLINT、INT都可以转换为FLOAT。
（4）BOOLEAN类型不可以转换为任何其它的类型。

**2）可以使用CAST操作显示进行数据类型转换**
		例如CAST('1' AS INT)将把字符串'1' 转换成整数1；如果强制类型转换失败，如执行CAST('X' AS INT)，表达式返回空值 NULL。

```properties
hive (default)> select '1' + 2, cast('1' as int) + 2;

_c0	   _c1
3.0	    3
```