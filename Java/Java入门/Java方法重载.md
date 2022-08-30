# Java方法重载

## 定义

**同一个类**中，出现**多个方法名称相同**，但是**形参列表是不同的**，那么这些方法就是**重载方法**。

## 案例

```java
package com.kk.overload;

public class MethodDemo01 {
    public static void main(String[] args) {
        fire();
        fire("A");
        fire("A","B");
    }
    public static void fire(){
        System.out.println("默认发射一枚武器给米国---");
    }
    public static void fire(String location){
        System.out.println("发射一枚武器给"+location+"国---");
    }
    public static void fire(String location,String location1){
        System.out.println("发射一枚武器给"+location+"国和"+location1+"国---");
    }
}

```

返回结果

```java
默认发射一枚武器给米国---
发射一枚武器给A国---
发射一枚武器给A国和B国---
```

## 案例改进

```java 
package com.kk.overload;

public class MethodDemo02 {
    public static void main(String[] args) {
        fire();
        fire("A");
        fire("A",100);

    }
    public static void fire(){
        fire("米");
    }
    public static void fire(String location){
        fire(location,1);
    }
    public static void fire(String location,int num){
        System.out.println("发射"+num+"枚武器给"+location+"国---");
    }
}
```

返回结果

```java
发射1枚武器给米国---
发射1枚武器给A国---
发射100枚武器给A国---
```

