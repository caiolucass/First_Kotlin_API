package br.com.caio.forum.dto

import br.com.caio.forum.model.StatusTopico
import java.time.LocalDateTime

data class TopicoDTOOutput (
           val id: Long?,
           val titulo: String,
           val mensagem: String,
           val status: StatusTopico,
           val dataCriacao: LocalDateTime
        )
