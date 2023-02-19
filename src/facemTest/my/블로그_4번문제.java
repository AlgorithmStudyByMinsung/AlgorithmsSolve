package facemTest.my;
// https://www.acmicpc.net/problem/21921
// 33분 소요
// twoPointer 문제
// 시간복잡도를 잘못 계산
import java.io.*;
import java.util.StringTokenizer;

public class 블로그_4번문제 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int X;
    static int[] a;

    static void input() {
        N = scan.nextInt();
        X = scan.nextInt();

        a = new int[N + 1];

        for (int i = 1; i <= N ; i++) a[i] = scan.nextInt();
    }

    static void twoPointer(int k) {
        int R = 1;
        int sum = 0; int Max = Integer.MIN_VALUE;
        int cnt = 0; int l = 1;

        for (int L = 1; L <= N - k + 1; L++) {
            sum -= a[L - 1];
            l --;

            while (l < k) {
                sum += a[R];
                R ++; l ++;
            }

            if (sum > Max) {
                Max = sum;
                cnt = 1;
            } else if (sum == Max) {
                cnt ++;
            }
        }
        if (Max == 0) {
            System.out.println("SAD");
            System.out.close();
        }
        System.out.println(Max);
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        input();
        twoPointer(X);
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
