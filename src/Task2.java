import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        int number = 15;
        ToRomanConverter converter = new ToRomanConverter(44);
        ToRomanConverter converter1 = new ToRomanConverter(55);
        ToRomanConverter converter2 = new ToRomanConverter(100);
        ToRomanConverter converter3 = new ToRomanConverter(901);
        ToRomanConverter converter4 = new ToRomanConverter(499);
        ToRomanConverter converter5 = new ToRomanConverter(85);
        ToRomanConverter converter6 = new ToRomanConverter(900);

        System.out.println(converter1.convertToRoman());
        System.out.println(converter2.convertToRoman());
        System.out.println(converter3.convertToRoman());
        System.out.println(converter4.convertToRoman());
        System.out.println(converter6.convertToRoman());
    }
}

class ToRomanConverter {
    private int number;

    public ToRomanConverter(int number) {
        this.number = number;
    }

    public String convertToRoman() {
        Map<Integer, String> table = new LinkedHashMap<>();
        table.put(1000, "M");
        table.put(900, "CM");
        table.put(500, "D");
        table.put(400, "CD");
        table.put(100, "C");
        table.put(90, "XC");
        table.put(50, "L");
        table.put(40, "XL");
        table.put(10, "X");
        table.put(9, "IX");
        table.put(5, "V");
        table.put(4, "IV");
        table.put(1, "I");

        StringBuilder romanBuilder = new StringBuilder();
        int n = number;

        for (Integer num : table.keySet()) {
            while (n >= num) {
                int d = n / num;
                n = n % num;
                for (int j = 0; j < d; j++) {
                    romanBuilder.append(table.get(num));
                }
            }
        }
        return romanBuilder.toString();
    }
}