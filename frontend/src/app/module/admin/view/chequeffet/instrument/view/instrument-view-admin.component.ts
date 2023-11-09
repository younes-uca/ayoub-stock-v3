import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {InstrumentAdminService} from 'src/app/controller/service/admin/chequeffet/InstrumentAdmin.service';
import {InstrumentDto} from 'src/app/controller/model/chequeffet/Instrument.model';
import {InstrumentCriteria} from 'src/app/controller/criteria/chequeffet/InstrumentCriteria.model';

import {ChequeEffetDto} from 'src/app/controller/model/gestionchequeffet/ChequeEffet.model';
import {ChequeEffetAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ChequeEffetAdmin.service';
import {TypeInstrumentDto} from 'src/app/controller/model/gestionchequeffet/TypeInstrument.model';
import {TypeInstrumentAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TypeInstrumentAdmin.service';
@Component({
  selector: 'app-instrument-view-admin',
  templateUrl: './instrument-view-admin.component.html'
})
export class InstrumentViewAdminComponent extends AbstractViewController<InstrumentDto, InstrumentCriteria, InstrumentAdminService> implements OnInit {


    constructor(private instrumentService: InstrumentAdminService, private chequeEffetService: ChequeEffetAdminService, private typeInstrumentService: TypeInstrumentAdminService){
        super(instrumentService);
    }

    ngOnInit(): void {
    }


    get typeInstrument(): TypeInstrumentDto {
       return this.typeInstrumentService.item;
    }
    set typeInstrument(value: TypeInstrumentDto) {
        this.typeInstrumentService.item = value;
    }
    get typeInstruments(): Array<TypeInstrumentDto> {
       return this.typeInstrumentService.items;
    }
    set typeInstruments(value: Array<TypeInstrumentDto>) {
        this.typeInstrumentService.items = value;
    }
    get chequeEffet(): ChequeEffetDto {
       return this.chequeEffetService.item;
    }
    set chequeEffet(value: ChequeEffetDto) {
        this.chequeEffetService.item = value;
    }
    get chequeEffets(): Array<ChequeEffetDto> {
       return this.chequeEffetService.items;
    }
    set chequeEffets(value: Array<ChequeEffetDto>) {
        this.chequeEffetService.items = value;
    }


}
