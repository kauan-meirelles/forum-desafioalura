package com.alura.forumhub.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String senha;

    // Implementação dos métodos da interface UserDetails

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Se não tiver papéis, pode retornar null ou Collections.emptyList()
        return null;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;  // Aqui, o username será o email
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Pode implementar lógica real se quiser
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Pode implementar lógica real se quiser
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Pode implementar lógica real se quiser
    }

    @Override
    public boolean isEnabled() {
        return true; // Pode implementar lógica real se quiser
    }
}
