# 巩固题

## 抽象类和接口

### 1、交通工具

（1）声明抽象类Vehicle交通工具

- 包含私有的的int类型的属性wheels，代表轮子的数量
- 包含有参构造Vehicle(int wheels)
- 包含抽象方法public abstract void drive()
- 重写toString()：返回轮子的数量

（2）声明子类Monocycle单轮车

- 重写抽象方法drive，输出“脚踏独轮车，摇摇摆摆往前走”

（3）声明子类Bicycle自行车

- 重写抽象方法drive，输出“脚踏双轮自行车，优哉游哉往前走”

（4）声明子类Tricycle三轮车

- 重写抽象方法drive，输出“脚踏三轮车，稳稳当当往前走“

（5）测试类

- 创建几个交通工具的对象，打印对象并调用drive方法

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



### 2、支付接口

（1）声明可支付接口Payable：

- 包含抽象方法：void pay();


（2）声明支付枚举类Payment：

- 声明String类型的final属性description
- 声明有参构造Payment(String description)
- 重写toString方法，返回description

```java
ALIPAY("支付宝"),WECHAT("微信"),CREDITCARD("信用卡"),DEPOSITCARD("储蓄卡")
```

- 枚举类Payment实现接口Payable


​	①支付宝/微信：对接口的实现是打印“扫码支付”

​	②信用卡/储蓄卡：对接口的实现是打印“输入卡号支付”

（3）在测试类中，获取所有支付对象，打印支付对象并调用它们的pay()方法

```java

```

```java

```

```java

```



### 3、各种鸟

（1）声明Flyable接口，

- 包含抽象方法void fly()方法

（2）声明Swimming接口

- 包含抽象方法void swim()方法

（3）声明子类Bird

- 声明抽象方法：public abstract void eat()

（4）声明子类Penguin企鹅，

- 继承Bird类，重写eat方法，输出"企鹅吃南极磷虾"
- 实现Swimming接口，重写swim()方法，输出“企鹅下海捉虾”

（5）声明子类Swan天鹅

- 继承Bird类，重写eat方法，输出“天鹅吃水生植物的根茎和种子、水生昆虫、螺类和小鱼”
- 实现Flyable接口，重写fly方法，输出“天鹅展翅高飞，天南海北任我游”
- 实现Swimming接口，重写swim()方法，输出“天鹅把羽毛洗的锃亮，顺便捉条鱼”

（6）声明子类Chicken鸡，

- 继承Bird类，重写eat方法，输出“鸡吃谷子”
- 实现Flyable接口，重写fly方法，输出“鸡上房揭瓦，满院子乱扑腾"

（7）测试类

- 创建Bird数组，并且把Penguin企鹅、Swan天鹅、Chicken鸡的对象放到Bird数组中，遍历数组，
- 调用各个元素的eat方法，
- 如果会飞的调用fly方法（提示：可以使用instanceof判断）
- 如果会游的调用swim方法

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

```java

```



