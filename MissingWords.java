class MissingWords
{

  public static String[] missingWords(String t, String s) {

    String[] a = t.split(" ");
    String[] b = s.split(" ");
    int diff = a.length - b.length;
    String [] missing = new String[diff];
    int c = 0;
    for(int i = 0; i < a.length; i++){
      int flag = 0;
      for(int j = 0; j < b.length; j++) {
        if(a[i].equals(b[j])) {
          flag = 1;
          break;
        }
      }
      if(flag == 0) {
        missing[c++] = a[i];
      }
    }
    return missing;
  }

  public static void main(String [] args) {
    String t = "I am using hackerrank to improve programming";
    String s = "am hackerrank to improve";
    String[] str = missingWords(t, s);
    for(int i = 0; i <str.length; i++) {
      System.out.println(str[i]);
    }
  }
}
