# 巩固题

## 1、月份

用一个数组，保存12个月的英语单词，从键盘输入1-12，显示对应的单词。

```java
{"January","February","March","April","May","June","July","August","September","October","November","December"}
```

## 2、打印扑克牌

遍历输出一副扑克牌。

```java
String[] hua = {"黑桃","红桃","梅花","方片"};
String[] dian = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
```



## 3、正序和逆序输出26个英文字母

要求使用char数组存储26个英文字母，并分别用正序和逆序方式显示输出。要求10个一行。

![image-20211224105504484](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/image-20211224105504484.png)





## 4、判断数组中的元素值是否对称

判断某个数组是否是对称数组，即数组正序遍历和倒序遍历的结果是一样的。例如：

![](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/6.jpg)

开发提示：数组中元素首尾比较。





# 拔高题

## 1、统计字符出现次数

英语中最长的单词是"pneumonoultramicroscopicsilicovolcanoconiosis"，意思是“肺尘病，矽肺病”，一共有45个英文字母。现在要求统计这个单词中出现了哪些字母，以及它们出现的次数，并且找出出现次数最多的字母。

开发提示：

（1）使用String类型的变量word存储英语单词"pneumonoultramicroscopicsilicovolcanoconiosis"

（2）通过word.toCharArray()可以根据字符串word得到一个char[]类型的数组。

其中toCharArray()是String类型提供的系统函数，就像Math.random()等函数一样，后面会学到，这里先提前用一下。它的作用就是创建一个char[]数组，并把字符串中的每一个字符依次存储到这个char[]数组中。

```java
//以"hello"为例
String word = "hello";
char[] wordCharArray = word.toCharArray();
//此时wordCharArray字符数组内容是 {‘h','e','l','l','o'}
```

（3）声明一个int类型的数组counts，长度为26，分别用来记录26个字母出现的次数，counts[0]记录的是'a'字母的次数，counts[1]记录的是'b'字母的次数，依次类推。



## 2、统计低于平均分的学生人数

先从键盘输入本组学员的人数，再从键盘输入本组学员的姓名和成绩，最后统计：

- 本组学员的平均分，
- 低于平均分的学员人数，
- 哪些学员低于平均分，
- 最高分和最低分分别是谁。









