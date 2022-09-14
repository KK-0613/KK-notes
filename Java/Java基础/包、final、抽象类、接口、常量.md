# 包

## 包是什么？

- 包是用来分门别类的管理各种不同类的，类似于文件夹、建包利于程序的管理和维护。
- 建包的语法格式：package 公司域名倒写.技术名称。报名建议全部英文小写，且具备意义

- 建包语句必须在第一行，一般IDEA工具会帮助创建

## 导包

- 假如一个类中需要用到不同类，而这个两个类的名称是一样的，那么默认只能导入一个类，另一个类要带包名访问。

# 权限修饰符

## 什么是权限修饰符

- 权限修饰符：是用来控制一个成员能够被访问的范围。
- 可以修饰成员变量，方法，构造器，内部类，不同权限修饰符修饰的成员能够被访问的范围将受到限制。

## 权限修饰符的具体分类和修饰范围

权限修饰符：有四种作用范围由小到大（private -> 缺省 -> protected - > public ）

- private：同一个类下，可访问
- 缺省：同一个类下、同一个包下不同类，可访问
- protected：同一个类下、同一个包下不同类、不同包下的子类，可访问
- public：同一个类下、同一个包下不同类、不同包下的子类、不同包下的无关类，可访问

## 自己定义成员（变量、方法、构造器等）一般按如下习惯：

- 成员变量一般私有
- 方法一般公开
- 如果该成员希望只被本类访问，使用private修饰
- 如果该成员希望只被本类，同一个包下的其他类和子类访问，用protected修饰

# final

## 作用

- final 关键字是最终的意思，可以修饰（类、方法、变量）
- 修饰类：表明该类是最终类，不能被继承。
- 修饰方法：表明该方法是最终方法，不能被重写。
- 修饰变量：表示该变量第一次赋值后，不能再次被赋值(有且仅能被赋值一次)。

## final修饰变量的注意

- final修饰的变量是基本类型：那么变量存储的**数据值**不能发生改变。
- final修饰的变量是引用类型：那么变量存储的**地址值**不能发生改变，但是地址指向的对象内容是可以发生变化的。

# 常量

## 常量是什么

- 常量是使用了public static final修饰的成员变量，必须有初始化值，而且执行的过程中其值不能被改变。

- 常量名的命名规范：英文单词全部大写，多个单词下划线连接起来。

- 如：

  ```java
  public class Constant {
      public static final String SCHOOL_NAME = "传智教育";
      public static final String LOGIN_NAME = "admin";
      public static final String PASS_WORD = "123456";
  }
  ```

## 常量做信息配置的原理、优势

- 在编译阶段会进行“宏替换”：把使用常量的地方全部替换成真实的字面量。
- 维护系统容易，可读性更好。

# 枚举

## 概述

- 枚举是Java中的一种特殊类型。
- 枚举的作用："是为了做信息的标志和信息的分类"。

### 定义枚举类的格式：

```java
修饰符 enum 枚举名称{
    第一行都是罗列枚举类实例的名称。
}
//例
enum SeasonDemo01 {
    SPRING,SUMMER,AUTUMN,WINTER;
}
//测试
public class Demo01{
    public static void main(String[] args) {
        System.out.println(SeasonDemo01.SPRING);
        System.out.println(SeasonDemo01.SUMMER);
    }
}
//运行结果
SPRING
SUMMER
```

### 枚举的特征

**反编译枚举类**

```java
  Compiled from "Season.java"

public final class Season extends java.lang.Enum<Season> {
    public static final Season SPRING = new Season();
    public static final Season SUMMER = new Season();
    public static final Season AUTUMN = new Season();
    public static final Season WINTER = new Season();

    public static Season[] values();

    public static Season valueOf(java.lang.String);
}

```

**特征**

- 枚举类都是继承了枚举类型：java.lang.Enum

- 枚举都是最终类，不可以被继承。

- 构造器都是私有的，枚举对外不能创建对象。

- 枚举类的第一行默认都是罗列枚举对象的名称的。

- 枚举类相当于是多例模式。

# 抽象类

## 概念

- 在Java中abstract是抽象的意思，可以修饰类、成员方法。
- abstract修饰类，这个类就是抽象类；修饰方法，这个方法就是抽象方法。

```java
修饰符 abstract class 类名{ 
	修饰符 abstract 返回值类型 方法名称(形参列表)；
 }
```

```java
public abstract class Animal {
    public abstract void run();
}
```

## 特点

- 抽象方法只有方法签名，不能声明方法体。
- 一个类中如果定义了抽象方法，这个类必须声明成抽象类，否则报错。

## 使用场景

- 抽象类可以理解成不完整的设计图，一般作为父类，让子类来继承。
- 当父类知道子类一定要完成某些行为，但是每个子类该行为的实现又不同，于是该父类就把该行为定义成抽象方法的形式，具体实现交给子类去完成。此时这个类就可以声明成抽象类。

```java
public abstract class Animal {
    public abstract void run();
}
```
