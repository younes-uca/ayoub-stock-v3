import {Component, OnInit} from '@angular/core';
import {AvoirAchatAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatAdmin.service';
import {AvoirAchatDto} from 'src/app/controller/model/stock/AvoirAchat.model';
import {AvoirAchatCriteria} from 'src/app/controller/criteria/stock/AvoirAchatCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {AvoirAchatItemDto} from 'src/app/controller/model/stock/AvoirAchatItem.model';
import {AvoirAchatItemAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatItemAdmin.service';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';


@Component({
  selector: 'app-avoir-achat-list-admin',
  templateUrl: './avoir-achat-list-admin.component.html'
})
export class AvoirAchatListAdminComponent extends AbstractListController<AvoirAchatDto, AvoirAchatCriteria, AvoirAchatAdminService>  implements OnInit {

    fileName = 'AvoirAchat';

    entrepriseSocietes: Array<EntrepriseSocieteDto>;
    achats: Array<AchatDto>;


    constructor( private avoirAchatService: AvoirAchatAdminService  , private depotService: DepotAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private produitService: ProduitAdminService, private avoirAchatItemService: AvoirAchatItemAdminService, private achatService: AchatAdminService) {
        super(avoirAchatService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadEntrepriseSociete();
        this.loadAchat();
    }


    public initCol() {
        this.cols = [
            {field: 'entrepriseSociete?.nom', header: 'Entreprise societe'},
            {field: 'dateAvoir', header: 'Date avoir'},
            {field: 'montant', header: 'Montant'},
            {field: 'achat?.id', header: 'Achat'},
        ];
    }


    public async loadEntrepriseSociete(){
       this.entrepriseSocieteService.findAllOptimized().subscribe(entrepriseSocietes => this.entrepriseSocietes = entrepriseSocietes, error => console.log(error))
    }
    public async loadAchat(){
       this.achatService.findAll().subscribe(achats => this.achats = achats, error => console.log(error))
    }

	public initDuplicate(res: AvoirAchatDto) {
        if (res.avoirAchatItems != null) {
             res.avoirAchatItems.forEach(d => { d.avoirAchat = null; d.id = null; });
        }
	}


   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Entreprise societe': e.entrepriseSociete?.nom ,
                'Date avoir': this.datePipe.transform(e.dateAvoir , 'dd/MM/yyyy hh:mm'),
                 'Montant': e.montant ,
                'Achat': e.achat?.id ,
            }
        });

        this.criteriaData = [{
        //'Entreprise societe': this.criteria.entrepriseSociete?.nom ? this.criteria.entrepriseSociete?.nom : environment.emptyForExport ,
            'Date avoir Min': this.criteria.dateAvoirFrom ? this.datePipe.transform(this.criteria.dateAvoirFrom , this.dateFormat) : environment.emptyForExport ,
            'Date avoir Max': this.criteria.dateAvoirTo ? this.datePipe.transform(this.criteria.dateAvoirTo , this.dateFormat) : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
        //'Achat': this.criteria.achat?.id ? this.criteria.achat?.id : environment.emptyForExport ,
        }];
      }
}
