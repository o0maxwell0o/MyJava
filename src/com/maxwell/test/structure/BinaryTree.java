package com.maxwell.test.structure;


import java.util.*;
import java.util.List;

//二叉树的结构，创建和相关运算
//这里定义的二叉树中数值0代表空
public class BinaryTree {
    public static void main(String[] args) {
        int[] arr = {10, 5, 15, 0, 0, 6, 20};
        TreeNode root = createBinaryTreeByArray(arr, 0);
        System.out.println(isValidBST(root));
    }

    //leetcode 101 判断二叉树是不是对称的 递归
    public static boolean isSymmetricRecursion(TreeNode root) {
        return root == null || isSymmetricRecursion_check(root.left, root.right);
    }

    public static boolean isSymmetricRecursion_check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {    //左右子节点都为空
            return true;
        }
        if (left == null || right == null) {    //一边子节点为空
            return false;
        }
        if (left.val != right.val) {            //左右子节点都不为空，但值不同
            return false;
        }  //一个点>>两个点>>四个点，外侧两点比较，内侧两点比较
        return isSymmetricRecursion_check(left.right, right.left) && isSymmetricRecursion_check(left.left, right.right);
    }

    //leetcode 101 判断二叉树是不是对称的 非递归
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode left, right;
        if (root.left != null) {
            if (root.right == null) {   //根节点的右有孩子缺少
                return false;
            }
            queue.add(root.left);
            queue.add(root.right);
        } else if (root.right != null) {    //根节点的做孩子缺少
            return false;
        }
        while (!queue.isEmpty()) {
            if (queue.size() % 2 != 0) {          //一层中左右数量不对称
                return false;
            }
            left = queue.remove();
            right = queue.remove();
            if (left.val != right.val) {
                return false;
            }
            if (left.left != null) {
                if (right.right == null) {      //右子节点的右子节点不存在形成不对称
                    return false;
                }
                queue.add(left.left);
                queue.add(right.right);
            } else if (right.right != null) {
                return false;
            }
            if (left.right != null) {
                if (right.left == null) {      //右子节点的左子节点不存在形成不对称
                    return false;
                }
                queue.add(left.right);
                queue.add(right.left);
            } else if (right.left != null) {
                return false;
            }
        }
        return true;

    }

    public static boolean isSymmetric_check(int[] arr) {
        int count = arr.length;
        for (int i = 0; i < count / 2; i++) {
            if (arr[i] != arr[count - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    //leetcode 235 二叉搜索树中两个节点的最近公共祖先 非递归
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (p.val > root.val && q.val > root.val) {//两个节点都在根节点的右侧，虽然根节点是公共祖先，但其孩子节点中还有更接近的公共祖先
                root = root.right;
            } else if (p.val < root.val && q.val < root.val) {//两个节点都在根节点左侧，理由同上
                root = root.left;
            } else {//两个节点分别分别在根节点的两侧，则此时的根节点是两个节点的最近的公共祖先
                return root;
            }
        }
        return null;

    }

    //leetcode 235 二叉搜索树中两个节点的最近公共祖先 递归
    public static TreeNode lowestCommonAncestorRecursion(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestorRecursion(root.left, p, q);
        TreeNode right = lowestCommonAncestorRecursion(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;


    }

    //leetcode 257 找到有所从根节点出发至叶节点的路径
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePaths_findPath(result, root, "");
        return result;

    }

    public static void binaryTreePaths_findPath(List<String> list, TreeNode root, String str) {
        if (root == null) {
            return;
        }
        str += String.valueOf(root.val);
        if (root.left != null) {
            binaryTreePaths_findPath(list, root.left, str + "->");
        }
        if (root.right != null) {
            binaryTreePaths_findPath(list, root.right, str + "->");
        }
        if (root.left == null && root.right == null) {
            list.add(str);
        }

    }

    //leetcode 递归
    public static boolean isValidBSTRecursion(TreeNode root) {
        return isValidBST_check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST_check(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        return isValidBST_check(root.left, min, root.val) && isValidBST_check(root.right, root.val, max);
    }

    //leetcode 98!!!
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();
            if (currentNode.left != null) {
                if (currentNode.left.val < currentNode.val) {
                    queue.add(currentNode.left);
                } else {
                    return false;
                }

            }
            if (currentNode.right != null) {
                if (currentNode.right.val > currentNode.val) {
                    queue.add(currentNode.right);
                } else {
                    return false;
                }

            }
        }
        return true;
    }


    //leetcode 104 二叉树的最大深度
    public static int level(TreeNode root) {
        if (root == null) {
            return 0;
        }
        System.out.println(root.val);
        int result = Math.max(level(root.left), level(root.right)) + 1;
        return result;
    }

    //深度优先 递归
    public static void depthOrderTraversalRecursion(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            depthOrderTraversalRecursion(root.left);
            depthOrderTraversalRecursion(root.right);
        }
    }

    //深度优先遍历二叉树 非递归
    public static void depthOrderTraversal(TreeNode root) {
        if (root == null) {
            System.out.println("Empty Tree");
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            System.out.print(currentNode.val + " ");
            if (currentNode.right != null) {            //由于栈是后进先出，所以要先放入右子节点再放入左子节点
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
        System.out.print("\n");
    }

    //广度优先遍历二叉数 非递归
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            System.out.println("Empty Tree");
            return;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();
            System.out.print(currentNode.val + " ");
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        System.out.print("\n");
    }

    //leetcode 103 层遍历二叉树，每一行输出一层的所有节点，第一行从左到右，第二行从右到左，以此交替
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>(); //用队列来实现层遍历
        int count;
        queue.add(root);
        boolean reverse = false;//
        while (!queue.isEmpty()) {
            List<Integer> lineResult = new LinkedList<>();
            count = queue.size();
            for (int i = 0; i < count; i++) {          //每次循环遍历一层的节点，并把该层所有节点的孩子加入到堆中
                TreeNode currentNode = queue.remove();
                lineResult.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            if (reverse) {
                reverse = false;
                Collections.reverse(lineResult);
            } else {
                reverse = true;
            }
            result.add(lineResult);//从0处插入，之前的元素顺序向后移动一位，实现最终的bottom-up输出
        }
        return result;
    }

    //leetcode 107 层遍历二叉树，每一行输出一层的所有节点，从下到上，从左到右
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>(); //用队列来实现层遍历
        int count;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> lineResult = new LinkedList<>();
            count = queue.size();
            for (int i = 0; i < count; i++) {          //每次循环遍历一层的节点，并把该层所有节点的孩子加入到堆中
                TreeNode currentNode = queue.remove();
                lineResult.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(0, lineResult);//从0处插入，之前的元素顺序向后移动一位，实现最终的bottom-up输出
        }
        return result;
    }

    //leetcode 199 层遍历二叉树，输出每一层最右边的节点的值
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        int count;
        int finalNum;
        TreeNode currentNode = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            count = queue.size();
            for (int i = 0; i < count; i++) {
                currentNode = queue.remove();
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            finalNum = currentNode.val;
            result.add(finalNum);
        }
        return result;

    }

    //二叉树结构
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    private static TreeNode createBinaryTreeByArray(int[] array, int index) {
        TreeNode tn = null;
        if (index < array.length) {
            int value = array[index];
            if (value != 0) {
                tn = new TreeNode(value);
                tn.left = createBinaryTreeByArray(array, 2 * index + 1);
                tn.right = createBinaryTreeByArray(array, 2 * index + 2);
                return tn;
            }

        }
        return tn;
    }
}
