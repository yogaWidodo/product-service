package com.batch15.springboot.product.repository

import com.batch15.springboot.product.domain.entity.MasterBrandEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BrandRepository: JpaRepository<MasterBrandEntity, Int> {

}