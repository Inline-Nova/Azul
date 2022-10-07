import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.*;
import static java.lang.System.*;

public class ExampleSets {
	public static void main(String args[]) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		HashSet<String> names = new HashSet<String>();
		Set<String> words = new TreeSet<String>();
		//Set<Double> money = new Set<Double>(); not allowed
		
		HashSet <Integer> digits = new HashSet<Integer>();
		set.add(43); 
		set.add(32);
		set.add(35);
		set.add(48);
		set.add(43); //doesnt add dup
		set.add(35);
		set.add(4);
		set.add(3);
		
		for(int i=0; i<10; i++) 
			digits.add(i);
			out.println("Set:" + set);
			out.println("Digits:" + digits);
		
			
		out.println();
			digits.addAll(set);
			out.println("Digits:"+digits);
			out.println("Set contains 48? "+set.contains(48));
			out.println("Set contains -7? "+set.contains(-7));
			digits.clear();
			digits.add(3);
			digits.add(4);
			out.println("Set contains all digits? "+set.containsAll(digits));
			digits.add(-7);
			out.println("Set contains all digits? "+set.containsAll(digits));
			set.addAll(digits);
			out.println("Set contains all digits? "+set.containsAll(digits));
			out.println("Set equals digits? "+set.equals(digits));
			out.println("Set is empty? "+set.isEmpty());
			out.println("Names is empty? "+names.isEmpty());
			
			Iterator <Integer> iter = set.iterator();
			while(iter.hasNext())
			names.add(""+iter.next());
			out.println("Names: "+names);
			out.print("Names: ");
			for(String k:names)
			out.print(k+" ");
			out.println();
			out.println("Set size: "+set.size());
			//for(int i=0; i<set.size(); i++)
			// out.println(set.get(i));
			set.remove(35);
			out.println("Set: "+set);
			iter = set.iterator();
			iter.next(); iter.next();
			iter.remove(); iter.next();
			out.println("Set after iter.remove(): "+set);
			set.remove(48);
			//iter.next();
			
			out.println();
			
			names.clear();
			names.add("Giants");names.add("Cardinals");
			names.add("Federals");names.add("Cowboys");
			names.add("Eagles");
			words.add("Dodgers"); words.add("Giants");
			words.add("Padres"); words.add("Cardinals");
			words.add("Cubs");
			out.println("names: "+names);
			out.println("words: "+words);
			names.retainAll(words); //keep only any words w/in words
			out.println("names: "+names);
			words.removeAll(names); //remove anything thats also in names
			out.println("words: "+words);
			
			Collection c = new ArrayList();
			c.add(5);
			out.println();
			
			Set<String> b = new TreeSet<String>();
			b.add("a");
			b.add("6");
			b.add("A");
			b.add("d");
			out.println(b);
			
			Collection x = new TreeSet();
			x.add(5);
			out.println(x);
			
			Set<Integer> s = new TreeSet<Integer>();
			s.add(5);
			s.add(6);
			s.add(6);
			s.add(7);
			out.println(s);
			
	}
	
	
}
