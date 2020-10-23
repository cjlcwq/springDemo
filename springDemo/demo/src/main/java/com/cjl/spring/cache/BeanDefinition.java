package com.cjl.spring.cache;

/**
 * @ClassName BeanDefinition
 * @Description TODO
 * @Author chen jingling
 * @Date 2020/10/22 21:24
 */
public class BeanDefinition {

    private Class BeanClass;

    private Boolean isLazy;

    private String scope;

    private String name;

    public Class getBeanClass() {
        return BeanClass;
    }

    public void setBeanClass(Class beanClass) {
        BeanClass = beanClass;
    }

    public Boolean getLazy() {
        return isLazy;
    }

    public void setLazy(Boolean lazy) {
        isLazy = lazy;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
