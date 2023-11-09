import {Component, OnInit} from '@angular/core';
import {CollaborateurAdminService} from 'src/app/controller/service/admin/commun/CollaborateurAdmin.service';
import {CollaborateurDto} from 'src/app/controller/model/commun/Collaborateur.model';
import {CollaborateurCriteria} from 'src/app/controller/criteria/commun/CollaborateurCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-collaborateur-list-admin',
  templateUrl: './collaborateur-list-admin.component.html'
})
export class CollaborateurListAdminComponent extends AbstractListController<CollaborateurDto, CollaborateurCriteria, CollaborateurAdminService>  implements OnInit {

    fileName = 'Collaborateur';



    constructor( private collaborateurService: CollaborateurAdminService  ) {
        super(collaborateurService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
    }


    public initCol() {
        this.cols = [
            {field: 'nom', header: 'Nom'},
            {field: 'prenom', header: 'Prenom'},
        ];
    }





   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Nom': e.nom ,
                 'Prenom': e.prenom ,
            }
        });

        this.criteriaData = [{
            'Nom': this.criteria.nom ? this.criteria.nom : environment.emptyForExport ,
            'Prenom': this.criteria.prenom ? this.criteria.prenom : environment.emptyForExport ,
        }];
      }
}
