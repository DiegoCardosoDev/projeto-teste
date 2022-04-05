package br.com.diego.teste.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;
    private long validDays;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientModel client;

    @Getter
    @OneToMany(mappedBy = "order")
    private List<OrderItem> items = new ArrayList<>();

    public LocalDateTime dateValid(LocalDateTime valid){
        return  valid = LocalDateTime.now().minus(validDays, ChronoUnit.DAYS);
    }



}
