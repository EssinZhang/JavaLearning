package cn.zyx.repository;

import cn.zyx.domain.Article;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
//@Document(indexName = "blog",type = "article",shards = 1,replicas = 0)
public interface ArticleRepository extends ElasticsearchRepository <Article,Long> {
}
