import org.apache.commons.lang.ObjectUtils;

import java.util.*;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/4/28 16:25
 */
public class Test {

    public static void main(String[] args) {
        Map<Object, Object> list = new HashMap<>();
        for (Map.Entry<Object, Object> entry : list.entrySet()) {
            entry.getKey();
            entry.getValue();
        }
        System.out.println(list.size());
        list.put("a","a");
//        list.add("b");
//        list.add("c");
//        list.forEach(s -> {
//            if (ObjectUtils.equals(s,"b")){
//                return;
//            }
//        });

//        Optional result = list.stream().filter(s -> ObjectUtils.notEqual(s,"b")).findAny();
//        System.out.println(result);


    }


}
