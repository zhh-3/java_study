package cha;
import java.util.Scanner;

public class nixushu {
	public static void main(String[] args) {
		int n;
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	int[] nums = new int[n];
    	for(int i=0;i<n;i++) {
    		nums[i] = sc.nextInt();
    	}
    	
		System.out.println(reversePairs(nums));
	}


    public static int reversePairs(int[] nums) {
    	
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int[] temp = new int[len];
        return reversePairs(nums, 0, len - 1, temp);
    }
    private static int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = (left + right)/2;

        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        int reversePairs = leftPairs + rightPairs;
        if (nums[mid] <= nums[mid + 1]) {
            return reversePairs;
        }

        int reverseCrossPairs = mergeAndCount(nums, left, mid, right, temp);
        return reversePairs + reverseCrossPairs;

    }

    private static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        int res = 0;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                nums[k] = temp[j];
                j++;
            } else if (j > right) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                res += (mid - i + 1);
            }
        }
        return res;
    }
}