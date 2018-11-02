package com.traning1ch8.test.b.service.question;

import com.traning1ch8.test.b.assist.Consts;
import com.traning1ch8.test.b.assist.SL_QuestionBank;
import com.traning1ch8.test.b.vo.QuestionInCacheVo;
import com.traning1ch8.test.b.vo.QuestionInDBVo;
import com.traning1ch8.test.b.vo.TaskResultVo;

import java.util.concurrent.*;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/2 0002
 */
public class ParallQstService {

    //已处理题目的缓存
    private static ConcurrentHashMap<Integer, QuestionInCacheVo> questionCache
            = new ConcurrentHashMap<>();

    //正在处理题目的缓存
    private static ConcurrentHashMap<Integer, Future<QuestionInCacheVo>>
            processingQuestionCache = new ConcurrentHashMap<>();

    private static ExecutorService makeQuestionService
            = new ThreadPoolExecutor(Consts.CPU_COUNT * 2, Consts.CPU_COUNT * 2, 0l, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

    /**
     * 对题目进行处理
     *
     * @param questionId 题目id
     * @return 题目解析后的文本
     */
    public static TaskResultVo makeQuestion(Integer questionId) {
        QuestionInCacheVo qstCacheVo = questionCache.get(questionId);
        if (qstCacheVo == null) {
            System.out.println("......题目[" + questionId + "]在缓存中不存在，"
                    + "准备启动任务.");
            return new TaskResultVo(getQstFuture(questionId));
        } else {
            String sha = SL_QuestionBank.getSha(questionId);
            if (qstCacheVo.getQuestionSha().equals(sha)) {
                System.out.println("......题目[" + questionId + "]在缓存中已存在，且未变化.");
                return new TaskResultVo(qstCacheVo.getQuestionDetail());
            }
            System.out.println("......题目[" + questionId + "]在缓存中已存在，"
                    + "但是发生了变化，更新缓冲.");
            return new TaskResultVo(getQstFuture(questionId));
        }

//        return BaseQuestionProcessor.makeQuestion(questionId,
//                SL_QuestionBank.getQuetion(questionId).getDetail());
    }

    private static Future<QuestionInCacheVo> getQstFuture(Integer questionId) {
        Future<QuestionInCacheVo> questionFuture
                = processingQuestionCache.get(questionId);
        if (questionFuture == null) {
            QuestionInDBVo qstDbVo = SL_QuestionBank.getQuetion(questionId);
            QuestTask questTask = new QuestTask(qstDbVo, questionId);

            FutureTask<QuestionInCacheVo> ft
                    = new FutureTask<QuestionInCacheVo>(questTask);
            questionFuture = processingQuestionCache.putIfAbsent(questionId, ft);

            if (questionFuture == null) {
                //先在map中占位
                questionFuture = makeQuestionService.submit(questTask);
                processingQuestionCache.putIfAbsent(questionId, questionFuture);
                System.out.println("成功启动了题目[" + questionId + "]的计算任务，请等待完成>>>>>>>>");
            } else {
                System.out.println("<<<<<<<<<<<有其他线程刚刚启动了题目[" + questionId
                        + "]的计算任务，本任务无需开启！");
            }

        } else {
            System.out.println("题目[" + questionId + "]已存在计算任务，无需重新生成.");
        }

        return questionFuture;
    }

    private static class QuestTask implements Callable<QuestionInCacheVo> {
        private QuestionInDBVo qstDbVo;
        private Integer questionId;

        public QuestTask(QuestionInDBVo qstDbVo, Integer questionId) {
            super();
            this.qstDbVo = qstDbVo;
            this.questionId = questionId;
        }

        @Override
        public QuestionInCacheVo call() throws Exception {

            try {
                String s = BaseQuestionProcessor.makeQuestion(questionId,
                        SL_QuestionBank.getQuetion(questionId).getDetail());
                QuestionInCacheVo cacheVo = new QuestionInCacheVo(s, qstDbVo.getSha());

                questionCache.put(questionId, cacheVo);
                return cacheVo;
            } finally {

                processingQuestionCache.remove(questionId);
            }
        }
    }
}
