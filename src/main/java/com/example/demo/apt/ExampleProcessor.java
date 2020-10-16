package com.example.demo.apt;

import com.google.auto.service.AutoService;
import com.google.common.collect.ImmutableSet;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import java.io.IOException;
import java.util.Set;

@AutoService(Processor.class)
public class ExampleProcessor extends AbstractProcessor {

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        System.out.println("========== getSupportedAnnotationTypes ===============");
        return ImmutableSet.of(ExampleGetter.class.getCanonicalName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        final Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(ExampleGetter.class);

        for (Element element : elements) {
//            element.
            try {
                generateJavFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("============= process ======================");
        return true;
    }

    private void generateJavFile() throws IOException {
        TypeSpec.Builder example = TypeSpec.classBuilder("Example");
        example.addModifiers(Modifier.PUBLIC, Modifier.FINAL);
        MethodSpec methodSpec = MethodSpec
                            .methodBuilder("test")
                            .addModifiers(Modifier.FINAL, Modifier.PUBLIC)
                            .returns(TypeName.VOID)
                            .build();

        example.addMethod(methodSpec);

        JavaFile.builder("com.example.demo.apt", example.build())
                    .build()
                    .writeTo(processingEnv.getFiler());
    }
}
