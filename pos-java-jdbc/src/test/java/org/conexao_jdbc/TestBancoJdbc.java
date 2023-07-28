package org.conexao_jdbc;

import org.dao.UserPosDao;
import org.domain.model.UserPosJava;
import org.junit.Test;

import java.util.List;

public class TestBancoJdbc {

    @Test
    public void initDatabase() {
        SingleConnection.getConnection();
    }

    @Test
    public void registerUserTest() {
        UserPosDao userPosDao = new UserPosDao();
        UserPosJava userPosJava = new UserPosJava();

        userPosJava.setId(3L);
        userPosJava.setNome("Mauricio");
        userPosJava.setEmail("mauricio@gmail.com");

        userPosDao.save(userPosJava);
    }

    @Test
    public void findAllRegisterUserTest() throws Exception {
        UserPosDao userPosDao = new UserPosDao();

        List<UserPosJava> listUsers = userPosDao.findAll();

        listUsers.forEach(System.out::println);
    }

    @Test
    public void findById() throws  Exception{
        UserPosDao userPosDao = new UserPosDao();

        UserPosJava userPosJava = userPosDao.findById(3L);

        if (userPosJava == null) {
            System.out.println("Usuário não encontrado na consulta");
        } else {
            System.out.println(userPosJava);
        }
    }

}
