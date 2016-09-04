/**
 * Created by liuyan on 16/9/4.
 */
public class Main {
    public static void main(String[] args) {

    }

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
     * */
    public static ListNode findMid(ListNode list) {
        ListNode fast = list;
        ListNode slow = list;
        while(fast != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 判断回文链表
     * */
    public static boolean isHuiwenList(ListNode list) {
        if(list == null || list.next == null) {
            return true;
        } else {
            ListNode mid = findMid(list);
            ListNode reverseMid = reverse(mid);
            while(reverseMid != null) {
                if(reverseMid.val != list.val) {
                    return false;
                }
                reverseMid = reverseMid.next;
                list = list.next;
            }
            return true;
        }
    }

    public static ListNode deleteDuplicate(ListNode list) {
        return null;
    }

    public static ListNode deleteDuplicateAll(ListNode list) {
        return null;
    }
}
