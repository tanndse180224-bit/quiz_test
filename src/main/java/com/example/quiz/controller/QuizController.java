package com.example.quiz.controller;

import com.example.quiz.dto.QuestionDTO;
import com.example.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    
    @Autowired
    private QuestionService questionService;
    
    @GetMapping("/start")
    public String startQuiz(Model model) {
        List<QuestionDTO> questions = questionService.getAllQuestions();
        
        if (questions.isEmpty()) {
            model.addAttribute("errorMessage", "Chưa có câu hỏi nào trong hệ thống. Vui lòng thêm câu hỏi trước!");
            return "quiz/start";
        }
        
        // Shuffle questions for random order
        Collections.shuffle(questions);
        
        model.addAttribute("questions", questions);
        model.addAttribute("totalQuestions", questions.size());
        return "quiz/quiz";
    }
    
    @PostMapping("/submit")
    public String submitQuiz(@RequestParam Map<String, String> answers, Model model) {
        List<QuestionDTO> allQuestions = questionService.getAllQuestions();
        
        int correctCount = 0;
        int totalQuestions = 0;
        List<QuizResult> results = new ArrayList<>();
        
        for (QuestionDTO question : allQuestions) {
            String answeredIndexStr = answers.get("question_" + question.getId());
            
            if (answeredIndexStr != null) {
                totalQuestions++;
                int answeredIndex = Integer.parseInt(answeredIndexStr);
                boolean isCorrect = answeredIndex == question.getCorrectAnswerIndex();
                
                if (isCorrect) {
                    correctCount++;
                }
                
                QuizResult result = new QuizResult();
                result.setQuestion(question);
                result.setAnsweredIndex(answeredIndex);
                result.setCorrect(isCorrect);
                results.add(result);
            }
        }
        
        double score = totalQuestions > 0 ? (correctCount * 100.0 / totalQuestions) : 0;
        
        model.addAttribute("results", results);
        model.addAttribute("correctCount", correctCount);
        model.addAttribute("totalQuestions", totalQuestions);
        model.addAttribute("score", String.format("%.2f", score));
        
        return "quiz/result";
    }
    
    @GetMapping("/practice")
    public String startPractice(Model model) {
        List<QuestionDTO> questions = questionService.getAllQuestions();
        
        if (questions.isEmpty()) {
            model.addAttribute("errorMessage", "Chưa có câu hỏi nào trong hệ thống. Vui lòng thêm câu hỏi trước!");
            return "quiz/start";
        }
        
        // Shuffle questions for random order
        Collections.shuffle(questions);
        
        model.addAttribute("questions", questions);
        model.addAttribute("totalQuestions", questions.size());
        return "quiz/practice";
    }
    
    @PostMapping("/practice/check")
    @ResponseBody
    public Map<String, Object> checkAnswer(@RequestBody Map<String, Object> request) {
        Long questionId = Long.parseLong(request.get("questionId").toString());
        int answeredIndex = Integer.parseInt(request.get("answeredIndex").toString());
        
        QuestionDTO question = questionService.getQuestionById(questionId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy câu hỏi với ID: " + questionId));
        boolean isCorrect = answeredIndex == question.getCorrectAnswerIndex();
        
        Map<String, Object> response = new java.util.HashMap<>();
        response.put("correct", isCorrect);
        response.put("correctIndex", question.getCorrectAnswerIndex());
        response.put("correctAnswer", question.getAnswers().get(question.getCorrectAnswerIndex()));
        
        return response;
    }
    
    // Inner class for quiz results
    public static class QuizResult {
        private QuestionDTO question;
        private int answeredIndex;
        private boolean correct;
        
        public QuestionDTO getQuestion() {
            return question;
        }
        
        public void setQuestion(QuestionDTO question) {
            this.question = question;
        }
        
        public int getAnsweredIndex() {
            return answeredIndex;
        }
        
        public void setAnsweredIndex(int answeredIndex) {
            this.answeredIndex = answeredIndex;
        }
        
        public boolean isCorrect() {
            return correct;
        }
        
        public void setCorrect(boolean correct) {
            this.correct = correct;
        }
    }
}
