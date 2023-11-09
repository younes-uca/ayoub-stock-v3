import {Component, OnInit} from '@angular/core';
import {InstrumentAdminService} from 'src/app/controller/service/admin/chequeffet/InstrumentAdmin.service';
import {InstrumentDto} from 'src/app/controller/model/chequeffet/Instrument.model';
import {InstrumentCriteria} from 'src/app/controller/criteria/chequeffet/InstrumentCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {ChequeEffetDto} from 'src/app/controller/model/gestionchequeffet/ChequeEffet.model';
import {ChequeEffetAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ChequeEffetAdmin.service';
import {TypeInstrumentDto} from 'src/app/controller/model/gestionchequeffet/TypeInstrument.model';
import {TypeInstrumentAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TypeInstrumentAdmin.service';


@Component({
  selector: 'app-instrument-list-admin',
  templateUrl: './instrument-list-admin.component.html'
})
export class InstrumentListAdminComponent extends AbstractListController<InstrumentDto, InstrumentCriteria, InstrumentAdminService>  implements OnInit {

    fileName = 'Instrument';

    typeInstruments: Array<TypeInstrumentDto>;
    chequeEffets: Array<ChequeEffetDto>;


    constructor( private instrumentService: InstrumentAdminService  , private chequeEffetService: ChequeEffetAdminService, private typeInstrumentService: TypeInstrumentAdminService) {
        super(instrumentService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadTypeInstrument();
        this.loadChequeEffet();
    }


    public initCol() {
        this.cols = [
            {field: 'typeInstrument?.libelle', header: 'Type instrument'},
            {field: 'chequeEffet?.id', header: 'Cheque effet'},
            {field: 'dateEmission', header: 'Date emission'},
            {field: 'montant', header: 'Montant'},
        ];
    }


    public async loadTypeInstrument(){
       this.typeInstrumentService.findAllOptimized().subscribe(typeInstruments => this.typeInstruments = typeInstruments, error => console.log(error))
    }
    public async loadChequeEffet(){
       this.chequeEffetService.findAll().subscribe(chequeEffets => this.chequeEffets = chequeEffets, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Type instrument': e.typeInstrument?.libelle ,
                'Cheque effet': e.chequeEffet?.id ,
                'Date emission': this.datePipe.transform(e.dateEmission , 'dd/MM/yyyy hh:mm'),
                 'Montant': e.montant ,
            }
        });

        this.criteriaData = [{
        //'Type instrument': this.criteria.typeInstrument?.libelle ? this.criteria.typeInstrument?.libelle : environment.emptyForExport ,
        //'Cheque effet': this.criteria.chequeEffet?.id ? this.criteria.chequeEffet?.id : environment.emptyForExport ,
            'Date emission Min': this.criteria.dateEmissionFrom ? this.datePipe.transform(this.criteria.dateEmissionFrom , this.dateFormat) : environment.emptyForExport ,
            'Date emission Max': this.criteria.dateEmissionTo ? this.datePipe.transform(this.criteria.dateEmissionTo , this.dateFormat) : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
        }];
      }
}
