package ru.netology
import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDateTime

class WallServiceTest {

    @Test
    fun addIdAddedNotZero() {
        val post1 = Post(
            text = "Hello, what's up?",
            comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
            copyright = Copyright(),
            likes = Likes(5, userLikes = true, canLike = true, canPublish = true),
            reposts = Reposts(1, false),
            views = Views(),
            postSource = PostSource(),
            geo = Geo(),
            donut = Donut(),
           attachments = emptyArray()
        )
        val post2 = Post(
            text = "Can you?",
            comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
            copyright = Copyright(),
            likes = Likes(5, userLikes = true, canLike = true, canPublish = true),
            reposts = Reposts(1, false),
            views = Views(),
            postSource = PostSource(),
            geo = Geo(),
            donut = Donut(),
            attachments = arrayOf(
                NoteAttachment(

                    Note(
                        2,
                        1,
                        "Wow",
                        "I found it, when came back home",
                        LocalDateTime.now().nano,
                        12,
                        "https://...",
                        arrayOf("firstProperty", "secondProperty"),
                        canComment = true
                    )
                )
            )

        )
        val post3 = Post(
            text = "What's up?",
            comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
            copyright = Copyright(),
            likes = Likes(5, userLikes = true, canLike = true, canPublish = true),
            reposts = Reposts(1, false),
            views = Views(),
            postSource = PostSource(),
            geo = Geo(),
            donut = Donut(),
            attachments = arrayOf(
                NoteAttachment(

                    Note(
                        2,
                        1,
                        "Wow",
                        "I found it, when came back home",
                        LocalDateTime.now().nano,
                        12,
                        "https://...",
                        arrayOf("firstProperty", "secondProperty"),
                        canComment = true
                    )
                ),
                PhotoAttachment(

                    Photo(
                        1, 2, 1, 1, " ", LocalDateTime.now().nano, 500, 300
                    )
                )
            )
        )
        val service = WallService
        service.add(post1)
        service.add(post2)
        service.add(post3)
        var result = true
        for (i in 0 until service.getSize()) {
            if (service.getId(i) == 0) {
                result = false
            }
        }
        assertTrue(result)
    }

    @Test

    fun updateExistingWithDifferentId() {

        val service = WallService

        service.add(
            Post(
                text = "Hell, what's up?",
                comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
                copyright = Copyright(),
                likes = Likes(5, userLikes = true, canLike = true, canPublish = true),
                reposts = Reposts(1, false),
                views = Views(),
                postSource = PostSource(),
                geo = Geo(),
                donut = Donut(),
                attachments = arrayOf(
                    NoteAttachment(

                        Note(
                            2,
                            1,
                            "Wow",
                            "I found it, when came back home",
                            LocalDateTime.now().nano,
                            12,
                            "https://...",
                            arrayOf("firstProperty", "secondProperty"),
                            canComment = true
                        )
                    ),
                    PhotoAttachment(

                        Photo(
                            1, 2, 1, 1, " ", LocalDateTime.now().nano, 500, 300
                        )
                    )
                )
            )
        )
        service.add(
            Post(
                text = "Hello, wh?",
                comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
                copyright = Copyright(),
                likes = Likes(5, userLikes = true, canLike = true, canPublish = true),
                reposts = Reposts(1, false),
                views = Views(),
                postSource = PostSource(),
                geo = Geo(),
                donut = Donut(),
                attachments = emptyArray()
            )
        )
        service.add(
            Post(
                text = "Hello?",
                comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
                copyright = Copyright(),
                likes = Likes(5, userLikes = true, canLike = true, canPublish = true),
                reposts = Reposts(1, false),
                views = Views(),
                postSource = PostSource(),
                geo = Geo(),
                donut = Donut(),
                attachments = arrayOf(
                    DocumentAttachment(

                        Document(
                            1,
                            1,
                            "Some facts",
                            100,
                            "pdf",
                            "https://...",
                            LocalDateTime.now().nano
                        )
                    )
                )

            )
        )

        val update = Post(
            text = "Hello, what's up?",
            comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
            copyright = Copyright(),
            likes = Likes(5, userLikes = true, canLike = true, canPublish = true),
            reposts = Reposts(1, false),
            views = Views(),
            postSource = PostSource(),
            geo = Geo(),
            donut = Donut(),
            attachments = arrayOf(
                NoteAttachment(

                    Note(
                        2,
                        1,
                        "New vibes",
                        "I am starting",
                        LocalDateTime.now().nano,
                        8,
                        "https://...",
                        arrayOf("firstProperty", "secondProperty"),
                        canComment = true
                    )
                ),
                PhotoAttachment(

                    Photo(
                        1, 2, 1, 1, " ", LocalDateTime.now().nano, 500, 300
                    )
                )
            )
        )


        val result = service.update(update)

        assertFalse(result)
    }

    @Test

    fun updateExistingWithSameId() {

        val service = WallService

        service.add(
            Post(
                text = "Hello, what's up?",
                comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
                copyright = Copyright(),
                likes = Likes(5, userLikes = true, canLike = true, canPublish = true),
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
                    )
                )
            )
        )
        service.add(
            Post(
                text = "Hello, what's up?",
                comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
                copyright = Copyright(),
                likes = Likes(5, userLikes = true, canLike = true, canPublish = true),
                reposts = Reposts(1, false),
                views = Views(),
                postSource = PostSource(),
                geo = Geo(),
                donut = Donut(),
                attachments = emptyArray()
            )
        )
        service.add(
            Post(
                text = "Hello, what's up?",
                comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
                copyright = Copyright(),
                likes = Likes(5, userLikes = true, canLike = true, canPublish = true),
                reposts = Reposts(1, false),
                views = Views(),
                postSource = PostSource(),
                geo = Geo(),
                donut = Donut(),
                attachments = arrayOf(
                    PollAttachment(

                        Poll(
                            1,
                            1,
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
                    )
                )
            )
        )

        val update = Post(
            id = service.getId(0),
            text = "Hello, what's up?",
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

                    Photo(3, 5, 1, 1, " ", LocalDateTime.now().nano, 100, 90)
                ),
                NoteAttachment(

                    Note(
                        2,
                        1,
                        "Wow",
                        "I found it, when came back home",
                        LocalDateTime.now().nano,
                        12,
                        "https://...",
                        arrayOf("firstProperty", "secondProperty"),
                        canComment = true
                    )
                ),
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
                )
            )
        )


        val result = service.update(update)

        assertTrue(result)
    }
}
