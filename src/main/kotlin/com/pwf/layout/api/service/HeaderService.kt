package com.pwf.header.api.service

import com.pwf.header.api.exception.NotFoundException
import com.pwf.header.api.model.entities.Header
import com.pwf.header.api.repository.IHeaderRepository
import com.pwf.header.api.request.HeaderRequest
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class HeaderService(
    private val headerRepository: IHeaderRepository
) {
    fun createHeader(request:HeaderRequest):Mono<Header> =
        headerRepository.save(
            Header(
                id = request.id,
                logoImg = request.logoImg,
                listMenu = request.listMenu,
                listIcons = request.listIcons,
                isDeleted = false
            )
        )

    fun findById(id:String):Mono<Header> =
        headerRepository.findById(id)

    fun findAll():Flux<Header> =
        headerRepository.findByIsDeletedIsFalse()

    fun updateHeader(id:String, request: HeaderRequest):Mono<Header> =
        findById(id)
            .flatMap { headerRepository.save(
                it.apply {
                    logoImg = request.logoImg
                    listMenu = request.listMenu
                    listIcons = request.listIcons
                }
            ) }

    fun updateListMenuHeader(id:String,request: HeaderRequest):Mono<Header> =
        findById(id)
            .flatMap { headerRepository.save(
                it.apply { listMenu = request.listMenu }
            ) }

    fun updateListIconsHeader(id:String,request: HeaderRequest):Mono<Header> =
        findById(id)
            .flatMap { headerRepository.save(
                it.apply { listIcons = request.listIcons }
            ) }

    fun deleteHeader(id: String):Mono<Header> =
        findById(id)
            .flatMap { headerRepository.save(
                it.apply {
                    isDeleted = true
                }
            ) }
}