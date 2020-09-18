package com.test.hello;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Main mn = new Main();
        Boolean fn = null;
        System.out.println(fn != null && fn ? true: false);

       /* System.out.println("" + isSemiPrime(21));
        System.out.println("" + isSemiPrime(22));
        System.out.println("" + isSemiPrime(26));
        System.out.println("---------------------------");
        System.out.println("" + countSemiPrimes(1, 26));
        System.out.println("" + countSemiPrimes(4, 10));
        System.out.println("" + countSemiPrimes(16, 20));*/

        System.out.println("---------------------------");

        /*System.out.println("" + solution(new int[]{20, 21, 50, 60, 70}));

        System.out.println("" + solution(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println("" + solution(new int[]{1, 2, 3}));
        System.out.println("" + solution(new int[]{-1, -3}));
         System.out.println("" + generate());

         */

        //solution("baaabbabbbaaaabaaabbbaaabbb");

        /*System.out.println("" + solution(new int[]{
                4, 2, 3, 4, 3, 4, 1, 2, 3, 4,
                6, 2, 5, 7, 1, 2, 3, 4, 3, 4,
                8, 2, 3, 4, 6, 2, 7, 8, 9, 1,
                5, 3, 4, 3, 4, 1, 2, 3, 4, 6,
                4,3, 2}));*/
        //System.out.println("" + solution(45));
        //System.out.println("" + solution(64));
        //System.out.println("" + solution(48));

        //printArr(solution(new int[]{3, 1, 2, 3, 6}));

        //printArr(solution(26, new int[]{1, 4, 16}, new int[]{26, 10, 20}));

        //printArr(getPrimeDivisors(75));
        //printArr(getPrimeDivisors(88));
        //printArr(getPrimeDivisors(75));

        //System.out.println("xxx: " + solution(new int[]{15, 10, 9}, new int[]{75, 30, 5}));


        //System.out.println("xx: " + solution(new int[]{3, 1, 2, 3, 6}));

