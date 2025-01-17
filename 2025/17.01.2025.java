class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int allXor = 0;
        for(int i : derived) allXor ^= i;
        return allXor == 0;
    }
}
