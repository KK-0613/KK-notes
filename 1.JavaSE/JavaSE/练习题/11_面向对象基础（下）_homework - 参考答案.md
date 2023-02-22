# 巩固题

## 内部类

### 1、尚硅谷

编写一个匿名内部类，它继承Object，并在匿名内部类中，声明一个方法public void print()，输出尚硅谷。

请编写代码调用这个方法。

```java
package com.atguigu.homework4;

public class TestObject {
    public static void main(String[] args) {
        new Object(){
            public void print(){
                System.out.println("尚硅谷");
            }
        }.print();
    }
}
```



### 2、我爱尚硅谷/尚硅谷爱我

（1）已知java.lang包下有一个Thread类（这个类不用写），该类有：

- ①public Thread(String name)构造器
- ②public Thread(Runnable target)构造器
- ③public void run()方法
- ④public void start()方法
- ⑤public String getName()方法

（2）已知java.lang包下还有一个Runnable接口（这个接口不用写），该接口有

- 抽象方法：public void run()

（3）测试类

- ①请用匿名内部类的方式继承Thread类，并显示使用Thread(String name)构造器，传入实参“自己的姓名”，在匿名内部类中重写run方法，输出“xx爱尚硅谷”，其中xx通过getName()方法获取。同时调用Thread类匿名子类对象的start()方法。
- ②请用Thread(Runnable target)构造器创建Thread类的对象，并且用匿名内部类的方式实现Runnable接口，重写run方法，输出“尚硅谷爱我”。调用Thread类对象的start方法
- ③运行测试类，查看运行效果

```java
package com.atguigu.homework5;

public class TestThread {
    public static void main(String[] args) {
        new Thread("你"){
            @Override
            public void run() {
                System.out.println(getName() +"爱尚硅谷");
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("尚硅谷爱我");
            }
        }).start();
    }
}
```

### 3、阅读代码，分析运行结果

```java
public class TestOutIn {
    public static void main(String[] args) {
        Out.In in = new Out().new In();
        in.print();
    }
}
class Out {
    private int a = 12;
    class In {
        private int a = 13;
        public void print() {
            int a = 14;
            System.out.println("局部变量：" + a);
            System.out.println("内部类变量：" + this.a);
            System.out.println("外部类变量：" + Out.this.a);
        }
    }
}
```

### 4、阅读代码，分析运行结果

```java
public class TestOut {
	public static void main(String[] args) {
        Out out = new Out();
        out.print(3);
    }
}
class Out {
    private int a = 12;
    public void print(final int x) {
        class In {
            public void inPrint() {
                System.out.println(x);
                System.out.println(a);
            }
        }
        new In().inPrint();
    }
}
```

## 枚举和包装类

### 第1题：阅读代码，分析运行结果

```java
	public static void main(String[] args) {
		Integer i1 = 128;
		Integer i2 = 128;
		int i3 = 128;
		int i4 = 128;
		System.out.println(i1 == i2);
		System.out.println(i3 == i4);
		System.out.println(i1 == i3);
	}
```

### 第2题：阅读代码，分析运行结果

```java
	public static void main(String[] args) {
		double a = 2.0;
		double b = 2.0;
		Double c = 2.0;
		Double d = 2.0;
		System.out.println(a == b);
		System.out.println(c == d);
		System.out.println(a == d);
	}
```

### 第3题：颜色枚举类

（1）声明颜色枚举类Color：

- 声明final修饰的int类型的属性red,green,blue
- 声明final修饰的String类型的属性description
- 声明有参构造Color(int red, int green, int blue,String description)
- 创建7个常量对象：赤、橙、黄、绿、青、蓝、紫，
- 重写toString方法，例如：RED(255,0,0)->红色

（2）在测试类中，使用枚举类，获取绿色对象，并打印对象。

提示：

- 7个常量对象的RGB值如下：

```java
赤：(255,0,0)
橙：(255,128,0)
黄：(255,255,0)
绿：(0,255,0)
青：(0,255,255)
蓝：(0,0,255)
紫：(128,0,255)
```

- 7个常量对象名如下：

```java
RED, ORANGE, YELLOW, GREEN, CYAN, BLUE,PURPLE
```

