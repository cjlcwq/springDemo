package com.cjl.csdn;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectTest
 * @Description 使用反射的方式来获取传入的类的一些信息
 * @Author chen jingling
 * @Date 2020/10/20 10:31
 */
public class ReflectTest {
    public Object copy(Object object) throws Exception {
        //获取对象的类型
        Class classType = object.getClass();
        System.out.println("对象的类型：" + classType.getName());
        //通过默认构造方法创建一个新的对象
        Object objectCopy = classType.getConstructor(new Class[]{}).newInstance(new Object[]{});
        //获取对象中的所有属性
        Field[] fields = classType.getDeclaredFields();
        for (Field field : fields) {
            //遍历获取到对象中各个属性
            String fieldName = field.getName();
            //将属性的第一个字母转换为大写
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            //获取和属性对应的get方法的名字
            String getMethodName = "get" + firstLetter + fieldName.substring(1);
            //获取和属性对应的set方法的名字
            String setMethodName = "set" + firstLetter + fieldName.substring(1);
            //获取到跟属性对应的get方法
            Method getMethod = classType.getMethod(getMethodName, new Class[]{});
            //获取到跟属性对应的set方法
            Method setMethod = classType.getMethod(setMethodName, new Class[]{field.getType()});
            //调用原对象的get方法
            Object value = getMethod.invoke(object, new Object[]{});
            System.out.println("参数" + fieldName + "的get方法值为：" + value);
            //调用copy对象的set方法
            setMethod.invoke(objectCopy, new Object[]{value});
        }
        return objectCopy;
    }
}
