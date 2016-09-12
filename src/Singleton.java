/**
 * Created by liuyan on 16/9/13.
 */

/**
 * 单例模式，双重校验锁
 * */
class Singleton1 {
    private static volatile Singleton1 singleton1 = null;

    private  Singleton1() {}

    public static Singleton1 getInstance() {
        if(singleton1 == null) {
            synchronized (Singleton1.class) {
                if(singleton1 == null) {
                    singleton1 = new Singleton1();
                }
            }
        }
        return singleton1;
    }
}


/**
 * 单例模式，静态内部类
 * */
class Singleton2 {
    private Singleton2() {}

    private static class A {
        private static Singleton2 singleton2 = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return A.singleton2;
    }
}


/**
 * 单例模式，枚举写法
 * 调用方法: Singleton3.INSTANCE.foo()
 * */
enum Singleton3 {
    INSTANCE;

    public int i = 0;

    public void foo() {
        System.out.println("hello world");
    }
}