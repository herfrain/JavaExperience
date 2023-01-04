package java_stl;

import java.util.Scanner;
import java.util.regex.Pattern;

/*
 *
 * 正则表达式匹配
 * Pattern.matches(String regex,String input);（返回boolean）
 * 正则表达式规则
 * \\特殊字符 表示匹配该特殊字符
 */

public class RegexTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String regex = "";
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();//要匹配的字符串
        input = input.trim();//去掉前后的空格
        System.out.println(input.length() + "," + input);
        System.out.println(Pattern.matches(regex, input));
    }

}
