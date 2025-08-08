import java.util.HashMap;
import java.util.Map;

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> ans = new HashMap<>();
        for (int num : nums) {
            ans.put(num, ans.getOrDefault(num, 0) + 1);
        }

        int singleNum = 0; 
        for (Map.Entry<Integer, Integer> entry : ans.entrySet()) {
            if (entry.getValue() == 1) {
                singleNum = entry.getKey(); 
                break; 
            }
        }
        
        return singleNum;
    }
}