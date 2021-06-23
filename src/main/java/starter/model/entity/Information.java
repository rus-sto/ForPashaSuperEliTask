package starter.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity//пометка для класса, чтобы гипернет знал что этот класс содержит сущность для бд
@Data
@Table(name = "myInfo")
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String info;

}
