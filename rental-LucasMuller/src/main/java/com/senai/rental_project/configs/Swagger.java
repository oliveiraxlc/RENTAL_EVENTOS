package com.senai.rental_project.configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
@Configuration
@OpenAPIDefinition(
info = @Info(
title = "Rental",
version = "1.0",
description = "Mapeia e controla as movimentações de equipamentos feitas pelo usuário."
)
)

public class Swagger {
    
}
