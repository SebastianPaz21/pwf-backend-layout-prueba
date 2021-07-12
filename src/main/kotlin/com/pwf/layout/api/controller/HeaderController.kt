package com.pwf.header.api.controller

import com.pwf.header.api.request.HeaderRequest
import com.pwf.header.api.response.HeaderResponse
import com.pwf.header.api.service.HeaderService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@CrossOrigin
@RequestMapping("/api/header")
class HeaderController (
    private val headerService:HeaderService
){
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun postHeader(@RequestBody request:HeaderRequest): Mono<HeaderResponse> =
        headerService.createHeader(request).map { HeaderResponse.fromEntity(it) }

    @GetMapping("/{id}")
    fun getByIdHeader(@PathVariable id:String): Mono<HeaderResponse> =
        headerService.findById(id).map { HeaderResponse.fromEntity(it) }

    @GetMapping
    fun getAllHeader(): Flux<HeaderResponse> =
        headerService.findAll().map { HeaderResponse.fromEntity(it) }

    @PutMapping("/{id}")
    fun putHeader(@PathVariable id:String, @RequestBody request: HeaderRequest):Mono<HeaderResponse> =
        headerService.updateHeader(id,request)
            .map { HeaderResponse.fromEntity(it) }

    @PutMapping("/listMenu/{id}")
    fun putListMenuHeader(@PathVariable id:String, @RequestBody request: HeaderRequest):Mono<HeaderResponse> =
        headerService.updateListMenuHeader(id,request)
            .map { HeaderResponse.fromEntity(it) }

    @PutMapping("/listIcons/{id}")
    fun putListIconsHeader(@PathVariable id:String, @RequestBody request: HeaderRequest):Mono<HeaderResponse> =
        headerService.updateListIconsHeader(id,request)
            .map { HeaderResponse.fromEntity(it) }

}