package br.com.faunora.controllers;

import br.com.faunora.domain.dto.exames.LaudoRecordDto;
import br.com.faunora.domain.dto.rest.RestMensagemRecordDto;
import br.com.faunora.domain.models.LaudoModel;
import br.com.faunora.services.LaudoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/laudos")
public class LaudoController {
    @Autowired
    private LaudoService laudoService;

    @PreAuthorize("hasRole('ROLE_VET')")
    @PostMapping
    public ResponseEntity<RestMensagemRecordDto> saveLaudo(@RequestBody @Valid LaudoRecordDto laudoRecordDto) {
        laudoService.saveLaudo(laudoRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new RestMensagemRecordDto("laudo criado com sucesso"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaudoModel> getLaudoById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(laudoService.findById(id));
    }

    @PreAuthorize("hasRole('ROLE_VET')")
    @PutMapping("/{id}")
    public ResponseEntity<RestMensagemRecordDto> updateLaudoById(@PathVariable Long id, @RequestBody @Valid LaudoRecordDto laudoRecordDto) {
        laudoService.updateById(id, laudoRecordDto);
        return ResponseEntity.status(HttpStatus.OK).body(new RestMensagemRecordDto("laudo atualizado com sucesso"));
    }

    @PreAuthorize("hasRole('ROLE_VET')")
    @DeleteMapping("/{id}")
    public ResponseEntity<RestMensagemRecordDto> deleteLaudoById(@PathVariable Long id) {
        laudoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new RestMensagemRecordDto("laudo deletado com sucesso"));
    }
}
