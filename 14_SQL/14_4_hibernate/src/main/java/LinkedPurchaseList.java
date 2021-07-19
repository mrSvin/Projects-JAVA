import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "linkedpurchaselist")
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkedPurchaseListKey id;

    public LinkedPurchaseList(Student student, Course course) {
        this.id = new LinkedPurchaseListKey(student_id, course_id);
    }


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student_id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course_id;


    @Embeddable
    @Data
    public static class LinkedPurchaseListKey implements Serializable {

        @ManyToOne
        @JoinColumn(name = "student_id", nullable = false, columnDefinition = "INT(11) UNSIGNED")
        private Student student_id;

        @ManyToOne
        @JoinColumn(name = "course_id", nullable = false, columnDefinition = "INT(11) UNSIGNED")
        private Course course_id;

        public LinkedPurchaseListKey(Student student_id, Course course_id) {
            this.student_id = student_id;
            this.course_id = course_id;

        }
    }


    public Student getStudent_id() {
        return student_id;
    }

    public Course getCourse_id() {
        return course_id;
    }


    public void setStudent_id(Student student_id) {
        this.student_id = student_id;
    }

    public void setCourse_id(Course course_id) {
        this.course_id = course_id;
    }

    public void setId(LinkedPurchaseListKey id) {
        this.id = id;
    }


}
