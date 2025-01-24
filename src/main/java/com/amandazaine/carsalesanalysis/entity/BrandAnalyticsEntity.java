package com.amandazaine.carsalesanalysis.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "brand_analytics")
public class BrandAnalyticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private Long qtddPosts;

    public BrandAnalyticsEntity() {
    }

    public BrandAnalyticsEntity(Long id, String brand, Long qtddPosts) {
        this.id = id;
        this.brand = brand;
        this.qtddPosts = qtddPosts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getQtddPosts() {
        return qtddPosts;
    }

    public void setQtddPosts(Long qtddPosts) {
        this.qtddPosts = qtddPosts;
    }
}
