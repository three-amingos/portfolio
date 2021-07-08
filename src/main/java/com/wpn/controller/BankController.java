package com.wpn.controller;

import com.wpn.model.Account;
import com.wpn.service.BankService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("person")
public class BankController {

    private final BankService personService;
    public BankController(BankService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Account create(@RequestBody Account person) {
        return personService.insertPersonData(person);
    }

    @GetMapping
    public Collection<Account> read() {
        return personService.getAllPersonInformation();
    }

    @GetMapping(path = "{id}")
    public Optional<Account> readQueryUsingId(@PathVariable("id") String id) {
        return personService.getPersonInformationUsingId(id);
    }

    @PutMapping(path = "/update/{id}")
    public void update(@PathVariable String id, @RequestBody Account person ) {
        personService.updatePersonUsingId(id, person);
    }

    @DeleteMapping(path = "/delete/{id}",produces = "text/html")
    public void delete(@PathVariable("id") String id){
        personService.deletePersonUsingId(id);
    }
   /* @GetMapping("/")
    public Object hello(@AuthenticationPrincipal OAuth2User user) {
        System.out.println(user);
        Map<String, Object> res = new LinkedHashMap<>();
        res.put("class", user.getClass());
        res.put("name", user.getName());
        res.put("authorities", user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        res.put("attributes", user.getAttributes());
        return res;
    }*/
}
