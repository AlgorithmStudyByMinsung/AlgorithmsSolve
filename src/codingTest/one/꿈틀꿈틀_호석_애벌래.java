package codingTest.one;
// https://www.acmicpc.net/problem/20181
// 시간 초과
// 시간 : 30분
// 2^100000000 에서 줄어든다해도 1초이하가 걸리지 않는다.
import java.io.*;
import java.util.StringTokenizer;

public class 꿈틀꿈틀_호석_애벌래 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int K;
    static int[] a;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();

        a = new int[N + 1];

        for (int i = 1; i <= N ; i++) a[i] = scan.nextInt();
    }
    static int max = Integer.MIN_VALUE;
    static void pro(int x, int sum){
        if (x == N + 1) {
            max = Math.max(max, sum);
            return;
        }
        int s = 0;
        int R = x;

        while (R >= 1 && R <= N && s < K) {
            s += a[R];
            R ++;
        }

        int b = s - K;

        pro(R , sum + b);
        pro(x + 1, sum);
    }

    public static void main(String[] args) {
        input();

        pro(1, 0);
        System.out.println(max);
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
