# 一  MySQL安装和卸载

## 1.MySQL卸载

```java 
/*
1.关闭MySQL服务
	此电脑 ---> 右键 ---> 管理 ---> 服务和应用程序 --->服务
			---->MySQL57（不同版本名字不同）---> 右键 ---> 停止
			
2.卸载MySQL
	控制面板 ---> 程序 --->卸载程序 ---> Mysql（右键卸载或双击卸载）
	
3.将Mysql安装目录中的数据全部删掉（再次安装时选其它目录安装）
	注意：目录里有数据库和配置文件（确定不需要再删）
	
4.删除服务名
	4.1 在命令提示符上右键 --> 以管理员身份运行
	4.2 输入命令 ： sc delete 服务名
	
===========================================	
5.清理注册表（详见百度）
6.重装系统
*/
```

## 2.MySQL安装

```
详见PPT
```

# 二 MySQL概述

```mysql
/*
1.MySQL作用：①持久化保存数据  ②可以方便的对数据进行增，删，改，查的操作
	
2.概念
	DB : 数据库
	DBMS ：数据库管理系统
	SQL：结构化查询语言
	
3.常见的数据库管理系统 ：MySQL，SQLServer,Oracle......

4.SQL的优点：①简单易学  ②所有数据库支持 ③虽然简单但是一种强有力的语言
	
5.SQL(Structural query language)语句分为以下三种类型：
	DML: Data Manipulation Language 数据操纵语言
	DDL:  Data Definition Language 数据定义语言
	DCL:  Data Control Language 数据控制语言

*/
```

常用的操作：

```mysql
#查看所有的库：
show databases;

#查看所有的表
show tables;

#选库
use 库名;

#输出1+1
select 1+1 from dual;#dual：伪表，可以省略不写
select 1+1;

#任何数据类型和null做运算结果为null
select 1+null;

```



# 三 DML-上

## 1.查询语句

```mysql
/*
select 字段名1，字段名2，.......
from  表名;

select *   #*表示所有的字段
from 表名;
*/
```

## 2.别名

```mysql
/*
select 字段名1 别名1，字段名2 as 别名2，字段名3 "别 名 3"
from 表名;
*/
#注意：如果别名中间有空格那么可以使用双引号或者单引号引起来（一般使用双引号）。
```

## 3.注意

```mysql
/*
1.SQL 语言大小写不敏感。 
2.SQL 可以写在一行或者多行
3.关键字不能被缩写也不能分行
4.各子句一般要分行写。
5.使用缩进提高语句的可读性。
*/
```

## 4.过滤

```mysql
/*
select 字段名1，字段名2,.....
from 表名
where 过滤条件;
*/
```

## 5.运算符

![1649637701330](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1649637701330.png)

![1649637780193](img/1649637780193.png)

![1649637796385](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1649637796385.png)



```mysql
#查询员工的薪水大于6000的有哪些人
SELECT first_name,salary
FROM employees
WHERE salary>6000;

#查询80号部门员工有哪些
SELECT first_name,department_id
FROM employees
WHERE department_id=80;

#查询除80号部门其它部门的员工有哪些
SELECT first_name,department_id
FROM employees
#where department_id != 80;
WHERE department_id <> 80; #建议使用此写法

#查询员工的薪水在6000到10000之间的有哪些
SELECT first_name,salary
FROM employees
#where salary>=6000 && salary<=10000;
#where salary>=6000 and salary<=10000;#建议使用此写法
WHERE salary BETWEEN 6000 AND 10000;#相当于salary>=6000 and salary<=10000

#注意：下面的写法不对
SELECT first_name,salary
FROM employees
WHERE salary BETWEEN 10000 AND 6000;#相当于salary>=10000 and salary<=6000


#查询30和50号部门中所有的员工
SELECT first_name,department_id
FROM employees
#where department_id=30 || department_id=50;
#where department_id=30 or department_id=50;#建议使用此写法
WHERE department_id IN(30,50);#相当于department_id=30 or department_id=50

#查询员工的奖金率为null的员工有哪些
SELECT first_name,commission_pct
FROM employees
WHERE commission_pct IS NULL;#注意：不要写成commission_pct = NULL

#查询员工的奖金率不为null的员工有哪些
SELECT first_name,commission_pct
FROM employees
WHERE commission_pct IS NOT NULL;

#查询员工的薪水不在6000到10000之间的员工有哪些
SELECT first_name,salary
FROM employees
WHERE salary NOT BETWEEN 6000 AND 10000;
```

