interface Attachment {
    val type: String
}

class AudioAttachment(
    override val type: String,
    val audio: Audio,
) : Attachment {
    // TODO
}

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String,
)

class DocumentAttachment(
    override val type: String,
    val document: Document,
) : Attachment {
    //TODO
}

data class Document(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val url: String,
    val date: Int,
)

class NoteAttachment(
    override val type: String,
    val note: Note,
) : Attachment {
    //TODO
}

data class Note(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val text: String,
    val date: Int,
    val comments: Int,
    val viewUrl: String,
    val privacyView: Array<String>,
    val canComment: Boolean,
) {
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

class PollAttachment(
    override val type: String,
    val poll: Poll,
) : Attachment {
    //TODO
}

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

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + ownerId
        result = 31 * result + created
        result = 31 * result + question.hashCode()
        result = 31 * result + votes
        result = 31 * result + answers.contentHashCode()
        return result
    }
}

data class Answer(
    // вспомогательный дата класс, который не относится к вложениям
    val id: Int,
    val text: String,
    val votes: Int,
    val rate: Double,
)

class PhotoAttachment(
    override val type: String,
    val photo: Photo,
) : Attachment {
    //TODO
}

data class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
    val width: Int,
    val height: Int,
)