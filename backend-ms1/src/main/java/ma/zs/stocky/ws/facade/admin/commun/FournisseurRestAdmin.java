package  ma.zs.stocky.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.commun.Fournisseur;
import ma.zs.stocky.dao.criteria.core.commun.FournisseurCriteria;
import ma.zs.stocky.service.facade.admin.commun.FournisseurAdminService;
import ma.zs.stocky.ws.converter.commun.FournisseurConverter;
import ma.zs.stocky.ws.dto.commun.FournisseurDto;
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
@RequestMapping("/api/admin/fournisseur/")
public class FournisseurRestAdmin  extends AbstractController<Fournisseur, FournisseurDto, FournisseurCriteria, FournisseurAdminService, FournisseurConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<Fournisseur>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody FournisseurDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one fournisseur")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple fournisseurs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all fournisseurs")
    @GetMapping("")
    public ResponseEntity<List<FournisseurDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all fournisseurs")
    @GetMapping("optimized")
    public ResponseEntity<List<FournisseurDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a fournisseur by id")
    @GetMapping("id/{id}")
    public ResponseEntity<FournisseurDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a fournisseur by ice")
    @GetMapping("ice/{ice}")
    public ResponseEntity<FournisseurDto> findByIce(@PathVariable String ice, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new Fournisseur(ice), includes, excludes);
    }

    @Operation(summary = "Saves the specified  fournisseur")
    @PostMapping("")
    public ResponseEntity<FournisseurDto> save(@RequestBody FournisseurDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  fournisseur")
    @PutMapping("")
    public ResponseEntity<FournisseurDto> update(@RequestBody FournisseurDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of fournisseur")
    @PostMapping("multiple")
    public ResponseEntity<List<FournisseurDto>> delete(@RequestBody List<FournisseurDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified fournisseur")
    @DeleteMapping("")
    public ResponseEntity<FournisseurDto> delete(@RequestBody FournisseurDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified fournisseur")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple fournisseurs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by ville id")
    @GetMapping("ville/id/{id}")
    public List<FournisseurDto> findByVilleId(@PathVariable Long id){
        return findDtos(service.findByVilleId(id));
    }
    @Operation(summary = "delete by ville id")
    @DeleteMapping("ville/id/{id}")
    public int deleteByVilleId(@PathVariable Long id){
        return service.deleteByVilleId(id);
    }
    @Operation(summary = "Finds fournisseurs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<FournisseurDto>> findByCriteria(@RequestBody FournisseurCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated fournisseurs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody FournisseurCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports fournisseurs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody FournisseurCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets fournisseur data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody FournisseurCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public FournisseurRestAdmin (FournisseurAdminService service, FournisseurConverter converter) {
        super(service, converter);
    }




}
