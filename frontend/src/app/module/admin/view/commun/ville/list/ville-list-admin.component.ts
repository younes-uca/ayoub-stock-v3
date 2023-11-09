import {Component, OnInit} from '@angular/core';
import {VilleAdminService} from 'src/app/controller/service/admin/commun/VilleAdmin.service';
import {VilleDto} from 'src/app/controller/model/commun/Ville.model';
import {VilleCriteria} from 'src/app/controller/criteria/commun/VilleCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-ville-list-admin',
  templateUrl: './ville-list-admin.component.html'
})
export class VilleListAdminComponent extends AbstractListController<VilleDto, VilleCriteria, VilleAdminService>  implements OnInit {

    fileName = 'Ville';



    constructor( private villeService: VilleAdminService  ) {
        super(villeService);
        this.pdfName = 'Ville.pdf';
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
        ];
    }





   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        }];
      }
}
