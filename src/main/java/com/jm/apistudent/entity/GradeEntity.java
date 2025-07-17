package com.jm.apistudent.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "grades")
public class GradeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double grade;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id", nullable = false)
    private CourseEntity course;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity student;


}
