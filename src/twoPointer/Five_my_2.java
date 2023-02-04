package twoPointer;

import java.io.*;
import java.util.StringTokenizer;

public class Five_my_2 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static String alpha;
    static int[] sel;
    static int[] alp;

    static void input() {
        N = scan.nextInt();
        alpha = scan.nextLine();
        sel = new int[27];
        alp = new int[alpha.length() +1];

        for (int i = 0; i < alpha.length(); i++) {
            alp[i +1] = alpha.charAt(i) - 96;
        }

    }

    static void twoPointer() {
        int R = 1;
        int ans = Integer.MIN_VALUE;
        /**
         * 종류를 확인 할때는 kind 변수를 쓰면 좋다.
         **/
        int kind = 0;

        for (int L = 1; L <= alpha.length(); L++) {
            sel[alp[L -1]] -= 1;
            if (sel[alp[L -1]] == 0) kind --;

            while (R <= alpha.length()) {

                if (sel[alp[R]] == 0) {
                    if (kind +1 > N) break;
                    kind ++;
                }

                sel[alp[R]] +=1;
                R ++;
            }

            ans = Math.max(ans, R - L);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        twoPointer();
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
