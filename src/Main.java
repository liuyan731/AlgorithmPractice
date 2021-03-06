import java.util.*;

/**
 * Created by liuyan on 16/9/4.
 */
public class Main {

	/**
	 * 打印金字塔
	 */
	public static void printJinzita(int a) {
		for (int i = 1; i <= a; i++) {
			for (int j = 0; j < a - i; j++) {
				System.out.print(" ");
			}

			for (int j = 0; j < i * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	/**
	 * 打印乘法口诀
	 */
	public static void printChengfakoujue() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + "*" + j + "=" + i * j + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 合并两个有序链表
	 */
	public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else {
			ListNode ret;
			if (l1.val < l2.val) {
				ret = l1;
				ret.next = mergeTwoList(l1.next, l2);
			} else {
				ret = l2;
				ret.next = mergeTwoList(l1, l2.next);
			}
			return ret;
		}
	}

	/**
	 * 将链表的相邻节点互换
	 */
	public static ListNode swapNode(ListNode l) {
		if (l == null || l.next == null) {
			return l;
		} else {
			ListNode ret = l.next;
			ListNode tmp = ret.next;
			ret.next = l;
			l.next = swapNode(tmp);
			return ret;
		}
	}

	/**
	 * 就地逆置链表，非递归
	 */
	public static ListNode reverse(ListNode l) {
		if (l == null || l.next == null) {
			return l;
		} else {
			ListNode p = l.next;
			l.next = null;
			ListNode q = null;
			while (p != null) {
				q = p;
				p = p.next;
				q.next = l;
				l = q;
			}
			return l;
		}
	}

	/**
	 * 就地反转链表，递归版本
	 */
	public static ListNode reverse(ListNode l, ListNode l2) {
		if (l == null) {
			return l2;
		} else {
			ListNode tmp = l.next;
			l.next = l2;
			return reverse(tmp, l);
		}
	}

	/**
	 * 反转数组
	 */
	public static int[] reverse(int nums[]) {
		if (nums.length == 0 || nums.length == 1) {
			return nums;
		} else {
			int l = 0, r = nums.length - 1, mid = (l + r) / 2;
			for (int i = 0; i <= mid; i++) {
				int tmp = nums[i];
				nums[i] = nums[nums.length - i - 1];
				nums[nums.length - i - 1] = tmp;
			}
			return nums;
		}
	}

	/**
	 * 找到链表的中间
	 */
	public static ListNode findMid(ListNode list) {
		ListNode fast = list;
		ListNode slow = list;
		while (fast != null && slow != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	/**
	 * 判断回文链表
	 */
	public static boolean isHuiwenList(ListNode list) {
		if (list == null || list.next == null) {
			return true;
		} else {
			ListNode mid = findMid(list);
			ListNode reverseMid = reverse(mid);
			while (reverseMid != null) {
				if (reverseMid.val != list.val) {
					return false;
				}
				reverseMid = reverseMid.next;
				list = list.next;
			}
			return true;
		}
	}

	/**
	 * 删除已排序链表中重复的节点（保留一个）
	 */
	public static ListNode deleteDuplicate(ListNode list) {
		if (list == null || list.next == null) {
			return list;
		} else {
			ListNode p = list;
			ListNode q = list.next;
			while (p.next != null) {
				if (p.val == q.val) {
					p.next = q.next;
					q = q.next;
				}
				p = p.next;
				q = q.next;
			}
			return list;
		}
	}

	/**
	 * 删除已排序链表中重复的节点（不保留）
	 */
	public static ListNode deleteDuplicateAllMethodOne(ListNode list) {
		if (list == null || list.next == null) {
			return list;
		} else {
			ListNode newHead = new ListNode(-1);
			newHead.next = list;
			ListNode prevNode = newHead;
			ListNode p = prevNode.next;
			ListNode q = p.next;
			int tmp = -999;
			while (p.next != null) {
				if (p.val == q.val) {
					tmp = p.val;
					while (q != null) {
						if (p.val == tmp) {
							prevNode.next = p.next;
							p = p.next;
							q = q.next;
						} else {
							tmp = -999;
							break;
						}
					}
				} else {
					prevNode = prevNode.next;
					p = p.next;
					q = q.next;
					tmp = -999;
				}
			}
			return list;
		}
	}

	public static ListNode deleteDuplicateAllMethodTwo(ListNode list) {
		if (list == null || list.next == null) {
			return list;
		} else {
			ListNode newHead = new ListNode(-1);
			newHead.next = list;
			ListNode p = newHead;
			ListNode q = newHead.next;
			while (q != null) {
				while (q.next != null && q.val == q.next.val) {
					q = q.next;
				}
				if (p.next.val != q.val) {
					p.next = q.next;
					q = p.next;
				} else {
					p = p.next;
					q = q.next;
				}
			}
			return newHead.next;
		}
	}

	/**
	 * 删除链表的倒数第n个节点
	 */
	public static ListNode deleteTailNthElement(ListNode list, int n) {
		ListNode newHead = new ListNode(-1);
		newHead.next = list;
		ListNode fast = newHead;
		ListNode slow = newHead;
		while (fast != null) {
			if (n < 0) {
				slow = slow.next;
			}
			fast = fast.next;
			n--;
		}
		slow.next = slow.next.next;
		return newHead.next;
	}

	/**
	 * 判断链表是否存在环
	 */
	public static boolean hasCycleInList(ListNode list) {
		if (list == null) {
			return false;
		} else {
			ListNode fast = list;
			ListNode slow = list;
			while (fast != null) {
				fast = fast.next.next;
				slow = slow.next;
				if (fast == null) {
					return false;
				}
				if (fast == slow) {
					return true;
				}
			}
			return false;
		}
	}

	/**
	 * 删除链表中的某个节点
	 */
	public static void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

	/**
	 * 删除链表中值为val的节点
	 */
	public static ListNode deleteNode(ListNode list, int val) {
		if (list == null) {
			return null;
		} else {
			ListNode newNode = new ListNode(-1);
			newNode.next = list;
			ListNode p = newNode;
			ListNode q = newNode.next;
			while (q != null) {
				if (q.val == val) {
					q = q.next;
					p.next = q;
				} else {
					p = p.next;
					q = q.next;
				}
			}
			return newNode.next;
		}
	}

	/**
	 * 将char数组中所有小写字母排在大写字母前面
	 */
	public static char[] changeOrder(char[] chars) {
		int l = 0, r = chars.length - 1;
		while (l < r) {
			if (chars[l] <= 'z' && chars[l] >= 'a') {
				l++;
				continue;
			}

			if (chars[r] >= 'A' && chars[r] <= 'Z') {
				r--;
				continue;
			}

			char tmp = chars[l];
			chars[l] = chars[r];
			chars[r] = tmp;
		}
		return chars;
	}

	/**
	 * 打印全排列
	 */
	public static void printQuanpailie(int[] nums, int l, int r) {

		if (l > r) {
			for (int i : nums) {
				System.out.print(i);
			}
			System.out.println();
		}

		for (int i = l; i <= r; i++) {
			swap(nums, i, l);
			printQuanpailie(nums, l + 1, r);
			swap(nums, i, l);
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	/**
	 * 二分查找的相关问题（important） 
	 * 1、普通二分查找递归 
	 * 2、普通二分查找非递归 
	 * 3、找到key首次出现的位置 
	 * 4、找到key最后出现的位置
	 * 5、在变型的排列数组中找到key的位置（5,6,7,8,1,2,3,4 数组前后分别有序）
	 * 6、返回第一个大于等于key的元素下标
	 * 7、返回最后一个小于等于key的元素下标
	 * 8、返回第一个大于key的元素下标，都小于或等于返回-1
	 * 9、返回第一个小于key的元素下标，都大于或等于返回-1
	 */
	public static int binarySearch1(int[] nums, int l, int r, int x) {
		if (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] == x) {
				return mid;
			} else if (nums[mid] > x) {
				return binarySearch1(nums, l, mid - 1, x);
			} else {
				return binarySearch1(nums, mid + 1, r, x);
			}
		} else {
			return -1;
		}
	}

	public static int binarySearch2(int[] nums, int x) {
		int l = 0, r = nums.length - 1, mid;
		while (l <= r) {
			mid = (l + r) / 2;
			if (nums[mid] == x) {
				return mid;
			} else if (nums[mid] > x) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	public static int binarySearch3(int[] nums, int x) {
		int l = 0, r = nums.length - 1, mid;
		while (l <= r) {
			mid = (l + r) / 2;
			if (nums[mid] == x) {
				if (mid == 0) {
					return mid;
				} else if (mid >= 1 && nums[mid - 1] != x) {
					return mid;
				} else {
					r = mid - 1;
				}
			} else if (nums[mid] > x) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	public static int binarySearch4(int[] nums, int x) {
		int l = 0, r = nums.length - 1, mid;
		while (l <= r) {
			mid = (l + r) / 2;
			if (nums[mid] == x) {
				if (mid == nums.length - 1) {
					return mid;
				} else if (mid < nums.length - 1 && nums[mid + 1] != x) {
					return mid;
				} else {
					l = mid + 1;
				}
			} else if (nums[mid] > x) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	public static int binarySearch5(int[] nums, int x) {
		int l = 0, r = nums.length - 1, mid;
		while (l <= r) {
			mid = (l + r) / 2;
			if (nums[mid] == x) {
				return mid;
			} else if (nums[mid] >= nums[l]) {
				if (nums[mid] > x && x >= nums[l]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			} else {
				if (nums[mid] < x && x <= nums[r]) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
		}
		return -1;
	}

	public static int binarySearch6(int[] nums, int x) {
		int l = 0, r = nums.length - 1, mid;
		while(l <= r) {
			mid = (l + r) / 2;
			if(nums[mid] >= x) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		if(l <= nums.length) {
			return l;
		}
		return -1;
	}
	
	public static int binarySearch7(int[] nums, int x) {
		int l = 0, r = nums.length - 1, mid;
		while(l <= r) {
			mid = (l + r) / 2;
			if(nums[mid] <= x) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		if(r >= l) {
			return r;
		}
		return -1;
	}
	
	public static int binarySearch8(int[] nums, int x) {
		int l = 0, r = nums.length - 1, mid;
		while(l <= r) {
			mid = (l + r) /2;
			if(nums[mid] > x) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		if(l <= nums.length - 1) {
			return l;
		}
		return -1;
	}
	
	public static int binarySearch9(int[] nums, int x) {
		int l = 0, r = nums.length - 1, mid;
		while(l <= r) {
			mid = (l + r) / 2;
			if(nums[mid] < x) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		if(r >= l) {
			return r;
		}
		return -1;
	}
	
	/**
	 * 最长公共子串
	 */
	public static String LCString(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		int maxLen = 0, idx = 0;
		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = s2.length() - 1; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[i][j] = dp[i + 1][j + 1] + 1;
					if (dp[i][j] > maxLen) {
						maxLen = dp[i][j];
						idx = i;
					}
				}
			}
		}
		return s1.substring(idx, idx + maxLen);
	}

	/**
	 * 最长递增子串
	 */
	public static void LIString(int[] s) {
		int dp[] = new int[s.length];
		int maxLen = 0, idx = 0;
		for (int i = 1; i < s.length; i++) {
			dp[i] = 1;
			if (s[i] > s[i - 1]) {
				dp[i] = dp[i - 1] + 1;
				if (dp[i] > maxLen) {
					maxLen = dp[i];
					idx = i;
				}
			}
		}
		for (int i = idx - (maxLen - 1); i <= idx; i++) {
			System.out.print(s[i] + " ");
		}
		System.out.println();
		System.out.println(maxLen);
	}

	/**
	 * 最长公共子序列
	 */
	public static String LCSequence(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = s2.length() - 1; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[i][j] = dp[i + 1][j + 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int i = 0, j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) == s2.charAt(j)) {
				sb.append(s1.charAt(i));
				i++;
				j++;
			} else if (dp[i + 1][j] > dp[i][j + 1]) {
				i++;
			} else {
				j++;
			}
		}
		return sb.toString();
	}

	/**
	 * 最长递增子序列
	 */
	public static void LISequence(int[] s) {
		int[] dp = new int[s.length];
		int maxLen = 0;
		for (int i = 0; i < s.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < j; j++) {
				if (s[i] > s[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
				if (dp[i] > maxLen) {
					maxLen = dp[i];
				}
			}
		}
		System.out.println(maxLen);
	}

	/**
	 * QuickSort
	 */
	public static void quickSort(int[] nums, int l, int r) {
		if (l < r) {
			int i = l, j = r, x = nums[l];
			while (i < j) {
				while (i < j && nums[j] > x) {
					j--;
				}
				if (i < j) {
					nums[i++] = nums[j];
				}

				while (i < j && nums[i] < x) {
					i++;
				}
				if (i < j) {
					nums[j--] = nums[i];
				}
			}
			nums[i] = x;
			quickSort(nums, l, i - 1);
			quickSort(nums, i + 1, r);
		}
	}
	
	/**
	 * MergeSort
	 * */
	public static void mergeSort(int[] a, int l, int r, int tmp[]) {
		if(l < r) {
			int mid = (l + r) / 2;
			mergeSort(a, l, mid, tmp);
			mergeSort(a, mid+ 1, r, tmp);
			mergeArray(a, l, r, mid, tmp);
		}
	}
	
	public static void mergeArray(int a[], int l, int r, int mid, int tmp[]) { // 合并数组a[l, mid]和数组a[mid + 1, r]
		int i = l, j = mid + 1;
		int m = mid, n = r;
		int k = 0;
		while(i <= m && j <= n) {
			if(a[i] <= a[j]) {
				tmp[k++] = a[i++];
			} else {
				tmp[k++] = a[j++];
			}
		}
		while(i <= m) {
			tmp[k++] = a[i++];
		}
		while(j <= r) {
			tmp[k++] = a[j++];
		}
		
		for(int q = 0; q < k; q++) {
			a[l + q] = tmp[q];
		}
	}
	
	/**
	 * 设计含有getMin()方法的栈
	 * */
	class GetMinStack {
		private Stack<Integer> stack;
		private Stack<Integer> minStack;
		
		public GetMinStack() {
			stack = new Stack<>();
			minStack = new Stack<>();
		}
		
		public void push(int i) {
			stack.push(i);
			if(minStack.isEmpty() || i <= minStack.peek()) {
				minStack.push(i);
			}
		}
		
		public boolean pop() {
			if(stack.isEmpty()) {
				return false;
			} else {
				if(minStack.peek().equals(stack.peek())) {
					minStack.pop();
				}
				stack.pop();
				return true;
			}
		}
		
		public int getMin() {
			if(minStack.isEmpty()) {
				return -999; // error code
			} else {
				return minStack.peek();
			}
		}
	}
	
	/**
	 * 使用一个栈倒序另外一个栈中的数
	 * */
	public void reverse(Stack<Integer> stack) {
		Stack<Integer> tmp = new Stack<>();
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			int top = stack.pop();
			while (stack.size() > i) {
				tmp.push(stack.pop());
			}
			stack.push(top);
			while (!tmp.isEmpty()) {
				stack.push(tmp.pop());
			}
		}
	}
	
	/**
	 * 使用两个队列实现一个栈
	 * */
	class StackImplementByTwoQueues {
		private Queue<Integer> q1;
		private Queue<Integer> q2;
		public StackImplementByTwoQueues() {
			q1 = new LinkedList<>();
			q2 = new LinkedList<>();
		}
		
		public void push(int x) {	// push操作只在非空队列中进行
			if(q1.isEmpty() && q2.isEmpty()) {
				q1.offer(x);
			} 
			if(!q1.isEmpty()) {
				q1.offer(x);
			}
			if(!q2.isEmpty()) {
				q2.offer(x);
			}
		}
		
		public int pop() throws Exception {
			if(q1.isEmpty() && q2.isEmpty()) {
				throw new Exception("stack is empty");
			} else {
				if(!q1.isEmpty()) {
					while(q1.size() > 1) {
						q2.offer(q1.poll());
					}
					return q1.poll();
				} else if(!q2.isEmpty()) {
					while(q2.size() > 1) {
						q1.offer(q2.poll());
					}
					return q2.poll();
				}
			}
			return 0;
		}
 	}
	
	/**
	 * 使用两个栈实现一个队列
	 * */
	class QueueImplementByTwoStacks {
		private Stack<Integer> s1;
		private Stack<Integer> s2;
		
		public QueueImplementByTwoStacks() {
			s1 = new Stack<>();
			s2 = new Stack<>();
		}
		
		public void push(int x){
			s1.push(x);
		}
		
		public int pop() throws Exception {
			if(!s2.isEmpty()) {
				return s2.pop();
			} else {
				while(!s1.isEmpty()) {
					s2.push(s1.pop());
				}
				if(!s2.isEmpty()) {
					return s2.pop();
				} else {
					throw new Exception("queue is empty");
				}
			}
		}
	}
	
	/**
	 * 二叉树的最大深度
	 * */
	public static int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		} else {
			return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
		}
	}
	
	/**
	 * 二叉树的最小深度
	 * */
	public static int minDepth(TreeNode root) {
		if(root == null) {
			return 0;
		} else {
			if(root.left != null && root.right != null) {
				return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
			} else if(root.left == null) {
				return minDepth(root.right);
			} else {
				return minDepth(root.left);
			}
		}
	}
	
	/**
	 * 判断二叉树是否存在一条从根节点到叶子节点的路径来使得节点之和等于给定的值
	 * */
	public static boolean hasPath(TreeNode root, int sum) {
		if(root == null) {
			return false;
		} else if(root.left == null && root.right == null && sum == root.val){
			return true;
		} else {
			return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
		}
	}
	
	/**
	 * 将二叉树的左右子树互换
	 * */
	public static TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return root;
		} else {
			TreeNode l = root.left;
			TreeNode r = root.right;
			root.left = invertTree(r);
			root.right = invertTree(l);
		}
		return root;
	}
	
	/**
	 * 判断一棵二叉树是否平衡(左右子树的深度不超过1)
	 * */
	public static boolean isBlanceTree(TreeNode root) {
		if(root == null) {
			return true;
		} else if(Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
			return false;
		} else {
			return isBlanceTree(root.left) && isBlanceTree(root.right);
		}
	}
	
	/**
	 * 判断两个二叉树是否相同
	 * */
	public static boolean isSameTree(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null) {
			return true;
		} else if((t1 == null && t2 != null) || (t1 != null && t2 == null) || (t1.val != t2.val)) {
			return false;
		} else {
			return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
		}
	}

    /**
     * 判断一棵树是否左右对称的
     * */
    public static boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    public static boolean helper(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) {
            return node1 == node2;
        } else if (node1.val != node2.val) {
            return false;
        } else {
            return helper(node1.left, node2.right) && helper(node1.right, node2.left);
        }
    }

    /**
     * 打印二叉树的所有路径
     * */
    public static List<String> binaryTreePaths(TreeNode root) {
        helper(root, "");
        return list;
    }

    public static List<String> list = new ArrayList<>();

    public static void helper(TreeNode root, String path) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            list.add(path + root.val);
        }
        if(root.left != null) {
            helper(root.left, path + root.val + "->");
        }
        if(root.right != null) {
            helper(root.right, path + root.val + "->");
        }
    }

    /**
     * 按层次打印二叉树
     * */
    public List<List<Integer>> levelOrder(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<>();
    	List<List<Integer>> ret = new ArrayList<>();
    	if(root == null) {
    		return ret;
    	} else {
    		queue.offer(root);
    		while(!queue.isEmpty()) {
    			List<Integer> list = new ArrayList<>();
    			int size = queue.size();
    			for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();
					if(node.left != null) {
						queue.offer(node.left);
					}
					if(node.right != null) {
						queue.offer(node.right);
					}
					list.add(node.val);
				}
    			ret.add(list);
    		}
    	}
    	return ret;
    }
    
    /**
     * 判断二叉树是否为完全二叉树
     * */
    public boolean isCompleteTree(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		TreeNode node;
		while((node = queue.poll()) != null) {
			queue.offer(node.left);
			queue.offer(node.right);
		}
		while(!queue.isEmpty()) {
			if(queue.poll() != null) {
				return false;
			}
		}
    	return true;
    }

    /**
	 * 在二叉查找树中寻找两个节点相同的祖先节点（lowest common ancestor LCA）
	 * 二叉查找树：任意左子树值 < 根节点值 < 右子树值
	 * */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while((root.val - p.val) * (root.val - q.val) > 0) {
			root = p.val < root.val ? root.left : root.right;
		}
    	return root;
	}

	/**
	 * 前缀树
	 * */
	class TriesTree {
		class Node {
			protected boolean isEnd;
			protected Map<Character, Node> children;
			protected int count;
			public Node() {
				isEnd = false;
				children = new HashMap<>();
				count = 0;
			}
		}

		private Node root;

		public TriesTree() {
			root = new Node();
		}

		public void insert(String str) {
			Node node = root;
			for (int i = 0; i < str.length(); i++) {
				if(!node.children.containsKey(str.charAt(i))) {
					node.children.put(str.charAt(i), new Node());
				}
				node = node.children.get(str.charAt(i));
			}
			node.isEnd = true;
			node.count++;
		}

		public boolean find(String word) {
			Node node = root;
			for (int i = 0; i < word.length(); i++) {
				if(!node.children.containsKey(word.charAt(i))) {
					return false;
				}
				node = node.children.get(word.charAt(i));
			}
			return node.isEnd;
		}
	}

	/**
	 * 二叉树的前序遍历，递归、非递归
	 * */
	public List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		if(root == null) {
			return ret;
		} else {
			ret.add(root.val);
			ret.addAll(preorderTraversal1(root.left));
			ret.addAll(preorderTraversal1(root.right));
		}
		return ret;
	}

	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if(node != null) {
				ret.add(node.val);
				stack.push(root.right);
				stack.push(root.left);
			}
		}
		return ret;
	}

	/**
	 * 二叉树的中序遍历，递归、非递归
	 * */
	public List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		if(root == null) {
			return ret;
		} else {
			ret.addAll(preorderTraversal1(root.left));
			ret.add(root.val);
			ret.addAll(preorderTraversal1(root.right));
		}
		return ret;
	}

	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while(!stack.isEmpty() || node != null) {
			while(node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			ret.add(node.val);
			node = node.right;
		}
		return ret;
	}

	/**
	 * 二叉树的后序遍历，递归、非递归
	 * */
	public List<Integer> postorderTraversal1(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		if(root == null) {
			return ret;
		} else {
			ret.addAll(preorderTraversal1(root.left));
			ret.addAll(preorderTraversal1(root.right));
			ret.add(root.val);
		}
		return ret;
	}

	public List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while(!stack.isEmpty() || node != null) {
			if(node != null) {
				stack.push(node);
				ret.add(0, node.val);
				node = node.right;
			} else {
				TreeNode tmp = stack.pop();
				node = tmp.left;
			}
		}
		return ret;
	}

	/**
	 * 求一个数的质因子分解，90 ＝ 2 ＊ 3 ＊ 3 ＊ 5
	 * */
	public static List<Integer> getPrimeFactors(int num) {
		List<Integer> ret = new ArrayList<>();
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				ret.add(i);
				num /= i;
				i = 1;
			}
		}
		ret.add(num);
		return ret;
	}

	/**
	 * 求一个字符串中第一个只出现一次的字符
	 * */
	public static char getFirstNoRepeatChar(String str) {
		char[] cs = str.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (char c : cs) {
			map.put(c, map.containsKey(c) ? (map.get(c) + 1) : 1);
		}
		for (Map.Entry<Character, Integer> e : map.entrySet()) {
			if(e.getValue() == 1) {
				return e.getKey();
			}
		}
		return 0;
	}

	/**
	 * 高效求数值的整数次方
	 * */
	public static int powN(int num, int n) {
		if(n == 0) {
			return 1;
		} else if(n == 1) {
			return num;
		} else {
			int tmp = powN(num, n / 2);
			if(n % 2 == 0) {
				return tmp * tmp;
			} else {
				return tmp * tmp * num;
			}
		}
	}
	
	/**
	 * 判断一个数是否为2的整数次幂
	 * */
	public static boolean is2Pow(int n) {
		return (n & (n - 1)) == 0 ? true : false; 
	}
	
	/**
	 * 判断一个数是否为丑数(只包含因子2,3,5的数)
	 * */
	public static boolean idUglyNum(int num) {
		while(num % 2 == 0) {
			num /= 2;
		}
		while(num % 3 == 0) {
			num /= 3;
		}
		while(num % 5 == 0) {
			num /= 5;
		}
		return num == 1 ? true : false;
	}
	
	/**
	 * 菲波那切、上台阶....
	 * 递归：效率低下，非递归：效率高
	 * */
	public static int fib1(int n) {
		if(n == 0 || n == 1) {
			return n;
		} else {
			return fib1(n - 1) + fib1(n - 2);
		}
	}
	
	public static int fib2(int n) {
		int[] ret = new int[n + 1];
		ret[0] = 0;
		ret[1] = 1;
		for (int i = 2; i <= n; i++) {
			ret[i] = ret[i - 1] + ret[i - 2];
		}
		return ret[n];
	}
	
	/**
	 * 求一个数组的最大连续子数组的最大和
	 * */
	public static int findMaxSum(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(dp[i - 1] < 0) {
				dp[i] = nums[i];
			} else {
				dp[i] = dp[i - 1] + nums[i];
			}
		}
		int max = dp[0];
		for (int i : dp) {
			if(i > max) {
				max = i;
			}
		}
		return max;
	}

	/**
	 * 进制转换
	 * 二（八）进制转十进制
	 * 十进制转二（八）进制
	 * 十六进制转十进制
	 * 十进制转十六进制
	 * */
	public static int BinaryToDecimal(String str) {
		char[] cs = str.toCharArray();
		int ret = 0;
		for (int i = 0; i < cs.length; i++) {
			ret += Integer.parseInt(cs[i] + "") * Math.pow(2, str.length() - 1 - i);
		}
		return ret;
	}
	
	public static String DecimalToBinary(int num) {
		StringBuilder sb = new StringBuilder("");
		while(num > 0) {
			sb.append(num % 2);
			num /= 2;
		}
		return sb.reverse().toString();
	}
	
	public static int HexToDecimal(String str) {
		char[] cs = str.toCharArray();
		int ret = 0;
		for (int i = 0; i < cs.length; i++) {
			if(cs[i] >= '0' && cs[i] <= '9') {
				ret += (int)((cs[i] - '0') * Math.pow(16, cs.length - 1 - i));
			} else if(cs[i] >= 'A' && cs[i] <= 'B') {
				ret += (int)((cs[i] - 'A' + 10) * Math.pow(16, cs.length - 1 - i));
			}
		}
		return ret;
	}
	
	public static String DecimalToHex(int num) {
		StringBuilder sb = new StringBuilder("");
		while(num > 0) {
			if(num % 16 >= 0 && num % 16 <= 9) {
				sb.append(num % 16);
			} else if(num % 16 >= 10 && num % 16 <= 15) {
				sb.append((char)(num % 16 - 10 + 'A'));
			}
			num /= 16;
		}
		return sb.reverse().toString();
	}
	
	/**
	 * 一个大小为100的数组，存储1~99的数，其中有两个数是一样的，找出这个数
	 * 分析：就是1~99的数都有，且其中有一个出现两次
	 * */
	public static int findRepeatNum(int[] nums) {
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < nums.length; i++) {
			sum1 += i;
			sum2 += nums[i];
		}
		return sum2 - sum1;
	}
	
	/**
	 * 一个大小为100的数组，存储0~99的数，其中有两个数是一样的，找出这个数
	 * 分析：存储0~99，说明有一个数缺失，有一个数重复一次
	 * */
	public static int findRepeatNum2(int[] nums) {
		int sum1 = 0;
		int sum2 = 0;
		// 假设重复的元素为a， 缺失的元素为b
		for (int i = 0; i < nums.length; i++) {
			sum1 += nums[i] - i; //a - b
			sum2 += nums[i] * nums[i] - i * i; //a*a - b*b
		}
		return ((sum2 / sum1) + sum1) / 2;
	}
	
	/**
	 * 一个数组中除了某一个元素之外，其它的元素都重复了一次，求这个没有重复的元素
	 * */
	public static int findNotRepeatOne(int[] nums) {
		int ret = 0;
		for (int i = 0; i < nums.length; i++) {
			ret ^= nums[i];
		}
		return ret;
	}
	
	public static void main(String[] args) {
//		int[] nums2 = { 5, 1, 2, 3, 8 };
//		int[] tmp = new int[nums2.length];
//		mergeSort(nums2, 0, nums2.length - 1, tmp);
//		for (int i : nums2) {
//			System.out.println(i);
//		}
//		System.out.println(fib1(10000));
		System.out.println(BinaryToDecimal("10101"));
		System.out.println(DecimalToBinary(21));
		
		System.out.println(HexToDecimal("1A"));
		System.out.println(DecimalToHex(26));
	}

}
