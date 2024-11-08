package ss17_thread;

public class Demo implements Runnable {
    private String threadName;

    public Demo(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(threadName + " start");
        for (int i = 0; i< 5; i++) {
            System.out.println(threadName + ". số lần lặp: "+ i);
            try {
//                Giả sử đây là tác vụ cần thực hiện. và nó mất 1s để hoàn thành
//                sleep: tạm dừng thread 1s
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Demo demo1 = new Demo("HaiTT");
        Demo demo2 = new Demo("C0724M1");
        Thread thread1 = new Thread(demo1);
        Thread thread2 = new Thread(demo2);
//        Đăng bài viết
        thread1.start();
//        Đăng bài viết
        thread2.start();
//        Thông báo thành công
        try {

            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Lỗi");
        }
        System.out.println("Hello");
    }
}

