package ru.netology

class NoteService : CrudService<Note, CommentToNote>() {
    override val elems = mutableListOf<Note>()

    override val comments = mutableListOf<CommentToNote>()

    override fun add(elem: Note): Note {
        super.add(elem)
        return elems.last().copy(id = elemId)
    }



    override fun createCommentWithCid (elemid: Int, comment: CommentToNote): Int {
        super.createCommentWithCid(elemid, comment)
        val newComment: CommentToNote = comment.copy(noteId = elemId)
        comments += newComment.copy(guid = newComment.hashCode())
        return super.createCommentWithCid(elemid, comment)
    }

    override fun getComments(noteIdent: Int, ownerId: Int, sort: Boolean, offset: Int, count: Int): String {
             comments.retainAll { CommentToNote().noteId == -1 }
        return super.getComments(noteIdent, ownerId, sort, offset, count)
    }

}