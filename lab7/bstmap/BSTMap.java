package bstmap;

import java.util.Set;
import java.util.Iterator;
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private Node root;
    private int size;

    private class Node {
        private K key; //sorted by key
        private V value; // associated data
        private Node left, right; // left and right subtrees
        private int size; // number of nodes in subtree
        public Node (K key, V value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
            }
        }
    public BSTMap() {

    }
    /** Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = clear(root);
        this.size = 0;
    }
    private Node clear(Node node) {
        if (node == null) {
            return null;
        }

        node.left = clear(node.left);
        node.right = clear(node.right);
        return null;
    }
    /* Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to contains() is null");
        }
        return containsKey(root, key);
    }

    private boolean containsKey(Node node, K key) {
        if (node == null) {
            return false;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return containsKey(node.left, key);
        } else if (cmp > 0) {
            return containsKey(node.right, key);
        }
        return true;
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to contains() is null");
        }
        Node n =  get(root, key);
        if (n == null ) return null;
        else return n.value;
    }

    private Node get(Node node, K key) {
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        }
        else if (cmp > 0) {
            return get(node.right, key);
        }
        else return node;
    }
    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size(root);
    }
    private int size(Node node) {
        if (node == null) return 0;
        else return node.size;
    }

    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        root = put(root, key, value);
    }


    private Node put(Node node, K key, V value) {
        if(node == null) return new Node(key, value, 1);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        }
        else if (cmp > 0) {
            node.right = put(node.right, key, value);
        }
        else  node.value = value;
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    /* Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException("NOT IMPLEMENT");
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException("NOT IMPLEMENT");
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 7. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException("NOT IMPLEMENT");
    }
    public Iterator<K> iterator(){
        throw new UnsupportedOperationException("NOT IMPLEMENT");
    }

//    public void printInOrder() {
//        printInOrder(root);                                                                                                                                                                        left
//    }
//
//    private void printInOrder(Node node){
//        if(node != null) {
//            printInOrder(node.left);
//            System.out.println(node.key);
//            printInOrder(node.right);
//        }
//    }
}
