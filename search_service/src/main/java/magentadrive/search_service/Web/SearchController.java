package magentadrive.search_service.Web;

import magentadrive.search_service.service.SearchServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/search")
    @RestController
    public class SearchController {
        private final SearchServiceImpl service;

        public SearchController(SearchServiceImpl service) {this.service = service;}


        @GetMapping("")
        public ResponseEntity<?> search(@RequestBody SearchRequest request){

            var searchString = request.getSearchString();
            var results = service.search(searchString);




            return ResponseEntity.ok(
                    new SearchResponse(
                            (List<?>) results.get(0)

                    )
            );
        }


    }
