# Java方法实例练习

## 实例1 求 1 - n 的和

### 需求

**定义一个方法，方法中计算1 - n的和并返回**

### 实现

```java
package com.kk.demo;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入计算1-n的n是：");
        int n = sc.nextInt();
        System.out.println("1-" + n + "的和为" + sum(n));
    }

    public static int sum(int n){
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }
}

```

### 返回结果

```jav
请输入计算1-n的n是：
100
1-100的和为5050
```



## 实例2 判断整数是奇数还是偶数

### 需求

**拿一个整数，然后调用方法，把整数交给方法，在方法中输出该数为奇数还是偶数**

### 实现

```java
package com.kk.demo;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要判断的整数：");
        int num = sc.nextInt();
        numType(num);
    }

    public static void numType(int num){
        if((num % 2) == 0) {
            System.out.println("偶数");
        }
        else{
            System.out.println("奇数");
        }
    }
}

```

### 返回结果

```jav
请输入要判断的整数：
55
奇数
```

## 实例3 数组求最值

### 需求

**找出数组的最大值，要求可以返回任意类型整型数组的最大值数据**

### 实现

```java
package com.kk.demo;

import java.util.Random;

public class Demo03 {
    public static void main(String[] args) {
        int[] array = new int[5];
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(100);
            System.out.println(array[i] + " ");
        }
        System.out.println("最大值是：" + maxNum(array));
    }

    public static int maxNum(int[] array){
        int maxN = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i] > maxN){
                maxN = array[i];
            }
        }
        return maxN;
    }
}

```

### 返回结果

```jav
74 95 99 48 69 最大值是：99
```



