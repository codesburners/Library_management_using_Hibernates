=# 📚 Library Management System (Java + Hibernate)

A beginner-friendly command-line application to manage a digital library, built using **Java** and **Hibernate ORM**, with data stored persistently in **Oracle** or **MySQL** databases.

---

## ✅ Features

- 📖 Add new books to the database  
- 🗑️ Remove books by ID  
- 🔍 Search for a book using its ID  
- 📋 Display all books in the library  
- 🧠 Input validation to prevent invalid or crashing input  
- 💾 Persistent storage using Hibernate ORM and relational DB  

---

## 🛠️ Tech Stack

- **Java 17+**
- **Hibernate ORM (JPA)**
- **Oracle / MySQL**
- **Command Line Interface (CLI)**
- **JDBC driver (DB dependent)**

---

## ⚙️ How It Works

- The `Book` class is a JPA entity annotated with `@Entity` and `@Id`, and mapped to a table in the database.
- The application uses `hibernate.cfg.xml` for database connection settings like URL, username, password, and dialect.
- When the program starts, it:
  - Creates a Hibernate `SessionFactory`
  - Opens a session
  - Displays a user-friendly menu
- Depending on user input, the application performs operations like:
  - `session.persist()` to add a book
  - `session.get()` to search a book by ID
  - `session.remove()` to delete a book
  - HQL query (`from Book`) to display all records
- Each write operation (add/delete) is wrapped in a `Transaction` to ensure data consistency.
- Input is validated using `Scanner.hasNextInt()` or `hasNextDouble()` to avoid runtime exceptions.
- The app runs in the terminal/console and provides visual cues using emojis and messages.

---

## 🚀 Getting Started

1. Clone the project:
   ```bash
   git clone https://github.com/your-username/library-management-hibernate.git
   cd library-management-hibernate
Configure hibernate.cfg.xml with your database details:

xml
Copy
Edit
<property name="hibernate.connection.url">jdbc:oracle:thin:@localhost:1521:xe</property>
<property name="hibernate.connection.username">yourUsername</property>
<property name="hibernate.connection.password">yourPassword</property>
Compile & Run:

bash
Copy
Edit
javac -cp "lib/*" com/project/*.java
java -cp ".:lib/*" com.project.Main
🌱 Ideal For
Students learning Hibernate and ORM concepts

Java developers practicing database integration

Academic projects or backend practice apps

🔮 Possible Enhancements
✏️ Add "Update Book" functionality

🔠 Search books by title or author (not just ID)

📃 Implement pagination for large datasets

🌐 Convert to a web app using Spring Boot + Thymeleaf

🧪 Add unit tests with JUnit and H2 in-memory DB

👤 Author
Gowtham G
🎓 3rd Year Integrated M.Tech, VIT Vellore
🔗 LinkedIn (replace with your actual profile)

📄 License
This project is free to use for academic or personal learning purposes.

yaml
Copy
Edit

---

Let me know if you'd like:
- A `.pdf` export
- A GitHub banner or profile-level `README`
- This converted into a project report or slides

Happy coding, Gowtham! 🚀
