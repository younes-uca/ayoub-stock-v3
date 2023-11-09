package  ma.zs.stocky.ws.facade.admin.paiement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.paiement.PaiementAvoirVente;
import ma.zs.stocky.dao.criteria.core.paiement.PaiementAvoirVenteCriteria;
import ma.zs.stocky.service.facade.admin.paiement.PaiementAvoirVenteAdminService;
import ma.zs.stocky.ws.converter.paiement.PaiementAvoirVenteConverter;
import ma.zs.stocky.ws.dto.paiement.PaiementAvoirVenteDto;
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
@RequestMapping("/api/admin/paiementAvoirVente/")
public class PaiementAvoirVenteRestAdmin  extends AbstractController<PaiementAvoirVente, PaiementAvoirVenteDto, PaiementAvoirVenteCriteria, PaiementAvoirVenteAdminService, PaiementAvoirVenteConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<PaiementAvoirVente>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody PaiementAvoirVenteDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one paiementAvoirVente")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple paiementAvoirVentes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all paiementAvoirVentes")
    @GetMapping("")
    public ResponseEntity<List<PaiementAvoirVenteDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all paiementAvoirVentes")
    @GetMapping("optimized")
    public ResponseEntity<List<PaiementAvoirVenteDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a paiementAvoirVente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaiementAvoirVenteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a paiementAvoirVente by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<PaiementAvoirVenteDto> findByReference(@PathVariable String reference, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new PaiementAvoirVente(reference), includes, excludes);
    }

    @Operation(summary = "Saves the specified  paiementAvoirVente")
    @PostMapping("")
    public ResponseEntity<PaiementAvoirVenteDto> save(@RequestBody PaiementAvoirVenteDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  paiementAvoirVente")
    @PutMapping("")
    public ResponseEntity<PaiementAvoirVenteDto> update(@RequestBody PaiementAvoirVenteDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of paiementAvoirVente")
    @PostMapping("multiple")
    public ResponseEntity<List<PaiementAvoirVenteDto>> delete(@RequestBody List<PaiementAvoirVenteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified paiementAvoirVente")
    @DeleteMapping("")
    public ResponseEntity<PaiementAvoirVenteDto> delete(@RequestBody PaiementAvoirVenteDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified paiementAvoirVente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple paiementAvoirVentes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by vente id")
    @GetMapping("vente/id/{id}")
    public List<PaiementAvoirVenteDto> findByVenteId(@PathVariable Long id){
        return findDtos(service.findByVenteId(id));
    }
    @Operation(summary = "delete by vente id")
    @DeleteMapping("vente/id/{id}")
    public int deleteByVenteId(@PathVariable Long id){
        return service.deleteByVenteId(id);
    }
    @Operation(summary = "find by modePaiement id")
    @GetMapping("modePaiement/id/{id}")
    public List<PaiementAvoirVenteDto> findByModePaiementId(@PathVariable Long id){
        return findDtos(service.findByModePaiementId(id));
    }
    @Operation(summary = "delete by modePaiement id")
    @DeleteMapping("modePaiement/id/{id}")
    public int deleteByModePaiementId(@PathVariable Long id){
        return service.deleteByModePaiementId(id);
    }
    @Operation(summary = "find by avoirVente id")
    @GetMapping("avoirVente/id/{id}")
    public List<PaiementAvoirVenteDto> findByAvoirVenteId(@PathVariable Long id){
        return findDtos(service.findByAvoirVenteId(id));
    }
    @Operation(summary = "delete by avoirVente id")
    @DeleteMapping("avoirVente/id/{id}")
    public int deleteByAvoirVenteId(@PathVariable Long id){
        return service.deleteByAvoirVenteId(id);
    }
    @Operation(summary = "Finds paiementAvoirVentes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaiementAvoirVenteDto>> findByCriteria(@RequestBody PaiementAvoirVenteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated paiementAvoirVentes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaiementAvoirVenteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports paiementAvoirVentes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaiementAvoirVenteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets paiementAvoirVente data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaiementAvoirVenteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PaiementAvoirVenteRestAdmin (PaiementAvoirVenteAdminService service, PaiementAvoirVenteConverter converter) {
        super(service, converter);
    }




}
