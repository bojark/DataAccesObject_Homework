package ru.bojark.daohw.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.bojark.daohw.domain.Product;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DBRepo {
    private static final String QUERY_FILE_NAME = "script.sql";
    private final String query = read();
    @Autowired
    private JdbcTemplate template;
    public List<Product> fetchProduct(String name){

        return template.query(query,
                (rs, rowNum) -> {
                    return new Product(
                            rs.getString(1),
                            rs.getString(2)
                    );
                }, name);
    }


    private static String read(){
        try (InputStream is = new ClassPathResource(QUERY_FILE_NAME).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
