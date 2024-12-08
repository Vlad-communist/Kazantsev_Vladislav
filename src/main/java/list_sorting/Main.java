package list_sorting;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int mod = (int) (1e9 + 7);

    public static void main(String[] args) throws Exception {
        // test algorithms
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            int g = i + 12345;
            arr.add((g * g % mod * g + 123456789) % mod);
        }
        String type = "bubble";
        List<Integer> sortedArr = Sorts.sortAscending(arr, type);
    }
}
