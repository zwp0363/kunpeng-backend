package com.zwp.kunpeng.judge.codesandbox;

import com.zwp.kunpeng.MainApplication;
import com.zwp.kunpeng.judge.codesandbox.impl.ExampleCodeSandbox;
import com.zwp.kunpeng.judge.codesandbox.model.ExecuteCodeRequest;
import com.zwp.kunpeng.judge.codesandbox.model.ExecuteCodeResponse;
import com.zwp.kunpeng.model.enums.QuestionSubmitLanguageEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


@SpringBootTest
class CodeSandboxTest {

    @Value("${codesandbox.type:example}")
    private String type;

    @Test
    void executeCode() {
        CodeSandbox codeSandBox = new ExampleCodeSandbox();
        String code = "int main() { }";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }

    @Test
    void executeCodeByValue() {
        CodeSandbox codeSandBox = CodeSandboxFactory.newInstance(type);
        String code = "int main() { }";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }

    @Test
    void executeCodeByProxy() {
        CodeSandbox codeSandBox = CodeSandboxFactory.newInstance(type);
        codeSandBox = new CodeSandboxProxy(codeSandBox);
        String code = "public class Main {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        int a = Integer.parseInt(args[0]);\n" +
                "        int b = Integer.parseInt(args[1]);\n" +
                "        System.out.println(\"结果:\" + (a + b));\n" +
                "    }\n" +
                "}\n";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 使用 Scanner 类从标准输入读取数据
        while (scanner.hasNext()) { // 当有输入时，进入一个循环。
            String type = scanner.next(); // 从输入中读取一个字符串 type，这个字符串表示沙箱类型。
            CodeSandbox codeSandBox = CodeSandboxFactory.newInstance(type);
            String code = "int main() { }";
            String language = QuestionSubmitLanguageEnum.JAVA.getValue();
            List<String> inputList = Arrays.asList("1 2", "3 4");
            ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                    .code(code)
                    .language(language)
                    .inputList(inputList)
                    .build();
            ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        }
    }
}