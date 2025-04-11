package com.zwp.kunpeng.judge.codesandbox;

import com.zwp.kunpeng.judge.codesandbox.model.ExecuteCodeRequest;
import com.zwp.kunpeng.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {

    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
