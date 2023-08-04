import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static List<Grade> gradeList = new ArrayList<>();
    static int[] countriesCnt = new int[100];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int studentNumber = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());

            gradeList.add(new Grade(country, studentNumber, point));
        }

        int cnt = 0;
        Collections.sort(gradeList);
        for (Grade grade : gradeList) {
            if (cnt == 3) {
                break;
            }

            if (countriesCnt[grade.country] >= 2) {
                continue;
            }

            System.out.println(grade);
            countriesCnt[grade.country]++;
            cnt++;
        }
    }

    private static class Grade implements Comparable<Grade> {
        int country;
        int studentNumber;
        int point;

        public Grade(int country, int studentNumber, int point) {
            this.country = country;
            this.studentNumber = studentNumber;
            this.point = point;
        }

        @Override
        public int compareTo(Grade o) {
            return Integer.compare(o.point, point);
        }

        @Override
        public String toString() {
            return country + " " + studentNumber;
        }
    }
}
