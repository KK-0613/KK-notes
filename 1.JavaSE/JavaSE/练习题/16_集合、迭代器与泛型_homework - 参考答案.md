# 巩固题

### 第1题：随机验证码

* 随机验证码。

  * 随机生成十组六位字符组成的验证码。
  * 验证码由大小写字母、数字字符组成。

* 代码实现，效果如图所示：

  ![1559813820285](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1559813820285.png)

  

* 开发提示：

  * 把26个大小写字母，数字0-9保存到一个ArrayList集合letterList中
  * 将十组六位字符组成的验证码放到另一个ArrayList集合中，利用Random类生成随机索引从letterList中取字符。
  * 用Iterator迭代器遍历集合

```java
package com.atguigu.homework1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class Homework1 {
    public static void main(String[] args) {
        char[] arr = new char[26+26+10];

        //使用字符数组保存原始字符
        for (int i = 0; i < arr.length; i++) {
            if(i<10){//前10个放数字
                arr[i] = (char)(i+48);
            }else if(i<10+26){//中间26个放大写字母
                arr[i] = (char)(i+65-10);
            }else{//剩下的放小写字母
                arr[i] = (char)(i+97-10-26);
            }
        }

        //随机生成10组验证码
        Collection<String> list = new ArrayList<String>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            String str = "";
            for (int j = 0; j < 6; j++) {
                int index = rand.nextInt(arr.length);
                str += arr[index];
            }
            list.add(str);
        }

        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            System.out.println("随机验证码：" + iter.next());
        }
    }
}

```

### 第2题：学生对象

（1）定义学生类，属性为姓名，年龄，属性私有化，提供有参构造，get/set，重写toString。

（2）在测试类中，创建ArrayList集合中。

（3）从键盘录入学生信息，创建学生对象，保存到集合中。

循环录入的方式，1：表示继续录入，0：表示结束录入。

（4）使用foreach遍历输出。

效果如图所示：

![1559890098509](https://iamgs.oss-cn-shanghai.aliyuncs.com/Images/1559890098509.png)

```java
package com.atguigu.homework2;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

```

```java
package com.atguigu.homework2;

import java.util.ArrayList;
import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        while(true){
            System.out.print("选择（1、录入；0、退出）：");
            int select = input.nextInt();
            if(select == 0){
                break;
            }
            System.out.print("姓名：");
            String name = input.next();
            System.out.print("年龄：");
            int age = input.nextInt();

            list.add(new Student(name,age));
        }

        for (Student stu : list) {
            System.out.println(stu);
        }

        input.close();
    }
}

```

### 第3题：自定义List容器

（1）定义MyArrayList<T>类，其中T表示元素类型，该类包含

- private的Object[]类型all，初始化长度为4。
- private的int类型的total，
- public void add(T t)：实现添加一个元素到all数组中，如果all数组已满，数组扩容为原来2倍。
- public T get(int index)：实现返回all[index]的元素。
- public Object toArray()：返回实际存储的元素。

（2）在测试类中创建MyArrayList容器对象

- 添加1-10的数字到MyArrayList容器中，
- 返回下标[5]的元素，
- 返回所有元素。

```java
package com.atguigu.homework6;

import java.util.Arrays;

public class MyArrayList<T> {
    private Object[] all = new Object[4];
    private int total;

    public void add(T t){
        if(total >= all.length){
            all = Arrays.copyOf(all, all.length*2);
        }
        all[total++] = t;
    }

    public T get(int index){
        if(index<0 || index>=total){
            throw new IndexOutOfBoundsException(index +"越界");
        }
        return (T) all[index];
    }

    public Object[] toArray(){
        return Arrays.copyOf(all,total);
    }
}

```

```java
package com.atguigu.homework6;

public class Homework6 {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 1; i <= 10 ; i++) {
            list.add(i);
        }
        System.out.println("list[5] = " + list.get(5));
        Object[] objects = list.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
    }
}

```

