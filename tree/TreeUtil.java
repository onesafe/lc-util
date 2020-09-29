package tree;

import java.util.*;

public class TreeUtil {

    /**
     * 非递归二叉树后续遍历
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) return res;

        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode node = root;
        while (!s.isEmpty() || null != node) {
            if (null != node) {
                s.push(node);
                res.add(node.val);
                node = node.right;
            } else {
                node = s.pop();
                node = node.left;
            }
        }
        Collections.reverse(res);
        return res;
    }
}
