import java.util.*;

public class GrammarExercise {
    public static void main(String[] args) {
        String firstWordList = "";
        String secondWordList = "";
        Scanner sc = new Scanner(System.in);
        firstWordList = sc.nextLine();
        sc.nextLine();
        secondWordList = sc.nextLine();
        List<String> result = findCommonWordsWithSpace(firstWordList, secondWordList);
        for (String list : result) {
            System.out.println(list);
        }

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        String[] first = firstWordList.split(",");
        String[] second = secondWordList.split(",");
        List<String> result = new ArrayList<>();
        Set<String> set = new TreeSet<>();

        for (int i = 0; i < first.length; i++) {
            if (first[i].equals("")){
                throw new RuntimeException("input not valid");
            }
            first[i] = first[i].toUpperCase();
        }
        for (int i = 0; i < second.length; i++) {
            if (second[i].equals("")){
                throw new RuntimeException("input not valid");
            }
            second[i] = second[i].toUpperCase();
        }
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i].equals(second[j])) {
                    set.add(first[i]);
                }
            }
        }
        String[] temp = new String[set.size()];
        int ti = 0;
        for (String s : set) {
            temp[ti] = s;
            ti++;
        }
        for (int i = 0; i < temp.length; i++) {
            String newTemp="";
            for (int j = 0; j < temp[i].length(); j++) {
                if(temp[i].charAt(j)<'A'||temp[i].charAt(j)>'Z'){
                    throw new RuntimeException("input not valid");
                }
                if (j!=temp[i].length()-1){
                    newTemp=newTemp+temp[i].charAt(j)+" ";
                }else {
                    newTemp=newTemp+temp[i].charAt(j);
                }
            }
            temp[i]=newTemp;
        }
        for (int i = 0; i < temp.length-1; i++) {
            for (int j = 1; j < temp.length-i-1; j++) {
                if (temp[i].compareTo(temp[j])>0){
                    String t=temp[i];
                    temp[i]=temp[j];
                    temp[j]=t;
                }
            }
        }
        for (int i = 0; i < temp.length; i++) {
            result.add(temp[i]);
        }
        return result;
    }
}
