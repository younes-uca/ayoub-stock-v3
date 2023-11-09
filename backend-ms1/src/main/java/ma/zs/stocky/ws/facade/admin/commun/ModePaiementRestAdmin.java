package  ma.zs.stocky.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.commun.ModePaiement;
import ma.zs.stocky.dao.criteria.core.commun.ModePaiementCriteria;
import ma.zs.stocky.service.facade.admin.commun.ModePaiementAdminService;
import ma.zs.stocky.ws.converter.commun.ModePaiementConverter;
import ma.zs.stocky.ws.dto.commun.ModePaiementDto;
import ma.zs.stocky.zynerator.controller.AbstractController;
import ma.zs.stocky.zynerator.dto.AuditEntityDto;
import ma.zs.stocky.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.stocky.zynerator.process.Result;

import org.springframework.http.HttpEntity;

import org.springframework.web.multipart.MultipartFile;
import ma.zs.stocky.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/modePaiement/")
public class ModePaiementRestAdmin  extends AbstractController<ModePaiement, ModePaiementDto, ModePaiementCriteria, ModePaiementAdminService, ModePaiementConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<ModePaiement>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ModePaiementDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one modePaiement")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple modePaiements")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all modePaiements")
    @GetMapping("")
    public ResponseEntity<List<ModePaiementDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all modePaiements")
    @GetMapping("optimized")
    public ResponseEntity<List<ModePaiementDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a modePaiement by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ModePaiementDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a modePaiement by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<ModePaiementDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new ModePaiement(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  modePaiement")
    @PostMapping("")
    public ResponseEntity<ModePaiementDto> save(@RequestBody ModePaiementDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  modePaiement")
    @PutMapping("")
    public ResponseEntity<ModePaiementDto> update(@RequestBody ModePaiementDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of modePaiement")
    @PostMapping("multiple")
    public ResponseEntity<List<ModePaiementDto>> delete(@RequestBody List<ModePaiementDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified modePaiement")
    @DeleteMapping("")
    public ResponseEntity<ModePaiementDto> delete(@RequestBody ModePaiementDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified modePaiement")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple modePaiements by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds modePaiements by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ModePaiementDto>> findByCriteria(@RequestBody ModePaiementCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated modePaiements by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ModePaiementCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports modePaiements by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ModePaiementCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets modePaiement data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ModePaiementCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ModePaiementRestAdmin (ModePaiementAdminService service, ModePaiementConverter converter) {
        super(service, converter);
    }




}
