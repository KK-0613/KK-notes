# Java 单独使用return关键字

## 需求

**return; ------>可以立即跳出并结束当前方法的执行；return关键字单独使用可以放在任何方法中**

## 实现

```java
package com.kk.demo;

public class Demo07 {
    public static void main(String[] args) {
        System.out.println("main方法开始");
        chu(10,0);
        System.out.println("main方法结束");
    }
    public static void chu(int a, int b){
        if(b == 0){
            System.out.println("数据有误，除数不可为0！！");
            return;//立即跳出当前方法，并结束当前方法的执行。
        }
        int c = a / b;
        System.out.println("结果是：" + c);
    }
}

```

返回结果

```java
main方法开始
数据有误，除数不可为0！！
main方法结束
```

