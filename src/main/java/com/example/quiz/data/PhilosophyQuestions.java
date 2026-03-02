package com.example.quiz.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Lớp chứa dữ liệu câu hỏi Triết học Mác-Lênin
 */
public class PhilosophyQuestions {
    
    public static List<QuestionItem> getAllQuestions() {
        List<QuestionItem> questions = new ArrayList<>();
        
        // Phần 1: Câu hỏi về chủ nghĩa Mác-Lênin
        addMarxismQuestions(questions);
        
        // Phần 2: Câu hỏi về phương pháp biện chứng
        addDialecticQuestions(questions);
        
        // Phần 3: Câu hỏi về lực lượng sản xuất và quan hệ sản xuất
        addProductionQuestions(questions);
        
        // Phần 4: Câu hỏi về ý thức xã hội
        addConsciousnessQuestions(questions);
        
        // Phần 5: Câu hỏi về giai cấp và nhà nước
        addStateQuestions(questions);
        
        return questions;
    }
    
    private static void addMarxismQuestions(List<QuestionItem> questions) {
        questions.add(new QuestionItem(
            "Xanh-ximông là đại biểu của trường phái nào?",
            Arrays.asList(
                "Chủ nghĩa xã hội không tưởng Pháp",
                "Chủ nghĩa xã hội không tưởng Đức",
                "Triết học cổ điển Đức",
                "Kinh tế chính trị học Anh"
            ),
            0
        ));
        
        questions.add(new QuestionItem(
            "Thales, Heraclitus, Anaximenes là những đại biểu thuộc trường phái nào?",
            Arrays.asList(
                "Chủ nghĩa duy tâm chủ quan",
                "Chủ nghĩa duy vật chất phác",
                "Chủ nghĩa duy tâm khách quan",
                "Chủ nghĩa duy vật biện chứng trước Mác"
            ),
            1
        ));
        
        questions.add(new QuestionItem(
            "Triết học Mác-Lênin ra đời một phần là kết quả kế thừa trực tiếp từ",
            Arrays.asList(
                "Thế giới quan duy vật của Hêghen và phép biện chứng của Phoiobắc",
                "Thế giới quan duy vật của Phơ bách và phép biện chứng của Hêghen",
                "Thế giới quan duy vật và phép biện chứng của cả Hêghen và Phơ bách",
                "Chủ nghĩa duy tâm của Hồn bách và biện chứng pháp của Aristốt"
            ),
            1
        ));
        
        questions.add(new QuestionItem(
            "Chủ nghĩa Mác-Lênin gồm mấy bộ phận cấu thành?",
            Arrays.asList(
                "Triết học, Kinh tế chính trị học và Chủ nghĩa xã hội khoa học",
                "Triết học, Kinh tế chính trị học và Chính trị học",
                "Triết học, Kinh tế học và Chủ nghĩa xã hội khoa học",
                "Ba bộ phận khác"
            ),
            0
        ));
        
        questions.add(new QuestionItem(
            "Trong chủ nghĩa Mác - Lênin thì bộ phận nào là cơ sở nền tảng?",
            Arrays.asList(
                "Triết học là cơ sở nền tảng của kinh tế chính trị và chủ nghĩa xã hội khoa học",
                "Kinh tế chính trị học là cơ sở nền tảng của triết học và chủ nghĩa xã hội khoa học",
                "Chủ nghĩa xã hội khoa học là cơ sở của kinh tế chính trị và triết học",
                "Cả ba đều là cơ sở"
            ),
            0
        ));
        
        questions.add(new QuestionItem(
            "Triết học Mác là thế giới quan khoa học của giai cấp nào?",
            Arrays.asList(
                "Giai cấp tư sản tiến bộ",
                "Giai cấp công nhân",
                "Tầng lớp trí thức",
                "Giai cấp lao động"
            ),
            1
        ));
        
        questions.add(new QuestionItem(
            "Đâu là nguồn gốc lý luận của chủ nghĩa Mác?",
            Arrays.asList(
                "Tư tưởng xã hội phương Đông cổ đại",
                "Triết học cổ điển Đức, kinh tế chính trị cổ điển Anh và chủ nghĩa xã hội không tưởng Pháp",
                "Chủ nghĩa duy vật siêu hình thế kỷ XVII - XVIII ở Tây Âu",
                "Học thuyết tiến hóa"
            ),
            1
        ));
        
        questions.add(new QuestionItem(
            "Chủ nghĩa Mác-Lênin ra đời dựa trên bao nhiêu tiền đề?",
            Arrays.asList(
                "Ba tiền đề",
                "Bốn tiền đề",
                "Năm tiền đề",
                "Sáu tiền đề"
            ),
            0
        ));
    }
    
