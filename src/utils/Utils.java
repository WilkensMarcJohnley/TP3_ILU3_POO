package utils;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import carte.*;

public class Utils {
	public static <T> T extraire_V1(List<T> carte) {
		//System.out.println("size liste: " + carte.size());
		int random= (int)(Math.random()*(carte.size()));
		T extraction=carte.get(random);
		carte.remove(random);
		return extraction;
	}
	
	public static <T> T extraire_V2(List<T> carte) {
		ListIterator<T> iter= carte.listIterator();
		int random= (int)(Math.random()*(carte.size()));
		T extraction=null;
		for(int i=0;i<random;i++) {
			extraction=iter.next();
		}
		iter.remove();
		return extraction;
	}
	
	public static<T> List<T> melanger(List<T> carte) {
		List<T> result= new ArrayList<>()	;
		while(!carte.isEmpty()){
			result.add(extraire_V1(carte));
		}
		return result;
	}
	
	public static<T> boolean verifierMelange(List<T> li1, List<T> li2) {
		boolean result=true;
		for(ListIterator<T> it=li1.listIterator();it.hasNext();) {
			T next=it.next();
			result= result && (Collections.frequency(li1, next)==Collections.frequency(li2, next));
		}
		return result;
	}
	
	public static <T> List<T> rassembler(List<T> carte){
		List<T> result = new ArrayList<>();
		for(ListIterator<T> it=carte.listIterator();it.hasNext();) {
			T elem= it.next();
			if(!result.contains(elem)) {
				for(T elem1:carte) {
					if(elem.equals(elem1)) {
						result.add(elem1);
					}
				}
			}
		}
		return result;
	}
	
	public static <T> boolean verifierRassemblement(List<T> liste) {
		boolean result=true;
		for(ListIterator<T> it=liste.listIterator();it.hasNext() && result;) {
			T elem=it.next();
			if(it.hasPrevious()) {
				T elem1=it.previous();
				if(elem!=elem1) {
					ListIterator<T> iter= liste.listIterator((liste.size())-1);
					T elem2=iter.previous();
					while(liste.indexOf(elem2)!=liste.indexOf(elem1) && result) {
						if(elem1.equals(elem2)) {
							result=false;
							elem2=iter.previous();
						}
					}
				}
				it.next();
			}
		}
		return result;
	}
	
}
