package com.cjl.spring.init;

import com.cjl.spring.annotation.MyAutowire;
import com.cjl.spring.annotation.MyComponent;
import com.cjl.spring.annotation.MyComponentScan;
import com.cjl.spring.annotation.MyScope;
import com.cjl.spring.cache.BeanDefinition;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName MyApplicationContext
 * @Description 初始化spring
 * @Author chen jingling
 * @Date 2020/10/22 16:15
 */
public class MyApplicationContext {

    private ConcurrentHashMap<String, BeanDefinition> beanDefinitationMap = new ConcurrentHashMap();
    private ConcurrentHashMap<String, Object> singletonBean = new ConcurrentHashMap();

    public MyApplicationContext(Class configClass){
        scan(configClass);
        createSingletonBean();
    }

    private void createSingletonBean(){
        for (String bean : beanDefinitationMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitationMap.get(bean);
            if ("Singleton".equals(beanDefinition.getScope())){
                Object newBean = createBean(bean, beanDefinition);
                //将单例实例放入到单例池中
                singletonBean.put(bean, newBean);
            }
        }
    }

    private Object createBean(String beanName, BeanDefinition beanDefinition){
        Class beanClass = beanDefinition.getBeanClass();
        try {
            //获取到默认构造器
            Constructor declaredConstructor = beanClass.getDeclaredConstructor();
            Object instance = declaredConstructor.newInstance();
            //属性填充
            Field[] fields = beanClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(MyAutowire.class)){
                    String fieldName = field.getName();
                    Object bean = myGetBean(fieldName);
                    field.setAccessible(true);
                    field.set(instance, bean);
                }
            }
            return instance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void scan(Class configClass){
         //获取到需要去扫描的包
        MyComponentScan myComponentScan = (MyComponentScan) configClass.getAnnotation(MyComponentScan.class);
        //获取到的结果 com.cjl.spring.service
        String path = myComponentScan.value();
        //得到包下面类的所有路径放入list中
        List<Class> classList = getBeanClazz(path);
        //遍历得到的价包下的所有类 并获取到类中的相关信息存入到缓存 beanDefinition
        for (Class clazz : classList) {
            //对类中是否存在MyComponent注解进行解析
            if (clazz.isAnnotationPresent(MyComponent.class)){
                //创建一个benaDefination对象用来存放类中需要的信息
                BeanDefinition beanDefinition = new BeanDefinition();
                beanDefinition.setBeanClass(clazz);
                MyComponent myComponent = (MyComponent) clazz.getAnnotation(MyComponent.class);
                String key = myComponent.value();
                if ("".equals(key)){
                    String simpleName = clazz.getSimpleName();
                    key = simpleName.substring(0, 1).toLowerCase().concat(simpleName.substring(1));
                    beanDefinition.setName(key);
                }
                //解析scope
                if (clazz.isAnnotationPresent(MyScope.class)){
                    MyScope myScope = (MyScope) clazz.getAnnotation(MyScope.class);
                    String scopeValue = myScope.value();
                    if ("prototype".equals(scopeValue)){
                        beanDefinition.setScope("prototype");
                    }else {
                        beanDefinition.setScope("Singleton");
                    }
                }else {
                    //默认只有Singleton与prototype，不考虑写错或者其他情况
                    beanDefinition.setScope("Singleton");
                }
                beanDefinitationMap.put(key, beanDefinition);
            }
        }
    }

    private List<Class> getBeanClazz(String packagePath){
        ArrayList<Class> clazzs = new ArrayList();
        //结果 com/cjl/spring/service
        packagePath = packagePath.replace(".", "/");
        ClassLoader classLoader = MyApplicationContext.class.getClassLoader();
        //结果 E:\IDEA\IdeaProjects\Demo\demo\com\cjl\spring\service
        URL resource = classLoader.getResource(packagePath);
        File file = new File(resource.getFile());
        for (File listFile : file.listFiles()) {
            //结果 E:\IDEA\IdeaProjects\Demo\demo\com\cjl\spring\service\UserService.class
            String absolutePath = listFile.getAbsolutePath();
            if (absolutePath.endsWith(".class")){
                //结果 com\cjl\spring\service\UserService
                String className = absolutePath.substring(absolutePath.indexOf("com"), absolutePath.indexOf(".class"));
                className = className.replace("\\", ".");

                try {
                    Class<?> aClass = classLoader.loadClass(className);
                    clazzs.add(aClass);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
        return clazzs;
    }

    public Object myGetBean(String beanName){
        if (singletonBean.containsKey(beanName)){
            return singletonBean.get(beanName);
        }else {
            //没有实例化bean的时候 例如懒加载或者原形
            BeanDefinition beanDefinition = beanDefinitationMap.get(beanName);
            return createBean(beanName, beanDefinition);
        }
    }

}
