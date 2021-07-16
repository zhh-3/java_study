package Demo03Lambda;

import java.util.Arrays;
import java.util.Comparator;

/*
lambda作为返回值
 */
public class demo02Comparator {
    //定义一个方法，返回值为函数式接口lambda表达式
    public static Comparator<String> getComparator() {
        //返回值是一个接口，我们可以返回这个接口的匿名内部类
        /*return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //按字符串降序排列
                return o2.length()-o1.length();
            }
        };*/

        //返回值是一个函数式接口，我们可以返回一个lambda表达式
        return (o1,o2) -> {
            //按字符串降序排列
            return o2.length()-o1.length();
        };
    }

    public static void main(String[] args) {
        String[] arr = {"aa","bb","ccc","dddd"};
        //排序前的数组
        System.out.println(Arrays.toString(arr));
        //排序后的数组
        Arrays.sort(arr,getComparator());//自带的排序
        System.out.println(Arrays.toString(arr));
    }
}
