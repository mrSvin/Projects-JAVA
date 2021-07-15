import com.mysql.cj.jdbc.Driver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;
import org.hibernate.mapping.PrimaryKey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import static org.hibernate.id.PersistentIdentifierGenerator.PK;


public class Main {
    public static void main(String[] args) {

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


        //sql();
    }

    private static void sql() {
        try {
            DriverManager.registerDriver(new Driver());
            String mysqlUrl = "jdbc:mysql://localhost/scillbox";
            Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM scillbox.cources";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));


                System.out.println(rs.getString("name"));
            }
            con.close();

        } catch (Exception e) {
            //e.printStackTrace();
        }
    }


}
