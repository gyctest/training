package com.traning1ch8.test.b.vo;

/**
 * 描述:题目在缓存中的实体
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/1 0001
 */
public class QuestionInCacheVo {

    private final String questionDetail;
    private final String questionSha;

    public QuestionInCacheVo(String questionDetail, String questionSha) {
        super();
        this.questionDetail = questionDetail;
        this.questionSha = questionSha;
    }

    public String getQuestionDetail() {
        return questionDetail;
    }

    public String getQuestionSha() {
        return questionSha;
    }


}
