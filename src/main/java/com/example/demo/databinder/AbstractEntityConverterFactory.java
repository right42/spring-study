package com.example.demo.databinder;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

@Component
public class AbstractEntityConverterFactory implements ConverterFactory<String, AbstractEntity> {

    @Override
    public <T extends AbstractEntity> Converter<String, T> getConverter(Class<T> targetClass) {
        return new StringToAbstractEntityConverter<>(targetClass);
    }

    @RequiredArgsConstructor
    private static class StringToAbstractEntityConverter<T extends AbstractEntity> implements Converter<String, T> {

        private final Class<T> targetClass;

        @Override
        public T convert(String source) {
            if(this.targetClass == Bar.class) {
                return (T) new Bar(source);
            } else if (this.targetClass == Foo.class) {
                return (T) new Foo(source);
            } else {
                return null;
            }
        }
    }
}
