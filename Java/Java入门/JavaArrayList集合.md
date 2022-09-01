# ArrayList集合

## 概念

**集合是与数组类似，也是一种容器，用于装数据的。**

ArrayList是集合中的一种，它支持索引。

## 数组特点

- 数组定义完成并启动后，**类型确定、长度固定**。 

- 问题：在个数不能确定，且要进行增删数据操作的时候，数组是不太合适的。

## 集合特点

- 集合的大小不固定，启动后可以动态变化，类型也可以选择不固定。

- 集合非常适合做元素个数不确定，且要进行增删操作的业务场景。

- 集合还提供了许多丰富、好用的功能，而数组的功能很单一。

## **ArrayList集合的对象获取**

| 构造器             | 说明                 |
| ------------------ | -------------------- |
| public ArrayList() | 创建一个空的集合对象 |

## **ArrayList集合添加元素的方法**

| 构造器                               | 说明                               |
| ------------------------------------ | ---------------------------------- |
| public boolean add(E e)              | 将指定的元素追加到此集合的末尾     |
| public void add(int index,E element) | 在此集合中的指定位置插入指定的元素 |

## 泛型概述

- ArrayList<E>：其实就是一个泛型类，可以在编译阶段约束集合对象只能操作某种数据类型。

### 举例

- ArrayList<String> ：此集合只能操作字符串类型的元素。 

- ArrayList<Integer>：此集合只能操作整数类型的元素。

**注意：集合中只能存储引用类型，不支持基本数据类型。**

### 如何统一ArrayList集合操作的元素类型？

-  **使用泛型：<数据类型>** 

-  **ArrayList<String> list1 = new ArrayList();**

## **ArrayList集合常用方法**

| 方法名称                          | 说明                                   |
| --------------------------------- | -------------------------------------- |
| public E get(int index)           | 返回指定索引处的元素                   |
| public int size()                 | 返回集合中的元素的个数                 |
| public E remove(int index)        | 删除指定索引处的元素，返回被删除的元素 |
| public boolean remove(Object o)   | 删除指定的元素，返回删除是否成功       |
| public E set(int index,E element) | 修改指定索引处的元素，返回被修改的元素 |

# ArrayList集合案例练习

## 案例1 遍历并删除元素值

### 需求

- 某个班级的考试在系统上进行，成绩大致为：98, 77, 66, 89, 79, 50, 100

- 现在需要先把成绩低于80分以下的数据去掉。

### **分析：**

1. 定义ArrayList集合存储多名学员的成绩。

2. 遍历集合每个元素，如果元素值低于80分，去掉它。

### 代码实现

```java
package com.kk.apidemo01;

import java.util.ArrayList;

/**
 * @ClassName Test
 * @Description //TODO
 * @Author kk
 * @Date 2022/9/1 14:37
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        
        ArrayList<Integer> score = new ArrayList<>();
        score.add(98);
        score.add(77);
        score.add(66);
        score.add(89);
        score.add(79);
        score.add(50);
        score.add(100);

        System.out.println(score);
        for (int i = 0; i < score.size(); i++) {
            if(score.get(i) < 80){
                score.remove(i);
                i--;
            }
        }
        System.out.println("----------删减后----------");
        System.out.println(score);

    }
}

```

返回结果

```j
[98, 77, 66, 89, 79, 50, 100]
----------删减后----------
[98, 89, 100]
```

## 案例2 存储自定义类型的对象-影片信息在程序中的表示

### 需求

- 某影院系统需要在后台存储上述三部电影，然后依次展示出来。

### **分析：**

1. 定义一个电影类，定义一个集合存储电影对象。
2. 创建3个电影对象，封装相关数据，把3个对象存入到集合中去。
3. 遍历集合中的3个对象，输出相关信息。

### 代码实现

电影类

```java
package com.kk.apidemo02;

import java.util.ArrayList;

/**
 * @ClassName Movie
 * @Description //TODO
 * @Author kk
 * @Date 2022/9/1 15:06
 * @Version 1.0
 **/
public class Movie {
    private String name;
    private double score;
    private String actor;

    public Movie(String name, double score, String actor) {
        this.name = name;
        this.score = score;
        this.actor = actor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}

```

测试类

