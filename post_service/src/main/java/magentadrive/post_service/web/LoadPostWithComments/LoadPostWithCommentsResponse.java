package magentadrive.post_service.web.LoadPostWithComments;


import lombok.AllArgsConstructor;
import magentadrive.post_service.model.Comment;
import magentadrive.post_service.model.Post;

import java.util.List;

@AllArgsConstructor
public class LoadPostWithCommentsResponse {
    Post post;
    List<Comment> comments;
}
