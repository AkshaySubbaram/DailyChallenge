import java.util.*;

public class Love {

//    ToDo: input 2 full names
//    in between 2 names LOVES is constant
//    need to take count of letters from input and constant
//    arrange in desc order
//    first dig means highest + last dig means lowest and go on.... keep odd digit as it is


    private static void loveCalculater(String input1, String input2){
        List<Integer> counts = countFromInputString(input1, input2);

        if (counts == null || counts.isEmpty()) {
            System.out.println("Calculation aborted due to invalid input.");
            return;
        }

        while (counts.size() > 2) {
            List<Integer> flattened = getIntegers(counts);
            counts = flattened;
            System.out.println("Next step: " + counts);
        }
        System.out.println("Final Love Score for " + input1 + " AND " + input2 + " is "+ counts.get(0) + "" + counts.get(1) + "%");
    }

    private static List<Integer> getIntegers(List<Integer> counts) {
        List<Integer> newCounts = new ArrayList<>();
        int i = 0, j = counts.size() - 1;

        while (i < j) {
            newCounts.add(counts.get(i) + counts.get(j));
            i++;
            j--;
        }

        if (i == j) {
            newCounts.add(counts.get(i));
        }

        List<Integer> flattened = new ArrayList<>();
        for (int num : newCounts) {
            if (num >= 10) {
                flattened.add(num / 10);
                flattened.add(num % 10);
            } else {
                flattened.add(num);
            }
        }
        return flattened;
    }

    private static List<Integer> countFromInputString(String input1, String input2) {
        String input = input1.toUpperCase() + input2.toUpperCase();
        char[] ch = input.toCharArray();

        StringBuilder newInput = new StringBuilder();

        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i])) {
                continue;
            }
            newInput.append(ch[i]);
        }

        if (newInput.toString().length() == 0){
            System.out.println("Only Alphabets allowed");
            return Collections.emptyList();
        }

        Map<Character, Integer> charCount = new HashMap<>();
        newInput.append("LOVES");

        for (char c : newInput.toString().toCharArray()) {
            if (c != ' ') {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }

        List<Integer> sortedList = new ArrayList<>(charCount.values());
        sortedList.sort(Collections.reverseOrder());

        System.out.println("Character counts: " + sortedList);
        return sortedList;
    }

    public static void main(String[] args){
        String input1 = "pappa";
        String input2 = "kanda";
        loveCalculater(input1, input2);
    }

}
