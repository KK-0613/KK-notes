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
package com.atguigu.homework1;

import java.io.Serializable;

public class AtguiguStudent implements Serializable,Comparable<AtguiguStudent>{
    private static final long serialVersionUID = 1L;
    private static String school = "尚硅谷";
    private String className;
    public AtguiguStudent(String className) {
        super();
        this.className = className;
    }
    public AtguiguStudent() {
        super();
    }
    public static String getSchool() {
        return school;
    }
    public static void setSchool(String school) {
        AtguiguStudent.school = school;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    @Override
    public String toString() {
        return "AtguiguDemo [className=" + className + "]";
    }
    @Override
    public int compareTo(AtguiguStudent o) {
        return this.className.compareTo(o.getClassName());
    }

}

```

```java
package com.atguigu.homework1;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Homework1 {
    @Test
    public void test01() throws ClassNotFoundException{
        Class clazz = Class.forName("com.atguigu.homework1.AtguiguStudent");

        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println("类加载器：" + classLoader);

        Package pkg = clazz.getPackage();
        System.out.println("包名：" + pkg.getName());

        int cMod = clazz.getModifiers();
        System.out.println("类的修饰符：" + Modifier.toString(cMod));

        System.out.println("类名：" + clazz.getName());
        System.out.println("父类：" + clazz.getSuperclass().getName());
        Class[] interfaces = clazz.getInterfaces();
        System.out.println("父接口们："+ Arrays.toString(interfaces));

        Field[] declaredFields = clazz.getDeclaredFields();
        for (int i =0 ;i<declaredFields.length; i++) {
            System.out.println("第" + (i+1) + "个字段：");
            int fMod = declaredFields[i].getModifiers();
            System.out.println("修饰符：" + Modifier.toString(fMod));
            System.out.println("数据类型："  + declaredFields[i].getType().getName());
            System.out.println("属性名：" + declaredFields[i].getName());
        }

        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (int i = 0; i < declaredConstructors.length; i++) {
            System.out.println("第" + (i+1) + "个构造器：");
            int csMod = declaredConstructors[i].getModifiers();
            System.out.println("修饰符：" + Modifier.toString(csMod));
            System.out.println("构造器名：" + declaredConstructors[i].getName());
            System.out.println("形参列表：" + Arrays.toString(declaredConstructors[i].getParameterTypes()));
        }

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            System.out.println("第" + (i+1) + "个成员方法：");
            int csMod = declaredMethods[i].getModifiers();
            System.out.println("修饰符：" + Modifier.toString(csMod));
            System.out.println("返回值类型：" + declaredMethods[i].getReturnType().getName());
            System.out.println("方法名：" + declaredMethods[i].getName());
            System.out.println("形参列表：" + Arrays.toString(declaredMethods[i].getParameterTypes()));
        }
    }

    @Test
    public void test02() throws Exception{
        Class clazz = Class.forName("com.atguigu.homework1.AtguiguStudent");
        Field field = clazz.getDeclaredField("school");
        field.setAccessible(true);
        field.set(null, "尚硅谷");
        Object value = field.get(null);
        System.out.println("school = " + value);
    }

    @Test
    public void test03() throws Exception{
        Class clazz = Class.forName("com.atguigu.test01.demo.AtguiguDemo");
        Object object = clazz.newInstance();
        Field field = clazz.getDeclaredField("className");
        field.setAccessible(true);
        Object value = field.get(object);
        System.out.println("className = " + value);

        field.set(object, "190513班");
        value = field.get(object);
        System.out.println("className = " + value);
    }

    @Test
    public void test04() throws Exception{
        Class clazz = Class.forName("com.atguigu.homework1.AtguiguStudent");
        Constructor c = clazz.getDeclaredConstructor(String.class);
        Object obj1 = c.newInstance("20210513BJ班");
        Object obj2 = c.newInstance("20210325SH班");

        Method m = clazz.getDeclaredMethod("compareTo", Object.class);
        System.out.println("obj1与obj2比较结果：" + m.invoke(obj1, obj2));
    }
}

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

```java
package com.atguigu.homework2;

public interface Fruit {
    void squeeze();
}

```

```java
package com.atguigu.homework2;

public class Apple implements Fruit{
    @Override
    public void squeeze() {
        System.out.println("苹果汁");
    }
}

```

```java
package com.atguigu.homework2;

public class Orange implements Fruit {
    @Override
    public void squeeze() {
        System.out.println("橙汁");
    }
}

```

```java
package com.atguigu.homework2;

public class Banana implements Fruit {
    @Override
    public void squeeze() {
        System.out.println("香蕉汁");
    }
}

```

```java
package com.atguigu.homework2;

public class Juicer {
    public void run(Fruit f){
        f.squeeze();
    }
}

```

```java
package com.atguigu.homework2;

import java.util.Properties;

public class Homework2 {
    public static void main(String[] args) throws Exception{
        Properties pro = new Properties();
        pro.load(ClassLoader.getSystemClassLoader().getResourceAsStream("fruit.properties"));
        Class<?> clazz = Class.forName(pro.getProperty("fruitName"));
        Fruit f = (Fruit) clazz.newInstance();
        Juicer j = new Juicer();
        j.run(f);
    }
}
```

fruit.properties配置文件：

```java
fruitName=com.atguigu.homework2.Apple
```

![image-20220201230629370](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/image-20220201230629370.png)

