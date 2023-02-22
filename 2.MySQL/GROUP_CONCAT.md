# 完整语法

```mysql
group_concat([DISTINCT] 要连接的字段 [Order BY ASC/DESC 排序字段] [Separator '分隔符'])
```

# 实例1

## 数据准备

创建数据库并插入数据

```mysql
-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(11) NOT NULL,
  `score` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '10');
INSERT INTO `score` VALUES ('1', '20');
INSERT INTO `score` VALUES ('1', '30');
INSERT INTO `score` VALUES ('2', '20');
INSERT INTO `score` VALUES ('2', '30');
INSERT INTO `score` VALUES ('2', '40');
INSERT INTO `score` VALUES ('3', '30');
INSERT INTO `score` VALUES ('3', '40');
INSERT INTO `score` VALUES ('3', '40');
```

效果如图

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220916112728.png)

## 语法实操

### 语法1

```mysql
SELECT id,GROUP_CONCAT(score) from score GROUP BY id;
```

结果如图

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220916112944.png)

### 语法2

```mysql
SELECT id,GROUP_CONCAT(DISTINCT score) from score GROUP BY id;
```

结果如图

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220916113026.png)

### 语法3

```mysql
SELECT id,GROUP_CONCAT(DISTINCT score ORDER BY score DESC) from score GROUP BY id;
```

结果如图

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220916113303.png)

### 语法4

```mysql
SELECT id,GROUP_CONCAT(DISTINCT score ORDER BY score DESC SEPARATOR ";") from score GROUP BY id;
```

结果如图

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220916113133.png)

# 实例2

## 数据准备

创建表，并插入数据

```mysql
-- ----------------------------
-- Table structure for grade1
-- ----------------------------
DROP TABLE IF EXISTS `grade1`;
CREATE TABLE `grade1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuName` varchar(22) DEFAULT NULL,
  `course` varchar(22) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade1
-- ----------------------------
INSERT INTO `grade1` VALUES ('1', '张三', '语文', '91');
INSERT INTO `grade1` VALUES ('2', '张三', '数学', '90');
INSERT INTO `grade1` VALUES ('3', '张三', '英语', '87');
INSERT INTO `grade1` VALUES ('4', '李四', '语文', '79');
INSERT INTO `grade1` VALUES ('5', '李四', '数学', '95');
INSERT INTO `grade1` VALUES ('6', '李四', '英语', '80');
INSERT INTO `grade1` VALUES ('7', '王五', '语文', '77');
INSERT INTO `grade1` VALUES ('8', '王五', '数学', '81');
INSERT INTO `grade1` VALUES ('9', '王五', '英语', '89');
```

效果如图

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220916113504.png)

## **问题：查询语数外，三门课的最低分，以及学生姓名**

### 方法一

```mysql
SELECT
    course,
    SUBSTRING_INDEX(
        (
            GROUP_CONCAT(stuName ORDER BY score ASC)
        ),
        ',',
        1
    ) AS studentName,
    MIN(score)
FROM
    grade1
GROUP BY
    course;
```

**解析：**

1. 根据课程course 分组（group by）,min() 函数 求该course 下的最低分
2. group_concat() 函数 根据分数从高到底 拼接 stuName
3. substring_index() 函数 拆分出 分数最低 stuName

数据量大的情况 不推荐使用该方法



**方法二：**

```css
SELECT
    a.course,
    a.stuName,
    a.score
FROM
    grade1 a
WHERE
    (a.score, a.course) IN (
        SELECT
            MIN(score),
            course
        FROM
            grade1
        GROUP BY
            course
    );
```

结果如图

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220916113815.png)

**解析：**
min(score) group by course 可以获取到 course 的最低分，而且知道 course,socre 也可以确定是哪个学生。