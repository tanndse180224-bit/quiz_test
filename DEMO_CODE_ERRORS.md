# Demo Code Scene - Các Lỗi Cố Tình

## Mục đích
File này mô tả các lỗi cố tình được thêm vào chức năng "Xem Tất Cả Câu Hỏi Chi Tiết" để demo khả năng debug và sửa lỗi.

## Cách truy cập
1. Khởi động ứng dụng
2. Truy cập trang chủ: `http://localhost:8080`
3. Click vào nút **"Demo Code Lỗi"** (màu vàng có icon bug)
4. Hoặc truy cập trực tiếp: `http://localhost:8080/questions/view-all`

## Tổng quan các lỗi

### Loại lỗi:
- **3 lỗi cú pháp ở Service** (dễ sửa)
- **10 lỗi cú pháp ở Controller** 
- **5 lỗi runtime** (Runtime Errors)
- **3 lỗi logic/warning** (Logic Errors & Warnings)
- **Tổng cộng: 21 lỗi!**

### Chiến lược sửa lỗi:
1. **Bước 1**: Sửa 3 lỗi cú pháp ở Service trước (dễ nhất) ⚡
2. **Bước 2**: Sửa 10 lỗi cú pháp ở Controller 🔧
3. **Bước 3**: Chạy và gặp các lỗi runtime → debug từng cái 🐛
4. **Bước 4**: Sửa các warning và logic errors ✨

### Tóm tắt nhanh:
**Service (QuestionService.java)** - CHỈ 3 LỖI CÚ PHÁP:
- Dòng 36: Thiếu `;` sau unusedVariable
- Dòng 50: Thiếu `;` sau firstAnswer  
- Dòng 62: Thiếu `;` sau result.add(dto)

**Controller (QuestionController.java)** - 10 LỖI CÚ PHÁP:
- Dòng 114: Thiếu `;` 
- Dòng 119: Thiếu `;`
- Dòng 120: Thiếu `)` trong if
- Dòng 121: Thiếu `;`
- Dòng 122: Thiếu `;`
- Dòng 130: Thiếu `;`
- Dòng 134, 135, 136: Thiếu `;` (3 lỗi)
- Dòng 140: Thiếu `;`

**Runtime Errors (Sẽ gặp sau khi build thành công)**:
- ArrayIndexOutOfBoundsException (vòng lặp `i <= size()`)
- ArrayIndexOutOfBoundsException (truy cập index 4)
- ArithmeticException (chia cho 0)
- NullPointerException (không check null)

---

## CHI TIẾT CÁC LỖI

### PHẦN 1: LỖI CÚ PHÁP Ở SERVICE (3 lỗi - Ưu tiên sửa trước)

#### File: QuestionService.java - Method: getAllQuestionsWithDetails()

**LỖI CÚ PHÁP 1**: Thiếu dấu chấm phẩy
```java
String unusedVariable = "This variable is never used"
int totalAnswers = 0;
```
- **Vị trí**: Dòng 36
- **Lỗi**: `;` expected
- **Cách sửa**: Thêm `;` sau "is never used"

**LỖI CÚ PHÁP 2**: Thiếu dấu chấm phẩy
```java
String firstAnswer = dto.getAnswers().get(0)
String fifthAnswer = dto.getAnswers().get(4);
```
- **Vị trí**: Dòng 50
- **Lỗi**: `;` expected
- **Cách sửa**: Thêm `;` sau .get(0)

**LỖI CÚ PHÁP 3**: Thiếu dấu chấm phẩy
```java
result.add(dto)
```
- **Vị trí**: Dòng 62
- **Lỗi**: `;` expected
- **Cách sửa**: Thêm `;` sau result.add(dto)

---

### PHẦN 2: LỖI CÚ PHÁP Ở CONTROLLER (10 lỗi)

#### File: QuestionController.java - Method: viewAllQuestionsWithDetails()

**LỖI CÚ PHÁP 4**: Thiếu dấu chấm phẩy
```java
List<QuestionDTO> questions = questionService.getAllQuestionsWithDetails()
```
- **Vị trí**: Dòng 114
- **Lỗi**: `;` expected
- **Cách sửa**: Thêm `;` vào cuối dòng

**LỖI CÚ PHÁP 5**: Thiếu dấu chấm phẩy
```java
String firstQuestionText = null
if (questions.size() > 0 {
```
- **Vị trí**: Dòng 119
- **Lỗi**: `;` expected
- **Cách sửa**: Thêm `;` sau null

**LỖI CÚ PHÁP 6**: Thiếu dấu đóng ngoặc )
```java
if (questions.size() > 0 {
```
- **Vị trí**: Dòng 120
- **Lỗi**: `)` expected
- **Cách sửa**: Thêm `)` trước dấu `{`

**LỖI CÚ PHÁP 7**: Thiếu dấu chấm phẩy
```java
QuestionDTO firstQ = questions.get(0)
```
- **Vị trí**: Dòng 121
- **Lỗi**: `;` expected
- **Cách sửa**: Thêm `;` vào cuối dòng

