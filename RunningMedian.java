/*
The median of a set of integers is the midpoint value of the data set for which an equal number of integers are less than and greater than the value. To find the median, you must first sort your set of integers in non-decreasing order, then:

If your set contains an odd number of elements, the median is the middle element of the sorted sample. In the sorted set ,  is the median.
If your set contains an even number of elements, the median is the average of the two middle elements of the sorted sample. In the sorted set ,  is the median.
Given an input stream of  integers, you must perform the following task for each  integer:

Add the  integer to a running list of integers.
Find the median of the updated list (i.e., for the first element through the  element).
Print the list's updated median on a new line. The printed value must be a double-precision number scaled to  decimal place (i.e.,  format).

Sample Input

6
12
4
5
3
8
7
Sample Output

12.0
8.0
5.0
4.5
5.0
6.0
*/

import java.util.PriorityQueue;

public class RunningMedian {

  public static double[] getMedian(int[] array) {
    double[] median = new double[array.length];
    PriorityQueue<Integer> lowers = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); //maxHeap
    PriorityQueue<Integer> highers = new PriorityQueue<>(); //minheap

    for(int i = 0; i < array.length; i++) {
      int number = array[i];
      addNumber(number, lowers, highers);
      rebalance(lowers, highers);
      median[i] = calculateMedian(lowers, highers);
    }

    return median;
  }
  private static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
    if(lowers.isEmpty() || number < lowers.peek()) {
      lowers.add(number);
    } else {
      highers.add(number);
    }
  }

  private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
    PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
    PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
    if(biggerHeap.size() - smallerHeap.size() >=2) {
      smallerHeap.add(biggerHeap.poll());
    }
  }

  private static double calculateMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
    PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
    PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

    if(biggerHeap.size() == smallerHeap.size()) {
      return ((double)biggerHeap.peek() + smallerHeap.peek()) / 2;
    } else {
      return biggerHeap.peek();
    }
  }

  public static void main(String[] args) {
    int[] input = {20, 12, 35, 28, 55, 72, 33};
    double[] output = getMedian(input);
    for(double val : output) {
      System.out.println(val);
    }
  }
}
