package binarySearch;
// https://www.acmicpc.net/problem/2470

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 특징)
 * 1. 하나의 배열에서 중복 x, 순서 x -->   binarySearch(a, i +1, N, -a[i]);
 *
 * 2. 근사치를 찾는 문제 --> 크거나 같다 기준으로 탐색
 *                  --> 없다면 R +1 을 return
 *                  --> return 값인 res 와 res -1 둘중에 하나가 정답
 *                  --> 대신 res 의 범위를 설정 해줘야한다.
 *                              --> 1. res <= n
 *                              --> 2. res -1 > left
 **/
public class Binary_2 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();



    static int N;
    static int[] a;

    static void input() {
        N = scan.nextInt();
        a= new int[N+1];

        for (int i = 1; i <=N ; i++) {
            a[i] = scan.nextInt();
        }
    }
    /**
     * 근사치를 구하는 이분탐색
     * res 나 res -1 를 확인하면 둘 중하나가 근사치
     **/
    static int binarySearch(int[] a, int L, int R, int x) {
        int res = R +1;

        while (L <= R){
            int mid = (L + R)/2;

            if (a[mid] >= x) {
                res = mid;
                R = mid -1;
            } else {
                L = mid +1;
            }
        }
        return res;
    }
    static void pro() {
        Arrays.sort(a, 1, N+1);

        int v1 = 0;
        int v2 = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= N -1 ; i++) {
            // N 이나 N-1 상관은 없지만 N은 굳이 할 필요가 없음

            // 문제가 서로 다른 용액을 섞는 것이므로
            // 자신의 것을 포함시켜서는 안된다.
            // 또한 어차피 서로 다른 두 용액을 고르는 것이므로
            // 왼쪽 부터 차례대로 가도된다.
            int index = binarySearch(a, i +1, N, -a[i]);

            // 절댓값 과 뺀 값을 비교해서 작은 것이 정답이 된다.
            if (index <= N && Math.abs(a[i] + a[index]) < ans) {

                v1 = a[i];
                v2 = a[index];
                ans = Math.abs(a[i] + a[index]);
            }

            if (i < index -1 && Math.abs(a[i] + a[index-1]) < ans) {
                v1 = a[i];
                v2 = a[index -1];
                ans = Math.abs(a[i] + a[index -1]);
            }
        }

        sb.append(v1).append(' ').append(v2);
        System.out.println(sb);
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
