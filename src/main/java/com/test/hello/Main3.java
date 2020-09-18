package com.test.hello;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.*;
import java.util.stream.Collectors;

public class Main3 {

    public static void main(String[] args) {
        try {

            parseFiles();
        } catch (Exception t) {
            t.printStackTrace();
        }
    }


    private String getMime(String fileName){
       String extension =  fileName.substring(fileName.lastIndexOf(".") + 1);
       if (extension.contains(".jpg") || extension.contains(".jpeg"))
           return "image/jpeg";
       else  if (extension.contains(".pdf") )
           return "application/pdf";

       return "image/png";
    }

    public static void main66(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();

            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(s.getBytes());
            byte[] digest = md.digest();
            String myHash = DatatypeConverter
                    .printHexBinary(digest).toUpperCase();

            System.out.println(myHash);
        } catch (Exception t) {
        }
    }

    public static void parseFiles() throws Exception {
        Path configFilePath = Paths.get("C:\\data\\static\\Img\\Temp22"); //"C:\\data\\static\\Img\\Temp"

        List<Path> fileWithName = Files.walk(configFilePath)
                .filter(s -> s.getFileName().toString().length() < 15)
                .map(Path::getFileName).sorted().collect(Collectors.toList());

        /*List<Path> fileWithName = Files.walk(configFilePath)
                .filter(s -> s.toString().endsWith("_X.pdf") || s.toString().endsWith("_X.jpg"))
                .map(Path::getFileName).sorted().collect(Collectors.toList());*/

        Map<Long, String> map = new HashMap<>();
        List<Long> agentIds = new ArrayList<>();
        for (Path name : fileWithName) {
            String fileName = name.toString();
            String ids = fileName.substring(0, fileName.indexOf("f"));
            if (ids == null)
                continue;

            Long agentId = Long.valueOf(ids);
            //System.out.println(agentId);
            agentIds.add(agentId);
            String fl = map.get(agentId);
            if (fl == null)
                map.put(agentId, fileName);
            else
                map.put(agentId, fl + "#" + fileName);
        }

        agentIds = agentIds.stream().distinct().sorted().collect(Collectors.toList());

        for (Map.Entry<Long, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());

            String fileStr = entry.getValue();
            String files[] = fileStr.split("#");
            for (String fileName : files) {
                System.out.println(fileName);
            }
        }

        System.out.println(map.size());
    }

    public static void main44(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (m == 0) {
                System.out.println("java.lang.ArithmeticException: / by zero");
                return;
            }

            System.out.println((int) (n / m));

        } catch (InputMismatchException t) {
            System.out.println("java.util.InputMismatchException");
        }

    }


    static Iterator func(ArrayList mylist) {
        Iterator it = mylist.iterator();
        while (it.hasNext()) {
            Object element = it.next();
            if (element instanceof Integer) {//Hints: use instanceof operator
                it.remove();
                continue;
            }

            /*if (element instanceof String) {//Hints: use instanceof operator
                if (element.equals("###")) {
                    it.remove();
                    continue;
                }
            }*/
            break;
        }
        return it;

    }

    @SuppressWarnings({"unchecked"})
    public static void main333(String[] args) {
        ArrayList mylist = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            mylist.add(sc.nextInt());
        }

        mylist.add("###");
        for (int i = 0; i < m; i++) {
            mylist.add(sc.next());
        }

        Iterator it = func(mylist);
        while (it.hasNext()) {
            Object element = it.next();
            System.out.println((String) element);
        }
    }
}
