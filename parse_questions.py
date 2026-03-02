# -*- coding: utf-8 -*-
import json
import re

def parse_questions_from_text(text_file_path, output_json_path):
    """
    Parse câu hỏi từ file text và chuyển thành JSON
    """
    with open(text_file_path, 'r', encoding='utf-8') as f:
        content = f.read()
    
    questions = []
    current_question = None
    current_answers = []
    
    lines = content.split('\n')
    i = 0
    
    while i < len(lines):
        line = lines[i].strip()
        
        # Skip empty lines
        if not line:
            i += 1
            continue
        
        # Check if this is an answer line (starts with A., B., C., D., A, B, C, D)
        if re.match(r'^[A-D]\.?\s+', line):
            # Extract answer text
            answer_text = re.sub(r'^[A-D]\.?\s+', '', line)
            current_answers.append(answer_text)
            i += 1
            continue
        
        # Check if this is a correct answer indicator (single letter A, B, C, D on its own line)
        if re.match(r'^[A-D]$', line) and current_question and len(current_answers) >= 2:
            # We have a complete question
            questions.append({
                "question": current_question,
                "answers": current_answers,
                "correctAnswer": line
            })
            current_question = None
            current_answers = []
            i += 1
            continue
        
        # Check for special multi-answer format (e.g., "BCD", "ABC")
        if re.match(r'^[A-D]{2,4}$', line) and current_question and len(current_answers) >= 2:
            # For now, use first letter as correct answer
            # TODO: Handle multiple correct answers
            questions.append({
                "question": current_question,
                "answers": current_answers,
                "correctAnswer": line[0]  # Use first letter
            })
            current_question = None
            current_answers = []
            i += 1
            continue
        
        # Otherwise, this is a question line
        # If we already have a question and answers, save it first
        if current_question and len(current_answers) >= 2:
            # Look ahead to see if next line is an answer
            if i + 1 < len(lines) and re.match(r'^[A-D]\.?\s+', lines[i + 1].strip()):
                # Start new question
                questions.append({
                    "question": current_question,
                    "answers": current_answers,
                    "correctAnswer": "A"  # Default if not specified
                })
                current_question = line
                current_answers = []
            else:
                # Continue current question (multi-line)
                current_question += " " + line
        else:
            # Start new question
            if current_answers:  # Save previous if exists
                questions.append({
                    "question": current_question if current_question else "Unknown question",
                    "answers": current_answers,
                    "correctAnswer": "A"
                })
                current_answers = []
            current_question = line
        
        i += 1
    
    # Save last question if exists
    if current_question and len(current_answers) >= 2:
        questions.append({
            "question": current_question,
            "answers": current_answers,
            "correctAnswer": "A"
        })
    
    # Write to JSON file
    with open(output_json_path, 'w', encoding='utf-8') as f:
        json.dump(questions, f, ensure_ascii=False, indent=2)
    
    print(f"✅ Đã parse thành công {len(questions)} câu hỏi!")
    print(f"📁 File JSON: {output_json_path}")
    
    return questions

if __name__ == "__main__":
    # Sử dụng:
    # 1. Copy tất cả câu hỏi vào file "raw_questions.txt"
    # 2. Chạy script này
    # 3. File questions.json sẽ được tạo
    
    parse_questions_from_text(
        "raw_questions.txt",
        "src/main/resources/questions.json"
    )
