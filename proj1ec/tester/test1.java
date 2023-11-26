package tester;

import org.junit.Test;
import student.StudentArrayDeque;
import static org.junit.Assert.*;
public class test1 {
    @Test
    public void mytest() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        //ArrayDequeSolution<Integer> sad2 = new ArrayDequeSolution<>();
        sad1.addFirst(13);
        sad1.addLast(13);
        sad1.addLast(10);
        sad1.addFirst(3);
        sad1.addFirst(16);
        sad1.addFirst(10);
        sad1.addLast(7);
        sad1.addFirst(11);
        sad1.addFirst(17);
        sad1.addLast(0);
        assertEquals((Integer) 17, sad1.removeFirst());
        assertEquals((Integer) 11, sad1.removeFirst());
        assertEquals((Integer) 10, sad1.removeFirst());
        assertEquals((Integer) 16, sad1.removeFirst());
        assertEquals((Integer) 3, sad1.removeFirst());
        assertEquals((Integer) 13, sad1.removeFirst());
        assertEquals((Integer) 13, sad1.removeLast());
    }
}
