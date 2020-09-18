package com.test.hello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author NIsaev on 30.03.2020
 */
public class Main6 {

    public static void main(String[] args) {


        //System.out.println(evaluate("1 2 3.5"));

        //System.out.println(evaluate("5 1 2 + 4 * + 3 -"));

        //System.out.println(evaluate("1 2 + 4 * + 3 -"));

        /*List<Integer> list = splitInteger(12, 5);
        for (int res : list) {
            System.out.println(res);
        }*/

        //printArr(possibilities(".")) ;
        //printArr(possibilities("-")) ;
        //printArr(possibilities("-.")) ;

        //printArr(possibilities("..."));
        //printArr(possibilities(".?"));

        printArr(possibilities("..?"));

        //printArr(possibilities("-.-"));


    }

    private static void printArr(List<String> list) {
        for (String elem : list) {
            System.out.println(elem);
        }

    }

    public static String getLetter(String signal) {
        String letter = null;
        if (signal.length() == 1) {
            if (signal.equals("."))
                letter = "E";
            else if (signal.equals("-"))
                letter = "T";
                /////////
            else if (signal.equals("?"))
                letter = "ET";
            /////////
        } else if (signal.length() == 2) {
            if (signal.equals(".."))
                letter = "I";
            else if (signal.equals(".-"))
                letter = "A";
            else if (signal.equals("-."))
                letter = "N";
            else if (signal.equals("--"))
                letter = "M";

                /////////
            else if (signal.equals("-?"))
                letter = "NM";
            else if (signal.equals("?-"))
                letter = "AM";
            else if (signal.equals("?."))
                letter = "IN";
            else if (signal.equals(".?"))
                letter = "IA";
            else if (signal.equals("??"))
                letter = "IANM";

            /////////


        } else if (signal.length() == 3) {
            if (signal.equals("..."))
                letter = "S";
            else if (signal.equals("..-"))
                letter = "U";
            else if (signal.equals(".-."))
                letter = "R";
            else if (signal.equals(".--"))
                letter = "W";
                ////////

            else if (signal.equals("-.."))
                letter = "D";
            else if (signal.equals("-.-"))
                letter = "K";
            else if (signal.equals("--."))
                letter = "G";
            else if (signal.equals("---"))
                letter = "O";

            else if (signal.equals("?.."))
                letter = "SD";

            else if (signal.equals("..?") || signal.equals("-.?"))
                letter = "UK";
            else if (signal.equals("?-?"))
                letter = "RWGO";

            else if (signal.equals("?.?"))
                letter = "SUDK";

            //else if (signal.equals("?..") || signal.equals("?-.") || signal.equals("-.?") || signal.equals("--?"))
            else if (signal.equals("..?") || signal.equals(".-?") || signal.equals("-.?") || signal.equals("--?"))
                letter = "SRDG";

            else if (signal.equals("???"))
                letter = "SURWDKGO";


        }

        return letter;

    }


    public static List<String> possibilities(String signals) {
        List<String> list = new ArrayList<>();

        String letter = getLetter(signals);
        if (letter == null)
            return list;

        if (letter.length() == 1) {
            list.add(letter);
            return list;
        }

        for (int i = 0; i < letter.length(); i++) {
            String str = letter.substring(i, i + 1);
            list.add(str);
        }

        return list;
    }


    public static List<Integer> splitInteger(Integer num, Integer parts) {
        List<Integer> list = new ArrayList<>();
        if (parts <= 0)
            return list;

        int res = num / parts;
        int remainder = num % parts;

        for (int i = 0; i < parts; i++) {
            list.add(res);
        }
        if (remainder == 0) {
            return list;
        }

        int sm = 0;
        for (int i = 0; i < parts; i++) {
            if (sm >= remainder)
                break;

            int elem = list.get(i);
            list.remove(i);
            list.add(++elem);
            sm++;
        }

        Collections.sort(list);

        return list;
    }


    public static int breakChocolate(int n, int m) {
        int res = n * m;
        if (res <= 0)
            return 0;

        return (res - 1);
    }

