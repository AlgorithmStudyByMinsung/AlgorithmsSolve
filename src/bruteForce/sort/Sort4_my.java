package bruteForce.sort;
// https://www.acmicpc.net/problem/15970
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sort4_my {
    static class Elem implements Comparable<Elem>{
         int pos;
         int color;

        @Override
        public int compareTo(Elem o) {
            if (o.color != color) return color - o.color;
            return pos - o.pos;
        }

        @Override
        public String toString() {
            return "Elem{" +
                    "pos=" + pos +
                    ", color=" + color +
                    '}';
        }
    }
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static Elem[] elems;
    static int sum;

    static void input() {
        N = scan.nextInt();
        elems = new Elem[N+2];

        for (int i = 1; i <=N ; i++) {
            elems[i] = new Elem();

            elems[i].pos = scan.nextInt();
            elems[i].color = scan.nextInt();
        }
    }
    static void sorting() {
        Arrays.sort(elems,1,N+1);

        for (int i = 1; i <=N ; i++) {
            Elem left = elems[i-1];
            Elem right = elems[i+1];
            Elem current = elems[i];

            if (left == null) sum += (right.pos - current.pos);
            else if (right == null) sum += (current.pos - left.pos);
            else {
                int leftValue;
                int rightValue;

                leftValue = left.color == current.color ? Math.abs(current.pos - left.pos) : Integer.MAX_VALUE;
                rightValue = right.color == current.color ? Math.abs(current.pos - right.pos) : Integer.MAX_VALUE;

                sum += Integer.min(leftValue, rightValue);
            }
        }
    }
    public static void main(String[] args) {
        input();
        sorting();

        System.out.println(sum);

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