    private static void addDialecticQuestions(List<QuestionItem> questions) {
        questions.add(new QuestionItem(
            "Quan hệ giữa người với người trong quá trình sản xuất được gọi là gì?",
            Arrays.asList(
                "Quan hệ xã hội",
                "Quan hệ tổ chức quản lý",
                "Quan hệ sản xuất",
                "Quan hệ điều tiết"
            ),
            2
        ));
        
        questions.add(new QuestionItem(
            "Nhận thức cảm tính được thực hiện dưới những hình thức nào?",
            Arrays.asList(
                "Tri giác, phán đoán và suy luận",
                "Cảm giác, tri giác và khái niệm",
                "Cảm giác, tri giác và biểu tượng",
                "Khái niệm và phán đoán"
            ),
            2
        ));
        
        questions.add(new QuestionItem(
            "Đứng im, cân bằng chỉ xảy ra trong một số quan hệ nhất định chứ không phải trong mọi quan hệ là?",
            Arrays.asList(
                "Thực tế",
                "Tuyệt đối",
                "Tương đối",
                "Thường xuyên"
            ),
            2
        ));
        
        questions.add(new QuestionItem(
            "Theo quan điểm của phép biện chứng duy vật, quy luật nào vạch ra nguồn gốc của sự phát triển?",
            Arrays.asList(
                "Quy luật thống nhất và đấu tranh của các mặt đối lập",
                "Quy luật về chuyển hóa từ lượng đến chất và ngược lại",
                "Quy luật phủ định của phủ định",
                "Quy luật về sự phù hợp của QHSX và trình độ LLSX"
            ),
            0
        ));
        
        questions.add(new QuestionItem(
            "Theo quan điểm của phép biện chứng duy vật, quy luật nào vạch ra cách thức của sự phát triển?",
            Arrays.asList(
                "Quy luật thống nhất và đấu tranh của các mặt đối lập",
                "Quy luật lượng - chất",
                "Quy luật phủ định của phủ định",
                "Quy luật về sự phù hợp của QHSX và trình độ LLSX"
            ),
            1
        ));
        
        questions.add(new QuestionItem(
            "Theo quan điểm của phép biện chứng duy vật, quy luật nào vạch ra khuynh hướng của sự phát triển?",
            Arrays.asList(
                "Quy luật thống nhất và đấu tranh của các mặt đối lập",
                "Quy luật lượng - chất",
                "Quy luật phủ định của phủ định",
                "Quy luật về sự phù hợp của QHSX và trình độ LLSX"
            ),
            2
        ));
        
        questions.add(new QuestionItem(
            "Phủ định biện chứng có đặc trưng cơ bản nào?",
            Arrays.asList(
                "Tính khách quan và tính mâu thuẫn",
                "Tính mâu thuẫn và tính kế thừa",
                "Tất cả các đáp án đều sai",
                "Tính khách quan và tính kế thừa"
            ),
            3
        ));
    }
    
