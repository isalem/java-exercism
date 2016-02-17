import java.util.*;

public class School {
    private final Map<Integer, List<String>> db = new HashMap<>();

    public Map<Integer, List<String>> db() {
        return Collections.unmodifiableMap(db);
    }

    public void add(String studentName, int grade) {
        List<String> studentsWithCurrentGrade = db.get(grade);
        if (studentsWithCurrentGrade == null) {
            studentsWithCurrentGrade = new ArrayList<>();
        }
        studentsWithCurrentGrade.add(studentName);
        db.put(grade, studentsWithCurrentGrade);
    }

    public List<String> grade(int grade) {
        List<String> studentsWithCurrentGrade = db.get(grade);
        if (studentsWithCurrentGrade == null) {
            studentsWithCurrentGrade = Collections.emptyList();
        }
        return studentsWithCurrentGrade;
    }

    public Map<Integer, List<String>> sort() {
        for (Map.Entry<Integer, List<String>> students : db.entrySet() ) {
            Collections.sort(students.getValue());
            db.put(students.getKey(), students.getValue());
        }
        return Collections.unmodifiableMap(db);
    }
}
