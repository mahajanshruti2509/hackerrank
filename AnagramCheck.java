/*
Two strings,  and , are called anagrams if they contain all the same characters in the same frequencies. For example, the anagrams of CAT are CAT, ACT, TAC, TCA, ATC, and CTA.

Complete the function in the editor. If  and  are case-insensitive anagrams, print "Anagrams"; otherwise, print "Not Anagrams" instead.

Input Format

The first line contains a string denoting .
The second line contains a string denoting .

Constraints

Strings  and  consist of English alphabetic characters.
The comparison should NOT be case sensitive.
Output Format

Print "Anagrams" if  and  are case-insensitive anagrams of each other; otherwise, print "Not Anagrams" instead.

Sample Input 0

anagram
margana
Sample Output 0

Anagrams

*/


import java.util.Scanner;

public class Solution {
    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        // Complete the function
        java.util.HashMap<Character, Integer> aFreqMap = getFrequencyMap(a.toLowerCase());
        java.util.HashMap<Character, Integer> bFreqMap = getFrequencyMap(b.toLowerCase());
        return isAnagram(aFreqMap, bFreqMap);
    }

    static java.util.HashMap<Character, Integer> getFrequencyMap(String str) {
        java.util.HashMap<Character, Integer> freqMap = new java.util.HashMap<>();
        for(char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        return freqMap;
    }

    static boolean isAnagram(java.util.HashMap<Character, Integer> aFreqMap, java.util.HashMap<Character, Integer> bFreqMap) {
        for(java.util.Map.Entry<Character, Integer> entry : aFreqMap.entrySet()) {
            char aChar = entry.getKey();
            if(!bFreqMap.containsKey(aChar) || bFreqMap.get(aChar) != entry.getValue()) {
                return false;
            }
        }
        return true;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
