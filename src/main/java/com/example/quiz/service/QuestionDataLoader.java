package com.example.quiz.service;

import com.example.quiz.data.JsonQuestionLoader;
import com.example.quiz.data.PhilosophyQuestions;
import com.example.quiz.dto.QuestionDTO;
import com.example.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class QuestionDataLoader implements CommandLineRunner {
    
    @Autowired
    private QuestionService questionService;
    
    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private JsonQuestionLoader jsonQuestionLoader;
    
    @Override
    public void run(String... args) throws Exception {
        // Chỉ load data nếu database trống
        long count = questionRepository.count();
        if (count == 0) {
            System.out.println("=== Bắt đầu import câu hỏi từ questions.json vào database ===");
            loadQuestions();
            long totalQuestions = questionRepository.count();
            System.out.println("=== Hoàn thành! Đã import thành công " + totalQuestions + " câu hỏi ===");
        } else {
            System.out.println("=== Database đã có " + count + " câu hỏi ===");
        }
    }
    
    private void loadQuestions() {
        // Đọc câu hỏi từ file JSON
        List<JsonQuestionLoader.QuestionItem> questions = jsonQuestionLoader.loadQuestionsFromJson();
        
        if (questions.isEmpty()) {
            System.err.println("CẢNH BÁO: Không tìm thấy câu hỏi nào trong questions.json!");
            System.out.println("Đang load câu hỏi mẫu từ PhilosophyQuestions...");
            loadFallbackQuestions();
            return;
        }
        
        int successCount = 0;
        int failCount = 0;
        
        for (JsonQuestionLoader.QuestionItem qData : questions) {
            try {
                QuestionDTO dto = new QuestionDTO();
                dto.setQuestionText(qData.getQuestion());
                dto.setAnswers(qData.getAnswers());
                dto.setCorrectAnswerIndex(qData.getCorrectIndex());
                
                questionService.createQuestion(dto);
                successCount++;
                
                if (successCount % 50 == 0) {
                    System.out.println("  + Đã import " + successCount + " câu hỏi...");
                }
            } catch (Exception e) {
                failCount++;
                System.err.println("  ! Lỗi khi import câu hỏi: " + qData.getQuestion());
                System.err.println("    Error: " + e.getMessage());
            }
        }
        
        System.out.println("  ✓ Thành công: " + successCount + " câu");
        if (failCount > 0) {
            System.out.println("  ✗ Thất bại: " + failCount + " câu");
        }
    }
    
    /**
     * Load câu hỏi mẫu từ PhilosophyQuestions nếu JSON không có dữ liệu
     */
    private void loadFallbackQuestions() {
        List<PhilosophyQuestions.QuestionItem> questions = PhilosophyQuestions.getAllQuestions();
        
        int successCount = 0;
        int failCount = 0;
        
        for (PhilosophyQuestions.QuestionItem qData : questions) {
            try {
                QuestionDTO dto = new QuestionDTO();
                dto.setQuestionText(qData.question);
                dto.setAnswers(qData.answers);
                dto.setCorrectAnswerIndex(qData.correctIndex);
                
                questionService.createQuestion(dto);
                successCount++;
                
                if (successCount % 10 == 0) {
                    System.out.println("  + Đã import " + successCount + " câu hỏi...");
                }
            } catch (Exception e) {
                failCount++;
                System.err.println("  ! Lỗi khi import câu hỏi: " + qData.question);
                System.err.println("    Error: " + e.getMessage());
            }
        }
        
        System.out.println("  ✓ Thành công: " + successCount + " câu");
        if (failCount > 0) {
            System.out.println("  ✗ Thất bại: " + failCount + " câu");
        }
    }
}
