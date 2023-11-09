package  ma.zs.stocky.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.gestionchequeffet.PermutationItem;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.PermutationItemCriteria;
import ma.zs.stocky.service.facade.admin.gestionchequeffet.PermutationItemAdminService;
import ma.zs.stocky.ws.converter.gestionchequeffet.PermutationItemConverter;
import ma.zs.stocky.ws.dto.gestionchequeffet.PermutationItemDto;
import ma.zs.stocky.zynerator.controller.AbstractController;
import ma.zs.stocky.zynerator.dto.AuditEntityDto;
import ma.zs.stocky.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.stocky.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.stocky.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/permutationItem/")
public class PermutationItemRestAdmin  extends AbstractController<PermutationItem, PermutationItemDto, PermutationItemCriteria, PermutationItemAdminService, PermutationItemConverter> {



    @Operation(summary = "upload one permutationItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple permutationItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all permutationItems")
    @GetMapping("")
    public ResponseEntity<List<PermutationItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a permutationItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PermutationItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  permutationItem")
    @PostMapping("")
    public ResponseEntity<PermutationItemDto> save(@RequestBody PermutationItemDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  permutationItem")
    @PutMapping("")
    public ResponseEntity<PermutationItemDto> update(@RequestBody PermutationItemDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of permutationItem")
    @PostMapping("multiple")
    public ResponseEntity<List<PermutationItemDto>> delete(@RequestBody List<PermutationItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified permutationItem")
    @DeleteMapping("")
    public ResponseEntity<PermutationItemDto> delete(@RequestBody PermutationItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified permutationItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple permutationItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public List<PermutationItemDto> findByProduitId(@PathVariable Long id){
        return findDtos(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @Operation(summary = "find by depot id")
    @GetMapping("depot/id/{id}")
    public List<PermutationItemDto> findByDepotId(@PathVariable Long id){
        return findDtos(service.findByDepotId(id));
    }
    @Operation(summary = "delete by depot id")
    @DeleteMapping("depot/id/{id}")
    public int deleteByDepotId(@PathVariable Long id){
        return service.deleteByDepotId(id);
    }
    @Operation(summary = "find by permutation id")
    @GetMapping("permutation/id/{id}")
    public List<PermutationItemDto> findByPermutationId(@PathVariable Long id){
        return findDtos(service.findByPermutationId(id));
    }
    @Operation(summary = "delete by permutation id")
    @DeleteMapping("permutation/id/{id}")
    public int deleteByPermutationId(@PathVariable Long id){
        return service.deleteByPermutationId(id);
    }
    @Operation(summary = "Finds permutationItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PermutationItemDto>> findByCriteria(@RequestBody PermutationItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated permutationItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PermutationItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports permutationItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PermutationItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets permutationItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PermutationItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PermutationItemRestAdmin (PermutationItemAdminService service, PermutationItemConverter converter) {
        super(service, converter);
    }




}
