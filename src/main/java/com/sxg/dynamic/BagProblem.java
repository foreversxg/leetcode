package com.sxg.dynamic;

/**
 * 01背包问题
 *
 * @author sxg create in 2022/2/17
 */
public class BagProblem {

  public static void main(String[] args) {
//    System.out.println(exe(new int[]{1, 2, 3}));
    System.out.println(exe(new int[]{8, 2, 4}));
  }

  private static boolean exe(int[] nums) {
    int sum = 0;
    for (int n : nums) {
      sum += n;
    }
    if ((sum & 1) != 0) {
      return false;
    }
    int target = sum >> 1;
    boolean[][] dp = new boolean[nums.length + 1][target + 1];
    dp[0][0] = true;
    for (int i = 1; i <= nums.length; i++) {
      for (int j = 0; j <= target; j++) {
        dp[i][j] = dp[i - 1][j]; // todo  dp[i - 1][j]满足则dp[i][j]肯定满足
        if (!dp[i - 1][j] && j >= nums[i - 1]) {
          dp[i][j] = dp[i - 1][j - nums[i - 1]];
        }
      }
    }
    return dp[nums.length][target];
  }
}
