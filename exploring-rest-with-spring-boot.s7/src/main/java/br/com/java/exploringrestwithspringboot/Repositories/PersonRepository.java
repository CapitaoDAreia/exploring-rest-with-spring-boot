package br.com.java.exploringrestwithspringboot.Repositories;

import br.com.java.exploringrestwithspringboot.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
