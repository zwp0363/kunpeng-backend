package com.zwp.kunpeng.esdao;

import com.zwp.kunpeng.model.dto.post.PostEsDTO;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 帖子 ES 操作
 *
 * @author <a href="https://github.com/zwp0363">zwp</a>
 * @from <a href="https://www.yuque.com/geqian-gtmrp/kskx4b">zwp知识库</a>
 */
public interface PostEsDao extends ElasticsearchRepository<PostEsDTO, Long> {

    List<PostEsDTO> findByUserId(Long userId);
}