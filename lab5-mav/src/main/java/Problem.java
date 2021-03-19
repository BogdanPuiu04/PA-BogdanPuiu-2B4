import com.sun.jdi.IntegerValue;
import com.sun.source.tree.Tree;

import java.util.*;

public class Problem  {
    private Map<Student, List<School>> studentListMap = new HashMap<>();
    private Map<School, List<Student>> schoolListMap = new HashMap<>();
    private int[][] priorityMatrix;

    public int studentCheck(Student student) {
        switch (student.getName()) {
            case "S0":
                return 0;
            case "S1":
                return 1;

            case "S2":
                return 2;

            case "S3":
                return 3;
            default:
                System.err.printf("error");
                return -1;
        }
    }

    public int selectMax(int[][] priorityMatrix, int row) {
        int max = Integer.MIN_VALUE;
        int aux = 0;
        for (int j = 0; j < studentListMap.size(); j++) {
            if (max < priorityMatrix[row][j]) {
                max = priorityMatrix[row][j];
                aux = j;
            }
        }
        for (; row < schoolListMap.size(); row++) {
            priorityMatrix[row][aux] = -1;
        }
        return aux;
    }


    /*public void selectStudenti() {
        for (int i = 0; i < schoolListMap.size(); i++) {

        }
    }*/

    public Problem(Map<Student, List<School>> studentListMap, Map<School, List<Student>> schoolListMap) {
        this.studentListMap = studentListMap;
        this.schoolListMap = schoolListMap;
        priorityMatrix = new int[schoolListMap.size()][studentListMap.size()];
    }

    public void rezolvare() {
        Iterator<Map.Entry<School, List<Student>>> iterator = schoolListMap.entrySet().iterator();

        for (int i = 0; i < schoolListMap.size(); i++) {
            Map.Entry<School, List<Student>> entry = iterator.next();
            List<Student> schoolList = entry.getValue();
            int aux = schoolList.size();
            int j = 0;
            while (j < schoolList.size()) {
                Student student = schoolList.get(j);
                priorityMatrix[i][studentCheck(student)] = aux;
                aux--;
                j++;
            }
        }
        for (int i = 0; i < schoolListMap.size(); i++) {
            for (int j = 0; j < studentListMap.size(); j++) {
                System.out.printf(" %d ", priorityMatrix[i][j]);
            }
            System.out.println();
        }
    }

    public void solution(Map<Student, List<School>> studentListMap) {
        Solution solution = new Solution();
        Iterator<Map.Entry<Student, List<School>>> iterator = studentListMap.entrySet().iterator();
        Map<Student, List<School>> treeMap = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getScore() == o2.getScore())
                    return 0;
                else if (o1.getScore() < o2.getScore())
                    return -1;
                return 1;
            }
        });
        treeMap.putAll(studentListMap);
        for (Map.Entry<Student, List<School>> pair : treeMap.entrySet()) {
            Student a = pair.getKey();
            List<School> schoolList = pair.getValue();

            int i = 0;
            while (i < schoolList.size()) {
                School school = new School(0, ".");
                school = schoolList.get(i);
                if (school.getCapacity() > 0) {
                    solution.setResult(a, school);
                    school.lowerCapacity();
                    schoolList.set(i,school);
                    break;
                }
                i++;
            }

        }
        solution.print();
    }
}