模糊查询

```mysql
#需求：查询员工的姓名中包含f的有哪些
SELECT first_name
FROM employees
WHERE first_name LIKE '%f%';# %表示任意个数的任意字符

#需求：查询员工的姓名中第二个字符为d的员工有哪些
SELECT first_name
FROM employees
WHERE first_name LIKE '_d%';# _表示任意一个字符

#需求：查询员工的姓名中第二个字符为_的员工有哪些
SELECT first_name
FROM employees
WHERE first_name LIKE '_\_%';# \_表示内容为_

#escape : 指定转义字符/*

*/
SELECT first_name
FROM employees
WHERE first_name LIKE '_$_%' ESCAPE '$'; #指定$为转义字符


#查询员工的姓名中包含a又包含e的有哪些
SELECT first_name
FROM employees
#where first_name like '%a%e%' or first_name LIKE '%e%a%';
WHERE first_name LIKE '%a%' AND first_name LIKE '%e%';
```

## 6.排序

```mysql
/*
select 字段名1，字段名2，......
from 表名
where 过滤条件
order by 字段名1 asc/desc,字段名2 asc/desc，.......

说明：
	1.asc表示升序，desc表示降序
	2.如是不指定排序方式那么默认是升序
*/
#查询所有员工的姓名和薪水并按照薪水排序-降序。
SELECT first_name,salary
FROM employees
ORDER BY salary DESC;

#查询所有员工的姓名和薪水并按照薪水排序-升序。
SELECT first_name,salary
FROM employees
ORDER BY salary;

#查询80号部门的所有员工的姓名和薪水并按照薪水排序-升序.
SELECT first_name,salary,department_id
FROM employees
WHERE department_id=80
ORDER BY salary ASC;

#查询给所有员工薪水+1000后的新的薪水，并对新的薪水进行排序--降序。
SELECT first_name,salary,salary+1000 new_salary
FROM employees
ORDER BY new_salary DESC;

#查询所有员工的名字，薪水，部门号。并对部门号进行排序-降序如果部门号相同再按照薪水排序-升序
SELECT first_name,salary,department_id
FROM employees
ORDER BY department_id DESC,salary ASC;


SELECT first_name,salary,salary+1000 "new salary"
FROM employees
ORDER BY `new salary` DESC;
```

# 四 DML-下

## 1.多表查询

```mysql
/*
多表查询 ：查询的多个字段不在同一张表中那么就需要用到多表查询

连接方式不同分类：
	自连接 vs 非自连接
	等值连接 vs 非等值连接
	内连接 vs 外连接

语法规则 ：sql92语法 vs sql99语法（主要使用sql99语法）
*/
#sql92语法
#查询员工的姓名和部门名称
SELECT first_name,department_name
FROM employees,departments
WHERE employees.department_id=departments.department_id;

#查询员工的姓名,部门号和部门名称
/*
在多表查询中如果查询的字段是唯一的那么可以在字段名前不用加表名。如果查询的字段
	不是唯一的那么该字段名前需要加表名。
	
注意：在多表查询中查询的字段名前加表名效率更高。	
*/
SELECT employees.first_name,departments.department_name,employees.department_id
FROM employees,departments
WHERE employees.department_id=departments.department_id;

#给表起别名
SELECT e.first_name,d.department_name,e.department_id
FROM employees e,departments d
WHERE e.department_id=d.department_id;

#下面会产生迪卡尔集的问题原因就是没有连接条件。
SELECT e.first_name,d.department_name,e.department_id
FROM employees e,departments d


#sql99语法
/*
select 字段名1，字段名2，....
from 表名1 join 表名2
on 连接条件
join 表名3
on 连接条件
.......
where 过滤条件
order by 字段名1 asc/desc, 字段名2 asc/desc，......
*/
#内连接：只获取表中匹配的内容
#等值连接：连接条件使用的是等号
#非自连接：连接的两张表不是同一张表
#查询员工的姓名和部门名称
SELECT e.first_name,d.`department_name`
FROM employees e JOIN departments d
ON e.`department_id` = d.`department_id`;



#自连接：
#查询员工的姓名及该员工的管理者的姓名
SELECT e1.`first_name` 员工姓名,e2.`first_name` 管理者姓名
FROM employees e1 JOIN employees e2   #e1当员工表，e2当管理者表
ON e1.`manager_id`=e2.`employee_id`;


#非等值连接
#查询员工的薪水及薪水的等级。
SELECT e.`first_name`,e.`salary`,j.`GRADE`
FROM employees e JOIN job_grades j
#on e.`salary` >= j.`LOWEST_SAL` and e.`salary` <= j.`HIGHEST_SAL`;
ON e.`salary` BETWEEN j.`LOWEST_SAL` AND j.`HIGHEST_SAL`;
```

