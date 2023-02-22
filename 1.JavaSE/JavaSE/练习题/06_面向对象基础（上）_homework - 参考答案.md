# 巩固题

## 成员变量基础题

### 第1题：员工

声明员工类Employee，包含属性：编号、姓名、年龄、薪资，

在测试类的main方法中，创建2个员工对象，并为属性赋值，并打印两个员工的信息。

```java
package com.atguigu.homework1;

public class Employee {
    int id;
    String name;
    int age;
    double salary;
}
```

```java
package com.atguigu.homework1;

public class TestEmployee {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.id = 1;
        emp1.name = "张三";
        emp1.age = 23;
        emp1.salary = 10000;

        Employee emp2 = new Employee();
        emp2.id = 2;
        emp2.name = "李四";
        emp2.age = 22;
        emp2.salary = 11000;

        System.out.println("第1个员工的编号：" + emp1.id +"，姓名：" + emp1.name + "，年龄：" + emp1.age + "，薪资：" + emp1.salary);
        System.out.println("第2个员工的编号：" + emp2.id +"，姓名：" + emp2.name + "，年龄：" + emp2.age + "，薪资：" + emp2.salary);
    }
}
```

### 第2题：日期类

声明一个日期类MyDate，包含属性：年、月、日

在测试类的main方法中，创建3个日期对象，一个是你的出生日期，一个是来尚硅谷的日期，一个是毕业的日期，并打印显示

```java
package com.atguigu.homework2;

public class MyDate {
    int year;
    int month;
    int day;
}

```

```java
package com.atguigu.homework2;

public class TestMyDate {
    public static void main(String[] args) {
        MyDate bir = new MyDate();
        bir.year = 1995;
        bir.month = 5;
        bir.day = 5;
        System.out.println("生日：" + bir.year + "年" + bir.month + "月" + bir.day + "日");

        MyDate come = new MyDate();
        come.year = 2021;
        come.month = 5;
        come.day = 12;
        System.out.println("来尚硅谷：" + come.year + "年" + come.month + "月" + come.day + "日");

        MyDate go = new MyDate();
        go.year = 2021;
        go.month = 10;
        go.day = 25;
        System.out.println("毕业：" + go.year + "年" + go.month + "月" + go.day + "日");
    }
}

```

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

```java
package com.atguigu.homework3;

public class Triangle {
    double a;
    double b;
    double c;

    boolean isTriangle(){
        return a>0 && b>0 && c>0 && a+b>c && b+c>a && a+c>b;
    }

    boolean isRightTriangle(){
        return isTriangle() && (a*a + b*b == c*c || a*a + c*c == b*b || b*b + c*c == a*a);
    }

    boolean isEquilateralTriangle(){
        return isTriangle() && a == b && b == c;
    }

    boolean isIsoscelesTriangle(){
        return isTriangle() && (a == b || a == c || b == c);
    }

    double perimeter(){
        if(!isTriangle()){
            return 0.0;
        }
        return a + b + c;
    }

    double area(){
        if(!isTriangle()){
            return 0.0;
        }
        double p = a + b + c;
        return Math.sqrt(p * (p-a) * (p-b) * (p-c));
    }
}

```

```java
package com.atguigu.homework3;

public class TestTriangle {
    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        t1.a = 3;
        t1.b = 4;
        t1.c = 5;
        System.out.println("t1是三角形吗？" + t1.isTriangle());
        System.out.println("t1是直角三角形吗？" + t1.isRightTriangle());
        System.out.println("t1是等腰三角形吗？" + t1.isIsoscelesTriangle());
        System.out.println("t1是等边三角形吗？" + t1.isEquilateralTriangle());
        System.out.println("t1的周长：" + t1.perimeter());
        System.out.println("t1的面积：" + t1.area());
    }
}
```

### 第2题：日期类

声明一个日期类MyDate，

- 包含属性：年、月、日
- boolean isLeapYear()：判断是否是闰年
- String monthName()：根据月份值，返回对应的英语单词
- int totalDaysOfMonth()：返回这个月的总天数
- int totalDaysOfYear()：返回这一年的总天数
- int daysOfTheYear()：返回这一天是当年的第几数

在测试类的main方法中，创建MyDate对象，赋值为当天日期值，调用方法测试。

```java
package com.atguigu.homework4;

public class MyDate {
    int year;
    int month;
    int day;

    boolean isLeapYear(){
        return year%4==0 && year%100!=0 || year%400==0;
    }
    
    int totalDaysOfYear(){
        return isLeapYear() ? 366 : 365;
    }

    int totalDaysOfMonth(){
        if(month == 4 || month == 6 || month == 9 || month == 11){
            return 30;
        }
        if(month == 2){
            return isLeapYear() ? 29 : 28;
        }
        return 31;
    }

    int daysOfTheYear(){
        int days = day;
        for(int i=1; i<month; i++){
            if(i==2){
                days += isLeapYear() ? 29 : 28;
            }else if(i==4 || i==6 || i==9 || i==11){
                days += 30;
            }else{
                days += 31;
            }
        }
        return days;
    }

    String monthName(){
        String[] monthNames = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        return monthNames[month-1];
    }
}

```

