package com.example.quiz.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Câu hỏi không được để trống")
    @Column(nullable = false, length = 1000)
    private String questionText;
    
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    @Size(min = 2, max = 4, message = "Phải có từ 2 đến 4 câu trả lời")
    private List<Answer> answers = new ArrayList<>();
    
    @Column(nullable = false)
    private Integer correctAnswerIndex;
    
    // Helper methods
    public void addAnswer(Answer answer) {
        answers.add(answer);
        answer.setQuestion(this);
    }
    
    public void removeAnswer(Answer answer) {
        answers.remove(answer);
        answer.setQuestion(null);
    }
}
