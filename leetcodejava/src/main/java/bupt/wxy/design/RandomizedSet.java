package bupt.wxy.design;

/**
 * Created by xiyuanbupt on 1/12/17.
 380. Insert Delete GetRandom O(1)
 Difficulty: Hard

 Design a data structure that supports all following operations in average O(1) time.

 insert(val): Inserts an item val to the set if not already present.
 remove(val): Removes an item val from the set if present.
 getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 Example:

 // Init an empty set.
 RandomizedSet randomSet = new RandomizedSet();

 // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 randomSet.insert(1);

 // Returns false as 2 does not exist in the set.
 randomSet.remove(2);

 // Inserts 2 to the set, returns true. Set now contains [1,2].
 randomSet.insert(2);

 // getRandom should return either 1 or 2 randomly.
 randomSet.getRandom();

 // Removes 1 from the set, returns true. Set now contains [2].
 randomSet.remove(1);

 // 2 was already in the set, so return false.
 randomSet.insert(2);

 // Since 2 is the only number in the set, getRandom always return 2.
 randomSet.getRandom();
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 思想是使用一个array存储val
 * 使用一个hashmap 记录key值的索引
 * 插入的时候在array最后面插入, 删除的时候将最后一个元素更新到删除的位置, 更新hashmap
 * 然后删除最后一个元素
 */
public class RandomizedSet {

    ArrayList<Integer> nums;
    Map<Integer,Integer> locs;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain=locs.containsKey(val);
        if(contain)return false;
        locs.put(val,nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if (!contain) return false;
        int loc = locs.get(val);
        if (loc<nums.size()- 1) { // not the last one than swap the last one with this val
            int lastone = nums.get(nums.size()-1);
            nums.set(loc,lastone);
            locs.put(lastone,loc);
        }
        locs.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
