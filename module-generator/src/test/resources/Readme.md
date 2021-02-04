http://localhost/graphiql

query {
    recentPosts(count: 2, offset: 0) {
      id
      title
      author {
        id
        name
        posts {
          id
          title
        }
      }
    }
  }