package com.wpn.repository;
import com.wpn.model.Account;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.Optional;

import java.util.NoSuchElementException;





@Component
public class BankDao {

    private final BankRepository personRepository;

    public BankDao(BankRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Account insertPersonData(Account person) {
        return personRepository.insert(person);
    }

    public Collection<Account> getAllPersonInformation() {
        return personRepository.findAll();
    }

    public Optional<Account> getPersonInformationById(String id) {
        return personRepository.findById(id);
    }

    public Account updatePersonUsingId(String id, Account person) {
        Optional<Account> findPersonQuery = personRepository.findById(id);
        Account personValues = findPersonQuery.get();
        personValues.setId(person.getId());
        personValues.setName(person.getName());
        personValues.setEmail(person.getEmail());
        return personRepository.save(personValues);
    }

    public void deletePersonUsingId(String id) {
        try {
            personRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }



}
