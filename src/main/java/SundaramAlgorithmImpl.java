import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SundaramAlgorithmImpl implements SundaramAlgorithm {


    public Integer[] getPrimes(int lowerRange, int upperRange) {
        Set<Integer> numListToRemove = new TreeSet<Integer>();
        //collect numbers like i+j+2*i*j in a given range;
        for (int i = lowerRange; i < upperRange; i++) {
            for (int j = i; j < upperRange; j++) {
                int numToRemove = i + j + 2 * i * j;
                if (numToRemove <= upperRange) {
                    numListToRemove.add(numToRemove);
                } else {
                    break;
                }
            }
        }
        //create the list from the rest of nums from that range where:
        //for each num multiply value and collect primeNums:  primeNum = 1 + i * 2
        //nums only in set range (if (primeNum < upperRange))
        List<Integer> primeNumListToReturn = new ArrayList<Integer>();
        for (int i = 1; i < upperRange; i++) {
            if (!numListToRemove.contains(i)) {
                int primeNum = 1 + i * 2;
                if (primeNum < upperRange) {
                    primeNumListToReturn.add(1 + i * 2);
                    System.out.println(primeNum + ", ");
                }
            }
        }
        return primeNumListToReturn.toArray(new Integer[0]);
    }
}
