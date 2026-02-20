class Solution {
    public String makeLargestSpecial(String s) {
        if (s.length() == 0) {
            return s;
        }
        
        List<String> mountains = new ArrayList<>();
        int count = 0;
        int start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            count += (s.charAt(i) == '1') ? 1 : -1;
            
            if (count == 0) {
                String mountain = "1" + makeLargestSpecial(s.substring(start + 1, i)) + "0";
                mountains.add(mountain);
                start = i + 1;
            }
        }
        
        Collections.sort(mountains, Collections.reverseOrder());
        
        StringBuilder result = new StringBuilder();
        for (String mountain : mountains) {
            result.append(mountain);
        }
        
        return result.toString();
    }
}