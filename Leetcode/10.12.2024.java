class Solution {
    public int maximumLength(String s) {
    int count = 0, last = s.charAt(0), ans = 0;
    Map<Character, List<Integer>> ump = new HashMap<>(); // this store the cont. occurance counts against each character
    for(char c: s.toCharArray()){            // compute all the cont. char count and add it to the corresponding char in the map
        if(c == last) count++;
        else{
            if(!ump.containsKey((char)last)) ump.put((char)last, new ArrayList<>());
            ump.get((char)last).add(count);
            count = 1;  last = c;
        }
    }
    if (!ump.containsKey((char) last)) ump.put((char) last, new ArrayList<>());
    ump.get((char) last).add(count);
    
    for(Map.Entry<Character,List<Integer>> entry: ump.entrySet()){  // For each char evaluate the max 3 occuarance count and check for possible max triplate count        
        int l1 = 0, l2 = 0, l3 = 0;
        for(int e: entry.getValue()){
            if(l1 < e) { l3 = l2; l2 = l1; l1 = e; }
            else if(l2 < e) { l3 = l2; l2 = e; }
            else if(l3 < e) { l3 = e; }
        }
        if(l1 == l2 && l1 > l3) l2--;      // This is to handle the case when the largest 3 occurances are 2, 2, 1
        if(l1 + l2 + l3 >= 3) ans = Math.max(ans, Math.max(l1 - 2, l2) );  //max triplet can be either largest - 2 or the second largest
    }
    return ans != 0?ans: -1;               // if ans is zero return -1 otherwise return ans.
}
}
