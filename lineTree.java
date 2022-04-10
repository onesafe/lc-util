public class lineTree {

    static class TreeNode{
        public int sum;
        public int start, end;
        public TreeNode left, right;
        public TreeNode(int start, int end){
            this.start = start;
            this.end   = end;
        }
    }
    TreeNode root = null;

    public lineTree(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    public void update(int index, int val) {
        update(root, index, val);
    }

    public int sumRange(int left, int right) {
        return query(root, left, right);
    }

    private int query(TreeNode root, int left, int right){
        if(root.start == left && root.end == right)
            return root.sum;
        else{
            int mid = root.start + (root.end - root.start) / 2;

            if(right <= mid)
                return query(root.left, left, right);
            else if(left > mid)
                return query(root.right, left, right);
            else
                return query(root.left, left, mid) + query(root.right, mid + 1, right);
        }
    }

    private void update(TreeNode root, int index, int val){
        if(root.start == root.end){
            root.sum = val;
        }else{
            int mid = root.start + (root.end - root.start) / 2;

            if(index <= mid)
                update(root.left, index, val);
            else
                update(root.right, index, val);

            root.sum = root.left.sum + root.right.sum;
        }
    }

    private TreeNode buildTree(int[] nums, int start, int end){
        if(start > end)
            return null;
        else if(start == end){
            TreeNode node = new TreeNode(start, end);
            node.sum      = nums[start];
            return node;
        }else{
            TreeNode node = new TreeNode(start, end);
            int mid = start + (end - start) / 2;

            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid + 1, end);

            node.sum  = node.left.sum + node.right.sum;
            return node;
        }
    }
}
