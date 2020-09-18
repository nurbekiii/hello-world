package com.test.hello;

import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class Comparer implements Comparator {
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;

        Double d1 = new Double(s1.getCgpa());
        Double d2 = new Double(s2.getCgpa());
        int comp1 = Double.compare(d1, d2);

        if (comp1 == 0) {
            int res = s1.getFname().compareTo(s2.getFname());
            if (res != 0)
                return res;
            return new Integer(s1.getId()).compareTo(new Integer(s2.getId()));

        } else if (d1 < d2)
            return 1;
        else
            return -1;
    }
}

//Complete the code
public class StudentsCompare {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        Comparer comparer = new Comparer();

        Student [] arr = studentList.stream().toArray(Student[]::new);
        Arrays.sort(arr, comparer);

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
