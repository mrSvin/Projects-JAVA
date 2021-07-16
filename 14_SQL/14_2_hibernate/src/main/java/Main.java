
public class Main {
    public static void main(String[] args) {
        Hibernate hibernate = new Hibernate();
        hibernate.HibernateOpenSession();
        Course course = hibernate.getSession().get(Course.class, 4);
        System.out.println("Название курса: " + course.getName() + " количество студентов: " + course.getStudentsCount());
        hibernate.getSessionFactory().close();

    }


}
