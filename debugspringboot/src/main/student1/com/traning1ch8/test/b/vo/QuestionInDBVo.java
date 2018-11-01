package com.traning1ch8.test.b.vo;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/1 0001
 */
public class QuestionInDBVo {

    /**
     * 题目id
     */
    private final int id;
    /**
     * 题目内容
     */
    private final String detail;

    private final String sha;

    public QuestionInDBVo(int id, String detail, String sha) {
        this.id = id;
        this.detail = detail;
        this.sha = sha;
    }

    public int getId() {
        return id;
    }

    public String getDetail() {
        return detail;
    }

    public String getSha() {
        return sha;
    }
}
