package custom_array_list;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> arrayList = new CustomArrayList<>(5);
        try {
            System.out.println(arrayList.get(0));
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Integer number = null;
            arrayList.add(number);
        } catch (Exception e) {
            System.out.println(e);
        }

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println(arrayList.get(1));

        arrayList.remove(1);
        System.out.println(arrayList.get(1));

    }
}