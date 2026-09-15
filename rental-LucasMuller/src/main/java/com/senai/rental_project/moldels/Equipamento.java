package com.senai.rental_project.moldels;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="marca")
    private String marca;

    @Column(name="modelo")
    private String modelo;

    @Column(name="categoria")
    private String categoria;

    @Column(name="potencia")
    private BigDecimal potencia;

    @Column(name="material")
    private String material;

    @Column(name="peso")
    private BigDecimal peso;

    @Column(name="dimencoes")
    private String dimencoes;

    @Column(name="cor")
    private String cor;

    @Column(name="quantidade_disponivel")
    private Integer quantidadeDisponivel;

    public Equipamento() {
    }

    public Equipamento(Long id, String marca, String modelo, String categoria, BigDecimal potencia, String material,
            BigDecimal peso, String dimencoes, String cor, Integer quantidadeDisponivel) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
        this.potencia = potencia;
        this.material = material;
        this.peso = peso;
        this.dimencoes = dimencoes;
        this.cor = cor;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPotencia() {
        return potencia;
    }

    public void setPotencia(BigDecimal potencia) {
        this.potencia = potencia;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getDimencoes() {
        return dimencoes;
    }

    public void setDimencoes(String dimencoes) {
        this.dimencoes = dimencoes;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

   
    

}
