package SecurityJAVA.JavaSpringsecurity.Config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import SecurityJAVA.JavaSpringsecurity.Repository.UserRepository;
import SecurityJAVA.JavaSpringsecurity.model.User;

@Service
public class SecurityDatabaseService implements UserDetailsService {
    
    // Injeção de dependência do repositório do usuário
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) {
        // Procurar o usuário no banco de dados pelo nome de usuário
        User userEntity = userRepository.findByUsername(username);
        
        // Verificar se o usuário foi encontrado
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        
        // Criar um conjunto de autoridades para o usuário
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        
        // Iterar pelas funções (roles) do usuário e adicioná-las como autoridades
        userEntity.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        });
        
        // Criar um objeto UserDetails com as informações do usuário
        UserDetails user = new org.springframework.security.core.userdetails.User(
            userEntity.getUsername(),
            userEntity.getPassword(),
            authorities
        );
        
        // Retornar o UserDetails, que será usado pelo Spring Security para autenticação e autorização
        return user;
    }
}

/*
 Este código é um serviço Spring que implementa a interface UserDetailsService. Ele é responsável por carregar os detalhes do usuário a partir do banco de dados e convertê-los em um objeto UserDetails, que o Spring Security utiliza para autenticar e autorizar usuários durante o processo de login e controle de acesso. Cada linha do código está explicada nos comentários.
 */

