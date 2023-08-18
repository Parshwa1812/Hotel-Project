package com.backend.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.backend.pojos.enums.IngredientType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ingredients")
public class IngredientPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Long ingredientId;

    @Column(name = "ingredient")
    private IngredientType ingredient;

    @Column(name = "inventory_capacity")
    private Long inventoryCapacity;

    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.LAZY)
    private Set<MenuPOJO> items = new HashSet<>();


    // private SupplierPOJO supplier;  

}
