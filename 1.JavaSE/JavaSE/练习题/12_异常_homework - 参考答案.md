# 巩固题

## 第1题：阅读代码，分析运行结果

```java
public class Test01 {
	public static void main(String[] args) {
		try{
			return;
		}finally{
			System.out.println("finally");
		}
	}
}
```

## 第2题：阅读代码，分析运行结果

```java
public class Test02 {
	{
		System.out.println("a");
	}
	static{
		System.out.println("b");
	}
	Test03(){
		System.out.println("c");
	}
	public static String getOut(){
		try{
			return "1";
		}catch(Exception e){
			return "2";
		}finally{
			return "3";
		}
	}
	public static void main(String[] args) {
		System.out.println(getOut());
	}
}
```

## 第3题：阅读代码，分析运行结果

```java
import java.io.IOException;

public class Test03 {
	public static void main(String[] args) {
		int a = -1;
		try{
			if(a>0){
				throw new RuntimeException("");
			}else if(a<0){
				throw new IOException("");
			}else{
				return ;
			}
		}catch(IOException ioe){
			System.out.println("IOException");
		}catch(Throwable e){
			System.out.println("Throwable");
		}finally{
			System.out.println("finally");
		}
	}
}
```

## 第4题：阅读代码，分析运行结果

```java
public class Test04 {
	public static int fun(){
		int result = 5;
		try{
			result = result / 0;
			return result;
		}catch(Exception e){
			System.out.println("Exception");
			result = -1;
			return result;
		}finally{
			result = 10;
			System.out.println("I am in finally.");
		}
	}
	public static void main(String[] args) {
		int x = fun();
		System.out.println(x);
	}
}

```

## 第5题：阅读代码，分析运行结果

```java
	public static int aMethod(int i)throws Exception{
		try{
			return i / 10;
		}catch(Exception ex){
			throw new Exception("exception in aMethod");
		}finally{
			System.out.println("finally");
		}
	}
	public static void main(String[] args) {
		try {
			aMethod(0);
		} catch (Exception e) {
			System.out.println("exception in main");
		}
	}
```

## 第6题：银行账户类

1、声明银行账户类Account

（1）包含账号、余额属性，要求属性私有化，提供无参和有参构造，get/set方法（其中balance没有set方法）

（2）包含public void withdraw(double money)取款方法，当取款金额为负数时，抛出Exception，异常信息为“越取你余额越多，想得美”，当取款金额超过余额时，抛出Exception，异常信息为“取款金额不足，不支持当前取款操作”

（3）包含public void save(double money)存款方法，当取款金额为负数时，抛出Exception，异常信息为“越存余额越少，你愿意吗？”

2、编写测试类，创建账号对象，并调用取款和存款方法，并传入非法参数，测试发生对应的异常。

```java
package com.atguigu.homework8;

public class Account {
    private String id;
    private double balance;

    public Account() {
    }

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double money) throws Exception {
        if(money<0){
            throw new Exception("越取你余额越多，想得美");
        }
        if(money>balance){
            throw new Exception("取款金额不足，不支持当前取款操作");
        }
        balance -= money;
    }
    public void save(double money) throws Exception {
        if(money<0){
            throw new Exception("越存余额越少，你愿意吗？");
        }
        balance += money;
    }
}

```

```java
package com.atguigu.homework8;

public class TestAccount {
    public static void main(String[] args) {
        Account a = new Account("111111",5000);

        try {
            a.withdraw(-5000);
        } catch (Exception e) {
//            e.printStackTrace();
            System.err.println("取款失败," + e.getMessage());
        }finally {
            System.out.println("尝试取款-5000后，" + a.getBalance() );
        }


        try{
            a.withdraw(1000);
        }catch (Exception e) {
//            e.printStackTrace();
            System.err.println("取款失败," + e.getMessage());
        }finally {
            System.out.println("尝试取款1000后，" + a.getBalance() );
        }

        try{
            a.withdraw(5000);
        }catch (Exception e) {
//            e.printStackTrace();
            System.err.println("取款失败," + e.getMessage());
        }finally {
            System.out.println("尝试取款5000后，" + a.getBalance() );
        }

        try{
            a.save(-5000);
        }catch (Exception e) {
//            e.printStackTrace();
            System.err.println("存款失败," + e.getMessage());
        }finally {
            System.out.println("尝试存款-5000后，" + a.getBalance() );
        }
        try{
            a.save(5000);
        }catch (Exception e) {
//            e.printStackTrace();
            System.err.println("存款失败," + e.getMessage());
        }finally {

            System.out.println("尝试存款5000后，" + a.getBalance() );
        }

    }
}
```



## 第7题：游戏角色

在一款角色扮演游戏中，每一个人都会有名字和生命值，角色的生命值不能为负数。

要求：当一个人物的生命值为负数的时候需要抛出自定义的异常

操作步骤描述：

（1）自定义异常类NoLifeValueException继承RuntimeException

（2）定义Person类

①属性：名称(name)和生命值(lifeValue)

②提供空参构造

③提供有参构造：使用setXxx方法给name和lifeValue赋值

④提供setter和getter方法：

​	在setLifeValue(int lifeValue)方法中，首先判断，如果 lifeValue为负数,就抛出NoLifeValueException，异常信息为：生命值不能为负数；

​	然后在给成员lifeValue赋值。

⑤重写toString方法

（3）定义测试类

①使用有参构造方法创建Person对象，生命值传入一个负数

②使用空参构造创建Person对象

调用setLifeValue(int lifeValue)方法,传入一个正数,运行程序

调用setLifeValue(int lifeValue)方法,传入一个负数,运行程序

③分别对①和②处理异常和不处理异常进行运行看效果

```java
package com.atguigu.homework9;

public class NoLifeValueException extends RuntimeException {
    public NoLifeValueException() {
    }

    public NoLifeValueException(String message) {
        super(message);
    }
}
```

```java
package com.atguigu.homework9;

public class Person {
    private String name;
    private int lifeValue;

    public Person() {
    }

    public Person(String name, int lifeValue) {
        this.name = name;
        setLifeValue(lifeValue);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifeValue() {
        return lifeValue;
    }

    public void setLifeValue(int lifeValue) {
        if(lifeValue<0){
            throw new NoLifeValueException("生命值不能为负数");
        }
        this.lifeValue = lifeValue;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lifeValue=" + lifeValue +
                '}';
    }
}

```

```java
package com.atguigu.homework9;

public class TestPerson {
    public static void main(String[] args) {
        try {
            Person p1 = new Person("张三",-5);
            System.out.println(p1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Person p2 = new Person();
        p2.setName("李四");
        try {
            p2.setLifeValue(-5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            p2.setLifeValue(50);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(p2);
    }
}

```


