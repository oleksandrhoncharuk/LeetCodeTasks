package linked_list

import kotlin.collections.HashMap

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 *
 *
 * Constraints:
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 104
 * 0 <= value <= 105
 * At most 2 * 105 calls will be made to get and put.
 */

class LRUCache(private val capacity: Int) {
    private val cache = HashMap<Int, LRUNode>(capacity)
    private val head = LRUNode(0, 0)
    private val tail = LRUNode(0, 0)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        return if (cache.contains(key)) {
            val node = cache[key]!!
            moveToFront(node)
            node.value
        } else {
            -1
        }
    }

    fun put(key: Int, value: Int) {
        if (cache.contains(key)) {
            val node = cache[key]!!
            node.value = value
            moveToFront(node)
        } else {
            // Create, insert, add to map
            val node = LRUNode(key, value)
            cache[key] = node
            insert(node)

            if (cache.size > capacity) {
                popTail()
            }
        }
    }

    private fun remove(node: LRUNode?) {
        if (node != null) {
            node.prev?.next = node.next
            node.next?.prev = node.prev
        }
    }

    private fun insert(node: LRUNode?) {
        if (node != null) {
            node.prev = head
            node.next = head.next
            head.next?.prev = node
            head.next = node
        }
    }

    private fun moveToFront(node: LRUNode) {
        remove(node)
        insert(node)
    }

    private fun popTail() {
        // Remove LRU node (before tail)
        val lru = tail.prev!!
        remove(lru)
        cache.remove(lru.key)
    }
}

private class LRUNode(val key: Int, var value: Int) {
    var prev: LRUNode? = null
    var next: LRUNode? = null
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
fun main() {
    val lru = LRUCache(2)
    lru.put(1, 1)
    lru.put(2, 2)
    println(lru.get(1)) // returns 1
    lru.put(3, 3)       // evicts key 2
    println(lru.get(2)) // returns -1 (not found)
    lru.put(4, 4)       // evicts key 1
    println(lru.get(1)) // returns -1
    println(lru.get(3)) // returns 3
    println(lru.get(4)) // returns 4
}