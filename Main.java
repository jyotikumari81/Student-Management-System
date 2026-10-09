package com.studentmanagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student by ID");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                        System.out.println("Invalid email! Please enter a valid email.");
                        break;
                    }

                    System.out.print("Enter course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter age: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid age! Please enter a number.");
                        sc.nextLine();
                        break;
                    }

                    int age = sc.nextInt();
                    sc.nextLine();

                    if (age <= 0) {
                        System.out.println("Age must be greater than 0.");
                        break;
                    }

                    Student student =
                            new Student(0, name, email, course, age);

                    dao.addStudent(student);
                    break;

                case 2:
                    dao.viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    int searchId = sc.nextInt();
                    dao.searchStudent(searchId);
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteStudent(deleteId);
                    break;
                    
                case 5:
                    System.out.print("Enter student ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new email: ");
                    String newEmail = sc.nextLine();

                    System.out.print("Enter new course: ");
                    String newCourse = sc.nextLine();

                    System.out.print("Enter new age: ");
                    int newAge = sc.nextInt();

                    dao.updateStudent(updateId, newName, newEmail, newCourse, newAge);
                    break;    

                case 6:
                    System.out.println("Thank you for using the system!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
