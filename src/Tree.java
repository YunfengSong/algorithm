
import java.util.*;



public class Tree {

    private TreeNode root;

    /**
     * 插入值到二叉树中
     * @param value
     */
    public void insert(int value){
        TreeNode node = new TreeNode(value);
        TreeNode curr = root;
        TreeNode parent;
        if (root == null){
            root = new TreeNode(value);
            return;
        }
        while (true){
            parent = curr;
            if (curr.data > value){
                curr = curr.leftNode;
                if (curr == null){
                    parent.leftNode = node;
                    return;
                }
            }else {
                curr = curr.RightNode;
                if (curr == null){
                    parent.RightNode = node;
                    return;
                }
            }
        }
    }

    /**
     * 查找指定值的树节点
     * @param value
     * @return
     */

    public TreeNode findNode(int value){

        TreeNode curr = root;
        while (curr.data != value){
            if (curr.data > value){
                curr = curr.leftNode;
            }else curr = curr.RightNode;
        }
        if (curr == null)return null;
        return new TreeNode(curr.data);
    }

    /**
     * 前序遍历（递归）
     * @param node
     */
    public void preOrder(TreeNode node){
        if (node != null){
            System.out.println(node.data);
            preOrder(node.leftNode);
            preOrder(node.RightNode);
        }
    }

