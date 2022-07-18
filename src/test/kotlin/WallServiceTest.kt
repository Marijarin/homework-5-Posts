import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDateTime

class WallServiceTest {

    @Test
    fun addIdAddedNotZero() {
        val post1 = Post(
            0,
            1,
            1,
            null,
            LocalDateTime.now().nano,
            "Hello",
            null,
            null,
            false,
            Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
            Copyright(0, "https://...", "post", "post"),
            Likes(5, userLikes = true, canLike = true, canPublish = true),
            Reposts(1, false),
            Views(5),
            "post",
            null,
            Geo("place1", "coordinates1"),
            null,
            null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = false,
            isFavourite = false,
            donut = Donut(false, 0, "empty place", true, "all"),
            postponedId = null,
            null
        )
        val post2 = Post(
            0,
            1,
            1,
            null,
            LocalDateTime.now().nano,
            "Can you guess?",
            null,
            null,
            false,
            comments = Comments(10, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
            copyright = Copyright(0, "https://...", "post", "post"),
            likes = Likes(5, userLikes = true, canLike = true, canPublish = true),
            reposts = Reposts(1, false),
            views = Views(15),
            postType = "post",
            postSource = null,
            geo = Geo("place1", "coordinates1"),
            signerId = null,
            copyHistory = null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = false,
            isFavourite = false,
            donut = Donut(false, 0, "empty place", true, "all"),
            postponedId = null,
            arrayOf(
                NoteAttachment(
                    "note",
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
            0,
            1,
            1,
            null,
            LocalDateTime.now().nano,
            "My new car",
            null,
            null,
            false,
            comments = Comments(12, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
            copyright = Copyright(0, "https://...", "post", "post"),
            likes = Likes(5, userLikes = true, canLike = true, canPublish = true),
            reposts = Reposts(1, false),
            views = Views(20),
            postType = "post",
            postSource = null,
            geo = Geo("place2", "coordinates2"),
            signerId = null,
            copyHistory = null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = false,
            isFavourite = false,
            donut = Donut(false, 0, "empty place", true, "all"),
            postponedId = null,
            arrayOf(
                NoteAttachment(
                    "note",
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
                    "photo",
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
        for (i in 0 until service.posts.size) {
            /*service.posts[i]= Post(0,
            1,
            1,
            null,
            LocalDateTime.now().nano,
            "My new car",
            null,
            null,
            false,
            comments = Comments(12, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
            copyright = Copyright(0, "https://...", "post", "post"),
            likes = Likes(5, userLikes = true, canLike = true, canPublish = true),
            reposts = Reposts(1, false),
            views = Views(20),
            postType = "post",
            postSource = null,
            geo = Geo("place2", "coordinates2"),
            signerId = null,
            copyHistory = null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = false,
            isFavourite = false,
            donut = Donut(false, 0, "empty place", true, "all" ),
            postponedId = null,
            null
            )*/
            if (service.posts[i].id == 0) {
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
                0,
                1,
                1,
                null,
                LocalDateTime.now().nano,
                "Hello",
                null,
                null,
                false,
                comments = Comments(0, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
                copyright = Copyright(0, "https://...", "post", "post"),
                likes = Likes(0, userLikes = true, canLike = true, canPublish = true),
                reposts = Reposts(0, false),
                views = Views(0),
                postType = "post",
                postSource = null,
                geo = Geo("place1", "coordinates1"),
                signerId = null,
                copyHistory = null,
                canPin = true,
                canDelete = true,
                canEdit = true,
                isPinned = true,
                markedAsAds = false,
                isFavourite = false,
                donut = Donut(false, 0, "empty place", true, "all"),
                postponedId = null,
                arrayOf(
                    NoteAttachment(
                        "note",
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
                        "photo",
                        Photo(
                            1, 2, 1, 1, " ", LocalDateTime.now().nano, 500, 300
                        )
                    )
                )
            )
        )
        service.add(
            Post(
                0,
                1,
                1,
                null,
                LocalDateTime.now().nano,
                "I will be there next week",
                null,
                null,
                false,
                comments = Comments(100, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
                copyright = Copyright(0, "https://...", "post", "post"),
                likes = Likes(5, userLikes = true, canLike = true, canPublish = true),
                reposts = Reposts(1, false),
                views = Views(500),
                postType = "post",
                postSource = null,
                geo = Geo("place1", "coordinates1"),
                signerId = null,
                copyHistory = null,
                canPin = true,
                canDelete = true,
                canEdit = true,
                isPinned = true,
                markedAsAds = false,
                isFavourite = false,
                donut = Donut(false, 0, "empty place", true, "all"),
                postponedId = null,
                null
            )
        )
        service.add(
            Post(
                0,
                1,
                1,
                null,
                LocalDateTime.now().nano,
                "How are you?",
                null,
                null,
                false,
                Comments(10, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
                Copyright(0, "https://...", "post", "post"),
                Likes(10, userLikes = true, canLike = true, canPublish = true),
                Reposts(0, false),
                Views(10),
                "post",
                null,
                Geo("place1", "coordinates1"),
                null,
                null,
                canPin = true,
                canDelete = true,
                canEdit = true,
                isPinned = true,
                markedAsAds = false,
                isFavourite = false,
                donut = Donut(false, 0, "empty place", true, "all"),
                postponedId = null,
                arrayOf(
                    DocumentAttachment(
                        "document",
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
            0,
            1,
            1,
            null,
            LocalDateTime.now().nano,
            "Hello",
            null,
            null,
            false,
            comments = Comments(0, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
            copyright = Copyright(0, "https://...", "post", "post"),
            likes = Likes(0, userLikes = true, canLike = true, canPublish = true),
            reposts = Reposts(0, false),
            views = Views(0),
            postType = "post",
            postSource = null,
            geo = Geo("place1", "coordinates1"),
            signerId = null,
            copyHistory = null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = false,
            isFavourite = false,
            donut = Donut(false, 0, "empty place", true, "all"),
            postponedId = null,
            arrayOf(
                NoteAttachment(
                    "note",
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
                    "photo",
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
                0,
                1,
                1,
                null,
                LocalDateTime.now().nano,
                "It's my friend",
                null,
                null,
                false,
                Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
                Copyright(0, "https://...", "post", "post"),
                likes = Likes(5, userLikes = true, canLike = true, canPublish = true),
                reposts = Reposts(1, false),
                views = Views(5),
                postType = "post",
                postSource = null,
                geo = Geo("place1", "coordinates1"),
                signerId = null,
                copyHistory = null,
                canPin = true,
                canDelete = true,
                canEdit = true,
                isPinned = true,
                markedAsAds = false,
                isFavourite = false,
                donut = Donut(false, 0, "empty place", true, "all"),
                postponedId = null,
                arrayOf(
                    PollAttachment(
                        "poll",
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
                0,
                1,
                1,
                null,
                LocalDateTime.now().nano,
                "Hello",
                null,
                null,
                false,
                Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
                Copyright(0, "https://...", "post", "post"),
                likes = Likes(5, userLikes = true, canLike = true, canPublish = true),
                reposts = Reposts(1, false),
                views = Views(5),
                postType = "post",
                postSource = null,
                geo = Geo("place2", "coordinates2"),
                signerId = null,
                copyHistory = null,
                canPin = true,
                canDelete = true,
                canEdit = true,
                isPinned = true,
                markedAsAds = false,
                isFavourite = false,
                donut = Donut(false, 0, "empty place", true, "all"),
                postponedId = null,
                null
            )
        )
        service.add(
            Post(
                0,
                1,
                1,
                null,
                LocalDateTime.now().nano,
                "Hello",
                null,
                null,
                false,
                Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
                Copyright(0, "https://...", "post", "post"),
                likes = Likes(5, userLikes = true, canLike = true, canPublish = true),
                reposts = Reposts(1, false),
                views = Views(5),
                postType = "post",
                postSource = null,
                geo = Geo("place1", "coordinates1"),
                signerId = null,
                copyHistory = null,
                canPin = true,
                canDelete = true,
                canEdit = true,
                isPinned = true,
                markedAsAds = false,
                isFavourite = false,
                donut = Donut(false, 0, "empty place", true, "all"),
                postponedId = null,
                arrayOf(
                    PollAttachment(
                        "poll",
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
            service.posts[0].id,
            1,
            1,
            null,
            LocalDateTime.now().nano,
            "Hello",
            null,
            null,
            false,
            comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
            copyright = Copyright(0, "https://...", "post", "post"),
            likes = Likes(5, userLikes = true, canLike = true, canPublish = true),
            reposts = Reposts(1, false),
            views = Views(5),
            postType = "post",
            postSource = null,
            geo = Geo("place1", "coordinates1"),
            signerId = null,
            copyHistory = null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = false,
            isFavourite = false,
            donut = Donut(false, 0, "empty place", true, "all"),
            postponedId = null,
            arrayOf(
                PhotoAttachment(
                    "photo",
                    Photo(3, 5, 1, 1, " ", LocalDateTime.now().nano, 100, 90)
                ),
                NoteAttachment(
                    "note",
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


        val result = service.update(update)

        assertTrue(result)
    }
}
