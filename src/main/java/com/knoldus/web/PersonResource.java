package com.knoldus.web;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.knoldus.model.Person;
import com.knoldus.service.PersonService;

import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

@Path("/person")
public class PersonResource {

  @Inject PersonService personService;

  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Person listFistElement() {
    System.out.println("id is: "+personService.list().get(0).getId() +  " "+ " and name is " +   personService.list().get(0).getName());
    return new Person(personService.list().get(0).getId(), personService.list().get(0).getName());
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public void post(Person person) {
    personService.add(person);
  }

}
