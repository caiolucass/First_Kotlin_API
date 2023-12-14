package br.com.caio.forum.controller

import br.com.caio.forum.dto.TopicoDTOInput
import br.com.caio.forum.dto.TopicoDTOOutput
import br.com.caio.forum.service.TopicoService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listar(): List<TopicoDTOOutput> {
       return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoDTOOutput {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody dto: TopicoDTOInput){
        service.cadastrar(dto)
    }
}