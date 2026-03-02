# 🎓 Ứng dụng Thi Trắc Nghiệm Online - Triết học Mác-Lênin

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-green)
![License](https://img.shields.io/badge/License-MIT-blue)

Ứng dụng web cho phép quản lý câu hỏi trắc nghiệm và thực hiện bài kiểm tra trực tuyến. Hệ thống **tự động import 50+ câu hỏi Triết học** khi khởi động lần đầu.

## ✨ Tính năng Nổi bật

### 🎯 Dành cho Người dùng/Học sinh
- **Làm bài thi**: Câu hỏi được xáo trộn ngẫu nhiên mỗi lần
- **Radio button đẹp mắt**: Dễ click, responsive
- **Cảnh báo thông minh**: Warning nếu chưa trả lời đủ
- **Kết quả chi tiết**: 
  - Điểm số với animation đếm ngược
  - Thống kê (đúng/sai/tổng)
  - Review từng câu với màu sắc (xanh = đúng, đỏ = sai)

### 👨‍🏫 Dành cho Giáo viên
- Thêm/Sửa/Xóa câu hỏi
- Hỗ trợ 2-4 đáp án
- Validation tự động

### 🔄 Tính năng Tự động
- **Auto-import**: 50+ câu hỏi Triết học
- **Database**: H2 in-memory, tự động tạo schema

## 🛠️ Công nghệ

- **Backend**: Spring Boot 3.2.0, Java 17
- **Frontend**: Thymeleaf, Bootstrap 5.3.0, Font Awesome 6.4.0
- **Database**: H2 (in-memory)
- **Build**: Maven 3.x

## 📁 Cấu trúc Project

```
quiz-app/
├── src/main/java/com/example/quiz/
│   ├── controller/       # REST Controllers
│   ├── service/          # Business Logic + DataLoader
│   ├── repository/       # JPA Repositories
│   ├── model/            # JPA Entities
│   ├── dto/              # Data Transfer Objects
│   └── data/             # PhilosophyQuestions.java (50+ câu)
├── src/main/resources/
│   ├── templates/        # Thymeleaf HTML
│   └── application.properties
└── pom.xml
```

## 🚀 Cách Chạy

### Yêu cầu
- Java 17+
- Maven 3.6+
- Port 8080 trống

### Các bước

```bash
# 1. Di chuyển vào thư mục project
cd c:\quiz-app

# 2. Build project
mvn clean package -DskipTests

# 3. Chạy ứng dụng
mvn spring-boot:run

# 4. Mở trình duyệt
# Trang chủ: http://localhost:8080
# H2 Console: http://localhost:8080/h2-console
#   - JDBC URL: jdbc:h2:mem:quizdb
#   - Username: sa
#   - Password: (để trống)
```

## 📊 Database Schema

### QUESTION
| Cột | Kiểu | Mô tả |
|-----|------|-------|
| id | BIGINT | PK (auto) |
| question_text | VARCHAR(1000) | Nội dung |
| correct_answer_index | INTEGER | Index đúng (0-3) |

### ANSWER
| Cột | Kiểu | Mô tả |
|-----|------|-------|
| id | BIGINT | PK (auto) |
| answer_text | VARCHAR(500) | Nội dung |
| answer_order | INTEGER | Thứ tự (0-3) |
| question_id | BIGINT | FK → QUESTION |

## 📚 API Endpoints

### Public (User)
- `GET /` → Trang chủ
- `GET /quiz/start` → Bắt đầu thi
- `POST /quiz/submit` → Nộp bài + xem kết quả

### Admin (Teacher)
- `GET /questions` → Danh sách câu hỏi
- `GET /questions/new` → Form thêm mới
- `POST /questions/new` → Lưu câu hỏi
- `GET /questions/edit/{id}` → Form sửa
- `POST /questions/edit/{id}` → Cập nhật
- `POST /questions/delete/{id}` → Xóa

## 🎨 UI Design

- **Gradient**: `linear-gradient(135deg, #667eea 0%, #764ba2 100%)`
- **Typography**: System fonts (SF Pro, Segoe UI, Roboto)
- **Icons**: Font Awesome 6.4.0
- **Cards**: White với shadow + hover

## 📝 Thêm Câu hỏi

### Cách 1: Qua Web (khuyến nghị)
1. Truy cập http://localhost:8080/questions
2. Click "Thêm Câu Hỏi Mới"
3. Điền form → Lưu

### Cách 2: Code (bulk import)
Mở `PhilosophyQuestions.java`:

```java
questions.add(new QuestionItem(
    "Câu hỏi của bạn?",
    Arrays.asList("Đáp án A", "Đáp án B", "Đáp án C", "Đáp án D"),
    0  // Index đúng (0-3)
));
```

Sau đó restart app.

## ⚙️ Cấu hình

File `application.properties`:

```properties
# Server
server.port=8080

# H2 Database
spring.datasource.url=jdbc:h2:mem:quizdb
spring.datasource.username=sa
spring.datasource.password=

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false

# Thymeleaf
spring.thymeleaf.cache=false
```

## 🐛 Troubleshooting

### Port 8080 đang dùng
```bash
# Windows
netstat -ano | findstr :8080
taskkill /PID <PID> /F

# Hoặc đổi port trong application.properties
server.port=8081
```

### Không có câu hỏi
- Kiểm tra log khi khởi động
- Xem H2 console: `SELECT * FROM QUESTION`
- Restart app để trigger auto-import

### Validation Error
- 2-4 đáp án required
- Index đúng: 0 ≤ index < số đáp án

## 💡 Tips

1. **Development**: Cache đã tắt → Reload browser để thấy thay đổi
2. **Production**: Đổi sang PostgreSQL/MySQL trong `pom.xml` và `application.properties`
3. **More Questions**: Thêm vào `PhilosophyQuestions.java` (50 câu hiện tại)

## 📖 Tài liệu

- [Spring Boot 3.2](https://docs.spring.io/spring-boot/docs/3.2.0/reference/html/)
- [Thymeleaf](https://www.thymeleaf.org/documentation.html)
- [Bootstrap 5](https://getbootstrap.com/docs/5.3/)

## � Author

**Tann D** - [@tanndse180224-bit](https://github.com/tanndse180224-bit)

## �👥 Credits

Xây dựng với Spring Boot và ❤️

---

**🎉 Chúc bạn học tốt Triết học Mác-Lênin!** 📚
