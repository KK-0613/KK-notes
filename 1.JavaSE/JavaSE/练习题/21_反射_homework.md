# 巩固题

## 第1题：尚硅谷学生类

（1）声明一个尚硅谷学生类AtguiguStudent，

- 包含静态变量：学校school

- 包含属性：班级名称className

- 并提供构造器，get/set等

- 实现Serializable
- 实现Comparable<T>接口，重写int compareTo(T t)方法按照班级名称排序

（2）在测试类的test01()测试方法中，用反射获取AtguiguStudent类的Class对象，并获取它的所有信息，包括类加载器、包名、类名、父类、父接口、属性、构造器、方法们等。

（3）在测试类的test02()测试方法中，用反射设置school的值为“尚硅谷”，获取school的值

（4）在测试类的test03()测试方法中，用反射创建AtguiguStudent类的对象，并设置班级名称className属性的值，并获取它的值

（5）在测试类的test04()测试方法中，用反射获取有参构造创建2个AtguiguStudent类的对象，并获取compareTo方法，调用compareTo方法，比较大小。

```java

```

```java

```



## 第2题：水果榨汁机

（1）声明(Fruit)水果接口，包含榨汁抽象方法：void squeeze();

（2）声明各种水果实现类，实现(Fruit)水果接口，并重写squeeze();

实现类有苹果(Apple)香蕉(Banana)桔子(Orange)

（3）声明榨汁机(Juicer)，包含运行方法：public void run(Fruit f)，方法体中，调用f的榨汁方法squeeze()

（4）在src下，建立配置文件：fruit.properties，并在配置文件中配上fruitName=xxx（其中xx为某种水果的全类名）

```java
fruitName=某种水果的全类名
//例如：fruitName=com.atguigu.homework2.Apple
```

（5）在测试类中，

- 读取配置文件，获取水果类名，并用反射创建水果对象，
- 创建榨汁机对象，并调用run()方法

fruit.properties配置文件：

```java
fruitName=com.atguigu.homework2.Apple
```

![image-20220201230629370](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/image-20220201230629370.png)


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

```java

```



