import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Hibernate {

    public Session HibernateOperations() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        //Course course = session.get(Course.class, 1);
        //Получаем данные с таблицы courses
//        System.out.println("Название курса: " + course.getName() + " количество студентов: " + course.getStudentsCount());

        //Получаем данные с таблицы teachers через связь cources
//        System.out.println(course.getTeacher().getName());

        //с таблицы students join cources через subscription получаем студентов
//        System.out.println(course.getStudents().size());
//        List<Student> studentList = course.getStudents();
//        for (Student student : studentList) {
//            System.out.println(student.getName());
//        }
        //Получаем студента с таблицы students
//        Student student = session.get(Student.class, 1);
//        System.out.println(student.getName());

        //Получаем учителя с таблицы teachers
//          Teacher teacher = session.get(Teacher.class, 1);
//          System.out.println(teacher.getName());


        //Subscription subscription = session.get(Subscription.class, new Subscription.Key());
        String hql = "From " + Subscription.class.getSimpleName();
        List<Subscription> data = session.createQuery(hql).list();

//        System.out.println("users.size = " + data.size());
//        for (Iterator<Subscription> it = data.iterator(); it.hasNext();) {
//            System.out.println( it.next().getSubscription_date());
//        }
        // Выводим названия курсов и фио студентов относящихся к курсу по id subscription
        for (Subscription subscription : data) {
            System.out.println(subscription.getCourse().getName() + " - " + subscription.getStudent().getName());
        }



        sessionFactory.close();

        return  session;
    }

}
