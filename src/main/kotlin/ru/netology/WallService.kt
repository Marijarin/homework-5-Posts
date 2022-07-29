package ru.netology

object WallService : CrudService<Post, Comment>() {
    override val elems = mutableListOf<Post>()
    override val comments = mutableListOf<Comment>()
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

    override fun add(elem: Post): Post {
        super.add(elem)
        return elems.last().copy(id = elemId)
    }
    fun createComment(elemId: Int, comment: Comment): Comment {
        val initSize = comments.size
        for (i in elems.indices) {
            if (elemIds[i] == elemId) {
                comments += comment
                break
            }
        }
        val lastSize = comments.size
        if (initSize == lastSize) {
            throw PostNotFoundException("No post with id $elemId")
        }
        return comments.last()
    }
    fun reportAbuseInComment(abuseComment: Comment): Comment {
        if (comments.isNotEmpty()) {
            for (comment in comments) {
                if (abuseComment.id == comment.id && abuseComment.fromId == comment.fromId) {
                    println(
                        "\n Вы хотите пожаловаться на комментарий с номером ${abuseComment.id}." +
                                "\n Для завершения жалобы выберите, пожалуйста, ее причину." +
                                "\n Введите код причины из предложенных ниже и нажмите Enter" +
                                "\n ${reason.contentToString()}"
                    )
                    val userInput = readLine()?.toInt()
                    if (userInput != null && (userInput >= 0 && userInput <= reason.size)) {
                        reportsAbuse += abuseComment

                    } else throw IllegalArgumentException("Неверный код причины для жалобы")
                    break
                } else throw CommentNotFoundException("Comment not found")
            }
        } else throw CommentNotFoundException("Comment not found")
        return reportsAbuse.last()
    }
}

