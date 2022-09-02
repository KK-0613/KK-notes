# static：修饰成员变量，内存机制

## **static是什么**

- static是静态的意思，可以用来修饰成员变量、成员方法。

- static修饰成员变量之后称为静态成员变量（类变量），修饰方法之后称为静态方法（类方法）。

- static修饰后的成员变量，可以被类的所有对象共享（访问、修改)。

```java
public class User {
    static String name;
    int age;
}
```

## static修饰的成员变量是什么？ 有什么特点？

**静态成员变量（有static修饰，属于类、加载一次，内存中只有一份），访问格式**

```
类名.静态成员变量(推荐)
对象.静态成员变量(不推荐)。
```

**实例成员变量（无static修饰，属于对象），访问格式：**

```
对象.实例成员变量。
```

### 两种成员变量各自在什么情况下定义？

- 静态成员变量：表示在线人数等需要被类的所有对象共享的信息时。

- 实例成员变量：属于每个对象，且每个对象的该信息不同时（如：name,age,money…）

## 成员方法的分类

- 静态成员方法（有static修饰，归属于类），建议用类名访问，也可以用对象访问。

  ```
  类名.静态成员方法。
  对象.静态成员方法。（不推荐）
  ```

- 实例成员方法（无static修饰，归属于对象），只能用对象触发访问。

  ```
  对象.实例成员方法。
  ```

  

### 使用场景

- 静态成员方法（有static修饰，归属于类），建议用类名访问，也可以用对象访问。

- 实例成员方法（无static修饰，归属于对象），只能用对象触发访问。

## 实例练习 定义员工类

### 需求

请完成一个标准实体类的设计，并提供如下要求实现。 

1. 某公司的员工信息系统中，需要定义一个公司的员工类Employee，包含如下信息（name, age , 所在部门名称 dept ） , 定义一个静态的成员变量company记录公司的名称。 

2. 需要在Employee类中定义一个方法showInfos()，用于输出当前员工对象的信息。如name, age ，dept 以及公 司名称company的信息。 

3. 需要在Employee类中定义定义一个通用的静态方法compareByAge，用于传输两个员工对象的年龄进入，并返回比较较大的年龄，例如：2个人中的最大年龄是:45岁. 

### 代码实现

员工类

```java
package com.kk.d1_static_employee;

/**
 * @ClassName Employee
 * @Description //TODO
 * @Author kk
 * @Date 2022/9/2 16:14
 * @Version 1.0
 **/
public class Employee {
    public static String company;
    private String name;
    private int age;
    private String dept;

    public Employee() {
    }

    public Employee(String name, int age, String dept) {
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    public static String getCompany() {
        return company;
    }

    public static void setCompany(String company) {
        Employee.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public static int compareByAge(int age1,int age2){
        return Math.max(age1,age2);
    }
}

```

测试类

```java
package com.kk.d1_static_employee;

/**
 * @ClassName EmployeeTest
 * @Description //TODO
 * @Author kk
 * @Date 2022/9/2 16:22
 * @Version 1.0
 **/
public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp1 = new Employee("张三",22,"交付部");
        Employee emp2 = new Employee("李四",23,"研发部");
        Employee emp3 = new Employee("王武",24,"产品部");

        Employee.company = "杭州希望科技有限公司";
        //比较三位同学谁的年龄最大
        int maxAge = Employee.compareByAge(emp1.getAge(),emp2.getAge());
        maxAge = Employee.compareByAge(maxAge,emp3.getAge());
        System.out.println("来自" + Employee.company + "的3个人中的最大年龄是:" + maxAge + "岁.");
    }
}
```

测试结果

```
来自杭州希望科技有限公司的3个人中的最大年龄是:24岁.
```

## static访问注意事项： 

- 静态方法只能访问静态的成员，不可以直接访问实例成员。

- 实例方法可以访问静态的成员，也可以访问实例成员。 

- 静态方法中是不可以出现this关键字的。

## **static应用知识：工具类**

### **工具类是什么？**

- 类中都是一些静态方法，每个方法都是以完成一个共用的功能为目的，这个类用来给系统开发人员共同使用的。

### **举例**

> 在企业的管理系统中，通常需要在一个系统的很多业务处使用验证码进行防刷新等安全控制
>
> > **问题：**
> >
> > 同一个功能多处开发，会出现代码重复度过高。

### **使用工具类的好处**

- 一是调用方便，二是提高了代码复用（一次编写，处处可用）

