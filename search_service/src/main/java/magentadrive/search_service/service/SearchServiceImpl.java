package magentadrive.search_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;



@Service
public class SearchServiceImpl implements SearchService {
    String FileServiceURLstring = "http://localhost:8083/storage/search";


    @Override
    public List search(String s) {
       List<List> searchResult = Arrays.asList(searchDocsContainSearchstring(s), searchPostContainSearchstring(s),searchTagsContainSearchstring(s) );
       return searchResult;
    }

    @Override
    public List<?> searchDocsContainSearchstring(String s) {

        return new RestTemplate().getForObject(FileServiceURLstring, List.class);
    }

    @Override
    public List<?> searchPostContainSearchstring(String s) {
        return null;
    }

    @Override
    public List<?> searchTagsContainSearchstring(String s) {
        return null;
    }
}

