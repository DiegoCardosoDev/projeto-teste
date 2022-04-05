package br.com.diego.teste.services;


import br.com.diego.teste.models.Order;
import br.com.diego.teste.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderService {

    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> order = orderRepository.findById(id);
        return order.orElseThrow(()-> new RuntimeException("order nao encontrada" + Order.class.getName()));
    }

}
