package ru.netology

object WallService {
    private var posts = emptyArray<Post>()
    private var postId: Int = 0
    private var comments = emptyArray<Comment>()
    fun add(post: Post): Post {
        postId = post.hashCode()
        posts += post.copy(id = postId)
        return posts.last()
    }

    fun getId(index: Int) = if ((index >= 0) && (index <= posts.size)) posts[index].id else -2

    fun getSize(): Int {
        return posts.size
    }

    fun update(post: Post): Boolean {
        var flag = false
        for ((index, onePost) in posts.withIndex())
            if (post.id == onePost.id) {
                posts[index] = post.copy(ownerId = onePost.ownerId, date = onePost.date)
                flag = true
            }
        return flag
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        val initSize = comments.size
        for (i in posts.indices) {
            if (getId(i) == postId) {
                comments += comment

            }
        }
        val lastSize = comments.size
        if (initSize == lastSize) {
            throw PostNotFoundException("No post with id $postId")
        }
        return comment
    }
}

