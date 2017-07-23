public class SampleJavaCode {

	public interface List {
		/**
		 * Insert value at given index
		 *
		 * @param index
		 * @param value
		 * @return true if success, false otherwise
		 */
		boolean insert(int index, int value) throws IndexOutOfBoundsException;

		/**
		 * Remove element at given index. If we can't remove false will be returned. I
		 * is safe to call remove on empty list
		 *
		 * @param index
		 * @return true if success, false otherwise
		 */
		boolean remove(int index);

		/**
		 * Getter for value at given index. If such index doesn't work exception should
		 * be thrown
		 *
		 * @param index
		 * @return value at given index
		 */
		int getItem(int index) throws IndexOutOfBoundsException;
	}

	public static class ForwardListImplementation implements List {

		@Override
		public boolean insert(int index, int value) throws IndexOutOfBoundsException {
			if (index >= getSize() + 1) {
				throw new IndexOutOfBoundsException();
			}

			Node newElement = new Node(value);

			if (head == null) {
				head = newElement;
				return true;
			}

			Node previous = getItemNode(index - 1);
			newElement.next = previous.next;
			previous.next = newElement;

			return true;
		}

		@Override
		public boolean remove(int index) {
			Node previous = null;
			try {
				previous = getItemNode(index - 1);
			} catch (IndexOutOfBoundsException ex) {
				if (index == 0) {
					head = null;
					return true;
				}
				return false;
			}

			Node removedNode = previous.next;
			previous.next = removedNode.next;
			return true;
		}

		@Override
		public int getItem(int index) throws IndexOutOfBoundsException {
			return getItemNode(index).value;
		}

		private Node getItemNode(int index) throws IndexOutOfBoundsException {
			if (index == 0 || head == null) {
				if (head == null) {
					throw new IndexOutOfBoundsException("Sorry no such element: " + index);
				}
				return head;
			}

			int currentIndex = 0;

			Node currentNode = head;
			while (currentNode.next != null && currentIndex < index) {
				++currentIndex;
				currentNode = currentNode.next;
			}

			if (currentNode == null) {
				throw new IndexOutOfBoundsException("Sorry no such element: " + index);
			}

			return currentNode;
		}

		public int getSize() {
			if (head == null) {
				return 0;
			}

			int count = 1;
			Node currentNode = head;
			while (currentNode.next != null) {
				++count;
				currentNode = currentNode.next;
			}

			return count;
		}

		private Node head;

		public static class Node {
			public Node(int value) {
				this.value = value;
			}

			int value;
			Node next;
		}// End of Node class
	}// End of ForwardList class
}// End of Main class
