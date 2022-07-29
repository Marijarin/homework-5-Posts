package ru.netology


import java.time.LocalDateTime

fun main() {
    val post1 = Post(
        text = "Hello",
        comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
        copyright = Copyright(),
        likes = Likes(5, userLikes = true, canLike = true, canPublish = true),
        reposts = Reposts(1, false),
        views = Views(),
        postSource = PostSource(),
        geo = Geo(),
        donut = Donut(),
        attachments = arrayOf(
            PhotoAttachment(

                Photo(1, 2, 1, 1, "Morning", LocalDateTime.now().nano, 500, 300)
            )
        )
    )
    val post2 = Post(
        text = "Wow",
        comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
        copyright = Copyright(),
        likes = Likes(5, userLikes = true, canLike = true, canPublish = true),
        reposts = Reposts(1, false),
        views = Views(),
        postSource = PostSource(),
        geo = Geo(),
        donut = Donut(),
        attachments = arrayOf(
            AudioAttachment(
                Audio(
                    1,
                    1,
                    "Various artists",
                    "Lullaby",
                    300,
                    "https://..."
                )
            )
        )

    )
    val noteService = NoteService()
    val post1Added: Post = WallService.add(post1)
    val post2Added: Post = WallService.add(post2)
    val note1 = Note(text = "First note")
    val note2 = Note(text = "Second note")
    val noteUpd = Note(text = "Updated note")
    val note1Added: Note = noteService.add(note1)
    val note2Added: Note = noteService.add(note2)
    println(noteService.getById(note1Added.id))
    println(
        noteService.createCommentWithCid(
            note2Added.id,
            CommentToNote(message = "First comment to the second note")
        )
    )
    println(
        noteService.createCommentWithCid(
            note2Added.id,
            CommentToNote(message = "Second comment to the second note")
        )
    )
    println(
        noteService.createCommentWithCid(
            note1Added.id,
            CommentToNote(message = "First comment to the first note")
        )
    )
    println(noteService.getComments(note2Added.id, note2Added.ownerId, false))
    println(noteService.update(noteUpd, noteService.elemIds[0]))
    println(noteService.editComment(CommentToNote(message = "Comment was edited"), noteService.commentIds[1]))
    println(noteService.deleteComment(noteService.commentIds[0]))
    println(noteService.restoreComment(noteService.commentIds[0]))
    println(noteService.get())
    println(noteService.comments.toString())
    println(noteService.getComments(note1Added.id, note1Added.ownerId, true))
    println(post1Added)
    println(post2Added)

    println(noteService.delete(/*NoteService.getId(0)*/0))
    println(noteService.get())
    val post1Update = Post(
        id = WallService.getId(0),
        date = post1.date,
        text = "Hello, what's up?",
        comments = Comments(10, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
        copyright = Copyright(),
        likes = Likes(15, userLikes = true, canLike = true, canPublish = true),
        reposts = Reposts(1, false),
        views = Views(),
        postSource = PostSource(),
        geo = Geo(),
        donut = Donut(),
        attachments = arrayOf(
            PollAttachment(

                Poll(
                    10,
                    11,
                    LocalDateTime.now().nano,
                    "Can you?",
                    1,
                    arrayOf(Answer(2, "Yes", 1, 1.0)),
                    false,
                    multiple = true,
                    0,
                    closed = false,
                    canEdit = true,
                    canVote = true,
                    true,
                    canShare = true,
                    1,
                    Photo(3, 5, 1, 1, " ", LocalDateTime.now().nano, 100, 90),
                    arrayOf(3, 4, 5)
                )
            ),
            AudioAttachment(
                Audio(
                    1,
                    1,
                    "Various artists",
                    "Lullaby",
                    300,
                    "https://..."
                )
            )
        )
    )

    val post1Updated = WallService.update(post1Update, WallService.getId(0))
    val post2Updated = WallService.update(post2, 0)

    println(post1Updated)
    println(post2Updated)
    println(post1Update)

    val newComment = WallService.createComment(
        WallService.getId(0),
        Comment(text = "This is the first comment here")
    )
    println(newComment)
    /*val nonExistingComment = WallService.createComment(0, Comment())
    println(nonExistingComment)*/
    val abuse = WallService.createComment(
        WallService.getId(0),
        Comment(text = "This is an example of abuse")
    )
    val complaint = WallService.reportAbuseInComment(abuse)
    println(complaint)

}

class PostNotFoundException(message: String) : RuntimeException(message)

class CommentNotFoundException(message: String) : RuntimeException(message)

class NoteNotFoundException(message: String) : RuntimeException(message)

class ElementNotFoundException(message: String) : RuntimeException(message)

