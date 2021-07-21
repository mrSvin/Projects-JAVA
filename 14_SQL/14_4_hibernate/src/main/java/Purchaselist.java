import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "purchaselist")
public class Purchaselist {
    @EmbeddedId
    private PurchaselistKey key;

    @Column(name = "student_name", insertable = false, updatable = false)
    private int student_name;


    @Column(name = "course_name", insertable = false, updatable = false)
    private int course_name;

    @Column(columnDefinition = "subscription_date")
    private LocalDateTime subscription_date;


    @Embeddable
    @Data
    public static class PurchaselistKey implements Serializable {
        @Column(columnDefinition = "student_name")
        private String student_name;

        @Column(columnDefinition = "course_name")
        private String course_name;

    }

    public int getStudent_name() {
        return student_name;
    }

    public int getCourse_name() {
        return course_name;
    }


}
