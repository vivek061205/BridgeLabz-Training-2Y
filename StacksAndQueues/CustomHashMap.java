
/**
 * Problem 9 (HashMap): Implement a Custom Hash Map
 * Design and implement a basic HashMap with insertion, deletion, and retrieval.
 * Hint: Use an array of linked lists (separate chaining) to handle collisions.
 */
public class CustomHashMap {

    private static final int DEFAULT_CAPACITY = 16;

    // Node for the linked-list chain at each bucket
    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key   = key;
            this.value = value;
        }
    }

    private Node[] buckets;
    private int size;

    public CustomHashMap() {
        buckets = new Node[DEFAULT_CAPACITY];
        size    = 0;
    }

    // Hash function: maps key to bucket index
    private int getBucketIndex(int key) {
        return Math.abs(key) % buckets.length;
    }

    /** Insert or update key-value pair */
    public void put(int key, int value) {
        int index = getBucketIndex(key);
        Node head = buckets[index];

        // Update if key already exists
        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Prepend new node
        Node newNode = new Node(key, value);
        newNode.next  = buckets[index];
        buckets[index] = newNode;
        size++;
    }

    /** Retrieve value by key; returns -1 if not found */
    public int get(int key) {
        int  index = getBucketIndex(key);
        Node node  = buckets[index];
        while (node != null) {
            if (node.key == key) return node.value;
            node = node.next;
        }
        return -1;
    }

    /** Remove key from map */
    public void remove(int key) {
        int  index = getBucketIndex(key);
        Node head  = buckets[index];

        if (head == null) return;

        // Key is at head of chain
        if (head.key == key) {
            buckets[index] = head.next;
            size--;
            return;
        }

        // Key is deeper in chain
        Node prev = head;
        while (prev.next != null) {
            if (prev.next.key == key) {
                prev.next = prev.next.next;
                size--;
                return;
            }
            prev = prev.next;
        }
    }

    public int size()      { return size; }
    public boolean isEmpty() { return size == 0; }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();

        map.put(1, 100);
        map.put(2, 200);
        map.put(3, 300);
        System.out.println("get(1): " + map.get(1));  // 100
        System.out.println("get(2): " + map.get(2));  // 200

        map.put(2, 999);  // update
        System.out.println("get(2) after update: " + map.get(2));  // 999

        map.remove(1);
        System.out.println("get(1) after remove: " + map.get(1));  // -1

        System.out.println("Size: " + map.size());   // 2
    }
}