```java
package com.atguigu.enumration;

public enum Color {
    RED(255,0,0,"赤"),
    ORANGE(255,128,0,"橙"),
    YELLOW(255,255,0,"黄"),
    GREEN(0,255,0,"绿"),
    CYAN(0,255,255,"青"),
    BLUE(0,0,255,"蓝"),
    PURPLE(128,0,255,"紫");

    private final int red;
    private final int green;
    private final int blue;
    private final String description;

    Color(int red, int green, int blue,String description) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.description = description;
    }

    @Override
    public String toString() {
        return name()+"("+red+","+green+","+green+")->" + description;
    }
}

```

```java
package com.atguigu.enumration;

public class TestColor {
    public static void main(String[] args) {
        Color green = Color.GREEN;
        System.out.println(green);
    }
}

```



### 第4题：设备状态枚举类

（1）声明设备状态枚举类Status

- 声明final修饰的String类型的属性description和int类型的属性value，value值初始化为ordinal()值
- 声明有参构造Status(String description)
- 重写toString方法，返回description值
- 提供静态方法public static Status getByValue(int value)：根据value值获取Status状态对象
- 创建3个常量对象：

```java
FREE("空闲"), USED("在用"), SCRAP("报废")
```

（2）声明设备类型Equipment

- 声明设备编号(int)、设备的品牌（String）、价格（double）、设备名称（String）、状态（Status）属性，私有化
- 提供无参和有参构造
- 重写toString方法，返回设备信息

（3）现有Data.java，代码如下：

```java
public class Data {
    public static final String[][] EQUIPMENTS = {
            {"1", "联想", "6000", "拯救者","0"},
            {"2", "宏碁 ","5000", "AT7-N52","0"},
            {"3", "小米", "2000", "5V5Pro","1"},
            {"4", "戴尔", "4000", "3800-R33","1"},
            {"5", "苹果", "12000", "MBP15","1"},
            {"6", "华硕", "8000", "K30BD-21寸","2"},
            {"7", "联想", "7000", "YOGA","0"},
            {"8", "惠普", "5800", "X500","2"},
            {"9", "苹果", "4500","2021Pro","0"},
            {"10", "惠普", "5800", "FZ5","1"}
    };
}
```

（4）在测试类中，创建Equipment类型的数组，并使用Data类的二维数组EQUIPMENTS的信息初始化设备对象，遍历输出

```java
package com.atguigu.wrapper;

public enum Status {
    FREE("空闲"), USED("在用"), SCRAP("报废");

    private final int value;
    private final String description;

    private Status(String description) {
        this.value = ordinal();
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Status getByValue(int value){
        return Status.values()[value];
    }

    @Override
    public String toString() {
        return description;
    }
}
```

```java
package com.atguigu.wrapper;

public class Equipment {
    private int id;
    private String factory;
    private double price;
    private String name;
    private Status status;

    public Equipment() {}

    public Equipment(int id, String factory, double price, String name, Status status) {
        this.id = id;
        this.factory = factory;
        this.price = price;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", factory='" + factory + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
```

```java
package com.atguigu.wrapper;

public class Data {
    public static final String[][] EQUIPMENTS = {
            {"1", "联想", "6000", "拯救者","0"},
            {"2", "宏碁 ","5000", "AT7-N52","0"},
            {"3", "小米", "2000", "5V5Pro","1"},
            {"4", "戴尔", "4000", "3800-R33","1"},
            {"5", "苹果", "12000", "MBP15","1"},
            {"6", "华硕", "8000", "K30BD-21寸","2"},
            {"7", "联想", "7000", "YOGA","0"},
            {"8", "惠普", "5800", "X500","2"},
            {"9", "苹果", "4500","2021Pro","0"},
            {"10", "惠普", "5800", "FZ5","1"}
    };
}
```

```java
package com.atguigu.wrapper;

import static com.atguigu.wrapper.Data.EQUIPMENTS;

public class TestEquipment {
    public static void main(String[] args) {
        Equipment[] arr = new Equipment[EQUIPMENTS.length];

        for (int i = 0; i < arr.length; i++) {
            int id = Integer.parseInt(EQUIPMENTS[i][0]);
            String factory = EQUIPMENTS[i][1];
            double price = Double.parseDouble(EQUIPMENTS[i][2]);
            String name = EQUIPMENTS[i][3];
            int value = Integer.parseInt(EQUIPMENTS[i][4]);
            Status status = Status.getByValue(value);
            arr[i] = new Equipment(id,factory,price,name,status);
            System.out.println(arr[i]);
        }
    }
}
```

