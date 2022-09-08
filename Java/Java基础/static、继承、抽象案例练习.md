#                                 day01面向对象

# 简答题:

### 1.面向对象和面向过程的区别?

```
   面向过程就是分析出解决问题所需要的步骤，然后用函数把这些步骤一步一步实现，使用的时候一个一个依次调用就可以了。

   面向对象是把构成问题事务分解成各个对象，建立对象的目的不是为了完成一个步骤，而是为了描叙某个事物在整个解决问题的步骤中的行为。
```

### 2.继承的特点?

```
a.只支持单继承
b.不能多继承
c.支持单层继承
```



# 编程题:

## 题目一

```
每一款手机都有自己的品牌和价格,原来的手机只能打电话,发短信;现在的新手机,在打电话和发短信的基础上还能玩儿游戏,请设计程序,完成手机的升级!
```

### 训练目标

```
继承
```

### 训练提示

```
新手机在老手机基本的功能上添加新功能,新功能就是新手机特有的内容
```

### 参考方案

```
1.定义新手机类 extends 老手机类
2.在新手机中定义特有的方法
```

### 操作步骤

```
1.定一个OldPhone类,定义两个私有属性brand和price,定义空参和有参构造方法,get/set方法
2.在OldPhone类中,定义一个打电话的方法,传递姓名的参数,方法体内输出给谁打电话
3.在OldPhone类中,定义一个发短信的方法,直接输出"发短信"
4.定一个子类NewPhone,继承OldPhone类,在子类中定义玩游戏的特有方法,直接输出内容"玩游戏"
5.定义测试类,创建NewPhone类对象,调用set方法为属性赋值,调用get方法获取属性值
6.调用从父类中继承过来的方法以及自己特有的方法.
```

### 参考答案

```java
//父类-->OldPhone
public class OldPhone {
    private String brank;
    private double price;

    public OldPhone() {
    }

    public OldPhone(String brank, double price) {
        this.brank = brank;
        this.price = price;
    }

    public String getBrank() {
        return brank;
    }

    public void setBrank(String brank) {
        this.brank = brank;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //打电话
    public void call(String name){
        System.out.println("给"+name+"打电话!");
    }

    //发短信
    public void message(){
        System.out.println("发短信!");
    }
}

```

```java
//子类->NewPhone
public class NewPhone extends OldPhone{
    //特有内容
    public void playGame(){
        System.out.println("玩儿游戏");
    }
}
```

```java
//测试类
public class Test {
    public static void main(String[] args) {
        //创建NewPhone类对象
        NewPhone newPhone = new NewPhone();
        //调用set方法为属性赋值
        newPhone.setBrank("苹果");
        newPhone.setPrice(6399);
        //调用get方法获取属性值
        System.out.println("新手机的品牌为:"+newPhone.getBrank()+",新手机的价格为:"+newPhone.getPrice());
        //调用从父类中继承过来的方法
        newPhone.call("小勇");
        newPhone.message();
        //调用自己的特有方法
        newPhone.playGame();
    }
}
```

## 题目二

```
每一款手机都有自己的品牌和价格,原来的手机只能打电话,发短信,来电显示只能显示手机号;现在的新手机针对于来电显示做了功能的升级,还能显示头像,还能显示归属地,请设计程序,完成手机的升级!
```

### 训练目标

```
继承,重写
```

### 训练提示

```
新手机在老手机的基本功能基础上,针对老手机的某个功能进行重新实现
```

### 参考方案

```
定义一个老手机类,包含品牌和价格两个属性,对应的构造,get/set方法,还有打电话,和发短信的方法,来电显示的方法
定义一个新手机,继承老手机类,重写来电显示方法进行升级
最后在测试类中为属性赋值,调用继承过来的方法以及来电显示方法
```

### 操作步骤

```
1.定一个OldPhone类,定义两个私有属性brand和price,定义空参和有参构造方法,get/set方法
2.在OldPhone类中,定义一个打电话的方法,传递姓名的参数,方法体内输出给谁打电话
3.在OldPhone类中,定义一个发短信的方法,直接输出"发短信"
4.定义一个来电显示的方法,输出内容为"显示手机号",
4.定一个子类NewPhone,继承OldPhone类,在子类中重写来电显示的方法,输出内容为"显示手机号","显示归属地","显示头像"
5.定义测试类,创建NewPhone类对象,调用set方法为属性赋值,调用get方法获取属性值
6.调用从父类中继承过来的方法以及重写的方法
```

### 参考答案

```java
//父类-->老手机
public class OldPhone {
    private String brand;
    private double price;

    public OldPhone() {
    }

    public OldPhone(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //定义打电话方法
    public void call(String name){
        System.out.println("给"+name+"打电话!");
    }

    //发短信
    public void message(){
        System.out.println("发短信!");
    }

    //来电显示
    public void show(){
        System.out.println("显示手机号!");
    }

}
```

```java
//新手机
public class NewPhone extends OldPhone {
    //来电显示功能升级方法
    public void show() {
        super.show();
        System.out.println("显示归属地!");
        System.out.println("显示头像!");
    }
}
```

