# 巩固题

## 1、强制类型转换练习

（1）先声明两个byte类型的变量b1,b2,并分别赋值为10和20，求b1和b2变量的和，并将结果保存在byte类型的变量b3中，最后输出b3变量的值

（2）先声明两个short类型的变量s1,s2,并分别赋值为1000和2000，求s1和s2变量的和，并将结果保存在short类型的变量s3中，最后输出s3变量的值

（3）先声明1个char类型的变量c1赋值为'a'，再声明一个int类型的变量num赋值为5，求c1和num变量的和，并将结果将结果保存在char类型的变量letter中，最后输出letter变量的值。

（4）先声明两个int类型的变量i1,i2，并分别赋值5和2，求i1和i2的商，并将结果保存在double类型的变量result中，最后输出result变量的值。如何得到结果2.5呢？

![image-20211219161207200](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/image-20211219161207200.png)

```java
public class Homework1 {
    public static void main(String[] args) {
        byte b1 = 10;
        byte b2 = 20;
        byte b3 = (byte)(b1 + b2);
        System.out.println("byte类型的b1和b2的和为：" + b3);

        short s1 = 1000;
        short s2 = 2000;
        short s3 = (short)(s1 + s2);
        System.out.println("short类型的s1和s2的和为："+ s3);

        char c1 = 'a';
        int num = 5;
        char letter = (char) (c1 + num);
        System.out.println("char类型的c1和int类型的num的和：" + letter);

        int i1 = 5;
        int i2 = 2;
        double result = (double)i1 / i2;
        System.out.println("int类型的i1和i2的商是：" + result);
    }
}
```



## 2、按步骤编写代码，效果如图所示：

![](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/4.jpg)

1. 定义两个int类型变量a1和a2,分别赋值10,11,判断变量是否为偶数,拼接输出结果
2. 定义两个int类型变量a3和a4,分别赋值12,13,判断变量是否为奇数,拼接输出结果

```java
public class Homework2 {
    public static void main(String[] args) {
        int a1 = 10;
        int a2 = 11;
        int a3 = 12;
        int a4 = 13;
        System.out.println("10是偶数？" + (a1 % 2 == 0));
        System.out.println("11是偶数？" + (a2 % 2 == 0));
        System.out.println("12是奇数？" + (a3 % 2 != 0));
        System.out.println("13是奇数？" + (a4 % 2 != 0));
    }
}

```

## 3、计算时间

案例：为抵抗洪水，战士连续作战89小时，编程计算共多少天零多少小时？

![1557879127503](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/6.png)

1. 定义一个int类型变量hours，赋值为89
2. 定义一个int类型变量day，用来保存89小时中天数的结果
3. 定义一个int类型变量hour，用来保存89小时中不够一天的剩余小时数的结果
4. 输出结果

```java
public class Homework3 {
    public static void main(String[] args){
        int hours = 89;
        int day = hours / 24;
        int hour = hours % 24;
        System.out.println("为抵抗洪水，战士连续作战89小时：");
        System.out.println(hours + "是" + day + "天" + hour +"小时");
    }
}
```



## 4、案例：今天是周2，100天以后是周几？

![1557879464870](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/7.png)

1. 定义一个int类型变量week，赋值为2
2. 修改week的值，在原值基础上加上100
3. 修改week的值，在原值基础上模以7
4. 输出结果，在输出结果的时候考虑特殊值，例如周日

```java
public class Homework4 {
    public static void main(String[] args) {
        int week = 2;
        week += 100;
        week %= 7;
        System.out.println("今天是周2,100天以后是周" + (week == 0 ? "日" : week));
    }
}
```



## 5、案例：求三个整数x,y,z中的最大值

![1557879847378](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/8.png)

1. 定义三个int类型变量,x,y,z，随意赋值整数值
2. 定义一个int类型变量max，先存储x与y中的最大值（使用三元运算符）
3. 再次对max赋值，让它等于上面max与z中的最大值（使用三元运算符）
4. 输出结果

```java
public class Homework5 {
    public static void main(String[] args) {
        int x = 3;
        int y = 4;
        int z = 1;
        int max = x > y ? x : y;
        max = max > z ? max : z;
        System.out.println(x + "," + y + "," + z + "中的最大值是：" + max);
    }
}

```

## 6、案例：判断今年是否是闰年

闰年的判断标准是：

​       1）可以被4整除，但不可被100整除

​       2）可以被400整除

![1557902649882](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/9.png)

1. 定义一个int类型变量year，赋值为今年年份值
2. 定一个一个boolean类型变量，用来保存这个年份是否是闰年的结果
3. 输出结果

```java
public class Homework6 {
    public static void main(String[] args) {
        int year = 2018;
        boolean result = year%4==0 && year%100!=0 || year%400==0;
        System.out.println(year + (result ? "是闰年" : "不是闰年"));
    }
}

```

## 7、华氏度转摄氏度

案例：小明要到美国旅游，可是那里的温度是以华氏度为单位记录的。它需要一个程序将华氏温度（80度）转换为摄氏度，并以华氏度和摄氏度为单位分别显示该温度。

![1557903785834](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1557903785834.png)

![1557903814057](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1557903814057.png)

1. 定义一个double类型变量hua，存储华氏温度80
2. 定义一个double类型变量she，存储摄氏温度，根据公式求值
3. 输出结果

```java
public class Homework7 {
    public static void main(String[] args) {
        double hua = 80;
        double she = (hua-32)/1.8;
        System.out.println("华氏度" + hua+"℉转为摄氏度是" +she+"℃");
    }
}

```



# 拔高题

## 第一题

```java
如下代码的计算结果是：
int i = 1;
i *= 0.2;  
i++;
System.out.println("i=" + i);//1
```

## 第二题

```java
如下代码的运算结果是：
int i = 2;
i *= i++;

int j = 2;
j *= j+1; 

int k = 2;
k *= ++k;

System.out.println("i=" + i);//4
System.out.println("j=" + j);//6
System.out.println("k=" + k);//6
```

## 第三题

```java
如下代码的运算结果是：
int a = 3;
int b = 1;
if(a = b){//编译报错
	System.out.println("Equal");
}else{
	System.out.println("Not Equal");
}
```

## 第四题

```java
如下代码的运算结果是：
int a = 8, b = 3;
System.out.println(a>>>b);//1
System.out.println(a>>>b | 2);//3
```

## 第五题

如何用最有效的的方法计算2乘以8

```java
public class Homework8 {
    public static void main(String[] args) {
        System.out.println(2<<3);
    }
}
```

