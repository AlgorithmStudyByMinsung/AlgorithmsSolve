package parametricSearch;
// https://www.acmicpc.net/problem/2805
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 1. 자료형을 항상 먼저 생각 --> 시간 복잡도를 셍각
 * 2. 이분 탐색 = 근사치, 특정 값보다 큰 것중에 최솟값, 같은 값 등등 이런 것들을 구할 수가 있다.
 * 3. ~의 최대값 == 이분 탐색을 고려!
 * 큰 것중에 가장 오른쪽 값
 * 
 * 정의 : 정답을 파라미터로 받아 이분 탐색을 한다.
 **/
public class One_my_1 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int M;
    static int[] a;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        a = new int[N +1];
        for (int i = 1; i <=N ; i++) {
            a[i] = scan.nextInt();
        }
    }

    static long sum(int h) {
        long sum = 0;

        for (int i = 1; i <= N ; i++) {
            if (a[i] > h) sum += a[i] - h;
        }
        return sum;
    }

    static void pro(){
        Arrays.sort(a, 1, N+1);

        int L = 0;
        int R = a[N];

        int res = R +1;

        while (L <= R) {
            int mid = (L + R)/2;

            if (M <= sum(mid)) {
                res = mid;
                L = mid +1;
            } else {
                R = mid -1;
            }
        }
        System.out.println(res);
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
