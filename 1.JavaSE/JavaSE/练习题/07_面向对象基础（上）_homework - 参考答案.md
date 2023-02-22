# 巩固题

## 1、可变参数

声明数学工具类MathTools，包含如下方法：

- boolean isEven(int... nums)：判断0~n个整数是否都是偶数，如果都是偶数，返回true，否则返回false
- boolean isPositive(int... nums)：判断0~n个整数是否都是正数，如果都是正数，返回true，否则返回false
- int[] toArray(int... nums)：将0~n个整数放到一个int[]数组中，并返回数组

在测试类的main方法中测试，例如：1,2,3,4,5

```java
package com.atguigu.homework1;

public class MathTools {
    boolean isEven(int... nums){
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 != 0){
                return false;
            }
        }
        return true;
    }
    boolean isPositive(int... nums){
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0){
                return false;
            }
        }
        return true;
    }
    int[] toArray(int... nums){
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        return arr;
    }
}

```

```java
package com.atguigu.homework1;

public class MathToolsTest {
    public static void main(String[] args) {
        MathTools tools = new MathTools();

        System.out.println("1,2,3,4,5都是偶数吗？" + tools.isEven(1,2,3,4,5));
        System.out.println("1,2,3,4,5都是正数吗？" + tools.isPositive(1,2,3,4,5));
        int[] array = tools.toArray(1, 2, 3, 4, 5);
        System.out.println("array数组的元素：");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
```



## 2、重载方法

声明一个数组工具类ArrayTools，包含如下方法：

- int  binarySearch(int[]  arr,  int  value)：使用二分查找法在arr数组中查找value的下标，如果value不存在，就返回-1，如果数组arr不是有序的，结果将不一定正确

- int  binarySearch(char[]  arr,  char  value)：使用二分查找法在arr数组中查找value的下标，如果value不存在，就返回-1，如果数组arr不是有序的，结果将不一定正确

- int  binarySearch(double[]  arr,  double  value)：使用二分查找法在arr数组中查找value的下标，如果value不存在，就返回-1，如果数组arr不是有序的，结果将不一定正确

- void sort(int[] arr)：可以给arr数组从小到大排序，用冒泡排序实现

- void sort(char[] arr)：可以给arr数组从小到大排序，用冒泡排序实现

- void sort(double[] arr)：可以给arr数组从小到大排序，用冒泡排序实现
- String toString(int[] arr)：将元素拼接为"{元素1，元素2，......}"的字符串返回。
- String toString(double[] arr)：将元素拼接为"{元素1，元素2，......}"的字符串返回。
- String toString(char[] arr)：将元素拼接为"{元素1，元素2，......}"的字符串返回。

在测试类的main方法中测试，例如：

```
int[] arr = {2,4,1,3,6};  //显示排序前后的元素、查找5
char[] letters = {'h','e','w','o','d'};//显示排序前后的元素、查找'a'
double[] nums = {2.3, 1.5, 2.0, 3.5, 3.0};//显示排序前后的元素、查找1.5
```

```java
package com.atguigu.homework2;

public class ArrayTools {
    int binarySearch(char[] arr,  char value){
        for(int left = 0,right = arr.length-1; left<=right; ){
            int mid = left + (right-left)/2;

            if(arr[mid] == value){
                return mid;
            }else if(value > arr[mid]){
                //说明target在[mid]右边
                left = mid+1;
            }else{
                //说明target<arr[mid]，target在[mid]左边
                right= mid-1;
            }
        }
        return -1;
    }
    int binarySearch(int[] arr,  int value){
        for(int left = 0,right = arr.length-1; left<=right; ){
            int mid = left + (right-left)/2;

            if(arr[mid] == value){
                return mid;
            }else if(value > arr[mid]){
                //说明target在[mid]右边
                left = mid+1;
            }else{
                //说明target<arr[mid]，target在[mid]左边
                right= mid-1;
            }
        }
        return -1;
    }

    int binarySearch(double[] arr,  double value){
        for(int left = 0,right = arr.length-1; left<=right; ){
            int mid = left + (right-left)/2;

            if(arr[mid] == value){
                return mid;
            }else if(value > arr[mid]){
                //说明target在[mid]右边
                left = mid+1;
            }else{
                //说明target<arr[mid]，target在[mid]左边
                right= mid-1;
            }
        }
        return -1;
    }

    void sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    void sort(char[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i; j++) {
                if(arr[j] > arr[j+1]){
                    char temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    void sort(double[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i; j++) {
                if(arr[j] > arr[j+1]){
                    double temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    String toString(int[] arr){
        String result = "{";
        for (int i = 0; i < arr.length; i++) {
            if(i<arr.length-1){
                result += arr[i] + ",";
            }else{
                result += arr[i];
            }
        }
        result += "}";
        return result;
    }
    String toString(char[] arr){
        String result = "{";
        for (int i = 0; i < arr.length; i++) {
            if(i<arr.length-1){
                result += arr[i] + ",";
            }else{
                result += arr[i];
            }
        }
        result += "}";
        return result;
    }
    String toString(double[] arr){
        String result = "{";
        for (int i = 0; i < arr.length; i++) {
            if(i<arr.length-1){
                result += arr[i] + ",";
            }else{
                result += arr[i];
            }
        }
        result += "}";
        return result;
    }
}

```

