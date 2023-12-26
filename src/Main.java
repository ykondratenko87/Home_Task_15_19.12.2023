import java.util.*;

public class Main {
    public static void main(String[] args) {

//Задача 1
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите набор чисел в виде строки:");
        String input = scanner.nextLine();

        String[] numbers = input.split(",\\s*");

        Set<String> uniqueNumbers = new HashSet<>();

        for (String number : numbers) {
            uniqueNumbers.add(number);
        }

        System.out.println("Результат без повторений:");
        for (String uniqueNumber : uniqueNumbers) {
            System.out.print(uniqueNumber + " ");
        }

        System.out.println();

//Задача 2
        AnimalCollection animalCollection = new AnimalCollection();

        animalCollection.addAnimal("Кот");
        animalCollection.addAnimal("Собака");
        animalCollection.addAnimal("Лев");

        animalCollection.displayAnimalNames();

        String removedAnimal = animalCollection.removeAnimal();
        if (removedAnimal != null) {
            System.out.println("Удалено животное: " + removedAnimal);
        } else {
            System.out.println("Коллекция пуста, невозможно удалить животное.");
        }
        animalCollection.displayAnimalNames();

//Задача 3
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иванов", "Группа1", 1, List.of(4.0, 3.5, 4.5)));
        students.add(new Student("Петров", "Группа2", 2, List.of(3.0, 2.5, 3.5)));
        students.add(new Student("Сидоров", "Группа1", 1, List.of(2.0, 2.5, 3.0)));
        students.add(new Student("Свердлов", "Группа2", 2, List.of(4.0, 4.5, 3.5)));

        removeAndPromoteStudents(students);

        printStudentsByCourse(students, 1);
        printStudentsByCourse(students, 2);
    }

    private static void removeAndPromoteStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            double averageGrade = student.getAverageGrade();

            if (averageGrade < 3.0) {
                iterator.remove();
            } else {
                promoteStudent(student);
            }
        }
    }

    private static Student promoteStudent(Student student) {
        int currentCourse = student.getCourse();
        student = new Student(student.getName(), student.getGroup(), currentCourse + 1, student.getGrades());
        return student;
    }

    private static void printStudentsByCourse(List<Student> students, int course) {
        System.out.println("Студенты на курсе " + course + ":");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}