class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // rec[0]=x1, rec[1]=y1, rec[2]=x2, rec[3]=y2

        boolean noOverlap = rec1[2] <= rec2[0]   // rec1 is entirely to the left of rec2
                          || rec2[2] <= rec1[0]   // rec2 is entirely to the left of rec1
                          || rec1[3] <= rec2[1]   // rec1 is entirely below rec2
                          || rec2[3] <= rec1[1];  // rec2 is entirely below rec1

        return !noOverlap;
    }
}