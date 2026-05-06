package stream;

class StudentResponse {
    int id;
    String name;
    String filterOption = "none";

    public StudentResponse(int id, String name, String filterOption) {
        this.id = id;
        this.name = name;
        this.filterOption = filterOption;
    }

    @Override
    public String toString() {
        return "StudentResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", filterOption='" + filterOption + '\'' +
                '}';
    }
}
