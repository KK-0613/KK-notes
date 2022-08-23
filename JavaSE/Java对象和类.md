# Java对象和类
## 简介
- 对象：对象是类的一个实例，有状态和行为。例如，一条狗是一个对象，它的状态有：颜色、名字、品种；行为有：摇尾巴、叫、吃等。
- 类：类是一个模版，它描述一类对象的行为和状态。

比如：男孩和女孩是类（class），具体的某个男孩和女孩是对象（object）<br>
![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/boy-class.jpeg)

再如：汽车是类（class），而具体的每一辆汽车是对象（object），对象包含了汽车的颜色、品牌、名称等。
![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/car-class_00.png)

## Java中的对象
Java中的对象和现实中的对象极为相似。
Java中的对象也有状态和行为，在Java中的状态对应着属性，行为通过方法来体现。
在软件开发中，方法操作对象内部状态的改变，对象的相互调用也是通过方法来完成。

## Java中的类
类可以看作是创建Java对象的模板。
![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20210105-java-object-1.png)

通过上图创建一个简单的类来理解一下Java中类的定义：

```java
public class Dog {
    String status;
    int size;
    String colour;
    int age;
    String name;

    public Dog(String name){
        this.name=name;
    }
    void eat(){
        this.status = "吃饭";
    }

    void run(){
       this.status = "奔跑";
    }

    void sleep(){
        this.status = "睡觉";
    }
}
```
一个类可以包含以下类型变量：
- 局部变量：在方法、构造方法或者语句块中定义的变量被称为局部变量。声明变量和初始化都是在方法中，方法结束后，变量就会自动销毁。
- 成员变量：成员变量是定义中类中，方法体之外的变量。这种变量在创建对象的时候实例化。成员变量可以被类中方法、构造方法和特定类的语句块访问。
- 类变量：类变量也声明在类中，方法体之外，但必须声明为static类型。

一个类可以拥有多个方法，在上面的例子中：eat()、run()、和name()都是Dog类的方法

## 构造方法
每个类都有构造方法。如果没有显式地为类定义构造方法，Java编译器将会为该类提供一个默认构造方法。  
在创建一个对象的时候，至少要调用一个构造方法。构造方法的名称必须与类同名，一个类可以有多个构造方法。
下面是一个构造方法示例：
```java
public class Puppy {
    public Puppy(){
    }
    public Puppy(String name){
        // 这个构造函数仅有一个参数name
    }
}
```
## 创建对象
对象是根据类创建的。在Java中，使用关键字new来创建一个新的对象。创建对象需要以下三步：
1. 声明：声明一个对象，包括对象名称和对象类型。
2. 实例化：使用关键字new来创建一个对象。
3. 初始化：使用new创建对象时，会调用构造方法初始化对象。

下面是一个创建对象的例子：
```java
public class Puppy {
    public Puppy(){
    }
    public Puppy(String name){
        // 这个构造函数仅有一个参数name
        System.out.println("小狗的名字叫"+name);
    }

    public static void main(String[] args) {
        //下面的语句将创建一个Puppy对象
        Puppy myPuppy = new Puppy("coco");
    }
}
```
编译运行以上程序，打印结果：
    
    小狗的名字叫coco
    
## 访问实例变量和方法
通过前面已创建的Dog类来测试访问成员变量和成员方法，如下所示：
```java
public class DogDemo {
    public static void main(String[] args) {
        Dog dog1 = new Dog("coco");
        dog1.age=5;
        dog1.colour = "黄色";
        int age = dog1.age;
        dog1.run();
        System.out.println(dog1.status+"的"+dog1.colour+"小狗是"+dog1.name+",它的年龄是"+age+"岁");
    }
}
```
输出结果：
    
    奔跑的黄色小狗是coco,它的年龄是5岁
    
## 源文件声明规则
当在一个源文件中定义多个类，并且还有import语句和package语句时，要特别注意这些规则。

- 一个源文件中只能有一个public类
- 一个源文件可以有多个非public类
- 源文件的名称应该和public类的类名保持一致。例如：源文件的public类的类名是Employee，那么源文件应该命名为Employee.java。
- 如果一个类定义在某个包中，那么package语句应该中源文件的首行
- 如果源文件包含import语句，那么应该放在package语句和类定义之间。如果没有package语句，那么import语句应该中源文件最前面。
- import语句和package语句对源文件中定义的所有类都有效。在同一源文件中，不能给不同的类不同的包声明

## Java包
包主要用来对类和接口进行分类。当开发Java程序时，可能编写成百上千的类，因此很有必要对类和接口进行分类。

## import语句
在Java中，如果给出一个完整的限定名，包括包名、类名，那么Java编译器就可以很容易的定位到源代码或者类。  
import语句就是用来提供一个合理的路径，使得编译器可以找到某个类。  
例如，下面的命令行将会命令编译器载入java_installation/java/io路径下的所有类
    
    import java.io.*;
    
## 一个简单的示例
在该例中，我们创建两个类：Employee和EmployeeTest。  
Employee类有四个成员变量：name、age、designation和salary。该类显示声明了一个构造方法，该方法只有应该参数。  
Employee：
```java
package com.kk.employee;

public class Employee {
    String name;
    int age;
    String designation;
    double salary;

    public Employee(String name){
        this.name = name;
    }
    //设置员工年龄
    public void empAge(int empAge){
        age = empAge;
    }
    //设置员工职位
    public void empDesignation(String empDsign){
        designation = empDsign;
    }
    //设置员工工资
    public void empSalary(double empSalary){
        salary = empSalary;
    }
    //打印员工信息
    public void printEmployee(){
        System.out.println("名字："+name);
        System.out.println("年龄："+age);
        System.out.println("职位："+designation);
        System.out.println("薪水："+salary);
    }
}

```
EmployeeTest类实例化2个Employee类的实例，并调用方法设置变量的值。  
EmployeeTest：
```java
package com.kk.employee;

public class EmployyTest {
    public static void main(String[] args) {
        //使用构造器创建两个对象
        Employee emp01 = new Employee("KK");
        Employee emp02 = new Employee("TT");

        //调用这两个对象的成员方法
        emp01.empAge(26);
        emp01.empDesignation("高级程序员");
        emp01.empSalary(1000);
        emp01.printEmployee();
        System.out.println("---------------------------");
        emp02.empAge(21);
        emp02.empDesignation("菜鸟程序员");
        emp02.empSalary(500);
        emp02.printEmployee();
    }
}
```
编译运行EmployeeTest类，结果如下：
```
名字：KK
年龄：26
职位：高级程序员
薪水：1000.0
---------------------------
名字：TT
年龄：21
职位：菜鸟程序员
薪水：500.0
```
