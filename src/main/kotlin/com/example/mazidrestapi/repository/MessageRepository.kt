package com.example.mazidrestapi.repository

import com.example.mazidrestapi.model.Message
import org.springframework.stereotype.Repository
import kotlin.random.Random

@Repository
class MessageRepository : IRepository<Message> {

    // TODO: 8/2/2022 use dao or data_source instead
    private val messages by lazy {
        ArrayList<Message>(10)
    }

    override fun create(t: Message): Message {
        val message = t.copy(id = messages.size.toLong())
        messages.add(message)
        return message
    }

    override fun update(id: Long, t: Message): Boolean {
        val index = messages.indexOfFirst {
            it.id == id
        }
        if (index != -1) {
            messages.removeAt(index)
            messages.add(index, t.copy(id = id))
            return true
        }
        return false
    }

    override fun delete(id: Long): Boolean {
        val index = messages.indexOfFirst {
            it.id == id
        }
        if (index != -1) {
            messages.removeAt(index)
            return true
        }
        return false
    }

    override fun findAll(): List<Message> {
        return messages
    }

    override fun findById(id: Long): Message? {
        return messages.find {
            it.id == id
        }
    }
}