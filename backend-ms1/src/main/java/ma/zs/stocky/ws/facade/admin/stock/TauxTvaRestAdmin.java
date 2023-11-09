package  ma.zs.stocky.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.stock.TauxTva;
import ma.zs.stocky.dao.criteria.core.stock.TauxTvaCriteria;
import ma.zs.stocky.service.facade.admin.stock.TauxTvaAdminService;
import ma.zs.stocky.ws.converter.stock.TauxTvaConverter;
import ma.zs.stocky.ws.dto.stock.TauxTvaDto;
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
@RequestMapping("/api/admin/tauxTva/")
public class TauxTvaRestAdmin  extends AbstractController<TauxTva, TauxTvaDto, TauxTvaCriteria, TauxTvaAdminService, TauxTvaConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<TauxTva>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody TauxTvaDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one tauxTva")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple tauxTvas")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all tauxTvas")
    @GetMapping("")
    public ResponseEntity<List<TauxTvaDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all tauxTvas")
    @GetMapping("optimized")
    public ResponseEntity<List<TauxTvaDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a tauxTva by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TauxTvaDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a tauxTva by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<TauxTvaDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new TauxTva(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  tauxTva")
    @PostMapping("")
    public ResponseEntity<TauxTvaDto> save(@RequestBody TauxTvaDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  tauxTva")
    @PutMapping("")
    public ResponseEntity<TauxTvaDto> update(@RequestBody TauxTvaDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of tauxTva")
    @PostMapping("multiple")
    public ResponseEntity<List<TauxTvaDto>> delete(@RequestBody List<TauxTvaDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified tauxTva")
    @DeleteMapping("")
    public ResponseEntity<TauxTvaDto> delete(@RequestBody TauxTvaDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified tauxTva")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple tauxTvas by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds tauxTvas by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TauxTvaDto>> findByCriteria(@RequestBody TauxTvaCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated tauxTvas by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TauxTvaCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports tauxTvas by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TauxTvaCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets tauxTva data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TauxTvaCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TauxTvaRestAdmin (TauxTvaAdminService service, TauxTvaConverter converter) {
        super(service, converter);
    }




}
