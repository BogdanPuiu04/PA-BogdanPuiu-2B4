import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 3).mapToObj(i -> new Student("S" + i,i)).toArray(Student[]::new);
        var schools = IntStream.rangeClosed(0, 2).mapToObj(i -> new School(i + 1, "H" + i)).toArray(School[]::new);
        School H1 = new School(1, "H1");
        School H2 = new School(2, "H2");
        School H3 = new School(2, "H3");
        Map<Student, List<School>> studentListMap = new HashMap<>();
        studentListMap.put(students[0], Arrays.asList(H1, H2, H3));
        studentListMap.put(students[1], Arrays.asList(H2, H3, H1));
        studentListMap.put(students[2], Arrays.asList(H3, H1, H2));
        studentListMap.put(students[3], Arrays.asList(H1, H3, H2));
        Map<School, List<Student>> schoolListMap = new HashMap<>();
        schoolListMap.put(H1, Arrays.asList(students[0], students[1], students[3]));
        schoolListMap.put(H2, Arrays.asList(students[1], students[2], students[3]));
        schoolListMap.put(H3, Arrays.asList(students[2], students[1], students[3]));
        Iterator<Map.Entry<Student, List<School>>> iterator = studentListMap.entrySet().iterator();

        // afisare
        while (iterator.hasNext()) {
            Map.Entry<Student, List<School>> entry = iterator.next();
            Student student = entry.getKey();
            List<School> schoolList = entry.getValue();
            int i = 0;
            System.out.printf("Student %s Scoli:", student.getName());
            while (i < schoolList.size()) {
                School school = schoolList.get(i);
                System.out.printf(" %s ", school.getName());
                i++;
            }
            System.out.println();
        }
        Iterator<Map.Entry<School, List<Student>>> iterator1 = schoolListMap.entrySet().iterator();
        //afisare scoli
        while (iterator1.hasNext()) {
            Map.Entry<School, List<Student>> entry = iterator1.next();
            School school = entry.getKey();
            List<Student> studentList = entry.getValue();
            int i = 0;
            System.out.printf("Scoala  %s prefera Studentii:", school.getName());
            while (i < studentList.size()) {
                Student student = studentList.get(i);
                System.out.printf(" %s ", student.getName());
                i++;
            }
            System.out.println();

        }

        //linked list studenti

        List<Student> studentLinkedList = new LinkedList<>();
        studentLinkedList.addAll(Arrays.asList(students));
        for (Iterator<Student> studentIterator = studentLinkedList.iterator(); studentIterator.hasNext(); ) {
            Student student = studentIterator.next();
            System.out.println(student.getName());
        }

        Set<School> schoolTreeSet = new TreeSet<>(new Comparator<School>() {
            @Override
            public int compare(School o1, School o2) {
                if (o1.getCapacity() > o2.getCapacity())
                    return 1;
                else return 0;
            }
        });
        Faker faker = new Faker();
        for(int i=0;i<10;i++) {
            String name = faker.name().fullName(); // Miss Samanta Schmidt
            String firstName = faker.name().firstName(); // Emory
            String lastName = faker.name().lastName(); // Barton

            String streetAddress = faker.address().streetAddress();
            System.out.println(firstName + " " + lastName);
        }
        Problem problem=new Problem(studentListMap,schoolListMap);
        problem.solution(studentListMap);

    }
}
