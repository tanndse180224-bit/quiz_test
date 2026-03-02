# HƯỚNG DẪN IMPORT 500 CÂU HỎI VÀO HỆ THỐNG

## 🎯 Tổng quan
Hệ thống đã được cấu hình để **tự động đọc câu hỏi từ file JSON** khi khởi động. Bạn chỉ cần paste 500 câu vào file `questions.json` theo đúng format.

## 📝 Cách thực hiện

### Bước 1: Mở file questions.json
File này nằm tại: `src/main/resources/questions.json`

### Bước 2: Paste câu hỏi theo format

```json
[
  {
    "question": "Câu hỏi của bạn ở đây?",
    "answers": [
      "Đáp án A",
      "Đáp án B",
      "Đáp án C",
      "Đáp án D"
    ],
    "correctAnswer": "A"
  },
  {
    "question": "Câu hỏi tiếp theo?",
    "answers": [
      "Đáp án A",
      "Đáp án B",
      "Đáp án C",
      "Đáp án D"
    ],
    "correctAnswer": "B"
  }
]
```

### Bước 3: Quy tắc quan trọng

✅ **ĐÚng:**
- Mỗi câu hỏi là 1 object với 3 field: `question`, `answers`, `correctAnswer`
- `answers` phải là array có 2-4 phần tử
- `correctAnswer` là "A", "B", "C" hoặc "D" (viết hoa)
- Câu cuối cùng **KHÔNG có dấu phẩy**
- Đặt trong ngoặc vuông `[]`

❌ **SAI:**
```json
{
  "correctAnswer": "a"  // Sai: phải viết HOA
}
```
```json
{
  "answers": ["Đáp án A"]  // Sai: phải có ít nhất 2 đáp án
}
```

### Bước 4: Chuyển đổi dữ liệu của bạn

Nếu bạn có 500 câu dạng text như này:
```
Câu 1: Xanh-ximông là đại biểu của trường phái nào?
A. Chủ nghĩa xã hội không tưởng Pháp
B. Chủ nghĩa xã hội không tưởng Đức
C. Triết học cổ điển Đức
D. Kinh tế chính trị học Anh
A
```

**Tôi có thể giúp bạn chuyển đổi!** Chỉ cần:
1. Paste toàn bộ 500 câu (dạng text) vào đây
2. Tôi sẽ tự động chuyển thành JSON format
3. Bạn copy kết quả vào `questions.json`

### Bước 5: Restart ứng dụng

```powershell
# Dừng app
Stop-Process -Name "java" -Force

# Khởi động lại
mvn spring-boot:run
```

## 🔍 Kiểm tra kết quả

Khi app khởi động, bạn sẽ thấy log:
```
=== Bắt đầu import câu hỏi từ questions.json vào database ===
  + Đã import 50 câu hỏi...
  + Đã import 100 câu hỏi...
  ...
  + Đã import 500 câu hỏi...
  ✓ Thành công: 500 câu
=== Hoàn thành! Đã import thành công 500 câu hỏi ===
```

## 💡 Lưu ý

1. **Database H2 (in-memory)**: Dữ liệu sẽ mất khi tắt app. Mỗi lần restart sẽ load lại từ JSON.
   
2. **Nếu muốn database persistent** (lưu vĩnh viễn):
   - Thay đổi trong `application.properties`:
   ```properties
   # Thay vì in-memory:
   # spring.datasource.url=jdbc:h2:mem:quizdb
   
   # Dùng file-based:
   spring.datasource.url=jdbc:h2:file:./data/quizdb
   ```

3. **Backup dữ liệu**: File JSON chính là backup của bạn. Giữ nó cẩn thận!

## 🚀 Sẵn sàng import?

Bạn có thể:
- **Option 1**: Tự chỉnh sửa file `questions.json`
- **Option 2**: Paste 500 câu text vào chat, tôi convert thành JSON cho bạn

Bạn chọn cách nào? 😊