```java
package com.kk.apidemo02;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @ClassName Test
 * @Description //TODO
 * @Author kk
 * @Date 2022/9/1 15:05
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {

        ArrayList <Movie> movies = new ArrayList<>();
        movies.add(new Movie("《阿甘正传》", 9.5 , "汤姆.汉克斯"));
        movies.add(new Movie("《霸王别姬》", 9.6 , "张丰毅"));
        movies.add(new Movie("《阿甘正传》", 9.7 , "罗宾斯"));
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < movies.size(); i++) {
            System.out.println("片名：" +  movies.get(i).getName());
            System.out.println("评分：" +  movies.get(i).getScore());
            System.out.println("主演：" +  movies.get(i).getActor());
            System.out.println("-----------------------------------------------");
        }
    }
}

```

返回结果：

```j
-----------------------------------------------
片名：《阿甘正传》
评分：9.5
主演：汤姆.汉克斯
-----------------------------------------------
片名：《霸王别姬》
评分：9.6
主演：张丰毅
-----------------------------------------------
片名：《阿甘正传》
评分：9.7
主演：罗宾斯
-----------------------------------------------
```



## 案例3 学生信息系统的数据搜索

### 需求

- 后台程序需要存储如下学生信息并展示，然后要提供按照学号搜索学生信息的功能。

  ![](https://cdn.jsdelivr.net/gh/KK-0613/KK-Image/20220901152022.png)

### **分析：**

1. 定义Student类，定义ArrayList集合存储如上学生对象信息，并遍历展示出来。
2. 提供一个方法，可以接收ArrayList集合，和要搜索的学号，返回搜索到的学生对象信息，并展示。
3. 使用死循环，让用户可以不停的搜索。

### 代码实现

学生类

```java
package com.kk.apidemo03;

/**
 * @ClassName Student
 * @Description //TODO
 * @Author kk
 * @Date 2022/9/1 15:21
 * @Version 1.0
 **/
public class Student {
    private String userId;
    private String name;
    private int age;
    private String stuClass;

    public Student() {
    }

    public Student(String userId, String name, int age, String stuClass) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.stuClass = stuClass;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }
}

```

测试类

```java
package com.kk.apidemo03;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * @ClassName Test
 * @Description //TODO
 * @Author kk
 * @Date 2022/9/1 15:24
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("20180302", "叶孤城", 23, "护理1班"));
        students.add(new Student("20180303", "东方不败", 23, "护理1班"));
        students.add(new Student("20180304", "西门吹雪", 26, "中药学4班"));
        students.add(new Student("20180305", "梅超风", 26, "神经科2班"));

        System.out.println("------------------------学生信息------------------------");
        for (int i = 0; i < students.size(); i++) {
            System.out.print("学号：" + students.get(i).getUserId());
            System.out.print("\t姓名：" + students.get(i).getName());
            System.out.print("\t班级：" + students.get(i).getStuClass());
            System.out.println("\t年龄：" + students.get(i).getAge() + "岁");
        }
        System.out.println("------------------------");
        Scanner sc = new Scanner(System.in);
        OUT:
        while (true) {
            System.out.println("请输入要搜索的学号：");
            String stuId = sc.next();
            System.out.println("------------------------");
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getUserId().equals(stuId)) {
                    System.out.println("学号：" + students.get(i).getUserId());
                    System.out.println("姓名：" + students.get(i).getName());
                    System.out.println("班级：" + students.get(i).getStuClass());
                    System.out.println("年龄：" + students.get(i).getAge() + "岁");
                    System.out.println("------------------------");
                    break OUT;
                }
            }
            System.out.println("未找到该同学，请检查输入的学号是否正确，并且重新输入要搜索的学号");
            System.out.println("------------------------");

        }
    }
}

```

返回结果：

```j
------------------------学生信息------------------------
学号：20180302	姓名：叶孤城	班级：护理1班	年龄：23岁
学号：20180303	姓名：东方不败	班级：护理1班	年龄：23岁
学号：20180304	姓名：西门吹雪	班级：中药学4班	年龄：26岁
学号：20180305	姓名：梅超风	班级：神经科2班	年龄：26岁
------------------------
请输入要搜索的学号：
20190302
------------------------
未找到该同学，请检查输入的学号是否正确，并且重新输入要搜索的学号
------------------------
请输入要搜索的学号：
20180302
------------------------
学号：20180302
姓名：叶孤城
班级：护理1班
年龄：23岁
------------------------
```