**LỖI CÚ PHÁP 8**: Thiếu dấu chấm phẩy
```java
firstQuestionText = firstQ.getQuestionText().toUpperCase()
```
- **Vị trí**: Dòng 122
- **Lỗi**: `;` expected
- **Cách sửa**: Thêm `;` vào cuối dòng

**LỖI CÚ PHÁP 9**: Thiếu dấu chấm phẩy
```java
int totalQuestions = questions.size() + 1
```
- **Vị trí**: Dòng 130
- **Lỗi**: `;` expected
- **Cách sửa**: Thêm `;` vào cuối dòng

**LỖI CÚ PHÁP 10**: Thiếu dấu chấm phẩy
```java
model.addAttribute("questions", questions)
```
- **Vị trí**: Dòng 134
- **Lỗi**: `;` expected
- **Cách sửa**: Thêm `;` vào cuối dòng

**LỖI CÚ PHÁP 11**: Thiếu dấu chấm phẩy
```java
model.addAttribute("totalQuestions", totalQuestions)
```
- **Vị trí**: Dòng 135
- **Lỗi**: `;` expected
- **Cách sửa**: Thêm `;` vào cuối dòng

**LỖI CÚ PHÁP 12**: Thiếu dấu chấm phẩy
```java
model.addAttribute("firstQuestion", firstQuestionText)
```
- **Vị trí**: Dòng 136
- **Lỗi**: `;` expected
- **Cách sửa**: Thêm `;` vào cuối dòng

**LỖI CÚ PHÁP 13**: Thiếu dấu chấm phẩy
```java
return "questions/view-all"
```
- **Vị trí**: Dòng 140
- **Lỗi**: `;` expected
- **Cách sửa**: Thêm `;` vào cuối dòng

---

### PHẦN 3: LỖI RUNTIME (Sẽ gặp sau khi sửa xong lỗi cú pháp)
```java
String unusedVariable = "This variable is never used";
int totalAnswers = 0;
```
- **Vị trí**: Dòng 36-37
- **Loại**: Warning - Biến được khai báo nhưng không được sử dụng
- **Cách phát hiện**: Compiler sẽ cảnh báo "The value of the local variable is not used"
- **Cách sửa**: Xóa biến không dùng hoặc sử dụng chúng

#### Lỗi 2: ArrayIndexOutOfBoundsException
```java
for (int i = 0; i <= questions.size(); i++) {
    Question q = questions.get(i);
    ...
}
```
- **Vị trí**: Dòng 40
- **Loại**: Runtime Error - Vòng lặp vượt quá kích thước mảng
- **Nguyên nhân**: Dùng `<=` thay vì `<` trong điều kiện vòng lặp
- **Kết quả**: Khi i = questions.size(), sẽ ném ArrayIndexOutOfBoundsException
- **Cách sửa**: Đổi `i <= questions.size()` thành `i < questions.size()`

#### Lỗi 3: NullPointerException tiềm ẩn
```java
List<String> answers = dto.getAnswers();
totalAnswers += answers.size(); // Nếu answers null thì lỗi
```
- **Vị trí**: Dòng 45-46
- **Loại**: Potential Runtime Error
- **Nguyên nhân**: Không kiểm tra null trước khi gọi method
- **Cách sửa**: Thêm null check: `if (answers != null) { ... }`

#### Lỗi 4: ArrayIndexOutOfBoundsException khi truy cập index không tồn tại
```java
String firstAnswer = dto.getAnswers().get(0);
String fifthAnswer = dto.getAnswers().get(4); // Chỉ có 4 answers (0-3)
```
- **Vị trí**: Dòng 49-50
- **Loại**: Runtime Error
- **Nguyên nhân**: Truy cập index 4 trong khi mảng chỉ có 4 phần tử (index 0-3)
- **Kết quả**: Ném ArrayIndexOutOfBoundsException
- **Cách sửa**: Kiểm tra size trước khi truy cập hoặc dùng index hợp lệ

#### Lỗi 5: ArithmeticException - Division by Zero
```java
int totalLength = dto.getAnswers().stream()
    .mapToInt(String::length)
    .sum();
avgLength = totalLength / (dto.getAnswers().size() - dto.getAnswers().size()); // Chia cho 0
```
- **Vị trí**: Dòng 54-58
- **Loại**: Runtime Error
- **Nguyên nhân**: `size() - size() = 0`, chia cho 0
- **Kết quả**: Ném ArithmeticException: / by zero
- **Cách sửa**: Sử dụng đúng công thức: `totalLength / dto.getAnswers().size()`

### File: QuestionController.java - Method: viewAllQuestionsWithDetails()

#### Lỗi 6: Không xử lý Exception
```java
List<QuestionDTO> questions = questionService.getAllQuestionsWithDetails();
```
- **Vị trí**: Dòng 114
- **Loại**: Bad Practice
- **Nguyên nhân**: Method gọi có thể ném nhiều exception nhưng không được xử lý
- **Cách sửa**: Thêm try-catch để xử lý exception

