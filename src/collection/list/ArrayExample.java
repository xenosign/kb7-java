package collection.list;

public class ArrayExample {
    public static void main(String[] args) {
        String[] students = { "이지민", "송태권", "김현태" };

        // 제일 뒷자리에 있는 사람 중에서 한 명이 빠져있죠?
        // 자바 기본 배열에서 추가해 봅시다 ^0^
        String[] newStudents = new String[students.length + 1];        

        for (int i = 0; i < students.length; i++) {
            newStudents[i] = students[i];
        }
        newStudents[newStudents.length - 1] = "강태규";

        students = newStudents;

        for (String s : students) {
            System.out.println(s);
        }
    }
}
