class Solution {
    public boolean hasAlternatingBits(int n) {
        while(n>0){
            int lastBit = n & 1;
            n = n >> 1;
            int nextBit = n & 1;

            if (lastBit == nextBit) // agar side wala bit same 
            return false;
        }
        return true;
    }
}