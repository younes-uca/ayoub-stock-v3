package  ma.zs.stocky.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.gestionchequeffet.TypeTransaction;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.TypeTransactionCriteria;
import ma.zs.stocky.service.facade.admin.gestionchequeffet.TypeTransactionAdminService;
import ma.zs.stocky.ws.converter.gestionchequeffet.TypeTransactionConverter;
import ma.zs.stocky.ws.dto.gestionchequeffet.TypeTransactionDto;
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
@RequestMapping("/api/admin/typeTransaction/")
public class TypeTransactionRestAdmin  extends AbstractController<TypeTransaction, TypeTransactionDto, TypeTransactionCriteria, TypeTransactionAdminService, TypeTransactionConverter> {



    @Operation(summary = "upload one typeTransaction")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple typeTransactions")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all typeTransactions")
    @GetMapping("")
    public ResponseEntity<List<TypeTransactionDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all typeTransactions")
    @GetMapping("optimized")
    public ResponseEntity<List<TypeTransactionDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a typeTransaction by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypeTransactionDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a typeTransaction by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<TypeTransactionDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new TypeTransaction(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  typeTransaction")
    @PostMapping("")
    public ResponseEntity<TypeTransactionDto> save(@RequestBody TypeTransactionDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  typeTransaction")
    @PutMapping("")
    public ResponseEntity<TypeTransactionDto> update(@RequestBody TypeTransactionDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of typeTransaction")
    @PostMapping("multiple")
    public ResponseEntity<List<TypeTransactionDto>> delete(@RequestBody List<TypeTransactionDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified typeTransaction")
    @DeleteMapping("")
    public ResponseEntity<TypeTransactionDto> delete(@RequestBody TypeTransactionDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified typeTransaction")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple typeTransactions by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds typeTransactions by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TypeTransactionDto>> findByCriteria(@RequestBody TypeTransactionCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated typeTransactions by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TypeTransactionCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports typeTransactions by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TypeTransactionCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets typeTransaction data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TypeTransactionCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TypeTransactionRestAdmin (TypeTransactionAdminService service, TypeTransactionConverter converter) {
        super(service, converter);
    }




}
