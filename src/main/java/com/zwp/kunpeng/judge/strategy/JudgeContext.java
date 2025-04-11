package com.zwp.kunpeng.judge.strategy;

import com.zwp.kunpeng.model.dto.question.JudgeCase;
import com.zwp.kunpeng.model.dto.questionsubmit.JudgeInfo;
import com.zwp.kunpeng.model.entity.Question;
import com.zwp.kunpeng.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文（用于定义在策略中传递的参数）
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;

}
