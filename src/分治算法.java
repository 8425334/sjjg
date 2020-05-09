import java.util.HashSet;
import java.util.Set;

public class 分治算法 {
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,3,2,2,2,3};
        //查找下标为2的index
        System.out.println(find(arr, 2, 0, arr.length - 1));
    }
    static Set<Integer> list = new HashSet<>();
    static Set<Integer> find(int[] arr, int key, int l, int r){
        if (l != r){
            int mid = (l + r) / 2;
            //左边细分
            find(arr, key, l, mid);
            //右边细分
            find(arr, key, mid + 1, r);
            if (arr[l] == key){
                list.add(l);
            }
            if (arr[r] == key){
                list.add(r);
            }
        }
        return list;
    }
}
