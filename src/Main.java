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
                if(s[i] > s[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
                if(dp[i] > maxLen) {
                    maxLen = dp[i];
                }
            }
        }
        System.out.println(maxLen);;
    }

    public static void main(String[] args) {
        String s1 = "abcdefg";
        String s2 = "eafbgchd";
        System.out.println(LCString(s1, s2));
        System.out.println(LCSequence(s1, s2));
        int[] nums = {5, 1, 2, 3, 8};
        LIString(nums);
    }

}
