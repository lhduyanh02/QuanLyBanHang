/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhang.control;

import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class CheckInputMethod {
    // Hàm kiểm tra ký tự đặc biệt
    private static boolean isSpecialCharacter(char c) {
        // Bạn có thể thêm hoặc bớt đi các ký tự đặc biệt tùy thuộc vào yêu cầu của bạn
        String specialCharacters = "!@#$%^&*()-_+=<>?";
        return specialCharacters.contains(String.valueOf(c));
    }

    //Kiểm tra có chứa ký tự đặc biệt
    public static boolean containsSpecialChars(String input) {
        // Biểu thức chính quy kiểm tra xem có ký tự đặc biệt không
        String regex = ".*[\\p{P}].*";
        return Pattern.matches(regex, input);
    }

    //Kiểm tra chứa khoảng trắng
    public static boolean containsWhitespace(String input) {
        // Biểu thức chính quy kiểm tra xem có khoảng trắng không
        String regex = ".*[\\s].*";
        return Pattern.matches(regex, input);
    }

    //Kiểm tra chứa tiếng Việt
    public static boolean containsVietnamese(String input) {
        // Biểu thức chính quy kiểm tra xem có ký tự tiếng Việt không
        String regex = ".*[àáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ].*";

        // Sử dụng phương thức matches() để kiểm tra
        return Pattern.matches(regex, input);
    }
}
