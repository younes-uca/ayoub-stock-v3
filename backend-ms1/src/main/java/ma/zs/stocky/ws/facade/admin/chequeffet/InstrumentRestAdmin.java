package  ma.zs.stocky.ws.facade.admin.chequeffet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.chequeffet.Instrument;
import ma.zs.stocky.dao.criteria.core.chequeffet.InstrumentCriteria;
import ma.zs.stocky.service.facade.admin.chequeffet.InstrumentAdminService;
import ma.zs.stocky.ws.converter.chequeffet.InstrumentConverter;
import ma.zs.stocky.ws.dto.chequeffet.InstrumentDto;
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
@RequestMapping("/api/admin/instrument/")
public class InstrumentRestAdmin  extends AbstractController<Instrument, InstrumentDto, InstrumentCriteria, InstrumentAdminService, InstrumentConverter> {



    @Operation(summary = "upload one instrument")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple instruments")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all instruments")
    @GetMapping("")
    public ResponseEntity<List<InstrumentDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a instrument by id")
    @GetMapping("id/{id}")
    public ResponseEntity<InstrumentDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  instrument")
    @PostMapping("")
    public ResponseEntity<InstrumentDto> save(@RequestBody InstrumentDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  instrument")
    @PutMapping("")
    public ResponseEntity<InstrumentDto> update(@RequestBody InstrumentDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of instrument")
    @PostMapping("multiple")
    public ResponseEntity<List<InstrumentDto>> delete(@RequestBody List<InstrumentDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified instrument")
    @DeleteMapping("")
    public ResponseEntity<InstrumentDto> delete(@RequestBody InstrumentDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified instrument")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple instruments by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by typeInstrument id")
    @GetMapping("typeInstrument/id/{id}")
    public List<InstrumentDto> findByTypeInstrumentId(@PathVariable Long id){
        return findDtos(service.findByTypeInstrumentId(id));
    }
    @Operation(summary = "delete by typeInstrument id")
    @DeleteMapping("typeInstrument/id/{id}")
    public int deleteByTypeInstrumentId(@PathVariable Long id){
        return service.deleteByTypeInstrumentId(id);
    }
    @Operation(summary = "find by chequeEffet id")
    @GetMapping("chequeEffet/id/{id}")
    public List<InstrumentDto> findByChequeEffetId(@PathVariable Long id){
        return findDtos(service.findByChequeEffetId(id));
    }
    @Operation(summary = "delete by chequeEffet id")
    @DeleteMapping("chequeEffet/id/{id}")
    public int deleteByChequeEffetId(@PathVariable Long id){
        return service.deleteByChequeEffetId(id);
    }
    @Operation(summary = "Finds instruments by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<InstrumentDto>> findByCriteria(@RequestBody InstrumentCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated instruments by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody InstrumentCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports instruments by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody InstrumentCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets instrument data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody InstrumentCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public InstrumentRestAdmin (InstrumentAdminService service, InstrumentConverter converter) {
        super(service, converter);
    }




}