![1649723666409](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1649723666409.png)

```mysql
#内连接：
#查询所有的员工姓名及部门名称
SELECT e.`first_name`,d.`department_name`
FROM employees e JOIN departments d
ON e.`department_id`=d.`department_id`;

#左外连接:除了匹配的内容还包括左表中不匹配的内容
#需求：查询所有的员工的姓名及员工部门的名称。
SELECT e.`first_name`,d.`department_name`
FROM employees e LEFT JOIN departments d
ON e.`department_id`=d.`department_id`;

#右外连接:除了匹配的内容还包括右表中不匹配的内容
#需求：查询所有的部门名称及部门中员工的姓名
SELECT e.`first_name`,d.`department_name`
FROM employees e RIGHT JOIN departments d
ON e.`department_id`=d.`department_id`;


#满外连接(MySQL不支持)：除了匹配的内容还包括左表和右表中不匹配的内容
/*
union : 可以将两张表中的内容合并起来（去重）

左外连接
union
右外连接
*/
#需求：查询所有的员工和部门名称(包括没有部门的员工和没有员工的部门)
SELECT e.`first_name`,d.`department_name`
FROM employees e LEFT JOIN departments d
ON e.`department_id`=d.`department_id`
UNION
SELECT e.`first_name`,d.`department_name`
FROM employees e RIGHT JOIN departments d
ON e.`department_id`=d.`department_id`;


#需求：查询员工的姓名部门名称及部门所在城市的名称
SELECT e.`first_name`,d.`department_name`,l.city
FROM employees e JOIN departments d
ON e.`department_id`=d.`department_id`
JOIN locations l
ON d.`location_id`=l.location_id;

```

## 2.补充

```mysql

#  `` 飘号 : 用来区分关键字和字段名。
SELECT e.first_name
FROM employees e JOIN departments d
ON e.`department_id`=d.`department_id`;

SELECT `select`
FROM xxxx;


#distinct : 去重
#需求：查询有员工的部门的部门号有哪些
SELECT DISTINCT department_id
FROM employees
WHERE department_id IS NOT NULL;
```

## 2.函数

### 2.1单行函数

```mysql
/*
LOWER('SQL Course') ：将字符串内容全部变成小写
UPPER('SQL Course') ：将字符串内容全部变成大写
*/
SELECT LOWER('abcDeFgKl'),UPPER('abcDeFgKl');

SELECT LOWER(first_name),UPPER(last_name)
FROM employees;

/*
CONCAT('Hello', 'World') : 字符串拼接
SUBSTR('HelloWorld',1,5) : 截取子串（索引位置从1开始）
	1 ：开始的位置
	5 ： 长度（偏移量）
LENGTH('HelloWorld') : 内容的长度
INSTR('HelloWorld', 'W') : W在当前字符串中首次出现的位置

LPAD(salary,10,'*') : 向右对齐
	如果内容长度不够10用 *补
	
RPAD(salary, 10, '*') ：向左对齐
	如果内容长度不够10用 *补

TRIM('H' FROM 'HelloWorld') : 去除字符串两端指定的字符
REPLACE('abcd','b','m') : 将字符串中所有的b替换成m
*/
SELECT CONCAT(first_name,'-',last_name)
FROM employees;

SELECT SUBSTR('abcdef',2,3);

SELECT first_name,LENGTH(first_name)
FROM employees;

SELECT INSTR('abcdc','c');

SELECT LPAD(salary,10,' '),RPAD(salary,10,' ')
FROM employees;

SELECT TRIM('H' FROM 'HHHHHAHHHBHHHH');

SELECT REPLACE('abcccdba','c','C');


/*
ROUND: 四舍五入
ROUND(45.926, 2)			45.93

TRUNCATE: 截断
TRUNCATE(45.926,0)      		45

MOD: 求余
MOD(1600, 300)		          100

*/
SELECT ROUND(45.926, 2),ROUND(45.926, 1),ROUND(45.926, 0),ROUND(45.926, -1);
SELECT TRUNCATE(45.926, 2),TRUNCATE(45.926, 1),TRUNCATE(45.926, 0),TRUNCATE(45.926, -1);

#结果的正负和被模数的正负有关（第一个参数的正负有关）
SELECT MOD(3,2),MOD(-3,2),MOD(3,-2),MOD(-3,-2);

#日期时间 now()
SELECT NOW();

#版本 version()
SELECT VERSION();
```

