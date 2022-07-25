package com.knoldus.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(value = { "id" }, allowGetters = true)
public class Person {

  private String id;
  private String name;

  public Person(String id,
                String name) {
    this.id = id;
    this.name = name;
  }

  public Person() {

  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Person{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }

}
