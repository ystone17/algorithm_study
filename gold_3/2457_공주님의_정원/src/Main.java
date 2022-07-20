import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static Flower[] flowers;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        flowers = new Flower[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());

            flowers[i] = new Flower(sm, sd, em, ed);
        }

        Arrays.sort(flowers);

        Date curDate = new Date(3, 1);
        Date endDate = new Date(11, 30);
        Date temp = new Date(1, 1);
        int res = 0;

        for (Flower flower : flowers) {
            if (flower.sDate.compareTo(curDate) > 0 && temp.compareTo(flower.sDate) >= 0) {
                res++;
                curDate = temp;
                temp = new Date(1, 1);
            }

            if (curDate.compareTo(flower.sDate) >= 0 && temp.compareTo(flower.eDate) < 0) {
                temp = flower.eDate;
                if (temp.compareTo(endDate) > 0) {
                    res++;
                    break;
                }
            }
        }

        if(temp.compareTo(endDate) <= 0){
            System.out.println(0);
        } else{
            System.out.println(res);
        }

    }

    private static class Flower implements Comparable<Flower> {
        Date sDate;
        Date eDate;

        public Flower(int sMonth, int sDay, int eMonth, int eDay) {
            this.sDate = new Date(sMonth, sDay);
            this.eDate = new Date(eMonth, eDay);
        }


        @Override
        public int compareTo(Flower o) {
            if (sDate.equals(o.sDate)) {
                return o.eDate.compareTo(eDate);
            } else {
                return sDate.compareTo(o.sDate);
            }

        }


        @Override
        public String toString() {
            return "Flower{" +
                    "sDate=" + sDate +
                    ", eDate=" + eDate +
                    '}';
        }
    }

    private static class Date implements Comparable<Date> {
        int month;
        int day;

        public Date(int month, int day) {
            this.month = month;
            this.day = day;
        }

        @Override
        public int compareTo(Date o) {
            if (month == o.month) {
                return Integer.compare(day, o.day);
            } else {
                return Integer.compare(month, o.month);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Date date = (Date) o;
            return month == date.month && day == date.day;
        }

        @Override
        public int hashCode() {
            return Objects.hash(month, day);
        }

        @Override
        public String toString() {
            return "Date{" +
                    "month=" + month +
                    ", day=" + day +
                    '}';
        }
    }
}
