import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
//for new commit
@Data
@Entity
@Table(name = "subscriptions")
public class Subscription {

    @EmbeddedId
    private Key id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;


    @Column(columnDefinition = "subscription_date")
    private Date subscription_date;


    @Embeddable
    @Data
    public static class Key implements Serializable {
        @ManyToOne
        @JoinColumn(columnDefinition = "student_id")
        private Student student;

        @ManyToOne
        @JoinColumn(columnDefinition = "course_id")
        private Course course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getSubscription_date() {
        return subscription_date;
    }



}
