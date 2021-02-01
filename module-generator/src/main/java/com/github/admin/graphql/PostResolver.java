package com.github.admin.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.github.admin.mapper.AuthorDynamicSqlSupport;
import com.github.admin.mapper.AuthorMapper;
import com.github.admin.model.Author;
import com.github.admin.model.Post;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

/**
 * @author wang lei
 * @version v0.1
 */
@Service
public class PostResolver implements GraphQLResolver<Post> {
    @Resource
    private AuthorMapper authorMapper;

    public Author getAuthor(Post post) {
        Optional<Author> author = authorMapper.selectOne(c -> c.where(AuthorDynamicSqlSupport.id, isEqualTo(post.getAuthorId())));
        return author.orElseGet(Author::new);
    }
}
