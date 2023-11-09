import {Component, OnInit} from '@angular/core';
import {ModePaiementAdminService} from 'src/app/controller/service/admin/commun/ModePaiementAdmin.service';
import {ModePaiementDto} from 'src/app/controller/model/commun/ModePaiement.model';
import {ModePaiementCriteria} from 'src/app/controller/criteria/commun/ModePaiementCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-mode-paiement-list-admin',
  templateUrl: './mode-paiement-list-admin.component.html'
})
export class ModePaiementListAdminComponent extends AbstractListController<ModePaiementDto, ModePaiementCriteria, ModePaiementAdminService>  implements OnInit {

    fileName = 'ModePaiement';



    constructor( private modePaiementService: ModePaiementAdminService  ) {
        super(modePaiementService);
        this.pdfName = 'ModePaiement.pdf';
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
        ];
    }





   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Code': e.code ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        }];
      }
}
