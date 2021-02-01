package com.github.admin.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.github.admin.mapper.PostDynamicSqlSupport;
import com.github.admin.mapper.PostMapper;
import com.github.admin.model.Author;
import com.github.admin.model.Post;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

/**
 * @author wang lei
 * @version v0.1
 */
@Service
public class AuthorResolver implements GraphQLResolver<Author> {
    @Resource
    private PostMapper postMapper;

    public List<Post> getPosts(Author author) {
        return postMapper.select(c -> c.where(PostDynamicSqlSupport.authorId, isEqualTo(author.getId())));
    }
}
