package Day17;
import java.util.*;

abstract class CourseType {
    private String courseName;
    public CourseType(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseName() {
        return courseName;
    }
    public abstract String getEvaluationMethod();
}

class ExamCourse extends CourseType {
    public ExamCourse(String courseName) {
        super(courseName);
    }
    @Override
    public String getEvaluationMethod() {
        return "Exam-Based Evaluation";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName) {
        super(courseName);
    }
    @Override
    public String getEvaluationMethod() {
        return "Assignment-Based Evaluation";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName) {
        super(courseName);
    }
    @Override
    public String getEvaluationMethod() {
        return "Research-Based Evaluation";
    }
}

class Course<T extends CourseType> {
    private T courseDetails;
    public Course(T courseDetails) {
        this.courseDetails = courseDetails;
    }
    public T getCourseDetails() {
        return courseDetails;
    }
    public void displayCourse() {
        System.out.println(courseDetails.getCourseName() + " | " + courseDetails.getEvaluationMethod());
    }
}

class CourseUtils {
    public static void displayAllCourses(List<? extends Course<? extends CourseType>> courses) {
        for (Course<? extends CourseType> course : courses) {
            course.displayCourse();
        }
    }
}

public class pr3 {
    public static void main(String[] args) {
        List<Course<? extends CourseType>> allCourses = new ArrayList<>();
        Course<ExamCourse> javaCourse = new Course<>(new ExamCourse("Java Programming"));
        Course<AssignmentCourse> webDevCourse = new Course<>(new AssignmentCourse("Data Analyst"));
        Course<ResearchCourse> aiCourse = new Course<>(new ResearchCourse("AI Research"));
        allCourses.add(javaCourse);
        allCourses.add(webDevCourse);
        allCourses.add(aiCourse);
        System.out.println("---- University Courses ----");
        CourseUtils.displayAllCourses(allCourses);
    }
}
