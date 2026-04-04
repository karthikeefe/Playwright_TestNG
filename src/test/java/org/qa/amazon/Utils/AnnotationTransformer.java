package org.qa.amazon.Utils;

public class AnnotationTransformer implements org.testng.IAnnotationTransformer {

    @Override
    public void transform(org.testng.annotations.ITestAnnotation annotation, Class testClass, java.lang.reflect.Constructor testConstructor, java.lang.reflect.Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
