package com.github.admin.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.github.admin.mapper.PostMapper;
import com.github.admin.model.Post;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version v0.1
 * @author wang lei
 */
@Service
public class Query implements GraphQLQueryResolver {
    @Resource
    private PostMapper postMapper;

    public List<Post> getRecentPosts(int count, int offset) {
        return postMapper.select(c -> c);
    }
}
