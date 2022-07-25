package ru.netology

import java.time.LocalDateTime

data class Comment(
    val id: Int = -1,
    val fromId: Int = -1,
    val date: Int = LocalDateTime.now().nano,
    val text: String = "This is the text of a comment",
    val donut: DonutInfo = DonutInfo(),
    val replyToUser: Int? = -1,
    val replyToComment: Int? = null,
    val attachments: Array<Attachment> = emptyArray(),
    val parentsStack: Array<Int> = emptyArray(),
    val thread: ThreadOfComments = ThreadOfComments()
)
{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Comment

        if (id != other.id) return false
        if (fromId != other.fromId) return false
        if (date != other.date) return false
        if (text != other.text) return false
        if (donut != other.donut) return false
        if (replyToUser != other.replyToUser) return false
        if (replyToComment != other.replyToComment) return false
        if (!attachments.contentEquals(other.attachments)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + fromId
        result = 31 * result + date
        result = 31 * result + text.hashCode()
        result = 31 * result + donut.hashCode()
        result = 31 * result + (replyToUser ?: 0)
        result = 31 * result + (replyToComment ?: 0)
        result = 31 * result + attachments.contentHashCode()
        return result
    }
}

data class DonutInfo(
    val isDon: Boolean = false,
    val placeholder: String = "empty place"
)

data class ThreadOfComments(
    val count: Int = -1,
    val items: Array<Comment> = emptyArray(),
    val canPost: Boolean = true,
    val showReplyAction: Boolean = false,
    val groupsCanPost: Boolean = false
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ThreadOfComments

        if (count != other.count) return false
        if (!items.contentEquals(other.items)) return false
        if (canPost != other.canPost) return false
        if (showReplyAction != other.showReplyAction) return false
        if (groupsCanPost != other.groupsCanPost) return false

        return true
    }

    override fun hashCode(): Int {
        var result = count
        result = 31 * result + items.contentHashCode()
        result = 31 * result + canPost.hashCode()
        result = 31 * result + showReplyAction.hashCode()
        result = 31 * result + groupsCanPost.hashCode()
        return result
    }
}

