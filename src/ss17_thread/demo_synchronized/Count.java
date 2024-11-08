package ss17_thread.demo_synchronized;

public class Count {
    synchronized void printTable(int n) { // synchronized method
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
