// Program to implement a hash map

package design_hash_map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomHashMap<K, V> {
    private int mapSize;
    private static double LOAD_FACTOR = 0.75;
    private Node[] hashMap;
    private int currentMapSize;

    public CustomHashMap() {
        this.mapSize = 16;
        hashMap = new Node[mapSize];
    }

    public CustomHashMap(int capacity) {
        this.mapSize = capacity;
        hashMap = new Node[mapSize];
    }

    // To add a new key & value pair in the map
    public void put(K key, V value) {
        int index = Math.abs(key.hashCode()) % mapSize;
        Node node = hashMap[index];

        if (containsKey(key))
            return;

        if (node == null) {
            currentMapSize++;
            hashMap[index] = new Node(key, value);
        } else {
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(key, value);
        }

        if ((double) currentMapSize / (double) mapSize >= LOAD_FACTOR)
            resizeMap();
    }

    // To get the value for a given key
    public V get(K key) {
        return getNodeValue(key);
    }

    // To check if a given key exists in the map
    public boolean containsKey(K key) {
        return getNodeValue(key) != null;
    }

    // To get all the key & value pairs in the map
    public Set<Node<K, V>> entrySet() {
        Set<Node<K, V>> set = new HashSet<>();

        for (int i = 0; i < hashMap.length; ++i) {
            if (hashMap[i] != null) {
                Node temp = hashMap[i];
                while (temp != null) {
                    set.add(temp);
                    temp = temp.next;
                }
            }
        }

        return set;
    }

    // To get all the keys in the map
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();

        for (int i = 0; i < hashMap.length; ++i) {
            if (hashMap[i] != null) {
                Node temp = hashMap[i];
                while (temp != null) {
                    set.add((K) temp.getKey());
                    temp = temp.next;
                }
            }
        }

        return set;
    }

    // To get all the values in the map
    public List<V> values() {
        List<V> set = new ArrayList<>();

        for (int i = 0; i < hashMap.length; ++i) {
            if (hashMap[i] != null) {
                Node temp = hashMap[i];
                while (temp != null) {
                    set.add((V) temp.getValue());
                    temp = temp.next;
                }
            }
        }

        return set;
    }

    // To iterate the map and get the value
    private V getNodeValue(K key) {
        int index = Math.abs(key.hashCode()) % mapSize;
        Node node = hashMap[index];

        while (node != null) {
            if (node.key.equals(key))
                return (V) node.value;
            node = node.next;
        }

        return null;
    }

    // To resize the map
    private void resizeMap() {
        Node[] temp = new Node[2 * hashMap.length];
        mapSize = temp.length;
        currentMapSize = 0;

        for (int i = 0; i < hashMap.length; ++i) {
            Node node = hashMap[i];

            while (node != null) {
                K key = (K) node.getKey();
                V value = (V) node.getValue();

                int index = Math.abs(key.hashCode()) % mapSize;
                Node node2 = temp[index];

                if (node2 == null) {
                    currentMapSize++;
                    temp[index] = new Node(key, value);
                } else {
                    while (node2.next != null) {
                        node2 = node2.next;
                    }
                    node2.next = new Node(key, value);
                }

                node = node.next;
            }
        }

        hashMap = temp;
        temp = null;
    }

    // To remove a key & value pair from the map
    public V remove(K key) {
        if (!containsKey(key))
            return null;

        int index = Math.abs(key.hashCode()) % mapSize;
        Node curr = hashMap[index], prev = null;
        V value = getNodeValue(key);

        if (curr.getKey().equals(key)) {
            hashMap[index] = curr.next;
            if (hashMap[index] == null) currentMapSize--;
        } else {
            while (!curr.getKey().equals(key)) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
        }

        return value;
    }

    // To delete all the key & value pairs from the map
    public void clear() {
        for (int i = 0; i < hashMap.length; ++i) {
            hashMap[i] = null;
        }
    }

    static class Node<K, V> {
        K key;
        V value;
        Node next;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
        public K getKey() {
            return this.key;
        }
        public V getValue() {
            return this.value;
        }
        public String toString() {
            return "key: " + key + " value: " + value;
        }
    }
}
