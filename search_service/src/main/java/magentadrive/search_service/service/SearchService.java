package magentadrive.search_service.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface SearchService {

    List<List<?>> search(String s);

    List<?>  searchDocsContainSearchstring(String s);

    List<?>  searchPostContainSearchstring(String s);

    List<?>  searchTagsContainSearchstring(String s);
}
