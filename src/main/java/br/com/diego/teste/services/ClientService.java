package br.com.diego.teste.services;

import br.com.diego.teste.models.ClientModel;
import br.com.diego.teste.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientService {


    private ClientRepository clientRepository;

    public List<ClientModel> findAll(){
        List<ClientModel> list = clientRepository.findAll();
        return list;
    }

    public ClientModel findById(Long id){
        Optional<ClientModel> obj = clientRepository.findById(id);

        return obj.orElseThrow(()-> new RuntimeException(
                "obj nao encontrado" + ClientModel.class.getName()));
    }



}
