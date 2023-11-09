package  ma.zs.stocky.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.stock.AvoirVente;
import ma.zs.stocky.dao.criteria.core.stock.AvoirVenteCriteria;
import ma.zs.stocky.service.facade.admin.stock.AvoirVenteAdminService;
import ma.zs.stocky.ws.converter.stock.AvoirVenteConverter;
import ma.zs.stocky.ws.dto.stock.AvoirVenteDto;
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
@RequestMapping("/api/admin/avoirVente/")
public class AvoirVenteRestAdmin  extends AbstractController<AvoirVente, AvoirVenteDto, AvoirVenteCriteria, AvoirVenteAdminService, AvoirVenteConverter> {



    @Operation(summary = "upload one avoirVente")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple avoirVentes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all avoirVentes")
    @GetMapping("")
    public ResponseEntity<List<AvoirVenteDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a avoirVente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AvoirVenteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  avoirVente")
    @PostMapping("")
    public ResponseEntity<AvoirVenteDto> save(@RequestBody AvoirVenteDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  avoirVente")
    @PutMapping("")
    public ResponseEntity<AvoirVenteDto> update(@RequestBody AvoirVenteDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of avoirVente")
    @PostMapping("multiple")
    public ResponseEntity<List<AvoirVenteDto>> delete(@RequestBody List<AvoirVenteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified avoirVente")
    @DeleteMapping("")
    public ResponseEntity<AvoirVenteDto> delete(@RequestBody AvoirVenteDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified avoirVente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple avoirVentes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by entrepriseSociete id")
    @GetMapping("entrepriseSociete/id/{id}")
    public List<AvoirVenteDto> findByEntrepriseSocieteId(@PathVariable Long id){
        return findDtos(service.findByEntrepriseSocieteId(id));
    }
    @Operation(summary = "delete by entrepriseSociete id")
    @DeleteMapping("entrepriseSociete/id/{id}")
    public int deleteByEntrepriseSocieteId(@PathVariable Long id){
        return service.deleteByEntrepriseSocieteId(id);
    }
    @Operation(summary = "find by vente id")
    @GetMapping("vente/id/{id}")
    public List<AvoirVenteDto> findByVenteId(@PathVariable Long id){
        return findDtos(service.findByVenteId(id));
    }
    @Operation(summary = "delete by vente id")
    @DeleteMapping("vente/id/{id}")
    public int deleteByVenteId(@PathVariable Long id){
        return service.deleteByVenteId(id);
    }
    @Operation(summary = "Finds a avoirVente and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<AvoirVenteDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds avoirVentes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<AvoirVenteDto>> findByCriteria(@RequestBody AvoirVenteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated avoirVentes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody AvoirVenteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports avoirVentes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody AvoirVenteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets avoirVente data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody AvoirVenteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public AvoirVenteRestAdmin (AvoirVenteAdminService service, AvoirVenteConverter converter) {
        super(service, converter);
    }




}
