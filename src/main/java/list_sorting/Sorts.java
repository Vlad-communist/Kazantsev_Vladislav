package list_sorting;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Sorts {

    private static final String[] sortAscendingTypes = {"bubble", "merge"};

    public static void bubbleSortAscending(List<Integer> arr) throws Exception {
        if (arr.size() > 100) {
            throw new Exception("Arr size is too large");
        }
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) > arr.get(j)) {
                    int temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
    }

    public static void mergeSortAscending(List<Integer> arr) throws Exception {
        if (arr.size() > 200) {
            throw new Exception("Arr size is too big");
        }
        Collections.sort(arr);
    }

    public static String[] getAscendingSortTypes() {
        return sortAscendingTypes;
    }

    private static List<Integer> sortAscendingByType(List<Integer> arr, String type) throws Exception {
        if (type.equals(sortAscendingTypes[0])) {
            bubbleSortAscending(arr);
        } else if (type.equals(sortAscendingTypes[1])) {
            mergeSortAscending(arr);
        } else {
            throw new Exception("Unknown sort type");
        }
        return arr;
    }

    public static List<Integer> sortAscending(List<Integer> arr, String type) throws Exception {
        List<Integer> result = new ArrayList<Integer>(arr);
        try {
            sortAscendingByType(result, type);
            return result;
        } catch (Exception e) {
            if (e.toString().equals("java.lang.Exception: Unknown sort type")) {
                throw e;
            }
        }
        for (String nType : sortAscendingTypes) {
            try {
                sortAscendingByType(result, nType);
                return result;
            } catch (Exception e) {
            }
        }
        throw new Exception("Your array is too big");
    }
}