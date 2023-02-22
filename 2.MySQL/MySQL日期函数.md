# MySQL常用的日期函数

## MySQL 中的常用日期函数：

| 函数          | 描述                                |
| ------------- | ----------------------------------- |
| NOW()         | 返回当前的日期和时间                |
| CURDATE()     | 返回当前的日期                      |
| CURTIME()     | 返回当前的时间                      |
| DATE()        | 提取日期或日期/时间表达式的日期部分 |
| EXTRACT()     | 返回日期/时间按的单独部分           |
| DATE_ADD()    | 给日期添加指定的时间间隔            |
| DATE_SUB()    | 从日期减去指定的时间间隔            |
| DATEDIFF()    | 返回两个日期之间的天数              |
| DATE_FORMAT() | 用不同的格式显示日期/时间           |

## MySQL 使用下列数据类型在数据库中存储日期或日期/时间值

- DATE - 格式 YYYY-MM-DD
- DATETIME - 格式: YYYY-MM-DD HH:MM:SS
- TIMESTAMP - 格式: YYYY-MM-DD HH:MM:SS
- YEAR - 格式 YYYY 或 YY

## 函数说明：

1. NOW()  ：返回当前的日期和时间
2. CURDATE()  :  返回当前的日期
3. CURTIME()  :  返回当前的时间

示例如下：


​       ![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220916164014.png)

4. DATE()  :  提取日期或日期/时间表达式的日期部分

示例如下：


​      ![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220916164216.png)

5. EXTRACT()  :  函数用于返回日期/时间的单独部分，比如年、月、日、小时、分钟等等。

语法：`EXTRACT(unit FROM date)`
unit 的可选值:

| YEAR   | MICROSECOND        | DAY_MICROSECOND | HOUR_MICROSECOND   |
| ------ | ------------------ | --------------- | ------------------ |
| MONTH  | DAY_SECOND         | WEEK            | HOUR_SECOND        |
| DAY    | QUARTER            | DAY_MINUTE      | HOUR_MINUTE        |
| HOUR   | SECOND             | DAY_HOUR        | MINUTE_MICROSECOND |
| MINUTE | SECOND_MICROSECOND | YEAR_MONTH      | MINUTE_SECOND      |


示例如下：    ![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220916164527.png)

6. DATE_ADD()  :  给日期添加指定的时间间隔

 语法：`DATE_ADD(date,INTERVAL expr type)`

  type 的可选值和第五点中的unit值一样

  示例如下：

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220916164608.png)

7. DATE_SUB()  : 从日期减去指定的时间间隔

 语法：`DATE_SUB(date,INTERVAL expr type)`

 type 的可选值和第五点中的unit值一样

 示例如下：

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220916164731.png)

8. DATEDIFF()    返回两个日期之间的天数

语法： `DATEDIFF(date1,date2)`

示例如下：


![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220916164823.png)      

9. DATE_FORMAT()    函数用于以不同的格式显示日期/时间数据。

   语法：`DATE_FORMAT(date,format)`

   date 参数是合法的日期。format 规定日期/时间的输出格式。

   可以使用的格式有：

   | 格式 | 描述                   | 格式 | 描述                                           |
   | ---- | ---------------------- | ---- | ---------------------------------------------- |
   | %a   | 缩写星期名             | %p   | AM 或 PM                                       |
   | %b   | 缩写月名               | %r   | 时间，12-小时（hh:mm:ss AM 或 PM）             |
   | %c   | 月，数值               | %S   | 秒(00-59)                                      |
   | %D   | 带有英文前缀的月中的天 | %s   | 秒(00-59)                                      |
   | %d   | 月的天，数值(00-31)    | %T   | 时间, 24-小时 (hh:mm:ss)                       |
   | %e   | 月的天，数值(0-31)     | %U   | 周 (00-53) 星期日是一周的第一天                |
   | %f   | 微秒                   | %u   | 周 (00-53) 星期一是一周的第一天                |
   | %H   | 小时 (00-23)           | %V   | 周 (01-53) 星期日是一周的第一天，与 %X 使用    |
   | %h   | 小时 (01-12)           | %v   | 周 (01-53) 星期一是一周的第一天，与 %x 使用    |
   | %I   | 小时 (01-12)           | %W   | 星期名                                         |
   | %i   | 分钟，数值(00-59)      | %w   | 周的天 （0=星期日, 6=星期六）                  |
   | %j   | 年的天 (001-366)       | %X   | 年，其中的星期日是周的第一天，4 位，与 %V 使用 |
   | %k   | 小时 (0-23)            | %x   | 年，其中的星期一是周的第一天，4 位，与 %v 使用 |
   | %l   | 小时 (1-12)            | %Y   | 年，4 位                                       |
   | %M   | 月名                   | %y   | 年，2 位                                       |
   | %m   | 月，数值(00-12)        |      |                                                |

示例如下：

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220916165729.png)     

10、本文的SQL汇集：

```mysql
-- 1、2、3
SELECT NOW(),CURDATE(),CURTIME();
 
-- 4
SELECT DATE(NOW());
 
-- 5、
SELECT NOW(),
EXTRACT(YEAR FROM NOW()) AS Year,
EXTRACT(MONTH FROM NOW()) AS Month,
EXTRACT(DAY FROM NOW()) AS Day,
EXTRACT(HOUR FROM NOW()) AS Hour,
EXTRACT(MINUTE FROM NOW()) AS MINUTE,
EXTRACT(SECOND FROM NOW()) AS Second;
 
-- 6、一个星期后的今天
SELECT DATE_ADD(NOW(),INTERVAL 7 DAY) AS A_week_later;
 
-- 7、去年的今天
SELECT DATE_SUB(CURRENT_DATE(),INTERVAL 1 YEAR) AS Today_last_year;
 
-- 8、
SELECT DATEDIFF('2020-04-22','1998-01-11') AS DifferDate;
 
-- 9、
SELECT DATE_FORMAT(NOW(),'%b %d %Y %h:%i %p')  UNION ALL
SELECT DATE_FORMAT(NOW(),'%m-%d-%Y') 		   UNION ALL
SELECT DATE_FORMAT(NOW(),'%d %b %y')           UNION ALL
SELECT DATE_FORMAT(NOW(),'%d %b %Y %T:%f') ;
```

