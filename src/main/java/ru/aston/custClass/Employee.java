package ru.aston.custClass;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class Employee{
    private int id;
    private String name;
    private String status;
    private String subdivision;
    private double wageRate;
}
