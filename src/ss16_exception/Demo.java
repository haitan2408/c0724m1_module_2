package ss16_exception;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();

        Object a = null;
        System.out.println(a.hashCode());
    }
}
