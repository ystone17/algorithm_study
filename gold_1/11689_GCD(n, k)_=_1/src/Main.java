import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static long n, res;
    static List<Long> primes = new ArrayList<>();
    static Deque<Long> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        n = Long.parseLong(br.readLine());

        if (n == 1) {
            System.out.println(1);
            return;
        }

        if (isPrime(n)) {
            System.out.println(n - 1);
            return;
        }

        getPrimes();

        solve(0, 0);
        System.out.println(n - res);

    }

    static void getPrimes() {
        long l = n;
        for (int i = 2; i <= Math.sqrt(l); i++) {
            if (l % i == 0 && isPrime(i)) {
                primes.add((long) i);
            }

            while (l % i == 0) {
                l /= i;
            }
        }

        if (l != 1) {
            primes.add(l);
        }
    }

    static boolean isPrime(long l) {
        if (l == 1) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(l); i++) {
            if (l % i == 0) {
                return false;
            }
        }

        return true;
    }

    static void solve(int primesIdx, int cnt) {
        if (primesIdx >= primes.size()) {
            if (cnt == 0) return;
            if (cnt % 2 == 0) {
                res -= total();
            } else {
                res += total();
            }

            return;
        }

        deque.addLast(primes.get(primesIdx));
        solve(primesIdx + 1, cnt + 1);
        deque.pollLast();
        solve(primesIdx + 1, cnt);
    }

    static long total() {
        long lcm = 1;

        for (Long prime : deque) {
            lcm = lcm(lcm, prime);
        }

        return n / lcm;
    }


    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    static long gcd(long a, long b) {
        if (a < b) {
            long temp = b;
            b = a;
            a = temp;
        }

        while (b > 0) {
            long temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }


}
