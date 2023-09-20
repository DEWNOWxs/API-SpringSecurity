# API-SpringSecurity
Minha aplicação Spring Security tem como objetivo fornecer autenticação e autorização para diferentes URLs com base em regras de segurança. Ela também usa um banco de dados para armazenar informações de usuário e permissões.

Descrição das Classes:

WebSecurityConfig

Esta classe é uma configuração de segurança Spring.
@Configuration, @EnableWebSecurity, e @EnableGlobalMethodSecurity(prePostEnabled = true) são anotações usadas para configurar a classe para gerenciamento de segurança.
securityService é injetado usando @Autowired para carregar detalhes do usuário.
globalUserDetails configura o AuthenticationManagerBuilder para usar o serviço personalizado securityService e o NoOpPasswordEncoder para autenticação (não recomendado para produção).
configure define regras de autorização e autenticação para diferentes URLs. Por exemplo, permite o acesso a "/" e "/login" para todos, requerendo "MANAGERS" para "/managers" e "USERS" ou "MANAGERS" para "/users". Outras URLs exigem autenticação via HTTP básico.
SecurityDatabaseService

Esta classe é um serviço Spring que implementa UserDetailsService para carregar detalhes do usuário.
@Service marca a classe como um componente gerenciado pelo Spring.
userRepository é injetado para consultar informações do usuário no banco de dados.
loadUserByUsername é chamado durante a autenticação e carrega informações do usuário com base no nome de usuário fornecido. Se o usuário não for encontrado, lança uma exceção.
User

Esta classe é uma entidade JPA que representa informações de usuário no banco de dados.
Ela possui campos como id, name, username, password, e roles.
roles é uma coleção de permissões associadas ao usuário.
UserRepository

Interface que estende JpaRepository para permitir consultas ao banco de dados relacionadas aos usuários.
Funcionamento Geral:

A aplicação permite que os usuários acessem as URLs "/" e "/login" sem autenticação.
Para outras URLs, como "/managers" e "/users", exige que os usuários tenham os papéis corretos.
As informações do usuário são carregadas do banco de dados durante a autenticação usando o serviço personalizado SecurityDatabaseService.
A autenticação é realizada via autenticação HTTP básica.
Observações:

O uso de NoOpPasswordEncoder para autenticação é inseguro e não é recomendado para ambientes de produção. Considere usar um método de codificação de senha mais seguro.
As permissões dos usuários são armazenadas no campo roles, que é uma coleção de strings. Certifique-se de que os nomes dos papéis correspondam aos configurados na sua aplicação.
Esta aplicação fornece uma estrutura básica para autenticação e autorização usando Spring Security.
