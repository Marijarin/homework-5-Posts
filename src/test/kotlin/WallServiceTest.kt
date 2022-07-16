
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
            LocalDateTime.now().nano,
            "Hello, what's up?",
            false,
            Comments(2, true, true, true, true),
            Likes(2, true, true, true),
            Reposts(0, false),
            Views(3),
            true,
            true,
            true,
            false,
            false,
            false
        )
        val post2 = Post(
            0,
            10,
            10,
            LocalDateTime.now().nano,
            "My favourite breakfast is...",
            false,
            Comments(1, true, true, true, true),
            Likes(1, true, true, true),
            Reposts(0, false),
            Views(5),
            true,
            true,
            true,
            false,
            false,
            false
        )
        val post3 = Post(
            0,
            5,
            6,
            LocalDateTime.now().nano,
            "Here is my new car",
            false,
            Comments(10, true, true, true, true),
            Likes(10, true, true, true),
            Reposts(0, false),
            Views(10),
            true,
            true,
            true,
            false,
            false,
            false
        )
        val service = WallService
        service.add(post1)
        service.add(post2)
        service.add(post3)
        var result = true
        for (i in 0..service.posts.size - 1) {
            /*service.posts[i]= Post(
                0,
                1,
                1,
                LocalDateTime.now().nano,
                "Here is my new car",
                false,
                Comments(10, true, true, true, true),
                Likes(10, true, true, true),
                Reposts(0, false),
                Views(10),
                true,
                true,
                true,
                false,
                false,
                false
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
                LocalDateTime.now().nano,
                "Hello, what's up?",
                false,
                Comments(2, true, true, true, true),
                Likes(2, true, true, true),
                Reposts(0, false),
                Views(3),
                true,
                true,
                true,
                false,
                false,
                false
            )
        )
        service.add(
            Post(
                0,
                2,
                2,
                LocalDateTime.now().nano,
                "Where are you guys?",
                true,
                Comments(12, true, true, true, true),
                Likes(12, true, true, true),
                Reposts(1, true),
                Views(22),
                true,
                true,
                true,
                true,
                true,
                true
            )
        )
        service.add(
            Post(
                0,
                10,
                10,
                LocalDateTime.now().nano,
                "Hello, what's up?",
                false,
                Comments(10, false, false, false, false),
                Likes(10, false, false, false),
                Reposts(10, false),
                Views(10),
                false,
                false,
                false,
                false,
                false,
                false
            )
        )

        val update = Post(
            0,
            1,
            1,
            LocalDateTime.now().nano,
            "Hello, what's up?",
            false,
            Comments(2, true, true, true, true),
            Likes(2, true, true, true),
            Reposts(0, false),
            Views(3),
            true,
            true,
            true,
            false,
            false,
            false
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
                LocalDateTime.now().nano,
                "Hello, what's up?",
                false,
                Comments(2, true, true, true, true),
                Likes(2, true, true, true),
                Reposts(0, false),
                Views(3),
                true,
                true,
                true,
                false,
                false,
                false
            )
        )
        service.add(
            Post(
                0,
                2,
                2,
                LocalDateTime.now().nano,
                "Where are you guys?",
                true,
                Comments(12, true, true, true, true),
                Likes(12, true, true, true),
                Reposts(1, true),
                Views(22),
                true,
                true,
                true,
                true,
                true,
                true
            )
        )
        service.add(
            Post(
                0,
                10,
                10,
                LocalDateTime.now().nano,
                "Hello, what's up?",
                false,
                Comments(10, false, false, false, false),
                Likes(10, false, false, false),
                Reposts(10, false),
                Views(10),
                false,
                false,
                false,
                false,
                false,
                false
            )
        )

        val update = Post(
            service.posts[0].id,
            15,
            12,
            LocalDateTime.now().nano,
            "It's my new bag",
            false,
            Comments(0, true, true, true, true),
            Likes(0, true, true, true),
            Reposts(0, false),
            Views(3),
            true,
            true,
            true,
            false,
            false,
            false
        )


        val result = service.update(update)

        assertTrue(result)
    }
}
