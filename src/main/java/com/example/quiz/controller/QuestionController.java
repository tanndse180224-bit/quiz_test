package com.example.quiz.controller;

import com.example.quiz.dto.QuestionDTO;
import com.example.quiz.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    
    @Autowired
    private QuestionService questionService;
    
    @GetMapping
    public String listQuestions(Model model) {
        model.addAttribute("questions", questionService.getAllQuestions());
        return "questions/list";
    }
    
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        QuestionDTO questionDTO = new QuestionDTO();
        // Initialize with 2 empty answers
        questionDTO.setAnswers(new ArrayList<>());
        questionDTO.getAnswers().add("");
        questionDTO.getAnswers().add("");
        model.addAttribute("question", questionDTO);
        model.addAttribute("isEdit", false);
        return "questions/form";
    }
    
    @PostMapping("/new")
    public String createQuestion(@Valid @ModelAttribute("question") QuestionDTO questionDTO,
                                BindingResult result,
                                RedirectAttributes redirectAttributes,
                                Model model) {
        if (result.hasErrors()) {
            model.addAttribute("isEdit", false);
            return "questions/form";
        }
        
        try {
            questionService.createQuestion(questionDTO);
            redirectAttributes.addFlashAttribute("successMessage", "Tạo câu hỏi thành công!");
            return "redirect:/questions";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("isEdit", false);
            return "questions/form";
        }
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return questionService.getQuestionById(id)
                .map(question -> {
                    model.addAttribute("question", question);
                    model.addAttribute("isEdit", true);
                    return "questions/form";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy câu hỏi!");
                    return "redirect:/questions";
                });
    }
    
    @PostMapping("/edit/{id}")
    public String updateQuestion(@PathVariable Long id,
                               @Valid @ModelAttribute("question") QuestionDTO questionDTO,
                               BindingResult result,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        if (result.hasErrors()) {
            model.addAttribute("isEdit", true);
            return "questions/form";
        }
        
        try {
            questionService.updateQuestion(id, questionDTO);
            redirectAttributes.addFlashAttribute("successMessage", "Cập nhật câu hỏi thành công!");
            return "redirect:/questions";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("isEdit", true);
            return "questions/form";
        }
    }
    
    @GetMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            questionService.deleteQuestion(id);
            redirectAttributes.addFlashAttribute("successMessage", "Xóa câu hỏi thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Lỗi khi xóa câu hỏi!");
        }
        return "redirect:/questions";
    }
    
    /**
     * Xem tất cả câu hỏi với chi tiết - CÓ LỖI CỐ TÌNH
     */
    @GetMapping("/view-all")
    public String viewAllQuestionsWithDetails(Model model) {
        // LỖI 6: Không handle exception
        List<QuestionDTO> questions = questionService.getAllQuestionsWithDetails();
        
        // LỖI CÚ PHÁP 4 ĐÃ SỬA: Thêm dấu chấm phẩy
        
        // LỖI 7: Gọi method trên object có thể null
        String firstQuestionText = null;
        if (questions.size() > 0) {
            QuestionDTO firstQ = questions.get(0);
            firstQuestionText = firstQ.getQuestionText().toUpperCase(); // Có thể null
        }
        
        // LỖI CÚ PHÁP 5-8 ĐÃ SỬA: Thêm dấu chấm phẩy và dấu )
        
        // LỖI 8 ĐÃ SỬA: Logic đúng - dùng questions.size() không cộng thêm 1
        int totalQuestions = questions.size();
        
        // LỖI CÚ PHÁP 9 ĐÃ SỬA: Thêm dấu chấm phẩy
        
        model.addAttribute("questions", questions);
        model.addAttribute("totalQuestions", totalQuestions);
        model.addAttribute("firstQuestion", firstQuestionText);
        
        // LỖI CÚ PHÁP 10, 11, 12 ĐÃ SỬA: Thêm dấu chấm phẩy ở 3 dòng trên
        
        return "questions/view-all";
    }
    // LỖI CÚ PHÁP 13 ĐÃ SỬA: Thêm dấu chấm phẩy ở return statement
}
