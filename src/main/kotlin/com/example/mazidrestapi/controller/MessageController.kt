package com.example.mazidrestapi.controller

import com.example.mazidrestapi.model.Message
import com.example.mazidrestapi.repository.IRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/messages")
class MessageController(
    private val repository: IRepository<Message>,
) {

    @GetMapping // default method
    fun findAll(): List<Message> {
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun findById(
        @PathVariable id: Long,
    ): Message? {
        return repository.findById(id)
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    fun create(
        @Valid
        @RequestBody message: Message,
    ): Message {
        return repository.create(message)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody message: Message,
    ) {
        repository.update(id, message)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable id: Long,
    ) {
        repository.delete(id)
    }

}
