package com.fernandez_market.Fernandez_Market.Services;

import com.fernandez_market.Fernandez_Market.Models.Usuarios;
import com.fernandez_market.Fernandez_Market.Repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void saveUsuario(Usuarios usuarioNuevo){
        this.usuarioRepository.save(usuarioNuevo);
    }

    public void updateUsuario(Usuarios usuarioActualizar){
        this.usuarioRepository.save(usuarioActualizar);
    }

    public Optional<Usuarios> getUsuarioById(long idUsuario){
        return this.usuarioRepository.findById(idUsuario);
    }

    public List<Usuarios> getUsuarios(){
        return this.usuarioRepository.findAll();
    }

    public Usuarios getUsuariosByEmail(String CorreoUsuario){
        return this.usuarioRepository.findByCorreoUsuario(CorreoUsuario);
    }

    public Usuarios getUsuariosByEmailPassword(String CorreoUsuario, String PasswordUsuario){
        return this.usuarioRepository.findByCorreoUsuarioAndPasswordUsuario(CorreoUsuario, PasswordUsuario);
    }
}
