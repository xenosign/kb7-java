package stream;

import java.util.Arrays;
import java.util.List;

public class StreamReal {
    static class StudentResponse {
        int id;
        String name;
        String filterOption = "none";

        StudentResponse(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public StudentResponse(int id, String name, String filterOption) {
            this.id = id;
            this.name = name;
            this.filterOption = filterOption;
        }

        @Override
        public String toString() {
            return "filterOption is " + filterOption + " / " + id + " : " + name;
        }
    }

    public static void main(String[] args) {
        List<String> students = Arrays.asList(
                "강태규", "권유현", "김건우", "김기선", "김민철",
                "김수현", "김현태", "송준수", "송태권", "양승환",
                "오진호", "이대주", "이민호", "이아영", "이지민",
                "이지은", "이채연", "장지연", "최규진", "최보윤",
                "홍상우", "황지원"
        );


        


        
    }
}