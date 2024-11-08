package ss17_thread.demo_synchronized;

class MyThread1 extends Thread {
    Count t;

    MyThread1(Count t) {
        this.t = t;
    }

    public void run() {
        t.printTable(5);
    }

}