
import java.time.LocalDateTime

fun main() {
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
        1,
        1,
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

    val post1Added: Post = WallService.add(post1)
    val post2Added: Post = WallService.add(post2)
    println(post1Added)
    println(post2Added)

    val post1Update = Post(
        WallService.posts[0].id,
        1,
        1,
        LocalDateTime.now().nano,
        "I need help",
        false,
        Comments(5, true, false, false, false),
        Likes(1, true, true, true),
        Reposts(0, false),
        Views(10),
        true,
        true,
        true,
        false,
        false,
        false
    )

    val post1Updated = WallService.update(post1Update)
    val post2Updated = WallService.update(post1)

    println(post1Updated)
    println(post2Updated)
    println(WallService.posts[0])

}

data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val friendsOnly: Boolean,
    val comments: Comments,
    val likes: Likes,
    val reposts: Reposts,
    val views: Views,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavourite: Boolean,
)

data class Comments(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean,
)

data class Likes(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean,
)

data class Reposts(
    val usersCount: Int,
    val userReposted: Boolean,
)

data class Views(
    val countViews: Int,
)


object WallService {
    internal var posts = emptyArray<Post>()
    private var postId: Int = 0
    fun add(post: Post): Post {
        postId = post.hashCode()
        posts += post.copy(id = postId)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        var flag = false
        for ((index, onePost) in posts.withIndex())
            if (post.id == onePost.id) {
                posts[index] = post.copy(ownerId = onePost.ownerId, date = onePost.date)
                flag = true
            }
        return flag
    }
}


