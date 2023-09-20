package SecurityJAVA.JavaSpringsecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import SecurityJAVA.JavaSpringsecurity.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    // Esta consulta personalizada busca um usuário pelo nome de usuário
    @Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.username = :username")
    public User findByUsername(@Param("username") String username);
}

/*
* 
  interface UserRepository extends JpaRepository<User, Integer>: Esta interface estende JpaRepository, que é fornecida pelo Spring Data JPA. Ela especifica a classe de entidade User e o tipo da chave primária (neste caso, Integer). Isso permite que você use métodos herdados, como save, findById, findAll, etc., para interagir com objetos User no banco de dados.

@Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.username = :username"): Esta é uma consulta personalizada escrita usando a JPQL (Java Persistence Query Language). Ela seleciona um objeto User e carrega as funções (roles) relacionadas com ele pelo nome de usuário. A cláusula JOIN FETCH garante que as funções sejam carregadas imediatamente (EAGER).

public User findByUsername(@Param("username") String username): Este é um método de consulta personalizado que permite encontrar um usuário pelo nome de usuário. Ele usa a consulta JPQL definida acima e associa o parâmetro :username ao parâmetro do método username usando a anotação @Param. Isso permite que você busque um usuário pelo nome de usuário usando esta interface.

Este repositório é uma parte importante da sua aplicação, pois fornece métodos para acessar e manipular os dados dos usuários no banco de dados. Com ele, você pode buscar usuários por nome de usuário, salvar novos usuários, atualizar informações de usuários existentes e muito mais.

 */