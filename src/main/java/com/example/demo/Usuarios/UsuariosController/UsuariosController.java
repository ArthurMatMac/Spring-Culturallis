package com.example.demo.Usuarios.UsuariosController;

import com.example.demo.Usuarios.UsuariosModel.Usuarios;
import com.example.demo.Usuarios.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturallis")
public class UsuariosController {

    private final UsuariosRepository usuariosRepository;

    @Autowired
    public UsuariosController(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @GetMapping("/listarUsuarios")
    public List<Usuarios> getContents() {
        return usuariosRepository.findAll();
    }

    @PostMapping("/inserir")
    public ResponseEntity<String> insertContents(@RequestBody Usuarios usuarios) {
        usuarios.setData_criacao(new Date());
        try {
            usuariosRepository.save(usuarios);
            return ResponseEntity.ok("Usuário Inserido");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/excluirUsuarios")
    public ResponseEntity<String> deleteContents(@RequestParam Long id) {
        Optional<Usuarios> contentToDelete = usuariosRepository.findById(id);
        if (contentToDelete.isPresent()) {
            usuariosRepository.deleteById(id);
            return ResponseEntity.ok("Usuário excluído!");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/alterarUsuarios/{id}")
    public ResponseEntity<String> alterarUsuario(@PathVariable Long id, @RequestBody Usuarios usuariosAtt) {
        Optional<Usuarios> usuario = usuariosRepository.findById(id);
        if (usuario.isPresent()) {

            Usuarios user = usuario.get();
            user.setFk_tb_tipos_sexos_id(usuariosAtt.getFk_tb_tipos_sexos_id());
            user.setNomeUsuario(usuariosAtt.getNomeUsuario());
            user.setNomeCompleto(usuariosAtt.getNomeCompleto());
            user.setTelefone(usuariosAtt.getTelefone());
            user.setBio(usuariosAtt.getBio());
            user.setCpf(usuariosAtt.getCpf());
            user.setUrlFoto(usuariosAtt.getUrlFoto());
            user.setEmail(usuariosAtt.getEmail());
            user.setData_criacao(usuariosAtt.getData_criacao());
            user.setDataNasc(usuariosAtt.getDataNasc());
            user.setData_mudanca(new Date());
            user.setData_desativacao(usuariosAtt.getData_desativacao());
            usuariosRepository.save(user);
            return ResponseEntity.ok("Usuário atualizado!");
        }
        return ResponseEntity.notFound().build();

    }

}
