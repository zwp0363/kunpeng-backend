package com.zwp.kunpeng.judge;

import com.zwp.kunpeng.judge.strategy.DefaultJudgeStrategy;
import com.zwp.kunpeng.judge.strategy.JavaLanguageJudgeStrategy;
import com.zwp.kunpeng.judge.strategy.JudgeContext;
import com.zwp.kunpeng.judge.strategy.JudgeStrategy;
import com.zwp.kunpeng.judge.codesandbox.model.JudgeInfo;
import com.zwp.kunpeng.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
