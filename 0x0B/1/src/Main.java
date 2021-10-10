public class Main {
    public static void main(String[] args) {
        System.out.println(recursion(12));
    }

    static int recursion(int n){
        if(n == 1){
            System.out.printf("%d = ", n);
            return n;
        }
        System.out.printf("%d + ", n);
        return n + recursion(n-1);
    }
}
