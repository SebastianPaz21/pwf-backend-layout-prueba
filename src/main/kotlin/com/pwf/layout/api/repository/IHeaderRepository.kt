package com.pwf.header.api.repository

import com.pwf.header.api.model.entities.Header
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux

interface IHeaderRepository:ReactiveMongoRepository<Header,String> {
    fun findByIsDeletedIsFalse():Flux<Header>
}