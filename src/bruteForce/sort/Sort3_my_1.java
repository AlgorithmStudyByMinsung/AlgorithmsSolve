package bruteForce.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sort3_my_1 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static long[] numbers;
    static void input() {
        N = scan.nextInt();
        numbers = new long[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = scan.nextLong();
        }
    }
    static void sorting(){
        /**
         * 정렬 후
         * 앞 뒤가 같다면 +1
         * 최빈값과 현재 횟 수를 비교한다.
         **/
        Arrays.sort(numbers);

        int currentCnt=1;
        int maxCnt= 1;
        long ans = numbers[0];

        for (int i = 1; i < N; i++) {
            if (numbers[i-1] == numbers[i]) {
                currentCnt++;

            } else currentCnt = 1;

            if (currentCnt > maxCnt) {
                maxCnt = currentCnt;
                ans = numbers[i];
            }
        }

        System.out.println(ans);
    }
    public static void main(String[] args) {
        input();

        sorting();
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
