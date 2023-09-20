package SecurityJAVA.JavaSpringsecurity.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests -> {
                authorizeRequests
                    // Permite acesso público às URLs "/", "/login"
                    .antMatchers("/", "/login").permitAll()
                    // Exige a função (role) "MANAGERS" para acessar "/managers"
                    .antMatchers("/managers").hasAnyRole("MANAGERS")
                    // Exige as funções (roles) "USERS" ou "MANAGERS" para acessar "/users"
                    .antMatchers("/users").hasAnyRole("USERS", "MANAGERS")
                    // Qualquer outra solicitação requer autenticação
                    .anyRequest().authenticated();
            })
            // Usa autenticação básica (HTTP Basic)
            .httpBasic();
        }
}

    

    /*
     Este código é uma configuração de segurança do Spring Security para controlar o acesso às URLs em sua aplicação. Cada linha está comentada para explicar sua função:

@Configuration: Indica que esta classe é uma classe de configuração Spring.
@EnableWebSecurity: Ativa a segurança baseada na web.
@EnableGlobalMethodSecurity(prePostEnabled = true): Ativa a segurança global baseada em métodos, permitindo o uso de anotações @PreAuthorize e @PostAuthorize.
WebSecurityConfig extends WebSecurityConfigurerAdapter: Estende a classe de configuração do Spring Security.
Dentro do método configure(HttpSecurity http), você está configurando as regras de autorização e autenticação para URLs específicas:

antMatchers("/"): Permite acesso público à URL "/" (página inicial).
antMatchers("/login"): Permite acesso público à URL "/login".
antMatchers("/managers"): Exige a função (role) "MANAGERS" para acessar "/managers".
antMatchers("/users"): Exige as funções (roles) "USERS" ou "MANAGERS" para acessar "/users".
anyRequest().authenticated(): Qualquer outra solicitação requer autenticação.
.httpBasic(): Configura autenticação básica (HTTP Basic) para autenticar os usuários.
Essas configurações definem como as solicitações serão tratadas pelo Spring Security em termos de autenticação e autorização.
     */



