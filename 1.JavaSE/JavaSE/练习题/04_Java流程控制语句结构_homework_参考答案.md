# 巩固题

## 1、5个一行输出1-100之间的偶数

输出1-100偶数，每5个一行，一行中的每个数字之间使用逗号分隔

```java
public class Homework1 {
    public static void main(String[] args) {
        for (int i=2; i<=100; i+=2){
            if(i%10 != 0){
                System.out.print(i + ",");
            }else{
                System.out.println(i);
            }
        }
    }
}
```

或

```java
public class Homework1 {
    public static void main(String[] args) {
        int count = 0;
        for (int i=2; i<=100; i+=2){
            count++;
            if(count<5){
                System.out.print(i + ",");
            }else{
                System.out.println(i);
                count = 0;
            }
        }
    }
}
```

## 2、趣味折纸

世界最高山峰是珠穆朗玛峰，它的高度是8848.86米，假如我有一张足够大的纸，它的厚度是0.1毫米。请问，我折叠多少次，可以折成珠穆朗玛峰的高度?

```java
public class Homework2 {
    public static void main(String[] args) {
        //定义一个计数器，初始值为0
        int count = 0;

        //定义珠穆朗玛峰的高度
        int zf = 8848860;//单位毫米

        //循环的执行过程中每次纸张折叠，纸张的厚度要加倍
        for(double paper = 0.1; paper < zf;  paper *= 2){
            //在循环中执行累加，对应折叠了多少次
            count++;
        }

        //打印计数器的值
        System.out.println("需要折叠：" + count + "次");
    }
}
```

## 3、实现输出如下任一个数字三角形

```java
1
12
123
1234
12345

或

1
22
333
4444
55555

或
    
    1
   222
  33333
 4444444
555555555
```

```java
public class Homework3 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5 ; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}

```

```java
public class Homework3 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5 ; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}

```

```java
public class Homework3 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5 ; i++) {
            for(int j=4; j>=i; j--){
                System.out.print(" ");
            }
            for(int j=1; j<=2*i-1; j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
```

## 4、计算这一天是这一年的第几天

案例需求：从键盘分别输入年、月、日，使用循环for+if实现，判断这一天是当年的第几天 

```java
import java.util.Scanner;

public class Homework4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("请输入年：");
        int year = input.nextInt();

        System.out.print("请输入月：");
        int month = input.nextInt();

        System.out.print("请输入日：");
        int day = input.nextInt();
        
        input.close();
        
        //计算这一天是这一年的第几天
        int days = day;
        for (int i = 1; i < month; i++) {
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                days += 30;
            } else if (i == 2) {
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    days += 29;
                } else {
                    days += 28;
                }
            } else {
                days += 31;
            }
        }
        System.out.println(year + "年" + month + "月" + day + "日是这一年的第" + days + "天");
    }
}

```



# 拔高题

## 1、计算这一天是这一年的第几天

案例需求：从键盘分别输入年、月、日，判断这一天是当年的第几天。并增加输入值的合法性判断，确保输入的年份值必须大于0，月份值必须在[1,12]之间，日期值必须在[1, 当月最大日期值]范围内。

```java
import java.util.Scanner;

public class Homework5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //如果要考虑输入非法值的情况，代码就比较复杂
        System.out.println("请输入日期：");
        int year;
        while(true){
            System.out.print("年：");
            year = input.nextInt();

            if(year > 0){
                break;
            }else{
                System.out.println("年份必须大于0");
            }
        }

        int month;
        while(true){
            System.out.print("月：");
            month = input.nextInt();

            if(month >=1 && month <= 12){
                break;
            }else{
                System.out.println("月份范围是[1,12]");
            }
        }

        //计算month月的总天数
        int totalDaysOfMonth;
        if (month == 2) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                totalDaysOfMonth = 29;
            } else {
                totalDaysOfMonth = 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            totalDaysOfMonth = 30;
        } else {
            totalDaysOfMonth = 31;
        }

        int day;
        while(true){
            System.out.print("日");
            day = input.nextInt();

            if(day <= 0){
                System.out.println("日期必须大于0");
            }else if(day > totalDaysOfMonth){
                System.out.println(year +"年" + month +"月最多只有" + totalDaysOfMonth + "天");
            }else{
                break;
            }
        }

        input.close();

        //计算这一天是这一年的第几天
        int days = day;
        for (int i = 1; i < month; i++) {
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                days += 30;
            } else if (i == 2) {
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    days += 29;
                } else {
                    days += 28;
                }
            } else {
                days += 31;
            }
        }
        System.out.println(year + "年" + month + "月" + day + "日是这一年的第" + days + "天");
    }
}
```



## 2、打印空心菱形



![1558009783968](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1558009783968.png)

* 开发提示：

  * 平面图形涉及到有行有列，考虑到嵌套for循环
  * 一个外循环控制行，两个内循环控制输出内容
  * 一个内循环负责输出空格，另一个内循环输出"*"或空格

```java
public class Homework8 {
    public static void main(String[] args){
        //上半部分：正的等腰三角形
        //5行
        for(int i=1; i<=5; i++){
            //(1)打印空格
			/*
			当i=1,打印4个空格，j=4,3,2,1	j>=i
			当i=2,打印3个空格，j=4,3,2
			当i=3,打印2个空格，j=4,3
			当i=4,打印1个空格，j=4
			当i=5,打印0个空格，j=4,让循环条件一次都不满足
			*/
            for(int j=4; j>=i; j--){
                System.out.print("  ");
            }
            //(2)打印*
			/*
			当i=1,打印1个,j=1					j<=2*i-1
			当i=2,打印3个,j=1,2,3,
			当i=3,打印5个,j=1,2,3,4,5
			当i=4,打印7个,j=1,2,3,4,5,6,7
			当i=5,打印9个,j=1,2,3,4,5,6,7,8,9
			*/
            for(int j=1; j<=2*i-1; j++){
                //不是全部打印*
                if(j==1 || j==2*i-1){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            //(3)换行
            System.out.println();
        }


        //下半部分：倒立的等腰三角形
        //4行
        for(int i=1; i<=4; i++){
            //(1)打印空格
			/*
			当i=1,1个空格,j=1		j<=i
			当i=2,2个空格,j=1,2
			当i=3,3个空格,j=1,2,3
			当i=4,4个空格,j=1,2,3,4
			*/
            for(int j=1; j<=i; j++){
                System.out.print("  ");
            }
            //(2)打印*
			/*
			当i=1,7个*，j=1,2,3,4,5,6,7  j<=9-2*i;
			当i=2,5个*，j=1,2,3,4,5
			当i=3,3个*，j=1,2,3
			当i=4,1个*，j=1
			*/
            for(int j=1; j<=9-2*i; j++){
                //不是全部打印*
                if(j==1 || j==9-2*i){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            //(3)换行
            System.out.println();
        }
    }
}
```

