package randomizedtest;
import   static org.junit.Assert.*;
import org.junit.Test;
import edu.princeton.cs.algs4.StdRandom;

public class testThreeAddThreeRemove {
    @Test
    public void testThreeAddThreeRemove1(){
        AListNoResizing<Integer> a = new AListNoResizing<>();
        BuggyAList<Integer> b = new BuggyAList<>();
        a.addLast(4);
        b.addLast(4);
        a.addLast(5);
        b.addLast(5);
        a.addLast(6);
        b.addLast(6);
        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> M = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
//                System.out.println("addLast(" + randVal + ")");
                M.addLast(randVal);
//                System.out.println("addLast(BUGGY" + randVal + ")");
            }
            if(operationNumber == 1 ) {
                // size
                if (L.size() > 0 && M.size()>0){
                    int result =  L.getLast();
//                    System.out.println("getlast: " + result);
                    int resultm =  M.getLast();
//                    System.out.println("getlast BUGGY: " + resultm);
                }

            }
            if (operationNumber == 2){
                if( L.size() > 0 && M.size()>0){
                    L.removeLast();
                    int size = L.size();
//                    System.out.println("size: " + size);
                    M.removeLast();
                    int size1 = M.size();
//                    System.out.println("size1: " + size1);
                }

            }
        }
    }
}
