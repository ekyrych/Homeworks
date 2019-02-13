package task1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Shop {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Article article = new Article("Java","book about java","McGrahw");
        //task1-2
        Class<? extends Article> clazz = article.getClass();
        for (Field field: clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(PrintAnnotation.class)){
                System.out.println(field.getName());
                System.out.println(field.getAnnotation(PrintAnnotation.class).value());
            }
        }
        //task 3-4,6
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().equals("getFullDescription")){
                try {
                   Object result = method.invoke(article , " this is " );
                    System.out.println(result);
                    System.out.println(method.getReturnType());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            if (method.getName().equals("checkAuthor")){
                try {
                    Object result = method.invoke(article , "McGrahw" );
                    System.out.println(result);
                    System.out.println(method.getReturnType());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            if (method.getName().equals("addMorePages")){
                try {
                    Object result = method.invoke(article , 12 );
                    System.out.println(result);
                    System.out.println(method.getReturnType());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }
        //task 5
        Field pages = clazz.getDeclaredField("pages");
        if(pages.getType().equals(int.class)){
            pages.setAccessible(true);
            pages.setInt(article , 45);
            System.out.println(article.getPages());
        }


        //task 7
        MetaDataPrinter printer = new MetaDataPrinter();
        printer.print(article);
    }


}
