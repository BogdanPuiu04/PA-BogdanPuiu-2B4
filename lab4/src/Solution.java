import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Student, School> result;

    public Solution() {
        this.result=new HashMap<>();
    }

    public void setResult(Student student, School school ) {
        result.put(student,school);
    }
    public void print(){
        for(Map.Entry<Student,School> index : result.entrySet())
        {
            Student student=index.getKey();
            School school=index.getValue();
            System.out.println(student.getName() + " "+ school.getName());
        }
    }
}
