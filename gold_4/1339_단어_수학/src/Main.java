import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, answer;
    static char[][] board;
    static Set<Character> set = new HashSet<>();
    static int[] visited, number;
    static Map<Character, Integer> characterIntegerMap = new HashMap<>();
    static ArrayList<Character> characters;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new char[n][8];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
                board[i][j + (8 - input.length)] = input[j];
                set.add(input[j]);
            }
        }

        characters = new ArrayList<>(set);

        for (int i = 0; i < characters.size(); i++) {
            characterIntegerMap.put(characters.get(i), i);
        }

        number = new int[characters.size()];
        visited = new int[10];

        setNumber(0, 9 - characters.size());
        System.out.println(answer);
    }

    static void setNumber(int idx, int end) {
        if (idx == number.length) {
            int res = calc();
            answer = Integer.max(answer, res);
            return;
        }

        for (int i = 9; i > end; i--) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            number[idx] = i;
            setNumber(idx + 1, end);
            visited[i] = 0;
            number[idx] = 0;
        }
    }

    private static int calc() {
        int res = 0;
        for (char[] chars : board) {
            int ten = 1;
            for (int i = chars.length - 1; i >= 0 && chars[i] != '\0'; i--) {
                res += number[characterIntegerMap.get(chars[i])] * ten;
                ten *= 10;
            }
        }
        return res;
    }

}
