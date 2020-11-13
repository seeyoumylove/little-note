package top.whatimiss.littlenote.es.config;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author wcj
 * @create 2020/11/10  下午4:26
 * @description ES7.6.2的JavaApi
 */
@Component
@Slf4j
public class ElasticSearchDemo {

    @Autowired
    private RestHighLevelClient restHighLevelClient;


    private void search() {
        SearchRequest searchRequest = new SearchRequest("user");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        QueryBuilder queryBuilder = getNumberFuzzySearch();
        // 构建查询条件
        searchSourceBuilder.query(queryBuilder);
        // 只返回file_id字段
        searchSourceBuilder.fetchSource("file_id", null);
        // 排序
        searchSourceBuilder.sort("founderTime", SortOrder.DESC);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = null;
        try {
            search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SearchHits hits = search.getHits();
        System.out.println("搜索到:"+hits.getHits().length+"条数据");
    }

    /**
     * 不含中文的模糊查询
     * @return
     */
    private QueryBuilder getNumberFuzzySearch() {
        WildcardQueryBuilder wildcardQueryBuilder = QueryBuilders.wildcardQuery("name", "*杰*");
        return wildcardQueryBuilder;
    }

    /**
     * ES中文查询条件
     * @return
     */
    private QueryBuilder geChineseSearch() {
        /**
         * 此处使用模糊匹配查询 类比数据库中 like    name代表的是字段名，‘动态’代表的是匹配的关键字
         * QueryBuilder 适用于单个字段查询（matchPhraseQuery是没有用分词起，matchQuery会使用分词器，
         * 将我们输入的值进行分割，如：“java动态”会分割成：“java”,“动态”）
         *
         */
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        QueryBuilder queryBuilder = QueryBuilders.matchPhraseQuery("name", "杰");
        BoolQueryBuilder bqb1 = QueryBuilders.boolQuery().must(queryBuilder);
        boolQueryBuilder.must(bqb1);
        return boolQueryBuilder;
    }

    /**
     * 模糊查询 ?匹配单个字符，*匹配多个字符
     * @return
     */
    private QueryBuilder getWildcardQuery() {
        //搜索名字中含有jack文档（name中只要包含jack即可）
        WildcardQueryBuilder queryBuilder =QueryBuilders.wildcardQuery("name","*jack*");
        //搜索名字中含有_jack**的文档；如： wjacksss; ajackwww
//        WildcardQueryBuilder queryBuilder =QueryBuilders.wildcardQuery("name","?jack*");
        return queryBuilder;
    }

    /**
     * 复合模糊查询must(相当于Sql中的and)
     */
    private QueryBuilder getAndQuery() {
        //模糊查询
        WildcardQueryBuilder queryBuilder1 = QueryBuilders.wildcardQuery("name", "*jack*");
        //搜索名字中含有jack的文档
        WildcardQueryBuilder queryBuilder2 = QueryBuilders.wildcardQuery("interest", "*read*");
        //搜索interest中含有read的文档
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //name中必须含有jack,interest中必须含有read,相当于and
        boolQueryBuilder.must(queryBuilder1);
        boolQueryBuilder.must(queryBuilder2);
        return boolQueryBuilder;
    }

    /**
     * 模糊查询should(相当于Sql中的or)
     * @return
     */
    private QueryBuilder getOrQuery() {
        WildcardQueryBuilder queryBuilder1 = QueryBuilders.wildcardQuery("name", "*jack*");
        //搜索名字中含有jack的文档   如果是中文搜索，需要增加 keyword
//        WildcardQueryBuilder queryBuilder1 = QueryBuilders.wildcardQuery("name.keyword", "*jack*");
        WildcardQueryBuilder queryBuilder2 = QueryBuilders.wildcardQuery("interest", "*read*");
        //搜索interest中含有read的文档
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //name中含有jack或者interest含有read，相当于or
        boolQueryBuilder.should(queryBuilder1);
        boolQueryBuilder.should(queryBuilder2);
        return boolQueryBuilder;
    }

    /**
     * 多个字段匹配同一个值 精准匹配
     * @return
     */
    private QueryBuilder multiMatchQuery() {
        QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery("cyb","name", "interest");
        return queryBuilder;
    }



}
