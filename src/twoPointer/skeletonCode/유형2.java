package twoPointer.skeletonCode;
/**
 * 키워드 : 두 수의 합, 두 수의 차이, 두 수....
 * */

/**
 * 로직
 *
 * 1. L 과 R 을 생성
 * 2. target 보다 작다면 L을 이동 크다면 R 을 이동
 * 3. 같다면 break;
 * */

/**
 *
 * 유의 사항
 * : L < R
 * */
public class 유형2 {
    static int N;
    static int[] a = new int[N +1];
    static int target;
    static void twoPointer () {
        int L = 0; int R = N -1;

        while (L < R) {
            int sum = a[L] + a[R];

            if (sum < target) {
                L -= 1;
            } else if (sum > target) {
                R += 1;
            } else {
                // 같다면 저장
                break;
            }
        }
    }
}
