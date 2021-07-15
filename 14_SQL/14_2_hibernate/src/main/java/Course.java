import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private int duration;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private CourseType  type;
    private String description;

//    @Column(columnDefinition = "teacherID")
//    private int teacherID;
    @Column(columnDefinition = "students_count")
    private int students_count;
    private int price;
    @Column(columnDefinition = "price_per_hour")
    private float price_per_hour;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public CourseType getType() {
        return type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public int getTeacherID() {
//        return teacherID;
//    }
//
//    public void setTeacherID(int teacherID) {
//        this.teacherID = teacherID;
//    }

    public int getStudentsCount() {
        return students_count;
    }

    public void setStudentsCount(int studentsCount) {
        this.students_count = studentsCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getPricePerHour() {
        return price_per_hour;
    }

    public void setPricePerHour(float pricePerHour) {
        this.price_per_hour = pricePerHour;
    }

}
