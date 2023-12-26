package meu.booking_rebuild.controller;

import jakarta.validation.Valid;
import meu.booking_rebuild.config.Constants;
import meu.booking_rebuild.model.PassangerModel;
import meu.booking_rebuild.repository.PassangersRepository;
import meu.booking_rebuild.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/passanger", produces = MediaType.APPLICATION_JSON_VALUE)
public class PassangerController {
    @Autowired
    private  PassangersRepository passangersRepository;
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GenericResponse> addPassanger(@RequestBody @Valid PassangerModel model){
        try{
            passangersRepository.save(model);
            GenericResponse response = new GenericResponse(model.getId().toString());
            return new ResponseEntity<>(response, HttpStatusCode.valueOf(201));
        }catch (RuntimeException e){
            GenericResponse response = new GenericResponse(e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatusCode.valueOf(201));
        }
    }
}