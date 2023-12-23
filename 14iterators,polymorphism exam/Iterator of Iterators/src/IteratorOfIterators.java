

import java.util.*;

public class IteratorOfIterators implements Iterator<Integer> {
  private LinkedList<Iterator<Integer>> l;

    public IteratorOfIterators(List<Iterator<Integer>> a) {
      l = new LinkedList<>();
      for (Iterator<Integer> i : a) {
          if(i.hasNext()){
              l.addLast(i);
          }
      }
    }

    @Override
    public boolean hasNext() {
        return !l.isEmpty();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Iterator<Integer> curr = l.removeFirst();
        int ans = curr.next();
        if (curr.hasNext()) {
            l.addLast(curr);
        }
    return ans;
    }
}


