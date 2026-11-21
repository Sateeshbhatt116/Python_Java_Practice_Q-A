import java.util.Arrays;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        // adjacency of the original tree (linked-list style)
        int[] head = new int[n];
        int[] next = new int[n];
        Arrays.fill(head, -1);
        for (int i = 1; i < n; i++) {
            next[i] = head[parent[i]];
            head[parent[i]] = i;
        }

        int[] last = new int[26];      // nearest ancestor on the current path per letter
        Arrays.fill(last, -1);
        int[] saved = new int[n];      // previous last[c] to restore when leaving a node
        int[] newParent = new int[n];
        int[] order = new int[n];      // preorder of the original tree
        int count = 0;

        int[] it = head.clone();       // next unvisited child of each node
        int[] stack = new int[n];
        int top = 0;

        // enter root
        int rootChar = s.charAt(0) - 'a';
        saved[0] = last[rootChar];
        last[rootChar] = 0;
        newParent[0] = -1;
        order[count++] = 0;
        stack[top++] = 0;

        while (top > 0) {
            int x = stack[top - 1];
            if (it[x] != -1) {
                int child = it[x];
                it[x] = next[child];

                int c = s.charAt(child) - 'a';
                newParent[child] = (last[c] != -1) ? last[c] : parent[child];
                saved[child] = last[c];
                last[c] = child;

                order[count++] = child;
                stack[top++] = child;
            } else {
                last[s.charAt(x) - 'a'] = saved[x];
                top--;
            }
        }

        // a node's new parent is an original ancestor, so it appears earlier in preorder;
        // going in reverse preorder finishes every node before its new parent
        int[] size = new int[n];
        Arrays.fill(size, 1);
        for (int t = n - 1; t > 0; t--) {
            int v = order[t];
            size[newParent[v]] += size[v];
        }

        return size;
    }
}