/*
        System.out.println("xx: " + solution(new int[]{1000000000}));
        System.out.println("xx: " + solution(new int[]{5, 6, 7, 8}));

        System.out.println("xx: " + solution(new int[]{-8, 4, 5, -10, 3}));
        System.out.println("xx: " + solution(new int[]{-67, -78, 1, 4, -5, -6}));
        System.out.println("xx: " + solution(new int[]{10, 2, 5, 1, 8, 12}));
        System.out.println("xx: " + solution(new int[]{10, 2, 5, 1, 8, 12, -45, 6, 7, 8, -67, 45, -34, -23}));
        System.out.println("xx: " + solution(new int[]{10, 2, -5, 1, -8, 12, -46, 6, 7, 10, -67, 45, -34, -23, 6776, 5656, 454, -4545, -4534, 456}));
 */


       /* System.out.println("xx: " + solution(8, new int[]{-67, -78, 1, 4, -5, -6}));
        System.out.println("xx: " + solution(9, new int[]{10, 2, 5, 1, 8, 12}));
        System.out.println("xx: " + solution(12, new int[]{10, 2, 5, 1, 8, 12, -45, 6, 7, 8, -67, 45, -34, -23}));
        System.out.println("xx: " + solution(36, new int[]{10, 2, -5, 1, -8, 12, -46, 6, 7, 10, -67, 45, -34, -23, 6776, 5656, 454, -4545, -4534, 456}));
*/

        //System.out.println("xx: " + solution(new int[]{23, 22, 67, 78, 1, 4, 18, 5, 6}));


        /*System.out.println("xx: " + mn.solution88(new int[]{6, 6, 6, 6, 6, 6}, 10));
        System.out.println("xx: " + mn.solution88(new int[]{1, 2, 5, 1, 1, 2, 3, 5, 1}, 5));
        System.out.println("xx: " + mn.solution88(new int[]{12, 34, 5, 7, 8, 9, 9, 34, 22, 69, 7, 89, 2, 5, 1, 1, 23, 36, 7, 4, 5, 2, 3, 5, 1}, 5));

        System.out.println("xx: " + mn.solution88(new int[]{2, 4, 8, 16, 32, 64, 128, 8, 16, 256, 512, 32, 1024, 2048, 4096, 8192}, 4));

        System.out.println("xx: " + mn.solution95(new int[]{-1, 6, 3, 4, 7, 4}));*/

        //System.out.println("xx: " + mn.solution(new Tree(5, new Tree(3, new Tree(20, null, null), new Tree(21, null, null)), new Tree(10, new Tree(1, null, null), null)  )) );

        System.out.println("xx: " + mn.solution(2, new int[]{1, 2, 1, 1}, new int[]{1, 4, 3, 2, 4}));
    }


    public int solution(int K, int[] C, int[] D) {
        Arrays.sort(C);
        Arrays.sort(D);

        int[] result = Arrays.copyOf(C, C.length + D.length);
        System.arraycopy(D, 0, result, C.length, D.length);

        int[] distinctOrdered = Arrays.stream(result).sorted().distinct().toArray();

        List<Integer> comb = new ArrayList<>();
        int all = 0;
        for (int el : distinctOrdered) {
            int num1 = countOccurences(C, el);
            int num2 = countOccurences(D, el);

            if (num1 % 2 == 0) {
                if (num2 % 2 == 0) {
                    int diff = (all + num2 > K ? (all + num2 - K) : 0);

                    all += num2;
                    addElemNTimes(comb, el, num2 -diff);
                } else {
                    int diff = (all + num2 > K ? (all + num2 - K) : 0);
                    all += (num2 - 1);
                    addElemNTimes(comb, el, num2 - 1-diff);
                }
            }
            if (all >= K) {
                break;
            }

            if (num1 % 2 == 1) {
                if (num2 % 2 == 1) {
                    int diff = (all + num2 > K ? (all + num2 - K) : 0);

                    all += num2;
                    addElemNTimes(comb, el, num2-diff);
                } else {
                    int diff = (all + num2 > K ? (all + num2 - K) : 0);

                    all += (num2 - 1);
                    addElemNTimes(comb, el, num2 - 1 -diff);
                }
            }
            if (all >= K)
                break;
        }

        for (int el : C) {
            comb.add(el);
        }

        return (comb.size() / 2);
    }

    private void addElemNTimes(List<Integer> comb, int elem, int numTimes) {
        for (int i = 0; i < numTimes; i++) {
            comb.add(elem);
        }
    }

    public static int solution(Tree T) {
        int num1 = 1, num2 = 1;
        if (T == null)
            return 0;

        if (T.l == null && T.r == null)
            return 0;

        if (T.l != null) {
            if (countNodes(T.l) > 0)
                num1++;
        }

        if (T.r != null) {
            if (countNodes(T.r) > 0)
                num2++;
        }

        return (num1 > num2 ? num1 : num2);
    }

    public static int countNodes(Tree t) {
        if (t == null)
            return 0;

        int num1 = 1, num2 = 1;
        if (t.l != null)
            num1 += countNodes(t.l);

        if (t.r != null)
            num2 += countNodes(t.r);

        return (num1 > num2 ? num1 : num2);
    }


    static class Tree {
        public int x;
        public Tree l;
        public Tree r;

        public Tree(int x1, Tree l1, Tree r1) {
            this.x = x1;
            this.l = l1;
            this.r = r1;
        }
    }


    public int solution98(String S) {
        if (S == null || S.length() <= 1)
            return 0;

        int mid = (S.length() / 2);
        String str1 = S.substring(0, mid);
        StringBuffer buf = new StringBuffer(S.substring(mid + 1));
        String str3 = buf.reverse().toString();

        if (str1.equals(str3))
            return mid;

        return -1;
    }


    public int solution95(int[] A) {
        int num = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j])
                    num++;
            }
        }
        return (num > 1000000000 ? -1 : num);
    }


    //final int[] distinctOrdered = Arrays.stream(A).sorted().distinct().toArray();

    public int solution88(int[] A, int X) {
        Arrays.sort(A);

        //System.out.println(Arrays.toString(A));
        //System.out.println(Arrays.deepToString(A));


        int[] distinctOrdered = Arrays.stream(A).sorted().distinct().toArray();
        Set<Integer> set2 = new TreeSet<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int elem : distinctOrdered) {
            int num = countOccurences(A, elem);
            if (num >= 2) {
                set2.add(elem);
                map.put(elem, num);
            }
        }

        int[] copy2 = set2.stream().mapToInt(Integer::intValue).toArray();
        Set<String> all = new TreeSet<>();
        for (int elem : set2) {
            Set<String> res = getCombinationsEx(elem, copy2, X, map);
            all.addAll(res);
        }
        return all.size();
    }

    public int countOccurences(int[] A, int check) {
        int num = 0;
        for (int elem : A) {
            if (elem > check)
                break;
            else if (elem == check)
                num++;
        }
        return num;
    }

    public Set<String> getCombinationsEx(int check, int[] copy, int X, Map<Integer, Integer> map) {
        Set<String> pairs = new TreeSet<>();
        for (int i = 0; i < copy.length; i++) {
            if (check > copy[i])
                continue;

            if (check * copy[i] >= X) {
                if (check == copy[i]) {
                    if (map.get(check) < 4)
                        continue;
                }
                String str = "" + check + "," + copy[i];
                pairs.add(str);
            }
        }
        return pairs;
    }

    public static String solution123(String pwd) {

        String[] arrs = pwd.split(" ");
        for (String elem : arrs) {
            if (validate(elem)) {
                System.out.println(elem);
            }
        }
        return "xx";

    }

    public static boolean validate(final String password) {
        final String PASSWORD_PATTERN = "(^(?:[a-z][A-Z]{2})*$)";  //(^(?:[0-9]{2})*$)

        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static int solution99(final int[] A) {
        if (A == null || A.length <= 2)
            return 0;

        int copy[] = Arrays.copyOf(A, A.length);

        int maxHeight = 0;
        for (int i = 0; i < A.length - 2; i++) {
            int elem1 = Math.min(copy[i], copy[i + 2]);
            int elem2 = Math.max(copy[i], copy[i + 2]);
            int elemMid = copy[i + 1];

            if (elem1 > elemMid && elemMid < elem2) {
                if (elem1 - elemMid > maxHeight)
                    maxHeight = elem1 - elemMid;
            }
        }

        return maxHeight;
    }

    public static int solution67(final int[] A) {
        if (A == null || A.length <= 2)
            return 0;

        int copy[] = Arrays.copyOf(A, A.length);
        Arrays.sort(copy);

        for (int i = copy.length - 1; i > 0; i--) {
            int elem2 = copy[i];
            int elem1 = copy[i - 1];

            int pos1 = getElementIndex(A, elem1);
            int pos2 = getElementIndex(A, elem2);

            if (Math.abs(pos2 - pos1) > 1) {

                int pos11 = Math.min(pos1, pos2);
                int pos22 = Math.max(pos1, pos2);

                int smallest = smallestElem(A, pos11, pos22);
                if (smallest < elem1 && elem1 <= elem2) {
                    return (elem1 - smallest);
                }
            }
        }

        return 1;
    }

    public static int smallestElem(int[] arr, int start, int end) {
        int min = 1000000000;
        for (int i = start; i < end; i++) {
            if (arr[i + 1] <= 1)
                return arr[i + 1];

            if (arr[i + 1] < min)
                min = arr[i + 1];
        }
        return min;
    }

    public static int getElementIndex(int[] copy, int search) {
        int pos = 0;
        for (int elem : copy) {
            if (elem == search)
                return pos;

            pos++;
        }
        return -1;
    }

    public static int solution33(int M, int[] A) {
        if (A == null || A.length == 0)
            return 0;

        if (A.length == 1)
            return 1;

        Arrays.sort(A);
        Set<Integer> set = new HashSet<>();
        for (int elem : A) {
            if (elem <= M)
                set.add(elem);
        }

        int copy[] = new int[set.size()];
        int k = 0;
        for (int elem : set) {
            copy[k++] = elem;
        }

        Set<String> all = new HashSet<>();
        for (int elem : set) {
            Set<String> set2 = getCombinations(elem, copy);
            all.addAll(set2);
        }
        for (String str : all) {
            System.out.println(str);
        }

        return all.size();
    }

    public static Set<String> getCombinations(int check, int[] copy) {
        Set<String> pairs = new HashSet<>();
        for (int i = 0; i < copy.length; i++) {
            int val1 = (check < copy[i] ? check : copy[i]);
            int val2 = (check > copy[i] ? check : copy[i]);
            String str = "" + val1 + "," + val2;
            pairs.add(str);
        }
        return pairs;
    }


    public static int solution12(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        if (A.length == 1)
            return Math.abs(2 * A[0]);

        Arrays.sort(A);
        /*Set<Integer> set = new HashSet<>();
        for (int elem : A) {
            set.add(elem);
        }

        Set<Integer> set2 = new TreeSet<>(set);

        int copy3[] = new int[set2.size()];
        int k = 0;
        for (int elem : set2) {
            copy3[k++] = elem;
        }*/

        int negIndex = getNegatesLatestIndex(A);
        int posIndex = 0;
        if (negIndex == -1)
            posIndex = 0;

        if (negIndex >= 0)
            posIndex = (A.length - negIndex == 1 ? -1 : (A.length - negIndex - 1));

        if (negIndex != -1 && posIndex != -1) {
            int min = 10000000;
            for (int t = posIndex; t < A.length; t++) {
                int positElem = A[t];
                for (int i = negIndex; i >= 0; i--) {
                    int sm = Math.abs(positElem + A[i]);
                    if (sm <= 1)
                        return sm;

                    if (sm < min)
                        min = sm;
                }
            }
            return min;
        }

        if (negIndex == -1) {
            return 2 * A[0];
        }

        if (posIndex == -1) {
            return Math.abs(2 * A[A.length - 1]);
        }
        return 0;
    }

    public static int getNegatesLatestIndex(int[] copy) {
        int i = -1;
        for (i = 0; i < copy.length; i++) {
            if (copy[i] >= 0)
                return (i - 1);
        }
        return (i > 0 && copy[copy.length - 1] <= 0 ? (i - 1) : 0);
    }

    public static int getPositivesFirstIndex(int[] copy) {
        int pos = 0;
        for (int elem : copy) {
            if (elem > 0)
                return (pos == 0 ? 0 : pos);

            pos++;
        }
        return -1;
    }


    public static int solution19(int[] A) {
        int copy[] = A;
        Arrays.sort(copy);

        Integer[] copy2 = Arrays.stream(copy)
                .boxed()
                .toArray(Integer[]::new);

        HashSet<Integer> set = new HashSet<>(Arrays.asList(copy2));

        Set<String> triangles = new HashSet<>();
        for (int elem : set) {
            Set<String> set2 = getTriangleArrsNum(elem, copy);
            triangles.addAll(set2);
        }

        int num = 0;

        for (String str : triangles) {
            //System.out.println("--- "+str);
            String arr[] = str.split("#");
            if (str.length() > 10) {
                if (isTrianglePossibleEx2(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]))) {
                    System.out.println("--- " + str);
                    num++;
                }
            } else {
                if (isTrianglePossibleEx(Long.parseLong(arr[0]), Long.parseLong(arr[1]), Long.parseLong(arr[2]))) {
                    System.out.println("--- " + str);
                    num++;
                }
            }
        }
        return num;
    }


    public static Set<String> getTriangleArrsNum(int check, int[] copy) {
        Set<String> triangles = new HashSet<>();
        for (int i = 0; i < copy.length - 1; i++) {
            if (check == copy[i] || check == copy[i + 1])
                continue;

            int arr[] = new int[]{check, copy[i], copy[i + 1]};
            Arrays.sort(arr);
            String str = "" + arr[0] + "#" + arr[1] + "#" + arr[2];
            triangles.add(str);
        }
        return triangles;
    }

    public static boolean isTrianglePossibleEx(long aa, long bb, long cc) {
        return ((aa + bb > cc) && (aa + cc > bb) && (cc + bb > aa));
    }

    public static boolean isTrianglePossibleEx2(int aa, int bb, int cc) {
        return ((aa + bb > cc) && (aa + cc > bb) && (cc + bb > aa));
    }

    public static boolean isTrianglePossible(Integer[] arr) {
        boolean res1 = (arr[0] + arr[1] > arr[2]);
        boolean res2 = (arr[0] + arr[2] > arr[1]);
        boolean res3 = (arr[2] + arr[1] > arr[0]);

        return (res1 && res2 && res3);
    }

    public static boolean isTrianglePossible(int[] arr) {
        boolean res1 = (arr[0] + arr[1] > arr[2]);
        boolean res2 = (arr[0] + arr[2] > arr[1]);
        boolean res3 = (arr[2] + arr[1] > arr[0]);

        return (res1 && res2 && res3);
    }

    public static int solution55(int[] A) {
        int[] copy = A;
        Arrays.sort(copy);
        int negIndex = getNegatesIndex(copy);
        if (negIndex == 0 && copy[0] < 0)
            copy[0] = -copy[0];

        //negative elems will become positive
        if (negIndex > 0) {
            for (int i = 0; i <= negIndex; i++)
                copy[i] = -copy[i];
        }
        Integer[] copy2 = Arrays.stream(copy)
                .boxed()
                .toArray(Integer[]::new);

        HashSet<Integer> set = new HashSet<>(Arrays.asList(copy2));

        return set.size();
    }


    public static int solution37(int[] A, int[] B) {
        int num = 0;
        for (int i = 0; i < A.length; i++) {
            if (hasSamePrimeDivisors(A[i], B[i]))
                num++;
        }
        return num;
    }

    public static boolean hasSamePrimeDivisors(int num1, int num2) {
        int[] arr1 = getPrimeDivisors(num1);
        int[] arr2 = getPrimeDivisors(num2);
        if (arr1.length == 0 || arr2.length == 0)
            return false;
        if (arr1.length != arr2.length)
            return false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    public static int[] getPrimeDivisors(int num) {
        List<Integer> list = new ArrayList<>();
        if (num % 2 == 0)
            list.add(2);

        for (int i = 3; i < num / 2; i += 2) {
            if (num % i == 0 && isPrime(i))
                list.add(i);
        }
        if (list.isEmpty()) {
            return new int[]{};
        }

        int i = 0;
        int[] divs = new int[list.size()];
        for (int el : list) {
            divs[i] = el;
            i++;
        }
        return divs;
    }

    public static boolean isPrime(int check) {
        //check if n is a multiple of 2
        if (check == 2)
            return true;

        if (check % 2 == 0) return false;
        //if not, then just check the odds
        int num = 0;
        for (int i = 3; i * i <= check; i += 2) {
            if (check % i == 0)
                return false;
        }
        return true;
    }

    public static int[] solution37(int N, int[] P, int[] Q) {
        // write your code in Java SE 8
        int len = P.length;
        int arr[] = new int[len];
        int i = 0;
        while (i < len && P[i] <= Q[i] && Q[i] <= N) {
            int res = countSemiPrimes(P[i], Q[i]);
            arr[i] = res;

            i++;
            if (i == len)
                break;
        }
        return arr;
    }

    public static int countSemiPrimes(int begin, int end) {
        int num = 0;
        for (int i = begin; i <= end; i++) {
            if (isSemiPrime(i))
                num++;
        }
        return num;
    }

    public static boolean isSemiPrime(int check) {
        for (int i = 1; i <= check; i++) {
            int div = check / i;
            if (check % i == 0 && isPrime(i) && isPrime(div))
                return true;
        }

        return false;
    }


    public static int[] solution46(int[] A) {
        int[] divNums = new int[A.length];
        Map<Integer, Integer> map = new HashMap<>();
        int num;
        for (int i = 0; i < A.length; i++) {
            int check = A[i];
            Integer fnd = map.get(check);
            if (fnd != null) {
                num = fnd;
            } else {
                num = countNonDivisors(check, A);
                map.put(check, num);
            }

            divNums[i] = num;
        }
        return divNums;
    }

    public static int countNonDivisors(int check, int[] arr) {
        int num = 0;
        for (int elem : arr) {
            if (check % elem != 0)
                num++;
        }
        return num;
    }

    public static int solution48(int[] A) {
        int peaks = 0;
        int[] arr = A;
        for (int i = 0; i < arr.length - 1; i++) {
            if (i > 0 && (arr[i - 1] < arr[i] && arr[i] > arr[i + 1])) {
                peaks++;
            }
        }
        return peaks;
    }


    public static int solution45(int[] A) {
        int peaks = 0;
        int len = A.length;

        int arrNums = len / 100;
        int left = len % 100; ////?
        if (left > 0)
            arrNums++;

        int i = 0;
        for (i = 0; i < arrNums; i++) {
            int[] arrNew = Arrays.copyOfRange(A, i * 100, (i + 1) * 100);

            int res = calcPeaks(arrNew);
            if (res > peaks) {
                peaks = res;
            }
        }
        return peaks;
    }

    public static int calcPeaks(int arr[]) {
        return 1;
    }


    public static int solution37(int N) {
        // write your code in Java SE 8
        if (N <= 0)
            return 0;

        if (N == 1)
            return 1;

        /*boolean isPrime = !(N % 2 == 0 || N % 3 == 0 || N % 5 == 0 || N % 7 == 0 || N % 11 == 0 || N % 13 == 0);
        if (isPrime) {
            return 2;
        }*/
        int res = (int) Math.sqrt(N);

        HashSet<Integer> factors = new HashSet<>();
        for (int i = res; i < N; i++) {
            int div = N / i;
            if (div * i == N) {
                factors.add(div);
                factors.add(i);
            }

            if ((i - 5) > (N / 2))
                break;
        }

        factors.add(1);
        factors.add(N);

        return factors.size();
    }

    public static int solution34(int N) {
        if (N <= 0)
            return 0;

        int res = (int) Math.sqrt(N);

        boolean isPrime = !(N % 2 == 0 || N % 3 == 0 || N % 5 == 0 || N % 7 == 0 || N % 11 == 0 || N % 13 == 0);
        if (isPrime) {
            System.out.println("PRIME: 2 * (" + N + "+" + 1 + ")");
            return (2 * (N + 1));
        }

        for (int i = res; i < N; i++) {
            int div = N / i;
            if (div * i == N) {
                System.out.println("2 * (" + div + "+" + i + ")");
                return (2 * (div + i));
            }
        }

        System.out.println("2 * (" + N + "+" + 1 + ")");
        return (2 * (N + 1));
    }


    public static int solution55(String stringToMatch) {


        String regex = "((\\w)(\\2+|\\1+))(?=(.*\\2))";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(stringToMatch);
        for (int i = 1; matcher.find(); i++)
            System.out.println("Group # " + i + " got: " + matcher.group(1));

        return 1;
    }


    public static int solution35(int[] A) {

        if (A == null)
            return 0;

        if (A.length == 1)
            return A[0];

        if (A.length == 2) {
            if (A[0] > 0 && A[1] > 0)
                return (A[0] + A[1]);

            return (A[0] > A[1] ? A[0] : A[1]);
        }

        if (A.length == 3) {
            Long sm1 = Long.valueOf(A[0]) + Long.valueOf(A[1]);
            Long sm2 = Long.valueOf(A[1]) + Long.valueOf(A[2]);
            Long res = (sm1 > sm2 ? sm1 : sm2);
            return (res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res.intValue());
        }

        Long max = Long.MIN_VALUE;
        Long sm = 0L;
        for (int i = 0; i < A.length - 1; i++) {
            sm = Long.valueOf(A[i]) + Long.valueOf(A[i + 1]);
            if (sm > max) {
                max = sm;
            }
        }
        return (max > Integer.MAX_VALUE ? Integer.MAX_VALUE : max.intValue());
    }

    public static int solution29(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length == 0)
            return 0;

        if (allDescending(A))
            return 0;

        int[] copy = A;
        Arrays.sort(copy);
        int min = copy[0];
        int max = copy[copy.length - 1];

        int minInd = findElemIndex(A, min);
        int maxInd = findElemIndex(A, max);
        if (maxInd > minInd)
            return (max - min);


        int maxDiff = 0;
        for (int i = 0; i < A.length - 1; i += 2) {
            int diff = A[i + 1] - A[i];
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }

        return maxDiff;
    }

    public static boolean allDescending(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1])
                return false;
        }
        return true;
    }

    public static int findElemIndex(int[] A, int search) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == search)
                return i;
        }
        return -1;
    }


    public static int solution31(int[] A) {
        if (A == null || A.length == 1)
            return 0;

        if (A.length == 2)
            return -1;

        int len = A.length;
        Integer[] copy = Arrays.stream(A)
                .boxed()
                .toArray(Integer[]::new);

        HashSet<Integer> set = new HashSet<>(Arrays.asList(copy));

        int maxOccur = 0;
        int denomVal = 0;
        for (int el : set) {
            int num = countFinding(A, el);
            if (num > maxOccur) {
                maxOccur = num;
                denomVal = el;
            }
        }

        if (maxOccur > len / 2) {
            for (int i = 0; i < len; i++) {
                if (copy[i] == denomVal)
                    return i;
            }
        }

        return -1;
    }

    public static int countFinding(int[] A, int search) {
        int num = 0;
        for (int el : A) {
            if (el == search)
                num++;
        }
        return num;
    }


    public static int solution28(String S) {
        if (S == null || S.trim().length() == 0)
            return 1;

        String copy = S;
        String patterns1[] = {"\\(\\)", "\\{\\}", "\\[\\]"};
        String patterns2[] = {"\\{\\}", "\\[\\]", "\\(\\)"};
        String patterns3[] = {"\\[\\]", "\\(\\)", "\\{\\}"};

        for (String pattern : patterns1) {
            copy = copy.replaceAll(pattern, "").trim();
        }
        if (copy.equals(""))
            return 1;

        for (String pattern : patterns2) {
            copy = copy.replaceAll(pattern, "").trim();
        }
        if (copy.equals(""))
            return 1;

        for (String pattern : patterns3) {
            copy = copy.replaceAll(pattern, "").trim();
        }
        if (copy.equals(""))
            return 1;

        return 0;
    }

    public static int solution27(String S) {
        if (S == null || S.trim().length() == 0)
            return 1;

        String res = S.replaceAll("\\((\\))", "").replaceAll("\\(\\)", "").replaceAll("\\(\\)", "").trim();
        if (res.indexOf("(") >= 0 || res.indexOf(")") >= 0)
            return 0;

        return 1;
    }

    public static int solution27(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        Integer[] copy = Arrays.stream(A)
                .boxed()
                .toArray(Integer[]::new);

        List<Integer> list = Arrays.asList(copy);
        HashSet<Integer> set = new HashSet<Integer>(list);
        return set.size();
    }

    public static int solution26(int[] A) {
        int copy[] = A;
        Arrays.sort(copy);
        int num = 0;
        for (int elem : copy) {
            boolean isDistinct = isDistinct(copy, elem);
            if (isDistinct)
                num++;
        }
        return num;
    }


    public static boolean isDistinct(int[] copy, int val) {
        int num = 0;
        for (int elem : copy) {
            if (elem == val)
                num++;

            if (num > 1)
                return false;
        }
        return true;
    }

    public static int solution17(int[] A) {
        if (A == null || A.length <= 2)
            return 0;

        int copy[] = A;
        Arrays.sort(copy);

        if (A[0] <= 0 && A[1] <= 0 && A[2] <= 0)
            return 0;

        int len = copy.length;

        for (int i = 0; i < len - 2; i++) {
            if (checkThreeElems(copy, i))
                return 1;
        }
        return 0;
    }

    public static boolean checkThreeElems(int copy[], int pos) {
        int el1 = copy[pos];
        int el2 = copy[pos + 1];
        int el3 = copy[pos + 2];

        boolean res1 = (el1 + el2 > el3);
        boolean res2 = (el1 + el3 > el2);
        boolean res3 = (el2 + el3 > el1);

        return (res1 && res2 && res3);
    }

    public static int solution24(int[] A) {
        int copy[] = A;
        Arrays.sort(copy);
        int len = copy.length;

        int negIndex = getNegatesIndex(copy);
        int posIndex = getPositivesIndex(copy);

        if (negIndex == -1 && posIndex == -1)
            return 0;

        long res1 = 0, res2 = 0;
        if (negIndex > 0 && posIndex > 0) {
            try {
                res1 = (copy[negIndex - 1] * copy[negIndex] * copy[len - 1]);
            } catch (IndexOutOfBoundsException ex) {
                res1 = (copy[negIndex] * copy[len - 2] * copy[len - 1]);
            }
        }

        res2 = (copy[len - 3] * copy[len - 2] * copy[len - 1]);

        long res = (res1 > res2 ? res1 : res2);
        return (res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res);
    }

    public static int getNegatesIndex(int[] copy) {
        int pos = 0;
        for (int elem : copy) {
            if (elem >= 0)
                return (pos == 0 ? -1 : (pos - 1));

            pos++;
        }
        return -1;
    }

    public static int getPositivesIndex(int[] copy) {
        int pos = 0;
        for (int elem : copy) {
            if (elem > 0)
                return (pos == 0 ? -1 : pos);

            pos++;
        }
        return -1;
    }


    public static int solution21(int A, int B, int K) {
        if (K == 0)
            return 0;
        if (A > B)
            return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int i = A; i <= B; i++) {
            if (i % K == 0) {
                set.add(i);
            }
        }
        return set.size();
    }

    public static int solution17(int A, int B, int K) {
        if (K == 0)
            return 0;
        if (A > B)
            return 0;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = A; i <= B; i++) {
            if (i % K == 0) {
                list.add(i);
            }
        }
        list.trimToSize();
        return list.size();
    }

    public static int solution15(int[] A) {
        int copy[] = A;
        Arrays.sort(copy);
        int len = copy.length;
        if (copy[len - 1] <= 0)
            return 1;

        if (copy.length == 1 && copy[0] != 1)
            return 1;

        if (copy.length > 1 && copy[0] >= 2)
            return 1;

        /*if(copy[0] >=2)
            return (copy[0]-1);*/

        int pos = findIndex(copy);
        if (pos > -1) {
            int copy2[] = Arrays.copyOfRange(copy, pos, copy.length);

            for (int i = 0; i < copy2.length - 1; i++) {
                if (copy2[i + 1] - copy2[i] > 1) {
                    return (1 + copy2[i]);
                }
            }
            //not found in array
            return (1 + copy2[copy2.length - 1]);
        }

        return 1;
    }

    public static int findIndex(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0)
                return i;
        }
        return -1;
    }

    public static int solution13(int[] A) {

        int x = Integer.MIN_VALUE;

        int copy[] = A;
        Arrays.sort(copy);

        if (copy[0] != 1 || copy[0] != Integer.MIN_VALUE || copy[0] != Integer.MAX_VALUE)
            return 0;

        if (A.length <= 2)
            return 1;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] - A[i] != 1)
                return 0;
        }
        return 1;
    }


    public static int solution12(int X, int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == X)
                return i;
        }
        return -1;
    }

    public int solution22(int[] A) {
        // write your code in Java SE 8
        int arrs[] = new int[A.length - 1];
        for (int i = 0; i < A.length - 1; i++) {
            int res = getSums(A, i + 1);
            arrs[i] = res;
        }

        Arrays.sort(arrs);
        return arrs[0];
    }

    public static int getSums(int[] arr, int pos) {
        int sm1 = 0, sm2 = 0;
        for (int i = 0; i < pos; i++) {
            sm1 += arr[i];
        }

        for (int i = pos; i < arr.length; i++) {
            sm2 += arr[i];
        }
        return Math.abs(sm1 - sm2);
    }

    public static void main22(String[] args) {

        System.out.println("" + Integer.toBinaryString(1376796946));
        System.out.println("" + solution55(1376796946));

        /*System.out.println("" + solution(new int[]{20, 21, 50, 60, 70}));

        System.out.println("" + solution(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println("" + solution(new int[]{1, 2, 3}));
        System.out.println("" + solution(new int[]{-1, -3}));
         System.out.println("" + generate());


         */

        int A[] = new int[]{3, 8, 9, 7, 6};
        //printArr(A);
        System.out.println("--------");
        printArr(solution(A, 3));
        System.out.println("--------");
        //printArr(solution(A, 1));
        //System.out.println("--------");
        //printArr(solution(A, 1));

        //System.out.println("vvv: " + solution(85, 10, 37));

        //System.out.println("vvv: " + solution("(()(())())"));
        //System.out.println("vvv: " + solution(new int[]{Integer.MAX_VALUE, 1, Integer.MAX_VALUE - 5}));


        //System.out.println("vvv: " + solution(10, 10, 20));

        // System.out.println("vvv: " + solution(5, new int[]{1, 8, 3, 5, 7, 9}));
        //System.out.println("vvv: " + contains(new int[] {1, 2, 3}, 3));

        //System.out.println("vvv: " + solution(new int[]{7, 5}));
    }


    public static int solution111(int X, int Y, int D) {
        double xx = (double) Math.abs(Y - X) / D;
        return (int) Math.ceil(xx);
    }

    public static int solution4(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length == 0)
            return 1;

        if (A.length <= 1)
            return A[0];

        int copy[] = A;
        Arrays.sort(copy);

        if (A.length == 2)
            if (copy[1] - copy[0] != 1)
                return (1 + copy[0]);

        int k = 0;
        for (int elem : copy) {
            if (copy[k + 1] - elem != 1)
                return (elem + 1);

            k++;
        }
        return copy[0];
    }


    public static int solution33(int[] A) {
        int len = A.length;
        int mid = (int) (len / 2);
        int arr1[] = Arrays.copyOfRange(A, 0, mid);
        int arr2[] = Arrays.copyOfRange(A, mid + 1, len);
        int midElem = A[mid];
        int res = 0;
        for (int search : arr1) {
            res = countFindings(arr1, midElem, search);
            if (res > 1)
                return search;

            res += countFindings(arr2, midElem, search);
            if (res > 1)
                return search;

        }
        for (int search : arr2) {
            res = countFindings(arr1, midElem, search);
            if (res > 1)
                return search;

            res += countFindings(arr2, midElem, search);
            if (res > 1)
                return search;
        }
        return -1;
    }

    public static int countFindings(int[] A, int midElem, int search) {
        int num = 0;
        if (search == midElem)
            num++;

        for (int elem : A) {
            if (search == elem)
                num++;

            if (num > 1)
                return num;
        }
        return num;
    }

    public static int solution55(int N) {
        String result = Integer.toBinaryString(N);
        result = "1000000000000000000000000000001";
        if (!(result.startsWith("1") && result.endsWith("1")))
            return 0;

        String arr[] = result.split("1");
        int mx = 0;
        if (arr.length == 2)
            return 0;

        for (String rs : arr) {
            if (rs.indexOf("0") >= 0 && rs.length() > mx) {
                mx = rs.length();
            }
        }
        return mx;
    }


    private static String generate() {
        try {
/*
            "exp":1581507968,"user_name":"996773905665","authorities":["user.read","payment.create","payment.read

                    ,"client_id":"mobileId2","scope":["all"]*/

            String arr[] = new String[]{"user.read", "payment.create", "payment.read"};

            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create()
                    //.withIssuer("JWT")
                    .withExpiresAt(new Date())
                    .withClaim("user_name", "996773905665")
                    .withArrayClaim("authorities", new String[]{"user.read", "payment.create", "payment.read"})
                    .withClaim("jti", "409feeaf-7930-4281-9295-9bad437dc55c")
                    .withClaim("client_id", "mobileId2")
                    .withArrayClaim("scope", new String[]{"all"})
                    .sign(algorithm);

            return token;
        } catch (JWTCreationException exception) {
            //Invalid Signing configuration / Couldn't convert Claims.
        }
        return null;
    }

    public static void printArr(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(" " + A[i]);
        }
        System.out.println("");
    }

    public static void printArr(Integer[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(" " + A[i]);
        }
        System.out.println("");
    }


    public static int[] solution(int[] A, int K) {
        int copy[] = A;
        for (int i = 0; i < K - 1; i++) {
            solutionB(copy);
        }
        return copy;
    }

    public static void solutionB(int[] A) {
        // write your code in Java SE 8
        int copy[] = A;
        int len = copy.length;
        int first = copy[0];
        for (int i = 0; i < copy.length - 1; i++) {
            copy[i] = A[i + 1];
        }
        copy[len - 1] = first;
        A = copy;
    }

    public static int solution2(int[] A) {
        // write your code in Java SE 8

        int copy[] = A;
        Arrays.sort(copy);

        int search = 0;
        boolean found = false;
        int len = copy.length;
        for (int i = copy[0]; i < copy[len - 1]; i++) {
            if (!contains(A, i)) {
                if (search < i) {
                    search = i;
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            search = ++copy[len - 1];
        }

        if (search <= 0)
            return 1;

        return search;
    }

    public static boolean contains(int[] A, int elem) {
        // write your code in Java SE 8
        for (int i = 0; i < A.length; i++) {
            if (elem == A[i])
                return true;
        }
        return false;
    }

}

