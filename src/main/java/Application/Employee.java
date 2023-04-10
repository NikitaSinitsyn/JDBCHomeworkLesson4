package Application;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String first_name;
    private String last_name;
    private String gender;
    private Integer age;

    @ManyToOne(fetch = FetchType.LAZY)
    // FetchType.LAZY для связи многие к одному, чтобы загрузка связанных сущностей происходила только при необходимости
    // и уменьшить нагрузку на базу данных и увеличить производительность.
    @JoinColumn(name = "city_id")
    private City city;



    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", city=" + city +
                '}';
    }
}
