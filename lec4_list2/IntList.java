package lec4_lists2;

public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if (rest == null) {
			return 1;
		}
		return 1 + this.rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList p = this;
		int totalSize = 0;
		while (p != null) {
			totalSize += 1;
			p = p.rest;
		}
		return totalSize;
	}

	/** Returns the ith item of this IntList. */
	public int get(int i) {
		if (i == 0) {
			return first;
		}
		return rest.get(i - 1);
	}

	public void addAdjacent() {
		IntList p = this;
		while (p != null && p.rest != null) {
			if (p.first == p.rest.first) {
				p.first *= 2;
				p.rest = p.rest.rest;
			} else {
				p = p.rest;
			}

		}
	}

	public void printList() {
		IntList current = this;
		while (current != null) {
			System.out.print(current.first + " → ");
			current = current.rest;
		}
		System.out.println("null");
	}



	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(5, L);
		L = new IntList(5, L);
		L = new IntList(1, L);
		L.printList();
		L.addAdjacent();
		System.out.println(L);
		L.printList();
		//System.out.println(L.get(100));
	}


} 
