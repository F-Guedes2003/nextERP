package org.example.eprsystem.models;

public class User {
    private String name;
    private String cnpj;
    private String password;

    public User(String name, String cnpj, String password) {
        this.name = name;
        this.cnpj = cnpj;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
