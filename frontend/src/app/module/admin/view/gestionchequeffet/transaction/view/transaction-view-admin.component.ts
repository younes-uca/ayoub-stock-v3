import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {TransactionAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TransactionAdmin.service';
import {TransactionDto} from 'src/app/controller/model/gestionchequeffet/Transaction.model';
import {TransactionCriteria} from 'src/app/controller/criteria/gestionchequeffet/TransactionCriteria.model';

import {TypeTransactionDto} from 'src/app/controller/model/gestionchequeffet/TypeTransaction.model';
import {TypeTransactionAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TypeTransactionAdmin.service';
import {CompteDto} from 'src/app/controller/model/gestionchequeffet/Compte.model';
import {CompteAdminService} from 'src/app/controller/service/admin/gestionchequeffet/CompteAdmin.service';
import {InstrumentDto} from 'src/app/controller/model/chequeffet/Instrument.model';
import {InstrumentAdminService} from 'src/app/controller/service/admin/chequeffet/InstrumentAdmin.service';
@Component({
  selector: 'app-transaction-view-admin',
  templateUrl: './transaction-view-admin.component.html'
})
export class TransactionViewAdminComponent extends AbstractViewController<TransactionDto, TransactionCriteria, TransactionAdminService> implements OnInit {


    constructor(private transactionService: TransactionAdminService, private typeTransactionService: TypeTransactionAdminService, private compteService: CompteAdminService, private instrumentService: InstrumentAdminService){
        super(transactionService);
    }

    ngOnInit(): void {
    }


    get typeTransaction(): TypeTransactionDto {
       return this.typeTransactionService.item;
    }
    set typeTransaction(value: TypeTransactionDto) {
        this.typeTransactionService.item = value;
    }
    get typeTransactions(): Array<TypeTransactionDto> {
       return this.typeTransactionService.items;
    }
    set typeTransactions(value: Array<TypeTransactionDto>) {
        this.typeTransactionService.items = value;
    }
    get compte(): CompteDto {
       return this.compteService.item;
    }
    set compte(value: CompteDto) {
        this.compteService.item = value;
    }
    get comptes(): Array<CompteDto> {
       return this.compteService.items;
    }
    set comptes(value: Array<CompteDto>) {
        this.compteService.items = value;
    }
    get instrument(): InstrumentDto {
       return this.instrumentService.item;
    }
    set instrument(value: InstrumentDto) {
        this.instrumentService.item = value;
    }
    get instruments(): Array<InstrumentDto> {
       return this.instrumentService.items;
    }
    set instruments(value: Array<InstrumentDto>) {
        this.instrumentService.items = value;
    }


}
