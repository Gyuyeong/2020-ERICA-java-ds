package linked_list;

public class SinglyLinkedList2018037765 {
	
	/*
	 * [Class] Node
	 *   1) 개요
	 *     - SinglyLinkedList의 data를 담는 노드
	 *     - 각 노드는 다음 노드를 가리키고 있어야 함
	 *     - data type은 정수라고 가정
	 *   2) 필수 operation
	 *     - 생성자
	 *     - getData(): 현재 노드가 가지고 있는 data를 반환하는 함수
	 *     - getNext(): 현재 노드가 가리키고 있는 Node를 반환하는 함수
	 *     - setNext(): 현재 노드의 가리키고 있는 Node를 설정하는 함수
	 */
	
	private static class Node {
		private int data;	// Node에서 저장하는 data
		private Node next;	// Node가 가리키고 있는 다음 노드
		
		/* [필수] 생성자 */
		public Node(int d) {
			// 구현
			data = d;
			next = null;
		}
		
		/* [필수] getData() */
		public int getData() {
			// 구현
			return data;
		}
		
		/* [필수] getNext() */
		public Node getNext() {
			// 구현
			return next;
		}
		
		/* [필수] setNext() */
		public void setNext(Node n) {
			// 구현
			next = n;
		}
	}
	
	/*
	 * [Class] SinglyLinkedList
	 *   1) 개요
	 *     - LinkedList의 첫 번째 노드를 가리키는 head와 마지막 노드를 가리키는 tail이 존재
	 *       -> head/tail을 dummy 노드로 만들어도 좋고, 데이터를 가진 노드로 만들어도 좋음
	 *     - data를 처음/마지막에 추가, 삭제하는 함수를 만들면 됨
	 *   2) 필수 operation
	 *     - getFirst(): linked list의 첫 번째 노드의 data를 반환하는 함수
	 *     - getLast(): linked list의 마지막 노드의 data를 반환하는 함수
	 *     - addFirst(): linked list의 맨 앞에 데이터를 추가
	 *     - addLast(): linked list의 맨 뒤에 데이터를 추가
	 *   3) 추가 operation
	 *     - removeFirst(): linked list의 맨 앞의 노드를 삭제
	 *     - printList(): linked list의 모든 데이터를 출력
	 */
	
	private Node head;	// data의 첫 부분을 가리키는 노드
	private Node tail;	// data의 마지막 부분을 가리키는 노드
	private int size;	// 리스트의 크기를 출력하는 노드 (필요시 사용)
	
	/* [필수] 생성자 */
	public SinglyLinkedList2018037765() {
		// 구현
		head = null;
		tail = null;
		size = 0;
	}
	
	/* 필요시 구현 */
	public int size() {
		// 구현
		return size;
	}
	
	/* 필요시 구현 */
	public boolean isEmpty() {
		// 구현
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/* 
	 * [필수] getFirst()
	 *   - 노드가 아니라 데이터를 반환해야 함
	 *   - 만약 없을 경우 -1 리턴
	 */
	public int getFirst() {
		// 구현
		if (isEmpty()) {            // 비어 있는 경우
			return -1;
		} else {                    // head에 데이터가 있는 경우
			return head.getData();
		}
	}
	
	/* [필수] getLast() */
	public int getLast() {
		// 구현
		if (isEmpty()) {           // 비어 있는 경우
			return -1;
		} else {                   // tail에 데이터가 있는 경우
			return tail.getData();
		}
	}
	
	/* 
	 * [필수] addFirst()
	 *   - 데이터를 입력받아서 추가
	 */
	public void addFirst(int data) {
		// 구현
		Node node = new Node(data);      // 새 Node를 생성한다.
		if (isEmpty()) {                 // 비어 있는 경우
			head = tail = node;			 
		} else {                         // 있는 경우
			node.setNext(head);
			head = node;
		}
		size++;                          // size를 늘려준다
	}
	
	/* [필수] addLast() */
	public void addLast(int data) {
		// 구현
		if (isEmpty()) {                 // 비어 있는 경우
			addFirst(data);              // addFirst와 같다
		} else {                         // 있는 경우
			Node node = new Node(data);  // 새 Node를 생성한다
			tail.setNext(node);
			tail = node;
			size++;                      // size를 늘려준다
		}
	}
	
	/*
	 *  removeFirst()
	 *    - 첫 번째 노드를 삭제하고 data를 반환
	 *    - 만약 없을 경우 -1 리턴
	 */
	public int removeFirst() {
		// 구현
		if (isEmpty()) {                // 비어 있는 경우
			return -1;
		} else {                        // head가 있는 경우
			int data = head.getData();  // head의 데이터를 가져온다
			if (size == 1) {            // head밖에 없었을 경우
				head = tail = null;     // head와 tail을 null로 바꾼다.
			} else {                    // 원소가 2개 이상 있었을 경우
				head = head.getNext();  // 다음 node를 head로 지정한다.
			}
			size--;                     // size를 줄인다.
			
			return data;                // 지운 데이터 값을 반환한다.
		}
	}
	
	/*
	 * printList() : 재귀함수나 반복문으로 구현
	 *   - 형식은 다음과 같이 구현 (마지막 개행 포함)
	 *   > 1 2 3 4 5 
	 */
	public void printList() {
		// 구현
		if (isEmpty()) {                                 // 비어있는 경우
			System.out.println("");
		} else {
			Node node = head;
			while(node.getNext() != null) {
				System.out.print(node.getData() + " ");
				node = node.getNext();
			}
			System.out.print(node.getData() + " \n");
		}
	}
}
