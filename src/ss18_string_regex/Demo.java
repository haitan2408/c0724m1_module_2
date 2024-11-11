package ss18_string_regex;

public class Demo {
    public static void main(String[] args) {
        String a = "HaiTT";
        String b = "HaiTT";
        String c = new String("HaiTT");
        System.out.println(a == b);
        b = b.concat("CG");
        System.out.println(b);
    }
}
