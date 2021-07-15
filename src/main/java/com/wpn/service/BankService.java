package com.wpn.service;
import com.wpn.model.Account;
import com.wpn.repository.BankDao;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class BankService {

    private final BankDao personDao;

    public BankService(BankDao personDao) {
        this.personDao = personDao;
    }

    public Account insertPersonData(Account person) {
        return personDao.insertPersonData(person);
    }

    public Collection<Account> getAllPersonInformation() {
        return personDao.getAllPersonInformation();
    }

    public Optional<Account> getPersonInformationUsingId(String id) {
        return personDao.getPersonInformationById(id);
    }

    public void updatePersonUsingId(String id, Account person) {
        personDao.updatePersonUsingId(id, person);
    }

    public void deletePersonUsingId(String id) {
        personDao.deletePersonUsingId(id);
    }

}
