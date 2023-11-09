package  ma.zs.stocky.ws.facade.admin.paiement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.paiement.PaiementAvoirAchat;
import ma.zs.stocky.dao.criteria.core.paiement.PaiementAvoirAchatCriteria;
import ma.zs.stocky.service.facade.admin.paiement.PaiementAvoirAchatAdminService;
import ma.zs.stocky.ws.converter.paiement.PaiementAvoirAchatConverter;
import ma.zs.stocky.ws.dto.paiement.PaiementAvoirAchatDto;
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
@RequestMapping("/api/admin/paiementAvoirAchat/")
public class PaiementAvoirAchatRestAdmin  extends AbstractController<PaiementAvoirAchat, PaiementAvoirAchatDto, PaiementAvoirAchatCriteria, PaiementAvoirAchatAdminService, PaiementAvoirAchatConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<PaiementAvoirAchat>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody PaiementAvoirAchatDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one paiementAvoirAchat")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple paiementAvoirAchats")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all paiementAvoirAchats")
    @GetMapping("")
    public ResponseEntity<List<PaiementAvoirAchatDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all paiementAvoirAchats")
    @GetMapping("optimized")
    public ResponseEntity<List<PaiementAvoirAchatDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a paiementAvoirAchat by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaiementAvoirAchatDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a paiementAvoirAchat by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<PaiementAvoirAchatDto> findByReference(@PathVariable String reference, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new PaiementAvoirAchat(reference), includes, excludes);
    }

    @Operation(summary = "Saves the specified  paiementAvoirAchat")
    @PostMapping("")
    public ResponseEntity<PaiementAvoirAchatDto> save(@RequestBody PaiementAvoirAchatDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  paiementAvoirAchat")
    @PutMapping("")
    public ResponseEntity<PaiementAvoirAchatDto> update(@RequestBody PaiementAvoirAchatDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of paiementAvoirAchat")
    @PostMapping("multiple")
    public ResponseEntity<List<PaiementAvoirAchatDto>> delete(@RequestBody List<PaiementAvoirAchatDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified paiementAvoirAchat")
    @DeleteMapping("")
    public ResponseEntity<PaiementAvoirAchatDto> delete(@RequestBody PaiementAvoirAchatDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified paiementAvoirAchat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple paiementAvoirAchats by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by achat id")
    @GetMapping("achat/id/{id}")
    public List<PaiementAvoirAchatDto> findByAchatId(@PathVariable Long id){
        return findDtos(service.findByAchatId(id));
    }
    @Operation(summary = "delete by achat id")
    @DeleteMapping("achat/id/{id}")
    public int deleteByAchatId(@PathVariable Long id){
        return service.deleteByAchatId(id);
    }
    @Operation(summary = "find by modePaiement id")
    @GetMapping("modePaiement/id/{id}")
    public List<PaiementAvoirAchatDto> findByModePaiementId(@PathVariable Long id){
        return findDtos(service.findByModePaiementId(id));
    }
    @Operation(summary = "delete by modePaiement id")
    @DeleteMapping("modePaiement/id/{id}")
    public int deleteByModePaiementId(@PathVariable Long id){
        return service.deleteByModePaiementId(id);
    }
    @Operation(summary = "find by avoirAchat id")
    @GetMapping("avoirAchat/id/{id}")
    public List<PaiementAvoirAchatDto> findByAvoirAchatId(@PathVariable Long id){
        return findDtos(service.findByAvoirAchatId(id));
    }
    @Operation(summary = "delete by avoirAchat id")
    @DeleteMapping("avoirAchat/id/{id}")
    public int deleteByAvoirAchatId(@PathVariable Long id){
        return service.deleteByAvoirAchatId(id);
    }
    @Operation(summary = "Finds paiementAvoirAchats by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaiementAvoirAchatDto>> findByCriteria(@RequestBody PaiementAvoirAchatCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated paiementAvoirAchats by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaiementAvoirAchatCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports paiementAvoirAchats by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaiementAvoirAchatCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets paiementAvoirAchat data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaiementAvoirAchatCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PaiementAvoirAchatRestAdmin (PaiementAvoirAchatAdminService service, PaiementAvoirAchatConverter converter) {
        super(service, converter);
    }




}
