package org.sifrproject.annotations.api.input;

import org.json.simple.parser.ParseException;
import org.sifrproject.annotations.api.model.Annotation;

import java.util.List;

public interface AnnotationParser {
    void parseAnnotations(String queryResponse) throws ParseException;

    List<Annotation> annotations();

    void clear();
}