package com.springboot.practical.designs.example.model;

import com.springboot.practical.designs.example.model.Products.ProductsBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Bill {
String item;

}