```java
//测试类
public class Test {
    public static void main(String[] args) {
        //创建子类对象
        NewPhone newPhone = new NewPhone();
        //调用set方法为属性赋值
        newPhone.setBrand("苹果");
        newPhone.setPrice(9800);
        //调用get方法获取属性值
        System.out.println("手机品牌为:"+newPhone.getBrand()+",价格为:"+newPhone.getPrice());
        //调用继承过来的方法
        newPhone.call("柳岩");
        newPhone.message();
        //调用重写后的方法
        newPhone.show();
    }
}
```



## 题目三

```
 白色4条腿的北极熊(Bear)会吃(吃蜂蜜)和抓鱼(catchFish)
 黑色4条腿的大熊猫(Panda)会吃(吃竹子)和爬树(climbTree)
 要求: 把北极熊和大熊猫的共性提取动物类(Animal)中,使用抽象类
```

### 训练目标

```
继承,抽象,方法的重写
```

### 训练提示

```
1.将两种动物共性抽取出来,形成动物类,然后Bear和Panda继承动物类
2.重写共性方法,并定义特有方法
```

### 参考方案

```
1.定义一个动物类,里面有颜色和腿的条数,两个动物的共性就是吃的方法,所以可以把共性的吃的方法抽取出来,由于这个吃的方法内容无法确定,所以定义成抽象方法
2.定义出来的Bear类和Panda类都要继承动物类,重写吃的方法
3.定义北极熊和大熊猫的特有方法
4.在测试类中创建两个动物的对象,为属性赋值,并调用方法
```

### 操作步骤

```
1.定义一个Animal类,定义两个私有属性(颜色:color,个数:numOfLegs).对应的构造以及get/set方法
2.在Animal中定义一个抽象方法eat()
3.定义子类Bear(北极熊) 继承Animal类,重写父类中的抽象方法eat(),方法体输出 "白色4腿的北极熊在吃蜂蜜"
  定义特有方法catchFish(),方法体输出"白色4腿的北极熊在抓鱼"
4.定义子类Panda(熊猫)继承Animal类,重写父类中的抽象方法eat(),方法体输出 "黑色4条腿的大熊猫在吃竹子"
  定义特有方法climbTree(),方法体输出"黑色4条腿的大熊猫在爬树"
5.定义测试类,创建北极熊对象,为属性赋值,调用重写的方法以及特有方法
  创建大熊猫对象,为属性赋值,调用重写的方法以及特有方法
```

### 参考答案

```java
//动物类
public abstract class Animal {
    //动物颜色
    private String color;
    //动物腿的个数
    private int numOfLegs;

    //提供带参构造和setXxx和getXxx方法
    public Animal() {
        super();
    }
    public Animal(String color, int numOfLegs) {
        super();
        this.color = color;
        this.numOfLegs = numOfLegs;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getNumOfLegs() {
        return numOfLegs;
    }
    public void setNumOfLegs(int numOfLegs) {
        this.numOfLegs = numOfLegs;
    }

    //定义吃东西的抽象方法
    public abstract void eat();

}
```

```java
//北极熊类
public class Bear extends Animal {

    public Bear() {
        super();
    }

    public Bear(String color, int numOfLegs) {
        super(color, numOfLegs);
    }

    public void eat() {
        System.out.println(getColor() + getNumOfLegs() + "腿的北极熊在吃蜂蜜");
    }

    public void catchFish() {
        System.out.println(getColor() + getNumOfLegs() + "腿的北极熊在抓鱼");
    }
}
```

```java
//大熊猫类
public class Panda extends Animal {

    public Panda() {
        super();
    }

    public Panda(String color, int numOfLegs) {
        super(color, numOfLegs);
    }

    public void eat() {
        System.out.println(getColor() + getNumOfLegs() + "条腿的大熊猫在吃竹子");
    }

    public void climbTree() {
        System.out.println(getColor() + getNumOfLegs() + "条腿的大熊猫在爬树");
    }
}
```

```java
//测试类
public class Test {
    public static void main(String[] args) {
        //1. 创建北极熊对象 b,颜色赋值为白色,腿的个数赋值为4
        Bear b = new Bear("白色", 4);
        //2. 调用北极熊对象b的吃方法
        b.eat();
        //3.调用北极熊对象b的抓鱼方法
        b.catchFish();
        //4. 创建大熊猫对象 p,颜色赋值为黑色,腿的个数赋值为4
        Panda p = new Panda("黑色", 4);
        //5. 调用大熊猫对象p的吃方法
        p.eat();
        //6. 调用大熊猫对象p的爬树方法
        p.climbTree();
    }
}
```



## 题目四

