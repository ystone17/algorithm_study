import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, total;
    static Project[] projects;
    static int[] schedule = new int[10000];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        projects = new Project[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            projects[i] = new Project(p, d);
        }

        Arrays.sort(projects);

        for (Project project : projects) {
            for (int i = project.day - 1; i >= 0; i--) {
                if(schedule[i] == 0 ){
                    schedule[i] = project.charge;
                    total += project.charge;
                    break;
                }
            }
        }

        System.out.println(total);

    }

    static class Project implements Comparable<Project>{
        int charge;
        int day;

        public Project(int charge, int day) {
            this.charge = charge;
            this.day = day;
        }

        @Override
        public int compareTo(Project o) {
            return o.charge - charge;
        }

        @Override
        public String toString() {
            return "Project{" +
                    "charge=" + charge +
                    ", day=" + day +
                    '}';
        }
    }
}
