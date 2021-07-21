import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.LinkedList;
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


//        System.out.println("users.size = " + data.size());
//        for (Iterator<Subscription> it = data.iterator(); it.hasNext();) {
//            System.out.println( it.next().getSubscription_date());
//        }
        // Выводим названия курсов и фио студентов относящихся к курсу по id subscription
//        String hql = "From " + Subscription.class.getSimpleName();
//        List<Subscription> data = session.createQuery(hql).list();
//
//        for (Subscription subscription : data) {
//            System.out.println(subscription.getCourse().getName() + " - " + subscription.getStudent().getName());
//        }

        Transaction transaction = session.beginTransaction();
        String sql = "INSERT INTO skillbox.linkedpurchaselist(`student_id`, `course_id`) " +
                "SELECT " +
                "skillbox.students.id as students_id, " +
                "skillbox.courses.id as course_id " +
                "FROM skillbox.purchaselist " +
                "JOIN skillbox.courses ON skillbox.courses.name=skillbox.purchaselist.course_name " +
                "JOIN skillbox.students ON skillbox.students.name=skillbox.purchaselist.student_name";
        Query query = session.createSQLQuery(sql).addEntity(LinkedPurchaseList.class);
        query.executeUpdate();
        transaction.commit();
        session.close();


//        Transaction transaction = session.beginTransaction();
//        String sql = "CREATE TABLE `scillbox`.`linkedpurchaselist` ( `course_id` INT UNSIGNED NOT NULL,`student_id` INT UNSIGNED NOT NULL);";
//
//        Query query = session.createSQLQuery(sql).addEntity(LinkedPurchaseList.class);
//        query.executeUpdate();
//        transaction.commit();
//        session.close();

//        Course course = new Course();
//        Student student = new Student();
//
//        LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
//        linkedPurchaseList.setCourseId(course.getId());
//        linkedPurchaseList.setCourseId(student.getId());
//        session.save(linkedPurchaseList);

//        String hql = "From " + LinkedPurchaseList.class.getSimpleName();
//        List<LinkedPurchaseList> data = session.createQuery(hql).list();
//
//        for (LinkedPurchaseList linkedPurchaseList : data) {
//            System.out.println(linkedPurchaseList.getCourse_id().getName() + " - " + linkedPurchaseList.getStudent_id().getName());
//        }


        sessionFactory.close();

        return  session;
    }

}
