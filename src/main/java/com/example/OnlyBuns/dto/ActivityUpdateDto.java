package com.example.OnlyBuns.dto;

import com.example.OnlyBuns.model.Status;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActivityUpdateDto {
    public String name;
    public String description;
    public Status status;
    public Integer minCapacity;
    public Integer maxCapacity;
    public Double price;
    public Boolean isPremiumOption;
}
