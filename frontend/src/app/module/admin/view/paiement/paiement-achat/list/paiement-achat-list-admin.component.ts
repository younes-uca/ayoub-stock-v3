import {Component, OnInit} from '@angular/core';
import {PaiementAchatAdminService} from 'src/app/controller/service/admin/paiement/PaiementAchatAdmin.service';
import {PaiementAchatDto} from 'src/app/controller/model/paiement/PaiementAchat.model';
import {PaiementAchatCriteria} from 'src/app/controller/criteria/paiement/PaiementAchatCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {ModePaiementDto} from 'src/app/controller/model/commun/ModePaiement.model';
import {ModePaiementAdminService} from 'src/app/controller/service/admin/commun/ModePaiementAdmin.service';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';


@Component({
  selector: 'app-paiement-achat-list-admin',
  templateUrl: './paiement-achat-list-admin.component.html'
})
export class PaiementAchatListAdminComponent extends AbstractListController<PaiementAchatDto, PaiementAchatCriteria, PaiementAchatAdminService>  implements OnInit {

    fileName = 'PaiementAchat';

    achats: Array<AchatDto>;
    modePaiements: Array<ModePaiementDto>;


    constructor( private paiementAchatService: PaiementAchatAdminService  , private modePaiementService: ModePaiementAdminService, private achatService: AchatAdminService) {
        super(paiementAchatService);
        this.pdfName = 'PaiementAchat.pdf';
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadAchat();
        this.loadModePaiement();
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'datePaiement', header: 'Date paiement'},
            {field: 'montant', header: 'Montant'},
            {field: 'achat?.id', header: 'Achat'},
            {field: 'modePaiement?.libelle', header: 'Mode paiement'},
        ];
    }


    public async loadAchat(){
       this.achatService.findAll().subscribe(achats => this.achats = achats, error => console.log(error))
    }
    public async loadModePaiement(){
       this.modePaiementService.findAllOptimized().subscribe(modePaiements => this.modePaiements = modePaiements, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Date paiement': this.datePipe.transform(e.datePaiement , 'dd/MM/yyyy hh:mm'),
                 'Montant': e.montant ,
                'Achat': e.achat?.id ,
                'Mode paiement': e.modePaiement?.libelle ,
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Date paiement Min': this.criteria.datePaiementFrom ? this.datePipe.transform(this.criteria.datePaiementFrom , this.dateFormat) : environment.emptyForExport ,
            'Date paiement Max': this.criteria.datePaiementTo ? this.datePipe.transform(this.criteria.datePaiementTo , this.dateFormat) : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
        //'Achat': this.criteria.achat?.id ? this.criteria.achat?.id : environment.emptyForExport ,
        //'Mode paiement': this.criteria.modePaiement?.libelle ? this.criteria.modePaiement?.libelle : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        }];
      }
}
