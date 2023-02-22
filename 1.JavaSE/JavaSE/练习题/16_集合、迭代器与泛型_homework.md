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

```

```java

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

```

```java

```

