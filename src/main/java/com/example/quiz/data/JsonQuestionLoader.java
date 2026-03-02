package com.example.quiz.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class JsonQuestionLoader {
    
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    /**
     * Đọc câu hỏi từ file questions.json trong resources
     */
    public List<QuestionItem> loadQuestionsFromJson() {
        try {
            ClassPathResource resource = new ClassPathResource("questions.json");
            InputStream inputStream = resource.getInputStream();
            
            List<JsonQuestion> jsonQuestions = objectMapper.readValue(
                inputStream, 
                new TypeReference<List<JsonQuestion>>() {}
            );
            
            List<QuestionItem> questions = new ArrayList<>();
            for (JsonQuestion jq : jsonQuestions) {
                int correctIndex = convertAnswerToIndex(jq.getCorrectAnswer());
                questions.add(new QuestionItem(
                    jq.getQuestion(),
                    jq.getAnswers(),
                    correctIndex
                ));
            }
            
            return questions;
            
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file questions.json: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    /**
     * Chuyển đổi A, B, C, D thành index 0, 1, 2, 3
     */
    private int convertAnswerToIndex(String answer) {
        switch (answer.toUpperCase().trim()) {
            case "A": return 0;
            case "B": return 1;
            case "C": return 2;
            case "D": return 3;
            default: 
                System.err.println("Đáp án không hợp lệ: " + answer + ", mặc định là A");
                return 0;
        }
    }
    
    /**
     * Class để map JSON structure
     */
    public static class JsonQuestion {
        private String question;
        private List<String> answers;
        private String correctAnswer;
        
        public JsonQuestion() {}
        
        public String getQuestion() {
            return question;
        }
        
        public void setQuestion(String question) {
            this.question = question;
        }
        
        public List<String> getAnswers() {
            return answers;
        }
        
        public void setAnswers(List<String> answers) {
            this.answers = answers;
        }
        
        public String getCorrectAnswer() {
            return correctAnswer;
        }
        
        public void setCorrectAnswer(String correctAnswer) {
            this.correctAnswer = correctAnswer;
        }
    }
    
    /**
     * Class để trả về câu hỏi theo format của PhilosophyQuestions
     */
    public static class QuestionItem {
        private String question;
        private List<String> answers;
        private int correctIndex;
        
        public QuestionItem(String question, List<String> answers, int correctIndex) {
            this.question = question;
            this.answers = answers;
            this.correctIndex = correctIndex;
        }
        
        public String getQuestion() {
            return question;
        }
        
        public List<String> getAnswers() {
            return answers;
        }
        
        public int getCorrectIndex() {
            return correctIndex;
        }
    }
}
