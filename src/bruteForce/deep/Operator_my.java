package bruteForce.deep;


import java.io.*;
import java.util.StringTokenizer;

public class Operator_my {
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();

        N = scan.nextInt();

        numbers = new int[N+1];
        operators = new int[4];

        for (int i = 1; i <=N ; i++) numbers[i] = scan.nextInt();
        for (int i = 0; i < 4; i++) operators[i] = scan.nextInt();

    }

    static int N;
    static int[] numbers;
    static int[] operators;
    /**
     * static int max = Integer.MIN_VALUE;;
     *  static int min=Integer.MAX_VALUE; --> 이 설정을 꼭 해줘야함
     **/
    static int max = Integer.MIN_VALUE;
    static int min=Integer.MAX_VALUE;
    static int calculation(int k, int operator, int num){
        int number = numbers[k + 1];

        if (operator == 0) {

            operators[operator] -=1;
            return num + number;
        } else if (operator == 1){

            operators[operator] -=1;
            return num - number;
        } else if (operator ==2){

            operators[operator] -=1;
            return num * number;
        }
        else {

            operators[operator] -=1;
            return num / number;
        }
    }
    static void rec_func(int k, int num) {
        if (k == N) {
            /**
             * 여기도 팁
             **/
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for (int i = 0; i <4; i++) {
            // 연산자가 없다면 continue
            if (operators[i] == 0) continue;
            // 인덱스와 숫자를 통해서 계산을 해줘야함
            rec_func(k+1, calculation(k, i, num));
            /**
             * 재귀가 끝나면 올려준다.
             **/
            operators[i]+=1;
        }
    }
    public static void main(String[] args) {
        input();

        rec_func(1, numbers[1]);

        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
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
