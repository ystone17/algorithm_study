import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long a = sc.nextLong();
        Long b = sc.nextLong();
        Long c = sc.nextLong();

        System.out.println(recur(a, b, c));


    }

    static Long recur(Long a, Long b, Long c) {
        if (b == 1) {
            return a % c;
        }

        Long res = recur(a, b/2, c);
        if (b %2 ==0){
            return res * res % c;
        }

        return  a * (res * res % c) % c;

    }
}
