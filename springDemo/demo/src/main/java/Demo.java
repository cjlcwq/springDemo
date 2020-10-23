import com.cjl.AppConfig;
import com.cjl.spring.init.MyApplicationContext;
import com.cjl.spring.service.OrderService;
import com.cjl.spring.service.UserService;

public class Demo {

    public static void main(String[] args) throws Exception{

        MyApplicationContext myApplicationContext = new MyApplicationContext(AppConfig.class);
        OrderService bean = (OrderService) myApplicationContext.myGetBean("orderService");
        bean.getOrder();
        System.out.println(myApplicationContext.myGetBean("lazyService"));
        System.out.println(myApplicationContext.myGetBean("lazyService"));
        System.out.println(myApplicationContext.myGetBean("lazyService"));
    }

}
