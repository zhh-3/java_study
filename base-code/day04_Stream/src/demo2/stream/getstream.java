package demo2.stream;

import java.util.*;
import java.util.stream.Stream;

/*
两种方式：
1.调用collection中的stream方法,注意该集合是单列集合
2.调用stream中的静态方法of方法
 */
public class getstream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

        Map<String,String> map = new HashMap<>();
        //获取键
        Set<String> keyset = map.keySet();
        Stream<String> stream3 = keyset.stream();
        //获取值
        Collection<String> valueset = map.values();
        Stream<String> stream4 = valueset.stream();

        //获取键值对
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String, String>> stream5 = entries.stream();

        //把数组转化为流
        Stream<Integer> stream6 = Stream.of(1, 2, 3);

        Integer[] arr = {1,2,3};
        Stream<Integer> stream7 = Stream.of(arr);

        String[] arr2 = {"a","bb","ccc"};
        Stream<String> steam8 = Stream.of(arr2);
    }
}
