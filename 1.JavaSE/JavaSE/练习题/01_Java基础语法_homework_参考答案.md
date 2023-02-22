# 巩固题

## 1、输出你最想说的一句话！

* 编写步骤：

1. 定义类 Homework1
2. 定义 main方法
3. 控制台输出5行字符串类型常量值

```java
public class Homework1 {
    public static void main(String[] args) {
        System.out.println("我爱尚硅谷1");
        System.out.println("我爱尚硅谷2");
        System.out.println("我爱尚硅谷3");
        System.out.println("我爱尚硅谷4");
        System.out.println("我爱尚硅谷5");
    }
}
```

## 2、按步骤编写代码，效果如图所示：

![](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1.jpg)

* 编写步骤：

1. 定义类 Homework2
2. 定义 main方法
3. 控制台输出5行字符串类型常量值
4. 控制台输出5行字符类型常量值

```java
public class Homework2 {
    public static void main(String[] args) {
        System.out.println("善学如春起之苗");
        System.out.println("不见其增，日有所长");
        System.out.println("假学如磨刀之石");
        System.out.println("不见其损，年有所亏");
        System.out.println("加油吧！少年");

        //以下语句中使用单引号或双引号都可以
        System.out.println("J");
        System.out.println("A");
        System.out.println("V");
        System.out.println("A");
        System.out.println("!");
    }
}
```

## 3、按步骤编写代码，效果如图所示：

![](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/3.jpg)

- 编写步骤：

  1. 定义类 Homework3
  2. 定义 main方法
  3. 控制台输出所有布尔类型常量值

```java
public class Homework3 {
    public static void main(String[] args) {
        System.out.println(true);
        System.out.println(false);
    }
}
```



## 4、按步骤编写代码，效果如图所示：

![](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/4.jpg)

- 编写步骤：

  1. 定义类 Homework4
  2. 定义 main方法
  3. 定义2个 byte类型变量,分别赋byte类型范围内最大值和最小值,并输出在控制台.
  4. 定义2个 short类型变量,分别赋short类型范围内的值,并输出在控制台.
  5. 定义2个 int类型变量,分别赋int类型范围内的值,并输出在控制台.
  6. 定义2个 long类型变量,分别赋超过int类型范围的值,并输出在控制台.

```java
public class Homework4 {
    public static void main(String[] args) {
        byte minByte = -128;
        byte maxByte = 127;
        System.out.println(minByte);
        System.out.println(maxByte);

        short minShort = -32768;
        short maxShort = 32767;
        System.out.println(minShort);
        System.out.println(maxShort);

        int minInt = -2147483648;
        int maxInt = 2147483647;
        System.out.println(minInt);
        System.out.println(maxInt);

        long minLong = -2147483649L;
        long maxLong = 2147483648L;
        System.out.println(minLong);
        System.out.println(maxLong);
    }
}
```

## 5、按步骤编写代码，效果如图所示：

![](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/5.jpg)



* 编写步骤：
  1. 定义类Homework5
  2. 定义 main方法
  3. 定义2个 float类型变量,分别赋值,并输出在控制台.
  4. 定义2个 double类型变量,分别赋值,并输出在控制台.

```java
public class Homework5 {
    public static void main(String[] args) {
        float f1 = -3.14F;
        float f2 = 3.14F;
        System.out.println(f1);
        System.out.println(f2);

        double d1 = -3.4;
        double d2 = 3.4;
        System.out.println(d1);
        System.out.println(d2);
    }
}
```



## 6、交换两个变量的值

编写步骤：

1. 定义类Homework6
2. 定义 main方法
3. 定义两个整数变量a，b并赋值
4. 控制台输出变量a，b互换前的值
5. 定义一个第三方变量temp
6. 利用第三方变量temp使a，b的值互换
7. 控制台输出变量a，b互换后的值

![image-20211219152628406](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/image-20211219152628406.png)

```java
public class Homework6 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("互换前：");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        int temp = a;
        a = b;
        b = temp;
        System.out.println("互换后：");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}

```



## 7、按步骤编写代码，效果如图所示：

![](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/8.png)



* 开发提示：四则运算的符号

  ```java
  加: +
  减: -
  乘: *
  除: /
  ```

* 编写步骤：

  1. 定义类 Homework7
  2. 定义 main方法
  3. 定义2个int类型变量x、y，x赋值为100，y赋值为200
  4. 定义新变量add，保存变量x，y的和并打印到控制台
  5. 定义新变量sub，保存变量x，y的差并打印到控制台
  6. 定义新变量mul，保存变量x，y的积并打印到控制台
  7. 定义新变量div，保存变量x，y的商并打印到控制台

```java
public class Homework7 {
    public static void main(String[] args) {
        int x = 100;
        int y = 200;
        System.out.println("x,y的和为：" + (x+y));
        System.out.println("x,y的差为：" + (x-y));
        System.out.println("x,y的积为：" + (x*y));
        System.out.println("x,y的商为：" + (x/y));
    }
}
```



## 8、按步骤编写代码，效果如图所示：

![](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/9.png)

- 编写步骤：

  1. 定义类 Homework8
  2. 定义 main方法
  3. 定义2个double类型变量x、y，x赋值为100.8，y赋值为20.6
  4. 定义新变量add，保存变量x，y的和并打印到控制台
  5. 定义新变量sub，保存变量x，y的差并打印到控制台
  6. 定义新变量mul，保存变量x，y的积并打印到控制台
  7. 定义新变量div，保存变量x，y的商并打印到控制台

```java
public class Homework8 {
    public static void main(String[] args) {
        double x = 100.8;
        double y = 20.6;

        double add = x + y;
        System.out.println("x,y的和为：" + add);

        double sub = x - y;
        System.out.println("x,y的差为：" + sub);

        double mul = x * y;
        System.out.println("x,y的积为：" + mul);

        double div = x / y;
        System.out.println("x,y的商为：" + div);
    }
}
```

## 9、简答题

（1）Java的基本数据类型有哪些？String是基本数据类型吗？

```java
Java的基本数据类型有：byte,short,int,long,float,double,char,boolean
String是Java的引用数据类型，不是基本数据类型。
```



（2）float f=3.4;是否正确，表达式15/2*2的值是多少

```java
float f = 3.4; //编译报错，因为3.4是double类型，大于float类型
15/2*2的值
```



（3）char型变量中是否可以存储一个汉字？

```java
char型变量中可以存储一个汉字
```



