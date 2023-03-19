package com.fernandez_market.Fernandez_Market.Controllers.api;

import com.fernandez_market.Fernandez_Market.Services.ImageService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/images")
public class API_ImageController {

    private final ImageService imageService;

    public API_ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping(value = "/{category}/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public Resource getImage(@PathVariable String category, @PathVariable int id){

        byte[] image;

        switch (category) {
            case "Categoria" -> image = imageService.getRawImageCategoriaById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                    .getImagenCategoria();
            case "Subcategoria" -> image = imageService.getRawImageSubcategoriaById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                    .getImagenSubcategorias();
            case "Marca" -> image = imageService.getRawImageMarcaById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                    .getImagenMarca();
            case "Producto" -> {
                Long idLong = Long.parseLong(String.valueOf(id));
                image = imageService.getRawImageProductoById(idLong)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                        .getImagenProducto();
            }
            case "Promocion" -> image = imageService.getRawImagePromocionById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                    .getImagenPromocion();
            default -> throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return new ByteArrayResource(image);
    }

//    @PostMapping
//    public int uploadImage(@RequestParam MultipartFile imageFile) throws Exception {
//        Image image = new Image();
//
//        image.setName(imageFile.getName());
//        image.setContent(imageFile.getBytes());
//        image.setContentType(imageFile.getContentType());
//        image.setSize(imageFile.getSize());
//
//
//        return imageService.saveImage(image);
//    }
}
