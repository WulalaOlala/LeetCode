//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三
//元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
    public static void main(String[] args){
        Solution solution = new ThreeSum().new Solution();
        solution.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
    

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultArray = new ArrayList<>();
//        //1.暴力求解
//        for(int i = 0; i < nums.length -2; i++){
//            if(i > 0 && nums[i] == nums[i-1]) continue;
//            for(int j = i+1; j < nums.length -1; j++){
//                if(j > i+1 && nums[j] == nums[j-1]) continue;
//                for(int k = j+1; k < nums.length ; k++){
//                    if(k > j+1 && nums[k] == nums[k-1]) continue;
//                    if(nums[i]+nums[j]+nums[k] == 0){
//                        List<Integer> result = new ArrayList<>();
//                        result.add(nums[i]);
//                        result.add(nums[j]);
//                        result.add(nums[k]);
//                        resultArray.add(result);
//                    }
//                }
//            }
//        }
        //2.双指针
        for(int k =0 ; k < nums.length-2; k++){
            if(nums[k] > 0) break;
            if(k>0 && nums[k] == nums[k-1]) continue;
            for(int i=k+1, j = nums.length-1; i < j;){
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[k]);
                    result.add(nums[i]);
                    result.add(nums[j]);
                    resultArray.add(result);
                    while(i < j && nums[++i] == nums[i-1]);
                }else if(nums[i] + nums[j] + nums[k] < 0){
                    while(i < j && nums[++i] == nums[i-1]);
                }else{
                    while(i < j && nums[--j] == nums[j+1]);
                }
            }
        }
        return  resultArray;

        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
