package com.example.springbatch.codePattern.factoryPattern.util;

import com.example.springbatch.codePattern.factoryPattern.Human;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

public class ClassUtils {

    public static List<Class> getClass(String packageName) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("classLooader " +packageName );
        String path = packageName.replace(".","/");

        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while(resources.hasMoreElements()){
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }

        System.out.println(dirs.toString());

        ArrayList<Class> classes = new ArrayList<>();
        for(File directry:dirs){
            classes.addAll(findClass(directry,packageName));
        }
        return classes;
    }

    private static List<Class> findClass(File directory,String packageName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<Class> classes = new ArrayList<>();
        if(!directory.exists()){
            return classes;
        }

        File[] files = directory.listFiles();
        for(File file : files){
            if(file.isDirectory()){
                classes.addAll(findClass(file,packageName+"."+file.getName()));
            }else if(file.getName().endsWith(".class")){
                Class<?> fileClass = Class.forName(packageName+"."+file.getName()
                        .substring(0,file.getName().length()-6));

                if(fileClass.isInterface()){
                    System.out.println("is interface!");
                    continue;
                }
                Class<?>[] interClassArr = fileClass.getInterfaces();
                //Assert.notEmpty(interClassArr,"测试类接口不能为空");
                Arrays.stream(interClassArr).forEach(t -> {
                    if(t.getName().equals(Human.class.getName())){
                        try {
                            classes.add(Class.forName(packageName+"."+file.getName()
                                    .substring(0,file.getName().length()-6)));
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                });


            }
        }
        return classes;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class c = Human.class;
        String packageName = c.getPackage().getName();
        System.out.println(packageName);
        ArrayList<Class> classes = (ArrayList<Class>) getClass(packageName);
        System.out.println(classes);
    }
}
