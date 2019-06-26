# chp2 创建销毁对象
1. 用静态工厂方法替代构造器[static factory method]
2. 构造器参数较多时考虑使用构建器[builder]
3. 用私有构造器或者枚举类型强化Singleton属性
4. 通过私有构造器使类和子类不能被实例化[一些工具类仅静态方法]
5. 优先使用依赖注入引用资源[现成框架 spring、Guice、Dagger]
6. 避免创建不必要的对象[]
7. 消除过期的对象引用[特别是对象自己管理内存的时候]
8. 避免使用终结方法(finalizer)和清除方法
9. try-with-resources 优先于try-finally[AutoClosable 接口]