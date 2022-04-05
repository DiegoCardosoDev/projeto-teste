package br.com.diego.teste.controllers;


import br.com.diego.teste.dto.DetailsOrder;
import br.com.diego.teste.models.Order;
import br.com.diego.teste.services.OrderService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/orders")
public class OrderController {


    private OrderService orderService;
    private ModelMapper mapper;


    @GetMapping
    public ResponseEntity<List<DetailsOrder>> findAll() {
        return ResponseEntity.ok()
                .body(orderService.findAll()
                        .stream()
                        .map(x -> mapper.map(x, DetailsOrder.class)).collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order = this.orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }
}
