package basic.chap13;

import java.util.Arrays;

public class WildCardExample {
    public static void registerCourse(Course<?> course){
        System.out.println(course.getName()+" 수강생: "+ Arrays.toString(course.getStudents()));
    }

    public static void registerCourseStudent(Course<? extends Student> course){
        System.out.println(course.getName()+" 수강생: "+Arrays.toString(course.getStudents()));
    }

    public static void registerCourseWorker(Course<? super Worker> course){
        System.out.println(course.getName()+" 수강생: "+Arrays.toString(course.getStudents()));
    }

    public static void main(String[] args){
        // 타입 파라미터가 모든 타입인 경우 : Course<?>
        Course<Person> personCourse=new Course<Person>("일반인과정", 5);
        personCourse.add(new Person("일반인"));
        personCourse.add(new Worker("직장인"));
        personCourse.add(new Student("학생"));

        // 타입 파라미터가 Worker 타입 또는 Worker 타입의 상위 타입이거나 하위 타입인 경우 : Course<? super Worker>
        Course<Worker> workerCourse=new Course<Worker>("직장인과정", 5);
        workerCourse.add(new Worker("직장인"));

        // 타입 파라미터가 Student 타입 또는 Student 타입의 하위 타입인 경우 : Course<? extends Student>
        Course<Student> studentCourse=new Course<Student>("학생과정", 5);
        studentCourse.add(new Student("학생"));
        studentCourse.add(new HighStudent("고등학생"));

        Course<HighStudent> highStudentCourse=new Course<HighStudent>("고등학생과정", 5);
        highStudentCourse.add(new HighStudent("고등학생"));

        registerCourse(personCourse);
        registerCourse(workerCourse);
        registerCourse(studentCourse);
        registerCourse(highStudentCourse);
        System.out.println();

        registerCourseStudent(studentCourse);
        registerCourseStudent(highStudentCourse);
        System.out.println();

        registerCourseWorker(personCourse);
        registerCourseWorker(workerCourse);
    }
}
