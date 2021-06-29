package com.fundmaentosplatzi.springboot.fundamentos.repository.dto;

import java.time.LocalDate;

//es Data transfer object , transferimos objetos a nivel de aplicacion.♠
public class UserDto {
    private Long id;
    private String name;
    private LocalDate birthDate;

    public UserDto(Long id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
