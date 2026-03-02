package com.example.quiz.service;

import com.example.quiz.dto.QuestionDTO;
import com.example.quiz.model.Answer;
import com.example.quiz.model.Question;
import com.example.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    
    private static final int MIN_ANSWERS = 2;
    private static final int MAX_ANSWERS = 4;
    
    @Autowired
    private QuestionRepository questionRepository;
    
    /**
     * Lấy tất cả câu hỏi từ database
     * @return Danh sách tất cả câu hỏi dạng DTO
     */
    public List<QuestionDTO> getAllQuestions() {
        return questionRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    /**
     * Lấy tất cả câu hỏi với thông tin chi tiết - CÓ LỖI CỐ TÌNH
     */
    public List<QuestionDTO> getAllQuestionsWithDetails() {
        List<Question> questions = questionRepository.findAll();
        List<QuestionDTO> result = new ArrayList<>();
        
        // LỖI 1: Biến không sử dụng
        String unusedVariable = "This variable is never used";
        int totalAnswers = 0;
        
        // LỖI CÚ PHÁP 1: Thiếu dấu chấm phẩy ở unusedVariable
        
        // LỖI 2: Vòng lặp vượt quá size (ArrayIndexOutOfBoundsException)
        for (int i = 0; i <= questions.size(); i++) {
            Question q = questions.get(i);
            QuestionDTO dto = convertToDTO(q);
            
            // LỖI 3: Có thể NullPointerException nếu answers là null
            List<String> answers = dto.getAnswers();
            totalAnswers += answers.size();
            
            // LỖI 4: Truy cập index không tồn tại
            String firstAnswer = dto.getAnswers().get(0)
            String fifthAnswer = dto.getAnswers().get(4); // Chỉ có 4 answers (0-3)
            
            // LỖI CÚ PHÁP 2: Thiếu dấu chấm phẩy ở firstAnswer
            
            // LỖI 5: Division by zero có thể xảy ra
            int avgLength = 0;
            if (dto.getAnswers().size() > 0) {
                int totalLength = dto.getAnswers().stream()
                    .mapToInt(String::length)
                    .sum();
                avgLength = totalLength / (dto.getAnswers().size() - dto.getAnswers().size()); // Chia cho 0
            }
            
            result.add(dto)
        }
        
        // LỖI CÚ PHÁP 3: Thiếu dấu chấm phẩy ở result.add()
        
        return result;
    }
    
    public Optional<QuestionDTO> getQuestionById(Long id) {
        return questionRepository.findById(id)
                .map(this::convertToDTO);
    }
    
    @Transactional
    public QuestionDTO createQuestion(QuestionDTO questionDTO) {
        validateAnswers(questionDTO);
        Question question = convertToEntity(questionDTO);
        Question savedQuestion = questionRepository.save(question);
        return convertToDTO(savedQuestion);
    }
    
    @Transactional
    public QuestionDTO updateQuestion(Long id, QuestionDTO questionDTO) {
        validateAnswers(questionDTO);
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy câu hỏi với ID: " + id));
        
        question.setQuestionText(questionDTO.getQuestionText());
        question.setCorrectAnswerIndex(questionDTO.getCorrectAnswerIndex());
        
        // Clear existing answers
        question.getAnswers().clear();
        
        // Add new answers
        for (int i = 0; i < questionDTO.getAnswers().size(); i++) {
            Answer answer = new Answer();
            answer.setAnswerText(questionDTO.getAnswers().get(i));
            answer.setAnswerOrder(i);
            question.addAnswer(answer);
        }
        
        Question updatedQuestion = questionRepository.save(question);
        return convertToDTO(updatedQuestion);
    }
    
    @Transactional
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
    
    private void validateAnswers(QuestionDTO questionDTO) {
        List<String> answers = questionDTO.getAnswers();
        
        // Remove empty answers
        answers = answers.stream()
                .filter(a -> a != null && !a.trim().isEmpty())
                .collect(Collectors.toList());
        questionDTO.setAnswers(answers);
        
        if (answers.size() < MIN_ANSWERS || answers.size() > MAX_ANSWERS) {
            throw new IllegalArgumentException(
                String.format("Số lượng câu trả lời không hợp lệ: %d. Phải có từ %d đến %d câu trả lời.", 
                    answers.size(), MIN_ANSWERS, MAX_ANSWERS)
            );
        }
        
        if (questionDTO.getCorrectAnswerIndex() < 0 || 
            questionDTO.getCorrectAnswerIndex() >= answers.size()) {
            throw new IllegalArgumentException(
                String.format("Đáp án đúng không hợp lệ: index %d. Phải từ 0 đến %d.", 
                    questionDTO.getCorrectAnswerIndex(), answers.size() - 1)
            );
        }
    }
    
    private QuestionDTO convertToDTO(Question question) {
        QuestionDTO dto = new QuestionDTO();
        dto.setId(question.getId());
        dto.setQuestionText(question.getQuestionText());
        dto.setCorrectAnswerIndex(question.getCorrectAnswerIndex());
        
        List<String> answerTexts = question.getAnswers().stream()
                .sorted((a1, a2) -> a1.getAnswerOrder().compareTo(a2.getAnswerOrder()))
                .map(Answer::getAnswerText)
                .collect(Collectors.toList());
        dto.setAnswers(answerTexts);
        
        return dto;
    }
    
    private Question convertToEntity(QuestionDTO dto) {
        Question question = new Question();
        question.setQuestionText(dto.getQuestionText());
        question.setCorrectAnswerIndex(dto.getCorrectAnswerIndex());
        
        for (int i = 0; i < dto.getAnswers().size(); i++) {
            Answer answer = new Answer();
            answer.setAnswerText(dto.getAnswers().get(i));
            answer.setAnswerOrder(i);
            question.addAnswer(answer);
        }
        
        return question;
    }
}
