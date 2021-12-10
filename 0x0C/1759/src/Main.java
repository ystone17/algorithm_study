import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static char[] input;
    static List<Character> moList = Arrays.asList('a', 'e', 'i', 'o', 'u');
    static int l, c;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        input = new char[c];
        int i = 0;
        while (st.hasMoreTokens()) {
            input[i++] = st.nextToken().charAt(0);
        }

        Arrays.sort(input);

        Pwd(0, 0, "", 0, 0);
        bw.flush();
        bw.close();
        br.close();

    }

    static void Pwd(int index, int start, String pwd, int mo, int ja) throws IOException {
        if (index == l) {
            if (mo > 0 && ja > 1)
                bw.write(pwd + "\n");
            return;
        }

        for (int i = start; i < c; i++) {
            if (moList.contains(input[i])) {
                Pwd(index + 1, i + 1, pwd + input[i], mo + 1, ja);
            } else {
                Pwd(index + 1, i + 1, pwd + input[i], mo, ja + 1);
            }
        }
    }
}
