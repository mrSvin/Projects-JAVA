import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "linkedpurchaselist")
public class LinkedPurchaseList {


    public void setId(Key id) {
        this.id = id;
    }

    @EmbeddedId
    private Key id;

    public LinkedPurchaseList() {
        this.id = new Key(student, course);
    }

    @Column(name = "student_id", insertable = false, updatable = false)
    private int student;

    public void setStudent(int student) {
        this.student = student;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Column(name = "course_id", insertable = false, updatable = false)
    private int course;



    @Embeddable
    @Data
    public static class Key implements Serializable {


        @Column(name = "student_id", insertable = false, updatable = false)
        private int student;

        @Column(name = "course_id", insertable = false, updatable = false)
        private int course;

//        @JoinColumn(columnDefinition = "student_id")
//        private int student_id;
//
//        @JoinColumn(columnDefinition = "course_id")
//        private int course_id;

        public Key(int student_id, int course_id) {
            this.course = course_id;
            this.student = student_id;
        }
    }

}
