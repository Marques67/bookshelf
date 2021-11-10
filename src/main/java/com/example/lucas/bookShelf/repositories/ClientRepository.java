package com.example.lucas.bookShelf.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.lucas.bookShelf.models.Client;

public interface ClientRepository extends CrudRepository<Client, String>{

	Client findByCpf(Integer cpf);
}
