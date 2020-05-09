import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Index {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        System.out.println(linkedList);
        System.out.println(linkedList.size());
    }

    /**
     * 默认从小到大排序
     * @param list 线性表
     * @param x 整数x
     */
    private static void insert(ArrayList<Integer> list, int x){
        //线性表长度为0时直接加到0处并且跳出逻辑
        if (list.size() <= 0){
            list.add(x);
            return;
        }
        //从尾部遍历,到底位置到跳出逻辑
        for (int i = list.size() - 1; i >= 0; i--) {
            if (x >= list.get(i)){
                list.add(i + 1, x);
                return;
            }
        }
    }
}
