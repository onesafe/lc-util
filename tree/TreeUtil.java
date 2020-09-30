package tree;

import java.util.*;

public class TreeUtil {

    /**
     * 二叉搜索树插入节点
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode insertNode = new TreeNode(val);
        if (null == root) return insertNode;
        TreeNode res = root;

        while (insertNode != root) {
            if (root.val < insertNode.val) {
                if (null == root.right) {
                    root.right = insertNode;
                }
                root = root.right;
            } else {
                if (null == root.left) {
                    root.left = insertNode;
                }
                root = root.left;
            }
        }
        return res;
    }

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
