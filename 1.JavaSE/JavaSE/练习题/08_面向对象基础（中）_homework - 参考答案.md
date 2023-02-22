# 巩固题

## 1、普通员工类

（1）声明员工类Employee，

- 包含属性：姓名、性别、年龄、工资、电话、邮箱，属性私有化

- 提供get/set方法

- 提供String getInfo()方法


（2）在测试类的main中创建员工数组，并从键盘输入员工对象信息，最后遍历输出

```java
package com.atguigu.homework1;

public class Employee {
    private String name;// : 姓名
    private char gender;// : 性别
    private int age;// : 年龄
    private double salary;// : 工资
    private String phone;// : 电话号码
    private String email;// : 电子邮箱

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

    public String getInfo() {
        return name + "\t" + gender + "\t\t" + age + "\t\t" + salary + "\t\t" + phone + "\t\t" + email;
    }
}

```

```java
package com.atguigu.homework1;

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
            Employee employee = new Employee();
            employee.setName(name);
            employee.setGender(gender);
            employee.setAge(age);
            employee.setSalary(salary);
            employee.setPhone(phone);
            employee.setEmail(email);

            arr[i] = employee;
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
        arr[0] = new Man();
        arr[0].setName("张三");
        arr[0].setAge(23);
        arr[0].setJob("Java中级工程师");

        arr[1] = new Man();
        arr[1].setName("李四");
        arr[1].setAge(24);
        arr[1].setJob("大数据工程师");

        arr[2] = new Woman();
        arr[2].setName("翠花");
        arr[2].setAge(22);
        arr[2].setJob("UI设计师");

        arr[3] = new Woman();
        arr[3].setName("如花");
        arr[3].setAge(23);
        arr[3].setJob("前端设计师");

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
- 提供get/set方法
- 提供String say()方法：返回员工基本信息
- 提供String getInfo()方法：返回员工基本信息

（2）程序员Programmer类，继承普通员工类

- 重写String getInfo()方法，增加职位“程序员”信息

（3）设计师Designer类，继承程序员类

- 增加奖金属性
- 重写String getInfo()方法，增加职位“设计师”和奖金信息

（4）架构师Architect类，继承设计师类

- 增加股票属性
- 重写String getInfo()方法，增加职位“架构师”和奖金、股票信息

（5）在测试类中创建员工数组，并存储1个普通员工对象，2个程序员对象，1个架构师对象，1个设计师对象

```java
package com.atguigu.homework3;

public class Employee {

    private int id;
    private String name;// : 姓名
    private int age;// : 年龄
    private double salary;// : 工资

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
package com.atguigu.homework3;

public class Programmer extends Employee {
    @Override
    public String getInfo() {
        return super.say() + "\t\t程序员";
    }
}
```

```java
package com.atguigu.homework3;

public class Designer extends Programmer {

    private double bonus;// : 奖金

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
package com.atguigu.homework3;

public class Architect extends Designer {

    private int stock;// : 股票

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
package com.atguigu.homework3;

public class TestEmployees {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("段誉");
        employee.setAge(22);
        employee.setSalary(3000);

        Architect architect = new Architect();
        architect.setName("令狐冲");
        architect.setAge(32);
        architect.setSalary(18000);
        architect.setBonus(15000);
        architect.setStock(2000);

        Programmer programmer1 = new Programmer();
        programmer1.setName("任我行");
        programmer1.setAge(23);
        programmer1.setSalary(7000);

        Programmer programmer2 = new Programmer();
        programmer2.setName("张三丰");
        programmer2.setAge(24);
        programmer2.setSalary(7300);
        
        Designer designer = new Designer();
        designer.setName("周芷若");
        designer.setAge(28);
        designer.setSalary(10000);
        designer.setBonus(5000);

        Employee[] arr = new Employee[5];
        arr[0] = employee;
        arr[1] = architect;
        arr[2] = programmer1;
        arr[3] = programmer2;
        arr[4] = designer;

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



