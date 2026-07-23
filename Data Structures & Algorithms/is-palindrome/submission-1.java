class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        str = str.replaceAll("[^a-zA-Z0-9]", "");

        int i = 0;
        int j = str.length() - 1;

        while (i <= j) {
            char a = str.charAt(i);
            char b = str.charAt(j);

            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
