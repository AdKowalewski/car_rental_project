package com.carrental.model;

import com.carrental.enums.BodyType;
import com.carrental.enums.CarStatus;
import com.carrental.enums.FuelType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Entity(name = "car")
public class Car extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String brand;

    @Column(length = 50, nullable = false)
    private String model;

    @Column(length = 50, nullable = false)
    private String registrationNumber;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private BodyType bodyType;

    @Column(nullable = false)
    private Double engineCapacity;

    @Column(nullable = false)
    private Integer horsePower;

    @Column(nullable = false)
    private Integer numberOfSeats;

    @Column(nullable = false)
    private Integer numberOfDoors;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FuelType fuelType;

    @OneToMany(mappedBy = "car")
    @Column
    private List<Photo> photos;

    @Column(nullable = false)
    private Boolean isManual;

    @Column(nullable = false)
    private boolean hasAc;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer mileage;

    @Column(length = 50, nullable = false)
    private String color;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private CarStatus status;

    @Column
    private String description;

    @Column(nullable = false)
    private Integer dailyFee;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    public void addDepartment(Long id){
        department = new Department();
        department.setId(id);
    }

}
