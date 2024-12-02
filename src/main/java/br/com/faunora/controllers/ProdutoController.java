package br.com.faunora.controllers;

import br.com.faunora.domain.dto.ProdutoRecordDto;
import br.com.faunora.domain.dto.RestMensagemRecordDto;
import br.com.faunora.domain.enums.ProdutoTipo;
import br.com.faunora.domain.models.ProdutoModel;
import br.com.faunora.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<RestMensagemRecordDto> saveProduto(@RequestBody ProdutoRecordDto produtoRecordDto) {
        produtoService.saveProduto(produtoRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new RestMensagemRecordDto("produto criado com sucesso"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> getProdutoById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> getAllProdutos() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<ProdutoModel>> getAllByCategoria(@RequestParam ProdutoTipo categoria) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAllByCategoria(categoria));
    }

    @GetMapping("/{filter}")
    public ResponseEntity<List<ProdutoModel>> getAllByRandom(@PathVariable String filter) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAllByRandom(filter));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestMensagemRecordDto> updateProduto(@PathVariable Long id, @RequestBody ProdutoRecordDto produtoRecordDto) {
        produtoService.updateProduto(id, produtoRecordDto);
        return ResponseEntity.status(HttpStatus.OK).body(new RestMensagemRecordDto("produto atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestMensagemRecordDto> deleteById(@PathVariable Long id) {
        produtoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new RestMensagemRecordDto("produto deletado com sucesso"));
    }
}
