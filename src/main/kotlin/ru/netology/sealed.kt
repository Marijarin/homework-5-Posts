package ru.netology
sealed class Attachment(val type: String)

data class AudioAttachment (val audio: Audio) : Attachment ("audio")

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String,
)

data class DocumentAttachment(val document: Document) : Attachment ("document")

data class Document(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val url: String,
    val date: Int,
)

data class NoteAttachment(val note: Note) : Attachment ("note")

data class Note(
    val id: Int = -1,
    val ownerId: Int = -1,
    val title: String = "A note",
    val text: String = "A text of the note",
    val date: Int = 0,
    val comments: Int = 0,
    val viewUrl: String = "url here",
    val privacyView: Array<String> = emptyArray(),
    val canComment: Boolean = true
)  {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Note

        if (id != other.id) return false
        if (ownerId != other.ownerId) return false
        if (title != other.title) return false
        if (text != other.text) return false
        if (date != other.date) return false
        if (comments != other.comments) return false
        if (viewUrl != other.viewUrl) return false
        if (!privacyView.contentEquals(other.privacyView)) return false
        if (canComment != other.canComment) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + ownerId
        result = 31 * result + title.hashCode()
        result = 31 * result + text.hashCode()
        result = 31 * result + date
        result = 31 * result + comments
        result = 31 * result + viewUrl.hashCode()
        result = 31 * result + privacyView.contentHashCode()
        result = 31 * result + canComment.hashCode()
        return result
    }
}

data class PollAttachment (val poll: Poll): Attachment ("poll")

data class Poll(
    val id: Int,
    val ownerId: Int,
    val created: Int,
    val question: String,
    val votes: Int,
    val answers: Array<Answer>,
    val anonymous: Boolean,
    val multiple: Boolean,
    val endDate: Int,
    val closed: Boolean,
    val canEdit: Boolean,
    val canVote: Boolean,
    val canReport: Boolean,
    val canShare: Boolean,
    val authorId: Int,
    val photo: Photo,
    val friends: Array<Int>,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Poll

        if (id != other.id) return false
        if (ownerId != other.ownerId) return false
        if (created != other.created) return false
        if (question != other.question) return false
        if (votes != other.votes) return false
        if (!answers.contentEquals(other.answers)) return false
        if (anonymous != other.anonymous) return false
        if (multiple != other.multiple) return false
        if (endDate != other.endDate) return false
        if (closed != other.closed) return false
        if (canEdit != other.canEdit) return false
        if (canVote != other.canVote) return false
        if (canReport != other.canReport) return false
        if (canShare != other.canShare) return false
        if (authorId != other.authorId) return false
        if (photo != other.photo) return false
        if (!friends.contentEquals(other.friends)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + ownerId
        result = 31 * result + created
        result = 31 * result + question.hashCode()
        result = 31 * result + votes
        result = 31 * result + answers.contentHashCode()
        result = 31 * result + anonymous.hashCode()
        result = 31 * result + multiple.hashCode()
        result = 31 * result + endDate
        result = 31 * result + closed.hashCode()
        result = 31 * result + canEdit.hashCode()
        result = 31 * result + canVote.hashCode()
        result = 31 * result + canReport.hashCode()
        result = 31 * result + canShare.hashCode()
        result = 31 * result + authorId
        result = 31 * result + photo.hashCode()
        result = 31 * result + friends.contentHashCode()
        return result
    }
}

data class Answer(
    // вспомогательный дата класс, который не относится к вложениям
    val id: Int,
    val text: String,
    val votes: Int,
    val rate: Double
)

data class PhotoAttachment (val photo: Photo) : Attachment ("photo")

data class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
    val width: Int,
    val height: Int
)


