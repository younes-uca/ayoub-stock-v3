import {Component, OnInit} from '@angular/core';
import {ClientAdminService} from 'src/app/controller/service/admin/commun/ClientAdmin.service';
import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientCriteria} from 'src/app/controller/criteria/commun/ClientCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-client-list-admin',
  templateUrl: './client-list-admin.component.html'
})
export class ClientListAdminComponent extends AbstractListController<ClientDto, ClientCriteria, ClientAdminService>  implements OnInit {

    fileName = 'Client';



    constructor( private clientService: ClientAdminService  ) {
        super(clientService);
        this.pdfName = 'Client.pdf';
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
    }


    public initCol() {
        this.cols = [
            {field: 'cin', header: 'Cin'},
            {field: 'nom', header: 'Nom'},
            {field: 'prenom', header: 'Prenom'},
            {field: 'telephone', header: 'Telephone'},
            {field: 'adresse', header: 'Adresse'},
            {field: 'creance', header: 'Creance'},
        ];
    }





   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Cin': e.cin ,
                 'Nom': e.nom ,
                 'Prenom': e.prenom ,
                 'Telephone': e.telephone ,
                 'Adresse': e.adresse ,
                 'Description': e.description ,
                 'Creance': e.creance ,
            }
        });

        this.criteriaData = [{
            'Cin': this.criteria.cin ? this.criteria.cin : environment.emptyForExport ,
            'Nom': this.criteria.nom ? this.criteria.nom : environment.emptyForExport ,
            'Prenom': this.criteria.prenom ? this.criteria.prenom : environment.emptyForExport ,
            'Telephone': this.criteria.telephone ? this.criteria.telephone : environment.emptyForExport ,
            'Adresse': this.criteria.adresse ? this.criteria.adresse : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
            'Creance Min': this.criteria.creanceMin ? this.criteria.creanceMin : environment.emptyForExport ,
            'Creance Max': this.criteria.creanceMax ? this.criteria.creanceMax : environment.emptyForExport ,
        }];
      }
}
