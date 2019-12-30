package leetcode.editor.cn;//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1,0,nums1Copy,0,m);
        int posNum1 = 0, posNumCopy = 0 , posNum2 = 0;
        while(posNum1 < m+n && posNumCopy < m && posNum2 < n){
            nums1[posNum1++] = (nums1Copy[posNumCopy] < nums2[posNum2]) ? nums1Copy[posNumCopy++] : nums2[posNum2++];
        }
        if(posNumCopy < m){
            System.arraycopy(nums1Copy,posNumCopy,nums1,posNum1,m-posNumCopy);
        }
        if(posNum2 < n){
            System.arraycopy(nums2,posNum2,nums1,posNum1,n-posNum2);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
