package tester;
import static org.junit.Assert.*;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {
    @Test
    public void testOutput() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sad2 = new ArrayDequeSolution<>();
        String errString = new String();
        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            int n = StdRandom.uniform(20);
            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(n);
                sad2.addLast(n);
                errString += ("addLast(" + n + ")\n");
            } else {
                sad1.addFirst(n);
                sad2.addFirst(n);
                errString += ("addFirst(" + n + ")\n");
            }
        }
//        int size1 = sad1.size();
//        errString += ("size(): " + size1 + "\n");
//        assertEquals(errString, sad2.size(), sad1.size());
        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                Integer item1 = sad1.removeLast();
                Integer item2 = sad2.removeLast();
                errString += ("removeLast(): " + item2 +"\n");
                assertEquals(errString, item2, item1);


            } else {
                Integer item1 = sad1.removeFirst();
                Integer item2 = sad2.removeFirst();
                errString += ("removeFirst(): " + item2 + "\n");
                assertEquals(errString, item2, item1);

        }
//        int size2= sad1.size();
//        errString += ("size(): " + size2 + "\n");
//        assertEquals(errString, sad2.size(), sad1.size());
    }

}

}
