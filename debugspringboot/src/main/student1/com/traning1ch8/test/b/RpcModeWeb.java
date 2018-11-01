package com.traning1ch8.test.b;

import com.traning1ch8.test.b.assist.CreatePendingDocs;
import com.traning1ch8.test.b.assist.SL_QuestionBank;
import com.traning1ch8.test.b.service.ProduceDocService;
import com.traning1ch8.test.b.vo.SrcDocVo;
import com.xiangxue.ch8b.assist.Consts;

import java.util.List;
import java.util.concurrent.*;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/1 0001
 */
public class RpcModeWeb {
    //负责生成文档
    private static ExecutorService docMakeService
            = Executors.newFixedThreadPool(Consts.CPU_COUNT * 2);

    //负责上传文档
    private static ExecutorService docUploadService
            = new ThreadPoolExecutor(Consts.CPU_COUNT * 2, Consts.CPU_COUNT * 2, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    private static CompletionService<String> docCs
            = new ExecutorCompletionService<>(docMakeService);

    private static CompletionService<String> docUploadCs
            = new ExecutorCompletionService<>(docUploadService);


    private static class DockMarkTask implements Callable<String> {

        private SrcDocVo doc;

        public DockMarkTask(SrcDocVo srcDocVo) {
            this.doc = srcDocVo;
        }

        @Override
        public String call() throws Exception {
            long start = System.currentTimeMillis();
            String localName = ProduceDocService.makeDoc(doc);
            System.out.println("文档" + localName + "生成耗时："
                    + (System.currentTimeMillis() - start) + "ms");
            return localName;
        }
    }

    private static class DocUploadTask implements Callable<String> {

        private String localName;

        public DocUploadTask(String localName) {
            this.localName = localName;
        }

        @Override
        public String call() throws Exception {
            long start = System.currentTimeMillis();
            String remoteUrl = ProduceDocService.upLoadDoc(localName);
            System.out.println("已上传至[" + remoteUrl + "]耗时："
                    + (System.currentTimeMillis() - start) + "ms");
            return remoteUrl;
        }
    }

    public static void main(String[] args) {
        System.out.println("题库开始初始化...........");
        SL_QuestionBank.initBank();
        System.out.println("题库初始化完成。");

        //创建两个待处理文档
        List<SrcDocVo> docList = CreatePendingDocs.makePendingDoc(20);
        long startTotal = System.currentTimeMillis();
        for (SrcDocVo doc : docList) {
            docCs.submit(new DockMarkTask(doc));

        }
        for (SrcDocVo doc : docList) {
            try {
                String localName = docCs.take().get();
                docUploadCs.submit(new DocUploadTask(localName));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        //在实际的业务过程中可以不要，主要为了取得时间
        for (SrcDocVo doc : docList) {
            try {
                docUploadCs.take().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("------------共耗时："
                + (System.currentTimeMillis() - startTotal) + "ms-------------");
    }
}
