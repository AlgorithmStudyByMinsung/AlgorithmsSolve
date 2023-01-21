package parametricSearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int C;
    static int[] a;
    static int ans;

    static void input() {
        N = scan.nextInt();
        C = scan.nextInt();
        a = new int[N +1];

        for (int i = 1; i <= N ; i++) {
            a[i] = scan.nextInt();
        }
    }

    static boolean greedy(int x) {
        // a 배열을 for 문을 돌면서
        // 1부터 시작
        // current 변수 필요
        // 횟수 변수 필요 C 에 도달하면 종료
        // 다 돌았는데 C 보다 작으면 false 를 리턴

        int current = a[1];
//        int current = 1; --> 처음에 이렇게 해서 틀렸었음!!
        int cnt = 1;

        for (int i = 2; i <=N ; i++) {
            if (a[i] >= x + current) {
                current = a[i];
                cnt +=1;

                if (cnt == C) return true;
            }
        }
        return false;
    }

    static void parametricSearch(){
        int L = 1;
        int R = a[a.length -1] -1;
        int res = 0;

        while (L <= R) {
            int mid = (L + R)/2;

            if (greedy(mid)) {
                res = mid;
                L = mid+1;
            }else {
                R = mid -1;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(a, 1, N+1);

        parametricSearch();

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