    public static String markdownParser(String markdown) {
        try {
            int pos = markdown.indexOf("# ");
            int num = markdown.substring(0, pos + 1).trim().length();

            String start = markdown.substring(0, pos + 1).trim();
            if (!(start.startsWith("#") && start.endsWith("#")))
                return markdown;

            if (pos < 0 || num == 0)
                return markdown;

            String header = markdown.substring(pos + 1).trim();
            return String.format("<h%d>%s</h%d>", num, header, num);
        } catch (Exception t) {
            return markdown;
        }
    }


    public static int highOrderBitmask(int wordSize) {
        if (wordSize == 8)
            return 208;

        if (wordSize == 6)
            return 192;

        return 128;
    }

    public static double evaluate(String expr) {
        if (expr == null || expr.equals(""))
            return 0;

        String vals[] = expr.trim().split(" ");

        Stack<String> stack = new Stack<>();

        for (int i = vals.length - 1; i >= 0; i--) {
            stack.add(vals[i]);
        }

        //"5 1 2 + 4 * + 3 -"
        while (stack.size() > 1) {
            String s1 = stack.pop();
            String s2 = stack.pop();
            String s3 = stack.pop();
            if (isOperation(s3)) {
                double sm = makeMathOper(s1, s2, s3);
                stack.push("" + sm);
            } else {
                try {
                    String s4 = stack.pop();
                    double sm = makeMathOper(s2, s3, s4);
                    stack.push("" + sm);
                    stack.push(s1);
                } catch (Exception t) {
                    return Double.valueOf(s3);
                }
            }
        }

        return Double.valueOf(stack.get(0));
    }


    public static double evaluateEx(String expr) {
        String vals[] = expr.split(" ");

        String prevElem = null;

        double sm = 0;
        for (int i = 0; i < vals.length - 1; i++) {
            if (vals.length < 3)
                return Double.valueOf(vals[0]);

            String s1 = vals[i];
            String s2 = vals[i + 1];
            String s3 = vals[i + 2];

            if (isOperation(s2)) {
                if (Double.valueOf(s1) >= 0 && Double.valueOf(s3) >= 0) {
                    sm += makeMathOper(s1, s3, s2);
                    vals[i] = "" + sm;
                    vals[i + 1] = null;
                    vals[i + 2] = null;
                    sm = 0;

                    if (i > 0 && prevElem != null) {
                        vals[0] = prevElem;
                        prevElem = null;
                    }

                    vals = remakeAgain(vals);
                    i = -1;
                }
            } else if (isOperation(s3) && prevElem == null) {
                sm += makeMathOper(s1, s2, s3);
                vals[i] = "" + sm;
                vals[i + 1] = null;
                vals[i + 2] = null;
                sm = 0;

                if (i > 0 && prevElem != null) {
                    vals[0] = prevElem;
                    prevElem = null;
                }

                vals = remakeAgain(vals);
                i = -1;
            } else if (isOperation(s3) && prevElem != null) {
                sm += makeMathOper(s1, s2, s3);
                vals[i] = "" + sm;
                vals[i + 1] = null;
                vals[i + 2] = null;
                sm = 0;

                if (i > 0 && prevElem != null) {
                    vals[0] = prevElem;
                    prevElem = null;
                }

                vals = remakeAgain(vals);
                i = -1;
            } else {
                prevElem = s1;
            }
        }

        return Double.valueOf(vals[0]);
    }

    static String[] remakeAgain(String vals[]) {
        String res = "";
        for (int i = 0; i < vals.length; i++) {
            res += (vals[i] != null ? vals[i] + " " : "");
        }
        return res.trim().split(" ");
    }

    private static boolean isOperation(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*"));
    }

    private static double makeMathOper(String s1, String s2, String s3) {
        if (s3.equals("-"))
            return Double.valueOf(s1) - Double.valueOf(s2);

        if (s3.equals("*"))
            return Double.valueOf(s1) * Double.valueOf(s2);

        if (s3.equals("/"))
            return Double.valueOf(s1) / Double.valueOf(s2);


        return Double.valueOf(s1) + Double.valueOf(s2);
    }
}
