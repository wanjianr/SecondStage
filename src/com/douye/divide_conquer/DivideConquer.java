package com.douye.divide_conquer;

import com.douye.dynamic_programming.MaxSubArray;
import com.douye.tools.Times;

public class DivideConquer {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        DivideConquer divideConquer = new DivideConquer();
        MaxSubArray maxSubArray = new MaxSubArray();
        Times.test("maxSubArray1", new Times.Task() {
            @Override
            public void execute() {
                int maxSubArray1 = divideConquer.maxSubArray1(nums);
                System.out.println(maxSubArray1);
            }
        });
        Times.test("maxSubArray2", new Times.Task() {
            @Override
            public void execute() {
                int maxSubArray2 = divideConquer.maxSubArray2(nums);
                System.out.println(maxSubArray2);
            }
        });

        Times.test("maxSubArray3", new Times.Task() {
            @Override
            public void execute() {
                int maxSubArray3 = divideConquer.maxSubArray3(nums);
                System.out.println(maxSubArray3);
            }
        });
        Times.test("maxSubArray", new Times.Task() {
            @Override
            public void execute() {
                int maxSubArray1 = maxSubArray.maxSubArray(nums);
                System.out.println(maxSubArray1);
            }
        });
    }

    public int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < nums.length; begin++) {
            for (int end = 0; end < nums.length; end++) {
                int sum = 0;
                for (int i = begin; i < end; i++) {
                    sum += nums[i];
                }
                max = Math.max(sum,max);
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < nums.length; begin++) {
            int sum = 0;
            for (int end = begin; end < nums.length; end++) {
                sum += nums[end];
                max = Math.max(sum,max);
            }
        }
        return max;
    }

    public int maxSubArray3(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        return maxSubArray3(nums,0,nums.length);
    }

    private int maxSubArray3(int[] nums, int begin, int end) {
        if (end - begin < 2) return nums[begin];
        int mid = (end + begin) >> 1;
        int leftMax = nums[mid-1];
        int leftSum = leftMax;
        for (int i = mid-2; i >= begin; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax,leftSum);
        }

        int rightMax = nums[mid];
        int rightSum = rightMax;
        for (int i = mid+1; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax,rightSum);
        }
        return Math.max(leftMax + rightMax,
                Math.max(maxSubArray3(nums,begin,mid),
                        maxSubArray3(nums,mid,end)));
    }
}