### 2.2通用函数

```mysql
#ifnull(字段名,默认值) :如果字段的内容为null用默认值替换
#需求：查询所有员工的工资（工资+奖金）
SELECT salary+IFNULL(commission_pct,0)*salary 工资
FROM employees;


/*
case表达式

case 字段名
when 值1 then 返回值1
when 值2 then 返回值2
when 值3 then 返回值3
else 返回值n
end

case 
when 表达式1 then 返回值1
when 表达式2 then 返回值2
when 表达式3 then 返回值3
else 返回值n
end

*/
#练习：查询部门号为 10, 20, 30 的员工信息, 若部门号为 10, 则打印其工资的 1.1 倍,
# 20 号部门, 则打印其工资的 1.2 倍, 30 号部门打印其工资的 1.3 倍数
SELECT department_id,salary,CASE department_id
			    WHEN 10 THEN salary*1.1
			    WHEN 20 THEN salary*1.2
			    WHEN 30 THEN salary*1.3
			    ELSE salary
			    END AS "new_salary"
FROM employees
WHERE department_id IN(10,20,30);


#案例：查询所有员工的薪水如果大于10000显示会所嫩模,小于10000显示下海干活.
# 	等于10000再接再厉
SELECT salary,CASE 
	      WHEN salary>10000 THEN "会所嫩模"
	      WHEN salary<10000 THEN "下海干海"
	      ELSE "再接再厉"
	      END AS des
FROM employees;
```

### 2.3多行函数(组函数-聚合函数)

```mysql
/*
AVG() : 求平均值  
SUM() ：求和
注意：上面的函数只能对数值类型做运算

MAX() ：求最大值
MIN() ：求最小值
 
 
COUNT()：统计结果的数量 


*/
#求所有员工薪水的最大值，最小值，平均值，总和
SELECT MAX(salary),MIN(salary),AVG(salary),SUM(salary)
FROM employees;

#注意：下面的写法不对。select后面出现组函数后将不能再出现其它字段，除非该字段出现在
#group by的后面。
SELECT first_name,AVG(salary)
FROM employees;

/*
COUNT(字段名)：统计查询的结果中该字段内容不为null的有多少条
count(*) : 统计查询的结果有多少条数据
count(数值) ：和count(*)的作用一样。count(数值)效率高一些。
*/
SELECT COUNT(commission_pct),COUNT(*),COUNT(1)
FROM employees;

SELECT COUNT(*)
FROM employees
WHERE commission_pct IS NOT NULL;


#求平均值时是否包含null? 不包含null
SELECT SUM(commission_pct)/107,SUM(commission_pct)/35,AVG(commission_pct)
FROM employees;
```

## 3.分组和过滤

