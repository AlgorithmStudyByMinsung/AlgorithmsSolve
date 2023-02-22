package math.소수;
// https://www.acmicpc.net/problem/21919
/**
 * 흔흔 소수찾기 문제이지만 최소공배수를 구하라고 했고 소수가 같을 경우에는 곱해주면 안된다는
 * 주의 사항이 존재한다.
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수와최소공배수 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] a;
    static boolean[] check;
    static int MOD = 1000000;
    static void input() {
        N = scan.nextInt();

        a = new int[N + 1];
        check = new boolean[MOD + 1];

        for (int i = 1; i <= N; i++) {
            a[i] = scan.nextInt();
        }
    }

    static void primeCheck() {
        check[0] = check[1] = true;

        for (int i = 2; i * i <= MOD; i++) {
            if (check[i]) continue;

            for (int j = i + i; j <= MOD; j+= i) {
                check[j] = true;
            }
        }
    }
    static void pro() {
        primeCheck();

        long ans = 1;
        for (int i = 1; i <= N; i++) {
            if (check[a[i]]) continue;

            check[a[i]] = true;
            ans *= a[i];
        }
        if (ans == 1) System.out.println("-1");
        else System.out.println(ans);
    }
    public static void main(String[] args) {
        input();
        pro();

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }

    }
}