```java
package com.atguigu.homework2;

public class ArrayToolsTest {
    public static void main(String[] args) {
        ArrayTools tools = new ArrayTools();

        int[] arr = {2,4,1,3,6};
        System.out.println("排序前：" + tools.toString(arr));
        tools.sort(arr);
        System.out.println("排序后：" + tools.toString(arr));
        System.out.println("查找5：" + tools.binarySearch(arr, 5));

        char[] letters = {'h','e','w','o','d'};
        System.out.println("排序前：" + tools.toString(letters));
        tools.sort(letters);
        System.out.println("排序后：" + tools.toString(letters));
        System.out.println("查找'a'：" + tools.binarySearch(letters, 'a'));

        double[] nums = {2.3, 1.5, 2.0, 3.5, 3.0};
        System.out.println("排序前：" + tools.toString(nums));
        tools.sort(nums);
        System.out.println("排序后：" + tools.toString(nums));
        System.out.println("查找1.5：" + tools.binarySearch(nums, 1.5));
    }
}

```

# 拔高题

## 1、方法的参数传递机制分析

在PassParamDemo类中，声明如下方法，并体会方法的参数传递机制，并尝试画图分析

- void  doubleNumber(int num)：将num变为原来的2倍大

- void toUpperCase(char letter)：将letter的小写字母转为大写字母

- void expandCircle(Circle  c，double times)：将Circle的c对象的半径扩大为原来的times倍。圆Circle类，包含radius属性。

- void doubleElement(int[] arr)：把arr数组的元素扩大2倍
- void grow(int[] arr)：将arr数组的长度变为原来的1.5倍

```java
package com.atguigu.homework3;

public class PassParamDemo {
    void  doubleNumber(int num){
        num *= 2;
    }

    void toUpperCase(char letter){
        letter -= 32;
    }

    void expandCircle(Circle c, double times){
        c.radius *= times;
    }

    void doubleElement(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
    }

    void grow(int[] arr){
        arr = new int[arr.length*2];
    }
}

```

在main方法中调用上面的方法后，请分析运行结果。

```java
package com.atguigu.homework3;

public class PassParamDemoTest {
    public static void main(String[] args) {
        PassParamDemo demo = new PassParamDemo();
        
        int x = 1;
        demo.doubleNumber(x);
        System.out.println("x = " + x);
        
        char c = 'a';
        demo.toUpperCase(c);
        System.out.println("c = " + c); 
        
        Circle circle = new Circle();
        circle.radius = 1;
        demo.expandCircle(circle, 5);
        System.out.println("circle.radius = " + circle.radius);

        int[] arr = {1,2,3,4,5};
        demo.doubleElement(arr);
        System.out.println("调用doubleElement方法之后：");
        System.out.println("arr数组的元素：" );
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        demo.grow(arr);
        System.out.println("调用grow方法之后：arr的数组长度："  + arr.length);
        System.out.println("arr数组的元素：" );
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

## 2、员工对象数组

声明一个Employee员工类，包含属性：编号(id)、姓名(name)、薪资(salary)、年龄(age)，包含如下方法：

- String getInfo()：返回员工的详细信息，每一个

- void setInfo(int  i, String n, double s, int a)：可以同时给id,name,salary,age赋值

声明一个EmployeeManager员工管理类，包含：

- Employee[]类型的allEmployees，长度指定为5
- int类型的实例变量total，记录allEmployees数组实际存储的员工数量
- boolean addEmployee(Employee emp)：添加一个员工对象到allEmployees数组中，如果数组已满，则不添加并提示数组已满

- Employee[] getEmployees()：返回total个员工对象


在测试类的main中添加6个员工对象，并且遍历输出。

```java
package com.atguigu.homework6;

public class Employee {
    int id;
    String name;
    double salary;
    int age;

    String getInfo(){
        return "编号：" + id + "，姓名：" + name + "，薪资：" + salary + "，年龄：" +age;
    }
    void setInfo(int  i, String n, double s, int a){
        id = i;
        name = n;
        salary = s;
        age = a;
    }
}

```

```java
package com.atguigu.homework6;

public class EmployeeManager {
    Employee[] allEmployees = new Employee[5];
    int total;

    boolean addEmployee(Employee emp){
        if(total >= allEmployees.length){
            System.out.println("数组已满");
            return false;
        }
        allEmployees[total++] = emp;
        return true;
    }

    Employee[] getEmployees(){
        Employee[] results = new Employee[total];
        for (int i = 0; i < results.length; i++) {
            results[i] = allEmployees[i];
        }
        return results;
    }
}

```

```java
package com.atguigu.homework6;

public class EmployeeManagerTest {
    public static void main(String[] args) {
        EmployeeManager em = new EmployeeManager();

        Employee e1 = new Employee();
        e1.setInfo(1,"刘一",11000,21);
        Employee e2 = new Employee();
        e2.setInfo(2,"陈二",12000,22);
        Employee e3 = new Employee();
        e3.setInfo(3,"张三",13000,23);
        Employee e4 = new Employee();
        e4.setInfo(4,"李四",14000,24);
        Employee e5 = new Employee();
        e5.setInfo(5,"王五",15000,25);
        Employee e6 = new Employee();
        e6.setInfo(6,"赵六",16000,26);

        System.out.println("添加e1" + (em.addEmployee(e1)?"成功":"失败"));
        System.out.println("添加e2" + (em.addEmployee(e2)?"成功":"失败"));
        System.out.println("添加e3" + (em.addEmployee(e3)?"成功":"失败"));
        System.out.println("添加e4" + (em.addEmployee(e4)?"成功":"失败"));
        System.out.println("添加e5" + (em.addEmployee(e5)?"成功":"失败"));
        System.out.println("添加e6" + (em.addEmployee(e6)?"成功":"失败"));

        Employee[] employees = em.getEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getInfo());
        }
    }
}

```