### **为什么工具类中的方法不用实例方法做？** 

- **实例方法需要创建对象调用。**
- **此时用对象只是为了调用方法，这样只会浪费内存。**

### **工具类定义时的其他要求：**

- 由于工具里面都是静态方法，直接用类名即可访问，因此，工具类无需创建对象，建议将工具类的构造器进行私有。

## 实例练习 定义数组工具类

### 需求：

在实际开发中，经常会遇到一些数组使用的工具类。请按照如下要求编写一个数组的工具类：ArraysUtils 

1. 我们知道数组对象直接输出的时候是输出对象的地址的，而项目中很多地方都需要返回数组的内容，请在 ArraysUtils中提供一个工具类方法toString，用于返回整数数组的内容，返回的字符串格式如：[10, 20, 50, 34, 100]（只考虑整数数组，且只考虑一维数组） 

2. 经常需要统计平均值，平均值为去掉最低分和最高分后的分值，请提供这样一个工具方法getAerage，用于返回平均分。（只考虑浮点型数组，且只考虑一维数组） 

3. 定义一个测试类TestDemo，调用该工具类的工具方法，并返回结果。

### 代码实现

数组工具类

```java
package com.kk.d1_static_arraysutils;

/**
 * @ClassName ArraysUtils
 * @Description //TODO
 * @Author kk
 * @Date 2022/9/2 16:47
 * @Version 1.0
 **/
public class ArraysUtils {
    //返回整数数组的内容
    public static void toString(int[] arrayInt){
        System.out.print("[");
        for (int i = 0; i < arrayInt.length; i++) {
            System.out.print(i == arrayInt.length-1?arrayInt[i]:arrayInt[i] + ",");
        }
        System.out.println("]");
    }

    //统计平均值，平均值为去掉最低分和最高分后的分值
    public static float getAerage(float[] arrayFloat){
        for (int i = 0; i < arrayFloat.length-1; i++) {
            for (int j = 0; j < arrayFloat.length - i - 1; j++) {
                if(arrayFloat[j] < arrayFloat[j+1]){
                    float count = arrayFloat[j+1];
                    arrayFloat[j+1] = arrayFloat[j];
                    arrayFloat[j] = count;
                }
            }
        }
        float sum = 0;
        for (int i = 1; i < arrayFloat.length - 1; i++) {
            sum += arrayFloat[i];
        }
        return sum/(arrayFloat.length-2);
    }

}

```

测试类

```java
package com.kk.d1_static_arraysutils;

/**
 * @ClassName TestDemo
 * @Description //TODO
 * @Author kk
 * @Date 2022/9/2 17:09
 * @Version 1.0
 **/
public class TestDemo {
    public static void main(String[] args) {
        int[] a1 = {22,89,34,23,56};
        float[] f1 = {60.5F,88F,87.5F,90F,60F};

        ArraysUtils.toString(a1);

        System.out.println("------------------------");
        System.out.println("平均分：" + ArraysUtils.getAerage(f1));
    }
}

```

测试结果

```
[22,89,34,23,56]
------------------------
平均分：78.666664
```

## **static应用知识：代码块**

### **代码块概述**

- 代码块是类的5大成分之一（成员变量、构造器，方法，代码块，内部类），定义在类中方法外。 

- 在Java类下，使用 { } 括起来的代码被称为代码块 。

### **代码块分为**

> **静态代码块: **
>
> >  **格式**：static{} 
> >
> >  **特点**：需要通过static关键字修饰，随着类的加载而加载，并且自动触发、只执行一次 
> >
> >  **使用场景**：在类加载的时候做一些静态数据初始化的操作，以便后续使用。
>
>  **构造代码块**（**了解，见的少**）：
>
> > **格式**：{} 
> >
> > **特点**：每次创建对象，调用构造器执行时，都会执行该代码块中的代码，并且在构造器执行前执行 
> >
> > **使用场景**：初始化实例资源。

## 案例练习 斗地主游戏

### 需求

- 在启动游戏房间的时候，应该提前准备好54张牌，后续才可以直接使用这些牌数据。

### 分析

1. 该房间只需要一副牌。
2. 定义一个静态的ArrayList集合存储54张牌对象，静态的集合只会加载一份。
3. 在启动游戏房间前，应该将54张牌初始化好 
4. 当系统启动的同时需要准备好54张牌数据，此时可以用静态代码块完成。

### 代码实现

