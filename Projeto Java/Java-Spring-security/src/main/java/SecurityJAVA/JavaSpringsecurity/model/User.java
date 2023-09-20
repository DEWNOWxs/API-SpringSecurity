package SecurityJAVA.JavaSpringsecurity.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tab_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;
    
    @Column(length = 50, nullable = false)
    private String name;
    
    @Column(length = 20, nullable = false)
    private String username;
    
    @Column(length = 100, nullable = false)
    private String password;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tab_user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role_id")
    private List<String> roles = new ArrayList<>();

    // Construtores, getters e setters

    // Método construtor vazio
    public User() {
    }

    // Métodos getters e setters para as propriedades da classe

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}

/*
  @Entity: Esta anotação marca a classe como uma entidade JPA, o que significa que ela será mapeada para uma tabela no banco de dados.

@Table(name = "tab_user"): Especifica o nome da tabela no banco de dados onde esta entidade será armazenada.

@Id: Indica que o campo id é a chave primária da tabela.

@GeneratedValue(strategy = GenerationType.IDENTITY): Define a estratégia de geração de valores para a chave primária como identidade, o que é comum em bancos de dados que suportam autoincremento.

@Column(name = "id_user"): Especifica o nome da coluna no banco de dados que corresponde ao campo id.

@Column(length = 50, nullable = false): Especifica as propriedades da coluna name, incluindo o comprimento máximo e a restrição de não nulo.

@ElementCollection(fetch = FetchType.EAGER): Indica que a propriedade roles é uma coleção de elementos que será carregada imediatamente (EAGER) quando um objeto User for carregado.

@CollectionTable(name = "tab_user_roles", joinColumns = @JoinColumn(name = "user_id")): Especifica o nome da tabela de coleção e a coluna de junção usada para relacionar as funções (roles) com um usuário.

@Column(name = "role_id"): Especifica o nome da coluna que armazena as funções na tabela de coleção.

Métodos getters e setters: Esses métodos permitem acessar e modificar as propriedades da classe.

Construtores: Um construtor vazio padrão e outros construtores podem ser usados para criar instâncias da classe.

Esta classe User é uma representação da tabela no banco de dados que armazena informações sobre os usuários, incluindo seus nomes, nomes de usuário, senhas e funções (roles). É uma parte fundamental da sua aplicação de segurança.

 */