```
在传智播客有很多员工(Employee),按照工作内容不同分教研部员工(Teacher)和行政部员工(AdminStaff)
教研部根据教学的方式不同又分为讲师(Lecturer)和助教(Tutor)
行政部根据负责事项不同,有分为维护专员(Maintainer),采购专员(Buyer)
公司的每一个员工都编号,姓名和其负责的工作
工作内容:    
  讲师: 工号为 666 的讲师 乔峰 在讲课
  助教: 工号为 668的助教 段誉 在帮助学生解决问题
  维护专员: 工号为 686 的维护专员 柳岩 在解决不能共享屏幕问题
  采购专员: 工号为 888 的采购专员 景甜 在采购音响设备
 
提示:赋值可以用set方法或者构造方法

```

### 训练目标

```
继承,抽象
```

### 训练提示

![1568715106034](img/1568715106034.png)

### 参考方案

```
1.抽取共有的id name work()方法,形成员工类父类
2.教研部类和行政部类继承员工类
3.定义讲师类和助教类继承教研部类,重写work方法
4.定义维护类和采购类,继承行政类,重写work方法
```

### 操作步骤

```
1.定义员工类Employee,定义两个私有属性id,name,提供对应的构造,get/set方法,并提供抽象方法work
2.定义Teacher类继承Employee类
3.定义AdminStaff类继承Employee类
4.定义Lecturer(讲师)类继承Teacher类,重写work方法,输出"工号为 666 的讲师 乔峰 在讲课"
5.定义Tutor(助教)类继承Teacher类,重写work方法,输出"工号为 668的助教 段誉 在帮助学生解决问题"
6.定义Maintainner(维护)类继承AdminStaff类,重写work方法,输出"工号为 686 的维护专员 柳岩 在解决不能共享屏幕问题"
7.定义Buyer(采购)类继承AdminStaff类,重写work方法,输出"工号为 888 的采购专员 景甜 在采购音响设备"
8.定义测试类,分别创建讲师类,助教类,维护类,采购类对象分别为属性赋值,并调用重写的work方法
```

### 参考答案

```java
//员工类
public abstract class Employee {
    private String id;
    private String name;
    public abstract void work();

    public Employee() {
        super();
    }
    public Employee(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
```

```java
//教研部类
public abstract class Teacher extends Employee{
    public Teacher() {
    }

    public Teacher(String id, String name) {
        super(id, name);
    }
}
```

```java
//行政部类
public abstract class AdminStaff extends Employee{
    public AdminStaff() {
    }

    public AdminStaff(String id, String name) {
        super(id, name);
    }
}
```

```java
//讲师类
public class Lecturer extends Teacher{
    //提供无参和带参的构造方法
    public Lecturer() {
        super();
    }
    public Lecturer(String id, String name) {
        super(id, name);
    }

    //实现抽象方法: void work();
    //输出格式: 工号为 666 的讲师 乔峰 在讲课
    public void work() {
        System.out.println("工号为 "+getId()+" 的讲师 "+getName()+" 在讲课");
    }
}
```

```java
//助教类
public class Tutor extends Teacher{
    //提供无参和带参的构造方法
    public Tutor() {
        super();
    }

    public Tutor(String id, String name) {
        super(id, name);
    }
    //实现抽象方法: void work();
    //输出格式: 工号为 668的助教 段誉 在帮助学生解决问题
    public void work() {
        System.out.println("工号为 "+getId()+"的助教 "+getName()+" 在帮助学生解决问题");
    }
}
```

```java
//维护人员类
public class Maintainer extends AdminStaff{
    //提供无参和带参的构造方法
    public Maintainer() {
        super();
    }

    public Maintainer(String id, String name) {
        super(id, name);
    }
    //实现抽象方法: void work();
    //输出格式: 工号为 686 的维护专员 柳岩 在解决不能共享屏幕问题
    public void work() {
        System.out.println("工号为 "+getId()+" 的维护专员 "+getName()+" 在解决不能共享屏幕问题");
    }

}
```

```java
//采购人员类
public class Buyer extends AdminStaff{
    //提供无参和带参的构造方法
    public Buyer() {
        super();
    }

    public Buyer(String id, String name) {
        super(id, name);
    }
    //实现抽象方法: void work();
   //输出格式:  工号为 888 的采购专员 景甜 在采购音响设备
    public void work() {
        System.out.println("工号为 "+getId()+" 的采购专员 "+getName()+" 在采购音响设备");
    }
}
```

```java
//测试类
public class Test {
    public static void main(String[] args) {
//		a)创建讲师对象 l, 把工号赋值为666,姓名赋值为”傅红雪”
        Lecturer l = new Lecturer("666", "乔峰");
//		b)调用讲师对象l的工作方法
        l.work();
//		c)创建助教对象 t, 把工号赋值为668,姓名赋值为”顾棋”
        Tutor t = new Tutor("668", "段誉");
//		d)调用助教对象t的工作方法
        t.work();
//		e)创建维护专员对象 m, 把工号赋值为686,姓名赋值为”庖丁”
        Maintainer m = new Maintainer("686", "柳岩");
//		f)调用维护专员对象m的工作方法
        m.work();
//		g)创建采购专员对象 b, 把工号赋值为888,姓名赋值为”景甜”
        Buyer b = new Buyer("888", "景甜");
//		h)调用采购专员对象b的工作方法
        b.work();
    }
}
```

