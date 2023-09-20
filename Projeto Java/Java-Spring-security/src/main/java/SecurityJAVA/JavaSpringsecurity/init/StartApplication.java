package SecurityJAVA.JavaSpringsecurity.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import SecurityJAVA.JavaSpringsecurity.Repository.UserRepository;
import SecurityJAVA.JavaSpringsecurity.model.User;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    // Esta anotação indica que o método deve ser executado quando a aplicação é iniciada.
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        // Procura um usuário com o nome de usuário "admin" no repositório.
        User user = repository.findByUsername("admin");
        if(user == null) {
            // Se não encontrar, cria um novo usuário com as seguintes informações.
            user = new User();
            user.setName("ADMIN");
            user.setUsername("admin");
            user.setPassword("master123");
            user.getRoles().add("MANAGERS");
            // Salva o usuário no repositório.
            repository.save(user);
        }
        // Procura um usuário com o nome de usuário "user" no repositório.
        user = repository.findByUsername("user");
        if(user == null) {
            // Se não encontrar, cria um novo usuário com as seguintes informações.
            user = new User();
            user.setName("USER");
            user.setUsername("user");
            user.setPassword("user123");
            user.getRoles().add("USERS");
            // Salva o usuário no repositório.
            repository.save(user);
        }
    }
}


/*

  import org.springframework.beans.factory.annotation.Autowired;: Importa a anotação Autowired para injetar dependências automaticamente.

import org.springframework.boot.CommandLineRunner;: Importa a interface CommandLineRunner, que permite executar código quando a aplicação Spring Boot é iniciada.

import org.springframework.stereotype.Component;: Importa a anotação Component, que marca a classe como um componente gerenciado pelo Spring.

import org.springframework.transaction.annotation.Transactional;: Importa a anotação Transactional, que indica que os métodos marcados com essa anotação devem ser executados em uma transação.

import SecurityJAVA.JavaSpringsecurity.Repository.UserRepository;: Importa a classe UserRepository, que é uma interface que fornece métodos para interagir com os dados dos usuários.

import SecurityJAVA.JavaSpringsecurity.model.User;: Importa a classe User, que representa um usuário na aplicação.

@Component: Marca a classe como um componente gerenciado pelo Spring.

public class StartApplication implements CommandLineRunner {: Declaração da classe StartApplication que implementa a interface CommandLineRunner.

@Autowired: Anotação que injeta automaticamente uma instância do UserRepository na classe.

private UserRepository repository;: Declaração do campo repository, que será usado para interagir com os dados dos usuários.

@Transactional: Indica que o método run deve ser executado em uma transação.

@Override: Indica que o método run está substituindo um método da interface CommandLineRunner.

27-71: Dentro do método run, o código realiza o seguinte:

Verifica se o usuário com o nome de usuário "admin" já existe no repositório. Se não existir, cria um novo usuário com nome "ADMIN", nome de usuário "admin", senha "master123" e atribui a função "MANAGERS". Em seguida, salva o usuário no repositório.

Realiza a mesma verificação para o usuário com o nome de usuário "user" e cria um usuário com nome "USER", nome de usuário "user", senha "user123" e atribui a função "USERS" se ele não existir no repositório.
Essa classe é responsável por criar dois usuários iniciais (admin e user) no banco de dados quando a aplicação é iniciada, caso esses usuários não existam.

 */
