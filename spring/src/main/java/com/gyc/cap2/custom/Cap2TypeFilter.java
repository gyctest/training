package com.gyc.cap2.custom;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/5 0005
 */
public class Cap2TypeFilter implements TypeFilter {

    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        System.out.println("自定义过滤:"+annotationMetadata.getClassName());
        return true;
    }
}
