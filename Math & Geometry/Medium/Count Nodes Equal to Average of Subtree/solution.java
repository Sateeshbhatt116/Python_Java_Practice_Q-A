class Solution {
    private int count = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }

    // returns {sum, nodeCount} of the subtree rooted at node
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int sum = left[0] + right[0] + node.val;
        int nodeCount = left[1] + right[1] + 1;

        if (sum / nodeCount == node.val) {
            count++;
        }

        return new int[]{sum, nodeCount};
    }
}