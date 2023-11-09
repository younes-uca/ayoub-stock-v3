package  ma.zs.stocky.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.gestionchequeffet.Transaction;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.TransactionCriteria;
import ma.zs.stocky.service.facade.admin.gestionchequeffet.TransactionAdminService;
import ma.zs.stocky.ws.converter.gestionchequeffet.TransactionConverter;
import ma.zs.stocky.ws.dto.gestionchequeffet.TransactionDto;
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
@RequestMapping("/api/admin/transaction/")
public class TransactionRestAdmin  extends AbstractController<Transaction, TransactionDto, TransactionCriteria, TransactionAdminService, TransactionConverter> {



    @Operation(summary = "upload one transaction")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple transactions")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all transactions")
    @GetMapping("")
    public ResponseEntity<List<TransactionDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a transaction by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TransactionDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  transaction")
    @PostMapping("")
    public ResponseEntity<TransactionDto> save(@RequestBody TransactionDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  transaction")
    @PutMapping("")
    public ResponseEntity<TransactionDto> update(@RequestBody TransactionDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of transaction")
    @PostMapping("multiple")
    public ResponseEntity<List<TransactionDto>> delete(@RequestBody List<TransactionDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified transaction")
    @DeleteMapping("")
    public ResponseEntity<TransactionDto> delete(@RequestBody TransactionDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified transaction")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple transactions by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by typeTransaction id")
    @GetMapping("typeTransaction/id/{id}")
    public List<TransactionDto> findByTypeTransactionId(@PathVariable Long id){
        return findDtos(service.findByTypeTransactionId(id));
    }
    @Operation(summary = "delete by typeTransaction id")
    @DeleteMapping("typeTransaction/id/{id}")
    public int deleteByTypeTransactionId(@PathVariable Long id){
        return service.deleteByTypeTransactionId(id);
    }
    @Operation(summary = "find by instrument id")
    @GetMapping("instrument/id/{id}")
    public List<TransactionDto> findByInstrumentId(@PathVariable Long id){
        return findDtos(service.findByInstrumentId(id));
    }
    @Operation(summary = "delete by instrument id")
    @DeleteMapping("instrument/id/{id}")
    public int deleteByInstrumentId(@PathVariable Long id){
        return service.deleteByInstrumentId(id);
    }
    @Operation(summary = "find by compte id")
    @GetMapping("compte/id/{id}")
    public List<TransactionDto> findByCompteId(@PathVariable Long id){
        return findDtos(service.findByCompteId(id));
    }
    @Operation(summary = "delete by compte id")
    @DeleteMapping("compte/id/{id}")
    public int deleteByCompteId(@PathVariable Long id){
        return service.deleteByCompteId(id);
    }
    @Operation(summary = "Finds transactions by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TransactionDto>> findByCriteria(@RequestBody TransactionCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated transactions by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TransactionCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports transactions by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TransactionCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets transaction data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TransactionCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TransactionRestAdmin (TransactionAdminService service, TransactionConverter converter) {
        super(service, converter);
    }




}
