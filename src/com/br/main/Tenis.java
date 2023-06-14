package com.br.main;

public class Tenis {
    private String marca, cor, modelo;
    private int id, tamanho;
    private double preco;

    public Tenis(){
             
    }
    
    public Tenis(String id, String marca, String modelo, String tamanho, String cor, String preco){       
        this.id = Integer.parseInt(id);
        this.tamanho = Integer.parseInt(tamanho);
        this.preco = Double.parseDouble(preco);
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
    } 

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getId() {
        return String.valueOf(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTamanho() {
       return String.valueOf(tamanho);
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getPreco() {
       return String.valueOf(preco);
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}
