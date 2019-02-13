package task1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MetaDataPrinter {

    void print(Object o){
        Class<?> info = o.getClass();

        for (Method method : info.getDeclaredMethods()){
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(method.getParameterTypes());
        }
        System.out.println();
        for (Field field : info.getDeclaredFields()){
            System.out.println(field.getName());
            System.out.println(field.getType());
        }
        System.out.println();
        for (Annotation ann : info.getDeclaredAnnotations()){
            System.out.println(ann.annotationType());
        }
    }
}