```java
package com.atguigu.homework4;

public class TestMyDate {
    public static void main(String[] args) {
        MyDate my = new MyDate();
        my.year = 2021;
        my.month = 12;
        my.day = 29;

        System.out.println("今年是闰年吗？" + my.isLeapYear());
        System.out.println("月份名是" + my.monthName());
        System.out.println("这个月总天数：" + my.totalDaysOfMonth());
        System.out.println("这一年总天数：" + my.totalDaysOfYear());
        System.out.println("这一天是这一年的几天？" + my.daysOfTheYear());
    }
}
```

### 第3题：数组工具类

声明一个数组工具类ArrayTools，包含如下方法：

- int sum(int[] arr)：求所有元素总和
- int max(int[] arr)：求所有元素的最大值
- int indexOf(int[] arr, int value)：查找value在arr数组中第一次出现的下标，如果不存在返回-1
- int lastIndexOf(int[] arr, int value)：查找value在arr数组中最后一次出现的下标，如果不存在返回-1

在测试类的main方法中，调用方法测试，例如：

```java
int[] arr = {1,2,10,4,5,10,7,8,9,10};
```



```java
package com.atguigu.homework5;

public class ArrayTools {
    int sum(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    int max(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    int indexOf(int[] arr, int value){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }
    int lastIndexOf(int[] arr, int value){
        for(int i=arr.length-1; i>=0;  i--){
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}

```

```java
package com.atguigu.homework5;

public class ArrayToolsTest {
    public static void main(String[] args) {
        ArrayTools tools = new ArrayTools();

        int[] arr = {1,2,10,4,5,10,7,8,9,10};

        System.out.println("元素总和：" + tools.sum(arr));
        System.out.println("最大值：" + tools.max(arr));
        System.out.println("第1次出现10的下标：" + tools.indexOf(arr, 10));
        System.out.println("最后1次出现10的下标：" + tools.lastIndexOf(arr, 10));
        System.out.println("第1次出现3的下标：" + tools.indexOf(arr,3));
    }
}
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

```java
package com.atguigu.homework6;

public class MyDate {
    int year;
    int month;
    int day;
    String dateToString(){
        return year + "年" + month + "月" + day + "日";
    }
}
```

```java
package com.atguigu.homework6;

public class Citizen {
    String name;
    String cardId;
    MyDate birthday;
    void setBirthday(int year, int month, int day){
        birthday = new MyDate();
        birthday.year = year;
        birthday.month = month;
        birthday.day = day;
    }
    String getInfo(){
        return "姓名：" + name +"，身份证号码：" + cardId + "，生日：" + birthday.dateToString();
    }
}
```

```java
package com.atguigu.homework6;

public class TestCitizen {
    public static void main(String[] args) {
        Citizen citizen = new Citizen();
        citizen.name = "张三";
        citizen.cardId = "110250199512012535";
        citizen.setBirthday(1995,12,1);
        System.out.println(citizen.getInfo());
    }
}
```

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



```java
package com.atguigu.homework7;

public class ArrayTools {
    int max(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    int valueCount(int[] arr, int value){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value){
                count ++;
            }
        }
        return count;
    }
    int[] maxIndex(int[] arr){
        int max = max(arr);
        int count = valueCount(arr, max);
        int[] all = new int[count];
        for (int i = 0,j = 0; i < arr.length; i++) {
            if(arr[i] == max) {
                all[j++] = i;
            }
        }
        return all;
    }
    void sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    void reverse(int[] arr, int start, int end){
        for(int i=0; i<(end-start)/2; i++){
            int temp = arr[i+start];
            arr[i+start] = arr[end-i];
            arr[end-i] = temp;
        }
    }

    int[] copyOf(int[] arr, int newLength){
        int[] newArr = new int[newLength];
        for (int i = 0; i < newArr.length && i<arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    boolean equals(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    void fill(int[] arr, int start, int end, int value){
        for (int i = start; i <= end; i++) {
            arr[i] = value;
        }
    }
    String toString(int[] arr){
        String result = "{";
        for (int i = 0; i < arr.length; i++) {
            if(i<arr.length-1){
                result += arr[i] + ",";
            }else{
                result += arr[i];
            }
        }
        result += "}";
        return result;
    }
}

```

```java
package com.atguigu.homework7;

public class ArrayToolsTest {
    public static void main(String[] args) {
        ArrayTools tools = new ArrayTools();
        int[] arr = {1,2,10,4,5,10,7,8,9,10};

        System.out.println("arr数组为：" +tools.toString(arr));
        int maxValue = tools.max(arr);
        System.out.println("arr数组中的最大值：" + maxValue);
        System.out.println("最大值的个数：" + tools.valueCount(arr,maxValue));
        int[] indexs = tools.maxIndex(arr);
        System.out.println("所有最大值下标：" + tools.toString(indexs));

        tools.sort(arr);
        System.out.println("排序后arr：" + tools.toString(arr));
        tools.reverse(arr, 1,5);
        System.out.println("反转[1,5]下标范围的元素后："+ tools.toString(arr));

        int[] before = tools.copyOf(arr, 5);
        System.out.println("复制前面5个元素：" + tools.toString(before));
        int[] doubleArr = tools.copyOf(arr, arr.length*2);
        System.out.println("arr的两倍大数组：" + tools.toString(doubleArr));
        tools.fill(doubleArr, arr.length, doubleArr.length-1, 6);
        System.out.println("doubleArr新扩展的元素用6填充后：" + tools.toString(doubleArr));
    }
}
```

