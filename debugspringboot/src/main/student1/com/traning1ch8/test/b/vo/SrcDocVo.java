package com.traning1ch8.test.b.vo;

import java.util.List;

/**
 * 描述:待处理文档实体类
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/1 0001
 */
public class SrcDocVo {
    //待处理文档名称
    private final String docName;
    //待处理文档中题目id列表
    private final List<Integer> questionList;


    public SrcDocVo(String docName, List<Integer> questionList) {
        this.docName = docName;
        this.questionList = questionList;
    }

    public String getDocName() {
        return docName;
    }

    public List<Integer> getQuestionList() {
        return questionList;
    }
}
