# 巩固题

## 第1题

案例要求：

在子线程中输出1-100之间的偶数，主线程输出1-100之间的奇数。要求子程序，使用匿名内部类实现Runnable接口的方式创建和启动线程。

案例运行效果如下：

![1559644802018](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1559644802018.png)

开发提示：

（1）在main方法中，使用匿名内部类的方式实现Runnable接口

```java
new Runnable(){
    @Override
    public void run() {
        ....//使用for循环输出1-100的偶数
    }
}
```

（2）在main方法中，创建Thread类的对象，并把上面匿名内部类的对象创给Thread类的构造器，并调用start()方法启动线程

```java
Thread(Runnable target)   
    或
Thread(Runnable target, String name)
```

（3）在main方法中使用for循环输出1-100之间的奇数



```java

```

## 第2题

案例要求：

创建和启动2个子线程，一个打印奇数，一个打印偶数，

（1）要求实现交替打印。

（2）每对数打印间隔1秒

案例运行效果如下：

![1559643724642](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1559643724642.png)

开发提示：

（1）编写一个资源类，例如：Number类，

- 包含1个int类型的num，用来记录线程要打印的数字，初始值为1。
- 包含1个boolean类型的odd，用来标记是奇数线程打印还是偶数线程打印，true表示奇数线程打印，false表示偶数线程打印。初始化为true。
- 包含void printOddNum()方法，判断odd为true，就打印num，之后修改odd为false，然后唤醒偶数线程，之后自己wait。
- 包含void printEvenNum()方法，判断odd为false，就打印num，之后修改odd为true，然后唤醒奇数线程，之后自己wait。

（2）在测试类中

- 创建Number类对象
- 创建一个奇数线程，并启动，重写run方法，循环调用Number类对象的printOddNum()方法。
- 创建一个偶数线程，并启动，重写run方法，循环调用Number类对象的printEvenNum()方法。

```java

```

```java

```



## 第3题

（1）创建一个银行账户类Account，

- 属性私有化：账号（声明为final的），余额，
- 两个属性都只提供get方法
- 有参构造public Account(String id, double balance)
- toString()：返回：账户：xxx，余额：xxx
- 提供存钱方法 public void save(double money)，
- 提供取钱方法public void withdraw(double money)，余额不足要等待

（2）创建一个丈夫线程类Husband，

- 包含Account成员变量，
- 包含public Husband(String name, Account account)构造器
- 重写run方法，调用Account对象的save方法，负责往里存钱，每次存款[100,10000)以内不等金额

（3）创建一个妻子线程类Wife

- 包含Account成员变量，

- 包含public Wife(String name, Account account)构造器

- 重写run方法，调用Account对象的withdraw方法，负责取钱，每次取款[1000,20000)以内不等，如果余额不足，要等丈夫存够了才能取。

  ![](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/image-20220122183145423.png)

```java

```

```java

```

```java

```

```java

```

