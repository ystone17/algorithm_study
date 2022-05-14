import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int k = sc.nextInt() - 1;

        List<Integer> human = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            human.add(i + 1);
        }
        int idx = k;
        sb.append("<");

        while (human.size() > 1) {
            sb.append(human.get(idx)).append(", ");
            human.remove(idx);

            idx = (idx + k) % human.size();
        }
        sb.append(human.get(0)).append(">");
        System.out.print(sb);
    }
}
