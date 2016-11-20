package uottawa.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramSorting {
    
    public static void main(String[] args) {
        String[] array = {"care", "sets", "sset", "sample", "race", "test", "acre"};
        
        HashMapList mapList = new HashMapList();
        for (String s : array) {
            String sortedStr = sortChars(s);
            mapList.put(sortedStr, s);
        }
        
        String[] finalArray = new String[array.length];
        int index = 0;
        for (Object key : mapList.keySet()) {
            ArrayList<String> list = (ArrayList<String>) mapList.get((String)key);
            for (String val : list) {
                finalArray[index++] = val;
            }
        }
        
        for (String key : finalArray) {
            System.out.println(key);
        }
    }
    
    public static String sortChars(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
    
    public static class HashMapList extends HashMap {
        
        @Override
        public Object put(Object key, Object value) {
            Object existingValue = super.get((String)key);
            
            if (existingValue != null) {
                List<String> existingList = (List<String>) super.get(key);
                existingList.add((String)value);
                super.put((String)key, existingList);
            } else {
                List<String> newList = new ArrayList<String>();
                newList.add((String)value);
                super.put((String)key, newList);
            }
            
            return (String)value;
        }
        
    }

}
