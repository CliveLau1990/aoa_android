package com.vonchenchen.usbmuxd_android;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {

        Calendar cal1 = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8:00"));       //非常关键的！！！
        java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String localTimeStr = sdf.format(cal1.getTime());
        System.out.println(localTimeStr);

        Date d = sdf.parse(localTimeStr);
        long localTime = d.getTime();
        System.out.println(localTime);
    }

//    int[] A = new int[4];
//    A[0] = 127;
//    A[1] = 1033;
//    A[2] = 759;
//    A[4] = 734;
//
    public int[] findKthNumbers(int[] A, int n, int k) {
        // write code here

        int[] ret = new int[k];

        int max = A[0];
        int min = A[0];
        for(int i=0; i<n; i++){
            if(A[i] > max){
                max = A[i];
            }else if(A[i] < min){
                min = A[i];
            }
        }
        int len = max-min+1;
        int[] buf = new int[len];
        for(int i=min; i<=max; i++){
            buf[A[i]-min]++;
        }
        int cnt = 0;
        for(int i=0; i<len; i++){
            if(buf[i] != 0){
                ret[cnt] = A[i-min];
            }
        }
        return ret;
    }

    public boolean chkPalindrome(ListNode A) {
        // write code here
        int len = 1;
        ListNode p = A;
        while(p.next != null){
            len++;
            p = p.next;
        }

        ListNode pStart = A;

        int mid = (int)(len/2);
        ListNode list2 = getByIndex(A, mid);

        ListNode pEnd = revers(list2);

        for(int i=0; i<mid; i++){
            if(pStart.val != pEnd.val){
                return false;
            }else {
                pStart = pStart.next;
                pEnd = pEnd.next;
            }
        }

        return true;
    }

    public ListNode getByIndex(ListNode A, int index){
        ListNode p = A;
        while (index > 0){
            p = p.next;
            index--;
        }
        return p;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode revers(ListNode A){

        ListNode pCurr = A;

        ListNode pPrev = null;
        ListNode pNext = null;

        while (pCurr != null){
            pNext = pCurr.next;
            pCurr.next = pPrev;

            pPrev = pCurr;
            pCurr = pNext;
        }
        return pPrev;
    }
}












