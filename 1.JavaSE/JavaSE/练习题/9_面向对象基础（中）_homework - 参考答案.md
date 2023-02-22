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
package comg.atguigu.homework1;

public class Employee {
    private String name;// : 姓名
    private char gender;// : 性别
    private int age;// : 年龄
    private double salary;// : 工资
    private String phone;// : 电话号码
    private String email;// : 电子邮箱

    public Employee() {
    }
    
    public Employee(String name, char gender, int age, double salary, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString()() {
        return name + "\t" + gender + "\t\t" + age + "\t\t" + salary + "\t\t" + phone + "\t\t" + email;
    }
}

```

```java
package comg.atguigu.homework1;

import java.util.Scanner;

public class TestEmployee {
    public static void main(String[] args) {
        Employee[] arr = new Employee[3];
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            System.out.println("-------------添加第"+(i+1)+"个员工-----------------");
            System.out.print("姓名：");
            String name = input.next();
            System.out.print("性别：");
            char gender = input.next().charAt(0);
            System.out.print("年龄：");
            int age = input.nextInt();
            System.out.print("工资：");
            double salary = input.nextDouble();
            System.out.print("电话：");
            String phone = input.next();
            System.out.print("邮箱：");
            String email = input.next();

            // 创建Employee对象
            arr[i] = new Employee(name,gender,age,salary,phone,email);
        }
        System.out.println("-------------添加完成-----------------");
        System.out.println("-------------员工列表-----------------");
        System.out.println("编号\t姓名\t性别\t年龄\t工资\t\t电话\t\t邮箱");
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i+1) + "\t\t" + arr[i].getInfo());
        }

        System.out.println("-------------员工列表完成-----------------");
        input.close();
    }
}

```



## 2、男人女人类

（1）在Person类中，包含

- 属性：姓名，年龄，职业
- ==提供有参构造：public Person(String name, int age, String job)== 
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
package comg.atguigu.homework2;

public class Person {
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void eat() {
        System.out.println(name + "吃饭");
    }

    public void toilet() {
        System.out.println(name + "上洗手间");
    }

    public String getInfo() {
        return "姓名：" + name + "，年龄：" + age + "，职业：" + job;
    }
}

```

```java
package comg.atguigu.homework2;

public class Man extends Person {
    public Man(String name, int age, String job) {
        super(name, age, job);
    }

    @Override
    public void eat() {
        System.out.println(getName() + "狼吞虎咽的吃饭");
    }
    public void smoke(){
        System.out.println(getName() + "抽烟");
    }
}

```

```java
package comg.atguigu.homework2;

public class Woman extends Person{
    public Woman(String name, int age, String job) {
        super(name, age, job);
    }

    @Override
    public void eat() {
        System.out.println(getName()  + "细嚼慢咽的吃饭");
    }
    public void makeup(){
        System.out.println(getName() + "化妆");
    }
}

```

```java
package comg.atguigu.homework2;

public class TestPerson {
    public static void main(String[] args) {
        Person[] arr = new Person[4];
        arr[0] = new Man("张三",23,"Java中级工程师");
        arr[1] = new Man("李四",24,"大数据工程师");
        arr[2] = new Woman("翠花",22,"UI设计师");
        arr[3] = new Woman("如花",23,"前端设计师");

        System.out.println("------------初次见面--------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].getInfo());
        }

        System.out.println("-------------开始聚餐--------------");
        for (int i = 0; i < arr.length; i++) {
            arr[i].eat();
        }

        System.out.println("---------------饭后休息-------------");
        for (int i = 0; i < arr.length; i++) {
            arr[i].toilet();
            if(arr[i] instanceof Man){
                Man man = (Man) arr[i];
                man.smoke();
            }else if(arr[i] instanceof Woman){
                Woman woman = (Woman) arr[i];
                woman.makeup();
            }
        }
    }
}

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

- ==提供无参构造==
- ==提供有参构造Programmer(int id, String name, int age, double salary)== 
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
package comg.atguigu.homework3;

public class Employee {
    private int id;
    private String name;// : 姓名
    private int age;// : 年龄
    private double salary;// : 工资

    public Employee() {
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String say(){
        return id + "\t\t" + name + "\t" + age + "\t\t" + salary;
    }

    public String getInfo() {
        return say();
    }
}

```

```java
package comg.atguigu.homework3;

public class Programmer extends Employee {
    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary) {
        super(id, name, age, salary);
    }

    @Override
    public String getInfo() {
        return super.say() + "\t\t程序员";
    }
}

```

```java
package comg.atguigu.homework3;

public class Designer extends Programmer {
    private double bonus;// : 奖金

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, double bonus) {
        super(id, name, age, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String getInfo() {
        return super.say() + "\t\t设计师" + "\t" + bonus;
    }
}

```

```java
package comg.atguigu.homework3;

public class Architect extends Designer {
    private int stock;// : 股票

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, double bonus, int stock) {
        super(id, name, age, salary, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String getInfo() {
        return super.say() + "\t\t架构师" + "\t" + getBonus() + "\t" + stock;
    }
}
```

```java
package comg.atguigu.homework3;

public class TestEmployees {
    public static void main(String[] args) {
        Employee[] arr = new Employee[5];
        arr[0] = new Employee(1,"段誉",22,3000);
        arr[1] = new Architect(2,"令狐冲",32,18000,15000,2000);
        arr[2] = new Programmer(3,"任我行",23,7000);
        arr[3] = new Programmer(4,"张三丰",24,7300);
        arr[4] = new Designer(5,"周芷若",28,10000,5000);

        System.out.println("----------------员工信息管理-------------------");
        System.out.println("编号\t姓名\t年龄\t工资\t\t职位\t奖金\t股票");
        for (int i = 0; i < arr.length; i++) {
            arr[i].setId(i+1);
            System.out.println(arr[i].getInfo());
        }
        System.out.println("----------------------------------------------");
    }
}
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


