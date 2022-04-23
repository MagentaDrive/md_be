package magentadrive.post_service.service;


import magentadrive.post_service.model.Comment;

import java.util.List;
import java.util.UUID;

public interface CommentService {

    void addCommentToPost(Comment c);

    void deleteComment(UUID commentId);

    List<Comment> getCommentsFromPost(UUID postId);
}
