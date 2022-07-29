package ru.netology

abstract class CrudService<T, K> {
    open val elems = mutableListOf<T>()
    open val elemIds = mutableListOf<Int>()
    open val comments = mutableListOf<K>()
    open val commentIds = mutableListOf<Int>()
    open val elemsDeleted = mutableListOf<T>()
    open val elemIdsDeleted = mutableListOf<Int>()
    open val commentsDeleted = mutableListOf<K>()
    open val commentIdsDeleted = mutableListOf<Int>()
    open var elemId: Int = 0

    open fun add(elem: T): T {
        elemId = elem.hashCode()
        elemIds += elemId
        elems += elem
        return elems.last()
    }

    open fun getId(index: Int) = if ((index >= 0) && (index <= elems.size)) elemIds[index] else -2

    open fun getSize(): Int {
        return WallService.elems.size
    }

    open fun update(elem: T, id: Int): Boolean {
        var flag = false
        for ((index) in elems.withIndex())
            if (elemIds[index] == id) {
                elems[index] = elem
                flag = true
            }
        return flag
    }

    open fun delete(elemId: Int): Int {
        if (!elemIds.contains(elemId)) {
            return 0
        } else {
            for ((index, id) in elemIds.withIndex()) {
                if (elemId == id) {
                    elemsDeleted += elems[index]
                    elemIdsDeleted += elemIds[index]
                    elems.remove(elems[index])
                    elemIds.remove(elemIds[index])
                    break
                }
            }
        }
        return 1
    }

    open fun get(): String {
        return elems.toString()
    }

    open fun getById(elemid: Int): T {
       for ((index, id) in elemIds.withIndex()) {
            if (elemid == id) {
                elems[index]
                break
            } else throw NoteNotFoundException("No note with $elemid")
        }
        return elems[elemIds.indexOf(elemid)]
    }

    open fun createCommentWithCid(elemid: Int, comment: K): Int {
        if (!elemIds.contains(elemId)) {
            throw ElementNotFoundException("No element with $elemId")
        }
        val cid = comment.hashCode()
        //comments += comment
        commentIds += cid
        return cid
    }

    open fun getComments(noteIdent: Int, ownerId: Int, sort: Boolean, offset: Int = 0, count: Int = 1): String {
        val s: String
        if (elemIds.contains(noteIdent) && offset<=comments.size && (offset + count)<comments.size) {
            s = when (sort) {
                true -> comments.slice(offset..(offset + count)).toString()
                false -> comments.slice(offset..(offset + count)).asReversed().toString()
            }
        } else throw NoteNotFoundException("No note with $noteIdent")
        return s
    }

    open fun editComment(comment: K, cid: Int): Boolean {
        var flag = false
        for ((index, ) in comments.withIndex()) {
            if (commentIds[index] == cid) {
                comments[index] = comment
                flag = true
            }
        }
        return flag
    }

    open fun deleteComment(commentId: Int): Int {
        if (!commentIds.contains(commentId)) {
            return 0
        } else {
            for ((index, id) in commentIds.withIndex()) {
                if (commentId == id) {
                    commentsDeleted += comments[index]
                    commentIdsDeleted += commentIds[index]
                    comments.remove(comments[index])
                    commentIds.remove(commentIds[index])
                    break
                }
            }
        }
        return 1
    }

    open fun getFriendsNotes(ownerId: Int, offset: Int, count: Int): String {
        return elems.slice(offset..(offset + count)).toString()
    }

    open fun restoreComment(commentId: Int): Int {
        if (!commentIdsDeleted.contains(commentId)) {
            return 0
        } else {
            for ((index, id) in commentIdsDeleted.withIndex()) {
                if (commentId == id) {
                    comments += comments[index]
                    commentIds += commentIds[index]
                    commentsDeleted.remove(comments[index])
                    commentIdsDeleted.remove(commentIds[index])
                    break
                }
            }
        }
        return 1
    }
}

