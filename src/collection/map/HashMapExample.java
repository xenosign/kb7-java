package collection.map;

import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        List<String> students = new ArrayList<>();

        students.add("강태규"); students.add("권유현"); students.add("김건우");
        students.add("김기선"); students.add("김민철"); students.add("김수현");
        students.add("김현태"); students.add("송준수"); students.add("송태권");
        students.add("양승환"); students.add("오진호"); students.add("이대주");
        students.add("이민호"); students.add("이아영"); students.add("이지민");
        students.add("이지은"); students.add("이채연"); students.add("장지연");
        students.add("최규진"); students.add("최보윤"); students.add("홍상우");
        students.add("황지원");

        Map<String, List<String>> lastNameMap = new HashMap<>();

        for (String name : students) {
            String lastName = name.substring(0, 1);

            if (!lastNameMap.containsKey(lastName)) {
                lastNameMap.put(lastName, new ArrayList<>());
            }

            lastNameMap.get(lastName).add(name);
        }

        Map<String, List<String>> sortedMap = new TreeMap<>(lastNameMap);

        for (Map.Entry<String, List<String>> entry : sortedMap.entrySet()) {
            String lastName = entry.getKey();
            List<String> names = entry.getValue();
            System.out.println(lastName + "씨 (" + names.size() + "명): " + names);
        }
    }
}