    private static void addProductionQuestions(List<QuestionItem> questions) {
        questions.add(new QuestionItem(
            "Trong lực lượng sản xuất, đâu là yếu tố động nhất, cách mạng nhất?",
            Arrays.asList(
                "Công cụ lao động",
                "Bộ óc con người",
                "Con người lao động",
                "Tư liệu sản xuất"
            ),
            0
        ));
        
        questions.add(new QuestionItem(
            "Yếu tố chủ thể của lực lượng sản xuất là?",
            Arrays.asList(
                "Con người với kỹ năng, kỹ xảo và tri thức được tích lũy lại",
                "Tư liệu sản xuất hiện đại",
                "Khoa học công nghệ tiên tiến",
                "Các phương án trả lời đều đúng"
            ),
            0
        ));
        
        questions.add(new QuestionItem(
            "Khi quan hệ sản xuất được xem là phù hợp với tính chất và trình độ phát triển của lực lượng sản xuất?",
            Arrays.asList(
                "Thúc đẩy lực lượng sản xuất phát triển",
                "Cải thiện đời sống nhân dân",
                "Tạo điều kiện thực hiện công bằng xã hội",
                "Tất cả đều đúng"
            ),
            0
        ));
        
        questions.add(new QuestionItem(
            "Lực lượng sản xuất được hiểu là khái niệm dùng để chỉ?",
            Arrays.asList(
                "Quan hệ giữa con người với tự nhiên trong quá trình sản xuất",
                "Quan hệ giữa người với xã hội trong quá trình sản xuất",
                "Quan hệ giữa người với người trong quá trình sản xuất",
                "Quan hệ giữa những người lao động trong quá trình tác động vào giới tự nhiên"
            ),
            0
        ));
        
        questions.add(new QuestionItem(
            "Quan hệ sản xuất là phạm trù dùng để chỉ?",
            Arrays.asList(
                "Quan hệ giữa con người sản xuất với người tiêu dùng trong quá trình sản xuất",
                "Quan hệ giữa người với người trong quá trình sản xuất",
                "Quan hệ giữa con người với tự nhiên trong quá trình sản xuất",
                "Quan hệ giữa sản xuất với tiêu dùng"
            ),
            1
        ));
        
        questions.add(new QuestionItem(
            "Phương thức sản xuất bao gồm?",
            Arrays.asList(
                "Lực lượng sản xuất và quan hệ sản xuất",
                "Lực lượng sản xuất, quan hệ sản xuất, cơ sở hạ tầng",
                "Lực lượng sản xuất, quan hệ sản xuất, cơ sở hạ tầng, kiến trúc thượng tầng",
                "Công cụ lao động và đối tượng lao động"
            ),
            0
        ));
    }
    
    private static void addConsciousnessQuestions(List<QuestionItem> questions) {
        questions.add(new QuestionItem(
            "Tri thức nào sau đây nảy sinh một cách trực tiếp từ thực tiễn lao động sản xuất?",
            Arrays.asList(
                "Tri thức kinh nghiệm",
                "Tri thức lý luận",
                "Tri thức lý luận khoa học",
                "Tri thức lý luận thực tiễn"
            ),
            0
        ));
        
        questions.add(new QuestionItem(
            "Theo V.I.Lênin, quan điểm về đời sống, về thực tiễn phải là gì của lý luận nhận thức?",
            Arrays.asList(
                "Điểm thứ nhất",
                "Quan điểm đầu tiên",
                "Quan điểm thứ nhất và cơ bản",
                "Điều quan trọng"
            ),
            2
        ));
        
        questions.add(new QuestionItem(
            "Công lao của C.Mác và Ph.Ăngghen với nhận thức là gì?",
            Arrays.asList(
                "Phát hiện ra thế giới khách quan",
                "Đưa phương pháp luận vào nhận thức",
                "Đưa thực tiễn vào triết học",
                "Đề ra tư tưởng đấu tranh chống lại giai cấp tư sản"
            ),
            1
        ));
        
        questions.add(new QuestionItem(
            "Ý thức được gọi là hình ảnh chủ quan của?",
            Arrays.asList(
                "Hiện thực khách quan",
                "Thế giới khách quan",
                "Thế giới chủ quan",
                "Thế giới vật chất"
            ),
            1
        ));
        
        questions.add(new QuestionItem(
            "Chân lý là gì?",
            Arrays.asList(
                "Ý kiến của những người có kinh nghiệm",
                "Sự phù hợp giữa tri thức với hiện thực khách quan và được thực tiễn kiểm nghiệm",
                "Những quan điểm thuộc về đa số",
                "Là những thứ đúng đắn trong khoa học"
            ),
            1
        ));
        
        questions.add(new QuestionItem(
            "Thuyết có thể biết còn gọi là gì?",
            Arrays.asList(
                "Thuyết nhận biết",
                "Thuyết khả tri",
                "Thuyết khả tri luận",
                "Thuyết nhận biết luận"
            ),
            2
        ));
        
        questions.add(new QuestionItem(
            "Thuyết bất khả tri còn gọi là gì?",
            Arrays.asList(
                "Thuyết không thể biết",
                "Thuyết khả tri",
                "Thuyết khả tri luận",
                "Thuyết nhận biết luận"
            ),
            0
        ));
    }
    
