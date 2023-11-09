import {Component, OnInit} from '@angular/core';
import {ProprietaireAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ProprietaireAdmin.service';
import {ProprietaireDto} from 'src/app/controller/model/gestionchequeffet/Proprietaire.model';
import {ProprietaireCriteria} from 'src/app/controller/criteria/gestionchequeffet/ProprietaireCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-proprietaire-list-admin',
  templateUrl: './proprietaire-list-admin.component.html'
})
export class ProprietaireListAdminComponent extends AbstractListController<ProprietaireDto, ProprietaireCriteria, ProprietaireAdminService>  implements OnInit {

    fileName = 'Proprietaire';



    constructor( private proprietaireService: ProprietaireAdminService  ) {
        super(proprietaireService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
    }


    public initCol() {
        this.cols = [
            {field: 'nom', header: 'Nom'},
            {field: 'code', header: 'Code'},
        ];
    }





   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Nom': e.nom ,
                 'Code': e.code ,
            }
        });

        this.criteriaData = [{
            'Nom': this.criteria.nom ? this.criteria.nom : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        }];
      }
}
