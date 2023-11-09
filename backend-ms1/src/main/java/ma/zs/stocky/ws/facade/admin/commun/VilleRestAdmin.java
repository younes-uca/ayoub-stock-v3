package  ma.zs.stocky.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.commun.Ville;
import ma.zs.stocky.dao.criteria.core.commun.VilleCriteria;
import ma.zs.stocky.service.facade.admin.commun.VilleAdminService;
import ma.zs.stocky.ws.converter.commun.VilleConverter;
import ma.zs.stocky.ws.dto.commun.VilleDto;
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
@RequestMapping("/api/admin/ville/")
public class VilleRestAdmin  extends AbstractController<Ville, VilleDto, VilleCriteria, VilleAdminService, VilleConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<Ville>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody VilleDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one ville")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple villes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all villes")
    @GetMapping("")
    public ResponseEntity<List<VilleDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a ville by id")
    @GetMapping("id/{id}")
    public ResponseEntity<VilleDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  ville")
    @PostMapping("")
    public ResponseEntity<VilleDto> save(@RequestBody VilleDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  ville")
    @PutMapping("")
    public ResponseEntity<VilleDto> update(@RequestBody VilleDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of ville")
    @PostMapping("multiple")
    public ResponseEntity<List<VilleDto>> delete(@RequestBody List<VilleDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified ville")
    @DeleteMapping("")
    public ResponseEntity<VilleDto> delete(@RequestBody VilleDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified ville")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple villes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds villes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<VilleDto>> findByCriteria(@RequestBody VilleCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated villes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody VilleCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports villes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody VilleCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets ville data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody VilleCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public VilleRestAdmin (VilleAdminService service, VilleConverter converter) {
        super(service, converter);
    }




}
