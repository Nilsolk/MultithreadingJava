import java.util.ArrayList;

public class SolutionOutOfMemory {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        try {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                list.add(new Object());
            }
        } catch (OutOfMemoryError error) {
            System.out.println("OutOfMemoryError");
        } finally {
            System.out.println(list.size());
        }


    }
}
