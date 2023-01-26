package twoPointer;

import java.io.*;
import java.util.*;
/**
 * 투포인터 유형 1번문제
 *
 * - 5가지의 스텝을 거친다!!
 **/
public class Five_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static String s;
    static int R;
    static int[] alpha = new int[27];

    static void input() {
        N = scan.nextInt();
        s = scan.next();

    }
    /**
     * 4. 확인하는 함수
     *
     * - 그 R이 되는 지 안되는 지 확인
     **/
    static boolean available(int R) {
        alpha[s.charAt(R) -96] ++;

        int sum = 0;
        for (int i = 1; i <=26 ; i++) {
            int current = alpha[i];

            if (current == 0) sum ++;
        }
        int kind = 26 - sum;

        alpha[s.charAt(R) -96] --;
        return kind <= N;
    }
    static void pro() {
        /**
         * 1. 정답 변수
         * */
        int max = Integer.MIN_VALUE;

        /**
         *  2. for - while 문
         **/
        for (int L = 0; L <s.length() ; L++) {

            /**
             * 3. R을 증가시키는 while 문
             **/
            while (R <s.length() && available(R)) {
                alpha[s.charAt(R) -96] ++;
                R ++;
            }
            /**
             * 5. R 을 이용한 계산 & 비교
             **/
             int length = R -L;
            max = Math.max(max, length);

            /**
             * 6. 이전 꺼는 제외
             **/
            alpha[s.charAt(L) -96] --;
        }
        System.out.println(max);
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
