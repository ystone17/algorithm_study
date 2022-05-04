import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> seq = new ArrayList<>();
        seq.add(0);

        for (int i = 666; i < 10_000_000; i++) {
            String s = Integer.toString(i);
            if (s.contains("666")) {
                seq.add(i);
            }
        }

        Collections.sort(seq);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(seq.get(n));

    }

}
