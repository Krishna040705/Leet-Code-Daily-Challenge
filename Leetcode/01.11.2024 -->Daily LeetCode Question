
//After many days Leetcode has given an Easy Question...It feels good 
class Solution {
    public String makeFancyString(String str) {
        //return notsooptimized(str);
        return optimal(str);
    }

    private String optimal(String str) {
        StringBuilder sb = new StringBuilder(str);
        int f = 0;
        int s = 1;
        int t = 2;

        if (str.length() < 3) return str;
        while (t < sb.length()) {
            char atf = sb.charAt(f);
            char atb = sb.charAt(s);
            char att = sb.charAt(t);

            if (atf == atb && atf == att) {
                int ptr = t+1;
                while (ptr < sb.length() && sb.charAt(ptr) == atf) {
                    ptr += 1;
                }
                sb.delete(t, ptr);
            } else {
                f += 1;
                s += 1;
                t += 1;
            }
            
        }

        return sb.toString();
    }

    private String notsooptimized(String str) {
        StringBuilder sb = new StringBuilder(str);
        int f = 0;
        int s = 1;
        int t = 2;

        if (str.length() < 3) return str;
        while (t < sb.length()) {
            char atf = sb.charAt(f);
            char atb = sb.charAt(s);
            char att = sb.charAt(t);

            if (atf == atb && atf == att) {
                sb.deleteCharAt(t);
                
            } else {
                f += 1;
                s += 1;
                t += 1;
            }
            
        }

        return sb.toString();
    }
}
