package  ma.zs.stocky.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.gestionchequeffet.Permutation;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.PermutationCriteria;
import ma.zs.stocky.service.facade.admin.gestionchequeffet.PermutationAdminService;
import ma.zs.stocky.ws.converter.gestionchequeffet.PermutationConverter;
import ma.zs.stocky.ws.dto.gestionchequeffet.PermutationDto;
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
@RequestMapping("/api/admin/permutation/")
public class PermutationRestAdmin  extends AbstractController<Permutation, PermutationDto, PermutationCriteria, PermutationAdminService, PermutationConverter> {



    @Operation(summary = "upload one permutation")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple permutations")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all permutations")
    @GetMapping("")
    public ResponseEntity<List<PermutationDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a permutation by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PermutationDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  permutation")
    @PostMapping("")
    public ResponseEntity<PermutationDto> save(@RequestBody PermutationDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  permutation")
    @PutMapping("")
    public ResponseEntity<PermutationDto> update(@RequestBody PermutationDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of permutation")
    @PostMapping("multiple")
    public ResponseEntity<List<PermutationDto>> delete(@RequestBody List<PermutationDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified permutation")
    @DeleteMapping("")
    public ResponseEntity<PermutationDto> delete(@RequestBody PermutationDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified permutation")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple permutations by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds a permutation and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<PermutationDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds permutations by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PermutationDto>> findByCriteria(@RequestBody PermutationCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated permutations by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PermutationCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports permutations by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PermutationCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets permutation data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PermutationCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PermutationRestAdmin (PermutationAdminService service, PermutationConverter converter) {
        super(service, converter);
    }




}
