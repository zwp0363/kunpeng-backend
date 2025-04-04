package com.zwp.kunpeng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwp.kunpeng.model.entity.Question;
import com.zwp.kunpeng.service.QuestionService;
import com.zwp.kunpeng.mapper.QuestionMapper;
import org.springframework.stereotype.Service;

/**
* @author zwp
* @description 针对表【question(题目)】的数据库操作Service实现
* @createDate 2025-04-03 21:54:13
*/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
    implements QuestionService{

}




