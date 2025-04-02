package com.zwp.kunpeng.model.dto.user;

import java.io.Serializable;
import lombok.Data;

/**
 * 用户注册请求体
 *
 * @author <a href="https://github.com/zwp0363">zwp</a>
 * @from <a href="https://www.yuque.com/geqian-gtmrp/kskx4b">zwp知识库</a>
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;
}
