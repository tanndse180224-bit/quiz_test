package com.example.quiz.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    
    private Long id;
    
    @NotBlank(message = "Câu hỏi không được để trống")
    private String questionText;
    
    private List<String> answers = new ArrayList<>();
    
    @NotNull(message = "Phải chọn đáp án đúng")
    @Min(value = 0, message = "Chỉ số đáp án đúng không hợp lệ")
    @Max(value = 3, message = "Chỉ số đáp án đúng không hợp lệ")
    private Integer correctAnswerIndex;
}
