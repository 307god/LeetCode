public class Solution {
    public int[] twoSum(int[] nums, int target) {
        //build hash table by array
        int max = Integer.MIN_VALUE;//Integer.MIN_VALUE只是一个初始值，无实际意义
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
            if (min > num) {
                min = num;
            }
        }
        if (min > target) {
            min = target;
        }
        if (max < target) {
            max = target;
        }
        //之前都是为了确定所有数据的最大值和最小值，确定一个精确的范围
        int start = min - max;
        int len = max - start + 1;
        //len表示我们需要建立的数组的长度

        int[] table = new int[len];
        Arrays.fill(table, Integer.MIN_VALUE);//数组数值初始化

        for (int i = 0; i < nums.length; i++) {
            int idx = nums[i] - start;
            int v = table[idx];
            if (v != Integer.MIN_VALUE && v != i) {
                return new int[] {v, i};
            }
            table[target - nums[i] - start] = i;
            //对于每个数据都会存放进去，存放方式为将下标为对应的数据的数组值
            //通过数值的比较，一旦符合要求即返回所需数组
        }
        return new int[] {0, 0};
    }
}