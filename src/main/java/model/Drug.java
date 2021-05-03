package model;

import annotations.Column;
import annotations.Table;

import java.math.BigDecimal;

@Table(name = "drugs")
public class Drug {



    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "need_recipe")
    private Boolean needRecipe;
    @Column(name = "dosage")
    private Integer dosage;
    @Column(name = "in_stock")
    private Boolean inStock;

    public Drug() {
    }

    public Drug(String name, Double price, Boolean needRecipe, Integer dosage, Boolean inStock) {
        this.name = name;
        this.price = price;
        this.needRecipe = needRecipe;
        this.dosage = dosage;
        this.inStock = inStock;
    }

    public Drug(Integer id, String name, Double price, Boolean needRecipe, Integer dosage, Boolean inStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.needRecipe = needRecipe;
        this.dosage = dosage;
        this.inStock = inStock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getNeedRecipe() {
        return needRecipe;
    }

    public void setNeedRecipe(Boolean needRecipe) {
        this.needRecipe = needRecipe;
    }

    public Integer getDosage() {
        return dosage;
    }

    public void setDosage(Integer dosage) {
        this.dosage = dosage;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", needRecipe=" + needRecipe +
                ", dosage=" + dosage +
                ", inStock=" + inStock +
                '}';
    }
}
