import java.sql.*;
import java.util.Scanner;

public class StudentRecordManager {
    static final String DB_URL = "jdbc:mysql://localhost:3306/student_db";
    static final String USER = "root";
    static final String PASS = "your_password_here";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement stmt = conn.createStatement();
            int choice;
            do {
                System.out.println("\n1. Add Student\n2. View Students\n3. Delete Student\n4. Exit");
                choice = sc.nextInt();
                sc.nextLine();  // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter age: ");
                        int age = sc.nextInt();
                        String insertSQL = "INSERT INTO students (name, age) VALUES (?, ?)";
                        try (PreparedStatement ps = conn.prepareStatement(insertSQL)) {
                            ps.setString(1, name);
                            ps.setInt(2, age);
                            ps.executeUpdate();
                            System.out.println("Student added successfully!");
                        }
                        break;
                    case 2:
                        ResultSet rs = stmt.executeQuery("SELECT * FROM students");
                        while (rs.next()) {
                            System.out.println(rs.getInt("id") + " - " + rs.getString("name") + ", Age: " + rs.getInt("age"));
                        }
                        break;
                    case 3:
                        System.out.print("Enter student ID to delete: ");
                        int id = sc.nextInt();
                        String deleteSQL = "DELETE FROM students WHERE id = ?";
                        try (PreparedStatement ps = conn.prepareStatement(deleteSQL)) {
                            ps.setInt(1, id);
                            ps.executeUpdate();
                            System.out.println("Student deleted successfully!");
                        }
                        break;
                }
            } while (choice != 4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}