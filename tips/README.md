# 属性拷贝
两个对象之间属性大致相同，给对象赋值操作，会考虑属性拷贝工具进行，可以节省大量的 get 和 set 操作。
  
常用的工具类：
- Spring BeanUtils
- Cglib BeanCopier
- Apache BeanUtils
- Apache PropertyUtils
- Dozer

各个工具性能测试结果：

| 工具类               | 执行1000次耗时 | 执行10000次耗时 | 执行100000次耗时 | 执行1000000次耗时 |
| -------------------- | -------------- | --------------- | ---------------- | ----------------- |
| Spring BeanUtils     | 158ms          | 164ms           | 180ms            | 218ms             |
| Cglib BeanCopier     | 47ms           | 62ms            | 116ms            | 179ms             |
| Apache PropertyUtils | 161ms          | 761ms           | 4748ms           | 41600ms           |
| Apache BeanUtils     | 73ms           | 426ms           | 3955ms           | 35341ms           |
| Dozer                | 589ms          | 229ms           | 12036ms          | 148923ms          |

**结论：**  
综上，基本可以得出结论，在性能方面，Spring BeanUtils 和 Cglib BeanCopier 表现不错，而 
Apache PropertyUtils、Apache BeanUtils 以及 Dozer 则表现的很不好。

所以，如果考虑性能的情况下，建议不要选择 Apache PropertyUtils、Apache BeanUtils、以及 Dozer 等工具类。

技术选型，除了性能还有其它很多方面，比如使用成本呢、理解难度、兼容性、可扩展性、功能完善性等。
  

@TODO 浅拷贝 与 深拷贝


# SimpleDateFormat
日期格式化时必须使用 y 表示年，而不能用 Y。  
- y：表示 year
- Y：表示 Week Year ！
不同国家对于一周的开始和结束的定义是不同的。例如，中国把星期一作为一周的第一天，而在没过把星期日作为一周的第一天。
所以在跨年的时候容易发生错误。  

ISO 8601：
- 本年度第一个星期四所在的星期
- 1月4日所在的星期
- 本年度第一个至少有 4 天在同一星期内的星期
- 星期一在去年 12 月 29 日至今年 1 月 4 日以内的星期

所以要表示日期的时候，一定要使用 yyyy-MM-dd 而不是 YYYY-MM-dd ，这两者的返回结果大多数情况先都一样，但是极端情况就会有问题了。

# HashMap
建议初始化 HashMap 的容量大小。  
如果已知 Map 中将存放的元素个数，给 HashMap 设置初始化绒里那个可以在一定程度上减少扩容次数而提升效率。  

初始化容量计算公式(guava21.0): 
```
(int) ((float) expectedSize / 0.75F + 1.0F);
```  
例如想存 8 个元素，8/0.75 + 1 = 11 所以 初始化容量为 16，不会触发扩容机制，但可能会牺牲些内存

# 禁用 Executors 创建线程池
Executors 创建常用的线程池的一些问题：  
Executors.newFixedThreadPool 和 Executors.newSingleThreadExecutor 最大可添加 Integer.MAX_VALUE 个未执行线程，这样有可能会导致 OOM;  
Executors.newCachedThreadPool 和  Executors.newScheduledThreadPool 最多可以创建 Integer.MAX_VALUE 个线程，可能会导致 OOM;

创建线程池的正确姿势：  
正确姿势 1 -> 使用 ThreadPoolExecutor 创建线程池
```
private static ExecutorService es = new ThreadPoolExecutor(
            30,
            200,
            60L,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue(100));
``` 
正确姿势 2 -> 使用 guava 的 ThreadFactoryBuilder 创建线程池
通过上述方式创建线程时，不仅可以避免 OOM 的问题，还可以自定义线程名称，更加方便的出错的时候溯源
```
private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
    private static ExecutorService pool = new ThreadPoolExecutor(
            5,
            200,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024),
            namedThreadFactory,
            new ThreadPoolExecutor.AbortPolicy());
```

# 谨慎使用 ArrayList 中的 subList 方法
总结：
      1. 对 父 (sourceList) 子 (subList)List 做 的 非 结 构 性 修 改（non-structural changes），都会影响到彼此。
      2. 对子 List 做结构性修改，操作同样会反映到父 List 上。
      3. 对父 List 做结构性修改，会抛出异常 ConcurrentModificationException。
      

# 字符串拼接
速度对比：  
```asciidoc
StringBuilder > StringBuffer > concat > + > StringUtils.join
```  
- 如果不是在循环体中进行字符串拼接的话，直接使用 + 就好了
- 如果在并发场景中进行字符串拼接的话，要使用StringBuffer代替StringBuilder

# 禁止在 foreach 循环里进行元素的remove/add操作
不要在foreach循环里进行元素的remove/add操作。remove元素请使用Iterator方式，如果并发操作，需要对Iterator对象加锁

# 禁止工程师直接使用日志系统(Log4j、Logback)中的API
SLF4J 门面模式 -> 日志处理框架

# 禁止把 SimpleDateFormat 定义成 static 变量
多线程操作的时候是线程不安全的

# 禁止开发人员使用 isSuccess 作为变量名


# 禁止开发人员修改 serialVersionUID 字段的值
serialVersionUID 是一个用来验证版本已执行的，所以在做兼容性升级的时候，不要改变类中 serialVersionUID 的值。  
如果一个类实现了 Serializable 接口，一定要记得定义 serialVersionUID 否则会发生异常。可以在 IDE 中通过设置一键生成。  
