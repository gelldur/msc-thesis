/*
 * Decompiled with CFR 0_122.
 */
public class SampleJavaCode {

	public static class ForwardListImplementation implements List {
		private Node head;

		@Override
		public boolean insert(int n, int n2) throws IndexOutOfBoundsException {
			if (n >= this.getSize() + 1) {
				throw new IndexOutOfBoundsException();
			}
			Node node = new Node(n2);
			if (this.head == null) {
				this.head = node;
				return true;
			}
			Node node2 = this.getItemNode(n - 1);
			node.next = node2.next;
			node2.next = node;
			return true;
		}

		@Override
		public boolean remove(int n) {
			Node node = null;
			try {
				node = this.getItemNode(n - 1);
			} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
				if (n == 0) {
					this.head = null;
					return true;
				}
				return false;
			}
			Node node2 = node.next;
			node.next = node2.next;
			return true;
		}

		@Override
		public int getItem(int n) throws IndexOutOfBoundsException {
			return this.getItemNode((int) n).value;
		}

		private Node getItemNode(int n) throws IndexOutOfBoundsException {
			if (n == 0 || this.head == null) {
				if (this.head == null) {
					throw new IndexOutOfBoundsException("Sorry no such element: " + n);
				}
				return this.head;
			}
			Node node = this.head;
			for (int i = 0; node.next != null && i < n; ++i) {
				node = node.next;
			}
			if (node == null) {
				throw new IndexOutOfBoundsException("Sorry no such element: " + n);
			}
			return node;
		}

		public int getSize() {
			if (this.head == null) {
				return 0;
			}
			int n = 1;
			Node node = this.head;
			while (node.next != null) {
				++n;
				node = node.next;
			}
			return n;
		}

		public static class Node {
			int value;
			Node next;

			public Node(int n) {
				this.value = n;
			}
		}

	}

	public static interface List {
		public boolean insert(int var1, int var2) throws IndexOutOfBoundsException;

		public boolean remove(int var1);

		public int getItem(int var1) throws IndexOutOfBoundsException;
	}

}
