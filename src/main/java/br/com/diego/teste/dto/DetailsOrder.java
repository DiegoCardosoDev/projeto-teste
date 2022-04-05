package br.com.diego.teste.dto;

import br.com.diego.teste.models.ClientModel;
import br.com.diego.teste.models.Order;
import br.com.diego.teste.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailsOrder {

    private Order order;
    private ClientModel client;
    private User user;
}
