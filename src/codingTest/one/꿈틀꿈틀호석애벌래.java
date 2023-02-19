package codingTest.one;
/**
 * 선택의 여부가 가능 --> 하지만 이러면 보통 2의 n 승
 *               --> 여기에 최대 값을 구하는 문제다! -> DP
 * */
/**
 * dp 란 작은 값을 이용해서 큰 값을 구하는 문제이다.
 * 이전에 값들이 최댓 값이 다 잘 저장이 되어있다면 그걸 이용해서 답을 구할 수가 있다.
 *
 * */
/**
 * 선택과 관련된 dp
 * - dp[i] = dp[i - 1](= 선택 안함 ) + 선택 했을 때의 dp
 * */
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 꿈틀꿈틀호석애벌래 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Interval {
        public int L;
        public long score;

        public Interval(int l, long score) {
            L = l;
            this.score = score;
        }
    }

    static int N;
    static int K;
    static ArrayList<Interval>[] intervals;

    static int[] a;
    static long[] d;


    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        a = new int[N + 1];
        d = new long[N + 1];
        intervals = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            a[i] = scan.nextInt();
            intervals[i] = new ArrayList<>();
        }
    }

    static void twoPointer() {
        int R = 1; long sum = 0;

        for (int L = 1; L <= N; L++) {
            sum -= a[L - 1];

            while (R <= N && sum < K) {
                sum += a[R];
                R ++;
            }

            if (sum >= K) {
                long energy = sum - K;
                Interval interval = new Interval(L, energy);

                intervals[R - 1].add(interval);
            }
        }
    }

    static void dp() {
        for (int i = 1; i <= N; i++) {
            for (Interval interval : intervals[i]) {
                d[i] = Math.max(d[i], interval.score + d[interval.L - 1]);
            }
            d[i] = Math.max(d[i], d[i - 1]);
        }
        System.out.println(d[N]);
    }

    public static void main(String[] args) {
        input();
        twoPointer();
        dp();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
