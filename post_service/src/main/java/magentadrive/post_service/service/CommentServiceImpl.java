package magentadrive.post_service.service;


import magentadrive.post_service.model.Comment;
import magentadrive.post_service.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service

public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepo repo;

    @Override
    public void addCommentToPost(Comment c) {repo.save(c);}

    @Override
    public void deleteComment(UUID commentId) {
        Comment comment = repo.getById(commentId);
        repo.delete(comment);
    }

    @Override
    public List<Comment> getCommentsFromPost(UUID postId) {
        var comments = repo.findAll().stream().
                filter(c -> c.getPostId() == c.getPostId()).sorted(Comparator.comparing(Comment::getDate)).
                collect(Collectors.toList());

        return comments;
    }
}
