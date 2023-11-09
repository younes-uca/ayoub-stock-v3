package  ma.zs.stocky.ws.facade.admin.paiement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.paiement.PaiementVente;
import ma.zs.stocky.dao.criteria.core.paiement.PaiementVenteCriteria;
import ma.zs.stocky.service.facade.admin.paiement.PaiementVenteAdminService;
import ma.zs.stocky.ws.converter.paiement.PaiementVenteConverter;
import ma.zs.stocky.ws.dto.paiement.PaiementVenteDto;
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
@RequestMapping("/api/admin/paiementVente/")
public class PaiementVenteRestAdmin  extends AbstractController<PaiementVente, PaiementVenteDto, PaiementVenteCriteria, PaiementVenteAdminService, PaiementVenteConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<PaiementVente>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody PaiementVenteDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one paiementVente")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple paiementVentes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all paiementVentes")
    @GetMapping("")
    public ResponseEntity<List<PaiementVenteDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all paiementVentes")
    @GetMapping("optimized")
    public ResponseEntity<List<PaiementVenteDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a paiementVente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaiementVenteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a paiementVente by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<PaiementVenteDto> findByReference(@PathVariable String reference, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new PaiementVente(reference), includes, excludes);
    }

    @Operation(summary = "Saves the specified  paiementVente")
    @PostMapping("")
    public ResponseEntity<PaiementVenteDto> save(@RequestBody PaiementVenteDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  paiementVente")
    @PutMapping("")
    public ResponseEntity<PaiementVenteDto> update(@RequestBody PaiementVenteDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of paiementVente")
    @PostMapping("multiple")
    public ResponseEntity<List<PaiementVenteDto>> delete(@RequestBody List<PaiementVenteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified paiementVente")
    @DeleteMapping("")
    public ResponseEntity<PaiementVenteDto> delete(@RequestBody PaiementVenteDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified paiementVente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple paiementVentes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by vente id")
    @GetMapping("vente/id/{id}")
    public List<PaiementVenteDto> findByVenteId(@PathVariable Long id){
        return findDtos(service.findByVenteId(id));
    }
    @Operation(summary = "delete by vente id")
    @DeleteMapping("vente/id/{id}")
    public int deleteByVenteId(@PathVariable Long id){
        return service.deleteByVenteId(id);
    }
    @Operation(summary = "find by modePaiement id")
    @GetMapping("modePaiement/id/{id}")
    public List<PaiementVenteDto> findByModePaiementId(@PathVariable Long id){
        return findDtos(service.findByModePaiementId(id));
    }
    @Operation(summary = "delete by modePaiement id")
    @DeleteMapping("modePaiement/id/{id}")
    public int deleteByModePaiementId(@PathVariable Long id){
        return service.deleteByModePaiementId(id);
    }
    @Operation(summary = "Finds paiementVentes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaiementVenteDto>> findByCriteria(@RequestBody PaiementVenteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated paiementVentes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaiementVenteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports paiementVentes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaiementVenteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets paiementVente data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaiementVenteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PaiementVenteRestAdmin (PaiementVenteAdminService service, PaiementVenteConverter converter) {
        super(service, converter);
    }




}
