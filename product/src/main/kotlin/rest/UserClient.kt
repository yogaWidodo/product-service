package rest

import com.batch15.springboot.product.domain.dto.ResGetUserByIdsDTO
import com.batch15.springboot.product.domain.dto.ResUserByID
import com.batch15.springboot.product.domain.dto.WebResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam


@FeignClient(name = "usermanagementservice", path = "/user-management")
interface UserClient {
    @GetMapping("/{id}")
    fun getUserById(
        @PathVariable id: Int
    ): ResponseEntity<WebResponse<ResUserByID?>>

    @GetMapping("/data-source/users-by-ids")
    fun getUsersByIds(
        @RequestParam(required = true) ids: List<Int?>
    ): ResponseEntity<WebResponse<List<ResGetUserByIdsDTO>>>
}