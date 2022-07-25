package ru.netology

object WallService {
    private var posts = emptyArray<Post>()
    private var postId: Int = 0
    private var comments = emptyArray<Comment>()
    private var reportsAbuse = emptyArray<Comment>()
    private val reason = arrayOf(
        "0 — спам",
        "1 — детская порнография",
        "2 — экстремизм",
        "3 — насилие",
        "4 — пропаганда наркотиков",
        "5 — материал для взрослых",
        "6 — оскорбление",
        "8 — призывы к суициду"
    )

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
                break
            }
        }
        val lastSize = comments.size
        if (initSize == lastSize) {
            throw PostNotFoundException("No post with id $postId")
        }
        return comments.last()
    }

    fun reportAbuseInComment(abuseComment: Comment): Comment {
        val initSize = reportsAbuse.size
        if (comments.isNotEmpty()) {
            for (comment in comments) {
                if (abuseComment.id == comment.id && abuseComment.fromId == comment.fromId) {
                    println(
                        "Вы хотите пожаловаться на комментарий с номером ${abuseComment.id}. " +
                                "Для завершения жалобы выберите, пожалуйста, ее причину." +
                                " Введите код причины из предложенных ниже и нажмите Enter " +
                                "\n ${reason.contentToString()}"
                    )
                    val userInput = readLine()?.toInt()
                    if (userInput != null && (userInput >= 0 && userInput <= reason.size)) {
                        reportsAbuse += abuseComment

                    } else throw IllegalArgumentException("Неверный код причины для жалобы")
                    break
                } else throw CommentNotFoundException("Comment not found")
            }
            val lastSize = reportsAbuse.size
            if (initSize == lastSize) {
                throw CommentNotFoundException("Comment not found")
            }
        } else throw CommentNotFoundException("Comment not found")
        return reportsAbuse.last()
    }
}

