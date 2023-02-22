# 巩固题

## 成员变量基础题

### 第1题：员工

声明员工类Employee，包含属性：编号、姓名、年龄、薪资，

在测试类的main方法中，创建2个员工对象，并为属性赋值，并打印两个员工的信息。



### 第2题：日期类

声明一个日期类MyDate，包含属性：年、月、日

在测试类的main方法中，创建3个日期对象，一个是你的出生日期，一个是来尚硅谷的日期，一个是毕业的日期，并打印显示





## 成员方法基础题

### 第1题：三角形

声明一个三角形类Triangle，包含属性：a,b,c，都是double类型，表示三条边，包含几个方法：

- boolean isTriangle()：判断是否是一个三角形
- boolean isRightTriangle()：判断是否是一个直角三角形
- boolean isIsoscelesTriangle()：判断是否是一个等腰三角形

- boolean isEquilateralTriangle()：判断是否是一个等边三角形

- double area()：根据三条边，用海伦公式求面积

- double perimeter()：求周长


在测试类的main方法中创建三角形对象，将三角形的三条边设置为3,4,5，调用方法测试。





### 第2题：日期类

声明一个日期类MyDate，

- 包含属性：年、月、日
- boolean isLeapYear()：判断是否是闰年
- String monthName()：根据月份值，返回对应的英语单词
- int totalDaysOfMonth()：返回这个月的总天数
- int totalDaysOfYear()：返回这一年的总天数
- int daysOfTheYear()：返回这一天是当年的第几数

在测试类的main方法中，创建MyDate对象，赋值为当天日期值，调用方法测试。





### 第3题：数组工具类

声明一个数组工具类ArrayTools，包含如下方法：

- int sum(int[] arr)：求所有元素总和
- int max(int[] arr)：求所有元素的最大值
- int indexOf(int[] arr, int value)：查找value在arr数组中第一次出现的下标，如果不存在返回-1
- int lastIndexOf(int[] arr, int value)：查找value在arr数组中最后一次出现的下标，如果不存在返回-1

在测试类的main方法中，调用方法测试例如：

```java
int[] arr = {1,2,10,4,5,10,7,8,9,10};
```



# 拔高题

### 1、公民类

声明一个日期类MyDate，

- 包含属性：年、月、日，
- 包含String dateToString()方法，返回“xxxx年xx月xx日”

声明公民类Citizen，

- 包含属性：姓名，生日，身份证号，其中姓名是String类型，生日是MyDate类型，身份证号也是String类型。
- 包含String getInfo()方法，返回“姓名：xx，身份证号码：xx，生日：xxxx年xx月xx日”
- 包含void setBirthday(int year, int month, int day)：设置生日

在测试类的main方法中，创建你们家庭成员的几个对象，并打印信息。



### 2、数组工具类

声明一个数组工具类ArrayTools，包含如下方法：

- int max(int[] arr)：求所有元素的最大值
- int valueCount(int[] arr, int value)：查找value在arr数组中出现的次数，如果不存在返回0
- int[] maxIndex(int[] arr)：找出所有最大值
- void sort(int[] arr)：实现元素从小到大排序
- void reverse(int[] arr, int start, int end)：反转[start,end]范围内的元素
- int[] copyOf(int[] arr, int newLength)：复制arr数组，新数组的长度newLength。如果newLength<=arr.length，则复制arr数组的[0, newLength-1]范围的元素，如果newLength>arr.length，则复制arr数组的所有元素到新数组，剩下的元素则默认就可以。
- boolean equals(int[] arr1, int[] arr2)：判断两个数组的长度和元素是否都相等，如果两个数组以相同顺序包含相同的元素，则两个数组是相等的。
- void fill(int[] arr, int start, int end,  int value) ：将arr数组[start,end]范围的元素赋值为value。
- String toString(int[] arr)：将元素拼接为"{元素1，元素2，......}"的字符串返回。

在测试类的main方法中，调用方法测试例如：

```java
int[] arr = {1,2,10,4,5,10,7,8,9,10};
```



