package com.batch15.springboot.product.domain.entity

import jakarta.persistence.*


@Entity
@Table(name = "mst_brand")
data class MasterBrandEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    val id: Int = 0,

    @Column(name = "name", nullable = false)
    val name: String = ""
) : BaseEntity()
