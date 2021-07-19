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

    @EmbeddedId
    private Key id;

    public LinkedPurchaseList(Student student, Course course) {
        this.id = new Key(student, course);
    }


//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "student_id", insertable = false, updatable = false)
//    private Student student;
////
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "course_id", insertable = false, updatable = false)
//    private Course course;
//
//

    @NoArgsConstructor
    @Embeddable
    @Data
    public static class Key implements Serializable {
        @ManyToOne
        @JoinColumn(columnDefinition = "student_id")
        private Student student;

        @ManyToOne
        @JoinColumn(columnDefinition = "course_id")
        private Course course;

        public Key(Student student, Course course) {
            this.course = course;
            this.student = student;
        }
    }

}
