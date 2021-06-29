package com.fundmaentosplatzi.springboot.fundamentos.repository;

import com.fundmaentosplatzi.springboot.fundamentos.entity.User;
import com.fundmaentosplatzi.springboot.fundamentos.repository.dto.UserDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);

    @Query("select u from User u where u.name like ?1%")
    List<User> findByAndSort(String name, Sort sort);

    List<User> findByName(String name);

    Optional<User> findByEmailAndName(String email, String name);

    List<User> findByNameLike(String name);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);

    List<User> findByNameLikeOrderByIdDesc(String name);

    List<User> findByNameContainingOrderByIdDesc(String name);

    //named parameters
    @Query(" SELECT new com.fundmaentosplatzi.springboot.fundamentos.repository.dto.UserDto(u.id, u.name, u.birthDate)"+
            "FROM User u " +
            "WHERE u.birthDate=:parametroFecha" +
            " and u.email=:parametroEmail")

    Optional<UserDto> getAllByBirthdDateAndEmail(@Param("parametroFecha")LocalDate date,
                                                 @Param("parametroEmail") String email);

    List<User> findAll();;




}
