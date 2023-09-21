package com.example.demo.Usuarios.UsuariosModel;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk_id;

    private Long fk_tb_tipos_sexos_id;

    private String nome_usuario;

    private String nome_completo;

    private String url_foto;

    private String telefone;

    private String bio;

    private String cpf;

    private String email;

    private Date data_nasc;

    private Date data_criacao;

    private Date data_mudanca;

    private Date data_desativacao;

    public Usuarios(Long fk_tb_tipos_sexos_id, String nome_usuario, String nome_completo, String url_foto,
            String telefone, String bio, String cpf, String email, Date data_nasc) {
        this.fk_tb_tipos_sexos_id = fk_tb_tipos_sexos_id;
        this.nome_usuario = nome_usuario;
        this.nome_completo = nome_completo;
        this.url_foto = url_foto;
        this.telefone = telefone;
        this.bio = bio;
        this.email = email;
        this.data_nasc = data_nasc;
        this.cpf = cpf;
    }

    public Usuarios(Long pk_id, Long fk_tb_tipos_sexos_id, String nome_usuario, String nome_completo, String url_foto,
            String telefone, String bio, String cpf, String email, Date data_nasc, Date data_criacao, Date data_mudanca,
            Date data_desativacao) {
        this.pk_id = pk_id;
        this.fk_tb_tipos_sexos_id = fk_tb_tipos_sexos_id;
        this.nome_usuario = nome_usuario;
        this.nome_completo = nome_completo;
        this.url_foto = url_foto;
        this.telefone = telefone;
        this.bio = bio;
        this.email = email;
        this.data_nasc = data_nasc;
        this.cpf = cpf;
        this.data_criacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public Usuarios(Long fk_tb_tipos_sexos_id, String nome_usuario, String nome_completo, String url_foto,
            String telefone, String bio, String cpf, String email, Date data_nasc,
            Date data_criacao, Date data_mudanca, Date data_desativacao) {
        this.fk_tb_tipos_sexos_id = fk_tb_tipos_sexos_id;
        this.nome_usuario = nome_usuario;
        this.nome_completo = nome_completo;
        this.url_foto = url_foto;
        this.telefone = telefone;
        this.bio = bio;
        this.email = email;
        this.data_nasc = data_nasc;
        this.cpf = cpf;
        this.data_criacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public Usuarios() {

    }

    public Long getPk_id() {
        return pk_id;
    }

    public Long getFk_tb_tipos_sexos_id() {
        return fk_tb_tipos_sexos_id;
    }

    public void setFk_tb_tipos_sexos_id(Long fk_tb_tipos_sexos_id) {
        this.fk_tb_tipos_sexos_id = fk_tb_tipos_sexos_id;
    }

    public String getNomeUsuario() {
        return nome_usuario;
    }

    public void setNomeUsuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getNomeCompleto() {
        return nome_completo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public void setNomeCompleto(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getUrlFoto() {
        return url_foto;
    }

    public void setUrlFoto(String url_foto) {
        this.url_foto = url_foto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public Date getData_mudanca() {
        return data_mudanca;
    }

    public void setData_mudanca(Date data_mudanca) {
        this.data_mudanca = data_mudanca;
    }

    public Date getData_desativacao() {
        return data_desativacao;
    }

    public void setData_desativacao(Date data_desativacao) {
        this.data_desativacao = data_desativacao;
    }

    public Date getDataNasc() {
        return data_nasc;
    }

    public void setDataNasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    @Override
    public String toString() {
        return "UsuariosModel{" +
                "pk_id=" + pk_id +
                ", fk_tb_tipos_sexos_id=" + fk_tb_tipos_sexos_id +
                ", nome_usuario='" + nome_usuario + '\'' +
                ", nome_completo='" + nome_completo + '\'' +
                ", url_foto='" + url_foto + '\'' +
                ", telefone='" + telefone + '\'' +
                ", bio ='" + bio + '\'' +
                ", email ='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", data_nasc='" + data_nasc + '\'' +
                ", data_criacao=" + data_criacao +
                ", data_mudanca=" + data_mudanca +
                ", data_desativacao=" + data_desativacao +
                '}';
    }
}
