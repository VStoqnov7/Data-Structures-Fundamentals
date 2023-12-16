package P03TreesRepresentationAndTraversal_BFS_DFS.interfaces;

import P03TreesRepresentationAndTraversal_BFS_DFS.implementation.Trees;

import java.util.List;

public interface AbstractTree<E> {
    List<E> orderBfs();
    List<E> orderDfs();
    void addChild(E parentKey, Trees<E> child);
	void removeNode(E nodeKey);
    void swap(E firstKey, E secondKey);
}
