public class Student implements Comparable<Student> {
    private String name;
    private int score;

    @Override
    public int compareTo(Student o) {
        if(this.score== o.score)
            return 0;
        else if(this.score<o.score)
            return -1;
        return 1;
    }
    public int getScore()
    {
        return score;
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