#### Lỗi 7: NullPointerException tiềm ẩn
```java
String firstQuestionText = null;
if (questions.size() > 0) {
    QuestionDTO firstQ = questions.get(0);
    firstQuestionText = firstQ.getQuestionText().toUpperCase(); // getQuestionText() có thể null
}
```
- **Vị trí**: Dòng 117-120
- **Loại**: Potential Runtime Error
- **Nguyên nhân**: Không kiểm tra null trước khi gọi toUpperCase()
- **Cách sửa**: Thêm null check cho getQuestionText()

#### Lỗi 8: Logic Error
```java
int totalQuestions = questions.size() + 1;
```
- **Vị trí**: Dòng 123
- **Loại**: Logic Error
- **Nguyên nhân**: Sai logic, cộng thêm 1 không cần thiết
- **Kết quả**: Hiển thị số lượng câu hỏi sai (nhiều hơn 1)
- **Cách sửa**: Bỏ `+ 1`, chỉ dùng `questions.size()`

## Thứ tự ưu tiên sửa lỗi

1. **Sửa trước**: Lỗi 2, 4, 5 (Runtime errors nguy hiểm nhất)
2. **Sửa tiếp**: Lỗi 6 (Exception handling)
3. **Sửa sau**: Lỗi 3, 7 (Null checks)
4. **Cuối cùng**: Lỗi 1, 8 (Warnings và logic errors)

## Kịch bản Demo

### Bước 1: Chạy và gặp lỗi đầu tiên
```
1. Click vào "Demo Code Lỗi"
2. Ứng dụng sẽ crash với ArrayIndexOutOfBoundsException (Lỗi 2)
3. Xem stack trace trong console
```

### Bước 2: Debug với IDE
```
1. Đặt breakpoint tại vòng lặp (dòng 40 trong QuestionService.java)
2. Chạy debug mode
3. Quan sát giá trị của i và questions.size()
4. Phát hiện i vượt quá size
```

### Bước 3: Sửa lỗi và test lại
```
1. Sửa <= thành <
2. Build lại project
3. Chạy lại và gặp lỗi tiếp theo (Lỗi 4 hoặc 5)
```

### Bước 4: Lặp lại cho các lỗi khác
```
Tiếp tục quá trình debug → fix → test cho đến khi tất cả lỗi được sửa
```

## Kiểm tra kết quả sau khi sửa

Sau khi sửa tất cả lỗi, trang `/questions/view-all` nên:
- ✅ Hiển thị danh sách câu hỏi không bị crash
- ✅ Thống kê số câu hỏi chính xác
- ✅ Hiển thị đúng tất cả câu trả lời
- ✅ Không có warning trong console

## Code đã sửa mẫu

### QuestionService.java (Đã sửa)
```java
public List<QuestionDTO> getAllQuestionsWithDetails() {
    List<Question> questions = questionRepository.findAll();
    List<QuestionDTO> result = new ArrayList<>();
    
    // Đã sửa: Vòng lặp đúng
    for (int i = 0; i < questions.size(); i++) {
        Question q = questions.get(i);
        QuestionDTO dto = convertToDTO(q);
        
        // Đã sửa: Thêm null check
        List<String> answers = dto.getAnswers();
        if (answers != null && !answers.isEmpty()) {
            // Đã sửa: Chỉ tính toán với index hợp lệ
            int totalLength = answers.stream()
                .mapToInt(String::length)
                .sum();
            // Đã sửa: Chia đúng
            int avgLength = totalLength / answers.size();
        }
        
        result.add(dto);
    }
    
    return result;
}
```

### QuestionController.java (Đã sửa)
```java
@GetMapping("/view-all")
public String viewAllQuestionsWithDetails(Model model) {
    try {
        List<QuestionDTO> questions = questionService.getAllQuestionsWithDetails();
        
        String firstQuestionText = "Không có";
        if (!questions.isEmpty()) {
            QuestionDTO firstQ = questions.get(0);
            // Đã sửa: Thêm null check
            if (firstQ.getQuestionText() != null) {
                firstQuestionText = firstQ.getQuestionText().toUpperCase();
            }
        }
        
        // Đã sửa: Bỏ + 1
        int totalQuestions = questions.size();
        
        model.addAttribute("questions", questions);
        model.addAttribute("totalQuestions", totalQuestions);
        model.addAttribute("firstQuestion", firstQuestionText);
        
        return "questions/view-all";
    } catch (Exception e) {
        // Xử lý exception
        model.addAttribute("errorMessage", "Có lỗi xảy ra: " + e.getMessage());
        return "error";
    }
}
```

## Lưu ý
- Code lỗi này chỉ để demo, **KHÔNG** deploy lên production
- Dùng để thực hành debugging và error handling
- Học cách sử dụng IDE debugger hiệu quả
- Hiểu về các loại lỗi: Compile-time vs Runtime vs Logic errors
