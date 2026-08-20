class Solution {
    public int numSpecial(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    boolean rowOK = true;
                    boolean colOK = true;
                    for (int k = 0; k < cols; k++) {
                    if (k != j && mat[i][k] == 1) {
                            rowOK = false;
                            break;
                        }
                    }

                   
                    for (int k = 0; k < rows; k++) {


                        if (k != i && mat[k][j] == 1) {
                            colOK = false;
                            break;
                        }
                    }
                    if (rowOK && colOK) {
                        count++;
                    }
                }
            }
        }


        return count;
    }
}

