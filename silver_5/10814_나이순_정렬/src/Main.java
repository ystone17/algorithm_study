import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static Member[] members;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        members = new Member[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            members[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(members);
        for (Member member : members) {
            bw.write(member.toString());
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }


    static class Member implements Comparable<Member> {
        int age;
        String name;


        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            return Integer.compare(age, o.age);
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
}
