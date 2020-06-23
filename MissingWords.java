import java.util.HashSet;

class MissingWords
{

  public static String[] missingWords(String t, String s) {

    String[] a = t.split(" ");
    String[] b = s.split(" ");
    if(a.length < b.length) {
      return missingWords(s, t);
    }
    String[] missing = new String[a.length - b.length];

    HashSet<String> set = new HashSet<>();
    for(String word : a) {
      set.add(word);
    }

    for(String word : b) {
      if(set.contains(word)) {
        set.remove(word);
      }
    }
    set.toArray(missing);
    return missing;
  }

  public static void main(String [] args) {
    String t = "I am using hackerrank to improve programming";
    String s = "am hackerrank to improve";
    String[] str = missingWords(s, t);
    for(int i = 0; i <str.length; i++) {
      System.out.println(str[i]);
    }
  }
}
