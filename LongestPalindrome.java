//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome{
    public static void main(String[] args){
        Solution solution = new LongestPalindrome().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
//        Map<Character, Integer> cMap = new HashMap<>();
//        for(int i = 0 ; i < s.length(); i++){
//            Character c = s.charAt(i);
//            if(cMap.containsKey(c)){
//                cMap.put(c,cMap.get(c)+1);
//            }else{
//                cMap.put(c,1);
//            }
//        }
//        int count = 0;
//        int hasOdd = 0;
//        for (Integer v: cMap.values()
//             ) {
//            if(v%2 == 0){count += v;}
//            else{
//                hasOdd = 1;
//                count += v-1;
//            }
//        }
//        return count+ hasOdd;

        int[] counter = new int[128];
        for(int i = 0; i < s.length(); i++){
            counter[s.charAt(i)]++;
        }
        int result = 0;
        for(int i = 0; i < 128; i++){
            result +=  (counter[i]/2)*2;
        }
        if(!(result == s.length())) result +=1;
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
