class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> v1 = new ArrayList<>();
        fun("", v1, n, 0, 0);
        return v1;
    }

    void fun(String tmp, List<String> v1, int n, int a, int b) {
        if (a > n || b > n || b > a) return;

        if (tmp.length() == 2 * n) {
            v1.add(tmp);
            return;
        }

        fun(tmp + "(", v1, n, a + 1, b);
        fun(tmp + ")", v1, n, a, b + 1);
    }
}