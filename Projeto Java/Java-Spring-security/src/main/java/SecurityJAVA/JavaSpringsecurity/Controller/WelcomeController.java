package SecurityJAVA.JavaSpringsecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    
    // Este endpoint é mapeado para a raiz ("/") da aplicação
    @GetMapping
    public String welcome(){
        return "Welcome to My Spring Boot Web API";
    }
    
    // Este endpoint é mapeado para "/users" e requer que o usuário tenha pelo menos um dos papéis "MANAGERS" ou "USERS"
    @GetMapping("/users")
    public String users() {
        return "Authorized user";
    }
    
    // Este endpoint é mapeado para "/managers" e requer que o usuário tenha o papel "MANAGERS"
    @GetMapping("/managers")
    public String managers() {
        return "Authorized manager";
    }
}


/*

 import org.springframework.web.bind.annotation.GetMapping;: Importa a classe GetMapping do Spring Framework para mapear solicitações HTTP GET para métodos específicos.

import org.springframework.web.bind.annotation.RestController;: Importa a anotação RestController do Spring Framework para indicar que esta classe é um controlador REST.

@RestController: Anotação que indica que esta classe é um controlador REST que retornará respostas HTTP diretamente em vez de renderizar visualizações.

public class WelcomeController {: Declaração da classe WelcomeController.
    
A partir daqui, temos três métodos mapeados como endpoints:

@GetMapping: Indica que este método responde a solicitações HTTP GET.

public String welcome() {: Início do método welcome.

return "Welcome to My Spring Boot Web API";: Retorna uma mensagem de boas-vindas como uma resposta à solicitação GET na raiz ("/") da aplicação.

}: Fim do método welcome.

@GetMapping("/users"): Indica que este método responde a solicitações HTTP GET em "/users".

public String users() {: Início do método users.

return "Authorized user";: Retorna uma mensagem indicando que o usuário está autorizado como resposta à solicitação GET em "/users".

}: Fim do método users.

@GetMapping("/managers"): Indica que este método responde a solicitações HTTP GET em "/managers".

public String managers() {: Início do método managers.

return "Authorized manager";: Retorna uma mensagem indicando que o usuário está autorizado como resposta à solicitação GET em "/managers".

}: Fim do método managers.

Essa classe define endpoints para sua API Spring Boot e especifica como eles devem responder a diferentes solicitações GET.

 */