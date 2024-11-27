package org.example.eprsystem.service;

import org.example.eprsystem.models.User;

import java.util.Optional;

public interface DatabaseService {
    public void create(String name, String cnpj, String password);

    public Optional<User> findOne(String cnpj, String password);
}
