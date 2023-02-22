# ifnull()函数

## 概念

IFNULL() 函数用于判断第一个表达式是否为 NULL，如果为 NULL 则返回第二个参数的值，如果不为 NULL 则返回第一个参数的值。

IFNULL() 函数语法格式为：

```mysql
IFNULL(expression, alt_value)
```

| 参数         | 描述                                      |
| ------------ | ----------------------------------------- |
| *expression* | 必须，要测试的值                          |
| *alt_value*  | 必须，expression 表达式为 NULL 时返回的值 |

如果第一个参数的表达式 expression 为 NULL，则返回第二个参数的备用值。

**参数说明:**

## 实例

第一个参数为 NULL：

```mysql
SELECT IFNULL(NULL, "RUNOOB");
```

以上实例输出结果为：

```mysql
RUNOOB
```

第一个参数不为 NULL：

```mysql
SELECT IFNULL("Hello", "RUNOOB");
```

以上实例输出结果为：

```mysql
Hello
```