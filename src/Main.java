import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static List<Integer> mergeSort(List<Integer> list){
        if(list.size() == 1){
            return list;
        }else {
            List<Integer> firstHalf = list.subList(0, list.size() / 2);
            List<Integer> secondHalf = list.subList(list.size() / 2, list.size());

            List<Integer> sortedFirstHalf = Main.mergeSort(firstHalf);
            List<Integer> sortedSecondHalf = Main.mergeSort(secondHalf);

            int i=0, j=0;
            List<Integer> sortedList= new ArrayList<>();

            while(i < sortedFirstHalf.size() && j < sortedSecondHalf.size()){
                if(sortedFirstHalf.get(i) < sortedSecondHalf.get(j)){
                    sortedList.add(sortedFirstHalf.get(i));
                    i=i+1;
                }else{
                    sortedList.add(sortedSecondHalf.get(j));
                    j=j+1;
                }
            }
            while (i<sortedFirstHalf.size()){ sortedList.add(sortedFirstHalf.get(i));  i=i+1;}
            while (j<sortedSecondHalf.size()){ sortedList.add(sortedSecondHalf.get(j));  j=j+1;}

            return sortedList;

        }
    }
    public static List<Integer> quickSort(List<Integer> lista){
        if(lista.size() <= 1)
            return lista;

        int posljednjiManji = 0;
        for(int i=1; i<lista.size(); i=i+1){
            if(lista.get(i) < lista.get(0)){
                posljednjiManji = posljednjiManji+1;
                int temp = lista.get(posljednjiManji);
                lista.set(posljednjiManji, lista.get(i));
                lista.set(i, temp);
            }
        }

        int temp = lista.get(0);
        lista.set(0, lista.get(posljednjiManji));
        lista.set(posljednjiManji, temp);

        List<Integer> firstHalf = lista.subList(0, posljednjiManji);
        List<Integer> secondHalf = lista.subList(posljednjiManji+1, lista.size());

        List<Integer> sortedFirstHalf = quickSort(firstHalf);
        List<Integer> sortedSecondHalf = quickSort(secondHalf);

        List<Integer> sortedList = new ArrayList<>(sortedFirstHalf);
        sortedList.add(lista.get(posljednjiManji));
        sortedList.addAll(sortedSecondHalf);

        return sortedList;
    }

    public static List<Integer> insertionSort(List<Integer> lista) {
        for (int i = 1; i < lista.size(); i = i + 1) {
            int j = i;
            while (j > 0 && lista.get(j) < lista.get(j - 1)) {
                int temp = lista.get(j);
                lista.set(j, lista.get(j - 1));
                lista.set(j - 1, temp);
                j = j - 1;
            }
        }
        return lista;
    }


    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(5, 3, 15, 7, 1, 12, 4));
        ArrayList<Integer> sortedList = new ArrayList<>(Main.insertionSort(lista));
        System.out.println(sortedList);

    }
}