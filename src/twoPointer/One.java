package twoPointer;
//https://www.acmicpc.net/problem/1806

import java.io.*;
import java.util.StringTokenizer;

public class One {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int S;
    static int[] a;

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        a = new int[N +1];

        for (int i = 1; i <=N; i++) {
            a[i] = scan.nextInt();
        }
    }

    static void pro() {
        int R = 0, sum = 0, ans = N+1;

        for (int L = 1; L <=N ; L++) {
            // sum 은 - a[l] 의 값
            // sum 이 s 보다 작으면 추가로 sum 을 계산
            // sum 을 구한다, 추가로 하나씩 더하고 s 가넘어가면 종료
                // 그럼 R을 갱신
            // sum이 s 와 같다면 ans 를 계산과 비교

            sum -= a[L -1];

            while (sum < S && R < N) {
                R ++;
                sum += a[R];
            }
            if (sum >= S) ans = Math.min(ans, R - L +1);
        }
        if (ans == N +1) ans =0;

        System.out.println(ans);

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
