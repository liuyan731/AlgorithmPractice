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
     * */
    public static char[] changeOrder(char[] chars) {
        int l = 0, r = chars.length - 1;
        while(l < r) {
            if(chars[l] <= 'z' && chars[l] >= 'a') {
                l++;
                continue;
            }

            if(chars[r] >= 'A' && chars[r] <= 'Z') {
                r--;
                continue;
            }

            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
        }
        return chars;
    }

    public static void main(String[] args) {

    }
}
