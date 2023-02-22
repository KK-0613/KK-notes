# 巩固题

## 1、普通员工类

（1）声明员工类Employee，

- 包含属性：姓名、性别、年龄、工资、电话、邮箱，属性私有化
- 提供get/set方法
- ==提供无参构造==
- ==提供有参构造Employee(String name, char gender, int age, double salary, String phone, String email)==
- 提供String getInfo()方法

（2）在测试类的main中创建员工数组，并从键盘输入员工对象信息，最后遍历输出

```java

```

```java

```

## 2、男人女人类

（1）在Person类中，包含

- 属性：姓名，年龄，职业
- ==提供有参构造 public Person(String name, int age, String job)== 
- public void eat()：打印xx吃饭，xx代表姓名
- public void toilet()：打印xx上洗手间
- public String getInfo()：返回姓名、年龄、职业信息。

（2）在Man类中，包含

- 重写eat()：xx狼吞虎咽吃饭
- 增加  public void smoke()：打印xx抽烟

（3）在Woman类中，包含

- 重写eat()：xx细嚼慢咽吃饭
- 增加 public void makeup()：打印xx化妆

（4）周末一群男男女女相亲，在测试类创建不同对象放在Person[]数组中，

- 遍历数组，自我介绍，
- 再次遍历数组，调用吃饭方法
- 吃完饭，最后遍历数组，都去上厕所，男的上完厕所抽烟，女的上完厕所补妆。

```java

```

```java

```

```java

```

```java

```



## 3、普通员工、程序员、设计师、架构师

（1）普通员工Employee类

- 包含编号、姓名、年龄、工资，属性私有化
- ==提供无参构造==
- ==提供有参构造Employee(int id, String name, int age, double salary)==
- 提供get/set方法
- 提供String say()方法：返回员工基本信息
- 提供String getInfo()方法：返回员工基本信息

（2）程序员Programmer类，继承普通员工类

- 提供无参构造
- 提供有参构造Programmer(int id, String name, int age, double salary) 
- 重写String getInfo()方法，增加职位“程序员”信息

（3）设计师Designer类，继承程序员类

- 增加奖金属性
- ==提供无参构造==
- ==提供有参构造Designer(int id, String name, int age, double salary, double bonus)==
- 重写String getInfo()方法，增加职位“设计师”和奖金信息

（4）架构师Architect类，继承设计师类

- 增加股票属性
- ==提供无参构造==
- ==提供有参构造Architect(int id, String name, int age, double salary, double bonus, int stock)==
- 重写String getInfo()方法，增加职位“架构师”和奖金、股票信息

（5）在测试类中创建员工数组，并存储1个普通员工对象，2个程序员对象，1个架构师对象，1个设计师对象

```java

```

```java

```

```java

```

```java

```

```java

```



## 4、阅读如下代码

```java
class HelloA{
	public HelloA(){
		System.out.println("HelloA");
	}
	{
		System.out.println("I'm A Class");
	}
}

class HelloB extends HelloA{
	public HelloB(){
		System.out.println("HelloB");
	}
	{
		System.out.println("I'm B Class");
	}
}

public class TestHelloB{
	public static void main(String[] args) {
		new HelloB();
	}
}

```

## 5、阅读如下代码

```java
public class TestFatherChild {
	public static void main(String[] args) {
		Father f = new Father();
		Child c = new Child();
	}
}
class Father {
	public Father(){
		System.out.println("father");
	}
}
class Child extends Father{
	public Child(){
		System.out.println("child");
	}
}
```



