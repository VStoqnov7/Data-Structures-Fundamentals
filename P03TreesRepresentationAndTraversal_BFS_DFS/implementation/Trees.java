package P03TreesRepresentationAndTraversal_BFS_DFS.implementation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Trees<E>  {

    private E key;
    private Trees<E> parent;
    private List<Trees<E>> children;

    public Trees(E value, Trees<E>... subtrees) {
        this.key = value;
        this.parent = null;
        this.children = new ArrayList<>();

        for (Trees<E> subtree : subtrees) {
            this.children.add(subtree);
            subtree.parent = this;
        }
    }


    public List<E> orderBfs() {
        List<E> result = new ArrayList<>();
        if (this.key == null){
            return result;
        }
        Deque<Trees<E>> childrenQueue = new ArrayDeque<>();
        childrenQueue.offer(this);

        while (!childrenQueue.isEmpty()) {
            Trees<E> current = childrenQueue.poll();

            result.add(current.key);

            for (Trees<E> child : current.children) {
                childrenQueue.offer(child);
            }
        }
        return result;
    }


    //    public List<E> orderStackDfs(){
    //        List<E> result = new ArrayList<>();
    //        Deque<Tree<E>> toTraverse = new ArrayDeque<>();
    //        toTraverse.push(this);
    //
    //        while (!toTraverse.isEmpty()) {
    //            Tree<E> current = toTraverse.pop();
    //
    //            for (Tree<E> node : current.children) {
    //                toTraverse.push(node);
    //            }
    //            result.add(current.value);
    //        }
    //        return result;
    //    }


    public List<E> orderDfs() {
        List<E> result = new ArrayList<>();
        if (this.key == null){
            return result;
        }
        this.doDfs(this, result);
        return result;
    }

    private void doDfs(Trees<E> node, List<E> result) {
        for (Trees<E> child : node.children) {
            this.doDfs(child, result);
        }
        result.add(node.key);
    }


    public void addChild(E parentKey, Trees<E> child) {
        Trees<E> search = find(parentKey);

        if (search == null) {
            throw new IllegalArgumentException();
        }

        search.children.add(child);
        child.parent = search;
    }

    private Trees<E> find(E parentKey) {
        Deque<Trees<E>> childrenQueue = new ArrayDeque<>();
        childrenQueue.offer(this);

        while (!childrenQueue.isEmpty()) {
            Trees<E> current = childrenQueue.poll();

            if (current.key.equals(parentKey)) {
                return current;
            }

            for (Trees<E> child : current.children) {
                childrenQueue.offer(child);
            }
        }
        return null;
    }
	

    public void removeNode(E nodeKey) {
        Trees<E> toRemove = find(nodeKey);

        if (toRemove == null) {
            throw new IllegalArgumentException("Node with key " + nodeKey + " not found.");
        }

        if (toRemove.parent != null) {
            toRemove.parent.children.remove(toRemove);
        } else {
            this.key = null;
            this.parent = null;
            this.children.clear();
        }

        removeChildren(toRemove);
    }

    private void removeChildren(Trees<E> node) {
        for (Trees<E> child : new ArrayList<>(node.children)) {
            removeChildren(child);
        }
        node.children.clear();
    }


    public void swap(E firstKey, E secondKey) {
        Trees<E> firstNode = find(firstKey);
        Trees<E> secondNode = find(secondKey);

        if (firstNode == null || secondNode == null){
            throw new IllegalArgumentException();
        }

        Trees<E> firstParent = firstNode.parent;
        Trees<E> secondParent = secondNode.parent;

        if (firstParent == null){
            swapRoot(secondNode);
            return;
        } else if(secondParent == null) {
            swapRoot(firstNode);
            return;
        }

        firstNode.parent = secondParent;
        secondNode.parent = firstParent;

        int firstIndex = firstParent.children.indexOf(firstNode);
        int secondIndex = secondParent.children.indexOf(secondNode);

        firstParent.children.set(firstIndex, secondNode);
        secondParent.children.set(secondIndex, firstNode);
    }

    private void swapRoot(Trees<E> node) {
        this.key = node.key;
        this.parent = null;
        this.children = node.children;
        node.parent = null;
    }
}



