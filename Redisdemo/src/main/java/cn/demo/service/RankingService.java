package cn.demo.service;

import cn.demo.mapper.UserMapper;
import cn.demo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RankingService {

    private static final String RANKNAME = "user_score";

    private static final String SALESCORE = "sale_score_rank:";

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private UserMapper userMapper;

   /* @Autowired
    private ScoreFlowMapper scoreFlowMapper;

    @Autowired
    private UserScoreMapper userScoreMapper;*/


    public void rankAdd(String uid, Integer score) {
        redisUtils.zAdd(RANKNAME, uid, score);
    }

    public void increSocre(String uid, Integer score) {

        redisUtils.incrementScore(RANKNAME, uid, score);
    }

    public Long rankNum(String uid) {
        return redisUtils.zRank(RANKNAME, uid);
    }

    public Long score(String uid) {
        Long score = redisUtils.zSetScore(RANKNAME, uid).longValue();
        return score;
    }

    public Set<ZSetOperations.TypedTuple<Object>> rankWithScore(Integer start, Integer end) {
        return redisUtils.zRankWithScore(RANKNAME, start, end);
    }


  /*  public void rankSaleAdd() {
        UserScoreExample example = new UserScoreExample();
        example.setOrderByClause("id desc");
        List<UserScore> userScores = userScoreMapper.selectByExample(example);
        userScores.forEach(userScore -> {
            String key = userScore.getUserId() + ":" + userScore.getName();
            redisUtils.zAdd(SALESCORE, key, userScore.getUserScore());
        });
    }


    *//**
     * 添加用户积分
     *
     * @param uid
     * @param score
     *//*
    public void increSaleSocre(String uid, Integer score) {
        User user = userMapper.find(uid);
        if (user == null) {
            return;
        }
        int uidInt = Integer.parseInt(uid);
        long socreLong = Long.parseLong(score + "");
        String name = user.getUserName();
        String key = uid + ":" + name;
        scoreFlowMapper.insertSelective(new ScoreFlow(socreLong, uidInt, name));
        userScoreMapper.insertSelective(new UserScore(uidInt, socreLong, name));
        redisUtils.incrementScore(SALESCORE, key, score);
    }


    public Map<String, Object> userRank(String uid, String name) {
        Map<String, Object> retMap = new LinkedHashMap<>();
        String key = uid + ":" + name;
        Integer rank = redisUtils.zRank(SALESCORE, key).intValue();
        Long score = redisUtils.zSetScore(SALESCORE, key).longValue();
        retMap.put("userId", uid);
        retMap.put("score", score);
        retMap.put("rank", rank);
        return retMap;
    }


    public List<Map<String, Object>> reverseZRankWithRank(long start, long end) {
        Set<ZSetOperations.TypedTuple<Object>> setObj = redisUtils.reverseZRankWithRank(SALESCORE, start, end);
        List<Map<String, Object>> mapList = setObj.stream().map(objectTypedTuple -> {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("userId", objectTypedTuple.getValue().toString().split(":")[0]);
            map.put("userName", objectTypedTuple.getValue().toString().split(":")[1]);
            map.put("score", objectTypedTuple.getScore());
            return map;
        }).collect(Collectors.toList());
        return mapList;
    }

    public List<Map<String, Object>> saleRankWithScore(Integer start, Integer end) {
        Set<ZSetOperations.TypedTuple<Object>> setObj = redisUtils.reverseZRankWithScore(SALESCORE, start, end);
        List<Map<String, Object>> mapList = setObj.stream().map(objectTypedTuple -> {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("userId", objectTypedTuple.getValue().toString().split(":")[0]);
            map.put("userName", objectTypedTuple.getValue().toString().split(":")[1]);
            map.put("score", objectTypedTuple.getScore());
            return map;
        }).collect(Collectors.toList());
        return mapList;
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        System.out.println("======enter run bean=======");
//        Thread.sleep(100000);
//        this.rankSaleAdd();
//    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("======enter init bean=======");
        this.rankSaleAdd();
    }*/

}
