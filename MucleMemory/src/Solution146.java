import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description
 * @Author yunfeng
 * @Date 2020/8/3
 *
 * LRU
 */
public class Solution146 {
    private LinkedHashMap<Integer, Integer> map;
    private int capacity;

    public Solution146(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > Solution146.this.capacity;
            }
        };
        this.capacity = capacity;
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