    private static void addStateQuestions(List<QuestionItem> questions) {
        questions.add(new QuestionItem(
            "Sự khác biệt cơ bản nhất giữa các giai cấp là địa vị của họ trong?",
            Arrays.asList(
                "Quyền lực chính trị",
                "Quyền lực nhà nước",
                "Quyền lực quản lý kinh tế",
                "Quyền lực sở hữu tư liệu sản xuất"
            ),
            3
        ));
        
        questions.add(new QuestionItem(
            "Theo quan điểm duy vật lịch sử, sự ra đời của nhà nước là để giải quyết các mâu thuẫn trong xã hội vì?",
            Arrays.asList(
                "Xã hội có mâu thuẫn thì cần phải có lực lượng đại diện cho xã hội để giải quyết nó",
                "Kinh nghiệm thực tế cho thấy đúng như vậy",
                "Mâu thuẫn đã phát triển đến chỗ không thể giải quyết được nên cần đến sự ra đời của nhà nước",
                "Tất yếu của lịch sử nhân loại"
            ),
            2
        ));
        
        questions.add(new QuestionItem(
            "Ai là người đã đưa ra định nghĩa về giai cấp?",
            Arrays.asList(
                "Heraclit",
                "Khổng Tử",
                "V.I.Lênin",
                "Chủ tịch Hồ Chí Minh"
            ),
            2
        ));
        
        questions.add(new QuestionItem(
            "Hạt nhân cơ bản trong quần chúng nhân dân là ai?",
            Arrays.asList(
                "Những người lao động sản xuất ra của cải vật chất",
                "Những bộ phận dân cư chống lại giai cấp thống trị áp bức bóc lột",
                "Những tầng lớp xã hội khác nhau thúc đẩy sự tiến bộ của xã hội",
                "Những tầng lớp dân cư lao động"
            ),
            0
        ));
        
        questions.add(new QuestionItem(
            "Bản chất của nhà nước là?",
            Arrays.asList(
                "Cơ quan phúc lợi chung của toàn xã hội",
                "Cơ quan trọng tài thực hiện chức năng phân xử và hòa giải các xung đột xã hội",
                "Công cụ của giai cấp thống trị xã hội",
                "Tất cả đều đúng"
            ),
            2
        ));
        
        questions.add(new QuestionItem(
            "Chủ nghĩa duy vật lịch sử cho rằng, giai cấp nào nắm được tư liệu sản xuất chủ yếu thì chiếm được địa vị chính trị?",
            Arrays.asList(
                "Tư liệu sản xuất chủ yếu",
                "Quan hệ sản xuất thống trị",
                "Lực lượng sản xuất",
                "Lực lượng sản xuất mới"
            ),
            0
        ));
    }
    
    // Inner class để lưu trữ dữ liệu câu hỏi
    public static class QuestionItem {
        public String question;
        public List<String> answers;
        public int correctIndex;
        
        public QuestionItem(String question, List<String> answers, int correctIndex) {
            this.question = question;
            this.answers = answers;
            this.correctIndex = correctIndex;
        }
    }
}
