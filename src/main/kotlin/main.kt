
import java.time.LocalDateTime

fun main() {
    val post1 = Post(0,
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
        donut = Donut(false, 0, "empty place", true, "all" ),
        postponedId = null
    )
    val post2 = Post(
        0,
        1,
        2,
        null,
        LocalDateTime.now().nano,
        "Why don't you sleeping??",
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
        geo = Geo("place2", "coordinates2"),
        signerId = null,
        copyHistory = null,
        canPin = false,
        canDelete = false,
        canEdit = false,
        isPinned = false,
        markedAsAds = false,
        isFavourite = true,
        donut = Donut(false, 0, "empty place", true, "all" ),
        postponedId = null

    )

    val post1Added: Post = WallService.add(post1)
    val post2Added: Post = WallService.add(post2)
    println(post1Added)
    println(post2Added)

    val post1Update = Post(
        WallService.posts[0].id,
        1,
        1,
        null,
        LocalDateTime.now().nano,
        "Hello, what's up?",
        null,
        null,
        false,
        comments = Comments(10, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
        copyright = Copyright(0, "https://...", "post", "post"),
        likes = Likes(15, userLikes = true, canLike = true, canPublish = true),
        reposts = Reposts(1, false),
        views = Views(20),
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
        donut = Donut(false, 0, "empty place", true, "all" ),
        postponedId = null
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
    val createdBy: Int?,
    val date: Int,
    val text: String,
    val replyOwnerId: Int?,
    val replyPostId: Int?,
    val friendsOnly: Boolean,
    val comments: Comments,
    val copyright: Copyright,
    val likes: Likes,
    val reposts: Reposts,
    val views: Views,
    val postType: String,
    val postSource: Postsource?,
    val geo: Geo,
    val signerId: Int?,
    val copyHistory: Array<Reposts>?,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavourite: Boolean,
    val donut: Donut,
    val postponedId: Int?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (id != other.id) return false
        if (ownerId != other.ownerId) return false
        if (fromId != other.fromId) return false
        if (date != other.date) return false
        if (text != other.text) return false
        if (friendsOnly != other.friendsOnly) return false
        if (comments != other.comments) return false
        if (copyright != other.copyright) return false
        if (likes != other.likes) return false
        if (reposts != other.reposts) return false
        if (views != other.views) return false
        if (postType != other.postType) return false
        if (geo != other.geo) return false
        if (canPin != other.canPin) return false
        if (canDelete != other.canDelete) return false
        if (canEdit != other.canEdit) return false
        if (isPinned != other.isPinned) return false
        if (markedAsAds != other.markedAsAds) return false
        if (isFavourite != other.isFavourite) return false
        if (donut != other.donut) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + ownerId
        result = 31 * result + fromId
        result = 31 * result + date
        result = 31 * result + text.hashCode()
        result = 31 * result + friendsOnly.hashCode()
        result = 31 * result + comments.hashCode()
        result = 31 * result + copyright.hashCode()
        result = 31 * result + likes.hashCode()
        result = 31 * result + reposts.hashCode()
        result = 31 * result + views.hashCode()
        result = 31 * result + postType.hashCode()
        result = 31 * result + geo.hashCode()
        result = 31 * result + canPin.hashCode()
        result = 31 * result + canDelete.hashCode()
        result = 31 * result + canEdit.hashCode()
        result = 31 * result + isPinned.hashCode()
        result = 31 * result + markedAsAds.hashCode()
        result = 31 * result + isFavourite.hashCode()
        result = 31 * result + donut.hashCode()
        return result
    }
}


data class Comments(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean,
)
data class Copyright(
    val id: Int,
    val link: String,
    val name: String,
    val type: String
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
data class Postsource(
    val type: String,
    val platform: String,
    val data: String,
    val url: String
)
data class Geo(
    val type: String,
    val coordinates: String
    )
data class Donut(
    val isDonut: Boolean,
    val paidDuration: Int,
    val placeholder: String?,
    val canPublishFreeCopy: Boolean,
    val editMode: String
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


