package com.zwp.kunpeng.judge.codesandbox.impl;

import com.zwp.kunpeng.judge.codesandbox.CodeSandbox;
import com.zwp.kunpeng.judge.codesandbox.model.ExecuteCodeRequest;
import com.zwp.kunpeng.judge.codesandbox.model.ExecuteCodeResponse;
import com.zwp.kunpeng.model.dto.questionsubmit.JudgeInfo;
import com.zwp.kunpeng.model.enums.JudgeInfoMessageEnum;
import com.zwp.kunpeng.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * 示例代码沙箱（仅为了跑通业务流程）
 */
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getValue());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
