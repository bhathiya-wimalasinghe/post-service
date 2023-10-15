package lk.ijse.dep10.postservice.api;

import lk.ijse.dep10.postservice.dto.ImageDTO;
import lk.ijse.dep10.postservice.dto.PostDTO;
import lk.ijse.dep10.postservice.service.ImageService;
import lk.ijse.dep10.postservice.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
@CrossOrigin
public class PostRestController {
    private final PostService postService;

    private final ImageService imageService;

    public PostRestController(PostService postService, ImageService imageService) {
        this.postService = postService;
        this.imageService = imageService;
    }


    @PostMapping(value =  "/post",consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePost(@RequestBody @Validated PostDTO postDTO) {
        postService.savePost(postDTO);
    }


    @PostMapping(value =  "/image",consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveImage(@RequestBody @Validated ImageDTO imageDTO) {
        imageService.saveImage(imageDTO);
    }


    @PatchMapping(value = "/post-update", consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost( @RequestBody @Validated PostDTO postDTO) {
        postService.updatePost(postDTO);
    }


    @PostMapping(value = "/image-update", consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateImage(@RequestBody @Validated ImageDTO imageDTO) {
        imageService.updateImage(imageDTO);
    }


    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePost(@PathVariable Integer postId) {
        postService.deletePost(postId);
    }


    @GetMapping("/{postId}")
    public PostDTO getPost(@PathVariable Integer postId) {
        return postService.getPost(postId);
    }

    @GetMapping("find/{query}")
    public List<PostDTO> findPosts(@PathVariable String query) {
        return postService.findPosts(query);
    }
}
