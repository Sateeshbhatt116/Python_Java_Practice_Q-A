class Solution {
    public boolean isPalindrome(String s) {

        String s1 = "";

        for (int i = 0; i < s.length(); i++) {

            char ch = Character.toLowerCase(s.charAt(i));

            if ((ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9')) {

                s1 = s1 + ch;
            }
        }

        String rev = "";

        for (int i = 0; i < s1.length(); i++) {
            rev = s1.charAt(i) + rev;
        }

        if (s1.equals(rev)) {
            return true;
        }
        else {
            return false;
        }
    }
}