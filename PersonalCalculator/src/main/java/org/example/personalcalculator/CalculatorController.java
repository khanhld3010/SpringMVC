package org.example.personalcalculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CalculatorController {
    @GetMapping("/Calculator")
    public String showCalculatorForm() {
        return "calculator-form";
    }

    public String calculate(@RequestParam("num1") double num1,
                            @RequestParam("num2") double num2,
                            @RequestParam("operator") String operator,
                            RedirectAttributes flash) {

        // 1. Kiểm tra lỗi chia cho 0 đầu tiên
        if (operator.equals("/") && num2 == 0) {
            flash.addFlashAttribute("error", "Lỗi: Không thể chia cho 0!");
            return "redirect:/Calculator"; // Sửa lại URL cho đúng
        }

        // 2. Dùng Switch-case để code sạch và chạy nhanh hơn
        double result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                flash.addFlashAttribute("error", "Phép tính không hợp lệ!");
                return "redirect:/Calculator";
        }

        // 3. Nạp kết quả và Redirect về đúng đường dẫn GET
        flash.addFlashAttribute("result", result);
        return "redirect:/Calculator";
    }
}
