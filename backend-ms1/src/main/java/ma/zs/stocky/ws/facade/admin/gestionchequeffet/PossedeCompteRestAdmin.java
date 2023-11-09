package  ma.zs.stocky.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.gestionchequeffet.PossedeCompte;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.PossedeCompteCriteria;
import ma.zs.stocky.service.facade.admin.gestionchequeffet.PossedeCompteAdminService;
import ma.zs.stocky.ws.converter.gestionchequeffet.PossedeCompteConverter;
import ma.zs.stocky.ws.dto.gestionchequeffet.PossedeCompteDto;
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
@RequestMapping("/api/admin/possedeCompte/")
public class PossedeCompteRestAdmin  extends AbstractController<PossedeCompte, PossedeCompteDto, PossedeCompteCriteria, PossedeCompteAdminService, PossedeCompteConverter> {



    @Operation(summary = "upload one possedeCompte")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple possedeComptes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all possedeComptes")
    @GetMapping("")
    public ResponseEntity<List<PossedeCompteDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a possedeCompte by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PossedeCompteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  possedeCompte")
    @PostMapping("")
    public ResponseEntity<PossedeCompteDto> save(@RequestBody PossedeCompteDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  possedeCompte")
    @PutMapping("")
    public ResponseEntity<PossedeCompteDto> update(@RequestBody PossedeCompteDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of possedeCompte")
    @PostMapping("multiple")
    public ResponseEntity<List<PossedeCompteDto>> delete(@RequestBody List<PossedeCompteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified possedeCompte")
    @DeleteMapping("")
    public ResponseEntity<PossedeCompteDto> delete(@RequestBody PossedeCompteDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified possedeCompte")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple possedeComptes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by proprietaire id")
    @GetMapping("proprietaire/id/{id}")
    public List<PossedeCompteDto> findByProprietaireId(@PathVariable Long id){
        return findDtos(service.findByProprietaireId(id));
    }
    @Operation(summary = "delete by proprietaire id")
    @DeleteMapping("proprietaire/id/{id}")
    public int deleteByProprietaireId(@PathVariable Long id){
        return service.deleteByProprietaireId(id);
    }
    @Operation(summary = "find by banque id")
    @GetMapping("banque/id/{id}")
    public List<PossedeCompteDto> findByBanqueId(@PathVariable Long id){
        return findDtos(service.findByBanqueId(id));
    }
    @Operation(summary = "delete by banque id")
    @DeleteMapping("banque/id/{id}")
    public int deleteByBanqueId(@PathVariable Long id){
        return service.deleteByBanqueId(id);
    }
    @Operation(summary = "find by compte id")
    @GetMapping("compte/id/{id}")
    public List<PossedeCompteDto> findByCompteId(@PathVariable Long id){
        return findDtos(service.findByCompteId(id));
    }
    @Operation(summary = "delete by compte id")
    @DeleteMapping("compte/id/{id}")
    public int deleteByCompteId(@PathVariable Long id){
        return service.deleteByCompteId(id);
    }
    @Operation(summary = "Finds possedeComptes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PossedeCompteDto>> findByCriteria(@RequestBody PossedeCompteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated possedeComptes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PossedeCompteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports possedeComptes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PossedeCompteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets possedeCompte data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PossedeCompteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PossedeCompteRestAdmin (PossedeCompteAdminService service, PossedeCompteConverter converter) {
        super(service, converter);
    }




}
