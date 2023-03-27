import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Card[] cards = new Card[5];
    static int max = 0;
    static int[] cnt = new int[10];
    static boolean four, three;
    static int two;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            String color = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            cards[i] = new Card(color, num);
        }

        if (allSameColor()) {
            if (seqNumber()) {
                System.out.println(900 + max);
            } else {
                System.out.println(600 + max);
            }
            return;
        }


        if (seqNumber()) {
            System.out.println(500 + max);
            return;
        }

        initCnt();

        if (four) {
            int temp = 800;
            for (int i = 1; i <= 9; i++) {
                if (cnt[i] == 4) {
                    temp += i;
                    break;
                }
            }

            System.out.println(temp);
            return;
        }

        if (three) {
            int temp = 0;
            if (two > 0) {
                for (int i = 1; i <= 9; i++) {
                    if (cnt[i] == 3) {
                        temp += i * 10;
                    }

                    if (cnt[i] == 2) {
                        temp += i;
                    }
                }
                System.out.println(700 + temp);
            } else {
                for (int i = 1; i <= 9; i++) {
                    if (cnt[i] == 3) {
                        temp += i;
                        break;
                    }
                }
                System.out.println(400 + temp);
            }
            return;
        }

        if (two >= 2) {
            int max = 0;
            int min = 0;
            for (int i = 1; i <= 9; i++) {
                if (cnt[i] == 2) {
                    min = max;
                    max = i;
                }
            }

            System.out.println(max * 10 + min + 300);
            return;
        }

        if (two == 1) {
            for (int i = 1; i <= 9; i++) {
                if (cnt[i] == 2) {
                    System.out.println(200 + i);
                    return;
                }
            }
        }

        System.out.println(100 + max);

    }

    static boolean allSameColor() {
        String baseColor = cards[0].color;

        for (int i = 1; i < 5; i++) {
            if (!cards[i].color.equals(baseColor)) {
                return false;
            }
        }

        return true;
    }

    static boolean seqNumber() {
        List<Integer> numbers = Arrays.stream(cards).map(card -> card.num).sorted().collect(Collectors.toList());

        max = numbers.get(4);

        int baseNumber = numbers.get(0);
        for (int i = 1; i < 5; i++) {
            if (numbers.get(i) != baseNumber + i) {
                return false;
            }
        }

        return true;
    }

    static void initCnt() {
        for (Card card : cards) {
            cnt[card.num]++;
        }

        for (int i : cnt) {
            if (i == 4) four = true;
            if (i == 3) three = true;
            if (i == 2) two++;
        }
    }

    static class Card {
        public String color;
        public int num;

        public Card(String color, int num) {
            this.color = color;
            this.num = num;
        }
    }
}
