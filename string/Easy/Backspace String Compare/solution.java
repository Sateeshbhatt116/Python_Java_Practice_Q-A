
class Solution {
    public boolean backspaceCompare(String s, String t) {
        String processedS = process(s);
        String processedT = process(t);
        return processedS.equals(processedT);
    }
    private String process(String str) {
        String result = "";

        for (char c : str.toCharArray()) {
            if (c != '#') {
                result = result + c;
            } else {
              
                if (result.length() > 0) {
                    result = result.substring(0, result.length() - 1);
                }
            }
        }

        return result;
    }
}
