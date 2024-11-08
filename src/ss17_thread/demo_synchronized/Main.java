package ss17_thread.demo_synchronized;

public class Main {
    public static void main(String args[]) {
        Count obj = new Count();// tao mot object

        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);

        t1.start();
        t2.start();


    }
}
