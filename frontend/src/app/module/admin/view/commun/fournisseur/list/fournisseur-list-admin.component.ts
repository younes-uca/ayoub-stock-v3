import {Component, OnInit} from '@angular/core';
import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurCriteria} from 'src/app/controller/criteria/commun/FournisseurCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {VilleDto} from 'src/app/controller/model/commun/Ville.model';
import {VilleAdminService} from 'src/app/controller/service/admin/commun/VilleAdmin.service';


@Component({
  selector: 'app-fournisseur-list-admin',
  templateUrl: './fournisseur-list-admin.component.html'
})
export class FournisseurListAdminComponent extends AbstractListController<FournisseurDto, FournisseurCriteria, FournisseurAdminService>  implements OnInit {

    fileName = 'Fournisseur';

    villes: Array<VilleDto>;


    constructor( private fournisseurService: FournisseurAdminService  , private villeService: VilleAdminService) {
        super(fournisseurService);
        this.pdfName = 'Fournisseur.pdf';
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadVille();
    }


    public initCol() {
        this.cols = [
            {field: 'nom', header: 'Nom'},
            {field: 'ice', header: 'Ice'},
            {field: 'telephone', header: 'Telephone'},
            {field: 'ville?.id', header: 'Ville'},
            {field: 'creance', header: 'Creance'},
        ];
    }


    public async loadVille(){
       this.villeService.findAll().subscribe(villes => this.villes = villes, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Nom': e.nom ,
                 'Ice': e.ice ,
                 'Telephone': e.telephone ,
                 'Info bancaire': e.infoBancaire ,
                'Ville': e.ville?.id ,
                 'Adresse': e.adresse ,
                 'Creance': e.creance ,
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
            'Nom': this.criteria.nom ? this.criteria.nom : environment.emptyForExport ,
            'Ice': this.criteria.ice ? this.criteria.ice : environment.emptyForExport ,
            'Telephone': this.criteria.telephone ? this.criteria.telephone : environment.emptyForExport ,
            'Info bancaire': this.criteria.infoBancaire ? this.criteria.infoBancaire : environment.emptyForExport ,
        //'Ville': this.criteria.ville?.id ? this.criteria.ville?.id : environment.emptyForExport ,
            'Adresse': this.criteria.adresse ? this.criteria.adresse : environment.emptyForExport ,
            'Creance Min': this.criteria.creanceMin ? this.criteria.creanceMin : environment.emptyForExport ,
            'Creance Max': this.criteria.creanceMax ? this.criteria.creanceMax : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        }];
      }
}
