package ru.netology

import java.time.LocalDateTime

data class Post(
    val id: Int = -1,
    val ownerId: Int = 1,
    val fromId: Int = 1,
    val createdBy: Int? = null,
    val date: Int = LocalDateTime.now().nano,
    val text: String,
    val replyOwnerId: Int? = null,
    val replyPostId: Int? = null,
    val friendsOnly: Boolean = false,
    val comments: Comments,
    val copyright: Copyright,
    val likes: Likes,
    val reposts: Reposts,
    val views: Views,
    val postType: String = "post",
    val postSource: PostSource,
    val geo: Geo,
    val signerId: Int = 0,
    val copyHistory: Array<Reposts> = emptyArray(),
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = true,
    val markedAsAds: Boolean = true,
    val isFavourite: Boolean = true,
    val donut: Donut,
    val postponedId: Int? = null,
    val attachments: Array<Attachment>
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
    val id: Int = -1,
    val link: String = "https://...",
    val name: String = "post",
    val type: String = "post",
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
    val countViews: Int = 10,
)

data class PostSource(
    val type: String = "post",
    val platform: String = "thisPlatform",
    val data: String = "1234560",
    val url: String = "https://...",
)

data class Geo(
    val type: String = "place1",
    val coordinates: String = "coordinates1",
)

data class Donut(
    val isDonut: Boolean = false,
    val paidDuration: Int = 0,
    val placeholder: String = "empty place",
    val canPublishFreeCopy: Boolean = true,
    val editMode: String = "all",
)