```mysql
/*
select 字段名1，字段名2,.....
from 表名
where 过滤条件
group by 字段名1，字段名2，......
having 过滤条件
order by 字段名1 desc/asc,字段名2 desc/asc，......

where和having的区别？
1.where是在分组前进行过滤，having是在分组后过滤。
2.where后面不能使用组函数，having后面可以使用组函数。
*/
#查询各部门中最高薪水
#说明：select后面出现组函数后将不能再出现其它字段，除非该字段出现在group by的后面。
SELECT department_id,MAX(salary)
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id;

#查询各部门中平均薪水并按照最高薪水进行排序-降序
SELECT department_id,AVG(salary) a_s
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
ORDER BY a_s DESC;

SELECT department_id,AVG(salary)
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
ORDER BY `avg(salary)` DESC;

#查询各部门中不同的工种的最低薪水是多少
SELECT department_id,job_id,MIN(salary)
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id,job_id;

#需求：查询10,20,30部门的平均薪水大于5000的有哪个部门。
#方式一(效率高)
SELECT department_id,AVG(salary)
FROM employees
WHERE department_id IN(10,20,30)
GROUP BY department_id
HAVING AVG(salary)>5000;

#方式二
SELECT department_id,AVG(salary)
FROM employees
GROUP BY department_id
HAVING department_id IN(10,20,30) AND AVG(salary)>5000;
```

## 4.子查询

```mysql
/*
子查询 ：在一个a查询语句中再嵌套一个查询语句b。b语句叫作子查询（内查询）a语句叫作主查询(外查询)

子查询分类 ：单行子查询 vs 多行子查询

单行子查询 : 子查询的结果只有一条。
多行子查询 ： 子查询的结果有多条。

单行子查询使用的运算符 : > >= < <= = <>
多行子查询使用的运算符 ：in any all

注意：先执行子查询（内查询）再执行外查询（主查询）
*/
#谁的工资比 Abel 高?
#方式一：
#①查询Abel的工资
SELECT salary
FROM employees
WHERE last_name='Abel';#11000
#②查询工资高于11000的员工
SELECT last_name,salary
FROM employees
WHERE salary>11000;


#方式二：自连接
SELECT e1.`last_name`,e1.`salary`
FROM employees e1 JOIN employees e2
ON e1.`salary`>e2.`salary` AND e2.`last_name`='Abel'; 

#方式三：子查询
SELECT last_name,salary
FROM employees
WHERE salary>(
	SELECT salary
	FROM employees
	WHERE last_name='Abel'
);

#=========================================================

#题目：返回job_id与141号员工相同，salary比143号员工多的员工
#            姓名，job_id 和工资
#方式一：
#①查询141号员工的job_id
SELECT job_id
FROM employees
WHERE employee_id=141;#ST_CLERK
#②查询143号员工的薪水
SELECT salary
FROM employees
WHERE employee_id=143;#2600
#③查询job_id为ST_CLERK薪水大于2600的员工
SELECT job_id,salary
FROM employees
WHERE job_id='ST_CLERK' AND salary>2600;

#方式二
SELECT job_id,salary
FROM employees
WHERE job_id=(
	SELECT job_id
	FROM employees
	WHERE employee_id=141
) AND salary>(
	SELECT salary
	FROM employees
	WHERE employee_id=143
);

#=================================================================
#题目：返回公司工资最少的员工的last_name,job_id和salary
SELECT last_name,job_id,salary
FROM employees
WHERE salary=(
	SELECT MIN(salary)
	FROM employees
);


#=================================================================
#题目：查询最低工资大于50号部门最低工资的部门id和其最低工资
SELECT department_id,MIN(salary)
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
HAVING MIN(salary) > (
	#50号部门最低薪水
	SELECT MIN(salary)
	FROM employees
	WHERE department_id=50
);

#=====================================================
#错误代码： 1242
#Subquery returns more than 1 row
SELECT last_name,job_id,salary
FROM employees
WHERE salary=(
	SELECT salary
	FROM employees
);

#===========================================
#题目：返回其它部门中比job_id为‘IT_PROG’部门任一工资低的员工的员
#              工号、姓名、job_id 以及salary

SELECT employee_id,last_name,job_id,salary
FROM employees
WHERE salary <ANY (
	#查询IT部门所有员工的薪水
	SELECT DISTINCT salary
	FROM employees
	WHERE job_id='IT_PROG'
) AND job_id <> 'IT_PROG' ;



#题目：返回其它部门中比job_id为‘IT_PROG’部门所有工资都低的员工
#            的员工号、姓名、job_id 以及salary

SELECT employee_id,last_name,job_id,salary
FROM employees
WHERE salary <ALL (
	#查询IT部门所有员工的薪水
	SELECT DISTINCT salary
	FROM employees
	WHERE job_id='IT_PROG'
) AND job_id <> 'IT_PROG' ;


```



