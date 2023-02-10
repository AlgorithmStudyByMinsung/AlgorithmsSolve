package dp.유형2_배열_2개.구간;
// https://www.acmicpc.net/problem/11066
/**
 * DP 의 3번 째 유형 : 구간
 *
 * 가장 작은 값을 제일 작은 구간으로 지정
 * d[i][j]  를 i ~ j 까지로 한다.
 * */
import java.io.*;
import java.util.*;

public class One {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int K, Q;
    static int[] num;
    static int[][] Dy, sum;

    static void input(){
        K = scan.nextInt();
        num = new int[K + 1];
        sum = new int[K + 1][K + 1];
        for (int i = 1; i <= K; i++){
            num[i] = scan.nextInt();
        }
    }

    static void preprocess(){
        // 문제의 특성상 전처리 과정
        for (int i = 1; i <= K; i++){
            for (int j = i; j <= K; j++){
                sum[i][j] = sum[i][j - 1] + num[j];
            }
        }
    }

    static void pro() {
        preprocess();
        // i == j 일 때 d[i][j] 는 0으로 설정!
        Dy = new int[K + 1][K + 1];

        for (int len = 2; len <= K; len ++){
            for (int i = 1; i <= K - len + 1; i++){
                /**
                 * j 를 for 문으로 돌리는 것이 아니다!
                 * */
                int j = i + len - 1;

                Dy[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++){
                    Dy[i][j] = Math.min(Dy[i][j], Dy[i][k] + Dy[k + 1][j] + sum[i][j]);
                }
            }
        }

        System.out.println(Dy[1][K]);
    }

    public static void main(String[] args) {
        Q = scan.nextInt();
        for (int rep = 1; rep<=Q;rep++) {
            input();
            pro();
        }
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