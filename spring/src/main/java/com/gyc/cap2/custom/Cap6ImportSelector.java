package com.gyc.cap2.custom;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/5 0005
 */
public class Cap6ImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("ImportSelector选择导入：" + importingClassMetadata.getClassName());
        return new String[]{"com.gyc.cap2.bean.cap6.Pig"};
    }
}
