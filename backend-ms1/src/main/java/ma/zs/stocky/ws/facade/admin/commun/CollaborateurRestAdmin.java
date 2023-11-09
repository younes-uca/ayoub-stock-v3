package  ma.zs.stocky.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.commun.Collaborateur;
import ma.zs.stocky.dao.criteria.core.commun.CollaborateurCriteria;
import ma.zs.stocky.service.facade.admin.commun.CollaborateurAdminService;
import ma.zs.stocky.ws.converter.commun.CollaborateurConverter;
import ma.zs.stocky.ws.dto.commun.CollaborateurDto;
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
@RequestMapping("/api/admin/collaborateur/")
public class CollaborateurRestAdmin  extends AbstractController<Collaborateur, CollaborateurDto, CollaborateurCriteria, CollaborateurAdminService, CollaborateurConverter> {



    @Operation(summary = "upload one collaborateur")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple collaborateurs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all collaborateurs")
    @GetMapping("")
    public ResponseEntity<List<CollaborateurDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all collaborateurs")
    @GetMapping("optimized")
    public ResponseEntity<List<CollaborateurDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a collaborateur by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CollaborateurDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a collaborateur by nom")
    @GetMapping("nom/{nom}")
    public ResponseEntity<CollaborateurDto> findByNom(@PathVariable String nom, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new Collaborateur(nom), includes, excludes);
    }

    @Operation(summary = "Saves the specified  collaborateur")
    @PostMapping("")
    public ResponseEntity<CollaborateurDto> save(@RequestBody CollaborateurDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  collaborateur")
    @PutMapping("")
    public ResponseEntity<CollaborateurDto> update(@RequestBody CollaborateurDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of collaborateur")
    @PostMapping("multiple")
    public ResponseEntity<List<CollaborateurDto>> delete(@RequestBody List<CollaborateurDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified collaborateur")
    @DeleteMapping("")
    public ResponseEntity<CollaborateurDto> delete(@RequestBody CollaborateurDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified collaborateur")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple collaborateurs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds collaborateurs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CollaborateurDto>> findByCriteria(@RequestBody CollaborateurCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated collaborateurs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CollaborateurCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports collaborateurs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CollaborateurCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets collaborateur data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CollaborateurCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public CollaborateurRestAdmin (CollaborateurAdminService service, CollaborateurConverter converter) {
        super(service, converter);
    }




}
