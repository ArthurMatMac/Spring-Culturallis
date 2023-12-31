package com.example.demo.Categorias.CategoraisController;

import com.example.demo.Categorias.CategoriasModel.Categorias;
import com.example.demo.Categorias.CategoriasRepository;
import com.example.demo.Conteudos.ConteudosController.ConteudosController;
import com.example.demo.Conteudos.ConteudosModel.Conteudos;
import com.example.demo.Conteudos.ConteudosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturallis")
public class CategoriasController {

    private final CategoriasRepository categoriasRepository;

    @Autowired
    public CategoriasController(CategoriasRepository categoriasRepository){
        this.categoriasRepository = categoriasRepository;
    }


    @GetMapping("/listarCategorias")
    public List<Categorias> getContents(){
        return categoriasRepository.findAll();
    }

    @PostMapping("/inserirCategorias")
    public ResponseEntity<String> insertContents(@RequestBody Categorias categorias){
        categorias.setData_criacao(new Date());
        try {
            categoriasRepository.save(categorias);
            return ResponseEntity.ok("Conteúdo Inserido");
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/excluirCategorias")
    public ResponseEntity<String> deleteCategory(@RequestParam Long id){
        Optional<Categorias> categoryToDelete = categoriasRepository.findById(id);
        if(categoryToDelete.isPresent()){
            categoriasRepository.deleteById(id);
            return ResponseEntity.ok("Conteúdo excluído!");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/alterarCategorias/{id}")
    public ResponseEntity<String> alterarProduto(@PathVariable Long id, @RequestBody Categorias categoriasAtt){
        Optional<Categorias> category = categoriasRepository.findById(id);
        if(category.isPresent()){
            Categorias cat = category.get();
            cat.setNome(categoriasAtt.getNome());
            cat.setData_criacao(categoriasAtt.getData_criacao());
            cat.setData_mudanca(new Date());
            cat.setData_desativacao(categoriasAtt.getData_desativacao());
            categoriasRepository.save(cat);
            return ResponseEntity.ok("Conteúdo atualizado!");
        }
        return ResponseEntity.notFound().build();

    }
}
