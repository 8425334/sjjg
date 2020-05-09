
import java.util.*;

public class Main
{
    public static void main(String[] args) {
        System.out.println(f(1000));
    }

    private static int f(int count){
        int result = 0;
        if (count > 0){
            result += count;
            return result + f(--count);
        }
        return 0;
    }

    //————————————————————————————
    //|  我  |  爱  |  中  |  国  |
    //|————————————————————————————
    //|  我  |  爱  |  中  |  国  |
    //|————————————————————————————
    //|  我  |  爱  |  中  |  国  |
    //|————————————————————————————
    //|  我  |  爱  |  中  |  国  |
    //|————————————————————————————

}