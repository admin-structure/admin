package com.github.admin.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.github.admin.mapper.PostMapper;
import com.github.admin.model.Post;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wang lei
 * @version v0.1
 */
@Service
public class Mutation implements GraphQLMutationResolver {
    @Resource
    private PostMapper postMapper;

    public Post writePost(String title, String text, String category) {
        Post post = new Post();
        post.setTitle(title);
        post.setText(text);
        post.setCategory(category);
        postMapper.insert(post);

        return post;
    }
}
