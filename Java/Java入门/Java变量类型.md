# Java变量类型

## 声明变量
```java
int a, b, c;    //声明三个int型整数:a,b,c
int d = 3, e = 4, f = 5; // 声明三个整数并赋予初值
byte z = 22;         // 声明并初始化 z
String s = "runoob";  // 声明并初始化字符串 s
double pi = 3.14159; // 声明了双精度浮点型变量 pi
char x = 'x';        // 声明变量 x 的值是字符 'x'。
```

## 变量类型
```java
public class Variable{
    static int allClicks=0;    // 类变量,独立方法外，用static修饰
 
    String str="hello world";  // 实例变量，独立方法外
 
    public void method(){
 
        int i =0;  // 局部变量，方法中变量
 
    }
}
```

## 局部变量
- 局部变量声明在方法、构造方法或者语句块中；
- 局部变量会在方法、构造方法和语句块被执行的时候创建，执行完后被销毁；
- 访问修饰符不能用于局部变量；
- 局部变量只在声明它的范围内可见；
- 局部变量是在栈上分配的；
- 无初始值，声明后必须初始化才能使用；

### 实例
1. 下述的age就是一个局部变量，只能在pupAge中使用

```java
package com.kk.test;

public class Test1 {
    public void pupAge(){
        int age = 0;
        age = age+7;
        System.out.println("小狗的年龄是" + age + "岁");
    }

    public static void main(String[] args) {
        Test1 test = new Test1();
        test.pupAge();
    }
}
```
编译运行结果如下：
    
    小狗的年龄是7岁

2. 在下述中，未对age初始化便直接使用，故而报错
```java
package com.kk.test;

public class Test2 {
    public void pupAge(){
        int age;
        age = age + 7;
        System.out.println("小狗的年龄是" + age + "岁");
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.pupAge();
    }
}
```
运行编译后结果如下
    
    2022/8/24, 14:48 - 编译完成1秒897毫秒中 1 个错误 和 0 个警告
    java: 可能尚未初始化变量age

## 实例变量

- 实例变量声明在一个类中，但在方法、构造方法和语句块之外；
- 当一个对象被实例化之后，每个实例变量的值就跟着确定；
- 实例变量在对象创建的时候创建，在对象被销毁的时候销毁；
- 实例变量的值应该至少被一个方法、构造方法或者语句块引用，使得外部能够通过这些方式获取实例变量信息；
- 实例变量可以声明在使用前或者使用后；
- 访问修饰符可以修饰实例变量；
- 实例变量对于类中的方法、构造方法或者语句块是可见的。一般情况下应该把实例变量设为私有。通过使用访问修饰符可以使实例变量对子类可见；
- 实例变量具有默认值。数值型变量的默认值是0，布尔型变量的默认值是false，引用类型变量的默认值是null。变量的值可以在声明时指定，也可以在构造方法中指定；
- 实例变量可以直接通过变量名访问。但在静态方法以及其他类中，就应该使用完全限定名：ObjectReference.VariableName。
### 实例
```java
package com.kk.employee;

public class Employee2 {
    // 这个实例变量对子类可见
    public String name;
    // 这个实例变量仅在该类可见
    private double salary;

    public Employee2(String empName){
        name = empName;
    }

    public void setSalary(double empSalary){
        salary = empSalary ;
    }

    public void printEmp(){
        System.out.println("姓名：" + name);
        System.out.println("薪水：" + salary);
    }

    public static void main(String[] args) {
        Employee2 emp = new Employee2("张三");
        emp.setSalary(1000.0);
        emp.printEmp();
    }
}

```
编译运行结果如下：
    
    姓名：张三
    薪水：1000.0

## 类变量
- 类变量也称为静态变量，在类中以 **static** 关键字**声明**，但必须在方法之外。
- 无论一个类创建了多少个对象，类只拥有类变量的一份拷贝。
- 静态变量除了被声明为常量外很少使用，静态变量是指声明为 public/private，final 和 static 类型的变量。静态变量初始化后不可改变。
- 静态变量储存在静态存储区。经常被声明为常量，很少单独使用 static 声明变量。
- 静态变量在第一次被访问时创建，在程序结束时销毁。
- 与实例变量具有相似的可见性。但为了对类的使用者可见，大多数静态变量声明为 public 类型。
- 默认值和实例变量相似。数值型变量默认值是 0，布尔型默认值是 false，引用类型默认值是 null。变量的值可以在声明的时候指定，也可以在构造方法中指定。此外，静态变量还可以在静态语句块中初始化。
- 静态变量可以通过：ClassName.VariableName的方式访问。
- 类变量被声明为 public static final 类型时，类变量名称一般建议使用大写字母。如果静态变量不是 public 和 final 类型，其命名方式与实例变量以及局部变量的命名方式一致。

### 实例
```java
package com.kk.employee;

public class Employee3 {
    //salary是静态的私有变量
    private static double salary;
    //DEPARTMENT是一个常量
    public static final String DEPARTMENT = "开发人员";

    public static void main(String[] args) {
        salary = 10000;
        System.out.println(DEPARTMENT + "平均工资:" + salary);
    }
}

```
**注意**：如果其他类想要访问该变量，可以这样访问：Employee.DEPARTMENT。