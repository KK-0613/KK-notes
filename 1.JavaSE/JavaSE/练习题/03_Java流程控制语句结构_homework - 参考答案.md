# 巩固题

## 1、判断5的倍数

从键盘输入一个整数，判断它是否是5的倍数

```java
import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("请输入一个整数：");
        int num = input.nextInt();

        input.close();

        if(num % 5==0){
            System.out.println(num +"是5的倍数");
        }else{
            System.out.println(num +"不是5的倍数");
        }
    }
}
```

## 2、判断字符类型

从键盘输入一个字符，判断它是字母还是数字，还是其他字符

```java
import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("请输入一个字符：");
        char c = input.next().charAt(0);

        input.close();

        if(c >= '0' && c <= '9'){
            System.out.println(c + "是数字字符.");
        }else if(c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z'){
            System.out.println(c + "是字母字符.");
        }else{
            System.out.println(c + "是非数字非字母的其他字符.");
        }
    }
}
```



## 3、计算折扣后金额

从键盘输入订单总价格totalPrice（总价格必须>=0），根据优惠政策计算打折后的总价格。

编写步骤：

1. 判断当`totalPrice >=500` ,discount赋值为0.8
2. 判断当`totalPrice >=400` 且`<500`时,discount赋值为0.85
3. 判断当`totalPrice >=300` 且`<400`时,discount赋值为0.9
4. 判断当`totalPrice >=200` 且`<300`时,discount赋值为0.95
5. 判断当`totalPrice >=0` 且`<200`时,不打折，即discount赋值为1
6. 判断当`totalPrice<0`时，显示输入有误
7. 输出结果

```java
import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("请输入订单总价格：");
        double totalPrice = input.nextDouble();

        input.close();

        if(totalPrice >= 0){
            double discount;
            if(totalPrice>=500){
                discount = 0.8;
            }else if(totalPrice>=400){
                discount = 0.85;
            }else if(totalPrice>=300){
                discount = 0.9;
            }else if(totalPrice>=200){
                discount = 0.95;
            }else{
                discount = 1;
            }
            System.out.println("订单总价：" + totalPrice);
            System.out.println("享受的折扣：" + discount);
            System.out.println("折扣后总价：" + totalPrice * discount);
        }else{
            System.out.println("总价格输入有误！");
        }
    }
}
```

## 4、输出月份对应的英语单词

从键盘输入月份值，输出对应的英语单词

```java
import java.util.Scanner;

public class Homework4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("请输入月份值：");
        int month = input.nextInt();

        input.close();

        switch (month){
            case 1:System.out.println("January");break;
            case 2:System.out.println("February");break;
            case 3:System.out.println("March");break;
            case 4:System.out.println("April");break;
            case 5:System.out.println("May");break;
            case 6:System.out.println("June");break;
            case 7:System.out.println("July");break;
            case 8:System.out.println("August");break;
            case 9:System.out.println("September");break;
            case 10:System.out.println("October");break;
            case 11:System.out.println("November");break;
            case 12:System.out.println("December");break;
            default:System.out.println("月份值输入有误！");
        }

    }
}
```



## 5、计算今天是星期几

定义变量week赋值为上一年12月31日的星期值（可以通过查询日历获取），定义变量year、month、day，分别赋值今天日期年、月、日值。计算今天是星期几。

```java
public class Homework5 {
    public static void main(String[] args) {
        int week = 5;//查询日期得知
        int year = 2022;
        int month = 3;
        int day = 8;

        //判断这一天是当年的第几天==>从1月1日开始，累加到xx月xx日这一天
        //(1)[1,month-1]个月满月天数
        //(2)单独考虑2月份是否是29天（依据是看year是否是闰年）
        //(3)第month个月的day天

        //声明一个变量days，用来存储总天数
        int days = 0;

        //累加[1,month-1]个月满月天数
        switch (month) {
            case 12:
                //累加的1-11月
                days += 30;//这个30是代表11月份的满月天数
                //这里没有break，继续往下走
            case 11:
                //累加的1-10月
                days += 31;//这个31是代表10月的满月天数
                //这里没有break，继续往下走
            case 10:
                days += 30;//9月
            case 9:
                days += 31;//8月
            case 8:
                days += 31;//7月
            case 7:
                days += 30;//6月
            case 6:
                days += 31;//5月
            case 5:
                days += 30;//4月
            case 4:
                days += 31;//3月
            case 3:
                days += 28;//2月
                //在这里考虑是否可能是29天
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    days++;//多加1天
                }
            case 2:
                days += 31;//1月
            case 1:
                days += day;//第month月的day天
        }

        //计算星期
        week += days;
        week %= 7;

        //输出结果
        System.out.print(year + "年" + month + "月" + day + "日是星期");
        switch (week) {
            case 0:
                System.out.println("日");
                break;
            case 1:
                System.out.println("一");
                break;
            case 2:
                System.out.println("二");
                break;
            case 3:
                System.out.println("三");
                break;
            case 4:
                System.out.println("四");
                break;
            case 5:
                System.out.println("五");
                break;
            case 6:
                System.out.println("六");
                break;
        }
    }
}

```



# 拔高题

## 1、判断年、月、日是否合法

从键盘输入年、月、日，要求年份必须是正整数，月份范围是[1,12]，日期也必须在本月总天数范围内，如果输入正确，输出“年-月-日”结果，否则提示输入错误。

```java
import java.util.Scanner;

public class Homework6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("请输入日期：");
        System.out.print("年：");
        int year = input.nextInt();

        System.out.print("月：");
        int month = input.nextInt();

        System.out.print("日：");
        int day = input.nextInt();

        input.close();

        if (year > 0) {
            if (month >= 1 && month <= 12) {
                //计算month月的总天数
                int days;
                if (month == 2) {
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        days = 29;
                    } else {
                        days = 28;
                    }
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    days = 30;
                } else {
                    days = 31;
                }

                if(day >= 1 && day <= days) {
                    System.out.println(year + "-" + month + "-" + day);
                }else{
                    System.out.println("日期输入不合法");
                }
            } else {
                System.out.println("月份输入不合法");
            }
        } else {
            System.out.println("年份输入不合法");
        }
    }
}

```



# 简答题

1、switch是否能作用在byte上，是否能作用在long上，是否能作用在String上？

```java
switch(表达式)支持的类型有byte,short,int,char,String和枚举
```

