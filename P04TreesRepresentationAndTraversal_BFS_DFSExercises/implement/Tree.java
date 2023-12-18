package P04TreesRepresentationAndTraversal_BFS_DFSExercises.implement;

public class Tree<E> {
//    private E key;
//    private implementations.Trees<E> parent;
//    private List<implementations.Trees<E>> children;
//
//    public Tree(E key ){
//        this.key = key;
//        this.children = new ArrayList<>();
//    }
//
//    public Tree() {
//        this.children = new ArrayList<>();
//    }
//
//
//    public void setParent(implementations.Trees<E> parent) {
//        this.parent = parent;
//    }
//
//
//    public void addChild(implementations.Trees<E> child) {
//        this.children.add(child);
//    }
//
//
//    public implementations.Trees<E> getParent() {
//        return this.parent;
//    }
//
//
//    public E getKey() {
//        return this.key;
//    }
//
//
//    public String getAsString() {
//        StringBuilder builder = new StringBuilder();
//        traverseTreeWithRecurrence(builder, 0, this);
//        return builder.toString().trim();
//    }
//
//    public List<implementations.Trees<E>> traverseWithBFS() {
//
//        Deque<implementations.Trees<E>> queue = new ArrayDeque<>();
//        queue.offer(this);
//
//
//        List<implementations.Trees<E>> allNodes = new ArrayList<>();
//
//        while (!queue.isEmpty()) {
//            implementations.Trees<E> tree = queue.poll();
//            allNodes.add(tree);
//
//            for (implementations.Trees<E> child : tree.children) {
//                queue.offer(child);
//            }
//        }
//        return allNodes;
//    }
//
//    private void traverseTreeWithRecurrence(StringBuilder builder, int indent, implementations.Trees<E> tree) {
//        builder
//                .append(this.getPadding(indent))
//                .append(tree.getKey())
//                .append(System.lineSeparator());
//
//        for (implementations.Trees<E> child : tree.children) {
//            traverseTreeWithRecurrence(builder, indent + 2, child);
//        }
//    }
//
//    private String getPadding(int size) {
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < size; i++) {
//            builder.append(" ");
//        }
//        return builder.toString();
//    }
//
//
//    public List<E> getLeafKeys() {
//        return traverseWithBFS()
//                .stream()
//                .filter(tree -> tree.children.size() == 0)
//                .map(implementations.Trees::getKey)
//                .collect(Collectors.toList());
//    }
//
//
//    public List<E> getMiddleKeys() {
//
//        Deque<implementations.Trees<E>> queue = new ArrayDeque<>();
//        queue.offer(this);
//
//        List<E> middleNodes = new ArrayList<>();
//
//        while (!queue.isEmpty()) {
//            implementations.Trees<E> tree = queue.poll();
//
//            if (tree.parent != null && tree.children.size() > 0) {
//                middleNodes.add(tree.getKey());
//            }
//
//            for (implementations.Trees<E> child : tree.children) {
//                queue.offer(child);
//            }
//        }
//        return middleNodes;
//    }
//
//
//    public implementations.Trees<E> getDeepestLeftmostNode() {
//        List<implementations.Trees<E>> trees = this.traverseWithBFS();
//        implementations.Trees<E> deepestLeftNode = null;
//
//        int maxPath = 0;
//
//        for (implementations.Trees<E> tree : trees) {
//            if (tree.isLeaf()) {
//                int currentPath = getStepsFromLeafToRoot(tree);
//                if (currentPath > maxPath) {
//                    maxPath = currentPath;
//                    deepestLeftNode = tree;
//                }
//            }
//        }
//        return deepestLeftNode;
//    }
//
//    private int getStepsFromLeafToRoot(implementations.Trees<E> tree) {
//        int counter = 0;
//        implementations.Trees<E> current = tree;
//
//        while (current.parent != null) {
//            counter++;
//            current = current.parent;
//        }
//        return counter;
//    }
//
//    private boolean isLeaf() {
//        return this.parent != null && this.children.size() == 0;
//    }
//
//
//    public List<E> getLongestPath() {
//        List<implementations.Trees<E>> trees = this.traverseWithBFS();
//        List<E> result = new ArrayList<>();
//
//        int maxPath = 0;
//
//        for (implementations.Trees<E> tree : trees) {
//            if (tree.isLeaf()) {
//                int currentPath = getStepsFromLeafToRoot(tree);
//                if (currentPath > maxPath) {
//                    maxPath = currentPath;
//                    result.clear();
//                    result.add(tree.getKey());
//
//                    implementations.Trees<E> current = tree;
//
//                    while (current.parent != null) {
//                        current = current.parent;
//                        result.add(current.getKey());
//                    }
//                }
//            }
//        }
//        Collections.reverse(result);
//        return result;
//    }
//
//
//    public List<List<E>> pathsWithGivenSum(int sum) {
//        List<List<E>> result = new ArrayList<>();
//        List<E> currentPath = new ArrayList<>();
//        calculatePathsWithSum(this, sum, 0, currentPath, result);
//        return result;
//    }
//
//    private void calculatePathsWithSum(implementations.Trees<E> node, int targetSum, int currentSum, List<E> currentPath, List<List<E>> result) {
//        if (node == null) return;
//
//        currentPath.add(node.getKey());
//        currentSum += (Integer) node.getKey();
//
//        if (currentSum == targetSum && node.isLeaf()) {
//            result.add(new ArrayList<>(currentPath));
//        }
//
//        for (implementations.Trees<E> child : node.children) {
//            calculatePathsWithSum(child, targetSum, currentSum, currentPath, result);
//        }
//
//        currentPath.remove(currentPath.size() - 1);
//    }
//
//
//    public List<implementations.Trees<E>> subTreesWithGivenSum(int sum) {
//        List<implementations.Trees<E>> result = new ArrayList<>();
//        findSubTreesWithSum(this, sum, result);
//        return result;
//    }
//
//    private int findSubTreesWithSum(implementations.Trees<E> node, int targetSum, List<implementations.Trees<E>> result) {
//        if (node == null) return 0;
//
//        int currentSum = (Integer) node.getKey();
//        for (implementations.Trees<E> child : node.children) {
//            currentSum += findSubTreesWithSum(child, targetSum, result);
//        }
//
//        if (currentSum == targetSum) {
//            result.add(node);
//        }
//
//        return currentSum;
//    }
}