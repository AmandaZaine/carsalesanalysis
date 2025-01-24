package com.amandazaine.carsalesanalysis.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "carmodel_analytics")
public class CarModelAnalyticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String model;
    private Long qtddPosts;

    public CarModelAnalyticsEntity() {
    }

    public CarModelAnalyticsEntity(Long id, String model, Long qtddPosts) {
        this.id = id;
        this.model = model;
        this.qtddPosts = qtddPosts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getQtddPosts() {
        return qtddPosts;
    }

    public void setQtddPosts(Long qtddPosts) {
        this.qtddPosts = qtddPosts;
    }
}
