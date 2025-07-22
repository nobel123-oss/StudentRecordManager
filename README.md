# Student Record Manager (Java + JDBC + MySQL)

## 📝 Description
A simple command-line project built using Java and JDBC to manage student records. The application connects to a MySQL database and supports basic CRUD operations (Create, Read, Delete).

## ⚙️ Technologies Used
- Java
- JDBC
- MySQL
- VS Code

## 📁 Features
- Add a new student
- View all students
- Delete a student by ID

## 💻 How to Run

1. **Set up MySQL database**:
   - Open your MySQL client and run the script in `setup.sql`.

2. **Edit the Java file**:
   - Replace `your_password_here` with your actual MySQL password.

3. **Compile and Run**:
   ```bash
   javac StudentRecordManager.java
   java StudentRecordManager
   ```

## 📌 Notes
- Ensure the MySQL server is running.
- Requires MySQL Connector/J in the classpath when compiling and running.

## 📂 Project Structure
```
StudentRecordManager/
│
├── src/
│   └── StudentRecordManager.java
│
├── setup.sql
└── README.md
```