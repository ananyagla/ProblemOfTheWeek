import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubArraySumEqualsK {

    public int SubArray(int[] arr, int k) {
        int res = 0;
        int curr = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // For the case when subarray sum equals k starting from index 0

        for (int i : arr) {
            curr += i;
            res += map.getOrDefault(curr - k, 0);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the value of k:");
        int k = sc.nextInt();

        SubArraySumEqualsK obj = new SubArraySumEqualsK();
        int result = obj.SubArray(arr, k);

        System.out.println("Number of subarrays with sum = " + k + " : " + result);

        sc.close();
    }
}

