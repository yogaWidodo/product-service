package com.batch15.springboot.product.repository

import com.batch15.springboot.product.domain.entity.MasterBikeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ProductRepository: JpaRepository<MasterBikeEntity, Int> {

    @Query("SELECT m FROM MasterBikeEntity m WHERE m.isDelete = false", nativeQuery = false)
    fun getAllProducts(): List<MasterBikeEntity>
}