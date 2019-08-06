package cn.zyx.controller;

import cn.zyx.domain.Article;
import cn.zyx.domain.JsonData;
import cn.zyx.repository.ArticleRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("save")
    public Object save(){
        Article article = new Article();
        article.setId(2L);
        article.setPv(777);
        article.setContent("this is 内容");
        article.setTitle("Article测试");
        article.setSummary("概要搜索");

        Article save = articleRepository.save(article);

        return JsonData.buildSuccess(save);
    }

    @GetMapping("search")
    public Object search(String title){
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("title",title);

        Iterable<Article> iterable = articleRepository.search(queryBuilder);

        return JsonData.buildSuccess(iterable);
    }

}
