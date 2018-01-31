package interviewBits.tree.traversal;

import interviewBits.tree.TreeNode;

import java.util.*;

/**
 * Created by labuser on 7/30/17.
 */
public class VerticalOrderTraversal {

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (A == null)
            return result;
        Map<Integer, ArrayList<Integer>> levels = new HashMap<Integer, ArrayList<Integer>>();
        Queue<Map.Entry<TreeNode, Integer>> queue = new LinkedList<Map.Entry<TreeNode, Integer>>();
        int minLevel = 0;
        queue.offer(new MyEntry(A, 0));
        while (!queue.isEmpty()) {
            Map.Entry<TreeNode, Integer> vertical = queue.poll();
            int level = vertical.getValue();
            TreeNode node = vertical.getKey();
            if (!levels.containsKey(level))
                levels.put(level, new ArrayList<Integer>());
            levels.get(level).add(node.val);
            if (node.left != null) {
                minLevel = Math.min(minLevel, level - 1);
                queue.offer(new MyEntry(node.left, level - 1));
            }
            if (node.right != null) {
                queue.offer(new MyEntry(node.right, level + 1));
            }
        }
        for (int i = minLevel; levels.containsKey(i); i++)
            result.add(levels.get(i));
        return result;
    }

  static class MyEntry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }


        public K getKey() {
            return key;
        }


        public V getValue() {
            return value;
        }


        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
    }

    public static void main(String args[])
    {


        /* Let us construct the tree shown in above diagram */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);

        System.out.println(verticalOrderTraversal(root));
    }


}
