import {Component, OnInit} from '@angular/core';
import {TransactionAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TransactionAdmin.service';
import {TransactionDto} from 'src/app/controller/model/gestionchequeffet/Transaction.model';
import {TransactionCriteria} from 'src/app/controller/criteria/gestionchequeffet/TransactionCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {TypeTransactionDto} from 'src/app/controller/model/gestionchequeffet/TypeTransaction.model';
import {TypeTransactionAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TypeTransactionAdmin.service';
import {CompteDto} from 'src/app/controller/model/gestionchequeffet/Compte.model';
import {CompteAdminService} from 'src/app/controller/service/admin/gestionchequeffet/CompteAdmin.service';
import {InstrumentDto} from 'src/app/controller/model/chequeffet/Instrument.model';
import {InstrumentAdminService} from 'src/app/controller/service/admin/chequeffet/InstrumentAdmin.service';


@Component({
  selector: 'app-transaction-list-admin',
  templateUrl: './transaction-list-admin.component.html'
})
export class TransactionListAdminComponent extends AbstractListController<TransactionDto, TransactionCriteria, TransactionAdminService>  implements OnInit {

    fileName = 'Transaction';

    typeTransactions: Array<TypeTransactionDto>;
    instruments: Array<InstrumentDto>;
    comptes: Array<CompteDto>;


    constructor( private transactionService: TransactionAdminService  , private typeTransactionService: TypeTransactionAdminService, private compteService: CompteAdminService, private instrumentService: InstrumentAdminService) {
        super(transactionService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadTypeTransaction();
        this.loadInstrument();
        this.loadCompte();
    }


    public initCol() {
        this.cols = [
            {field: 'dateTransaction', header: 'Date transaction'},
            {field: 'typeTransaction?.libelle', header: 'Type transaction'},
            {field: 'instrument?.id', header: 'Instrument'},
            {field: 'compte?.numeroCompte', header: 'Compte'},
            {field: 'dateEncaissement', header: 'Date encaissement'},
            {field: 'pathCheque', header: 'Path cheque'},
        ];
    }


    public async loadTypeTransaction(){
       this.typeTransactionService.findAllOptimized().subscribe(typeTransactions => this.typeTransactions = typeTransactions, error => console.log(error))
    }
    public async loadInstrument(){
       this.instrumentService.findAll().subscribe(instruments => this.instruments = instruments, error => console.log(error))
    }
    public async loadCompte(){
       this.compteService.findAllOptimized().subscribe(comptes => this.comptes = comptes, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Date transaction': this.datePipe.transform(e.dateTransaction , 'dd/MM/yyyy hh:mm'),
                'Type transaction': e.typeTransaction?.libelle ,
                'Instrument': e.instrument?.id ,
                'Compte': e.compte?.numeroCompte ,
                'Date encaissement': this.datePipe.transform(e.dateEncaissement , 'dd/MM/yyyy hh:mm'),
                 'Path cheque': e.pathCheque ,
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
            'Date transaction Min': this.criteria.dateTransactionFrom ? this.datePipe.transform(this.criteria.dateTransactionFrom , this.dateFormat) : environment.emptyForExport ,
            'Date transaction Max': this.criteria.dateTransactionTo ? this.datePipe.transform(this.criteria.dateTransactionTo , this.dateFormat) : environment.emptyForExport ,
        //'Type transaction': this.criteria.typeTransaction?.libelle ? this.criteria.typeTransaction?.libelle : environment.emptyForExport ,
        //'Instrument': this.criteria.instrument?.id ? this.criteria.instrument?.id : environment.emptyForExport ,
        //'Compte': this.criteria.compte?.numeroCompte ? this.criteria.compte?.numeroCompte : environment.emptyForExport ,
            'Date encaissement Min': this.criteria.dateEncaissementFrom ? this.datePipe.transform(this.criteria.dateEncaissementFrom , this.dateFormat) : environment.emptyForExport ,
            'Date encaissement Max': this.criteria.dateEncaissementTo ? this.datePipe.transform(this.criteria.dateEncaissementTo , this.dateFormat) : environment.emptyForExport ,
            'Path cheque': this.criteria.pathCheque ? this.criteria.pathCheque : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        }];
      }
}
