import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import util.HibernateConfig;

public class TestHibernate {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        System.out.println(sessionFactory != null
                ? "SessionFactory is configured correctly."
                : "SessionFactory not found.");

        HibernateTransactionManager txManager = context.getBean(HibernateTransactionManager.class);
        System.out.println(txManager != null
                ? "Transaction Manager is configured correctly."
                : "Transaction Manager not found.");
    }
}
