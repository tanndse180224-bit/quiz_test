# HƯỚNG DẪN IMPORT 500 CÂU HỎI

## 🎯 Bạn có 3 cách để import 500 câu hỏi:

---

## **Cách 1: Dùng Script Python Tự Động** ⭐ (NHANH NHẤT - 2 phút)

### Bước 1: Tạo file `raw_questions.txt`
Copy **TẤT CẢ** câu hỏi của bạn vào file này (ở thư mục gốc `c:\quiz-app\raw_questions.txt`).

Format giữ nguyên như bạn đã paste:
```
Xanh-ximông là đại biểu của trường phái nào?
A. Chủ nghĩa xã hội không tưởng Pháp
B. Chủ nghĩa xã hội không tưởng Đức
C. Triết học cổ điển Đức
D. Kinh tế chính trị học Anh
A

Quan hệ giữa người với người...
A. ...
B. ...
C. ...
D. ...
C
```

### Bước 2: Chạy script
```powershell
cd c:\quiz-app  
python parse_questions.py
```

### Bước 3: Restart app
```powershell
Stop-Process -Name "java" -Force -ErrorAction SilentlyContinue
Start-Sleep -Seconds 2
mvn spring-boot:run
```

✅ **Xong!** Script sẽ tự động parse 500 câu vào `questions.json`.

---

## **Cách 2: Chỉnh Sửa Trực Tiếp File JSON** (Thủ công - 30 phút)

Mở file `src/main/resources/questions.json` và paste theo format:

```json
[
  {
    "question": "Câu hỏi 1?",
    "answers": [
      "Đáp án A",
      "Đáp án B",
      "Đáp án C",
      "Đáp án D"
    ],
    "correctAnswer": "A"
  },
  {
    "question": "Câu hỏi 2?",
    "answers": ["A", "B", "C", "D"],
    "correctAnswer": "C"
  }
]
```

**Lưu ý:**
- Câu cuối cùng **KHÔNG** có dấu phẩy
- `correctAnswer` phải là "A", "B", "C", hoặc "D" (viết HOA)
- Mỗi câu phải có 2-4 đáp án

---

## **Cách 3: Sử dụng Tool Online** (Dễ nhất - 10 phút)  

### Bước 1: Truy cập công cụ chuyển đổi
Tôi đề xuất: **https://json-generator.com** hoặc **ChatGPT**

### Bước 2: Paste câu hỏi và yêu cầu convert
Ví dụ prompt cho ChatGPT:
```
Chuyển đổi các câu hỏi sau sang JSON format:
{
  "question": "...",
  "answers": ["A", "B", "C", "D"],
  "correctAnswer": "A"
}

[Paste 500 câu hỏi của bạn]
```

### Bước 3: Copy kết quả vào `questions.json`

---

## ⚠️ Xử Lý Câu Hỏi Nhiều Đáp Án Đúng

Một số câu có nhiều đáp án (ví dụ: BCD, ABC). Hiện tại hệ thống **chỉ hỗ trợ 1 đáp án**, nên:
- **Tạm thời:** Chỉ lấy đáp án đầu tiên (B trong BCD)
- **Hoặc:** Gộp thành 1 đáp án mới: `"Tất cả B, C, D đều đúng"`

---

## 🔥 Khuyến Nghị Của Tôi

1. **Dùng Cách 1 (Script Python)** - Nhanh, tự động, ít lỗi
2. Nếu không có Python, dùng **Cách 3 (ChatGPT)**
3. Cách 2 chỉ dùng khi muốn kiểm soát 100%

---

## 📞 Cần Hỗ Trợ?

Nếu gặp vấn đề, paste câu hỏi có lỗi vào chat, tôi sẽ debug ngay!

**Chúc bạn import thành công 500 câu! 🎉**