    /**
     * 前序遍历（非递归）
     * @param node
     */
    public void preOrder1(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()){
            while (node != null){
                System.out.println(node.data);
                stack.push(node);
                node = node.leftNode;
            }
            if (!stack.empty()){
                node = stack.pop();
                node = node.RightNode;
            }
        }
    }
    /**
     * 中序遍历（递归）
     * @param node
     */
    public void midOrder(TreeNode node){
        if (node != null){
            midOrder(node.leftNode);
            System.out.println(node.data);
            midOrder(node.RightNode);
        }
    }

    /**
     * 中序遍历（非递归）
     * @param node
     */
    public void midOrder1(TreeNode node){

        Stack<TreeNode> stack = new Stack<>();
        while ( node != null || !stack.empty()){
            while ( node != null){
                stack.push(node);
                node = node.leftNode;
            }
            if (!stack.empty()){
                node = stack.pop();
                System.out.println(node.data);
                node = node.RightNode;
            }
        }
    }
    /**
     * 后序遍历
     * @param node
     */
    public void posOrder(TreeNode node){
        if (node != null){
            posOrder(node.leftNode);
            posOrder(node.RightNode);
            System.out.println(node.data);
        }
    }

    /**
     * 后序遍历（非递归）
     * @param node
     */
    public void posOrder1(TreeNode node){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (node != null || !stack1.empty()){
            while ( node != null){
                stack1.push(node);
                stack2.push(0);
                node = node.leftNode;
            }
            while (!stack1.empty() && stack2.peek() == 1){
                stack2.pop();
                System.out.println(stack1.pop().data);
            }
            if (!stack1.empty()){
                stack2.pop();
                stack2.push(1);
                node = stack1.peek();
                node = node.RightNode;
            }
        }
    }

    /**
     * 后序遍历（非递归）
     * 前序遍历  根--左--右
     * 后序遍历  左--右--根
     * 借用前序遍历算法思想 修改成 根--右--左，然后反转得到  左--右--根
     * @param node
     * @return
     */
    public ArrayList<Integer> posOrder2(TreeNode node){
        ArrayList<Integer> list = new ArrayList<>();
        if (node != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(node);
            while (!stack.empty()){
                TreeNode node1 = stack.pop();
                list.add(node1.data);
                if (node1.leftNode != null) stack.push(node1.leftNode);
                if (node1.RightNode != null)stack.push(node1.RightNode);
            }
            Collections.reverse(list);
        }
        return list;
    }
    /**
     * 层序遍历（递归）
     * @param node
     */
    public void levelOrder(TreeNode node){
        if (node == null)return;
        //计算深度
        int depth = depth(node);
        for(int i = 0;i< depth;i++){
            //根据第几层得到所处第几层的所有元素
            leveOrder(node,i);
        }
    }

    /**
     * 层序遍历（非递归）
     * @param node
     */
    public void levelOrder1(TreeNode node){

        if (node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        TreeNode node1;
        while (!queue.isEmpty()){
            node1 = queue.poll();
            System.out.println(node1.data);
            if (node1.leftNode != null)queue.offer(node1.leftNode);
            if (node1.RightNode != null)queue.offer(node1.RightNode);
        }
    }

    /**
     * 得到第几层的所有元素
     * @param node
     * @param level
     */
    public void leveOrder(TreeNode node,int level){

        if (node == null || level < 1)return;
        if ( level == 1){
            System.out.println(node.data);
            return;
        }
        leveOrder(node.leftNode,level - 1);
        leveOrder(node.RightNode,level - 1);
    }

    /**
     * 二叉树的深度
     * @param node
     * @return
     */
    public int depth(TreeNode node){
        if (node == null)
            return 0;
        int l = depth(node.leftNode);
        int r = depth(node.RightNode);
        if (l > r) return l + 1;
        else return r + 1;
    }

    /**
     * 通过层序遍历构建二叉树
     * @param str 层序遍历的任意参数
     * @return 二叉树
     */
    TreeNode buildTreeByLevelOrder(String str){
        String[] nodeArr = str.split(",");
        List<TreeNode> nodelist = new LinkedList<>();
        for (String s : nodeArr) {
            nodelist.add(new TreeNode(Integer.valueOf(s)));
        }
        System.out.println(nodelist.size());
        for(int index=0;index < nodelist.size()/2-1;index++){
            //编号为n的节点他的左子节点编号为2*n 右子节点编号为2*n+1 但是因为list从0开始编号，所以还要+1
            //这里父节点有1（2,3）,2（4,5）,3（6,7）,4（8,9） 但是最后一个父节点有可能没有右子节点 需要单独处理
            nodelist.get(index).leftNode = (nodelist.get(index*2+1));
            nodelist.get(index).RightNode = (nodelist.get(index*2+2));
        }
        //单独处理最后一个父节点 因为它有可能没有右子节点
        int index = nodelist.size()/2-1;
        nodelist.get(index).leftNode = (nodelist.get(index*2+1)); //先设置左子节点
        if(nodelist.size() % 2 == 1){ //如果有奇数个节点，最后一个父节点才有右子节点
            nodelist.get(index).RightNode = (nodelist.get(index*2+2));
        }
        return nodelist.get(0);
    }

    /**
     * 根据前序遍历还原二叉树
     * (在前序序列化的时候，如果遇到为null的节点，则在字符串后面添加“#，”
     当反序列化时，会进行判断，当前的位置是否为"#"，如果为#则不会创建子节点)
     */
    int index = -1;
    TreeNode Deserialize(String str) {
        if(str.length() == 0)
            return null;
        index++;
        int len = str.length();
        if(index >= len){
            return null;
        }
        String[] strr = str.split(",");
        TreeNode node = null;
        if(!strr[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.leftNode = Deserialize(str);
            node.RightNode = Deserialize(str);
        }

        return node;
    }


    /**
     * 反转二叉树
     * 或者
     * 建立一颗二叉树的镜像（如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。）
     * @param root
     */
    public void Mirror(TreeNode root) {
        if(root == null) {
            return;
        }
        if((root.leftNode == null) && (root.RightNode == null)) {
            return;
        }
        TreeNode temp = root.leftNode;
        root.leftNode = root.RightNode;
        root.RightNode = temp;
        Mirror(root.leftNode);
        Mirror(root.RightNode);
    }


    /**
     * 克隆一颗二叉树
     * @param root
     * @return
     */
    public static TreeNode cloneTree(TreeNode root){
        TreeNode node=null;
        if(root==null) return null;
        node = new TreeNode(root.data);
        node.leftNode = cloneTree(root.leftNode);
        node.RightNode = cloneTree(root.RightNode);
        return node;
    }


    /**
     * 判断两颗二叉树是否相同
     * @param root1
     * @param root2
     * @return
     */
    public boolean sameTree2(TreeNode root1, TreeNode root2){
        //树的结构不一样
        if((root1 == null && root2 != null) || (root1 != null && root2 == null))
            return false;
        //两棵树最终递归到终点时
        if(root1 == null && root2 == null)
            return true;
        if(Integer.valueOf(root1.data).compareTo(Integer.valueOf(root2.data)) != 0)
            return false;
        else
            return sameTree2(root1.leftNode, root2.leftNode) && sameTree2(root1.RightNode, root2.RightNode);
    }


    /**
     * 求公共父节点
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.leftNode, p, q);
        TreeNode right = lowestCommonAncestor(root.RightNode, p, q);
        return left == null ? right : (right == null ? left : root);
    }

    /**
     * 验证是否是二叉搜索树
     * @param
     * @param
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root , Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root , int min , int max) {
        if(root == null)
            return true;
        if(root.data <= min || root.data >= max)
            return false;
        return isValidBST(root , min , root.data)
                && isValidBST(root , root.data , max);
    }



    static  class TreeNode {
        int data;
        TreeNode leftNode;
        TreeNode RightNode;

        TreeNode(int x) {
            data = x;
        }
    }


}