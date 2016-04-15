import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class SubstitutionCipherDetector 
{
	 
	
	public void SubstitutionCipherDetector()
	{
	}
	
	
	public static void main(String[] args) 
	{
		String cipherText1 = "giuifg cei iprc tpnn du cei qprcni";
		
		decipher(cipherText1);
	}

	
	public static String decipher(String cipherText)
	{
		//Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		
		Map<Character, Integer> frequencyMap = new TreeMap<Character, Integer>();
		
		for (int i=0; i < cipherText.length(); i++)
		{
			char tempChar = cipherText.charAt(i);
			
			if (frequencyMap.containsKey(tempChar))
			{
				Integer value = frequencyMap.get(tempChar);
				frequencyMap.put(tempChar, value+1);
			}
			else
			{
				frequencyMap.put(tempChar, 1);
			}
		}
		
		
		return "";
	}
	
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortMapByValue(Map<K, V> unsortedMap)
	{
		List<Entry<K,V>> entryList = new LinkedList<Entry<K,V>>(unsortedMap.entrySet());
		
		Collections.sort(entryList, new Comparator<Entry<K,V>>() 
				{
					@Override
					public int compare(Entry<K, V> o1, Entry<K, V> o2) {
						return (o1.getValue()).compareTo(o2.getValue());
					}
				});
		
		entryList.get(entryList.size());
		
		Map<K, V> out = new LinkedHashMap<K,V>();
		
		for (Map.Entry<K, V> entry: entryList)
			out.put(entry.getKey(), entry.getValue());
		
		return out;
	}
	
	
	public static <K, V extends Comparable<? super V>> V getMostUsed(Map<K, V> unsortedMap)
	{
		List<Entry<K,V>> entryList = new LinkedList<Entry<K,V>>(unsortedMap.entrySet());
		
		Collections.sort(entryList, new Comparator<Entry<K,V>>() 
				{
					@Override
					public int compare(Entry<K, V> o1, Entry<K, V> o2) {
						return (o1.getValue()).compareTo(o2.getValue());
					}
				});
		
		return entryList.get(entryList.size()).getValue();
		
	}	
}
