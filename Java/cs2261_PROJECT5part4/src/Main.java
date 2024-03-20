import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> group1 = new HashSet<>(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));
        Set<String> group2 = new HashSet<>(Arrays.asList("George", "Katie", "Kevin", "Michelle","Ryan"));

        //prints out sets according for each group in difference, intersection, and union sets
        System.out.println("People in group 1 exclusively: " + difference(group1, group2));
        System.out.println("People in group 2 exclusively: " + difference(group2, group1));
        System.out.println("People in both groups: " + intersection(group1, group2));
        System.out.println("All people present: " + union(group1, group2));
    }
    
    //method for intersection set
    public static <T> Set<T> intersection(Set<T> setA, Set<T> setB) {
        Set<T> temp = new HashSet<T>();
        for (T x : setA)
            if (setB.contains(x))
                temp.add(x);
        return temp;
    }

    //method for difference set
    public static <T> Set<T> difference(Set<T> setA, Set<T> setB) {
        Set<T> temp = new HashSet<T>(setA);
        temp.removeAll(setB);
        return temp;
    }
    
    //method for Union set
    public static <T> Set<T> union(Set<T> setA, Set<T> setB){
    	Set<T> temp = new HashSet<T>(setA);
    	temp.addAll(setB);
    	return temp;
    }
}