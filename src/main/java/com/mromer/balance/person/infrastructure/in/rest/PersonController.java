package com.mromer.balance.person.infrastructure.in.rest;

import org.springframework.web.bind.annotation.*;

import com.mromer.balance.common.application.dto.PagedResponseDTO;
import com.mromer.balance.person.application.dto.PersonResponseDTO;
import com.mromer.balance.person.application.port.in.command.*;
import com.mromer.balance.person.application.port.in.query.*;
import com.mromer.balance.person.domain.value.PersonId;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;




@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/persons")
public class PersonController {
    private final GetAllPersons getAllPersons;
    private final GetPersonById getPersonById;
    private final RegisterPerson registerPerson;

    @GetMapping
    public ResponseEntity<PagedResponseDTO<PersonResponseDTO>> getAllPersons(
        @Valid GetAllPersonsQuery query, @PageableDefault Pageable pageable
    ) {
        return ResponseEntity.ok(getAllPersons.getAllPersons(query, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> getPersonById(@PathVariable UUID id) {
        return ResponseEntity.ok(getPersonById.getPersonById(PersonId.of(id)));
    }
    
    @PostMapping("/register")
    public ResponseEntity<PersonResponseDTO> registerPerson(@Valid @RequestBody RegisterPersonCommand command) {
        return ResponseEntity.ok(registerPerson.registerPerson(command));
    }

    @PatchMapping("/{id}/update-contact-info")
    public ResponseEntity<PersonResponseDTO> updatePersonContactInfo(
            @PathVariable UUID id,
            @Valid @RequestBody UpdatePersonContactInfoCommand command) {
        UpdatePersonContactInfo updatePersonContactInfo = (UpdatePersonContactInfo) getPersonById;
        return ResponseEntity.ok(updatePersonContactInfo.updatePersonContactInfo(PersonId.of(id), command));
    }

    @PatchMapping("/{id}/update-main-info")
    public ResponseEntity<PersonResponseDTO> updatePersonMainInfo(
            @PathVariable UUID id,
            @Valid @RequestBody UpdatePersonMainInfoCommand command) {
        UpdatePersonMainInfo updatePersonMainInfo = (UpdatePersonMainInfo) getPersonById;
        return ResponseEntity.ok(updatePersonMainInfo.updatePersonMainInfo(PersonId.of(id), command));
    }
    
}
