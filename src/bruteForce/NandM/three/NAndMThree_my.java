package bruteForce.NandM.three;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15651
// 1억 에 1초가 걸린다.
public class NAndMThree_my {
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
    }
    static int N, M;

    public void rec_func(int n, int m, List<Integer> dataList) {
        if (dataList.size() == m) {

            for (Integer integer : dataList) {
                sb.append(integer).append(' ');
            }
            sb.append('\n');

            return;
        }

        for (int i = 1; i <=n ; i++) {
            dataList.add(i);
            rec_func(n, m, dataList);
            dataList.remove(dataList.size()-1);// remove 하는 과정에서 시간이 더드는 것 같다.
        }
    }

    public static void main(String[] args) {
        input();

        NAndMThree_my nAndMThree = new NAndMThree_my();
        ArrayList<Integer> arrayList = new ArrayList<>();


        nAndMThree.rec_func(N,M, arrayList);

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

