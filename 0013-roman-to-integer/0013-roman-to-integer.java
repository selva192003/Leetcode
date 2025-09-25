class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map= new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int sum=0;
        // int sum1=0;
        for(int i=0;i<s.length()-1;i++)
        {
            char ch= s.charAt(i);
            char ch1=s.charAt(i+1);
            if(map.get(ch)<map.get(ch1))
            {
                sum -= map.get(ch);
            }
            else{
                sum += map.get(ch);
            }
        }
        return sum+ map.get(s.charAt(s.length()-1));
        // return sum-sum1+ map.get(s.charAt(s.length()-1));
    }
}