package bstmap;


import java.util.Set;
import java.util.HashSet;
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
        //throw new UnsupportedOperationException("NOT IMPLEMENT");
        Set<K> myset = new HashSet<>();
        return keySet(root, myset);
    }
    private Set<K> keySet(Node node, Set<K> myset) {
        if (node == null) return myset;
        keySet(node.left,  myset);
        myset.add(node.key);
        keySet(node.right, myset);
        return myset;
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
        //throw new UnsupportedOperationException("NOT IMPLEMENT");
        if( key == null) return null;
        else if (!containsKey(key)) return null;
        else return delete(key);
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 7. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) {
        //throw new UnsupportedOperationException("NOT IMPLEMENT");
        if (key == null) return null;
        else if (containsKey(key) && get(key) == value) return delete(key);
        else return null;
    }
    private V delete(K key) {
        if (key == null) throw new IllegalArgumentException("calls delete() with a null key");
        V myvalue = get(key);
        root = delete(root, key);
        return myvalue;
    }
    private Node delete(Node x , K key) {
        // find key
        if(x == null) return null;
        // delete key
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);        // reorg BST tree
        else {
            if(x.left == null) return x.right;
            if(x.right == null) return x.left;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;

    }

    private Node min(Node x) {
        if( x.left == null) return x;
        else return min(x.left);
    }

    private Node deleteMin(Node x) {
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }
    @Override
    public Iterator<K> iterator(){
        //throw new UnsupportedOperationException("NOT IMPLEMENT");
        return keySet().iterator();
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.println(node.key.toString() + " -> " + node.value.toString());
        printInOrder(node.right);
    }

}
