import java.util.*;

public class IteratorOfIteratorsTest {
    public static void main(String[] args) {
        // 测试基本功能
        List<Integer> listA = Arrays.asList(1, 3, 4, 5);
        List<Integer> listB = Collections.emptyList(); // 空列表
        List<Integer> listC = Collections.singletonList(2);

        List<Iterator<Integer>> iterators = new ArrayList<>();
        iterators.add(listA.iterator());
        iterators.add(listB.iterator());
        iterators.add(listC.iterator());

        IteratorOfIterators i = new IteratorOfIterators(iterators);

        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        // 预期输出: 1 2 3 4 5
    }
}
