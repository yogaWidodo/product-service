package com.batch15.springboot.product.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table


@Entity
@Table(name = "mst_bike")
data class MasterBikeEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", insertable = false, updatable = false)
    val id: Int = 0,

    @Column(name = "bike_name", nullable = false)
    var bikeName: String = "",

    @Column(name = "bike_type", nullable = false)
    val bikeType: String = "",

    @Column(name = "bike_price", nullable = false)
    var bikePrice: Int = 0,

    @Column(name = "user_id", nullable = true)
    var userId: Int? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = true)
    var brand: MasterBrandEntity? = null,


): BaseEntity()

