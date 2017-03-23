package id.mdh.pilgubjateng.customclass;

import java.util.Date;

/**
 * Created by jonat on 10/11/2016.
 */

public class Forum {

    //variables all here
    private String forumTitle;
    private Date forumDateCreated;
    private String forumPost;
    private String postID;

    private String fullName;
    private int numberOfPosts;

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getForumTitle() {
        return forumTitle;
    }

    public void setForumTitle(String forumTitle) {
        this.forumTitle = forumTitle;
    }

    public Date getForumDateCreated() {
        return forumDateCreated;
    }

    public void setForumDateCreated(Date forumDateCreated) {
        this.forumDateCreated = forumDateCreated;
    }

    public String getForumPost() {
        return forumPost;
    }

    public void setForumPost(String forumPost) {
        this.forumPost = forumPost;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public void setNumberOfPosts(int numberOfPosts) {
        this.numberOfPosts = numberOfPosts;
    }
}
