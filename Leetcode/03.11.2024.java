class Solution {
    public boolean rotateString(String s, String goal) {
        int i = 0;
        String temp = s;
        while (i < s.length()){
            temp = temp.substring(s.length()-1) + temp.substring(0, s.length()-1);
            if(temp.equals(goal)){
                return true;
            }
            i++;
        }
        return false;
    }
}
