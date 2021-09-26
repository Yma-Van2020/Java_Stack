import java.util.ArrayList;

public class ArrayL {
    public static void main(String[] args){
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(10);
        list.add("Hello");
        list.add(new ArrayList<Integer>());
        int size = list.size();
        System.out.println(size);
    }
}
