package P05DataStructuresBinaryTreesHeapsBST;

public class DemoBinaryTree {

    static class BinaryTree<K> {

        //---------------------------------------------------------------------------------------
        static class Node<K> {

            K key;
            Node<K> left;
            Node<K> right;

            public Node(K key, Node<K> left, Node<K> right) {
                this.key = key;
                this.left = left;
                this.right = right;
            }

            public K getKey() {
                return key;
            }

            public Node<K> getLeft() {
                return left;
            }

            public Node<K> getRight() {
                return right;
            }
        }
        //------------------------------------------------------------------------------------------

        Node<K> root;

//        public void insert(K key) {
//            Node<K> node = new Node<>(key, null, null);
//            if (root == null) {
//                root = node;
//            }
//        }

        public BinaryTree(Node<K> root){
            this.root = root;
        }

        public void print(){
            print(this.root,0);
        }

        private void print (Node<K> node , int level){
            if (node == null){
                return;
            }

            for (int i = 0; i < level; i++) {
                System.out.print('\t');
            }

            //Todo: Pre-order for copy too!!!
            System.out.println(node.getKey());
            print(node.getLeft(),level + 1);
            print(node.getRight(), level + 1);

            //Todo: In-order
//            print(node.getLeft(),level + 1);
//            System.out.println(node.getKey());
//            print(node.getRight(), level + 1);

            //Todo: Post-order for delete too!!!
//            print(node.getLeft(),level + 1);
//            print(node.getRight(), level + 1);
//            System.out.println(node.getKey());
        }

        public BinaryTree<K> copy(){
            return new BinaryTree<>(copy(this.root));
        }
        private Node<K> copy(Node<K> node){
            if (node == null){
                return null;
            }

            //Todo: First way copy
            Node<K> copiedNode = new Node<K>(node.key,null,null);
            copiedNode.left = copy(node.getLeft());
            copiedNode.right = copy(node.getRight());

            //Todo: Second way copy
          return  new Node<K>(node.getKey(),
                  copy(node.getLeft()),
                  copy(node.getRight()));
        }
    }

    public static void main(String[] args) {
//        BinaryTree<Integer> tree = new BinaryTree<>();
//        tree.insert(new BinaryTree.Node<>(14, null, null));

//        tree.insert(14);

        BinaryTree.Node<Integer> root =
                new BinaryTree.Node<Integer>(14,
                        new BinaryTree.Node<>(12,
                                new BinaryTree.Node<>(5, null, null),
                                null),
                        new BinaryTree.Node<>(13,
                                new BinaryTree.Node<>(28, null, null),
                                new BinaryTree.Node<>(7, null, null))
                );

        BinaryTree<Integer> tree1 = new BinaryTree<>(root);

        tree1.print();

        BinaryTree<Integer> copiedTree = tree1.copy();
    }

}
