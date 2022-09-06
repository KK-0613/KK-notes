# 继承

## 继承概述、使用继承的好处

### 什么是继承

- Java中提供一个关键字extends，用这个关键字，我们可以让一个类和另一个类建立起父子关系。

  ```java
  public class Student extends People {}
  ```

- Student称为子类（派生类），People称为父类(基类 或超类)。
- 作用：当子类继承父类后，就可以直接使用父类公共的属性和方法了

### 继承的格式

``` java
子类 extends 父类
```

### 继承的特点

- 子类继承父类后，就可以得到父类的属性和行为。

### 继承的核心优点

- 提高代码的复用性，多个子类的相同代码可以放在父类中，增强了类的扩展性。

## 继承的设计规范、内存运行原理

### 设计规范

- 子类共用属性和行为放在父类，子类独有属性和行为放在自己子类那里

### 内存原理（重要）

![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220906210951.png)

### 继承的特点

- 子类可以继承父类的属性和方法，但是子类不能继承父类的构造器
- 关于子类是否可以继承父类的私有成员，有前辈跟我说他认为是可以的，只是不能直接访问
- 子类可以直接用子类名访问父类的静态成员，那么子类是否是继承了父类的静态成员呢？我认为那不算是继承，只能说是可以共享的去访问父类的静态成员，共享并非继承（我觉得静态方法只有一份，父类子类访问的都是那一份）
- Java是单继承：一个类只能继承一个父类
- Java不支持多继承，但是支持多层继承
- Java中所有的类都是Object类的子类

### 继承后

#### 成员变量、成员方法的访问特点

- 就近原则

- this.子类自己的成员变量

- 在子类方法中怎么访问父类成员？

  ```JAVA
  super.父类成员变量/父类成员方法
  ```

#### 方法重写

##### 概念

子类重写了一个申明与父类一样的方法，覆盖父类的方法。子类认为父类的方法不好用，以后都使用自己重写的方法

##### 重写方法建议加上一个重写校验注解：@Override

- 作用：
  1. 要求必须是正确重写的才不会报错
  2. 可读性好

##### 重写的要求

1. 重写方法的名称和形参列表**必须**和父类的名称和形参列表一致
2. 私有方法不能重写
3. 静态方法不能重写
4. 重写方法的权限>=被重写方法的权限

#### 子类构造器的特点

##### 特点

- 子类的全部构造器默认都会先访问父类的无参构造器，再执行自己的构造器

  - why？

    先有爸爸再有儿子，先调用它爸爸的构造器初始化父类的数据，再调用自己的构造器初始化自己的数据

#### 子类构造器访问父类有参构造器

- 调用父类有参构造器，初始化继承自父类的数据。
- super(...)根据参数调用父类构造器

### this、super使用总结

- this访问子类当前对象的成员
- super：在子类方法中指定访问父类的成员
- this(...)：访问本类的兄弟构造器
- super(...)：在本类构造器中指定访问父类的构造器
- super(...)、this(...)都必须放在第一行，所以两者不能共存在一个构造器中

## 继承案例练习：学生教师类都继承自人类

### 需求

1. 人类：

   - 成员变量：姓名、年龄

   - 构造方法：无参、有参
   - 成员方法：看课表

2. 教师类：

   - 成员变量：职称
   - 构造方法：自身无参，有参，带有继承自父类的成员变量的有参
   - 成员方法：getter/setter，备课，重写父类的看课表方法

3. 学生类：

   - 成员变量：学号
   - 构造方法：自身无参，有参，带有继承自父类的成员变量的有参
   - 成员方法：getter/setter，考试

4. 测试类：

创建一个学生对象和一个老师对象，要求分别通过学生对象和教师对象设置其姓名年龄，并且都完成看课表的操作，同时学生完成考试，教师完成备课

### 实现

人类

```java
package com.kk.extends_demo;

/**
 * @ClassName
 * @Description //TODO
 * @Author kk
 * @Date 2022/9/6 22:15
 * @Version 1.0
 **/

public class People {
    String name;
    int age;

    public People(){
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void queryScheduler(){
        System.out.println("周一：语文，数学");
        System.out.println("周二：英语，数学");
        System.out.println("周三：语文，英语");
        System.out.println("......");
    }
}

```

教师类

```java
package com.kk.extends_demo;

/**
 * @ClassName
 * @Description //TODO
 * @Author kk
 * @Date 2022/9/6 22:16
 * @Version 1.0
 **/

public class Teacher extends People{
    private String title;

    public Teacher() {
    }

    public Teacher(String title) {
        this.title = title;
    }

    public Teacher(String name, int age, String title) {
        super(name, age);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return super.name;
    }

    public void setName(String name) {
        super.name = name;
    }

    public int getAge() {
        return super.age;
    }

    public void setAge(int age) {
        super.age = age;
    }

    public void preparing(){
        System.out.println(super.age+"的"+this.title+":"+super.name+"在备课");
    }
}

```

学生类

```java
package com.kk.extends_demo;

/**
 * @ClassName
 * @Description //TODO
 * @Author kk
 * @Date 2022/9/6 22:16
 * @Version 1.0
 **/

public class Student extends People{
    private String stuId;
    private String stuMajor;

    public Student(String stuId, String stuMajor) {
        this.stuId = stuId;
        this.stuMajor = stuMajor;
    }

    public Student(String name, int age, String stuId, String stuMajor) {
        super(name, age);
        this.stuId = stuId;
        this.stuMajor = stuMajor;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuMajor() {
        return stuMajor;
    }

    public void setStuMajor(String stuMajor) {
        this.stuMajor = stuMajor;
    }
    public String getName() {
        return super.name;
    }

    public void setName(String name) {
        super.name = name;
    }

    public int getAge() {
        return super.age;
    }

    public void setAge(int age) {
        super.age = age;
    }

    @Override
    public void queryScheduler(){
        System.out.println("周一：语文，数学");
        System.out.println("周二：英语，数学");
        System.out.println("周三：语文，英语");
        System.out.println("周四：英语，数学");
        System.out.println("周五：音乐，体育");
    }
    public void test(){
        System.out.println(this.stuMajor + "专业中，学号是:" + this.stuId + "的"+ super.age+ "岁" + super.name + "同学参加了考试");
    }
}

```

测试类：

```java
package com.kk.extends_demo;

/**
 * @ClassName
 * @Description //TODO
 * @Author kk
 * @Date 2022/9/6 23:02
 * @Version 1.0
 **/

public class Test {
    public static void main(String[] args) {
        Student s = new Student("201912775","计算机工程");
        Teacher t = new Teacher("高级教师");

        s.setName("王小五");
        s.setAge(21);

        t.setName("张劫");
        t.setAge(33);

        s.queryScheduler();
        s.test();

        t.queryScheduler();
        t.preparing();
    }
}

```

返回结果

```
周一：语文，数学
周二：英语，数学
周三：语文，英语
周四：英语，数学
周五：音乐，体育
计算机工程专业中，学号是:201912775的21岁王小五同学参加了考试
周一：语文，数学
周二：英语，数学
周三：语文，英语
......
33的高级教师:张劫在备课
```

